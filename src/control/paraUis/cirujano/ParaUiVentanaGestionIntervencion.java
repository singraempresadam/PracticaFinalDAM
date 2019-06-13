package control.paraUis.cirujano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import vista.cirujano.VentanaGestionarIntervención;

public class ParaUiVentanaGestionIntervencion extends VentanaGestionarIntervención{
	Controller control;
	String idIntervencion;
	String idMedico;
	String idPaciente;
	String idCirujano;
	String nombreMedico;
	String nombrePaciente;
	String nombreCirujano;
	
	public ParaUiVentanaGestionIntervencion (Controller control, String idIntervencion, String idCirujano)
	{
		super();
		this.setControl(control);
		this.setIdIntervencion(idIntervencion);
		this.setIdCirujano(idCirujano);
		this.setIdPaciente(this.getControl().obtenerPacienteDeIntervencion(this.getIdIntervencion(),this.getIdCirujano()));
		this.setIdMedico(this.getControl().obtenerMedicoDeIntervencion(this.getIdIntervencion(),this.getIdCirujano()));
		this.setNombrePaciente(this.getControl().obtenerNombrePaciente(this.getIdPaciente()));
		this.setNombreMedico(this.getControl().obtenerNombreMedico(this.getIdMedico()));
		this.setNombreCirujano(this.getControl().obtenerNombreCirujano(this.getIdCirujano()));
		this.getTxtPaciente().setText(this.getNombrePaciente());
		this.getTxtEspecialista().setText(this.getNombreMedico());
		this.getTxtCirujano().setText(this.getNombreCirujano());
		this.getTxtIntervencion().setText(this.getIdIntervencion());
		this.crearListeners();
	}

	private void crearListeners() {
		this.getBtnGestionarIntervencion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getControl().modificarIntervencion(getIdIntervencion(),getTxtObservaciones().getText(),getIdPaciente(),getIdCirujano(), getChckbxConfirmarAsistencia().isValid());
				dispose();
			}
		});
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	

	public String getIdIntervencion() {
		return idIntervencion;
	}

	public void setIdIntervencion(String idIntervencion) {
		this.idIntervencion = idIntervencion;
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

	public String getIdCirujano() {
		return idCirujano;
	}

	public void setIdCirujano(String idCirujano) {
		this.idCirujano = idCirujano;
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

	public String getNombreCirujano() {
		return nombreCirujano;
	}

	public void setNombreCirujano(String nombreCirujano) {
		this.nombreCirujano = nombreCirujano;
	}
	
}
