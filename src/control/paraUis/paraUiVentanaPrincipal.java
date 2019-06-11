package control.paraUis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import control.Controller;
import control.paraUis.cirujano.paraUiVentanaCirujano;
import control.paraUis.medico.paraUiVentanaMedico;
import control.paraUis.paciente.paraUiVentanaPaciente;
import vista.ventanaPrincipal;

public class paraUiVentanaPrincipal extends ventanaPrincipal{
	private Validator validator;
	private Controller control;
	public paraUiVentanaPrincipal ()
	{
		control = new Controller();
		this.validator = new Validator();
		this.getLblFechaYHora().setText(control.fechaYHora());
		crearListeners();
	}

	private void crearListeners() {
		
		this.getBotonPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaPaciente paraUiVentanaPaciente = new paraUiVentanaPaciente(getControl());
				paraUiVentanaPaciente.setVisible(true);
			}
		});
		this.getBotonMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaMedico paraUiVentanaMedico = new paraUiVentanaMedico(getControl());
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
		this.getBtnUnaHora().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.aumentarHora(1);
				getLblFechaYHora().setText(control.fechaYHora());
			}
		});
		this.getBtnTresHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.aumentarHora(3);
				getLblFechaYHora().setText(control.fechaYHora());
			}
		});
		this.getBtnDoceHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.aumentarHora(12);
				getLblFechaYHora().setText(control.fechaYHora());
			}
		});
		this.getBtnVeinticuatroHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.aumentarHora(24);
				getLblFechaYHora().setText(control.fechaYHora());
			}
		});
		this.getBtnUnDia().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				control.aumentarDia(1);
				getLblFechaYHora().setText(control.fechaYHora());
			}
		});
	}
	private Validator getValidator(){
		return this.validator;
	}

	public Controller getControl() {
		return control;
	}

	
}
