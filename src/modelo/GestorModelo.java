package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ListModel;

import lecturaYEscritura.DTO;
import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Cita;
import modelo.clasesDatos.Consulta;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;
import modelo.clasesDatos.Persona;
import modelo.clasesDatos.Respuesta;
import modelo.clasesDatos.Tratamiento;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.Medicamento;
import modelo.enumeraciones.TipoDeIntervencion;
import modelo.enumeraciones.Turno;

public class GestorModelo {
	/*
	 * "Anytime you find yourself writing code of the from "if the object is of type
	 * T1, then do something, but if it�s of type T2, then do something else," slap
	 * yourself
	 */
	private HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	private HashMap<String, Medico> medicos = new HashMap<String, Medico>();
	private HashMap<String, MedicoActivo> medicosActivo = new HashMap<String, MedicoActivo>();
	private HashMap<String, Cirujano> cirujanos = new HashMap<String, Cirujano>();
	private HashMap<String, Consulta> consultas = new HashMap<String, Consulta>();
	
	private DTO<Paciente> dtoPaciente = new DTO<>("src/Almacen/coleccionPaciente.dat");
	private DTO<Medico> dtoMedico = new DTO<>("src/Almacen/medicos.dat");
	private DTO<MedicoActivo> dtoMedicoActivo = new DTO<>("src/Almacen/medicosActivo.dat");
	private DTO<Cirujano> dtoCirujano = new DTO<>("src/Almacen/cirujanos.dat");
	private DTO<Consulta> dtoConsulta = new DTO<>("src/Almacen/consultas.dat");
	
	private LocalDate diaSistema =LocalDate.of(2019, 6, 3);
	private LocalTime horaSistema = LocalTime.of(10, 0);

	public GestorModelo() {
		super();
		this.cargarColeccionesMap();
	}
	@SuppressWarnings("unchecked")
	private void cargarColeccionesMap() {
		this.pacientes=dtoPaciente.leerColeccion();
		this.medicos=dtoMedico.leerColeccion();
		this.medicosActivo = dtoMedicoActivo.leerColeccion();
		this.cirujanos = dtoCirujano.leerColeccion();
		this.consultas = dtoConsulta.leerColeccion();
	}
	
	public void recetarUnTratamiento(String idUnicoPaciente, String medicamento, String dosis, String fechaDeInicio,
			String fechaFin) {
		this.getPacientes().get(idUnicoPaciente).crearTratamiento(medicamento, dosis, fechaDeInicio, fechaFin);
		this.getDtoPaciente().grabarColeccionPaciente(pacientes);
	}
	public void solicitarCitaPaciente(String idUnicoPaciente, String idUnicoMedico, String fechaYHora) {
		String idCita = this.generarId();
		idUnicoMedico=this.obtenerIdPersona(idUnicoMedico);
		System.out.println(idUnicoPaciente + " " + idUnicoMedico + " " +fechaYHora);
		
		this.getPacientes().get(idUnicoPaciente).crearCita(idCita, idUnicoMedico, fechaYHora);
		this.getMedicosActivo().get(idUnicoMedico).crearCita(idCita, idUnicoPaciente, fechaYHora);
		this.guardarPaciente(idUnicoPaciente);
		this.guardarMedicoActivo(idUnicoMedico);
	}
	public void solicitarCitaMedico(String idUnicoPaciente, String idUnicoMedico, String idUnicoMedicoEspecialista, String fechaYHora) {
		String idCita = this.generarId();
		this.getPacientes().get(idUnicoPaciente).crearCita(idCita, idUnicoMedico, fechaYHora);
		this.getMedicosActivo().get(idUnicoMedicoEspecialista).crearCita(idCita, idUnicoPaciente, fechaYHora);
		this.getDtoPaciente().grabarColeccionPaciente(this.getPacientes());
		this.getDtoMedicoActivo().grabarColeccionMedicoActivo(this.getMedicosActivo());
	}
	public void solicitarIntervencion(String idUnicoPaciente, String idUnicoMedico, String idUnicoCirujano,
			TipoDeIntervencion tipoDeIntervencion, String fechaYHora) {
		String idCita = this.generarId();
		this.getPacientes().get(idUnicoPaciente).crearIntervencion(idCita, idUnicoMedico, fechaYHora, idUnicoCirujano,
				tipoDeIntervencion);
		this.getCirujanos().get(idUnicoCirujano).crearIntervencion(idCita, idUnicoPaciente, idUnicoMedico, fechaYHora,
				tipoDeIntervencion);
		this.getDtoPaciente().grabarColeccionPaciente(this.getPacientes());
		this.getDtoCirujano().grabarColeccionCirujano(this.getCirujanos());
	}
	
