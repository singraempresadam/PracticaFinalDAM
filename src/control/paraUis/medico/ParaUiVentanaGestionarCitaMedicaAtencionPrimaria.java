package control.paraUis.medico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import vista.medico.VentanaGestionarCitaMedicaAtencionPrimaria;

public class ParaUiVentanaGestionarCitaMedicaAtencionPrimaria extends VentanaGestionarCitaMedicaAtencionPrimaria{
	Controller control;
	String idCita;
	String idMedico;
	String idPaciente;
	String nombreMedico;
	String nombrePaciente;
	public ParaUiVentanaGestionarCitaMedicaAtencionPrimaria(Controller control, String idCita, String idMedico) {
		super();
		this.setControl(control);
		this.setIdCita(idCita);
		this.setIdMedico(idMedico);
		
		this.agregarListener();
		//this.setIdPaciente(this.getControl().obtenerPacienteDeCita(this.getIdCita(), this.getIdMedico()));
		//this.setNombrePaciente(this.getControl().obtenerNombrePaciente(this.getIdPaciente()));
		//this.setNombreMedico(this.getControl().obtenerNombreMedico(this.getIdMedico()));
		
	}
	private void agregarListener() {
		this.getBtnGestionar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		this.getBtnSolicitarEspecialista().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ParaUiVentanaSolicitarCitaEspecialista paraUiVentanaSolicitarCitaEspecialista = new ParaUiVentanaSolicitarCitaEspecialista(control, idPaciente, idMedico);
				dispose();
			}
		});
		
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public String getIdCita() {
		return idCita;
	}
	public void setIdCita(String idCita) {
		this.idCita = idCita;
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
	public String getNombreMedico() {
		return nombreMedico;
	}
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	
	
}
