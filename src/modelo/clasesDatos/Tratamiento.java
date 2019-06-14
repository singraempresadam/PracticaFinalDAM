package modelo.clasesDatos;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Tratamiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2700823679366094855L;
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
		assert dosis!=null && validaDosis(dosis).isResultado();
		this.dosis = dosis;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		assert fechaInicio!=null && validaFecha(fechaInicio).isResultado();
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		assert fechaFin!=null && validaFecha(fechaFin).isResultado();
		this.fechaFin = fechaFin;
	}
	
	
	public static Respuesta validaDosis(String dosis) {
		return new Respuesta(Pattern.matches("[1-9][ ][m][g]|[1-9][ ][g]|[1-9][0-9][ ][m][g]|[1-9][0-9][ ][g]|[1-9][0-9][0-9][ ][m][g]|[1-9][0-9][0-9][ ][g]|[1][0][0][0][ ][m][g]|[1][0][0][0][ ][g]", dosis), "El dosis no cumple con los requisitos.");
	}
	public static Respuesta validaFecha(String fecha) {
		return new Respuesta(Pattern.matches("([0][1-9]|[12][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/([1][9][0-9][0-9]|[2][0][0-9][0-9]|[2][1][0][0])", fecha), "La fecha no cumple con los requisitos.");
	}
	
}
