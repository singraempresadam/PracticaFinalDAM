package control.paraUis.cirujano;

import control.Controller;
import vista.cirujano.VentanaDatosCirujano;

public class ParaUiVentanaDatosCirujano extends VentanaDatosCirujano {
	Controller control = new Controller();
	public ParaUiVentanaDatosCirujano(String datos) {
		String[] ayudante;
		ayudante=datos.split("-");
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[4]);
	}

}
