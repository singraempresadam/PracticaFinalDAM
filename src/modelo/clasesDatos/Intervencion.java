package modelo.clasesDatos;

import java.io.Serializable;
import java.util.regex.Pattern;

import modelo.enumeraciones.TipoDeIntervencion;

public class Intervencion extends Cita implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1069293026150365457L;
	String idUnicoCirujano;
	TipoDeIntervencion tipoDeIntervencion;
	
	public Intervencion(String idUnicoCita, String idUnicoPaciente, String idUnicoMedico, String idUnicoCirujano, TipoDeIntervencion tipoDeIntervencion, String fechaYHora) {
		super(idUnicoCita, idUnicoPaciente, idUnicoMedico, fechaYHora);
		this.setIdUnicoCirujano(idUnicoCirujano);
		this.setTipoDeIntervencion(tipoDeIntervencion);
	}

	public String getIdUnicoCirujano() {
		return idUnicoCirujano;
	}
	public TipoDeIntervencion getTipoDeIntervencion() {
		return tipoDeIntervencion;
	}
	
	public void setIdUnicoCirujano(String idUnicoCirujano) {
		assert idUnicoCirujano!=null&&validaIdUnico(idUnicoCirujano).isResultado();
		this.idUnicoCirujano = idUnicoCirujano;
	}
	public void setTipoDeIntervencion(TipoDeIntervencion tipoDeIntervencion) {
		assert tipoDeIntervencion != null;
		this.tipoDeIntervencion = tipoDeIntervencion;
	}
	
	public static Respuesta validaIdUnico(String idUnico) {
		return new Respuesta(Pattern.matches("\\d{9}", idUnico), "El idUnico no cumple con los requisitos");
	}
}
