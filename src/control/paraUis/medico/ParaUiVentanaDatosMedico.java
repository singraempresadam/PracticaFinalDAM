package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.border.LineBorder;

import control.Controller;
import control.paraUis.ExceptionDatos;
import control.paraUis.ParaUiOperacionRealizada;
import control.paraUis.ParaUiVentanaError;
import control.paraUis.Validator;
import control.paraUis.paciente.ParaUiVentanaHistorialPaciente;
import modelo.clasesDatos.Cita;
import vista.medico.VentanaDatosMedico;

public class ParaUiVentanaDatosMedico extends VentanaDatosMedico{
	private Controller control;
	private Validator validator;
	private String idMedico;
	private boolean estado;
	private boolean modificar;
	private String[] ayudante;
	public ParaUiVentanaDatosMedico(String datos, Controller control, Validator validator) {
		super();
		this.setControl(control);
		this.setValidator(validator);
		this.setEstado(false);
		
		this.rellenarCampos(datos);
		if(!this.isEstado()) this.eliminarBotones();
		this.agregarListener();
	}
	private void eliminarBotones() {
		this.getBtnDarDeBaja().setVisible(false);
		this.getBtnGestionarCita().setVisible(false);
		this.getBtnHistorialMedico().setVisible(false);
		this.getBtnModificar().setBounds(279, 380, 110, 25);
		
	}
	private void rellenarCampos(String datos) {
		this.setAyudante(datos.split("-"));
		this.setIdMedico(this.getAyudante()[2]);
		this.getTxtNombre().setText(this.getAyudante()[0]);
		this.getTxtApellidos().setText(this.getAyudante()[1]);
		this.getTxtTelefono().setText(this.getAyudante()[3]);
		this.getTxtDireccion().setText(this.getAyudante()[4]);
		this.getTxtEspecialidad().setText(this.getAyudante()[5]);
		this.getTxtEstado().setText(this.getAyudante()[6]);
		if(this.getAyudante()[6].contains("Activo")) this.setEstado(true);
	}
	private void agregarListener() {
			this.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comprobarModificar();
			}});
		this.getBtnDarDeBaja().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getControl().darBajaMedicoActivo(getIdMedico());
				crearVentanaOperacionRealizada("Este medico ahora es inactivo");
				dispose();
			}	
		});
		this.getBtnGestionarCita().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comprobarCitaDisponible();
			}	
		});
		this.getBtnHistorialMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaHistorialMedico paraUiVentanaHistorialMedico = new ParaUiVentanaHistorialMedico(getIdMedico(),getControl());
				paraUiVentanaHistorialMedico.setVisible(true);
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
		this.comprobarMedico();
		this.setModificar(true);
	}
	private void comprobarMedico() {
		String telefono=this.getTxtTelefono().getText();
		String direccion=this.getTxtDireccion().getText();
		boolean telefonoValido=this.getValidator().validarTelefono(telefono, this.getControl()).isResultado();
		boolean direccionValida=this.getValidator().validarDireccion(direccion, this.getControl()).isResultado();
		if(telefonoValido && direccionValida){
			if(this.isEstado())
				this.getControl().modificarMedicoActivo(this.getIdMedico(),telefono,direccion);
			else
				this.getControl().modificarMedico(this.getIdMedico(),telefono,direccion);
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
	private void comprobarCitaDisponible() {
		boolean citaRealizada=false;
		for(Map.Entry<String, Cita> entry : this.getControl().getMiGestor().getMedicosActivo().get(this.getIdMedico()).getCitas().entrySet()){
			System.out.println(entry.getValue().getFechaYHora().contains(this.getControl().fechaYHora()));
			if(entry.getValue().getFechaYHora().contains(this.getControl().fechaYHora()) && !entry.getValue().isConfirmacion()) {
				this.crearVentanaOperacionRealizada("Tiene una cita disponible");
				ParaUiVentanaGestionarCitaMedicaAtencionPrimaria PUGCMAP = new ParaUiVentanaGestionarCitaMedicaAtencionPrimaria (this.getControl(), this.getValidator(), entry.getValue().getIdUnicoCita(), this.getIdMedico());
				PUGCMAP.setVisible(true);
				citaRealizada=true;
			}
		}
		if(!citaRealizada)
		this.crearVentanaError("No tiene cita disponible");
	}
	private void crearVentanaOperacionRealizada(String mensaje) {
		ParaUiOperacionRealizada paraUiOpereacionRealizada = new ParaUiOperacionRealizada(mensaje);
		paraUiOpereacionRealizada.setVisible(true);
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
	public String getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}
	public boolean isModificar() {
		return modificar;
	}
	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}
	public String[] getAyudante() {
		return ayudante;
	}
	public void setAyudante(String[] ayudante) {
		this.ayudante = ayudante;
	}
	public Validator getValidator() {
		return validator;
	}
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
