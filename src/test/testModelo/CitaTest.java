package test.testModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.clasesDatos.Cita;

class CitaTest {

	@Test
	void validaFecha() {
		String FechaBienUno = "17/5/1992";
		String FechaBienDos = "24/09/2009";
		String FechaBienTres = "22/4/1995";
		
		String FechaMalUno = "28-4-1992";
		String FechaMalDos = "4/3/97";
		String FechaMalTres = "4/4/192";
		
		assertTrue(Cita.validaFecha(FechaBienUno).isResultado());
		assertTrue(Cita.validaFecha(FechaBienDos).isResultado());
		assertTrue(Cita.validaFecha(FechaBienTres).isResultado());
		
		assertFalse(Cita.validaFecha(FechaMalUno).isResultado());
		assertFalse(Cita.validaFecha(FechaMalDos).isResultado());
		assertFalse(Cita.validaFecha(FechaMalTres).isResultado());
	}

	@Test
	void testValidaObservaciones() {
		String textoBien = "Hola, amigo, soy una observacion, valida";
		String textoMal = "Aprovecho para dejar unos chistes malos y superar"
				+ "los 200 caracteres. DANGER"
				+ "AlguienSabeComoArreglarLaBarraEspaciadora?"
				+ "¿Que son 8 bocabits? Un bocabyte"
				+ "¿Con que se emborrachan los pinguinos? Con licor del polo";
		
		assertTrue(Cita.validaObservaciones(textoBien).isResultado());
		assertFalse(Cita.validaObservaciones(textoMal).isResultado());
	}
}
