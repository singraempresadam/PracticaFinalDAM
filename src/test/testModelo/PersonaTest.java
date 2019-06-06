package test.testModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.clasesDatos.Persona;

class PersonaTest {

	@Test
	void test() {
		assertTrue(true);
	}
	
	@Test
	void testValidaNombre() {
		String nombreBienUno = "Juan";
		String nombreBienDos = "Javierncho";
		String nombreBienTres = "Francisco Javier";
		
		String nombreMalUno = "juan";
		String nombreMalDos = "JaViErNChO";
		String nombreMalTres = "Yo Soy Tu Padre";
		
		String[] nombreBien = {nombreBienUno,nombreBienDos,nombreBienTres};
		for (int i = 0; i < nombreBien.length; i++) {
			assertTrue(Persona.validaNombre(nombreBien[i]).isResultado());
		}
		
		String[] nombreMal = {nombreMalUno,nombreMalDos,nombreMalTres};
		for (int i = 0; i < nombreMal.length; i++) {
			assertFalse(Persona.validaNombre(nombreMal[i]).isResultado());
		}
	}
	
	@Test
	void testValidaApellidos() {
		String apellidoBienUno = "Fernandez";
		String apellidoBienDos = "Javie Encho";
		String apellidoBienTres = "Francisco Javier";
		
		String apellidoMalUno = "juan";
		String apellidoMalDos = "JaViE rNChO";
		String apellidoMalTres = "Yo Soy Tu Padre";
		
		String [] apellidoBien= {apellidoBienUno,apellidoBienDos,apellidoBienTres};
		for (int i = 0; i < apellidoBien.length; i++) {
			assertTrue(Persona.validaNombre(apellidoBien[i]).isResultado());
		}
		
		String[] apellidoMal= {apellidoMalUno,apellidoMalDos,apellidoMalTres};
		for (int i = 0; i < apellidoMal.length; i++) {
			assertFalse(Persona.validaNombre(apellidoMal[i]).isResultado());
		}
	}
	
	@Test
	void testValidaTelefono() {
		String telefonoBienUno = "622865620";
		String telefonoBienDos = "722277147";
		String telefonoBienTres = "639234898";
		
		String telefonoMalUno = "543234532";
		String telefonoMalDos = "6363234";
		String telefonoMalTres = "62392392349";
		
		String[] telefonoBien = {telefonoBienUno,telefonoBienDos,telefonoBienTres};
		for (int i = 0; i < telefonoBien.length; i++) {
			assertTrue(Persona.validaTelefono(telefonoBien[i]).isResultado());
		}
		
		String[] telefonoMal = {telefonoMalUno,telefonoMalDos,telefonoMalTres};
		for (int i = 0; i < telefonoMal.length; i++) {
			assertFalse(Persona.validaTelefono(telefonoMal[i]).isResultado());
		}
	}
	
	@Test
	void testValidaDireccion() {
		String DireccionBienUno = "Calle Merida";
		String DireccionBienDos = "Avenida de la Paz";
		String DireccionBienTres = "Calle Madrid";
		
		String DireccionMalUno = "Calle bienvenido por la gloria de la santa madre yoquese23";
		String DireccionMalDos = "Calle bienvenido por la gloria de la santa madre yoquese23"
				+ "				  Calle bienvenido por la gloria de la santa madre yoquese23"
				+ "				  Calle bienvenido por la gloria de la santa madre yoquese23";
		String DireccionMalTres = "	Calle bienvenido por la gloria de la santa madre yoquese23"
				+ "					Calle bienvenido por la gloria de la santa madre yoquese23"
				+ "					Calle bienvenido por la gloria de la santa madre yoquese23"
				+ "					Calle bienvenido por la gloria de la santa madre yoquese23";
		
		String[] direccionBien = {DireccionBienUno,DireccionBienDos,DireccionBienTres};
		for (int i = 0; i < direccionBien.length; i++) {
			assertTrue(Persona.validaDireccion(direccionBien[i]).isResultado());
		}
		
		String[] direccionMal = {DireccionMalUno,DireccionMalDos,DireccionMalTres};
		for (int i = 0; i < direccionMal.length; i++) {
			assertFalse(Persona.validaDireccion(direccionMal[i]).isResultado());
		}
	}
}
