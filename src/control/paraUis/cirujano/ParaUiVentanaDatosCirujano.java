package control.paraUis.cirujano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import control.paraUis.paciente.ParaUiVentanaHistorialPaciente;
import vista.cirujano.VentanaDatosCirujano;

public class ParaUiVentanaDatosCirujano extends VentanaDatosCirujano {
	Controller control = new Controller();
	public ParaUiVentanaDatosCirujano(String datos) {
		super();
		this.agregarListener();
		String[] ayudante;
		ayudante=datos.split("-");
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[4]);
	}
	
	private void agregarListener() {
		this.getBtnHistorialCirujano().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ParaUiVentanaHistorialCirujano paraUiVentanaHistorialCirujano = new ParaUiVentanaHistorialCirujano();
			paraUiVentanaHistorialCirujano.setVisible(true);
			
		}
	});
}}
