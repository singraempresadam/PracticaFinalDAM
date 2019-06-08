package test.testValidador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Controller;
import control.paraUis.ExceptionDatos;
import control.paraUis.Validator;

class ValidatorTest {

	@Test
	void validarDatosPaciente() {

		Validator validator = new Validator();
		Controller control = new Controller();
		
		String datosPacienteBienUno = "Adrian-Fernandez Cardenal-622865620-Calle Merida-17/05/1997";
		String datosPacienteBienDos = "Felipe-Ramirez Perales-639002656-Avenida America-18/05/1975";
		String datosPacienteBienTres = "Jose Ramon-Broncano-645856545-Calle Buenavista-17/8/2004";
		
		String datosPacienteMalUno = "antonio-Hernandez-622885450-Calle Madrid-17/05/1957";
		String datosPacienteMalDos = "Adrian-Fernandez Cardenal-6228565620-Calle Merida-17/05/1997";
		String datosPacienteMalTres = "Felpudez-Caminata Larga-622865620-Calle Merida-17/05/19997";
		
		String[] datosPacienteBien = {datosPacienteBienUno,datosPacienteBienDos,datosPacienteBienTres};
		for (int i = 0; i < datosPacienteBien.length; i++) {
			try {
				assertTrue(validator.validarDatosPaciente(datosPacienteBien[i], control).isResultado());
			} catch (ExceptionDatos e) {
				System.out.println(e.getMsg());
			}
		}
		String[] datosPacienteMal = {datosPacienteMalUno,datosPacienteMalDos,datosPacienteMalTres};
		for (int i = 0; i < datosPacienteMal.length; i++) {
			try {
				assertFalse(validator.validarDatosPaciente(datosPacienteMal[i], control).isResultado());
			} catch (ExceptionDatos e) {
				System.out.println("Debe entrar aqui");
			}
		}
		
	}

}
