package modelo;

public class Cirujano extends Persona{
	private String numeroDeOperaciones;
	
	public Cirujano(String nombre, String telefono, String direccion, String idUnico, String numeroDeOperaciones) {
		super(nombre, telefono, direccion, idUnico);
		this.setNumeroDeOperaciones(numeroDeOperaciones);
	}

	public Cirujano(Cirujano leido) {
		super(leido.getNombre(),leido.getTelefono(),leido.getDireccion(),leido.getIdUnico());
		this.setNumeroDeOperaciones(leido.getNumeroDeOperaciones());
	}

	public String getNumeroDeOperaciones() {
		return numeroDeOperaciones;
	}

	public void setNumeroDeOperaciones(String numeroDeOperaciones) {
		this.numeroDeOperaciones = numeroDeOperaciones;
	}

	
}
