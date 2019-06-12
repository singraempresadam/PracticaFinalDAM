package control;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.ListModel;

import modelo.GestorModelo;
import modelo.clasesDatos.Cita;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;
import modelo.clasesDatos.Persona;
import modelo.clasesDatos.Respuesta;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.TipoDeIntervencion;

public class Controller {
	GestorModelo miGestor;
	
	public Controller()
	{
		miGestor= new GestorModelo();
	}
	
	void recetarUnTratamiento(String idUnicoPaciente, String medicamento, 
			String dosis, String fechaDeInicio ,String fechaFin)
	{
		this.getMiGestor().recetarUnTratamiento(idUnicoPaciente, medicamento,  dosis, fechaDeInicio, fechaFin);
	}
	public void solicitarCitaPaciente(String idUnicoPaciente,String idUnicoMedico, String fechaYHora)
	{
		this.getMiGestor().solicitarCitaPaciente(idUnicoPaciente, idUnicoMedico, fechaYHora);
	}
	void solicitarCitaMedico(String idUnicoPaciente, String idUnicoMedico, String idUnicoMedicoEspecialista, String fechaYHora)
	{
		this.getMiGestor().solicitarCitaMedico(idUnicoPaciente, idUnicoMedico, idUnicoMedicoEspecialista, fechaYHora);
	}
	void solicitarIntervencion(String idUnicoPaciente,String idUnicoMedico, 
								String fechaYHora, String idUnicoCirujano, 
								TipoDeIntervencion tipoDeIntervencion)
	{
		this.getMiGestor().solicitarIntervencion(idUnicoPaciente, idUnicoMedico, idUnicoCirujano, tipoDeIntervencion, fechaYHora);
	}
	
	public void darAltaPacienteNuevo(String nombre, String apellidos, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		this.getMiGestor().darAltaPacienteNuevo(nombre, apellidos, telefono, direccion, idUnico, fechaDeNacimiento);
	}
	public void darAltaMedicoNuevo(String nombre, String apellidos,String telefono, String direccion, String idUnico, Especialidad especialidad)
	{
		this.getMiGestor().darAltaMedicoNuevo(nombre, apellidos,telefono, direccion, idUnico, especialidad);
	}
	public void darAltaMedicoActivoNuevo(String nombre, String apellidos,String telefono, String direccion, 
			String idUnico, Especialidad especialidad, LocalTime horaInicio, 
			LocalTime horaFin, boolean [] dias, String consulta)
	{
		this.getMiGestor().darAltaMedicoActivoNuevo(nombre,apellidos, telefono, direccion, idUnico, especialidad, horaInicio, horaFin, dias, consulta);
	}
	
	public void darAltaCirujanoNuevo(String nombre, String apellidos,String telefono, String direccion, String idUnico)
	{
		this.getMiGestor().darAltaCirujanoNuevo(nombre, apellidos,telefono, direccion, idUnico);
	}
	
	public void eliminarPaciente(String idUnico)
	{
		this.getMiGestor().eliminarPaciente(idUnico);
	}
	public void eliminarMedico(String idUnico)
	{
		this.getMiGestor().eliminarMedico(idUnico);
	}
	public void eliminarMedicoActivo(String idUnico)
	{
		this.getMiGestor().eliminarMedicoActivo(idUnico);
	}
	public void eliminarCirujano(String idUnico)
	{
		this.getMiGestor().eliminarCirujano(idUnico);
	}
	
	public Respuesta getValidatorNombre(String nombre)
	{
		return this.getMiGestor().getValidatorNombre(nombre);
	}
	public Respuesta getValidatorApellidos(String apellidos)
	{
		return this.getMiGestor().getValidatorApellidos(apellidos);
	}
	public Respuesta getValidatorTelefono(String telefono)
	{
		return this.getMiGestor().getValidatorTelefono(telefono);
	}
	public Respuesta getValidatorDireccion(String direccion)
	{
		return this.getMiGestor().getValidatorDireccion(direccion);
	}
	public Respuesta getValidatorFecha(String fecha)
	{
		return this.getMiGestor().getValidatorFecha(fecha);
	}
	public Respuesta getValidatorObservaciones(String observaciones)
	{
		return this.getMiGestor().getValidatorObservaciones(observaciones);
	}
	public Respuesta getValidatorConsulta(String consulta)
	{
		return this.getMiGestor().getValidatorConsulta(consulta);
	}
	public Respuesta getValidatorFechaDeNacimiento(String fechaNacimiento)
	{
		return this.getMiGestor().getValidatorFechaDeNacimiento(fechaNacimiento);
	}
	
	
	public String fechaYHora()
	{
		return this.getMiGestor().fechaYHora();
	}
	
	public String [] obtenerElementosAMostrarPaciente()
	{
		return this.getMiGestor().obtenerElementosAMostrarPaciente();
	}
	public String [] obtenerElementosAMostrarMedico()
	{
		return this.getMiGestor().obtenerElementosAMostrarMedico();
	}
	public String [] obtenerElementosAMostrarMedicoActivo()
	{
		return this.getMiGestor().obtenerElementosAMostrarMedicoActivo();
	}
	
	
	public String [] obtenerElementosAMostrarCirujano()
	{
		return this.getMiGestor().obtenerElementosAMostrarCirujano();
	}
	

