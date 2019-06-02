package control;

import java.time.LocalTime;
import java.util.ArrayList;

import modelo.GestorModelo;
import modelo.clasesDatos.Tratamiento;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.TipoDeIntervencion;

public class Controller {
	GestorModelo miGestor = new GestorModelo();
	
	
	
	void darAltaPacienteNuevo(String nombre, String apellidos, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		miGestor.darAltaPacienteNuevo(nombre, apellidos, telefono, direccion, idUnico, fechaDeNacimiento);
	}
	void darAltaMedicoNuevo(String nombre, String apellidos,String telefono, String direccion, String idUnico, Especialidad especialidad)
	{
		miGestor.darAltaMedicoNuevo(nombre, apellidos,telefono, direccion, idUnico, especialidad);
	}
	void darAltaMedicoActivoNuevo(String nombre, String apellidos,String telefono, String direccion, 
			String idUnico, Especialidad especialidad, LocalTime horaInicio, 
			LocalTime horaFin, boolean [] dias, String consulta)
	{
		miGestor.darAltaMedicoActivoNuevo(nombre,apellidos, telefono, direccion, idUnico, especialidad, horaInicio, horaFin, dias, consulta);
	}
	
	void recetarUnTratamiento(String idUnicoPaciente, String medicamento, 
			String dosis, String fechaDeInicio ,String fechaFin)
	{
		miGestor.recetarUnTratamiento(idUnicoPaciente, medicamento,  dosis, fechaDeInicio, fechaFin);
	}
	
	void solicitarCita(String idUnicoPaciente,String idUnicoMedico, String fecha, String hora)
	{
		miGestor.solicitarCita(idUnicoPaciente, idUnicoMedico, fecha, hora);
	}
	void solicitarIntervencion(String idUnicoPaciente,String idUnicoMedico, 
								String fecha, String hora, String idUnicoCirujano, 
								TipoDeIntervencion tipoDeIntervencion)
	{
		
	}
	String [] obtenerElementosAMostrarPaciente()
	{
		return miGestor.obtenerElementosAMostrarPaciente();
	}
	String [] obtenerElementosAMostrarMedico()
	{
		return miGestor.obtenerElementosAMostrarMedico();
	}
	String [] obtenerElementosAMostrarMedicoActivo()
	{
		return miGestor.obtenerElementosAMostrarMedicoActivo();
	}
}
