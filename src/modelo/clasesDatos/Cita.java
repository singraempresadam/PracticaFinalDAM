package modelo.clasesDatos;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Cita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -592042392272912028L;
	private String idUnicoCita;
	private String idUnicoPaciente;
	private String idUnicoMedico;
	private boolean confirmacion;
	private String observaciones;
	private String fechaYHora;
	
	public Cita(String idUnicoCita, String idUnicoPaciente, String idUnicoMedico, String fechaYHora) {
		super();
		this.setIdUnicoCita(idUnicoCita);
		this.setIdUnicoPaciente(idUnicoPaciente);
		this.setIdUnicoMedico(idUnicoMedico);
		this.setObservaciones(" ");
		this.setFechaYHora(fechaYHora);
		this.setConfirmacion(false);
		
	}
	public String getIdUnicoCita() {
		return idUnicoCita;
	}
	public String getIdUnicoPaciente() {
		return idUnicoPaciente;
	}
	public String getIdUnicoMedico() {
		return idUnicoMedico;
	}
	public String getFechaYHora() {
		return fechaYHora;
	}
	public boolean isConfirmacion() {
		return confirmacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	
	
	public void setIdUnicoCita(String idUnicoCita) {
		assert idUnicoCita!=null&&validaIdUnico(idUnicoCita).isResultado();
		this.idUnicoCita = idUnicoCita;
	}
	public void setIdUnicoPaciente(String idUnicoPaciente) {
		assert idUnicoPaciente!=null&&validaIdUnico(idUnicoPaciente).isResultado();
		this.idUnicoPaciente = idUnicoPaciente;
	}
	public void setIdUnicoMedico(String idUnicoMedico) {
		assert idUnicoMedico!=null&&validaIdUnico(idUnicoMedico).isResultado();
		this.idUnicoMedico = idUnicoMedico;
	}
	public void setFechaYHora(String fechaYHora) {
		//assert fechaYHora!=null&&validaFecha(fechaYHora).isResultado();
		this.fechaYHora = fechaYHora;
	}
	
	public void setConfirmacion(boolean confirmacion) {
		this.confirmacion = confirmacion;
	}
	public void setObservaciones(String observaciones) {
		assert observaciones!=null&&validaObservaciones(observaciones).isResultado();
		this.observaciones = observaciones;
	}
	
	public static Respuesta validaIdUnico(String idUnico) {
		return new Respuesta(Pattern.matches("\\d{9}", idUnico), "El idUnico no cumple con los requisitos");
	}
	public static Respuesta validaFecha(String fecha) {
		return new Respuesta(Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", fecha), "El fecha no cumple con los requisitos");
	}
	public static Respuesta validaObservaciones(String observaciones) {
		return new Respuesta(Pattern.matches("[\\s\\S]{0,200}", observaciones), "Las observaciones no cumple con los requisitos");
	}
}
