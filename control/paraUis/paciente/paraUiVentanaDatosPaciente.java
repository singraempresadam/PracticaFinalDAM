package control.paraUis.paciente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import control.paraUis.ParaUiOperacionRealizada;
import vista.paciente.VentanaDatosPaciente;

public class paraUiVentanaDatosPaciente extends VentanaDatosPaciente {
	String[] ayudante;

	Controller control = new Controller();
	public paraUiVentanaDatosPaciente(String datos) {
		super();
		this.agregarListener();
		ayudante=datos.split("-");
		this.getGetTxtNombre().setText(ayudante[0]);
		this.getGetTxtApellidos().setText(ayudante[1]);
		this.getGetTxtTelefono().setText(ayudante[3]);
		this.getGetTxtDireccion().setText(ayudante[5]);
		this.getGetTxtFechaNacimiento().setText(ayudante[4]);
	}
	private void agregarListener() {
		this.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Modificar");
			}
		});
		this.getBtnEliminar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getControl().eliminarPaciente(ayudante[2]);
				ParaUiOperacionRealizada paraUiOperacionRealizada = new ParaUiOperacionRealizada("Paciente eliminado");
				paraUiOperacionRealizada.setVisible(true);
				paraUiVentanaPaciente paraUiVentanaPaciente = new paraUiVentanaPaciente();
				paraUiVentanaPaciente.setVisible(true);
				dispose();
			}
		});
		this.getBtnHistorial().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaHistorialPaciente paraUiVentanaHistorialPaciente = new ParaUiVentanaHistorialPaciente(ayudante[2]);
				paraUiVentanaHistorialPaciente.setVisible(true);
			}
		});
		this.getBtnSolicitarCita().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaSolicitarCitaPaciente paraUiVentanaSolicitarCitaPaciente = new ParaUiVentanaSolicitarCitaPaciente(ayudante[2]);
				paraUiVentanaSolicitarCitaPaciente.setVisible(true);
			}
		});
		
	}
	public String[] getAyudante() {
		return ayudante;
	}
	public void setAyudante(String[] ayudante) {
		this.ayudante = ayudante;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	

}
