package control.paraUis;


import modelo.clasesDatos.Paciente;
import modelo.clasesDatos.Respuesta;

public class Validator{
	public Respuesta validarDatosPaciente(String datosPaciente) throws ExceptionDatos
	{
		String datosFragmentados[]= datosPaciente.split("-");
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		Respuesta [] retornoArray= new Respuesta [5];
		try {
			retornoArray[0]=Paciente.validaNombre(datosFragmentados[0]);
			retornoArray[1]=Paciente.validaApellidos(datosFragmentados[1]);
			retornoArray[2]=Paciente.validaTelefono(datosFragmentados[2]);
			retornoArray[3]=Paciente.validaDireccion(datosFragmentados[3]);
			retornoArray[4]=Paciente.validaFechaNacimiento(datosFragmentados[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			return new Respuesta(false,"Faltan parametros por introducir");
		}
		
		int i=0;
		while(retorno.isResultado() && i < retornoArray.length)
		{
			retorno=retornoArray[i];
			if(!retorno.isResultado()) throw new ExceptionDatos(retorno.getComentario());
			i++;
		}
		return retorno; 
	}
}
