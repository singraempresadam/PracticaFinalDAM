package control.paraUis.medico;

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
import control.paraUis.TestParaUI;
import control.paraUis.Validator;
import modelo.enumeraciones.Especialidad;
import vista.medico.VentanaMedico;

public class paraUiVentanaMedico extends VentanaMedico {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3465405400822331219L;
	private JScrollPane scrollListaMedico;
	private JScrollPane scrollListaMedicoEspecialista;
	private JScrollPane scrollListaMedicoAtencionPrimaria;
	TestParaUI test = new TestParaUI();
	Controller control = new Controller();
	private JList<String> medicos;
	private JList<String> medicosEspecialistas;
	private JList<String> medicosAtencionPrimaria;

	@SuppressWarnings("unchecked")
	public paraUiVentanaMedico() {
		super();
		this.agregarListener();
		this.crearListaTodosLosMedicos();
		this.crearListaTodosLosMedicosAtencionPrimaria();
		this.crearListaTodosLosMedicosEspecialistas();
		Especialidad[] values = Especialidad.values();
		for (int i = 0; i < values.length; i++) {
			this.getComboBoxEspecialidad().addItem(values[i]);
		}
	}

	private void crearListaTodosLosMedicos() {
		this.setMedicos(new JList<String>(this.getControl().obtenerTodosLosMedicos()));
		this.getMedicos().setVisible(true);
		this.setScrollListaMedico(new JScrollPane(this.getMedicos()));
		this.getScrollListaMedico().setBounds(79, 108, 345, 213);
		this.getScrollListaMedico().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarMedico().add(this.getScrollListaMedico());
	}
	private void crearListaTodosLosMedicosEspecialistas() {
		this.setMedicosEspecialistas(new JList<String>(this.getControl().filtrarSin("Activo",this.getControl().filtrarSin("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos()))));
		this.getMedicosEspecialistas().setVisible(true);
		this.setScrollListaMedicoEspecialista(new JScrollPane(this.getMedicosEspecialistas()));
		this.getScrollListaMedicoEspecialista().setBounds(79, 108, 345, 213);
		this.getScrollListaMedicoEspecialista().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAñadirMedicoEspecialista().add(this.getScrollListaMedicoEspecialista());
	}
	private void crearListaTodosLosMedicosAtencionPrimaria() {
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		this.setMedicosAtencionPrimaria(new JList<String>(filtrarSin));
		this.getMedicosAtencionPrimaria().setVisible(true);
		this.setScrollListaMedicoAtencionPrimaria(new JScrollPane(this.getMedicosAtencionPrimaria()));
		this.getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		this.getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAñadirMedicoAP().add(this.getScrollListaMedicoAtencionPrimaria());
	}

	private String obtenerIdSeleccionado() {
		try {
			return this.getMedicos().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}

	private void agregarListener() {
		// TODO Auto-generated method stub
		this.getBtnConsultarMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				consultarMedico();
			}
		});
		this.getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarMedico();
			}
		});
		this.getBtnBuscarMedicoAP().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarMedicoAtencionPrimaria();
			}
		});
		this.getBtnBuscarEspecialista().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarMedicoEspecialista();
			}
		});
		this.getBtnAnadirMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aniadirMedico();
			}	
		});
		

	}
	private void consultarMedico() {
		ParaUiVentanaDatosMedico paraUiVentanaDatosMedico = new ParaUiVentanaDatosMedico(obtenerIdSeleccionado());
		paraUiVentanaDatosMedico.setVisible(true);
	}
	private void buscarMedico() {
		getPanelBuscarMedico().setVisible(false);
		getPanelBuscarMedico().remove(getScrollListaMedico());
		setMedicos(new JList<String>(getControl().filtrar(getTxtgetNombre().getText(), getControl().obtenerTodosLosMedicos())));
		setScrollListaMedico(new JScrollPane(getMedicos()));
		getScrollListaMedico().setBounds(79, 108, 345, 213);
		getScrollListaMedico().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarMedico().add(getScrollListaMedico());
		getPanelBuscarMedico().setVisible(true);
	}
	private void buscarMedicoEspecialista() {
		getPanelAñadirMedicoEspecialista().setVisible(false);
		getPanelAñadirMedicoEspecialista().remove(getScrollListaMedicoEspecialista());
		String[] filtrar = this.getControl().filtrarSin("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		setMedicosEspecialistas(new JList<String>(getControl().filtrar(getTxtNombreEspecialista().getText(), filtrarSin)));
		setScrollListaMedicoEspecialista(new JScrollPane(getMedicosEspecialistas()));
		getScrollListaMedicoEspecialista().setBounds(79, 108, 345, 213);
		getScrollListaMedicoEspecialista().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAñadirMedicoEspecialista().add(getScrollListaMedicoEspecialista());
		getPanelAñadirMedicoEspecialista().setVisible(true);
	}
	private void buscarMedicoAtencionPrimaria() {
		getPanelAñadirMedicoAP().setVisible(false);
		getPanelAñadirMedicoAP().remove(getScrollListaMedicoAtencionPrimaria());
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		setMedicosAtencionPrimaria(new JList<String>(getControl().filtrar(getTxtNombreMedicoAP().getText(), filtrarSin)));
		setScrollListaMedicoAtencionPrimaria(new JScrollPane(getMedicosAtencionPrimaria()));
		getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAñadirMedicoAP().add(getScrollListaMedicoAtencionPrimaria());
		getPanelAñadirMedicoAP().setVisible(true);
	}
	private void aniadirMedico() {
		Validator validator = new Validator();
		String nombre = getGetTxtNombreMedico().getText();
		String apellidos = getGetTxtApellidosMedico().getText();
		String telefono = getGetTxtTelefonoMedico().getText();
		String direccion = getGetTxtDireccionMedico().getText();
		Especialidad especialidad = (Especialidad) getComboBoxEspecialidad().getSelectedItem();
		String idUnico = control.generarId();
		String total = nombre + "-" + apellidos + "-" + telefono + "-" + direccion;

		try {
			if (validator.validarDatosMedico(total, getControl()).isResultado()) {
				getControl().darAltaMedicoNuevo(nombre, apellidos, telefono, direccion, idUnico, especialidad);
				getGetTxtNombreMedico().setText("");
				getGetTxtApellidosMedico().setText("");
				getGetTxtTelefonoMedico().setText("");
				getGetTxtDireccionMedico().setText("");
				crearVentanaOperacionRealizada("Medico registrado con exito");
				buscarMedico();
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
	public JScrollPane getScrollListaMedico() {
		return scrollListaMedico;
	}

	public void setScrollListaMedico(JScrollPane scrollListaMedico) {
		this.scrollListaMedico = scrollListaMedico;
	}

	public JList<String> getMedicos() {
		return medicos;
	}

	public JList<String> getMedicosEspecialistas() {
		return medicosEspecialistas;
	}

	public void setMedicosEspecialistas(JList<String> medicosEspecialistas) {
		this.medicosEspecialistas = medicosEspecialistas;
	}

	public JList<String> getMedicosAtencionPrimaria() {
		return medicosAtencionPrimaria;
	}

	public void setMedicosAtencionPrimaria(JList<String> medicosAtencionPrimaria) {
		this.medicosAtencionPrimaria = medicosAtencionPrimaria;
	}

	public void setMedicos(JList<String> medicos) {
		this.medicos = medicos;
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public JScrollPane getScrollListaMedicoEspecialista() {
		return scrollListaMedicoEspecialista;
	}

	public void setScrollListaMedicoEspecialista(JScrollPane scrollListaMedicoEspecialista) {
		this.scrollListaMedicoEspecialista = scrollListaMedicoEspecialista;
	}

	public JScrollPane getScrollListaMedicoAtencionPrimaria() {
		return scrollListaMedicoAtencionPrimaria;
	}

	public void setScrollListaMedicoAtencionPrimaria(JScrollPane scrollListaMedicoAtencionPrimaria) {
		this.scrollListaMedicoAtencionPrimaria = scrollListaMedicoAtencionPrimaria;
	}
	
}
