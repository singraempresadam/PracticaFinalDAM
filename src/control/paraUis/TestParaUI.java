package control.paraUis;

import java.util.HashMap;
import java.util.Map.Entry;

import modelo.clasesDatos.Paciente;

public class TestParaUI {
	public HashMap<String, Paciente> pacientesTest = new HashMap<String, Paciente>();
	public Paciente uno = new Paciente("Adrian", "Fernandez Cardenal", "622963425", "calle merida", "123456", "17/05/1997");
	public Paciente dos = new Paciente("Pepe", "Fernandez Cardenal", "622963425", "calle merida", "223456", "17/05/1997");
	public Paciente tres = new Paciente("Felipe", "Fernandez Cardenal", "622963425", "calle merida", "323456", "17/05/1997");
	public Paciente cuatro = new Paciente("Carmen", "Fernandez Cardenal", "622963425", "calle merida", "423456", "17/05/1997");

	public TestParaUI() {
		super();
		pacientesTest.put(uno.getIdUnico(), uno);
		pacientesTest.put(dos.getIdUnico(), dos);
		pacientesTest.put(tres.getIdUnico(), tres);
		pacientesTest.put(cuatro.getIdUnico(), cuatro);
	}
	public String[] obtenerElementosAMostrarPacienteTest() {
		String[] retorno = new String[pacientesTest.size()];
		int i = 0;
		for (Entry<String, Paciente> pacienteLista : pacientesTest.entrySet()) {
			retorno[i] = pacienteLista.getValue().getNombre() + "-" + pacienteLista.getValue().getApellidos() + "-"
					+ pacienteLista.getKey() + "-" + pacienteLista.getValue().getTelefono() + "-"
					+ pacienteLista.getValue().getFechaDeNacimiento() + "-" + pacienteLista.getValue().getDireccion();
			i++;
		}
		return retorno;
	}
	public void mostrar(String cosas [])
	{
		for (int i = 0; i < cosas.length; i++) {
			System.out.println(cosas[i]);
		}
	}
	
}
