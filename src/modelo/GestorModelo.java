package modelo;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.regex.Pattern;

import lecturaYEscritura.DAO;
import lecturaYEscritura.DTO;

public class GestorModelo {
	/*
	 * "Anytime you find yourself writing code of
	 * the from "if the object is of type T1, then do
	 * something, but if it´s of type T2, then do
	 * something else," slap yourself
	 * */
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Medico> medicos = new HashMap<String, Medico>();
	HashMap<String, MedicoActivo> medicosActivo = new HashMap<String, MedicoActivo>();
	HashMap<String, Cirujano> cirujanos = new HashMap<String, Cirujano>();

	DTO <Paciente> dtoPaciente = new DTO<>("pacientes.dat");
	DTO <Medico> dtoMedico = new DTO<>("medicos.dat");
	DTO <MedicoActivo> dtoMedicoActivo = new DTO<>("medicosActivo.dat");
	DTO <Cirujano> dtoCirujano = new DTO<>("cirujanos.dat");
	
	DAO dao;
	
	public void darAltaPacienteNuevo(String nombre, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		Paciente paciente = new Paciente(nombre, telefono, direccion, idUnico, fechaDeNacimiento);
		pacientes.put(paciente.getIdUnico(), paciente);
		//Escribir nueva lista pacientes
	}
	public void darAltaMedico(String nombre, String telefono, String direccion, String idUnico, String especialidad)
	{
		Medico medico= new Medico(nombre, telefono, direccion, idUnico, especialidad);
		medicos.put(medico.getIdUnico(), medico);
		//Escribir nueva lista medicos
	}
	public void darAltaMedicoActivo(String nombre, String telefono, String direccion, String idUnico, String especialidad, 
			LocalTime horaInicio, LocalTime horaFin, boolean [] dias, String consulta)
	{
		MedicoActivo medicoActivo = new MedicoActivo(nombre, telefono, direccion, idUnico, especialidad, horaInicio, horaFin ,dias, consulta);
		medicosActivo.put(medicoActivo.getIdUnico(),medicoActivo);
	}
	
	public void cargarPaciente(Paciente pacienteLeido)
	{
		Paciente paciente = new Paciente(pacienteLeido);
		pacientes.put(paciente.getIdUnico(), paciente);
	}
	public void cargarMedico(Medico medicoLeido)
	{
		Medico medico = new Medico(medicoLeido);
		medicos.put(medico.getIdUnico(), medico);
	}
	public void cargarMedicoActivo(MedicoActivo medicoActivoLeido)
	{
		MedicoActivo medicoActivo = new MedicoActivo(medicoActivoLeido);
		medicosActivo.put(medicoActivo.getIdUnico(), medicoActivo);
	}
	public void cargarCirujano(Cirujano cirujanoLeido)
	{
		Cirujano cirujano = new Cirujano(cirujanoLeido);
		cirujanos.put(cirujano.getIdUnico(), cirujano);
	}
	public void cargarColeccionesMap(){
		cargarColeccionMapPacientes();
		cargarColeccionMapMedicos();
		cargarColeccionMapMedicosActivo();
		cargarColeccionMapCirujanos();
	}
	public void cargarColeccionMapPacientes()
	{
		Paciente pacienteLeido;
		do {
			pacienteLeido=dtoPaciente.leer();
			this.cargarPaciente(pacienteLeido);
		} while (pacienteLeido != null);
	}
	public void cargarColeccionMapMedicos()
	{
		Medico medicoLeido;
		do {
			medicoLeido= dtoMedico.leer();
			this.cargarMedico(medicoLeido);
		} while (medicoLeido != null);
	}
	public void cargarColeccionMapMedicosActivo()
	{
		MedicoActivo medicoActivoLeido;
		do {
			medicoActivoLeido=dtoMedicoActivo.leer();
			this.cargarMedicoActivo(medicoActivoLeido);
		} while (medicoActivoLeido != null);
	}
	public void cargarColeccionMapCirujanos()
	{
		Cirujano cirujanoLeido;
		do {
			cirujanoLeido=dtoCirujano.leer();
			this.cargarCirujano(cirujanoLeido);
		} while (cirujanoLeido != null);
	}
	
	//personas.put(pepito.getIdUnico(), pepito);
	//personas.get("123456789").getNombre());
	
	
}
