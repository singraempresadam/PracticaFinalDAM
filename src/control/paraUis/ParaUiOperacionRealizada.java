package control.paraUis;

import java.awt.Font;

import javax.swing.SwingConstants;

import vista.VentanaOperacionRealizada;

public class ParaUiOperacionRealizada extends VentanaOperacionRealizada{
	public ParaUiOperacionRealizada(String mensaje) {
		super();
		this.getLblInfo().setText(mensaje);
		this.getLblInfo().setHorizontalAlignment(SwingConstants.CENTER);
		this.getLblInfo().setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
