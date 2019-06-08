package control.paraUis;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import vista.VentanaError;

public class ParaUiVentanaError extends VentanaError{
	public ParaUiVentanaError(String error) {
		super();
		getLblInfo().setText(error);
		getLblInfo().setHorizontalAlignment(SwingConstants.CENTER);
		getLblInfo().setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
