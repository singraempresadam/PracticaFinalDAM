package control.paraUis.medico;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import control.Controller;
import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.Medicamento;
import vista.medico.VentanaGestionarCitaMedicaAtencionPrimaria;

public class ParaUiVentanaGestionarCitaMedicaAtencionPrimaria extends VentanaGestionarCitaMedicaAtencionPrimaria{
	Controller control;
	String idCita;
	String idMedico;
	String idPaciente;
	String nombreMedico;
	String nombrePaciente;
	boolean AtencionPrimaria;
	public ParaUiVentanaGestionarCitaMedicaAtencionPrimaria(Controller control, String idCita, String idMedico) {
		super();
		this.setControl(control);
		this.setIdCita(idCita);
		this.setIdMedico(idMedico);
		this.setAtencionPrimaria(this.getControl().comprobarAtencionPrimaria(idMedico));
		Medicamento[] values = Medicamento.values();
		for (int i = 0; i < values.length; i++) {
			this.getComboBoxTratamiento().addItem(values[i]);
		}
		if(!this.isAtencionPrimaria())
		{
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
				getControl().crearTratamiento(getIdPaciente(),getComboBoxTratamiento().getSelectedItem().toString(),getTxtDosis().getText(),getTxtFechaInicio().getText(),getTxtFechaFin().getText());
				getControl().modificarCita(getIdCita(),getTxtObservaciones().getText(),getIdPaciente(),getIdMedico(), getChckbxConfirmarAsistencia().isValid());
				dispose();
			}
		});
		this.getBtnSolicitar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(isAtencionPrimaria())
				{
					ParaUiVentanaSolicitarCitaEspecialista paraUiVentanaSolicitarCitaEspecialista = new ParaUiVentanaSolicitarCitaEspecialista(control, idPaciente);
					paraUiVentanaSolicitarCitaEspecialista.setVisible(true);
				}
				else
				{
					ParaUiVentanaSolicitarIntervencion paraUiVentanaSolicitarIntervencion = new ParaUiVentanaSolicitarIntervencion(control,idPaciente, idMedico);
					paraUiVentanaSolicitarIntervencion.setVisible(true);
				}
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
	
	
}
