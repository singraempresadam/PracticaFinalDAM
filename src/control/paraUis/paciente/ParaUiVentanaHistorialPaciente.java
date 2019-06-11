package control.paraUis.paciente;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import vista.paciente.VentanaHistorialPaciente;

public class ParaUiVentanaHistorialPaciente extends VentanaHistorialPaciente{
	private JScrollPane scrollListaTratamientos;
	private JScrollPane scrollListaCitasPendientes;
	private JScrollPane scrollListaCitasRealizadas;
	String idPaciente;
	Controller control;
	String nombrePaciente;
	private JList<String> tratamientos;
	private JList<String> citasPendientes;
	private JList<String> citasRealizadas;
	public ParaUiVentanaHistorialPaciente(String idPaciente, Controller control) {
		super();
		this.setIdPaciente(idPaciente);
		this.setControl(control);
		this.setNombrePaciente(this.getControl().obtenerNombrePaciente(this.getIdPaciente()));
		this.getTxtPaciente().setText(this.getNombrePaciente());
		
		this.crearListaCitasPendientes();
		this.crearListaCitasRealizadas();
		this.crearListaTratamientos();
	}
	private void crearListaTratamientos() {
		
		this.setTratamientos(new JList<String>(this.getControl().obtenerTodosLosMedicos()));
		this.getTratamientos().setVisible(true);
		this.setScrollListaTratamientos(new JScrollPane(this.getTratamientos()));
		this.getScrollListaTratamientos().setBounds(79, 108, 345, 213);
		this.getScrollListaTratamientos().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelTratamientos().add(this.getScrollListaTratamientos());
		
	}
	private void crearListaCitasRealizadas() {
		// TODO Auto-generated method stub
		
	}
	private void crearListaCitasPendientes() {
		// TODO Auto-generated method stub
		
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
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public JScrollPane getScrollListaTratamientos() {
		return scrollListaTratamientos;
	}
	public void setScrollListaTratamientos(JScrollPane scrollListaTratamientos) {
		this.scrollListaTratamientos = scrollListaTratamientos;
	}
	public JScrollPane getScrollListaCitasPendientes() {
		return scrollListaCitasPendientes;
	}
	public void setScrollListaCitasPendientes(JScrollPane scrollListaCitasPendientes) {
		this.scrollListaCitasPendientes = scrollListaCitasPendientes;
	}
	public JScrollPane getScrollListaCitasRealizadas() {
		return scrollListaCitasRealizadas;
	}
	public void setScrollListaCitasRealizadas(JScrollPane scrollListaCitasRealizadas) {
		this.scrollListaCitasRealizadas = scrollListaCitasRealizadas;
	}
	public JList<String> getTratamientos() {
		return tratamientos;
	}
	public void setTratamientos(JList<String> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public JList<String> getCitasPendientes() {
		return citasPendientes;
	}
	public void setCitasPendientes(JList<String> citasPendientes) {
		this.citasPendientes = citasPendientes;
	}
	public JList<String> getCitasRealizadas() {
		return citasRealizadas;
	}
	public void setCitasRealizadas(JList<String> citasRealizadas) {
		this.citasRealizadas = citasRealizadas;
	}
	
	
}
