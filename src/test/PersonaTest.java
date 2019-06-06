package test;

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
		
		
		assertTrue(Persona.validaNombre(nombreBienUno).isResultado());
		assertTrue(Persona.validaNombre(nombreBienDos).isResultado());
		assertTrue(Persona.validaNombre(nombreBienTres).isResultado());
		
		assertFalse(Persona.validaNombre(nombreMalUno).isResultado());
		assertFalse(Persona.validaNombre(nombreMalDos).isResultado());
		assertFalse(Persona.validaNombre(nombreMalTres).isResultado());
	}
	
	@Test
	void testValidaTelefono() {
		String telefonoBienUno = "622865620";
		String telefonoBienDos = "722277147";
		String telefonoBienTres = "639234898";
		
		String telefonoMalUno = "543234532";
		String telefonoMalDos = "6363234";
		String telefonoMalTres = "62392392349";
		
		assertTrue(Persona.validaTelefono(telefonoBienUno).isResultado());
		assertTrue(Persona.validaTelefono(telefonoBienDos).isResultado());
		assertTrue(Persona.validaTelefono(telefonoBienTres).isResultado());
		
		assertFalse(Persona.validaTelefono(telefonoMalUno).isResultado());
		assertFalse(Persona.validaTelefono(telefonoMalDos).isResultado());
		assertFalse(Persona.validaTelefono(telefonoMalTres).isResultado());
	}
	@Test
	void testValidaDireccion() {
		String direccionBienUno = "Calle Merida";
		String direccionBienDos = "Avenida America";
		String direccionBienTres = "Puertas de tu corazon";
		
		String direccionMalUno = "Socialdemocratificación de los derechos según el manifiesto comunista nazi";
	}
}
