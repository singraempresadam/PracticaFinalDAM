package test.testModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.clasesDatos.Paciente;

class PacienteTest {

	@Test
	void validaFechaNacimiento() {
		String FechaBienUno = "17/5/1992";
		String FechaBienDos = "24/09/2009";
		String FechaBienTres = "22/4/1995";
		
		String FechaMalUno = "28-4-1992";
		String FechaMalDos = "4/3/97";
		String FechaMalTres = "4/4/192";
		
		assertTrue(Paciente.validaFechaNacimiento(FechaBienUno).isResultado());
		assertTrue(Paciente.validaFechaNacimiento(FechaBienDos).isResultado());
		assertTrue(Paciente.validaFechaNacimiento(FechaBienTres).isResultado());
		
		assertFalse(Paciente.validaFechaNacimiento(FechaMalUno).isResultado());
		assertFalse(Paciente.validaFechaNacimiento(FechaMalDos).isResultado());
		assertFalse(Paciente.validaFechaNacimiento(FechaMalTres).isResultado());
	}

}
