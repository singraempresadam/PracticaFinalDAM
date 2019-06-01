package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Paciente extends Persona{
	
	private String fechaDeNacimiento;
	private HashMap<String, Cita> citas = new HashMap<String, Cita>();
	private HashMap <String, Tratamiento> tratamientos = new HashMap<String, Tratamiento>();
	private HashMap<String, Intervencion> intervenciones = new HashMap<String, Intervencion>();
	
	public Paciente(Paciente leido)
	{
		super(leido.getNombre(), leido.getTelefono(), leido.getDireccion(), leido.getIdUnico());
		this.setFechaDeNacimiento(leido.getFechaDeNacimiento());
		this.setCitas(leido.getCitas());
		this.setTratamientos(leido.getTratamientos());
		this.setIntervenciones(leido.getIntervenciones());
	}
	public Paciente(String nombre, String telefono, String direccion, 
					String idUnico, String fechaDeNacimiento) {
		super(nombre, telefono, direccion, idUnico);
		this.setFechaDeNacimiento(fechaDeNacimiento);
		this.setCitas(null);
		this.setTratamientos(null);
		this.setIntervenciones(null);
	}
	
	
	public String getFechaDeNacimiento() {
		
		return fechaDeNacimiento;
	}
	public HashMap<String, Cita> getCitas() {
		return citas;
	}
	public HashMap<String, Tratamiento> getTratamientos() {
		return tratamientos;
	}
	public HashMap<String, Intervencion> getIntervenciones() {
		return intervenciones;
	}
	
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		assert fechaDeNacimiento!=null&&validaFechaNacimiento(fechaDeNacimiento).isResultado();
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public void setCitas(HashMap<String, Cita> citas) {
		this.citas = citas;
	}
	public void setTratamientos(HashMap<String, Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public void setIntervenciones(HashMap<String, Intervencion> intervenciones) {
		this.intervenciones = intervenciones;
	}
	public static Respuesta validaFechaNacimiento(String fechaNacimiento) {
		return new Respuesta(Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", fechaNacimiento), "El fecha nacimiento no cumple con los requisitos");
	}

}
