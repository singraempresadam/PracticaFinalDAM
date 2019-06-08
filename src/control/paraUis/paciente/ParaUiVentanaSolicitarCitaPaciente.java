package control.paraUis.paciente;

import vista.paciente.VentanaSolicitarCitaPaciente;

public class ParaUiVentanaSolicitarCitaPaciente extends VentanaSolicitarCitaPaciente{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1285684464416843466L;
	String idPaciente;
	public ParaUiVentanaSolicitarCitaPaciente(String idPaciente) {
		super();
		this.setIdPaciente(idPaciente);
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	
	
}
