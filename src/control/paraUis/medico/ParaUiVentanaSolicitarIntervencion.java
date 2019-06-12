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
import modelo.clasesDatos.Intervencion;
import modelo.enumeraciones.Days;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.TipoDeIntervencion;
import vista.medico.VentanaSolicitarIntervencion;

public class ParaUiVentanaSolicitarIntervencion extends VentanaSolicitarIntervencion {
	String idMedico;
	String idPaciente;
	String idCirujano;
	Controller control;
	public JButton botones[][]=new JButton[2][5];
	private JList<String> medicosCirujanos;
	
	private JScrollPane scrollListaCirujanos;
	
	public ParaUiVentanaSolicitarIntervencion(Controller control, String idPaciente, String idMedico)
	{
		super();
		this.setControl(control);
		this.setIdPaciente(idPaciente);
		this.setIdMedico(idMedico);
		this.getTxtPaciente().setText(this.getIdPaciente());
		this.crearListaTodosLosCirujanos();
		
		agregarListener();
		TipoDeIntervencion[] values = TipoDeIntervencion.values();
		for (int i = 0; i < values.length; i++) {
			this.getComboBoxIntervencion().addItem(values[i]);
		}
		
	}

	private void crearListaTodosLosCirujanos() {
		
		this.setMedicosCirujanos(new JList<String>(this.getControl().obtenerListaCirujanos()));
		this.getMedicosCirujanos().setVisible(true);
		this.setScrollListaCirujanos(new JScrollPane(this.getMedicosCirujanos()));
		this.getScrollListaCirujanos().setBounds(120, 108, 345, 120);
		this.getScrollListaCirujanos().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelSolicitarIntervencion().add(this.getScrollListaCirujanos());
		
	}

	private void agregarListener() {
		this.getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarCirujano();
			}

			
		});
		this.getBtnVerHorario().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				solicitarHorario();
			}

			
		});
		
	}
	private void buscarCirujano() {
		// TODO Auto-generated method stub
		
	}
	private String obtenerIdSeleccionado() {
		try {
			return this.getMedicosCirujanos().getSelectedValuesList().get(0);
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
		String cirujano=this.obtenerIdSeleccionado();
		boolean horario[][]=this.getControl().solicitarHorarioCirujano(cirujano, 2);
		LocalTime[] inicioYFin = this.getControl().obtenerInicioYFinCirujano(cirujano);
		String[] horas = new String [2];
		String diaActual = this.getControl().getDia();
		int plus=0;
		LocalDate firstMonday=null;
		this.crearBotoneraHorario(horario);
		this.getPanelHorario().setVisible(true);
		this.actualizarPantalla();
		
		plus = this.asignarPlusAlDiaActual(diaActual);
		firstMonday=this.getControl().obtenerPrimerLunesSemanal(-plus);

		this.asignarHoras(inicioYFin, horas);
		this.asignarNombresABotones(horas, firstMonday);
		this.asignarColor(horario);
		this.diasNoDisponiblesParaFecha(plus);
		this.crearListenerDos();
	}
	private void crearListenerDos() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				this.botones[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						String fecha = ((JButton) arg0.getSource()).getName();
						if(((JButton) arg0.getSource()).isEnabled())
						getControl().solicitarIntervencion(getIdPaciente(),getIdMedico(),obtenerId(obtenerIdSeleccionado()),(TipoDeIntervencion)getComboBoxIntervencion().getSelectedItem(), fecha);
						dispose();
					}
				});
			}
		}
	}
	private void diasNoDisponiblesParaFecha(int plus) {
		for (int i = 0; i < plus; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[j][i].setBackground(Color.gray);
				botones[j][i].setEnabled(false);
			}
		}
	}
	private void asignarHoras(LocalTime[] inicioYFin, String[] horas) {
		for (int i = 0; i < horas.length; i++) 
			horas[i]=inicioYFin[0].plusHours(i).toString();
	}
	public void actualizarPantalla() {
        JPanel temp = (JPanel) this.getContentPane();
        SwingUtilities.updateComponentTreeUI(temp);
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
	private void asignarColor(boolean[][] horario) {
		
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[i].length; j++) {
				if(horario[i][j]) this.botones[i][j].setBackground(Color.green);
				else {
					this.botones[i][j].setBackground(Color.red);
					this.botones[i][j].setEnabled(false);
				}
				for(Map.Entry<String, Intervencion> entry : this.getControl().getMiGestor().getCirujanos().get(this.obtenerId(this.obtenerIdSeleccionado())).getIntervenciones().entrySet()){
					
					if(entry.getValue().getFechaYHora().contains(this.botones[i][j].getName())) {
						this.botones[i][j].setBackground(Color.red);
						this.botones[i][j].setEnabled(false);
					}
				}
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

	public String getIdCirujano() {
		return idCirujano;
	}

	public void setIdCirujano(String idCirujano) {
		this.idCirujano = idCirujano;
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

	public JList<String> getMedicosCirujanos() {
		return medicosCirujanos;
	}

	public void setMedicosCirujanos(JList<String> medicosCirujanos) {
		this.medicosCirujanos = medicosCirujanos;
	}

	public JScrollPane getScrollListaCirujanos() {
		return scrollListaCirujanos;
	}

	public void setScrollListaCirujanos(JScrollPane scrollListaCirujanos) {
		this.scrollListaCirujanos = scrollListaCirujanos;
	}
	
}
