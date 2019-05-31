package modelo;

import java.util.ArrayList;

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

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public ArrayList<Cita> getCitas() {
		return citas;
	}

	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}

	public ArrayList<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	

}
