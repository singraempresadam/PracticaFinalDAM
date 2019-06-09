package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import vista.paciente.VentanaSolicitarCitaPaciente;

public class ParaUiVentanaSolicitarCitaPaciente extends VentanaSolicitarCitaPaciente{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1285684464416843466L;
	String idPaciente;
	Controller control = new Controller();

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
