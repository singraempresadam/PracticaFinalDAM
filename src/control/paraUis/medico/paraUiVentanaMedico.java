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
import modelo.enumeraciones.Turno;
import vista.medico.VentanaMedico;

public class paraUiVentanaMedico extends VentanaMedico {


	private Controller control;
	private Validator validator;
	private JScrollPane scrollListaMedico;
	private JScrollPane scrollListaMedicoEspecialista;
	private JScrollPane scrollListaMedicoAtencionPrimaria;
	private JList<String> medicos;
	private JList<String> medicosEspecialistas;
	private JList<String> medicosAtencionPrimaria;

	public paraUiVentanaMedico(Controller control, Validator validator) {
		super();
		this.setControl(control);
		this.setValidator(validator);
		
		for (int i = 0; i < this.getControl().obtenerEspecialidades().length; i++) {
			this.getComboBoxEspecialidad().addItem(this.getControl().obtenerEspecialidades()[i]);
		}
		for (int i = 0; i < this.getControl().obtenerTurno().length; i++) {
			this.getComboBoxTurnoMedicoAP().addItem(this.getControl().obtenerTurno()[i]);
		}
		for (int i = 10; i < 19; i+=2) {
			this.getComboBoxTurnoEspecialista().addItem(String.valueOf(i));
		}

		this.crearListaTodosLosMedicos();
		this.crearListaTodosLosMedicosAtencionPrimaria();
		this.crearListaTodosLosMedicosEspecialistas();
		
		this.agregarListener();
	}