	public void darAltaPacienteNuevo(String nombre, String apellidos, String telefono, String direccion, String idUnico,
			String fechaDeNacimiento) {
		Paciente paciente = new Paciente(nombre, apellidos, telefono, direccion, idUnico, fechaDeNacimiento);
		this.getPacientes().put(paciente.getIdUnico(), paciente);
		this.getDtoPaciente().grabarColeccionPaciente(this.getPacientes());
		
	}
	public void darAltaMedicoNuevo(String nombre, String apellidos, String telefono, String direccion, String idUnico,
			Especialidad especialidad) {
		Medico medico = new Medico(nombre, apellidos, telefono, direccion, idUnico, especialidad);
		this.getMedicos().put(medico.getIdUnico(), medico);
		this.getDtoMedico().grabarColeccionMedico(this.getMedicos());
	}
	public void darAltaCirujanoNuevo(String nombre, String apellidos, String telefono, String direccion,
			String idUnico) {
		Cirujano cirujano = new Cirujano(nombre, apellidos, telefono, direccion, idUnico, "2");
		this.getCirujanos().put(cirujano.getIdUnico(), cirujano);
		this.getDtoCirujano().grabarColeccionCirujano(this.getCirujanos());
		
	}
	public void darAltaMedicoActivoNuevo(String nombre, String apellidos, String telefono, String direccion,
			String idUnico, Especialidad especialidad, LocalTime horaInicio, LocalTime horaFin, boolean[] dias,
			String consulta) {
		MedicoActivo medicoActivo = new MedicoActivo(nombre, apellidos, telefono, direccion, idUnico, especialidad,
				horaInicio, horaFin, dias, consulta);
		this.getMedicosActivo().put(medicoActivo.getIdUnico(), medicoActivo);
		this.getDtoMedicoActivo().grabarColeccionMedicoActivo(this.getMedicosActivo());
		this.getMedicos().remove(idUnico);
		this.getDtoMedico().grabarColeccionMedico(this.getMedicos());
	}
	
	public void eliminarPaciente(String idUnico)
	{
		this.getPacientes().remove(idUnico);
		getDtoPaciente().grabarColeccionPaciente(this.getPacientes());
	}
	public void darBajaMedicoActivo(String idMedico) {
		Medico medico = crearMedicoDeMedicoActivo(idMedico);
		this.getMedicos().put(idMedico, medico);
		this.getDtoMedico().grabarColeccionMedico(this.getMedicos());
		this.getMedicosActivo().remove(idMedico);
		this.getDtoMedicoActivo().grabarColeccionMedicoActivo(this.getMedicosActivo());
	}
	private Medico crearMedicoDeMedicoActivo(String idMedico) {
		String nombre=this.getMedicosActivo().get(idMedico).getNombre();
		String apellidos=this.getMedicosActivo().get(idMedico).getApellidos();
		String telefono=this.getMedicosActivo().get(idMedico).getTelefono();
		String direccion=this.getMedicosActivo().get(idMedico).getDireccion();
		String idUnico=this.getMedicosActivo().get(idMedico).getIdUnico();
		Especialidad especialidad=this.getMedicosActivo().get(idMedico).getEspecialidad();
		Medico medico = new Medico(nombre, apellidos, telefono, direccion, idUnico, especialidad);
		return medico;
	}
	public void eliminarMedico(String idUnico)
	{
		this.getMedicos().remove(idUnico);
		this.getDtoMedico().grabarColeccionMedico(this.getMedicos());
	}
	public void eliminarMedicoActivo(String idUnico)
	{
		this.getMedicosActivo().remove(idUnico);
		getDtoMedicoActivo().grabarColeccionMedicoActivo(this.getMedicosActivo());
	}
	public void eliminarCirujano(String idUnico)
	{
		this.getCirujanos().remove(idUnico);
		getDtoCirujano().grabarColeccionCirujano(this.getCirujanos());
	}
	
