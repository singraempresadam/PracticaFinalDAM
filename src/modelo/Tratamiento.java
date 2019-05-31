package modelo;

public class Tratamiento {

	private String idUnicoPaciente;
	private String medicamento;
	private String dosis;
	private String fechaInicio;
	private String fechaFin;
	
	public Tratamiento(String idUnicoPaciente, String medicamento, String dosis, String fechaInicio, String fechaFin) {
		super();
		this.setIdUnicoPaciente(idUnicoPaciente);
		this.setMedicamento(medicamento);
		this.setDosis(dosis);
		this.setFechaInicio(fechaInicio);
		this.setFechaFin(fechaFin);
	}
	
	public String getIdUnicoPaciente() {
		return idUnicoPaciente;
	}
	public void setIdUnicoPaciente(String idUnicoPaciente) {
		this.idUnicoPaciente = idUnicoPaciente;
	}
	public String getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