	public String [] obtenerTodosLosMedicos() {
		return this.getMiGestor().obtenerTodosLosMedicos();
	}
	public String [] filtrar(String filtro, String[] contenidoAFiltrar)
	{
		return this.getMiGestor().filtrar(filtro, contenidoAFiltrar);
	}
	public String [] filtrarSin(String filtro, String[] contenidoAFiltrar)
	{
		return this.getMiGestor().filtrarSin(filtro, contenidoAFiltrar);
	}
	public GestorModelo getMiGestor() {
		return miGestor;
	}
	
	public String generarId()
	{
		return this.getMiGestor().generarId();
	}

	public void aumentarHora(long i) {
		this.getMiGestor().aumentarHora(i);
		
	}

	public void aumentarDia(long i) {
		this.getMiGestor().aumentarDia(i);
		
	}

	public boolean[][] solicitarHorario(String obtenerIdSeleccionado, int tamanio) {
		return this.miGestor.solicitarHorario(obtenerIdSeleccionado, tamanio);
	}

	public LocalTime[] obtenerInicioYFin(String medico) {
		
		return this.getMiGestor().obtenerInicioYFin(medico);
	}
	public LocalTime[] obtenerInicioYFinCirujano(String cirujano) {
		return this.getMiGestor().obtenerInicioYFinCirujano(cirujano);
	}

	public String getDia() {
		return this.getMiGestor().getDia();
		
	}

	public LocalDate obtenerPrimerLunesSemanal(int plus) {
		return getMiGestor().obtenerPrimerLunesSemanal(-plus);
	}

	public String obtenerPacienteDeCita(String idCita,String idMedico) {
		
		return this.getMiGestor().obtenerPacienteDeCita(idCita, idMedico);
	}
	public String obtenerPacienteDeIntervencion(String idIntervencion, String idCirujano) {
		return this.getMiGestor().obtenerPacienteDeIntervencion(idIntervencion, idCirujano);
	}
	public String obtenerMedicoDeIntervencion(String idIntervencion, String idCirujano) {
		return this.getMiGestor().obtenerMedicoDeIntervencion(idIntervencion, idCirujano);
	}
	public String obtenerNombrePaciente(String idPaciente) {
		return this.getMiGestor().obtenerNombrePaciente(idPaciente);
	}

	public String obtenerNombreMedico(String idMedico) {
		return this.getMiGestor().obtenerNombreMedico(idMedico);
	}
	public String obtenerNombreCirujano(String idCirujano) {
		return this.getMiGestor().obtenerNombreCirujano(idCirujano);
	}
	public void crearTratamiento(String idPaciente, String tratamiento, String dosis, String fechaInicio, String fechaFin) {
		this.getMiGestor().crearTratamiento(idPaciente, tratamiento, dosis, fechaInicio, fechaFin);
		
	}

	public String[] obtenerTratamiento(String idPaciente) {
		return this.getMiGestor().obtenerTratamiento(idPaciente);
	}

	public String[] obtenerCitasPendientes(String idPaciente) {
		return this.getMiGestor().obtenerCitasPendientes(idPaciente);
	}
	public String[] obtenerCitasPendientesMedico(String idMedico) {
		return this.getMiGestor().obtenerCitasPendientesMedico(idMedico);
	}
	public String[] obtenerCitasRealizadasMedico(String idMedico) {
		return this.getMiGestor().obtenerCitasRealizadasMedico(idMedico);
	}

	public  String[] obtenerCitasRealizadas(String idPaciente) {
		return this.getMiGestor().obtenerCitasRealizadas(idPaciente);
	}

	public void modificarCita(String idCita, String observaciones, String idPaciente, String idMedico, boolean asistencia) {
		this.getMiGestor().modificarCita(idCita, observaciones, idPaciente,idMedico, asistencia);
		
	}
	public void modificarIntervencion(String idIntervencion, String observacion, String idPaciente, String idCirujano,
			boolean valid) {
		this.getMiGestor().modificarIntervencion(idIntervencion,observacion,idPaciente,idCirujano,valid);
	}

	public void modificarPaciente(String idPaciente, String telefono, String direccion) {
		this.getMiGestor().modificarPaciente(idPaciente,telefono,direccion);
	}

	public void darBajaMedicoActivo(String idMedico) {
		this.getMiGestor().darBajaMedicoActivo(idMedico);
		
	}

	public boolean comprobarAtencionPrimaria(String idMedico) {
		return this.getMiGestor().comprobarAtencionPrimaria(idMedico);
	}

	public String[] obtenerListaCirujanos() {
		return this.getMiGestor().obtenerElementosAMostrarCirujano();
	}

	public boolean[][] solicitarHorarioCirujano(String cirujano, int i) {
		return this.getMiGestor().solicitarHorarioCirujano(cirujano, i);
	}

	public void solicitarIntervencion(String idPaciente, String idMedico, String obtenerIdSeleccionado,
			TipoDeIntervencion selectedItem, String fecha) {
		this.getMiGestor().solicitarIntervencion(idPaciente, idMedico, obtenerIdSeleccionado, selectedItem, fecha);
		
	}

	
	

	

	

	

	

	
	
}
