package lecturaYEscritura;

public interface DAOInterface {
	public Object leer(String ruta);
	public boolean grabar(String ruta, Object t);
}
