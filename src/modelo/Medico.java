package modelo;

public class Medico extends Persona{
	private String especialidad;
	
	public Medico(String nombre, String telefono, String direccion, String idUnico, String especialidad) {
		super(nombre, telefono, direccion, idUnico);
		this.setEspecialidad(especialidad);
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}
