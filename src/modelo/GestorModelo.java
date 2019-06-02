package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import lecturaYEscritura.DAO;
import lecturaYEscritura.DTO;
import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;
import modelo.enumeraciones.Especialidad;

public class GestorModelo {
	/*
	 * "Anytime you find yourself writing code of
	 * the from "if the object is of type T1, then do
	 * something, but if it´s of type T2, then do
	 * something else," slap yourself
	 * */
	private HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	private HashMap<String, Medico> medicos = new HashMap<String, Medico>();
	private HashMap<String, MedicoActivo> medicosActivo = new HashMap<String, MedicoActivo>();
	private HashMap<String, Cirujano> cirujanos = new HashMap<String, Cirujano>();

	private DTO <Paciente> dtoPaciente = new DTO<>("pacientes.dat");
	private DTO <Medico> dtoMedico = new DTO<>("medicos.dat");
	private DTO <MedicoActivo> dtoMedicoActivo = new DTO<>("medicosActivo.dat");
	private DTO <Cirujano> dtoCirujano = new DTO<>("cirujanos.dat");
	
	public GestorModelo()
	{
		super();
		this.cargarColeccionesMap();
	}
	public void recetarUnTratamiento(String idUnicoPaciente, String medicamento, String dosis, String fechaDeInicio,String fechaFin) {
		pacientes.get(idUnicoPaciente).crearTratamiento(medicamento, dosis, fechaDeInicio, fechaFin);
		//sobrescribimos el paciente aprovechando hashMap
		dtoPaciente.grabar(pacientes.get(idUnicoPaciente));
	}
	public void solicitarCita(String idUnicoPaciente, String idUnicoMedico, String fecha, String hora) {
		String idCita= this.generarId();
		pacientes.get(idUnicoPaciente).crearCita(idCita, idUnicoMedico, fecha, hora);
		medicosActivo.get(idUnicoMedico).crearCita(idCita, idUnicoPaciente, fecha, hora);
		dtoPaciente.grabar(pacientes.get(idUnicoPaciente));
		dtoMedicoActivo.grabar(medicosActivo.get(idUnicoMedico));
	}
	public void darAltaPacienteNuevo(String nombre, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		Paciente paciente = new Paciente(nombre, telefono, direccion, idUnico, fechaDeNacimiento);
		pacientes.put(paciente.getIdUnico(), paciente);
		for (Entry<String, Paciente> pacienteLista : pacientes.entrySet()) {
			dtoPaciente.grabar(pacienteLista.getValue());
		}
	}
	public void darAltaMedicoNuevo(String nombre, String telefono, String direccion, String idUnico, Especialidad especialidad)
	{
		Medico medico= new Medico(nombre, telefono, direccion, idUnico, especialidad);
		medicos.put(medico.getIdUnico(), medico);
		for (Entry<String, Medico> medicoLista : medicos.entrySet()) {
			dtoMedico.grabar(medicoLista.getValue());
		}
	}
	public void darAltaMedicoActivoNuevo(String nombre, String telefono, String direccion, String idUnico, Especialidad especialidad, 
			LocalTime horaInicio, LocalTime horaFin, boolean [] dias, String consulta)
	{
		MedicoActivo medicoActivo = new MedicoActivo(nombre, telefono, direccion, idUnico, especialidad, horaInicio, horaFin ,dias, consulta);
		medicosActivo.put(medicoActivo.getIdUnico(),medicoActivo);
		for (Entry<String, MedicoActivo> medicoActivoLista : medicosActivo.entrySet()) {
			dtoMedico.grabar(medicoActivoLista.getValue());
		}
	}
	
	//Bloque para cargar colecciones
	private void cargarPaciente(Paciente pacienteLeido)
	{
		Paciente paciente = new Paciente(pacienteLeido);
		pacientes.put(paciente.getIdUnico(), paciente);
	}
	private void cargarMedico(Medico medicoLeido)
	{
		Medico medico = new Medico(medicoLeido);
		medicos.put(medico.getIdUnico(), medico);
	}
	private void cargarMedicoActivo(MedicoActivo medicoActivoLeido)
	{
		MedicoActivo medicoActivo = new MedicoActivo(medicoActivoLeido);
		medicosActivo.put(medicoActivo.getIdUnico(), medicoActivo);
	}
	private void cargarCirujano(Cirujano cirujanoLeido)
	{
		Cirujano cirujano = new Cirujano(cirujanoLeido);
		cirujanos.put(cirujano.getIdUnico(), cirujano);
	}
	private void cargarColeccionesMap(){
		cargarColeccionMapPacientes();
		cargarColeccionMapMedicos();
		cargarColeccionMapMedicosActivo();
		cargarColeccionMapCirujanos();
	}
	private void cargarColeccionMapPacientes()
	{
		Paciente pacienteLeido;
		do {
			pacienteLeido=dtoPaciente.leer();
			this.cargarPaciente(pacienteLeido);
		} while (pacienteLeido != null);
	}
	private void cargarColeccionMapMedicos()
	{
		Medico medicoLeido;
		do {
			medicoLeido= dtoMedico.leer();
			this.cargarMedico(medicoLeido);
		} while (medicoLeido != null);
	}
	private void cargarColeccionMapMedicosActivo()
	{
		MedicoActivo medicoActivoLeido;
		do {
			medicoActivoLeido=dtoMedicoActivo.leer();
			this.cargarMedicoActivo(medicoActivoLeido);
		} while (medicoActivoLeido != null);
	}
	private void cargarColeccionMapCirujanos()
	{
		Cirujano cirujanoLeido;
		do {
			cirujanoLeido=dtoCirujano.leer();
			this.cargarCirujano(cirujanoLeido);
		} while (cirujanoLeido != null);
	}
	public Paciente obtenerUnPaciente(String idUnicoPaciente)
	{
		return pacientes.get(idUnicoPaciente);
	}
	public HashMap<String, Paciente> getPacientes() {
		return pacientes;
	}
	public HashMap<String, Medico> getMedicos() {
		return medicos;
	}
	public HashMap<String, MedicoActivo> getMedicosActivo() {
		return medicosActivo;
	}
	public HashMap<String, Cirujano> getCirujanos() {
		return cirujanos;
	}
	public DTO<Paciente> getDtoPaciente() {
		return dtoPaciente;
	}
	public DTO<Medico> getDtoMedico() {
		return dtoMedico;
	}
	public DTO<MedicoActivo> getDtoMedicoActivo() {
		return dtoMedicoActivo;
	}
	public DTO<Cirujano> getDtoCirujano() {
		return dtoCirujano;
	}
	private String generarId()
	{
		int numero= (int) (Math.random()*999999999)+100000000;
		return String.valueOf(numero);
	}
	
	
}
