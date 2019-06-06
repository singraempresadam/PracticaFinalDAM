package control.paraUis.medico;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import control.paraUis.TestParaUI;
import control.paraUis.paciente.paraUiVentanaDatosPaciente;
import vista.medico.VentanaMedico;

public class paraUiVentanaMedico extends VentanaMedico{
	private JScrollPane scrollListaMedico;
	TestParaUI test = new TestParaUI();
	private JList<String> medicos;
	
	public paraUiVentanaMedico()
	{
		super();
		agregarListener();
		medicos= new JList<String>(test.obtenerTodosLosMedicos());
		medicos.setVisible(true);
		scrollListaMedico = new JScrollPane(medicos);
		scrollListaMedico.setBounds(79, 108, 345, 213);
		scrollListaMedico.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getPanelBuscarMedico().add(scrollListaMedico);
	}
	private String obtenerIdSeleccionado() {
		List<String> lista = medicos.getSelectedValuesList();
		String retorno = lista.get(0);
		return retorno;

	}
	
	private void agregarListener() {
		// TODO Auto-generated method stub
		getBtnConsultarMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ParaUiVentanaDatosMedico paraUiVentanaDatosMedico = new ParaUiVentanaDatosMedico(
						obtenerIdSeleccionado());
				paraUiVentanaDatosMedico.setVisible(true);

			}
		});
		getBtnBuscar().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getPanelBuscarMedico().setVisible(false);
				String filtro = getTxtgetNombre().getText();
				getPanelBuscarMedico().remove(scrollListaMedico);
				medicos = new JList<String>(test.filtrar(filtro, test.obtenerTodosLosMedicos()));
				scrollListaMedico = new JScrollPane(medicos);
				scrollListaMedico.setBounds(79, 108, 345, 213);
				scrollListaMedico.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				getPanelBuscarMedico().add(scrollListaMedico);
				getPanelBuscarMedico().setVisible(true);
			}
		});
	}
}
