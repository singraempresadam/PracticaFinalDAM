package modelo;

import java.util.regex.Pattern;

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
		assert especialidad!=null&&validaEspecialidad(especialidad).isResultado();
		this.especialidad = especialidad;
	}
	
	public static Respuesta validaEspecialidad(String especialidad) {
		return new Respuesta(Pattern.matches("{10}", especialidad), "El especialidad no cumple con los requisitos");
	}
}
