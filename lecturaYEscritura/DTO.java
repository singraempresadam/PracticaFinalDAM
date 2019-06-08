package lecturaYEscritura;

import java.util.HashMap;

import modelo.clasesDatos.Cirujano;
import modelo.clasesDatos.Medico;
import modelo.clasesDatos.MedicoActivo;
import modelo.clasesDatos.Paciente;

public class DTO <Object>{
	private DAO miDao;
	private String ruta;
	
	public DTO(String ruta)
	{
		super();
		assert ruta != null;
		miDao = new DAO();
		this.ruta = ruta;
	}
	public HashMap leerColeccion() {
		return (HashMap) miDao.leer(this.ruta);
	}
	public Object leer() {
		return (Object) miDao.leer(this.ruta);
	}
	public boolean grabar (Object objeto) {
		
		return miDao.grabar(this.ruta, objeto);
	}
	
public boolean grabarColeccionPaciente (HashMap<String, Paciente> pacientes) {
		
		return miDao.grabar(this.ruta, pacientes);
	}
public boolean grabarColeccionMedico (HashMap<String, Medico> medicos) {
	
	return miDao.grabar(this.ruta, medicos);
}
public boolean grabarColeccionMedicoActivo (HashMap<String, MedicoActivo> medicosActivos) {
	
	return miDao.grabar(this.ruta, medicosActivos);
}
public boolean grabarColeccionCirujano (HashMap<String, Cirujano> cirujanos) {
	
	return miDao.grabar(this.ruta, cirujanos);
}
public boolean grabarColeccionPacienteJose (HashMap<String, String> pacientes) {
	
	return miDao.grabar(this.ruta, pacientes);
}
}
