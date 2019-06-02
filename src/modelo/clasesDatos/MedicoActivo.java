package modelo.clasesDatos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import modelo.enumeraciones.Especialidad;

public class MedicoActivo extends Medico{
	
	private Horario horario;
	private String consulta;
	private HashMap<String, Cita> citas = new HashMap<String, Cita>();
	
	public MedicoActivo(MedicoActivo leido)
	{
		super(leido.getNombre(),leido.getApellidos(),leido.getTelefono(), leido.getDireccion(), leido.getIdUnico(), leido.getEspecialidad());
		this.setConsulta(leido.getConsulta());
		this.setHorario(leido.getHorario());
		this.setCitas(leido.getCitas());
	}
	public MedicoActivo(String nombre, String apellidos,String telefono, String direccion, String idUnico, Especialidad especialidad, 
			LocalTime horaInicio, LocalTime horaFin, boolean [] dias, String consulta) {
		super(nombre, apellidos, telefono, direccion, idUnico, especialidad);
		this.setConsulta(consulta);
		Horario horario=new Horario(horaInicio,horaFin,dias);
		this.setHorario(horario);
		this.setCitas(null);
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
	public void crearCita(String idCita, String idUnicoPaciente, String fecha, String hora) {
		Cita cita = new Cita(idCita,idUnicoPaciente,this.getIdUnico(),fecha,hora);
		this.citas.put(cita.getIdUnicoCita(),cita);
	}
}
