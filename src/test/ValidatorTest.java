package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.paraUis.ExceptionDatos;
import control.paraUis.Validator;

class ValidatorTest {
	
	@Test
	void validarDatosPaciente() {
		Validator validator = new Validator();
		String datosPacienteBien= "Adrian-Fernandez Cardenal-622865820-Calle Merida-17/05/1997";
		
		try {
			assertTrue(validator.validarDatosPaciente(datosPacienteBien).isResultado());
		} catch (ExceptionDatos e) {
			e.printStackTrace();
		}
		}
	}


