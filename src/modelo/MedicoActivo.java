package modelo;

import java.util.ArrayList;

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
	public MedicoActivo(String nombre, String telefono, String direccion, String idUnico, String especialidad, Horario horario, String consulta) {
		super(nombre, telefono, direccion, idUnico, especialidad);
		this.setConsulta(consulta);
		this.setHorario(horario);
		this.setCitas(null);
	}
	

	
	
	
	
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public ArrayList <Cita> getCitas() {
		return citas;
	}
	public void setCitas(ArrayList <Cita> citas) {
		this.citas = citas;
	}
}
