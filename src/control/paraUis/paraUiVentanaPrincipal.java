package control.paraUis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import vista.ventanaPrincipal;

public class paraUiVentanaPrincipal extends ventanaPrincipal{
	private Validator validator;
	
	public paraUiVentanaPrincipal ()
	{
		this.validator = new Validator();
		crearListeners();
	}

	private void crearListeners() {
		
		this.getBotonPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaPaciente paraUiVentanaPaciente = new paraUiVentanaPaciente();
				paraUiVentanaPaciente.setVisible(true);
			}
		});
		this.getBotonMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaMedico paraUiVentanaMedico = new paraUiVentanaMedico();
				paraUiVentanaMedico.setVisible(true);
			}
		});
		this.getBotonCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaCirujano paraUiVentanaCirujano = new paraUiVentanaCirujano();
				paraUiVentanaCirujano.setVisible(true);
			}
		});
	}
	private Validator getValidator(){
		return this.validator;
	}
	
}
