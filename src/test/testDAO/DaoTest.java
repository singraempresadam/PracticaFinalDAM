package test.testDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lecturaYEscritura.DAO;
import lecturaYEscritura.DTO;
import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.Paciente;

class DaoTest {
	String cosaAgrabar = "necesito grabarme";
	String ruta = "test.dat";
	File archivo;
	DAO dao = null;

	@BeforeEach
	void antesDeLaPrueba() throws Exception{
		archivo = new File(ruta);
		dao = new DAO();
	}
	@AfterEach
	void despuesDeLaPrueba() {
		archivo.delete();
	}
	@Test
	void testGrabar() {
		assertTrue(dao.grabar(ruta, cosaAgrabar));
		assertTrue(archivo.exists());
	}
	@Test
	void leer() {
		assertTrue(dao.grabar(ruta, cosaAgrabar));
		assertEquals(cosaAgrabar, dao.leer(ruta));
	}

}
