package test.testValidador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class ValidadoresDatosTest {

	String fecha = "([0][1-9]|[12][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/([1][9][0-9][0-9]|[2][0][0-9][0-9]|[2][1][0][0])";
	String domicilio = "^[c][a][l][l][e][ ].*|^[a][v][e][n][i][d][a][ ].*";
	String dosis = "[1-9][ ][m][g]|[1-9][ ][g]|[1-9][0-9][ ][m][g]|[1-9][0-9][ ][g]|[1-9][0-9][0-9][ ][m][g]|[1-9][0-9][0-9][ ][g]|[1][0][0][0][ ][m][g]|[1][0][0][0][ ][g]";

	@Test
	void fecha() {
		assertTrue(Pattern.matches(fecha, "15/05/1997"));
		assertEquals(true, Pattern.matches(fecha, "15/05/1997"));
		assertTrue(Pattern.matches(fecha, "28/08/2010"));
		assertEquals(true, Pattern.matches(fecha, "17/12/2014"));

		assertFalse(Pattern.matches(fecha, "15/12/1834"));
		assertEquals(false, Pattern.matches(fecha, "33/14/1890"));
		assertFalse(Pattern.matches(fecha, "40/20/2200"));
		assertEquals(false, Pattern.matches(fecha, "57/15/2314"));

	}
	
	@Test
	void domicilio() {
		assertTrue(Pattern.matches(domicilio, "calle a"));
		assertEquals(true, Pattern.matches(domicilio, "avenida san antonio"));
		assertTrue(Pattern.matches(domicilio, "calle "));
		assertEquals(true, Pattern.matches(domicilio, "avenida "));

		assertFalse(Pattern.matches(domicilio, "calle"));
		assertFalse(Pattern.matches(domicilio, "avenida"));
		assertEquals(false, Pattern.matches(domicilio, "carretera"));
		assertEquals(false, Pattern.matches(domicilio, "casa"));

	}
	@Test
	void dosis() {
		assertTrue(Pattern.matches(dosis, "2 mg"));
		assertEquals(true, Pattern.matches(dosis, "2 g"));
		assertTrue(Pattern.matches(dosis, "999 mg"));
		assertEquals(true, Pattern.matches(dosis, "999 g"));

		assertFalse(Pattern.matches(dosis, "0"));
		assertFalse(Pattern.matches(dosis, "1001"));
		assertFalse(Pattern.matches(dosis, "1000"));
		assertEquals(false, Pattern.matches(dosis, "00"));
		assertEquals(false, Pattern.matches(dosis, "90"));

	}

}
