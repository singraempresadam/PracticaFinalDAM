package control.paraUis.cirujano;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.Controller;
import vista.cirujano.VentanaHistorialCirujano;

public class ParaUiVentanaHistorialCirujano extends VentanaHistorialCirujano {
	private JScrollPane scrollListaIntervencionesPendientes;
	private JScrollPane scrollListaIntervencionesRealizadas;
	private String idCirujano;
	private Controller control;
	private String nombreCirujano;
	private JList<String> intervencionesPendientes;
	private JList<String> intervencionesRealizadas;
	
	
	
	
	public ParaUiVentanaHistorialCirujano(String idCirujano, Controller control) {
		super();
		this.setIdCirujano(idCirujano);
		this.setControl(control);
		this.setNombreCirujano(this.getControl().obtenerNombreCirujano(this.getIdCirujano()));
		this.getTxtNombreCirujano().setText(this.getNombreCirujano());
		
		this.crearListaIntervencionesPendientes();
		this.crearListaIntervencionesRealizadas();
	}
	private void crearListaIntervencionesPendientes() {
		this.setIntervencionesPendientes((new JList<String>(this.getControl().obtenerIntervencionesPendientesCirujano(this.getIdCirujano()))));
		this.getIntervencionesPendientes().setVisible(true);
		this.setScrollListaIntervencionesPendientes(new JScrollPane(this.getIntervencionesPendientes()));
		this.getScrollListaIntervencionesPendientes().setBounds(20, 83, 260, 140);
		this.getScrollListaIntervencionesPendientes().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialCirujano().add(this.getScrollListaIntervencionesPendientes());
	}
	private void crearListaIntervencionesRealizadas() {
		this.setIntervencionesRealizadas((new JList<String>(this.getControl().obtenerIntervencionesRealizadasCirujano(this.getIdCirujano()))));
		this.getIntervencionesRealizadas().setVisible(true);
		this.setScrollListaIntervencionesRealizadas(new JScrollPane(this.getIntervencionesRealizadas()));
		this.getScrollListaIntervencionesRealizadas().setBounds(20, 83, 260, 140);
		this.getScrollListaIntervencionesRealizadas().setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelHistorialCirujano().add(this.getScrollListaIntervencionesRealizadas());
	}
	public JScrollPane getScrollListaIntervencionesPendientes() {
		return scrollListaIntervencionesPendientes;
	}
	public void setScrollListaIntervencionesPendientes(JScrollPane scrollListaIntervencionesPendientes) {
		this.scrollListaIntervencionesPendientes = scrollListaIntervencionesPendientes;
	}
	public JScrollPane getScrollListaIntervencionesRealizadas() {
		return scrollListaIntervencionesRealizadas;
	}
	public void setScrollListaIntervencionesRealizadas(JScrollPane scrollListaIntervencionesRealizadas) {
		this.scrollListaIntervencionesRealizadas = scrollListaIntervencionesRealizadas;
	}
	public String getIdCirujano() {
		return idCirujano;
	}
	public void setIdCirujano(String idCirujano) {
		this.idCirujano = idCirujano;
	}
	public Controller getControl() {
		return control;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public String getNombreCirujano() {
		return nombreCirujano;
	}
	public void setNombreCirujano(String nombreCirujano) {
		this.nombreCirujano = nombreCirujano;
	}
	public JList<String> getIntervencionesPendientes() {
		return intervencionesPendientes;
	}
	public void setIntervencionesPendientes(JList<String> intervencionesPendientes) {
		this.intervencionesPendientes = intervencionesPendientes;
	}
	public JList<String> getIntervencionesRealizadas() {
		return intervencionesRealizadas;
	}
	public void setIntervencionesRealizadas(JList<String> intervencionesRealizadas) {
		this.intervencionesRealizadas = intervencionesRealizadas;
	}
	
	
	
	
}
