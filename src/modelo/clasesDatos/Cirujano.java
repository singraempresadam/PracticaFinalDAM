package modelo.clasesDatos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashMap;

import modelo.enumeraciones.TipoDeIntervencion;

public class Cirujano extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4405045914921004136L;
	private String numeroDeOperaciones;
	private HashMap<String, Intervencion> intervenciones = new HashMap<String, Intervencion>();
	private Horario horario;
	
	public Cirujano(String nombre, String apellidos, String telefono, String direccion, String idUnico, String numeroDeOperaciones) {
		super(nombre, apellidos, telefono, direccion, idUnico);
		this.setNumeroDeOperaciones(numeroDeOperaciones);
		crearHorario();
	}
	
	private void crearHorario() {
		boolean[] dias ={true,true,true,true,true};
		this.setHorario(new Horario(LocalTime.of(0, 0), LocalTime.of(Integer.valueOf(this.getNumeroDeOperaciones()), 0), dias));
	}

	public void crearIntervencion(String idCita, String idUnicoPaciente,String idUnicoMedico, String fechaYHora, 
			 TipoDeIntervencion tipoDeIntervencion ) {
			Intervencion intervencion = new Intervencion(idCita,idUnicoPaciente,idUnicoMedico,
					this.getIdUnico(), tipoDeIntervencion,fechaYHora);
				this.getIntervenciones().put(intervencion.getIdUnicoCita(),intervencion);
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public boolean obtenerDias(int j) {
		return this.getHorario().getDias()[j];
	}

	public LocalTime getHoraIncio() {
		return getHorario().getHoraInicio();
	}
	public LocalTime getHoraFin() {
		return getHorario().getHoraFin();
	}

	public String getNombreYApellidos() {
		return this.getNombre()+ " " + this.getApellidos();
	}

	
	public String obtenerPacienteDeIntervencion(String idIntervencion) {
		// TODO Auto-generated method stub
		return this.getIntervenciones().get(idIntervencion).getIdUnicoPaciente();
	}
	public String obtenerMedicoDeIntervencion(String idIntervencion) {
		// TODO Auto-generated method stub
		return this.getIntervenciones().get(idIntervencion).getIdUnicoMedico();
	}

	public void modificarIntervencion(String idIntervencion, String observacion, boolean valid) {
		this.getIntervenciones().get(idIntervencion).setConfirmacion(valid);
		this.getIntervenciones().get(idIntervencion).setObservaciones(observacion);
		
	}
	
	
}
