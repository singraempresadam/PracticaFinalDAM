package control.paraUis.paciente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
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
		
		this.setTratamientos(new JList<String>(this.getControl().obtenerTratamiento(this.getIdPaciente())));
		this.getTratamientos().setVisible(true);
		this.setScrollListaTratamientos(new JScrollPane(this.getTratamientos()));
		this.getScrollListaTratamientos().setBounds(31, 180, 307, 202);
		this.getScrollListaTratamientos().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialPaciente().add(this.getScrollListaTratamientos());
		
	}
	private void crearListaCitasPendientes() {
		this.setCitasPendientes((new JList<String>(this.getControl().obtenerCitasPendientes(this.getIdPaciente()))));
		this.getCitasPendientes().setVisible(true);
		this.setScrollListaCitasPendientes(new JScrollPane(this.getCitasPendientes()));
		this.getScrollListaCitasPendientes().setBounds(400, 68, 253, 158);
		this.getScrollListaCitasPendientes().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialPaciente().add(this.getScrollListaCitasPendientes());
		
	}
	private void crearListaCitasRealizadas() {
		this.setCitasRealizadas((new JList<String>(this.getControl().obtenerCitasRealizadas(this.getIdPaciente()))));
		this.getCitasRealizadas().setVisible(true);
		this.setScrollListaCitasRealizadas(new JScrollPane(this.getCitasRealizadas()));
		this.getScrollListaCitasRealizadas().setBounds(400, 288, 253, 164);
		this.getScrollListaCitasRealizadas().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialPaciente().add(this.getScrollListaCitasRealizadas());
		
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
