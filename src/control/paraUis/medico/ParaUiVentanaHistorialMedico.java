package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import vista.medico.VentanaHistorialMedico;

public class ParaUiVentanaHistorialMedico extends VentanaHistorialMedico{
	private JScrollPane scrollListaCitasPendientes;
	private JScrollPane scrollListaCitasRealizadas;
	private String idMedico;
	private Controller control;
	private String nombreMedico;
	private JList<String> citasPendientes;
	private JList<String> citasRealizadas;
	public ParaUiVentanaHistorialMedico(String idMedico, Controller control)
	{
		super();
		this.setIdMedico(idMedico);
		this.setControl(control);
		
		this.setNombreMedico(this.getControl().obtenerNombreMedico(this.getIdMedico()));
		
		this.getTxtNombreMedico().setText(this.getNombreMedico());
		
		this.crearListaCitasPendientes();
		this.crearListaCitasRealizadas();
	}
	
	private void crearListaCitasRealizadas() {
		this.setCitasPendientes((new JList<String>(this.getControl().obtenerCitasPendientesMedico(this.getIdMedico()))));
		this.getCitasPendientes().setVisible(true);
		this.setScrollListaCitasPendientes(new JScrollPane(this.getCitasPendientes()));
		this.getScrollListaCitasPendientes().setBounds(20, 83, 260, 140);
		this.getScrollListaCitasPendientes().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialMedico().add(this.getScrollListaCitasPendientes());
		
	}

	private void crearListaCitasPendientes() {
		this.setCitasRealizadas((new JList<String>(this.getControl().obtenerCitasRealizadasMedico(this.getIdMedico()))));
		this.getCitasRealizadas().setVisible(true);
		this.setScrollListaCitasRealizadas(new JScrollPane(this.getCitasRealizadas()));
		this.getScrollListaCitasRealizadas().setBounds(20, 268, 260, 140);
		this.getScrollListaCitasRealizadas().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialMedico().add(this.getScrollListaCitasRealizadas());
		
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
	public String getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public String getNombreMedico() {
		return nombreMedico;
	}
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
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
