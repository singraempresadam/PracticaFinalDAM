package control.paraUis.cirujano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import control.Controller;
import control.paraUis.medico.ParaUiVentanaGestionarCitaMedicaAtencionPrimaria;
import control.paraUis.paciente.ParaUiVentanaHistorialPaciente;
import modelo.clasesDatos.Cita;
import modelo.clasesDatos.Intervencion;
import vista.cirujano.VentanaDatosCirujano;

public class ParaUiVentanaDatosCirujano extends VentanaDatosCirujano {
	Controller control;
	String idCirujano;
	public ParaUiVentanaDatosCirujano(String datos, Controller control) {
		super();
		this.setControl(control);
		this.agregarListener();
		String[] ayudante;
		ayudante=datos.split("-");
		this.getTxtNombre().setText(ayudante[0]);
		this.setIdCirujano(ayudante[2]);
		this.getTxtApellidos().setText(ayudante[1]);
		this.getTxtTelefono().setText(ayudante[3]);
		this.getTxtDireccion().setText(ayudante[4]);
	}
	
	private void agregarListener() {
		this.getBtnHistorialCirujano().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ParaUiVentanaHistorialCirujano paraUiVentanaHistorialCirujano = new ParaUiVentanaHistorialCirujano(getIdCirujano(),getControl());
			paraUiVentanaHistorialCirujano.setVisible(true);
		}
		});
		this.getBtnGestionarIntervencion().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comrprobarIntervencionDisponible();
			}

			
		});
}
	private void comrprobarIntervencionDisponible() {
		for(Map.Entry<String, Intervencion> Intervencion : this.getControl().getMiGestor().getCirujanos().get(this.getIdCirujano()).getIntervenciones().entrySet()){
			System.out.println(Intervencion.getValue().getFechaYHora().contains(this.getControl().fechaYHora()));
			if(Intervencion.getValue().getFechaYHora().contains(this.getControl().fechaYHora())) {
				ParaUiVentanaGestionIntervencion PUVGI = new ParaUiVentanaGestionIntervencion(this.getControl(),Intervencion.getValue().getIdUnicoCita(),this.getIdCirujano());
				PUVGI.setVisible(true);
			}
		}
		
	}
	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public String getIdCirujano() {
		return idCirujano;
	}

	public void setIdCirujano(String idCirujano) {
		this.idCirujano = idCirujano;
	}}
