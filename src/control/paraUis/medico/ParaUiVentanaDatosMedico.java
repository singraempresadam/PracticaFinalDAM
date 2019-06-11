package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import control.Controller;
import vista.medico.VentanaDatosMedico;

public class ParaUiVentanaDatosMedico extends VentanaDatosMedico{
	Controller control = new Controller();
	public ParaUiVentanaDatosMedico(String datos) {
		super();
		this.agregarListener();
		String[] ayudante;
		
		ayudante=datos.split("-");
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
			public void mouseClicked(MouseEvent e) {
				getTxtTelefono().setEditable(true);
				getTxtTelefono().setBorder(new LineBorder(Color.RED, 1, true));
				getTxtDireccion().setEditable(true);
				getTxtDireccion().setBorder(new LineBorder(Color.RED, 1, true));
				
			}
		});
		
		
	}

}
