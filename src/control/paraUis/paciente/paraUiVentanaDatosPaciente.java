package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ParaUiOperacionRealizada;
import control.paraUis.ParaUiVentanaError;
import control.paraUis.Validator;
import vista.paciente.VentanaDatosPaciente;

public class paraUiVentanaDatosPaciente extends VentanaDatosPaciente {
	
	private Controller control;
	private Validator validator;
	private String[] ayudante;
	private boolean modificar;
	private String idPaciente;
	
	public paraUiVentanaDatosPaciente(Controller control, Validator validator, String datos) {
		super();
		this.setControl(control);
		this.setValidator(validator);
		this.setModificar(true);
		rellenarCamposDatosPaciente(datos);
		this.agregarListener();
	}
	
	private void rellenarCamposDatosPaciente(String datos) {
		this.setAyudante(datos.split("-"));
		this.setIdPaciente(this.getAyudante()[2]);
		this.getTxtNombre().setText(this.getAyudante()[0]);
		this.getTxtApellidos().setText(this.getAyudante()[1]);
		this.getTxtTelefono().setText(this.getAyudante()[3]);
		this.getTxtDireccion().setText(this.getAyudante()[4]);
		this.getTxtFechaNacimiento().setText(this.getAyudante()[5]);
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
		comprobarPaciente();
		this.setModificar(true);
	}
	private void comprobarPaciente() {
		String telefono=this.getTxtTelefono().getText();
		String direccion=this.getTxtDireccion().getText();
		boolean telefonoValido=this.getValidator().validarTelefono(telefono, this.getControl()).isResultado();
		boolean direccionValida=this.getValidator().validarDireccion(direccion, this.getControl()).isResultado();
		if(telefonoValido && direccionValida){
			this.getControl().modificarPaciente(this.getIdPaciente(),this.getTxtTelefono().getText(),this.getTxtDireccion().getText());
			this.crearVentanaOperacionRealizada("Modificacion realizada con exito");
		}	
		else
			this.crearVentanaError("Alguno de los campos a modificar no es valido");
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
	private void crearVentanaOperacionRealizada(String mensaje) {
		ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
		paraUiOpereacionRealizada.setVisible(true);
	}
	private void crearVentanaError(String e) {
		ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e);
		paraUiVentanaError.setVisible(true);
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

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
