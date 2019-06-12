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
	Controller control;
	String idMedico;
	public ParaUiVentanaDatosMedico(String datos, Controller control) {
		super();
		this.setControl(control);
		this.agregarListener();
		String[] ayudante;
		
		ayudante=datos.split("-");
		this.setIdMedico(ayudante[2]);
		this.getTxtNombre().setText(ayudante[0]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[4]);
		this.getTxtEspecialidad().setText(ayudante[5]);
		this.getTxtEstado().setText(ayudante[6]);
	}
	private void agregarListener() {
			this.getBtnModificar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Validator validator = new Validator();
		
				getTxtTelefono().setEditable(true);
				getTxtTelefono().setBorder(new LineBorder(Color.RED, 1, true));
				getTxtDireccion().setEditable(true);
				getTxtDireccion().setBorder(new LineBorder(Color.RED, 1, true));
				String telefono = getTxtTelefono().getText();
				String direccion = getTxtDireccion().getText();
			}});
		this.getBtnDarDeBaja().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getControl().darBajaMedicoActivo(getIdMedico());
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
		

	private void comprobarCitaDisponible() {
		for(Map.Entry<String, Cita> entry : this.getControl().getMiGestor().getMedicosActivo().get(idMedico).getCitas().entrySet()){
			System.out.println(entry.getValue().getFechaYHora().contains(this.getControl().fechaYHora()));
			if(entry.getValue().getFechaYHora().contains(this.getControl().fechaYHora())) {
				ParaUiVentanaGestionarCitaMedicaAtencionPrimaria PUGCMAP = new ParaUiVentanaGestionarCitaMedicaAtencionPrimaria (this.getControl(), entry.getValue().getIdUnicoCita(), this.getIdMedico());
				PUGCMAP.setVisible(true);
			}
		}
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
	
}
