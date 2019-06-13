package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;

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

	private static final long serialVersionUID = -3465405400822331219L;
	private JScrollPane scrollListaMedico;
	private JScrollPane scrollListaMedicoEspecialista;
	private JScrollPane scrollListaMedicoAtencionPrimaria;
	Controller control;
	private JList<String> medicos;
	private JList<String> medicosEspecialistas;
	private JList<String> medicosAtencionPrimaria;

	@SuppressWarnings("unchecked")
	public paraUiVentanaMedico(Controller control, Validator validator) {
		super();
		this.setControl(control);
		
		this.agregarListener();
		this.crearListaTodosLosMedicos();
		this.crearListaTodosLosMedicosAtencionPrimaria();
		this.crearListaTodosLosMedicosEspecialistas();
		Especialidad[] values = Especialidad.values();
		for (int i = 0; i < values.length; i++) {
			this.getComboBoxEspecialidad().addItem(values[i]);
		}
		this.getComboBoxTurnoMedicoAP().addItem("Mañana");
		this.getComboBoxTurnoMedicoAP().addItem("Tarde");
		
		this.getComboBoxTurnoEspecialista().addItem("10");
		this.getComboBoxTurnoEspecialista().addItem("12");
		this.getComboBoxTurnoEspecialista().addItem("16");
		this.getComboBoxTurnoEspecialista().addItem("18");
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
		getPanelAnadirMedicoEspecialista().add(this.getScrollListaMedicoEspecialista());
	}
	private void crearListaTodosLosMedicosAtencionPrimaria() {
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		this.setMedicosAtencionPrimaria(new JList<String>(filtrarSin));
		this.getMedicosAtencionPrimaria().setVisible(true);
		this.setScrollListaMedicoAtencionPrimaria(new JScrollPane(this.getMedicosAtencionPrimaria()));
		this.getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		this.getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAnadirMedicoAP().add(this.getScrollListaMedicoAtencionPrimaria());
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
		this.getBtnAnadirEspecialista().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aniadirMedicoEspecialista();
			}

		});
		this.getBtnAnadirAtencionPrimaria().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aniadirMedicoAtencionPrimaria();
			}

		});
	}
	private void consultarMedico() {
		ParaUiVentanaDatosMedico paraUiVentanaDatosMedico = new ParaUiVentanaDatosMedico(obtenerIdSeleccionado(), this.getControl());
		paraUiVentanaDatosMedico.setVisible(true);
	}
	private void buscarMedico() {
		getPanelBuscarMedico().setVisible(false);
		getPanelBuscarMedico().remove(getScrollListaMedico());
		setMedicos(new JList<String>(getControl().filtrar(getTxtBuscarMedico().getText(), getControl().obtenerTodosLosMedicos())));
		setScrollListaMedico(new JScrollPane(getMedicos()));
		getScrollListaMedico().setBounds(79, 108, 345, 213);
		getScrollListaMedico().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarMedico().add(getScrollListaMedico());
		getPanelBuscarMedico().setVisible(true);
	}
	private void buscarMedicoEspecialista() {
		getPanelAnadirMedicoEspecialista().setVisible(false);
		getPanelAnadirMedicoEspecialista().remove(getScrollListaMedicoEspecialista());
		String[] filtrar = this.getControl().filtrarSin("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		setMedicosEspecialistas(new JList<String>(getControl().filtrar(getTxtNombreEspecialista().getText(), filtrarSin)));
		setScrollListaMedicoEspecialista(new JScrollPane(getMedicosEspecialistas()));
		getScrollListaMedicoEspecialista().setBounds(79, 108, 345, 213);
		getScrollListaMedicoEspecialista().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAnadirMedicoEspecialista().add(getScrollListaMedicoEspecialista());
		getPanelAnadirMedicoEspecialista().setVisible(true);
	}
	private void buscarMedicoAtencionPrimaria() {
		getPanelAnadirMedicoAP().setVisible(false);
		getPanelAnadirMedicoAP().remove(getScrollListaMedicoAtencionPrimaria());
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		setMedicosAtencionPrimaria(new JList<String>(getControl().filtrar(getTxtNombreMedicoAP().getText(), filtrarSin)));
		setScrollListaMedicoAtencionPrimaria(new JScrollPane(getMedicosAtencionPrimaria()));
		getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAnadirMedicoAP().add(getScrollListaMedicoAtencionPrimaria());
		getPanelAnadirMedicoAP().setVisible(true);
	}
	private void aniadirMedico() {
		Validator validator = new Validator();
		String nombre = getTxtNombreMedico().getText();
		String apellidos = getTxtApellidosMedico().getText();
		String telefono = getTxtTelefonoMedico().getText();
		String direccion = getTxtDireccionMedico().getText();
		Especialidad especialidad = (Especialidad) getComboBoxEspecialidad().getSelectedItem();
		String idUnico = control.generarId();
		String total = nombre + "-" + apellidos + "-" + telefono + "-" + direccion;

		try {
			if (validator.validarDatosMedico(total, getControl()).isResultado()) {
				getControl().darAltaMedicoNuevo(nombre, apellidos, telefono, direccion, idUnico, especialidad);
				getTxtNombreMedico().setText("");
				getTxtApellidosMedico().setText("");
				getTxtTelefonoMedico().setText("");
				getTxtDireccionMedico().setText("");
				crearVentanaOperacionRealizada("Medico registrado con exito");
				buscarMedico();
			}
		} catch (ExceptionDatos e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e.getMsg());
			paraUiVentanaError.setVisible(true);
		}
	}
	private void aniadirMedicoAtencionPrimaria()
	{
		String medico=this.getMedicosAtencionPrimaria().getSelectedValuesList().get(0);
		boolean[] dias= {true,true,true,true,true};
		
		int hora;
		if(this.getComboBoxTurnoMedicoAP().getSelectedItem().toString() == "mañana")
			hora=10;
		else hora=16;
		LocalTime horaInicio= LocalTime.of(hora, 0);
		LocalTime horaFin = horaInicio.plusHours(4);
		String[] fragmentarDatos = medico.split("-");
		control.darAltaMedicoActivoNuevo(fragmentarDatos[0], fragmentarDatos[1], fragmentarDatos[3], fragmentarDatos[4]
				, fragmentarDatos[2],Especialidad.valueOf(fragmentarDatos[5]), horaInicio, horaFin, dias,"1");
	
	}
	private void aniadirMedicoEspecialista() {
		String medico=this.getMedicosEspecialistas().getSelectedValuesList().get(0);
		boolean[] dias= {true,false,true,false,true};
		if(this.getCheckLMV().getState()) {
			for (int i = 0; i < dias.length; i++) {
				if(i%2==0) dias[i]=true;
				else dias[i]=false;
			}
		}
		if(this.getCheckMJ().getState()) {
			for (int i = 0; i < dias.length; i++) {
				if(i%2!=0) dias[i]=true;
				else dias[i]=false;
			}
		}
		LocalTime horaInicio= LocalTime.of(Integer.valueOf(this.getComboBoxTurnoEspecialista().getSelectedItem().toString()), 0);
		LocalTime horaFin = horaInicio.plusHours(2);
		String[] fragmentarDatos = medico.split("-");
		control.darAltaMedicoActivoNuevo(fragmentarDatos[0], fragmentarDatos[1], fragmentarDatos[3], fragmentarDatos[4]
				, fragmentarDatos[2],Especialidad.valueOf(fragmentarDatos[5]), horaInicio, horaFin, dias,"1");
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
