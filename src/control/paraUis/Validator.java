package control.paraUis;


import control.Controller;
import modelo.clasesDatos.Paciente;
import modelo.clasesDatos.Respuesta;

public class Validator{
	public Respuesta validarDatosPaciente(String[] datosFragmentados, Controller control) throws ExceptionDatos
	{
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		
		Respuesta [] retornoArray= new Respuesta [5];
		try {
			retornoArray[0]=this.validarNombre(datosFragmentados[0], control);
			retornoArray[1]=this.validarApellidos(datosFragmentados[1], control);
			retornoArray[2]=this.validarTelefono(datosFragmentados[3], control);
			retornoArray[3]=this.validarDireccion(datosFragmentados[4], control);
			retornoArray[4]=this.validarFechaDeNacimiento(datosFragmentados[5], control);
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

	public Respuesta validarDatosMedico(String[] datosFragmentados, Controller control) throws ExceptionDatos{
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		
		Respuesta [] retornoArray= new Respuesta [4];
		try {
			retornoArray[0]=this.validarNombre(datosFragmentados[0], control);
			retornoArray[1]=this.validarApellidos(datosFragmentados[1], control);
			retornoArray[2]=this.validarTelefono(datosFragmentados[2], control);
			retornoArray[3]=this.validarDireccion(datosFragmentados[3], control);
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
	
	public Respuesta validarDatosCirujano(String[] datosFragmentados, Controller control) throws ExceptionDatos
	{
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		
		Respuesta [] retornoArray= new Respuesta [4];
		try {
			retornoArray[0]=this.validarNombre(datosFragmentados[0], control);
			retornoArray[1]=this.validarApellidos(datosFragmentados[1], control);
			retornoArray[2]=this.validarTelefono(datosFragmentados[2], control);
			retornoArray[3]=this.validarDireccion(datosFragmentados[3], control);
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
	public Respuesta validarTratamiento(String dosis, String fechaInicio, String fechaFin, Controller control)throws ExceptionDatos {
		String datosFragmentados[]= {dosis,fechaInicio, fechaFin};
		Respuesta retorno= new Respuesta(true,"No hay fallo");
		Respuesta [] retornoArray= new Respuesta [4];
		try {
			retornoArray[0]=this.validarDosis(datosFragmentados[0], control);
			retornoArray[1]=this.validarFechaDeNacimiento(datosFragmentados[1], control);
			retornoArray[2]=this.validarFechaDeNacimiento(datosFragmentados[2], control);
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
	

	public Respuesta validarNombre(String nombre,Controller control) {
		return control.getValidatorNombre(nombre);
	}
	public Respuesta validarApellidos(String apellidos,Controller control) {
		return control.getValidatorApellidos(apellidos);
	}
	public Respuesta validarDireccion(String direccion,Controller control) {
		return control.getValidatorDireccion(direccion);
	}
	public Respuesta validarTelefono(String telefono,Controller control) {
		return control.getValidatorTelefono(telefono);
	}
	public Respuesta validarFechaDeNacimiento(String fechaDeNacimiento,Controller control) {
		return control.getValidatorFechaDeNacimiento(fechaDeNacimiento);
	}
	private Respuesta validarDosis(String dosis, Controller control) {
		return control.getValidatorDosis(dosis);
	}

	
}
