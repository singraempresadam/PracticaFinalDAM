package control.paraUis.medico;

import vista.medico.VentanaDatosMedico;

public class ParaUiVentanaDatosMedico extends VentanaDatosMedico{

	public ParaUiVentanaDatosMedico(String datos) {
		String[] ayudante;
		ayudante=datos.split("-");
		this.setTxtNombre.setText(ayudante[0]);
		this.setTxtApellidos.setText(ayudante[1]);
		this.setTxtTelefono.setText(ayudante[3]);
		this.setTxtDireccion.setText(ayudante[4]);
		this.setTxtEspecialidad.setText(ayudante[5]);
	}

}
