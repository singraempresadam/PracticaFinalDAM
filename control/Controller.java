package control;

import java.time.LocalTime;

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
	void solicitarCitaPaciente(String idUnicoPaciente,String idUnicoMedico, String fecha, String hora)
	{
		this.getMiGestor().solicitarCitaPaciente(idUnicoPaciente, idUnicoMedico, fecha, hora);
	}
	void solicitarCitaMedico(String idUnicoPaciente, String idUnicoMedico, String idUnicoMedicoEspecialista, String fecha, String hora)
	{
		this.getMiGestor().solicitarCitaMedico(idUnicoPaciente, idUnicoMedico, idUnicoMedicoEspecialista, fecha, hora);
	}
	void solicitarIntervencion(String idUnicoPaciente,String idUnicoMedico, 
								String fecha, String hora, String idUnicoCirujano, 
								TipoDeIntervencion tipoDeIntervencion)
	{
		this.getMiGestor().solicitarIntervencion(idUnicoPaciente, idUnicoMedico, idUnicoCirujano, tipoDeIntervencion, fecha, hora);
	}
	
	public void darAltaPacienteNuevo(String nombre, String apellidos, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		this.getMiGestor().darAltaPacienteNuevo(nombre, apellidos, telefono, direccion, idUnico, fechaDeNacimiento);
	}
	public void darAltaMedicoNuevo(String nombre, String apellidos,String telefono, String direccion, String idUnico, Especialidad especialidad)
	{
		this.getMiGestor().darAltaMedicoNuevo(nombre, apellidos,telefono, direccion, idUnico, especialidad);
	}
	void darAltaMedicoActivoNuevo(String nombre, String apellidos,String telefono, String direccion, 
			String idUnico, Especialidad especialidad, LocalTime horaInicio, 
			LocalTime horaFin, boolean [] dias, String consulta)
	{
		this.getMiGestor().darAltaMedicoActivoNuevo(nombre,apellidos, telefono, direccion, idUnico, especialidad, horaInicio, horaFin, dias, consulta);
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
}
