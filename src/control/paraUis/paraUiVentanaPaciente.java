package control.paraUis;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import vista.VentanaPaciente;


public class paraUiVentanaPaciente extends VentanaPaciente {
	Validator validator;

	private JScrollPane scrollListaPaciente;
	TestParaUI test = new TestParaUI();
	private JList<String> pacientes;
	public paraUiVentanaPaciente()
	{
		super();
		agregarListener();
		pacientes=new JList<String>(test.obtenerElementosAMostrarPacienteTest());
		pacientes.getSelectionMode();
		pacientes.setVisible(true);
		scrollListaPaciente = new JScrollPane(pacientes);
		scrollListaPaciente.setBounds(79, 108, 345, 213);
		scrollListaPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarPaciente().add(scrollListaPaciente);
	}

	private void agregarListener() {
		// TODO Auto-generated method stub
		
	}
}
