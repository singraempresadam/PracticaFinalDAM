package control.paraUis;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
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
	private String obtenerIdSeleccionado()
	{
		List<String> lista= pacientes.getSelectedValuesList();
		String retorno=lista.get(0);
		return retorno;
		
	}
	private String[] filtrar(String filtro, String[] vectorPacientes) {
		String retorno [];
		int j=0;
		for (int i = 0; i < vectorPacientes.length; i++) {
			if(vectorPacientes[i].contains(filtro))
			{
				j++;
			}
		}
		
		retorno= new String[j];
		j=0;
		for (int i = 0; i < vectorPacientes.length; i++) {
			if(vectorPacientes[i].contains(filtro))
			{
				retorno[j]=vectorPacientes[i];
				j++;
			}
		}
		return retorno;
	}
	private void agregarListener() {
		// TODO Auto-generated method stub
		getBtnConsultarPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				paraUiVentanaDatosPaciente paraUiVentanaDatosPaciente = new paraUiVentanaDatosPaciente(obtenerIdSeleccionado());
				paraUiVentanaDatosPaciente.setVisible(true);
			}
		});
		getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String filtro=getGetTxtBuscar().getText();
				getPanelBuscarPaciente().remove(scrollListaPaciente);
				pacientes=new JList<String>(filtrar(filtro,test.obtenerElementosAMostrarPacienteTest()));
				scrollListaPaciente = new JScrollPane(pacientes);
				scrollListaPaciente.setBounds(79, 108, 345, 213);
				scrollListaPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				getPanelBuscarPaciente().add(scrollListaPaciente);
				
				
			}
		});
	
	}
}
