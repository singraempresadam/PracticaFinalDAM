package lecturaYEscritura;

public interface DAOInterface {
	public Object leer(String path);
	public boolean grabar(String path, Object t);
}
