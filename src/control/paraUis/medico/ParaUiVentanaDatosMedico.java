package control.paraUis.medico;

import vista.medico.VentanaDatosMedico;

public class ParaUiVentanaDatosMedico extends VentanaDatosMedico{

	public ParaUiVentanaDatosMedico(String datos) {
		String[] ayudante;
		ayudante=datos.split("-");
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[4]);
		this.getTxtEspecialidad().setText(ayudante[5]);
	}

}
