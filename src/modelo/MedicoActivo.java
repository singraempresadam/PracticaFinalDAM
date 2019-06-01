package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MedicoActivo extends Medico{
	
	private Horario horario;
	private String consulta;
	private ArrayList <Cita> citas;
	
	public MedicoActivo(MedicoActivo leido)
	{
		super(leido.getNombre(),leido.getTelefono(), leido.getDireccion(), leido.getIdUnico(), leido.getEspecialidad());
		this.setConsulta(leido.getConsulta());
		this.setHorario(leido.getHorario());
		this.setCitas(leido.getCitas());
	}
	public MedicoActivo(String nombre, String telefono, String direccion, String idUnico, String especialidad, 
			LocalTime horaInicio, LocalTime horaFin, boolean [] dias, String consulta) {
		super(nombre, telefono, direccion, idUnico, especialidad);
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
	public ArrayList <Cita> getCitas() {
		return citas;
	}
	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public void setConsulta(String consulta) {
		assert consulta!=null&&validaConsulta(consulta).isResultado();
		this.consulta = consulta;
	}
	public void setCitas(ArrayList <Cita> citas) {
		this.citas = citas;
	}
	public static Respuesta validaConsulta(String consulta) {
		return new Respuesta(Pattern.matches("[1234]", consulta), "El consulta no cumple con los requisitos");
	}
}
