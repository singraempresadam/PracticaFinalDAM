package lecturaYEscritura;

import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;

public class PruebaDao {
 public static void main(String[] args) {
	Paciente paciente = new Paciente("Juan", "Garcia", "65", "casa", "2", "1998");
	Medico medico = new Medico("Manolo", "Garcia", "62", "casa", "2", null);
	Cirujano cirujano = new Cirujano("Raul", "NoSe", "67", "Piso", "4", "20");
	DTO<Paciente>dtoPaciente = new DTO<>("paciente.dat");
	DTO<Medico>dtoMedico = new DTO<>("medico.dat");
	DTO<Cirujano>dtoCirujano = new DTO<>("cirujano.dat");
	if(dtoPaciente.grabar(paciente)==true) {
		System.out.println(paciente.getNombre());
		System.out.println(paciente.getDireccion());
		System.out.println("Paciente grabado");
	};
	if(dtoMedico.grabar(medico)==true) {
		System.out.println(medico.getNombre());
		System.out.println(medico.getDireccion());
		System.out.println("Medico grabado");
	};
	if(dtoCirujano.grabar(cirujano)==true) {
		System.out.println(cirujano.getNombre());
		System.out.println(cirujano.getDireccion());
		System.out.println("Cirujano grabado");
	};
	
	/*Paciente pacienteLeer = dtoPaciente.leer();
	System.out.println(pacienteLeer);*/
	
}
}
