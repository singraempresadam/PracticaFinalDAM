package control.paraUis;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map.Entry;

import modelo.clasesDatos.*;
import modelo.enumeraciones.Especialidad;

public class TestParaUI {
	public HashMap<String, Paciente> pacientesTest = new HashMap<String, Paciente>();
	public HashMap<String, Medico> medicosTest = new HashMap<String, Medico>();
	public HashMap<String, MedicoActivo> medicosActivoTest = new HashMap<String, MedicoActivo>();
	public HashMap<String, Cirujano> cirujanosTest = new HashMap<String, Cirujano>();
	public Paciente uno = new Paciente("Adrian", "Fernandez Cardenal", "622963425", "calle merida", "123456789", "17/05/1997");
	public Paciente dos = new Paciente("Pepe", "Fernandez Cardenal", "622963425", "calle merida", "223456789", "17/05/1997");
	public Paciente tres = new Paciente("Felipe", "Fernandez Cardenal", "622963425", "calle merida", "323456789", "17/05/1997");
	public Paciente cuatro = new Paciente("Carmen", "Fernandez Cardenal", "622963425", "calle merida", "423456789", "17/05/1997");

	public Medico medicoUno = new Medico("Javier", "Gutierrez", "622865686", "Calle Salvamarina", "5648216785", Especialidad.Alergologo);
	public Medico medicoDos = new Medico("Eva", "Salmanca", "658957414", "Calle Benidor", "157468954", Especialidad.Atencion_Primaria);
	public Medico medicoTres = new Medico("Mario", "Rodriguez", "62345698", "Calle AltaGracia", "123658947", Especialidad.Ginecologo);
	public Medico medicoCuatro = new Medico("Ana", "Cabanillas", "677766147", "Calle Altorra", "456284635", Especialidad.Traumatologo);

	boolean [] diasRicardo = {true,true,true,true,true};
	public MedicoActivo medicoActivoUno= new MedicoActivo("Ricardo Antonio", "Zarco", "622568656", "Calle grupoperros", "321456789", 
															Especialidad.Atencion_Primaria, LocalTime.of(10, 0), LocalTime.of(14, 0), 
															diasRicardo, "1");
	public Cirujano cirujanoUno = new Cirujano("Manolo", "Gordillo", "615121512", "Calle Santiago Apostol", "314159692", "2");
	public Cirujano cirujanoDos = new Cirujano("Kiwi", "Pandoso", "621091997", "Calle Enamorado", "321654989", "2");
	
	public TestParaUI() {
		super();
		pacientesTest.put(uno.getIdUnico(), uno);
		pacientesTest.put(dos.getIdUnico(), dos);
		pacientesTest.put(tres.getIdUnico(), tres);
		pacientesTest.put(cuatro.getIdUnico(), cuatro);
		
		medicosTest.put(medicoUno.getIdUnico(), medicoUno);
		medicosTest.put(medicoDos.getIdUnico(), medicoDos);
		medicosTest.put(medicoTres.getIdUnico(), medicoTres);
		medicosTest.put(medicoCuatro.getIdUnico(), medicoCuatro);
		
		medicosActivoTest.put(medicoActivoUno.getIdUnico(), medicoActivoUno);
		
		cirujanosTest.put(cirujanoUno.getIdUnico(), cirujanoUno);
		cirujanosTest.put(cirujanoDos.getIdUnico(), cirujanoDos);
	}
	public void crearPaciente(String nombre, String apellidos, String telefono, String direccion, String idUnico, String fechaDeNacimiento)
	{
		Paciente paciente = new Paciente(nombre, apellidos, telefono, direccion, idUnico, fechaDeNacimiento);
		pacientesTest.put(paciente.getIdUnico(), paciente);
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
	public String[] obtenerElementosAMostrarMedico() {
		String[] retorno = new String[medicosTest.size()];
		int i = 0;
		for (Entry<String, Medico> medicoLista : medicosTest.entrySet()) {
			retorno[i] = medicoLista.getValue().getNombre() + "-" + medicoLista.getValue().getApellidos() + "-"
					+ medicoLista.getKey() + "-" + medicoLista.getValue().getTelefono() + "-"
					+ medicoLista.getValue().getEspecialidad()+"-inactivo";
			i++;
		}
		return retorno;
	}
	public String[] obtenerTodosLosMedicos() {
		String aUno[]=obtenerElementosAMostrarMedico();
		String aDos[]=obtenerElementosAMostrarMedicoActivo();
		String a[] = new String [aUno.length+aDos.length];
		int j=0;
		for (int i = 0; i < aUno.length; i++) {
			a[j]=aUno[i];
			j++;
		}
		for (int i = 0; i < aDos.length; i++) {
			a[j]=aDos[i];
			j++;
		}
		return a;
	}
	public String[] obtenerElementosAMostrarMedicoActivo() {
		String[] retorno = new String[medicosActivoTest.size()];
		int i = 0;
		for (Entry<String, MedicoActivo> medicoActivoLista : medicosActivoTest.entrySet()) {
			retorno[i] = medicoActivoLista.getValue().getNombre() + "-" + medicoActivoLista.getValue().getApellidos()
					+ "-" + medicoActivoLista.getKey() + "-" + medicoActivoLista.getValue().getTelefono() + "-"
					+ medicoActivoLista.getValue().getEspecialidad()+"-activo" ;
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
	public String[] filtrar(String filtro, String[] contenidoAFiltrar) {
		String retorno [];
		int j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(contenidoAFiltrar[i].contains(filtro))
			{
				j++;
			}
		}
		
		retorno= new String[j];
		j=0;
		for (int i = 0; i < contenidoAFiltrar.length; i++) {
			if(contenidoAFiltrar[i].contains(filtro))
			{
				retorno[j]=contenidoAFiltrar[i];
				j++;
			}
		}
		return retorno;
	}
	
}
