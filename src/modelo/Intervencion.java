package modelo;

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
	public void setIdUnicoCirujano(String idUnicoCirujano) {
		this.idUnicoCirujano = idUnicoCirujano;
	}
	public String getTipoDeIntervencion() {
		return tipoDeIntervencion;
	}
	public void setTipoDeIntervencion(String tipoDeIntervencion) {
		this.tipoDeIntervencion = tipoDeIntervencion;
	}
}
