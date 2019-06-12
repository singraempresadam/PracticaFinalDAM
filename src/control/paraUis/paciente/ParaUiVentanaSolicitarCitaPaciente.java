package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiVentanaError;
import modelo.GestorModelo;
import modelo.clasesDatos.Cita;
import modelo.enumeraciones.Days;
import vista.paciente.VentanaSolicitarCitaPaciente;

public class ParaUiVentanaSolicitarCitaPaciente extends VentanaSolicitarCitaPaciente{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1285684464416843466L;
	String idPaciente;
	Controller control;
	public JButton botones[][]=new JButton[4][5];
	private JList<String> medicosAtencionPrimaria;

	private JScrollPane scrollListaMedicoAtencionPrimaria;
	public ParaUiVentanaSolicitarCitaPaciente(Controller control,String idPaciente) {
		super();
		this.setControl(control);
		this.setIdPaciente(idPaciente);
		this.getTxtPaciente().setText(idPaciente);
		this.crearListaTodosLosMedicosAtencionPrimaria();
		this.crearListeners();
	}
	private void crearListeners() {
		this.getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarMedico();
			}
		});
		this.getBtnVerHorario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				solicitarHorario();
			}
		});
		
	}
	private void solicitarHorario() {
		String medico=this.obtenerIdSeleccionado();
		boolean horario[][]=this.getControl().solicitarHorario(medico, 4);
		String idMedico=obtenerId(medico);
		LocalTime[] inicioYFin = this.getControl().obtenerInicioYFin(medico);
		String[] horas = new String [4];
		String diaActual = this.getControl().getDia();
		int plus=0;
		LocalDate firstMonday=null;
		
		this.asignarHoras(inicioYFin, horas);
		this.crearBotoneraHorario(horario);
		this.getPanelHorario().setVisible(true);
		this.actualizarPantalla();
		
		plus = this.asignarPlusAlDiaActual(diaActual);
		firstMonday=this.getControl().obtenerPrimerLunesSemanal(-plus);
		this.asignarNombresABotones(horas, firstMonday);
		this.asignarColor(horario,idMedico);
		this.diasNoDisponiblesParaFecha(plus);
		this.crearListenerDos();
	}
	private String obtenerId(String medico) {
		String [] retornos = medico.split("-");
		return retornos[2];
	}
	private void crearBotoneraHorario(boolean[][] horario) {
		this.getPanelHorario().removeAll();
		int anchuraBoton=100,alturaBoton= 50;
		int x=0,y=0;
		for (int i = 0; i < horario.length; i++) {
			for (int j = 0; j < horario[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setBounds(x, y, anchuraBoton, alturaBoton);
				this.getPanelHorario().add(this.botones[i][j]);
				x+=anchuraBoton;
			}
			x=0;
			y+=alturaBoton;
		}
	}
	private void asignarHoras(LocalTime[] inicioYFin, String[] horas) {
		for (int i = 0; i < horas.length; i++) 
			horas[i]=inicioYFin[0].plusHours(i).toString();
		
		this.getLblHoraInicio().setText(horas[0]);
		this.getLblHoraDos().setText(horas[1]);
		this.getLblHoraTres().setText(horas[2]);
		this.getLblHoraFinal().setText(horas[3]);
	}
	private void crearListenerDos() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						String fecha = ((JButton) arg0.getSource()).getName();
						if(((JButton) arg0.getSource()).isEnabled())
						getControl().getMiGestor().solicitarCitaPaciente(idPaciente, obtenerIdSeleccionado(), fecha);
						dispose();
					}
				});
			}
		}
	}
	private int asignarPlusAlDiaActual(String diaActual) {
		int plus=0;
		for (Days dia : Days.values()) {
			if(diaActual == dia.getNombreIngles())
			{
				plus=dia.getPlusDays();
			}
		}
		return plus;
	}
	private void diasNoDisponiblesParaFecha(int plus) {
		for (int i = 0; i < plus; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[j][i].setBackground(Color.gray);
				botones[j][i].setEnabled(false);
			}
		}
	}
	private void asignarNombresABotones(String[] horas, LocalDate firstMonday) {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].setName(firstMonday.plusDays(j).toString()+ " "
						+horas[i]);
			}
		}
	}
	
	private void asignarColor(boolean[][] horario, String idMedico) {
		
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				if(horario[i][j]) this.botones[i][j].setBackground(Color.green);
				else {
					this.botones[i][j].setBackground(Color.red);
					this.botones[i][j].setEnabled(false);
				}
				for(Map.Entry<String, Cita> entry : this.getControl().getMiGestor().getMedicosActivo().get(idMedico).getCitas().entrySet()){
					if(entry.getValue().getFechaYHora().contains(this.botones[i][j].getName())) {
						this.botones[i][j].setBackground(Color.red);
						this.botones[i][j].setEnabled(false);
					}
				}
			}
		}
		
	}
	private String obtenerIdSeleccionado() {
		try {
			return this.getMedicosAtencionPrimaria().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private void buscarMedico() {
		getPanelSolicitarCitaPaciente().setVisible(false);
		getPanelSolicitarCitaPaciente().remove(getScrollListaMedicoAtencionPrimaria());
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrar("Activo",filtrar);
		setMedicosAtencionPrimaria(new JList<String>(getControl().filtrar(getTxtMedicoAP().getText(), filtrarSin)));
		setScrollListaMedicoAtencionPrimaria(new JScrollPane(getMedicosAtencionPrimaria()));
		getScrollListaMedicoAtencionPrimaria().setBounds(120, 108, 345, 120);
		getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelSolicitarCitaPaciente().add(getScrollListaMedicoAtencionPrimaria());
		getPanelSolicitarCitaPaciente().setVisible(true);
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	private void crearListaTodosLosMedicosAtencionPrimaria() {
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrar("Activo",filtrar);
		this.setMedicosAtencionPrimaria(new JList<String>(filtrarSin));
		this.getMedicosAtencionPrimaria().setVisible(true);
		this.setScrollListaMedicoAtencionPrimaria(new JScrollPane(this.getMedicosAtencionPrimaria()));
		this.getScrollListaMedicoAtencionPrimaria().setBounds(120, 108, 345, 120);
		this.getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelSolicitarCitaPaciente().add(this.getScrollListaMedicoAtencionPrimaria());
	}
	public JList<String> getMedicosAtencionPrimaria() {
		return medicosAtencionPrimaria;
	}
	public void setMedicosAtencionPrimaria(JList<String> medicosAtencionPrimaria) {
		this.medicosAtencionPrimaria = medicosAtencionPrimaria;
	}
	public JScrollPane getScrollListaMedicoAtencionPrimaria() {
		return scrollListaMedicoAtencionPrimaria;
	}
	public void setScrollListaMedicoAtencionPrimaria(JScrollPane scrollListaMedicoAtencionPrimaria) {
		this.scrollListaMedicoAtencionPrimaria = scrollListaMedicoAtencionPrimaria;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	
	
}
