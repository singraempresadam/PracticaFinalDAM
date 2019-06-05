package lecturaYEscritura;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;

public class PruebaDao {
	public static void main(String[] args) {
		System.out.println("PACIENTE: ");
		Paciente paciente = new Paciente("MArio", "garcia", "3255", "casa", "125", "45");
		grabarYleerPaciente(paciente);
		System.out.println("borrar: ");
		borrarArchivo("125");
		/*
		 * System.out.println("MEDICO: "); grabarYleerMedico();
		 * System.out.println("CIRUJANO: "); grabarYleerCirujano();
		 */

		/* guardarHashMap(); */

	}

	private static void grabarYleerPaciente(Paciente paciente) {
		/* Guardamos cada paciente en un archivo diferente */
		String ruta = paciente.getIdUnico();
		DTO<Paciente> dtoPaciente = new DTO<>(ruta + ".dat");
		if (dtoPaciente.grabar(paciente) == true) {
			System.out.println(paciente.getNombre() + " grabado");
		}
		;
		Paciente pacienteLeer = dtoPaciente.leer();
		System.out.println(pacienteLeer);
		System.out.println(pacienteLeer.getNombre());
		System.out.println(pacienteLeer.getApellidos());
		System.out.println(pacienteLeer.getDireccion());
		System.out.println(pacienteLeer.getFechaDeNacimiento());
		System.out.println(pacienteLeer.getIdUnico());
		System.out.println(pacienteLeer.getTelefono());
		System.out.println(pacienteLeer.getTratamientos());
	}

	private static void guardarHashMap() {
		HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
		Paciente paciente = new Paciente("Juan", "Garcia", "65", "casa", "2", "1998");
		Paciente pacienteDos = new Paciente("PEPE", "PEREZ", "80", "piso", "3", "1999");
		DTO<Paciente> dtoPaciente = new DTO<>("coleccionPaciente.dat");
		pacientes.put(paciente.getIdUnico(), paciente);
		pacientes.put(pacienteDos.getIdUnico(), pacienteDos);
		dtoPaciente.grabarColeccionPaciente(pacientes);
		HashMap coleccion = dtoPaciente.leerColeccion();
		System.out.println(coleccion);
	}

	private static void grabarYleerCirujano() {
		/* Graba cirujanos pero en el mismo archivo */
		Cirujano cirujano = new Cirujano("Raul", "NoSe", "67", "Piso", "4", "20");
		DTO<Cirujano> dtoCirujano = new DTO<>("cirujano.dat");
		if (dtoCirujano.grabar(cirujano) == true) {
			System.out.println(cirujano.getNombre());
			System.out.println(cirujano.getDireccion());
			System.out.println("Cirujano grabado");
		}
		;

		Cirujano cirujanoLeer = dtoCirujano.leer();
		System.out.println(cirujanoLeer);
		System.out.println(cirujanoLeer.getNombre());
	}

	private static void grabarYleerMedico() {
		/* Graba medicos pero en el mismo archivo */

		Medico medico = new Medico("Manolo", "Garcia", "62", "casa", "2", null);
		DTO<Medico> dtoMedico = new DTO<>("medico.dat");
		if (dtoMedico.grabar(medico) == true) {
			System.out.println(medico.getNombre());
			System.out.println(medico.getDireccion());
			System.out.println("Medico grabado");
		}
		;
		Medico medicoLeer = dtoMedico.leer();
		System.out.println(medicoLeer);
		System.out.println(medicoLeer.getNombre());
	}

	
	private static void grabarYllerPaciente() {
		/*Grabar pacientes en cada archivo*/
		Paciente paciente = new Paciente("Juan", "Garcia", "65", "casa", "2", "1998");
		Paciente pacienteDos = new Paciente("MArta", "Garcia", "65", "casa", "3", "1998");
		Paciente pacienteTres = new Paciente("MAria", "Garcia", "65", "casa", "4", "1998");
		String ruta = paciente.getIdUnico();
		String rutaDos = pacienteDos.getIdUnico();
		String rutaTres = pacienteTres.getIdUnico();
		DTO<Paciente> dtoPacienteDos = new DTO<>(rutaDos + ".dat");
		DTO<Paciente> dtoPaciente = new DTO<>(ruta + ".dat");
		DTO<Paciente> dtoPacienteTres = new DTO<>(rutaTres + ".dat");
		if (dtoPaciente.grabar(paciente) == true) {

			System.out.println(paciente.getNombre() + " grabado");
		}
		;
		if (dtoPacienteDos.grabar(pacienteDos) == true) {

			System.out.println(pacienteDos.getNombre() + " grabado");
		}
		;
		if (dtoPacienteTres.grabar(pacienteTres) == true) {
			System.out.println(pacienteTres.getNombre() + " grabado");
		}
		;
		Paciente pacienteLeer = dtoPaciente.leer();
		System.out.println(pacienteLeer);
		System.out.println(pacienteLeer.getNombre());
	}
	 

	private static void borrarArchivo(String id) {
		String ruta = id + ".dat";
		try {
			Files.delete(Paths.get(ruta));
		} catch (IOException e) {
			System.out.println("fallo");
			e.printStackTrace();
		}

	}
}
