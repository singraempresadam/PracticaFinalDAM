package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.clasesDatos.MedicoActivo;

class MedicoActivoTest {

	@Test
	void testValidaConsulta() {
		String consultaBienUno="1";
		String consultaBienDos="2";
		String consultaBienTres="3";
		
		String consultaMalUno=" 1";
		String consultaMalDos="0";
		String consultaMalTres="8";
		
		assertTrue(MedicoActivo.validaConsulta(consultaBienUno).isResultado());
		assertTrue(MedicoActivo.validaConsulta(consultaBienDos).isResultado());
		assertTrue(MedicoActivo.validaConsulta(consultaBienTres).isResultado());
		
		assertFalse(MedicoActivo.validaConsulta(consultaMalUno).isResultado());
		assertFalse(MedicoActivo.validaConsulta(consultaMalDos).isResultado());
		assertFalse(MedicoActivo.validaConsulta(consultaMalTres).isResultado());
	}

}
