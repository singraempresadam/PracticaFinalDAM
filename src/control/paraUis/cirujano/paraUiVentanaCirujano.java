package control.paraUis.cirujano;

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
import vista.cirujano.VentanaCirujano;

public class paraUiVentanaCirujano extends VentanaCirujano{
	private JScrollPane scrollListaCirujano;
	Controller control;
	private JList<String> cirujanos;
	
	public paraUiVentanaCirujano (Controller control, Validator validator)
	{
		super();
		this.setControl(control);
		this.agregarListener();
		
		
		this.setCirujanos(new JList<String>(control.obtenerElementosAMostrarCirujano()));
		
		this.getCirujanos().setVisible(true);
		this.setScrollListaCirujano(new JScrollPane(cirujanos));
		this.getScrollListaCirujano().setBounds(79, 108, 345, 213);
		this.getScrollListaCirujano().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscar().add(this.getScrollListaCirujano());
	}

	private String obtenerIdSeleccionado() {
		try {
			return this.getCirujanos().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un cirujano");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private void agregarListener() {
		this.getBtnConsultarCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (obtenerIdSeleccionado() != "") {
					ParaUiVentanaDatosCirujano paraUiVentanaDatosCirujano = new ParaUiVentanaDatosCirujano(
							obtenerIdSeleccionado(),getControl());
					paraUiVentanaDatosCirujano.setVisible(true);
					dispose();
				}

			}
		});
		this.getBtnBuscarCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getPanelBuscar().setVisible(false);
				getPanelBuscar().remove(getScrollListaCirujano());
				setCirujanos(new JList<String>(getControl().filtrar(getTxtBuscarCirujano().getText(), control.obtenerElementosAMostrarCirujano())));
				setScrollListaCirujano(new JScrollPane(getCirujanos()));
				getScrollListaCirujano().setBounds(79, 108, 345, 213);
				getScrollListaCirujano().setBorder(new LineBorder(new Color(0, 102, 204), 2));
				getPanelBuscar().add(getScrollListaCirujano());
				getPanelBuscar().setVisible(true);
			}
		});
		this.getBtnAnadirCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Validator validator = new Validator();
				String nombre = getTxtNombreCirujano().getText();
				String apellidos = getTxtApellidoCirujano().getText();
				String telefono = getTxtTelefonoCirujano().getText();
				String direccion = getTxtDireccionCirujano().getText();
				String idUnico = control.generarId();
				String total = nombre + "-" + apellidos + "-" + telefono + "-" + direccion;

				//try {
					//if ((validator.validarDatosPaciente(total, getControl())).isResultado()) {
						getControl().darAltaCirujanoNuevo(nombre, apellidos, telefono, direccion, idUnico);
						getTxtNombreCirujano().setText("");
						getTxtApellidoCirujano().setText("");
						getTxtTelefonoCirujano().setText("");
						getTxtDireccionCirujano().setText("");
						crearVentanaOperacionRealizada("Cirujano registrado con exito");
//					}
//				} catch (ExceptionDatos e) {
//					ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e.getMsg());
//					paraUiVentanaError.setVisible(true);
//				}

			}

			private void crearVentanaOperacionRealizada(String mensaje) {
				ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
				paraUiOpereacionRealizada.setVisible(true);
			}
		});
	}


	public JScrollPane getScrollListaCirujano() {
		return scrollListaCirujano;
	}
	
	public Controller getControl() {
		return control;
	}
	
	private void setCirujanos(JList<String> cirujanos) {
		this.cirujanos = cirujanos;	
	}
	
	public JList<String> getCirujanos() {
		return cirujanos;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public void setScrollListaCirujano(JScrollPane scrollListaCirujano) {
		this.scrollListaCirujano = scrollListaCirujano;
	}
}
