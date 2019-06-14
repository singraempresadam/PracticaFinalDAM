package control.paraUis.paciente;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ExceptionDatos;
import control.paraUis.ParaUiOperacionRealizada;
import control.paraUis.ParaUiVentanaError;
import control.paraUis.Validator;
import vista.paciente.VentanaPaciente;

public class ParaUiVentanaPaciente extends VentanaPaciente {
	
	private Controller control;
	private Validator validator;
	private JScrollPane scrollListaPaciente;
	private JList<String> pacientes;
	
	public ParaUiVentanaPaciente(Controller control, Validator validator) {
		super();
		this.setControl(control);
		this.setValidator(validator);
		this.crearListaTodosLosPacientes();
		this.agregarListener();
	}

	private void crearListaTodosLosPacientes() {
		this.setPacientes(new JList<String>(this.getControl().obtenerElementosAMostrarPaciente()));
		this.getPacientes().setVisible(true);
		this.setScrollListaPaciente(new JScrollPane(pacientes));
		this.getScrollListaPaciente().setBounds(79, 108, 345, 213);
		this.getScrollListaPaciente().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarPaciente().add(this.getScrollListaPaciente());
	}
	private void agregarListener() {
		this.eventoConsultarPaciente();
		this.eventoBuscarPaciente();
		this.eventoAniadirPaciente();
	}
	
	private void eventoConsultarPaciente() {
		this.getBtnConsultarPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearVentanaDatosPacientes();
			}
		});
	}
	private void eventoBuscarPaciente() {
		this.getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarPacientes();
			}
		});
	}
	private void eventoAniadirPaciente() {
		this.getBtnAnadir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aniadirPaciente();

			}
		});
	}
	
	private void crearVentanaDatosPacientes() {
		if (obtenerDatosPacienteSeleccionado() != "") {
			ParaUiVentanaDatosPaciente paraUiVentanaDatosPaciente = new ParaUiVentanaDatosPaciente(this.getControl(),this.getValidator(),this.obtenerDatosPacienteSeleccionado());
			paraUiVentanaDatosPaciente.setVisible(true);
			this.buscarPacientes();
		}
	}
	private void buscarPacientes() {
		this.getPanelBuscarPaciente().setVisible(false);
		this.getPanelBuscarPaciente().remove(getScrollListaPaciente());
		this.setPacientes(new JList<String>(getControl().filtrar(this.getTxtBuscarPaciente().getText(), this.getControl().obtenerElementosAMostrarPaciente())));
		this.setScrollListaPaciente(new JScrollPane(this.getPacientes()));
		this.getScrollListaPaciente().setBounds(79, 108, 345, 213);
		this.getScrollListaPaciente().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelBuscarPaciente().add(this.getScrollListaPaciente());
		this.getPanelBuscarPaciente().setVisible(true);
	}
	private void aniadirPaciente() {
		String[] datosFragmentadosPaciente=this.obtenerDatosPaciente();
		try {
			if ((this.getValidator().validarDatosPaciente(datosFragmentadosPaciente, this.getControl())).isResultado()) {
				this.getControl().darAltaPacienteNuevo(datosFragmentadosPaciente[0], datosFragmentadosPaciente[1], datosFragmentadosPaciente[3], 
						datosFragmentadosPaciente[4], datosFragmentadosPaciente[2],datosFragmentadosPaciente[5]);
				this.limpiarCampos();
				this.crearVentanaOperacionRealizada("Paciente registrado con exito");
			}
		} catch (ExceptionDatos e) {
			this.crearVentanaError(e);
		}
	}
	
	private String[] obtenerDatosPaciente() {
		String nombre = this.getTxtNombre().getText();
		String apellidos = this.getTxtApellidos().getText();
		String telefono = this.getTxtTelefono().getText();
		String direccion = this.getTxtDireccion().getText();
		String idUnico = this.getControl().generarId();
		String fechaDeNacimiento = this.getTxtFechaNacimiento().getText();
		String[] total = {nombre , apellidos , idUnico, telefono , direccion , fechaDeNacimiento};
		return total;
	}
	private String obtenerDatosPacienteSeleccionado() {
		try {
			return this.getPacientes().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un paciente");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	
	private void crearVentanaOperacionRealizada(String mensaje) {
		ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
		paraUiOpereacionRealizada.setVisible(true);
	}
	private void crearVentanaError(ExceptionDatos e) {
		ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e.getMsg());
		paraUiVentanaError.setVisible(true);
	}
	private void limpiarCampos() {
		getTxtNombre().setText("");
		getTxtApellidos().setText("");
		getTxtFechaNacimiento().setText("");
		getTxtTelefono().setText("");
		getTxtDireccion().setText("");
	}
	
	//GETTER AND SETTER
	public JScrollPane getScrollListaPaciente() {
		return scrollListaPaciente;
	}

	public Controller getControl() {
		return control;
	}

	public Validator getValidator() {
		return validator;
	}

	public JList<String> getPacientes() {
		return pacientes;
	}

	public void setPacientes(JList<String> pacientes) {
		this.pacientes = pacientes;
	}

	public void setScrollListaPaciente(JScrollPane scrollListaPaciente) {
		this.scrollListaPaciente = scrollListaPaciente;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}