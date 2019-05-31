package modelo;

import java.util.regex.Pattern;

public class Intervencion extends Cita{
	String idUnicoCirujano;
	String tipoDeIntervencion;
	
	public Intervencion(String idUnicoCita, String idUnicoPaciente, String idUnicoMedico, 
						String fecha, String idUnicoCirujano, String tipoDeIntervencion, String hora) {
		super(idUnicoCita, idUnicoPaciente, idUnicoMedico, fecha, hora);
		this.setIdUnicoCirujano(idUnicoCirujano);
		this.setTipoDeIntervencion(tipoDeIntervencion);
	}

	public String getIdUnicoCirujano() {
		return idUnicoCirujano;
	}
	public String getTipoDeIntervencion() {
		return tipoDeIntervencion;
	}
	
	public void setIdUnicoCirujano(String idUnicoCirujano) {
		assert idUnicoCirujano!=null&&validaIdUnico(idUnicoCirujano).isResultado();
		this.idUnicoCirujano = idUnicoCirujano;
	}
	public void setTipoDeIntervencion(String tipoDeIntervencion) {
		assert tipoDeIntervencion!=null&&validaIntervencion(tipoDeIntervencion).isResultado();
		this.tipoDeIntervencion = tipoDeIntervencion;
	}
	
	public static Respuesta validaIdUnico(String idUnico) {
		return new Respuesta(Pattern.matches("\\d{9}", idUnico), "El idUnico no cumple con los requisitos");
	}
	public static Respuesta validaIntervencion(String tipoDeIntervencion) {
		return new Respuesta(Pattern.matches("[a-zA-Z]{15}", tipoDeIntervencion), "El idUnico no cumple con los requisitos");
	}
}
