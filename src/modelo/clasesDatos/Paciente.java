package modelo.clasesDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.swing.ListModel;

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
	public String getNombreYApellidos() {
		
		return this.getNombre()+ " " + this.getApellidos();
	}
	public String[] obtenerTratamiento() {
		int i = 0;
		String[] retorno=new String [this.getTratamientos().size()];
		for (Tratamiento tratamiento: this.getTratamientos()) {
			retorno[i] = tratamiento.getFechaInicio() + "-" + tratamiento.getFechaFin() + "-"
					+tratamiento.getMedicamento() + "-" + tratamiento.getDosis();
		}
		return retorno;
	}
	public String[] obtenerCitas() {
		String[] retorno = new String[this.getCitas().size()];
		int i = 0;
		for (Entry<String, Cita> cita : this.getCitas().entrySet()) {
			retorno[i] = "cita-"+ cita.getValue().getFechaYHora() + "-" + cita.getValue().isConfirmacion()+"-"+cita.getValue().getIdUnicoCita();
			i++;
		}
		return retorno;
	}
	public String[] obtenerIntervenciones()
	{
		String[] retorno = new String[this.getIntervenciones().size()];
		int i = 0;
		for (Entry<String, Intervencion> intervencion : this.getIntervenciones().entrySet()) {
			retorno[i] = "intervencion-"+ intervencion.getValue().getFechaYHora() + "-" + intervencion.getValue().isConfirmacion()+"-"+intervencion.getValue().getIdUnicoCita();
			i++;
		}
		return retorno;
	}
	public void modificarCita(String idCita, String observaciones, boolean asistencia) {
		this.getCitas().get(idCita).setConfirmacion(asistencia);
		this.getCitas().get(idCita).setObservaciones(observaciones);
		
	}
	public void modificarIntervencion(String idIntervencion, String observacion, boolean valid) {
		this.getIntervenciones().get(idIntervencion).setConfirmacion(valid);
		this.getIntervenciones().get(idIntervencion).setObservaciones(observacion);
		
	}
	
	
	

}
