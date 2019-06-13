package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiOperacionRealizada;
import vista.paciente.VentanaDatosPaciente;

public class paraUiVentanaDatosPaciente extends VentanaDatosPaciente {
	
	private Controller control;
	private String[] ayudante;
	private boolean modificar;
	private String idPaciente;
	
	public paraUiVentanaDatosPaciente(Controller control, String datos) {
		super();
		this.setControl(control);
		this.setModificar(true);
		rellenarCamposDatosPaciente(datos);
		this.agregarListener();
	}
	
	private void rellenarCamposDatosPaciente(String datos) {
		ayudante=datos.split("-");
		this.setIdPaciente(ayudante[2]);
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[5]);
		this.getTxtFechaNacimiento().setText(ayudante[4]);
	}
	private void agregarListener() {
		this.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comprobarModificar();
			}
		});
		this.getBtnEliminar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarPaciente();
			}
		});
		this.getBtnHistorial().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirVentanaHistorialPaciente();
			}
		});
		this.getBtnSolicitarCita().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				solicitarCita();
			}
		});
	}
	
	private void comprobarModificar() {
		if(this.isModificar())
			this.modificarTrue();
		else
			this.modificarFalse();
	}
	private void modificarFalse() {
		this.getTxtTelefono().setEditable(false);
		this.getTxtTelefono().setBorder(new LineBorder(Color.BLUE, 1, true));
		this.getTxtDireccion().setEditable(false);
		this.getTxtDireccion().setBorder(new LineBorder(Color.BLUE, 1, true));
		this.getControl().modificarPaciente(this.getIdPaciente(),this.getTxtTelefono().getText(),this.getTxtDireccion().getText());
		this.setModificar(true);
	}
	private void modificarTrue() {
		this.getTxtTelefono().setEditable(true);
		this.getTxtTelefono().setBorder(new LineBorder(Color.RED, 1, true));
		this.getTxtDireccion().setEditable(true);
		this.getTxtDireccion().setBorder(new LineBorder(Color.RED, 1, true));
		this.setModificar(false);
	}
	private void eliminarPaciente() {
		this.getControl().eliminarPaciente(ayudante[2]);
		ParaUiOperacionRealizada paraUiOperacionRealizada = new ParaUiOperacionRealizada("Paciente eliminado");
		paraUiOperacionRealizada.setVisible(true);
		this.dispose();
	}
	private void abrirVentanaHistorialPaciente() {
		ParaUiVentanaHistorialPaciente paraUiVentanaHistorialPaciente = new ParaUiVentanaHistorialPaciente(ayudante[2], getControl());
		paraUiVentanaHistorialPaciente.setVisible(true);
	}
	private void solicitarCita() {
		ParaUiVentanaSolicitarCitaPaciente paraUiVentanaSolicitarCitaPaciente = new ParaUiVentanaSolicitarCitaPaciente(getControl(),ayudante[2]);
		paraUiVentanaSolicitarCitaPaciente.setVisible(true);
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
	public boolean isModificar() {
		return modificar;
	}
	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
}
