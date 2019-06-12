package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiVentanaError;
import modelo.clasesDatos.Cita;
import modelo.enumeraciones.Days;
import vista.medico.VentanaSolicitarCitaEspecialista;

public class ParaUiVentanaSolicitarCitaEspecialista extends VentanaSolicitarCitaEspecialista{
	String idMedico;
	String idPaciente;
	Controller control;
	public JButton botones[][]=new JButton[2][5];
	private JList<String> medicosEspecialistas;
	
	private JScrollPane scrollListaMedicoEspecialistas;
	public ParaUiVentanaSolicitarCitaEspecialista(Controller control, String idPaciente) {
		super();
		this.setControl(control);
		this.setIdPaciente(idPaciente);
		this.getTxtPaciente().setText(this.getIdPaciente());
		this.crearListaTodosLosMedicosEspecialistas();
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
	private void buscarMedico() {
		// TODO Auto-generated method stub
		
	}
	private String obtenerIdSeleccionado() {
		try {
			return this.getMedicosEspecialistas().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private String obtenerId(String medico) {
		String [] retornos = medico.split("-");
		return retornos[2];
	}
	private void solicitarHorario() {
		String medico=this.obtenerIdSeleccionado();
		boolean horario[][]=this.getControl().solicitarHorario(medico, 2);
		String idMedico=obtenerId(medico);
		LocalTime[] inicioYFin = this.getControl().obtenerInicioYFin(medico);
		String[] horas = new String [2];
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
	private void diasNoDisponiblesParaFecha(int plus) {
		for (int i = 0; i < plus; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[j][i].setBackground(Color.gray);
				botones[j][i].setEnabled(false);
			}
		}
	}
	private void crearListenerDos() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						String fecha = ((JButton) arg0.getSource()).getName();
						if(((JButton) arg0.getSource()).isEnabled())
						getControl().solicitarCitaPaciente(idPaciente, obtenerIdSeleccionado(), fecha);
						dispose();
					}
				});
			}
		}
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
	public void actualizarPantalla() {
        JPanel temp = (JPanel) this.getContentPane();
        SwingUtilities.updateComponentTreeUI(temp);
    }
	private void asignarHoras(LocalTime[] inicioYFin, String[] horas) {
		for (int i = 0; i < horas.length; i++) 
			horas[i]=inicioYFin[0].plusHours(i).toString();
		
		this.getLblHoraInicio().setText(horas[0]);
		this.getLblHoraDos().setText(horas[1]);
	}
	private void crearListaTodosLosMedicosEspecialistas() {
		String[] filtrar = this.getControl().filtrarSin("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrar("Activo",filtrar);
		this.setMedicosEspecialistas(new JList<String>(filtrarSin));
		this.getMedicosEspecialistas().setVisible(true);
		this.setScrollListaMedicoEspecialistas(new JScrollPane(this.getMedicosEspecialistas()));
		this.getScrollListaMedicoEspecialistas().setBounds(120, 108, 345, 120);
		this.getScrollListaMedicoEspecialistas().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelSolicitarCitaEspecialista().add(this.getScrollListaMedicoEspecialistas());
	}
	public String getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public JButton[][] getBotones() {
		return botones;
	}
	public void setBotones(JButton[][] botones) {
		this.botones = botones;
	}
	public JList<String> getMedicosEspecialistas() {
		return medicosEspecialistas;
	}
	public void setMedicosEspecialistas(JList<String> medicosEspecialistas) {
		this.medicosEspecialistas = medicosEspecialistas;
	}
	public JScrollPane getScrollListaMedicoEspecialistas() {
		return scrollListaMedicoEspecialistas;
	}
	public void setScrollListaMedicoEspecialistas(JScrollPane scrollListaMedicoEspecialistas) {
		this.scrollListaMedicoEspecialistas = scrollListaMedicoEspecialistas;
	}
	
	
	
	
	
}
