package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiVentanaError;
import modelo.GestorModelo;
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
		String medico=obtenerIdSeleccionado();
		boolean horario[][]=control.solicitarHorario(medico);
		LocalTime[] inicioYFin = this.getControl().obtenerInicioYFin(medico);
		String[] horas = new String [4];
		for (int i = 0; i < horas.length; i++) {
			horas[i]=inicioYFin[0].plusHours(i).toString();
		}
		this.getLblHoraInicio().setText(horas[0]);
		this.getLblHoraDos().setText(horas[1]);
		this.getLblHoraTres().setText(horas[2]);
		this.getLblHoraFinal().setText(horas[3]);
		
		String diaActual = this.getControl().getDia();
		
		this.getPanelHorario().removeAll();
		int anchuraBoton=100,alturaBoton= 50;
		int x=0,y=0;
		for (int i = 0; i < horario.length; i++) {
			for (int j = 0; j < horario[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setBounds(x, y, anchuraBoton, alturaBoton);
				asignarColor(horario, i, j);
				this.getPanelHorario().add(this.botones[i][j]);
				x+=anchuraBoton;
			}
			x=0;
			y+=alturaBoton;
		}
		tremensidisimoIF(diaActual,horas);
		System.out.println(diaActual);
		this.getPanelHorario().setVisible(true);
		this.actualizarPantalla();
		this.botones[1][1].setText("");
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				System.out.print(botones[i][j].getName());
			}
			System.out.println();
		}
		this.crearListenerDos();
	}
	private void crearListenerDos() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						String fecha = ((JButton) arg0.getSource()).getName();
						getControl().getMiGestor().solicitarCitaPaciente(idPaciente, obtenerIdSeleccionado(), fecha);
					}
				});
			}
		}
	}
	private void tremensidisimoIF(String diaActual,String[] horas)
	{
		LocalDate firstMonday=null;
		if(diaActual=="MONDAY")
		{
			firstMonday=getControl().getMiGestor().getDiaSistema();
		}
		if(diaActual=="TUESDAY")
		{
			for (int k = 0; k < botones.length; k++) {
				botones[k][0].setBackground(Color.gray);
				botones[k][0].setEnabled(false);
			}
			firstMonday=getControl().getMiGestor().getDiaSistema().plusDays(-1);
		}
		if(diaActual=="WEDNESDAY") {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < botones.length; j++) {
					botones[j][i].setBackground(Color.gray);
					botones[j][i].setEnabled(false);
				}
			}
			firstMonday=getControl().getMiGestor().getDiaSistema().plusDays(-2);
		}
		if(diaActual=="THURSDAY") {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < botones.length; j++) {
					botones[j][i].setBackground(Color.gray);
					botones[j][i].setEnabled(false);
				}
			}
			firstMonday=getControl().getMiGestor().getDiaSistema().plusDays(-3);
		}
		if(diaActual=="FRIDAY") {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < botones.length; j++) {
					botones[j][i].setBackground(Color.gray);
					botones[j][i].setEnabled(false);
				}
			}
			firstMonday=getControl().getMiGestor().getDiaSistema().plusDays(-4);
		}
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].setName(firstMonday.plusDays(j).toString()+ " "
						+horas[i]);
			}
		}
		
	}
	private void asignarColor(boolean[][] horario, int i, int j) {
		if(horario[i][j]) this.botones[i][j].setBackground(Color.green);
		else {
			this.botones[i][j].setBackground(Color.red);
			this.botones[i][j].setEnabled(false);
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
