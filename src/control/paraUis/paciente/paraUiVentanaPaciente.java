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

public class paraUiVentanaPaciente extends VentanaPaciente {
	private static final long serialVersionUID = -6068763124340799917L;
	private JScrollPane scrollListaPaciente;
	Controller control = new Controller();
	private JList<String> pacientes;

	public paraUiVentanaPaciente() {
		super();
		this.agregarListener();
		this.setPacientes(new JList<String>(control.obtenerElementosAMostrarPaciente()));
		this.getPacientes().getSelectionMode();
		this.getPacientes().setVisible(true);
		this.setScrollListaPaciente(new JScrollPane(pacientes));
		this.getScrollListaPaciente().setBounds(79, 108, 345, 213);
		this.getScrollListaPaciente().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarPaciente().add(this.getScrollListaPaciente());

	}

	private String obtenerIdSeleccionado() {
		try {
			return this.getPacientes().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un paciente");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}

	private void agregarListener() {
		this.getBtnConsultarPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (obtenerIdSeleccionado() != "") {
					paraUiVentanaDatosPaciente paraUiVentanaDatosPaciente = new paraUiVentanaDatosPaciente(
							obtenerIdSeleccionado());
					paraUiVentanaDatosPaciente.setVisible(true);
					dispose();
				}

			}
		});
		this.getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getPanelBuscarPaciente().setVisible(false);
				getPanelBuscarPaciente().remove(getScrollListaPaciente());
				setPacientes(new JList<String>(getControl().filtrar(getGetTxtBuscar().getText(), control.obtenerElementosAMostrarPaciente())));
				setScrollListaPaciente(new JScrollPane(getPacientes()));
				getScrollListaPaciente().setBounds(79, 108, 345, 213);
				getScrollListaPaciente().setBorder(new LineBorder(new Color(0, 102, 204), 2));
				getPanelBuscarPaciente().add(getScrollListaPaciente());
				getPanelBuscarPaciente().setVisible(true);
			}
		});
		this.getBtnAnadir().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Validator validator = new Validator();
				String nombre = getTxtNombre.getText();
				String apellidos = getTxtApellidos.getText();
				String telefono = getTxtTelefono.getText();
				String direccion = getTxtDireccion.getText();
				String idUnico = control.generarId();
				String fechaDeNacimiento = getTxtFechaNacimiento.getText();
				String total = nombre + "-" + apellidos + "-" + telefono + "-" + direccion + "-" + fechaDeNacimiento;

				try {
					if ((validator.validarDatosPaciente(total, getControl())).isResultado()) {
						getControl().darAltaPacienteNuevo(nombre, apellidos, telefono, direccion, idUnico,
								fechaDeNacimiento);
						getGetTxtNombre().setText("");
						getGetTxtApellidos().setText("");
						getGetTxtFechaNacimiento().setText("");
						getGetTxtTelefono().setText("");
						getGetTxtDireccion().setText("");
						crearVentanaOperacionRealizada("Paciente registrado con exito");
					}
				} catch (ExceptionDatos e) {
					ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e.getMsg());
					paraUiVentanaError.setVisible(true);
				}

			}

			private void crearVentanaOperacionRealizada(String mensaje) {
				ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
				paraUiOpereacionRealizada.setVisible(true);
			}
		});
	}

	public JScrollPane getScrollListaPaciente() {
		return scrollListaPaciente;
	}

	public Controller getControl() {
		return control;
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

}