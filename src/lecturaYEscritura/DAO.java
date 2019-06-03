package lecturaYEscritura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAO implements DAOInterface {

	private FileInputStream abrir(String ruta) {
		File file = new File(ruta);
		assert file.exists();
		FileInputStream flujoR = null;
		try {
			flujoR = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flujoR;
	}

	public Object leer(String ruta) {
		Object objeto = null;
		FileInputStream flujoR = abrir(ruta);
		if (flujoR != null) {
			try {
				ObjectInputStream adaptador = new ObjectInputStream(flujoR);
				objeto = (Object) adaptador.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				flujoR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return objeto;
	}

	private FileOutputStream abrir(String ruta, boolean anadir) {
		FileOutputStream flujoW = null;
		File file = new File(ruta);
		try {
			flujoW = new FileOutputStream(file,anadir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flujoW;
	}

	public boolean grabar(String ruta, Object object) {
		assert ruta != null && object != null;
		File file = new File(ruta);
		boolean retorno = true;
		FileOutputStream flujoW = abrir(ruta, false);
		ObjectOutputStream adaptador = null;
		try {
			adaptador = new ObjectOutputStream(flujoW);
			adaptador.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
			retorno = false;
		}
		try {
			flujoW.close();
		} catch (IOException e) {
			e.printStackTrace();
			retorno= false;
		}
		return retorno;
	}
}
