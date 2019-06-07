package test.testDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;

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
	File coleccion;
	String rutaDos = "coleccionPaciente.dat";
	HashMap<String, Paciente> mapaPaciente = new HashMap<String,Paciente>();
	DTO<Paciente> dtoPaciente = new DTO<>(rutaDos);
	Paciente uno = new Paciente("Adrian", "Fernandez Cardenal", "622963425", "calle merida", "123456789", "17/05/1997");

	public boolean equals(Object obj) {
		
		if(this==obj) return true;
		
		if(obj==null) return false;
		
		if(!(obj instanceof Paciente))return false;
		
		Paciente instancia=(Paciente)obj;
		
		return uno.getApellidos()==instancia.getApellidos();
}

@Override
public int hashCode() {

int hash=13;

return hash*uno.getApellidos().hashCode();
}
	@BeforeEach
	void antesDeLaPrueba() throws Exception{
		archivo = new File(ruta);
		coleccion = new File(rutaDos);
		dao = new DAO();
	}
	@AfterEach
	void despuesDeLaPrueba() {
		archivo.delete();
		coleccion.delete();
	}
	@Test
	void testGrabar() {
		assertTrue(dao.grabar(ruta, cosaAgrabar));
		assertTrue(archivo.exists());
		assertTrue(dtoPaciente.grabarColeccionPaciente(mapaPaciente));
		assertTrue(coleccion.exists());
		assertTrue(mapaPaciente.isEmpty());
	}
	@Test
	void subirMapa() {
		mapaPaciente.put(uno.getIdUnico(), uno);
		assertFalse(mapaPaciente.isEmpty());
		assertEquals(uno.getNombre(), mapaPaciente.get(uno.getIdUnico()).getNombre());
		assertEquals(uno, mapaPaciente.get(uno.getIdUnico()));
		
	}
	
	@Test
	void leer() {
		assertTrue(dao.grabar(ruta, cosaAgrabar));
		assertEquals(cosaAgrabar, dao.leer(ruta));
		
	}


}
