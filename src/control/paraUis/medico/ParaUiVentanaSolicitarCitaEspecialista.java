package control.paraUis.medico;

import control.Controller;
import vista.medico.VentanaSolicitarCitaEspecialista;

public class ParaUiVentanaSolicitarCitaEspecialista extends VentanaSolicitarCitaEspecialista{
	String idMedico;
	String idPaciente;
	Controller control;
	
	public ParaUiVentanaSolicitarCitaEspecialista(Controller control, String idPaciente, String idMedico) {
		super();
		this.setControl(control);
		this.setIdMedico(idMedico);
		this.setIdPaciente(idPaciente);
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
	
	
	
	
	
}
