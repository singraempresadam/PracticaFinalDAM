package modelo;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Paciente extends Persona{
	
	private String fechaDeNacimiento;
	private ArrayList <Cita> citas;
	private ArrayList <Tratamiento> tratamientos;
	public Paciente(Paciente leido)
	{
		super(leido.getNombre(), leido.getTelefono(), leido.getDireccion(), leido.getIdUnico());
		this.setFechaDeNacimiento(leido.getFechaDeNacimiento());
		this.setCitas(leido.getCitas());
		this.setTratamientos(leido.getTratamientos());
	}
	public Paciente(String nombre, String telefono, String direccion, 
					String idUnico, String fechaDeNacimiento) {
		super(nombre, telefono, direccion, idUnico);
		this.setFechaDeNacimiento(fechaDeNacimiento);
		this.setCitas(null);
		this.setTratamientos(null);
	}
	
	
	
	public String getFechaDeNacimiento() {
		
		return fechaDeNacimiento;
	}
	public ArrayList<Cita> getCitas() {
		return citas;
	}
	public ArrayList<Tratamiento> getTratamientos() {
		return tratamientos;
	}
	
	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		assert fechaDeNacimiento!=null&&validaFechaNacimiento(fechaDeNacimiento).isResultado();
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}
	public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public static Respuesta validaFechaNacimiento(String fechaNacimiento) {
		return new Respuesta(Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", fechaNacimiento), "El fecha nacimiento no cumple con los requisitos");
	}

}
