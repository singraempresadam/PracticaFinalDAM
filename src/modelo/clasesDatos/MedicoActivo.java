package modelo.clasesDatos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import modelo.enumeraciones.Especialidad;

public class MedicoActivo extends Medico implements Serializable{
	
	private Horario horario;
	private String consulta;
	private HashMap<String, Cita> citas = new HashMap<String, Cita>();
	
	public MedicoActivo(String nombre, String apellidos,String telefono, String direccion, String idUnico, Especialidad especialidad, 
			LocalTime horaInicio, LocalTime horaFin, boolean [] dias, String consulta) {
		super(nombre, apellidos, telefono, direccion, idUnico, especialidad);
		this.setConsulta(consulta);
		Horario horario=new Horario(horaInicio,horaFin,dias);
		this.setHorario(horario);
	}
	
	public Horario getHorario() {
		return horario;
	}
	public String getConsulta() {
		return consulta;
	}
	public HashMap<String, Cita> getCitas() {
		return citas;
	}
	
	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public void setConsulta(String consulta) {
		assert consulta!=null&&validaConsulta(consulta).isResultado();
		this.consulta = consulta;
	}
	public void setCitas(HashMap<String, Cita> citas) {
		this.citas = citas;
	}
	public static Respuesta validaConsulta(String consulta) {
		return new Respuesta(Pattern.matches("[1234]", consulta), "El consulta no cumple con los requisitos");
	}
	public void crearCita(String idCita, String idUnicoPaciente, String fechaYHora) {
		Cita cita = new Cita(idCita,idUnicoPaciente,this.getIdUnico(),fechaYHora);
		System.out.println(this.getCitas());
		this.getCitas().put(cita.getIdUnicoCita(),cita);
	}
	public boolean obtenerDias(int j) {
		return this.getHorario().getDias()[j];
	}
	public LocalTime getHoraIncio() {
		// TODO Auto-generated method stub
		return getHorario().getHoraInicio();
	}
	public LocalTime getHoraFin() {
		// TODO Auto-generated method stub
		return getHorario().getHoraFin();
	}

	public String obtenerPacienteDeCita(String idCita) {
		// TODO Auto-generated method stub
		return this.getCitas().get(idCita).getIdUnicoPaciente();
	}

	public String getNombreYApellidos() {
		// TODO Auto-generated method stub
		return this.getNombre() + " " + this.getApellidos();
	}

	public void modificarCita(String idCita, String observaciones, boolean asistencia) {
		this.getCitas().get(idCita).setConfirmacion(asistencia);
		this.getCitas().get(idCita).setObservaciones(observaciones);
		
	}

	public String[] obtenerCitas() {
		String[] retorno = new String[this.getCitas().size()];
		int i = 0;
		for (Entry<String, Cita> cita : this.getCitas().entrySet()) {
			retorno[i] = cita.getValue().getFechaYHora() + "-" + cita.getValue().isConfirmacion()+"-"+cita.getValue().getIdUnicoCita();
			i++;
		}
		return retorno;
	}
}