	public Respuesta getValidatorNombre(String nombre)
	{
		return Persona.validaNombre(nombre);
	}
	public Respuesta getValidatorApellidos(String apellidos)
	{
		return Persona.validaApellidos(apellidos);
	}
	public Respuesta getValidatorTelefono(String telefono)
	{
		return Persona.validaTelefono(telefono);
	}
	public Respuesta getValidatorDireccion(String direccion)
	{
		return Persona.validaDireccion(direccion);
	}
	public Respuesta getValidatorFecha(String fecha)
	{
		return Cita.validaFecha(fecha);
	}
	public Respuesta getValidatorObservaciones(String observaciones)
	{
		return Cita.validaObservaciones(observaciones);
	}
	public Respuesta getValidatorConsulta(String consulta)
	{
		return MedicoActivo.validaConsulta(consulta);
	}
	public Respuesta getValidatorFechaDeNacimiento(String fechaNacimiento)
	{
		return Paciente.validaFechaNacimiento(fechaNacimiento);
	}
	public Respuesta getValidatorDosis(String dosis) {
		return Tratamiento.validaDosis(dosis);
	}

	public String[] obtenerElementosAMostrarPaciente() {
		String[] retorno = new String[this.getPacientes().size()];
		int i = 0;
		for (Entry<String, Paciente> pacienteLista : this.getPacientes().entrySet()) {
			retorno[i] = pacienteLista.getValue().getNombre() + "-" + pacienteLista.getValue().getApellidos() + "-"
					+ pacienteLista.getKey() + "-" + pacienteLista.getValue().getTelefono() + "-"
					+ pacienteLista.getValue().getDireccion()+"-"+pacienteLista.getValue().getFechaDeNacimiento();
			i++;
		}
		return retorno;
	}
	public String[] obtenerElementosAMostrarMedico() {
		String[] retorno = new String[this.getMedicos().size()];
		int i = 0;
		for (Entry<String, Medico> medicoLista : medicos.entrySet()) {
			retorno[i] = medicoLista.getValue().getNombre() + "-" + medicoLista.getValue().getApellidos() + "-"
					+ medicoLista.getKey() + "-" + medicoLista.getValue().getTelefono() + "-"
					+ medicoLista.getValue().getDireccion()+"-"+ medicoLista.getValue().getEspecialidad()+ "-Inactivo";
			i++;
		}
		return retorno;
	}
	public String[] obtenerElementosAMostrarMedicoActivo() {
		String[] retorno = new String[this.getMedicosActivo().size()];
		int i = 0;
		for (Entry<String, MedicoActivo> medicoActivoLista : medicosActivo.entrySet()) {
			retorno[i] = medicoActivoLista.getValue().getNombre() + "-" + medicoActivoLista.getValue().getApellidos()
					+ "-" + medicoActivoLista.getKey() + "-" + medicoActivoLista.getValue().getTelefono() + "-"
					+ medicoActivoLista.getValue().getDireccion()+"-"+ medicoActivoLista.getValue().getEspecialidad() + "-Activo";
			i++;
		}
		return retorno;
	}
	public String[] obtenerElementosAMostrarCirujano() {
		String[] retorno = new String[this.getCirujanos().size()];
		int i = 0;
		for (Entry<String, Cirujano> cirujanoLista : this.getCirujanos().entrySet()) {
			retorno[i] = cirujanoLista.getValue().getNombre() + "-" + cirujanoLista.getValue().getApellidos()
					+ "-" + cirujanoLista.getKey() + "-" + cirujanoLista.getValue().getTelefono() + "-"
					+ cirujanoLista.getValue().getDireccion();
			i++;
		}
		return retorno;
	}
	public String[] obtenerTratamiento(String idPaciente) {
		return this.getPacientes().get(idPaciente).obtenerTratamiento();
	}
	public String[] obtenerTodosLosMedicos() {
		String medicos[]=obtenerElementosAMostrarMedico();
		String medicosActivos[]=obtenerElementosAMostrarMedicoActivo();
		String conjuntoMedicos[]=Arrays.copyOf(medicos,medicos.length+medicosActivos.length);
		int j=medicos.length;
		for (int i = 0; i < medicosActivos.length; i++) {
			conjuntoMedicos[j]=medicosActivos[i];
			j++;
		}
		return conjuntoMedicos;
	}
	public String[] filtrarSin(String filtro, String[] contenidoAFiltrar) {
		String [] retorno= new String[tamanioFiltracionSin(filtro, contenidoAFiltrar)];
		int j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(!contenidoAFiltrar[i].contains(filtro))
			{
				retorno[j]=contenidoAFiltrar[i];
				j++;
			}
		}
		return retorno;
	}
	public String[] filtrar(String filtro, String[] contenidoAFiltrar) {
		String [] retorno= new String[tamanioFiltracion(filtro, contenidoAFiltrar)];
		int j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(contenidoAFiltrar[i].contains(filtro))
			{
				retorno[j]=contenidoAFiltrar[i];
				j++;
			}
		}
		return retorno;
	}
	private int tamanioFiltracion(String filtro, String[] contenidoAFiltrar) {
		int j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(contenidoAFiltrar[i].contains(filtro))
			{
				j++;
			}
		}
		return j;
	}
	private int tamanioFiltracionSin(String filtro, String[] contenidoAFiltrar) {
		int j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(!contenidoAFiltrar[i].contains(filtro))
			{
				j++;
			}
		}
		return j;
	}
	public String fechaYHora() {
		return this.getDiaSistema().toString()+" "+this.getHoraSistema().toString();
	}
	public Paciente obtenerUnPaciente(String idUnicoPaciente) {
		return pacientes.get(idUnicoPaciente);
	}
	public String generarId() {
		int numero = (int) (Math.random() * 999999999) + 100000000;
		return String.valueOf(numero);
	}
	public void aumentarHora(long i) {
		LocalTime horaAnterior = this.getHoraSistema();
		this.setHoraSistema(horaSistema.plusHours(i));
		int comparacion=horaAnterior.compareTo(this.getHoraSistema());
		
		if( comparacion == 1 || comparacion == 0)
		{
			this.aumentarDia(1);
		}
	}
	public void aumentarDia(long i) {
		this.setDiaSistema(diaSistema.plusDays(i));
		
	}
	public boolean[][] solicitarHorario(String obtenerIdSeleccionado, int tamanio) {
		String idMedicoSeleccionado = obtenerIdPersona(obtenerIdSeleccionado);
		boolean [][] retorno = new boolean [tamanio][5];
		for (int i = 0; i < retorno.length; i++) {
			for (int j = 0; j < retorno[i].length; j++) {
				retorno[i][j]=this.getMedicosActivo().get(idMedicoSeleccionado).obtenerDias(j);				
			}
		}
 		return retorno;
	}
	public boolean[][] solicitarHorarioCirujano(String obtenerIdSeleccionado, int tamanio) {
		String idCirujanoSeleccionado = obtenerIdPersona(obtenerIdSeleccionado);
		boolean [][] retorno = new boolean [tamanio][5];
		for (int i = 0; i < retorno.length; i++) {
			for (int j = 0; j < retorno[i].length; j++) {
				retorno[i][j]=this.getCirujanos().get(idCirujanoSeleccionado).obtenerDias(j);				
			}
		}
 		return retorno;
	}
	private String obtenerIdPersona(String obtenerIdSeleccionado) {
		String [] fragmentarDatos = obtenerIdSeleccionado.split("-");
		String idMedicoSeleccionado=fragmentarDatos[2];
		return idMedicoSeleccionado;
	}
	public LocalTime[] obtenerInicioYFin(String medico) {
		String id=obtenerIdPersona(medico);
		LocalTime [] retorno = {this.getMedicosActivo().get(id).getHoraIncio(), 
					this.getMedicosActivo().get(id).getHoraFin()};
		return retorno;
	}
	public LocalTime[] obtenerInicioYFinCirujano(String cirujano) {
		String id=obtenerIdPersona(cirujano);
		LocalTime [] retorno = {this.getCirujanos().get(id).getHoraIncio(), 
					this.getCirujanos().get(id).getHoraFin()};
		return retorno;
	}
	public String getDia() {
		return this.getDiaSistema().getDayOfWeek().toString();
	}
	public LocalDate obtenerPrimerLunesSemanal(int plus) {
		return getDiaSistema().plusDays(-plus);
	}
	public String obtenerPacienteDeCita(String idCita,String idMedico) {
		
		return this.getMedicosActivo().get(idMedico).obtenerPacienteDeCita(idCita);
	}
	public String obtenerPacienteDeIntervencion(String idIntervencion,String idCirujano) {
		
		return this.getCirujanos().get(idCirujano).obtenerPacienteDeIntervencion(idIntervencion);
	}
	public String obtenerMedicoDeIntervencion(String idIntervencion,String idCirujano) {
		
		return this.getCirujanos().get(idCirujano).obtenerMedicoDeIntervencion(idIntervencion);
	}
	public String obtenerNombrePaciente(String idPaciente) {
		
		return this.getPacientes().get(idPaciente).getNombreYApellidos();
	}
	public String obtenerNombreCirujano(String idCirujano) {
		return this.getCirujanos().get(idCirujano).getNombreYApellidos();
	}
	public String obtenerNombreMedico(String idMedico) {
		return this.getMedicosActivo().get(idMedico).getNombreYApellidos();
	}
	public void crearTratamiento(String idPaciente, String medicamento, String dosis, String fechaInicio,
			String fechaFin) {
		this.getPacientes().get(idPaciente).crearTratamiento(medicamento, dosis, fechaInicio, fechaFin);
		
	}
	public String[] obtenerCitasRealizadas(String idPaciente) {
		return this.filtrar("true", this.getPacientes().get(idPaciente).obtenerCitas());
	}
	public String[] obtenerCitasPendientes(String idPaciente) {
		return this.filtrar("false", this.getPacientes().get(idPaciente).obtenerCitas());
	}
	public String[] obtenerCitasEIntervencionesPendientes(String idPaciente) {
		String [] citasP = this.obtenerCitasPendientes(idPaciente);
		String [] intervencionP = this.obtenerIntervencionesPendientes(idPaciente);
		String [] retorno = new String[intervencionP.length+citasP.length];
		for (int i = 0; i < citasP.length; i++) 
			retorno[i]=citasP[i];
		int j=0;
		for(int i=citasP.length;i<retorno.length;i++)
		{
			retorno[i]=intervencionP[j];
			j++;
		}
		return retorno;
	}
	public String[] obtenerCitasEIntervencionesRealizadas(String idPaciente) {
		String [] citasR = this.obtenerCitasRealizadas(idPaciente);
		String [] intervencionR = this.obtenerIntervencionesRealizadas(idPaciente);
		String [] retorno = new String[intervencionR.length+citasR.length];
		for (int i = 0; i < citasR.length; i++) 
			retorno[i]=citasR[i];
		int j=0;
		for(int i=citasR.length;i<retorno.length;i++)
		{
			retorno[i]=intervencionR[j];
			j++;
		}
		return retorno;
	}
	public String[] obtenerIntervencionesRealizadas(String idPaciente)
	{
		return this.filtrar("true", this.getPacientes().get(idPaciente).obtenerIntervenciones());
	}
	public String[] obtenerIntervencionesPendientes(String idPaciente)
	{
		return this.filtrar("false", this.getPacientes().get(idPaciente).obtenerIntervenciones());
	}
	public String[] obtenerCitasRealizadasMedico(String idMedico) {
		return this.filtrar("true", this.getMedicosActivo().get(idMedico).obtenerCitas());
	}
	public String[] obtenerCitasPendientesMedico(String idMedico) {
		return this.filtrar("false", this.getMedicosActivo().get(idMedico).obtenerCitas());
	}
	public String[] obtenerIntervencionesPendientesCirujano(String idCirujano) {
		return this.filtrar("false", this.getCirujanos().get(idCirujano).obtenerIntervenciones());
	}
	public String[] obtenerIntervencionesRealizadasCirujano(String idCirujano) {
		return this.filtrar("true", this.getCirujanos().get(idCirujano).obtenerIntervenciones());
	}
	public void modificarCita(String idCita, String observaciones, String idPaciente, String idMedico,boolean asistencia) {
		System.out.println(idCita + " " + observaciones + " " + asistencia);
		this.getPacientes().get(idPaciente).modificarCita(idCita,observaciones,asistencia);
		this.getMedicosActivo().get(idMedico).modificarCita(idCita,observaciones,asistencia);
		guardarPaciente(idPaciente);
		guardarMedicoActivo(idMedico);
	}
	public void modificarIntervencion(String idIntervencion, String observacion, String idPaciente, String idCirujano,
			boolean valid) {
		this.getPacientes().get(idPaciente).modificarIntervencion(idIntervencion,observacion,valid);
		this.getCirujanos().get(idCirujano).modificarIntervencion(idIntervencion,observacion,valid);
		guardarPaciente(idPaciente);
		guardarCirujano(idCirujano);
	}
	private void guardarMedicoActivo(String idMedico) {
		this.getMedicosActivo().put(idMedico,this.getMedicosActivo().get(idMedico));
		this.getDtoMedicoActivo().grabarColeccionMedicoActivo(this.getMedicosActivo());
	}
	private void guardarMedico(String idMedico) {
		this.getMedicos().put(idMedico,this.getMedicos().get(idMedico));
		this.getDtoMedico().grabarColeccionMedico(this.getMedicos());
	}
	private void guardarPaciente(String idPaciente) {
		this.getPacientes().put(idPaciente, this.getPacientes().get(idPaciente));
		this.getDtoPaciente().grabarColeccionPaciente(this.getPacientes());
	}
	private void guardarCirujano(String idCirujano) {
		this.getCirujanos().put(idCirujano, this.getCirujanos().get(idCirujano));
		this.getDtoCirujano().grabarColeccionCirujano(this.getCirujanos());
	}
	public void modificarPaciente(String idPaciente, String telefono, String direccion) {
		this.getPacientes().get(idPaciente).setTelefono(telefono);
		this.getPacientes().get(idPaciente).setDireccion(direccion);
		this.guardarPaciente(idPaciente);
	}
	public void modificarMedico(String idMedico, String telefono, String direccion) {
		this.getMedicos().get(idMedico).setTelefono(telefono);
		this.getMedicos().get(idMedico).setDireccion(direccion);
		this.guardarMedico(idMedico);
	}
	
	public void modificarMedicoActivo(String idMedico, String telefono, String direccion) {
		this.getMedicosActivo().get(idMedico).setTelefono(telefono);
		this.getMedicosActivo().get(idMedico).setDireccion(direccion);
		this.guardarMedicoActivo(idMedico);
	}
	public boolean comprobarAtencionPrimaria(String idMedico) {
		boolean retorno;
		if(this.getMedicosActivo().get(idMedico).getEspecialidad().toString().contains("Atencion_Primaria"))
			retorno=true;
		else retorno=false;
		return retorno;
	}
	public HashMap obtenerIntervencionesCirujano(String idCirujano) {
		return getCirujanos().get(idCirujano).getIntervenciones();
	}
	public void establecerHora(int dia, int hora, int minuto) {
		this.setHoraSistema(LocalTime.of(hora, minuto));
		this.setDiaSistema(this.getDiaSistema().plusDays(dia));
	}
	public Object[] obtenerEspecialidades() {
		return Especialidad.values();
	}
	public Object[] obtenerTurno() {
		return Turno.values();
	}
	public String[] obtenerTodosLosMedicosInactivosAtencionPrimaria() {
		String[] filtrar = this.filtrar("Atencion_Primaria", this.obtenerTodosLosMedicos());
		String[] filtrarSin = this.filtrarSin("Activo",filtrar);
		return filtrarSin;
	}
	public String[] obtenerTodosLosMedicosInactivosEspecialistas() {
		String[] filtrar = this.filtrarSin("Atencion_Primaria", this.obtenerTodosLosMedicos());
		String[] filtrarSin = this.filtrarSin("Activo",filtrar);
		return filtrarSin;
	}
	
	public LocalDate getDiaSistema() {
		return diaSistema;
	}
	public void setDiaSistema(LocalDate diaSistema) {
		this.diaSistema = diaSistema;
	}
	public LocalTime getHoraSistema() {
		return horaSistema;
	}
	public void setHoraSistema(LocalTime horaSistema) {
		this.horaSistema = horaSistema;
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
	
	public HashMap<String, Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(HashMap<String, Consulta> consultas) {
		this.consultas = consultas;
	}
	public DTO<Consulta> getDtoConsulta() {
		return dtoConsulta;
	}
	public void setDtoConsulta(DTO<Consulta> dtoConsulta) {
		this.dtoConsulta = dtoConsulta;
	}
	public boolean comprobarConsulta(int hora, String consultaSeleccionada) {
		boolean retorno;
		if(hora==Turno.ma�ana.getHora())
			retorno=this.getConsultas().get(consultaSeleccionada).ComprobarTurnoMa�anaEntero();
		else
			retorno=this.getConsultas().get(consultaSeleccionada).ComprobarTurnoTardeEntero();
		return retorno;
	}
	public void asignarConsulta(int hora, String consultaSeleccionada) {
		if(hora==Turno.ma�ana.getHora())
			this.getConsultas().get(consultaSeleccionada).cambiarTurnoMa�anaEntero();
		else
			this.getConsultas().get(consultaSeleccionada).cambiarTurnoTardeEntero();
	}
	public boolean comprobarConsulta(boolean[] dias, int hora, String consultaSeleccionada) {
		boolean retorno;
		if(hora>=Turno.ma�ana.getHora() && hora<Turno.tarde.getHora())
			retorno=this.getConsultas().get(consultaSeleccionada).comprobarTurnoMa�anaParcial(dias, hora);
		else
			retorno=this.getConsultas().get(consultaSeleccionada).comprobarTurnoTardeParcial(dias, hora);
		return retorno;
	}
	public void asignarConsulta(boolean[] dias, int hora, String consultaSeleccionada) {
		if(hora>=Turno.ma�ana.getHora() && hora<Turno.tarde.getHora())
			this.getConsultas().get(consultaSeleccionada).cambiarTurnoMa�anaParcial(dias, hora);
		else
			this.getConsultas().get(consultaSeleccionada).cambiarTurnoTardeParcial(dias, hora);
	}
	public Object[] obtenerMedicamentos() {
		return Medicamento.values();
	}
	
	
}