	private void crearListaTodosLosMedicos() {
		this.setMedicos(new JList<String>(this.getControl().obtenerTodosLosMedicos()));
		this.getMedicos().setVisible(true);
		this.setScrollListaMedico(new JScrollPane(this.getMedicos()));
		this.getScrollListaMedico().setBounds(79, 108, 345, 213);
		this.getScrollListaMedico().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelBuscarMedico().add(this.getScrollListaMedico());
	}
	private void crearListaTodosLosMedicosEspecialistas() {
		this.setMedicosEspecialistas(new JList<String>(this.getControl().filtrarSin("Activo",this.getControl().filtrarSin("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos()))));
		this.getMedicosEspecialistas().setVisible(true);
		this.setScrollListaMedicoEspecialista(new JScrollPane(this.getMedicosEspecialistas()));
		this.getScrollListaMedicoEspecialista().setBounds(79, 108, 345, 213);
		this.getScrollListaMedicoEspecialista().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelAnadirMedicoEspecialista().add(this.getScrollListaMedicoEspecialista());
	}
	private void crearListaTodosLosMedicosAtencionPrimaria() {
		String[] filtrar = this.getControl().filtrar("Atencion_Primaria", this.getControl().obtenerTodosLosMedicos());
		String[] filtrarSin = this.getControl().filtrarSin("Activo",filtrar);
		this.setMedicosAtencionPrimaria(new JList<String>(filtrarSin));
		this.getMedicosAtencionPrimaria().setVisible(true);
		this.setScrollListaMedicoAtencionPrimaria(new JScrollPane(this.getMedicosAtencionPrimaria()));
		this.getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		this.getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		this.getPanelAnadirMedicoAP().add(this.getScrollListaMedicoAtencionPrimaria());
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
		ParaUiVentanaDatosMedico paraUiVentanaDatosMedico = new ParaUiVentanaDatosMedico(obtenerDatosMedicoSeleccionado(), this.getControl());
		paraUiVentanaDatosMedico.setVisible(true);
	}
	private void buscarMedico() {
		getPanelBuscarMedico().setVisible(false);
		getPanelBuscarMedico().remove(getScrollListaMedico());
		
		String[] todosLosMedicos=this.getControl().obtenerTodosLosMedicos();
		String filtro = this.getTxtBuscarMedico().getText();
		setMedicos(new JList<String>(getControl().filtrar(filtro, todosLosMedicos)));
		setScrollListaMedico(new JScrollPane(getMedicos()));
		getScrollListaMedico().setBounds(79, 108, 345, 213);
		getScrollListaMedico().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarMedico().add(getScrollListaMedico());
		getPanelBuscarMedico().setVisible(true);
	}
	private void buscarMedicoAtencionPrimaria() {
		getPanelAnadirMedicoAP().setVisible(false);
		getPanelAnadirMedicoAP().remove(getScrollListaMedicoAtencionPrimaria());
		String [] todosLosMedicosAP=this.getControl().obtenerTodosLosMedicosInactivosAtencionPrimaria();
		String filtro= this.getTxtNombreMedicoAP().getText();
		setMedicosAtencionPrimaria(new JList<String>(getControl().filtrar(filtro, todosLosMedicosAP)));
		setScrollListaMedicoAtencionPrimaria(new JScrollPane(getMedicosAtencionPrimaria()));
		getScrollListaMedicoAtencionPrimaria().setBounds(79, 108, 345, 213);
		getScrollListaMedicoAtencionPrimaria().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAnadirMedicoAP().add(getScrollListaMedicoAtencionPrimaria());
		getPanelAnadirMedicoAP().setVisible(true);
	}
	private void buscarMedicoEspecialista() {
		getPanelAnadirMedicoEspecialista().setVisible(false);
		getPanelAnadirMedicoEspecialista().remove(getScrollListaMedicoEspecialista());
		String [] todosLosMedicosEspecialistas=this.getControl().obtenerTodosLosMedicosInactivosEspecialistas();
		String filtro= this.getTxtNombreMedicoAP().getText();
		setMedicosEspecialistas(new JList<String>(getControl().filtrar(filtro, todosLosMedicosEspecialistas)));
		setScrollListaMedicoEspecialista(new JScrollPane(getMedicosEspecialistas()));
		getScrollListaMedicoEspecialista().setBounds(79, 108, 345, 213);
		getScrollListaMedicoEspecialista().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelAnadirMedicoEspecialista().add(getScrollListaMedicoEspecialista());
		getPanelAnadirMedicoEspecialista().setVisible(true);
	}
	
	private String[] obtenerDatosMedico() {
		String nombre = getTxtNombreMedico().getText();
		String apellidos = getTxtApellidosMedico().getText();
		String telefono = getTxtTelefonoMedico().getText();
		String direccion = getTxtDireccionMedico().getText();
		String idUnico = this.getControl().generarId();
		String[] total = {nombre , apellidos , idUnico, telefono , direccion};
		return total;
	}
	private String obtenerDatosMedicoSeleccionado() {
		try {
			return this.getMedicos().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private boolean ambosCheckMarcados() {
		return this.getCheckLMV().getState() && this.getCheckMJ().getState();
	}
	private boolean algunCheckMarcado() {
		return this.getCheckLMV().getState() || this.getCheckMJ().getState();
	}
	private String obtenerDatosMedicoAtencionPrimariaSeleccionado() {
		try {
			return this.getMedicosAtencionPrimaria().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico AP");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private String obtenerDatosMedicoEspecialistaSeleccionado() {
		try {
			return this.getMedicosEspecialistas().getSelectedValuesList().get(0);
		} catch (IndexOutOfBoundsException e) {
			ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError("Selecciona un medico Especialista");
			paraUiVentanaError.setVisible(true);
		}
		return "";
	}
	private boolean[] obtenerDias() {
		boolean[] dias= new boolean [5];
		if(algunCheckMarcado() && !ambosCheckMarcados())
		{
			if(this.getCheckLMV().getState()) 
				for (int i = 0; i < dias.length; i++) 
					if(i%2==0) dias[i]=true;
					else dias[i]=false;
				
			if(this.getCheckMJ().getState()) 
				for (int i = 0; i < dias.length; i++) 
					if(i%2!=0) dias[i]=true;
					else dias[i]=false;
		}
		else
			crearVentanaError("Seleccione algún día");
		return dias;
	}

	private void aniadirMedico() {
		String[] datosFragmentadosMedico=this.obtenerDatosMedico();

		try {
			if (this.getValidator().validarDatosMedico(datosFragmentadosMedico, getControl()).isResultado()) {
				getControl().darAltaMedicoNuevo(datosFragmentadosMedico[0], datosFragmentadosMedico[1], 
						datosFragmentadosMedico[2], datosFragmentadosMedico[3], datosFragmentadosMedico[4], 
						(Especialidad) getComboBoxEspecialidad().getSelectedItem());
				this.limpiarCampos();
				this.crearVentanaOperacionRealizada("Medico registrado con exito");
				this.buscarMedico();
			}
		} catch (ExceptionDatos e) {
			crearVentanaError(e);
		}
	}
	private void aniadirMedicoAtencionPrimaria()
	{
		String medico=this.obtenerDatosMedicoAtencionPrimariaSeleccionado();
		boolean[] dias= {true,true,true,true,true};
		int hora=((Turno)this.getComboBoxTurnoMedicoAP().getSelectedItem()).getHora();
		LocalTime horaInicio= LocalTime.of(hora, 0);
		LocalTime horaFin = horaInicio.plusHours(4);
		String[] fragmentarDatos = medico.split("-");
		this.getControl().darAltaMedicoActivoNuevo(fragmentarDatos[0], fragmentarDatos[1], fragmentarDatos[3], fragmentarDatos[4]
				, fragmentarDatos[2],Especialidad.valueOf(fragmentarDatos[5]), horaInicio, horaFin, dias,"1");
		this.crearVentanaOperacionRealizada("Medico atencion primaria dado de alta");
		this.buscarMedicoAtencionPrimaria();
	}
	private void aniadirMedicoEspecialista() {
		String medico=this.obtenerDatosMedicoEspecialistaSeleccionado();
		boolean[] dias = obtenerDias();
		if(dias != null)
		{
			LocalTime horaInicio= LocalTime.of(Integer.valueOf(this.getComboBoxTurnoEspecialista().getSelectedItem().toString()), 0);
			LocalTime horaFin = horaInicio.plusHours(2);
			String[] fragmentarDatos = medico.split("-");
			this.getControl().darAltaMedicoActivoNuevo(fragmentarDatos[0], fragmentarDatos[1], fragmentarDatos[3], fragmentarDatos[4]
					, fragmentarDatos[2],Especialidad.valueOf(fragmentarDatos[5]), horaInicio, horaFin, dias,"1");
			this.crearVentanaOperacionRealizada("Medico especialista dado de alta");
			this.buscarMedicoEspecialista();
		}
	}
	
	private void crearVentanaOperacionRealizada(String mensaje) {
		ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
		paraUiOpereacionRealizada.setVisible(true);
	}
	private void crearVentanaError(ExceptionDatos e) {
		ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e.getMsg());
		paraUiVentanaError.setVisible(true);
	}
	private void crearVentanaError(String e) {
		ParaUiVentanaError paraUiVentanaError = new ParaUiVentanaError(e);
		paraUiVentanaError.setVisible(true);
	}

	private void limpiarCampos() {
		getTxtNombreMedico().setText("");
		getTxtApellidosMedico().setText("");
		getTxtTelefonoMedico().setText("");
		getTxtDireccionMedico().setText("");
	}
	

	
	//GETTER AND SETTERS
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

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
