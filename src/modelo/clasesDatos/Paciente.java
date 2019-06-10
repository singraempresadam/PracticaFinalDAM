package modelo.clasesDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import modelo.enumeraciones.TipoDeIntervencion;

public class Paciente extends Persona implements Serializable{

	private String fechaDeNacimiento;
	private HashMap<String, Cita> citas = new HashMap<String, Cita>();
	private ArrayList<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
	private HashMap<String, Intervencion> intervenciones = new HashMap<String, Intervencion>();
	

	public Paciente(String nombre, String apellidos, String telefono, String direccion, 
					String idUnico, String fechaDeNacimiento) {
		super(nombre,apellidos, telefono, direccion, idUnico);
		this.setFechaDeNacimiento(fechaDeNacimiento);
	}
	public void crearTratamiento(String medicamento, String dosis, String fechaInicio, String fechaFin) {
		this.tratamientos.add(new Tratamiento(this.getIdUnico(),medicamento,dosis,fechaInicio,fechaFin));
		
	}
	public void crearCita(String idCita, String idUnicoMedico, String fechaYHora) {
		Cita cita = new Cita(idCita,this.getIdUnico(),idUnicoMedico,fechaYHora);
		this.getCitas().put(cita.getIdUnicoCita(), cita);
	}
	public void crearIntervencion(String idCita, String idUnicoMedico, String fechaYHora, 
								String idUnicoCirujano, TipoDeIntervencion tipoDeIntervencion ) {
		Intervencion intervencion = new Intervencion(idCita,this.getIdUnico(),idUnicoMedico, 
														idUnicoCirujano, tipoDeIntervencion,fechaYHora);
		this.intervenciones.put(intervencion.getIdUnicoCita(),intervencion);
	}
	// GETTERS AND SETTERS
	public String getFechaDeNacimiento() {
		
		return fechaDeNacimiento;
	}
	public HashMap<String, Cita> getCitas() {
		return citas;
	}
	public ArrayList<Tratamiento> getTratamientos() {
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
	public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	public void setIntervenciones(HashMap<String, Intervencion> intervenciones) {
		this.intervenciones = intervenciones;
	}
	//VALIDADORES
	public static Respuesta validaFechaNacimiento(String fechaNacimiento) {
		return new Respuesta(Pattern.matches("\\d{1,2}/\\d{1,2}/\\d{4}", fechaNacimiento), "El fecha nacimiento no cumple con los requisitos");
	}
	
	

}
