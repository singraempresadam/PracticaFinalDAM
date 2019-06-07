package control.paraUis.medico;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import modelo.enumeraciones.Especialidad;
import modelo.enumeraciones.TipoDeIntervencion;
import vista.medico.VentanaSolicitarIntervencion;

public class ParaUiVentanaSolicitarIntervencion extends VentanaSolicitarIntervencion {
	public ParaUiVentanaSolicitarIntervencion()
	{
		super();
		agregarListener();
		TipoDeIntervencion[] values = TipoDeIntervencion.values();
		for (int i = 0; i < values.length; i++) {
			this.getComboBoxIntervencion().addItem(values[i]);
		}
	}

	private void agregarListener() {
		// TODO Auto-generated method stub
		
	}
}
