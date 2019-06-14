package control.paraUis.cirujano;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import control.Controller;
import control.paraUis.ParaUiOperacionRealizada;
import control.paraUis.ParaUiVentanaError;
import control.paraUis.medico.ParaUiVentanaGestionarCitaMedicaAtencionPrimaria;
import control.paraUis.paciente.ParaUiVentanaHistorialPaciente;
import modelo.clasesDatos.Cita;
import modelo.clasesDatos.Intervencion;
import vista.cirujano.VentanaDatosCirujano;

public class ParaUiVentanaDatosCirujano extends VentanaDatosCirujano {
	Controller control;
	String idCirujano;
	String[] ayudante;

	public ParaUiVentanaDatosCirujano(String datos, Controller control) {
		super();
		this.setControl(control);
		this.rellenarCamposCirujano(datos);
		this.agregarListener();
	}

	private void rellenarCamposCirujano(String datos) {
		this.setAyudante(datos.split("-"));
		this.getTxtNombre().setText(this.getAyudante()[0]);
		this.setIdCirujano(this.getAyudante()[2]);
		this.getTxtApellidos().setText(this.getAyudante()[1]);
		this.getTxtTelefono().setText(this.getAyudante()[3]);
		this.getTxtDireccion().setText(this.getAyudante()[4]);
	}

	private void agregarListener() {
		this.getBtnHistorialCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ParaUiVentanaHistorialCirujano paraUiVentanaHistorialCirujano = new ParaUiVentanaHistorialCirujano(
						getIdCirujano(), getControl());
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
		boolean intervencionRealizada = false;
		for (Map.Entry<String, Intervencion> Intervencion : this.getControl().getMiGestor().getCirujanos()
				.get(this.getIdCirujano()).getIntervenciones().entrySet()) {
			System.out.println(Intervencion.getValue().getFechaYHora().contains(this.getControl().fechaYHora()));
			if (Intervencion.getValue().getFechaYHora().contains(this.getControl().fechaYHora())) {
				this.crearVentanaOperacionRealizada("Tiene una intervencion disponible");
				ParaUiVentanaGestionIntervencion PUVGI = new ParaUiVentanaGestionIntervencion(this.getControl(),
						Intervencion.getValue().getIdUnicoCita(), this.getIdCirujano());
				PUVGI.setVisible(true);
				intervencionRealizada = true;
			}
		}
		if (!intervencionRealizada)
			this.crearVentanaError("No tiene intervencion disponible consulte horario");

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

	public String getIdCirujano() {
		return idCirujano;
	}

	public void setIdCirujano(String idCirujano) {
		this.idCirujano = idCirujano;
	}

	public String[] getAyudante() {
		return ayudante;
	}

	public void setAyudante(String[] ayudante) {
		this.ayudante = ayudante;
	}

}
