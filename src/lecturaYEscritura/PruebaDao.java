package lecturaYEscritura;

import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;

public class PruebaDao {
 public static void main(String[] args) {
	 System.out.println("PACIENTE: ");
	grabarYllerPaciente();
	System.out.println("MEDICO: ");
	grabarYleerMedico();
	System.out.println("CIRUJANO: ");
	grabarYleerCirujano();
}

private static void grabarYleerCirujano() {
	Cirujano cirujano = new Cirujano("Raul", "NoSe", "67", "Piso", "4", "20");
	DTO<Cirujano>dtoCirujano = new DTO<>("cirujano.dat");
	if(dtoCirujano.grabar(cirujano)==true) {
		System.out.println(cirujano.getNombre());
		System.out.println(cirujano.getDireccion());
		System.out.println("Cirujano grabado");
	};

	Cirujano cirujanoLeer = dtoCirujano.leer();
	System.out.println(cirujanoLeer);
	System.out.println(cirujanoLeer.getNombre());
}

private static void grabarYleerMedico() {
	Medico medico = new Medico("Manolo", "Garcia", "62", "casa", "2", null);
	DTO<Medico>dtoMedico = new DTO<>("medico.dat");
	if(dtoMedico.grabar(medico)==true) {
		System.out.println(medico.getNombre());
		System.out.println(medico.getDireccion());
		System.out.println("Medico grabado");
	};
	Medico medicoLeer = dtoMedico.leer();
	System.out.println(medicoLeer);
	System.out.println(medicoLeer.getNombre());
}

private static void grabarYllerPaciente() {
	Paciente paciente = new Paciente("Juan", "Garcia", "65", "casa", "2", "1998");
	DTO<Paciente>dtoPaciente = new DTO<>("paciente.dat");
	if(dtoPaciente.grabar(paciente)==true) {
		System.out.println(paciente.getNombre());
		System.out.println(paciente.getDireccion());
		System.out.println("Paciente grabado");
	};
	Paciente pacienteLeer = dtoPaciente.leer();
	System.out.println(pacienteLeer);
	System.out.println(pacienteLeer.getNombre());
}
}
