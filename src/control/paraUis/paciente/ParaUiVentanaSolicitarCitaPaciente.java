package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiVentanaError;
import vista.paciente.VentanaSolicitarCitaPaciente;

public class ParaUiVentanaSolicitarCitaPaciente extends VentanaSolicitarCitaPaciente{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1285684464416843466L;
	String idPaciente;
	Controller control = new Controller();
	public JButton botones[][]=new JButton[4][5];
	private JList<String> medicosAtencionPrimaria;

	private JScrollPane scrollListaMedicoAtencionPrimaria;
	public ParaUiVentanaSolicitarCitaPaciente(String idPaciente) {
		super();
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
		boolean horario[][]=control.solicitarHorario(obtenerIdSeleccionado());
		this.getPanelHorario().removeAll();
		int anchuraBoton=100,alturaBoton= 50;
		int x=0,y=0;
		for (int i = 0; i < horario.length; i++) {
			for (int j = 0; j < horario[i].length; j++) {
				this.botones[i][j] = new JButton();
				this.botones[i][j].setName(String.valueOf(i)+String.valueOf(j));
				this.botones[i][j].setBounds(x, y, anchuraBoton, alturaBoton);
				if(horario[i][j]) this.botones[i][j].setBackground(Color.green);
				else this.botones[i][j].setBackground(Color.red);
				this.getPanelHorario().add(this.botones[i][j]);
				x+=anchuraBoton;
			}
			x=0;
			y+=alturaBoton;
		}
		this.getPanelHorario().setVisible(true);
		this.actualizarPantalla();
		this.botones[1][1].setText("");
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
		getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
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
