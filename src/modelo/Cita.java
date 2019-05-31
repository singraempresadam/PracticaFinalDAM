package modelo;

public class Cita {
	private String idUnicoCita;
	private String idUnicoPaciente;
	private String idUnicoMedico;
	private String fecha;
	private boolean confirmacion;
	private String observaciones;
	private String hora;
	
	public Cita(String idUnicoCita, String idUnicoPaciente, String idUnicoMedico, String fecha, String hora) {
		super();
		this.setIdUnicoCita(idUnicoCita);
		this.setIdUnicoPaciente(idUnicoPaciente);
		this.setIdUnicoMedico(idUnicoMedico);
		this.setFecha(fecha);
		this.setObservaciones(" ");
		this.setConfirmacion(false);
		this.setHora(hora);
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora=hora;
	}
	public String getIdUnicoCita() {
		return idUnicoCita;
	}
	public void setIdUnicoCita(String idUnicoCita) {
		this.idUnicoCita = idUnicoCita;
	}
	public String getIdUnicoPaciente() {
		return idUnicoPaciente;
	}
	public void setIdUnicoPaciente(String idUnicoPaciente) {
		this.idUnicoPaciente = idUnicoPaciente;
	}
	public String getIdUnicoMedico() {
		return idUnicoMedico;
	}
	public void setIdUnicoMedico(String idUnicoMedico) {
		this.idUnicoMedico = idUnicoMedico;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isConfirmacion() {
		return confirmacion;
	}
	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
