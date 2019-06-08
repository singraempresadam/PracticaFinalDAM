package control.paraUis.medico;

import vista.medico.VentanaDatosMedico;

public class ParaUiVentanaDatosMedico extends VentanaDatosMedico{

	public ParaUiVentanaDatosMedico(String datos) {
		String[] ayudante;
		ayudante=datos.split("-");
		this.txtNombre.setText(ayudante[0]);
		this.txtApellidos.setText(ayudante[1]);
		this.txtTelefono.setText(ayudante[3]);
		this.txtDireccion.setText(ayudante[5]);
		this.txtEspecialidad.setText(ayudante[4]);
	}

}
