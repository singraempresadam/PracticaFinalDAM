package control.paraUis.paciente;

import vista.paciente.VentanaDatosPaciente;

public class paraUiVentanaDatosPaciente extends VentanaDatosPaciente {
	String[] ayudante;
	public paraUiVentanaDatosPaciente(String datos) {
		ayudante=datos.split("-");
		this.getGetTxtNombre().setText(ayudante[0]);
		this.getGetTxtApellidos().setText(ayudante[1]);
		this.getGetTxtTelefono().setText(ayudante[3]);
		this.getGetTxtDireccion().setText(ayudante[5]);
		this.getGetTxtFechaNacimiento().setText(ayudante[4]);
	}

}
