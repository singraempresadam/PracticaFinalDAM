package modelo.clasesDatos;

import java.io.Serializable;
import java.util.HashMap;

import modelo.enumeraciones.TipoDeIntervencion;

public class Cirujano extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4405045914921004136L;
	private String numeroDeOperaciones;
	private HashMap<String, Intervencion> intervenciones = new HashMap<String, Intervencion>();
	
	public Cirujano(String nombre, String apellidos, String telefono, String direccion, String idUnico, String numeroDeOperaciones) {
		super(nombre, apellidos, telefono, direccion, idUnico);
		this.setNumeroDeOperaciones(numeroDeOperaciones);
		this.setIntervenciones(null);
	}

	public Cirujano(Cirujano leido) {
		super(leido.getNombre(),leido.getApellidos(),leido.getTelefono(),leido.getDireccion(),leido.getIdUnico());
		this.setNumeroDeOperaciones(leido.getNumeroDeOperaciones());
		this.setIntervenciones(leido.getIntervenciones());
	}
	
	public void crearIntervencion(String idCita, String idUnicoPaciente,String idUnicoMedico, String fecha, String hora, 
			 TipoDeIntervencion tipoDeIntervencion ) {
			Intervencion intervencion = new Intervencion(idCita,idUnicoPaciente,idUnicoMedico,fecha, 
					this.getIdUnico(), tipoDeIntervencion,hora);
				this.intervenciones.put(intervencion.getIdUnicoCita(),intervencion);
	}

	public String getNumeroDeOperaciones() {
		return numeroDeOperaciones;
	}
	
	public HashMap<String, Intervencion> getIntervenciones() {
		return intervenciones;
	}

	public void setNumeroDeOperaciones(String numeroDeOperaciones) {
		this.numeroDeOperaciones = numeroDeOperaciones;
	}
	public void setIntervenciones(HashMap<String, Intervencion> intervenciones) {
		this.intervenciones = intervenciones;
	}

	
}
