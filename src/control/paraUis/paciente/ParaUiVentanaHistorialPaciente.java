package control.paraUis.paciente;

import vista.paciente.VentanaHistorialPaciente;

public class ParaUiVentanaHistorialPaciente extends VentanaHistorialPaciente{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5999063245841468771L;
	
	String idPaciente;
	public ParaUiVentanaHistorialPaciente(String idPaciente) {
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
