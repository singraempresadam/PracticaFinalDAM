package modelo.clasesDatos;

import java.util.HashMap;

public class Cirujano extends Persona{
	private String numeroDeOperaciones;
	private HashMap<String, Intervencion> intervenciones = new HashMap<String, Intervencion>();
	
	public Cirujano(String nombre, String telefono, String direccion, String idUnico, String numeroDeOperaciones) {
		super(nombre, telefono, direccion, idUnico);
		this.setNumeroDeOperaciones(numeroDeOperaciones);
		this.setIntervenciones(null);
	}

	public Cirujano(Cirujano leido) {
		super(leido.getNombre(),leido.getTelefono(),leido.getDireccion(),leido.getIdUnico());
		this.setNumeroDeOperaciones(leido.getNumeroDeOperaciones());
		this.setIntervenciones(leido.getIntervenciones());
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
