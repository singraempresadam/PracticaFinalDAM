package modelo;

import java.util.HashMap;
import java.util.regex.Pattern;

import lecturaYEscritura.DAO;
import lecturaYEscritura.DTO;

public class GestorModelo {
	HashMap<String, Persona> personas = new HashMap<String, Persona>();
	DAO dao;
	DTO dto;
	public void cargarColeccionMap(){
		/*	Leer todos los pacientes de pacientes.dat
		 * 		Añadir a personas
		 * 	Leer todos los medicos de medicos.dat
		 * 		Añadir a personas
		 * 	Leer todos los medicosActivos de medicosActivos.dat
		 * 		Añadir a personas
		 * 	Leer todos los cirujanos de cirujanos.dat
		 * 		Añadir a personas
		 * 
		 * 
		 * 
		 * */
	}
	
	
	public static void main(String[] args) {
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		Paciente juan = new Paciente("Adrian", "622865620", "CalleMerida", "123456789", "17/05/1997");
		Paciente Juan1 = new Paciente("Adrian", "622865620", "CalleMerida", "123456785", "17/05/1997");
		Paciente Juan2 = new Paciente("Adrian", "622865620", "CalleMerida", "123456786", "17/05/1997");
		Paciente Juan3 = new Paciente("Adrian", "622865620", "CalleMerida", "123456787", "17/05/1997");
		Paciente Juan4 = new Paciente("Adrian", "622865620", "CalleMerida", "123456788", "17/05/1997");
		Medico pedro = new Medico("Javier", "656854524", "CalleFernando",   "854698513", "Urologo");
		Medico pedro1 = new Medico("Javier", "656854524", "CalleFernando",   "854698542", "Urologo");
		Medico pedro2 = new Medico("Javier", "656854524", "CalleFernando",   "854698552", "Urologo");
		Medico pedro3 = new Medico("Javier", "656854524", "CalleFernando",   "854698562", "Urologo");
		Medico pedro4 = new Medico("Javier", "656854524", "CalleFernando",   "854698572", "Urologo");
		Cirujano pepito = new Cirujano("Pedro", "639008656", "EnriqueTribiño", "789654123", "2");
		
		personas.put(pedro.getIdUnico(), pedro);
		personas.put(juan.getIdUnico(), juan);
		personas.put(pepito.getIdUnico(), pepito);
		
		System.out.println(personas.get("123456789").getNombre());
		
	}
	
}
