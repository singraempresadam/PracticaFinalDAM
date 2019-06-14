package control;

import java.awt.EventQueue;

import control.paraUis.paraUiVentanaPrincipal;
import vista.ventanaPrincipal;

public class Principal {
	/*
	 * 
	 * 		Antes nos pedían y no hacíamos.
	 * 		Ahora nos piden la mitad y damos el doble. 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paraUiVentanaPrincipal frame = new paraUiVentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
