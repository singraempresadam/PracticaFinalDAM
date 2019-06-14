package control.paraUis.medico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import control.paraUis.ExceptionDatos;
import control.paraUis.ParaUiOperacionRealizada;
import control.paraUis.ParaUiVentanaError;
import control.paraUis.Validator;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.Medicamento;
import vista.medico.VentanaGestionarCitaMedicaAtencionPrimaria;

public class ParaUiVentanaGestionarCitaMedicaAtencionPrimaria extends VentanaGestionarCitaMedicaAtencionPrimaria {
	private Controller control;
	private Validator validator;
	private String idCita;
	private String idMedico;
	private String idPaciente;
	private String nombreMedico;
	private String nombrePaciente;
	private boolean AtencionPrimaria;

	@SuppressWarnings("unchecked")
	public ParaUiVentanaGestionarCitaMedicaAtencionPrimaria(Controller control, Validator validator, String idCita,
			String idMedico) {
		super();
		this.setControl(control);
		this.setValidator(validator);
		this.setIdCita(idCita);
		this.setIdMedico(idMedico);
		this.setAtencionPrimaria(this.getControl().comprobarAtencionPrimaria(idMedico));

		for (int i = 0; i < this.getControl().obtenerMedicamentos().length; i++) {
			this.getComboBoxTratamiento().addItem(this.getControl().obtenerMedicamentos()[i]);
		}
		if (!this.isAtencionPrimaria()) {
			this.getLblGestionarCitaMedicaAP().setText("GESTIONAR CITA ESPECIALIDAD");
			this.getBtnSolicitar().setText("Solicitar cirujano");
		}

		this.setIdPaciente(this.getControl().obtenerPacienteDeCita(this.getIdCita(), this.getIdMedico()));
		this.setNombrePaciente(this.getControl().obtenerNombrePaciente(this.getIdPaciente()));
		this.setNombreMedico(this.getControl().obtenerNombreMedico(this.getIdMedico()));
		this.getTxtNombrePaciente().setText(this.getNombrePaciente());
		this.getTxtNombreMedico().setText(this.getNombreMedico());
		this.agregarListener();
	}

	private void agregarListener() {
		this.getBtnGestionar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getionarCita();
			}
		});
		this.getBtnSolicitar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				solicitarCitaSiguienteNivel();
			}
		});

	}

	private void getionarCita() {
		String Dosis = this.getTxtDosis().getText();
		String fechaInicio = this.getTxtFechaInicio().getText();
		String fechaFin = this.getTxtFechaFin().getText();
		String observaciones = this.getTxtObservaciones().getText();
		boolean asistencia = this.getChckbxConfirmarAsistencia().isValid();
		System.out.println(Dosis + " " + fechaInicio + " " + fechaFin);
		try {
			if (this.getValidator().validarTratamiento(Dosis, fechaInicio, fechaFin, this.getControl()).isResultado())
				if (asistencia) {
					this.getControl().crearTratamiento(this.getIdPaciente(),
							this.getComboBoxTratamiento().getSelectedItem().toString(), Dosis, fechaInicio, fechaFin);
					this.getControl().modificarCita(this.getIdCita(), observaciones, this.getIdPaciente(),
							getIdMedico(), true);
					this.crearVentanaOperacionRealizada("Gestion completada");
					this.dispose();
				} else
					crearVentanaError("No puede gestionar una cita sin asistencia");
		} catch (ExceptionDatos e) {
			this.crearVentanaError(e);
		}
	}

	private void solicitarCitaSiguienteNivel() {
		if (this.isAtencionPrimaria()) {
			ParaUiVentanaSolicitarCitaEspecialista paraUiVentanaSolicitarCitaEspecialista = new ParaUiVentanaSolicitarCitaEspecialista(
					control, idPaciente);
			paraUiVentanaSolicitarCitaEspecialista.setVisible(true);
			this.getControl().modificarCita(this.getIdCita(), "Derivada a siguiente nivel", this.getIdPaciente(),
					getIdMedico(), true);
		} else {
			ParaUiVentanaSolicitarIntervencion paraUiVentanaSolicitarIntervencion = new ParaUiVentanaSolicitarIntervencion(
					control, idPaciente, idMedico);
			paraUiVentanaSolicitarIntervencion.setVisible(true);
		}
		this.crearVentanaOperacionRealizada("Gestion completada");
		this.dispose();
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

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public boolean isAtencionPrimaria() {
		return AtencionPrimaria;
	}

	public void setAtencionPrimaria(boolean atencionPrimaria) {
		AtencionPrimaria = atencionPrimaria;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

}
