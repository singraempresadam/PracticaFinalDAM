package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JList;
import java.awt.Checkbox;
import java.awt.Label;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;

public class VentanaMedico extends JFrame {
	protected JPanel contentPane;
	protected JTextField getTxtBuscar;
	private JTextField txtgetNombre;
	private JTextField txtNombreActivo;

		public VentanaMedico() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
			getContentPane().setBackground(new Color(255, 255, 255));
			getContentPane().setLayout(null);
			
			ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
			ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.setBounds(0, 0, 734, 461);
			getContentPane().add(tabbedPane);
			
			JPanel panelBuscarMedico = new JPanel();
			panelBuscarMedico.setBackground(Color.WHITE);
			tabbedPane.addTab("Buscar Medico", iconbuscar, panelBuscarMedico, null);
			panelBuscarMedico.setLayout(null);
			
			txtgetNombre = new JTextField();
			txtgetNombre.setBounds(56, 47, 405, 25);
			panelBuscarMedico.add(txtgetNombre);
			txtgetNombre.setColumns(10);
			txtgetNombre.setBorder(new LineBorder(new Color(102, 153, 255), 2));
			
			JButton btnBuscar = new JButton("Buscar");
			btnBuscar.setBackground(new Color(0, 102, 204));
			btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
			btnBuscar.setForeground(Color.WHITE);
			btnBuscar.setContentAreaFilled(false);
			btnBuscar.setBorderPainted(false);
			btnBuscar.setOpaque(true);
			btnBuscar.setBounds(520, 47, 89, 23);
			panelBuscarMedico.add(btnBuscar);
			
			JList listMedicos = new JList();
			listMedicos.setBackground(Color.LIGHT_GRAY);
			listMedicos.setBounds(56, 103, 405, 160);
			panelBuscarMedico.add(listMedicos);
			
			
			JPanel panelAñadirMedicoActivo = new JPanel();
			panelAñadirMedicoActivo.setBorder(null);
			panelAñadirMedicoActivo.setBackground(Color.WHITE);
			tabbedPane.addTab("Añadir Medico Activo", iconagregar, panelAñadirMedicoActivo, null);
			panelAñadirMedicoActivo.setLayout(null);
			
			txtNombreActivo = new JTextField();
			txtNombreActivo.setColumns(10);
			txtNombreActivo.setBorder(new LineBorder(new Color(102, 153, 255), 2));
			txtNombreActivo.setBounds(44, 56, 405, 25);
			panelAñadirMedicoActivo.add(txtNombreActivo);
			
			JButton btnBuscarActivo = new JButton("Buscar");
			btnBuscarActivo.setContentAreaFilled(false);
			btnBuscarActivo.setBorderPainted(false);
			btnBuscarActivo.setOpaque(true);
			btnBuscarActivo.setForeground(Color.WHITE);
			btnBuscarActivo.setFont(new Font("Verdana", Font.BOLD, 11));
			btnBuscarActivo.setBackground(new Color(0, 102, 204));
			btnBuscarActivo.setBounds(517, 56, 89, 23);
			panelAñadirMedicoActivo.add(btnBuscarActivo);
			
			JList listMedicosActivos = new JList();
			listMedicosActivos.setBackground(Color.LIGHT_GRAY);
			listMedicosActivos.setBounds(44, 108, 405, 160);
			panelAñadirMedicoActivo.add(listMedicosActivos);
			
			Checkbox checkLunes = new Checkbox("");
			checkLunes.setBackground(new Color(204, 255, 255));
			checkLunes.setBounds(502, 151, 19, 22);
			panelAñadirMedicoActivo.add(checkLunes);
			
			Checkbox checkMartes = new Checkbox("");
			checkMartes.setBackground(new Color(204, 255, 255));
			checkMartes.setBounds(527, 151, 19, 22);
			panelAñadirMedicoActivo.add(checkMartes);
			
			Checkbox checkMiercoles = new Checkbox("");
			checkMiercoles.setBackground(new Color(204, 255, 255));
			checkMiercoles.setBounds(552, 151, 19, 22);
			panelAñadirMedicoActivo.add(checkMiercoles);
			
			Checkbox checkJueves = new Checkbox("");
			checkJueves.setBackground(new Color(204, 255, 255));
			checkJueves.setBounds(577, 151, 19, 22);
			panelAñadirMedicoActivo.add(checkJueves);
			
			Checkbox checkViernes = new Checkbox("");
			checkViernes.setBackground(new Color(204, 255, 255));
			checkViernes.setBounds(602, 151, 19, 22);
			panelAñadirMedicoActivo.add(checkViernes);
			
			JButton btnAnadir = new JButton("A\u00F1adir");
			btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAnadir.setBackground(new Color(204, 255, 204));
			btnAnadir.setContentAreaFilled(false);
			btnAnadir.setBorderPainted(false);
			btnAnadir.setOpaque(true);
			btnAnadir.setBounds(600, 361, 89, 23);
			panelAñadirMedicoActivo.add(btnAnadir);
			
			Label labelLunes = new Label("L");
			labelLunes.setForeground(new Color(0, 51, 153));
			labelLunes.setFont(new Font("Century", Font.BOLD, 12));
			labelLunes.setBounds(502, 125, 19, 22);
			panelAñadirMedicoActivo.add(labelLunes);
			
			Label labelMartes = new Label("M");
			labelMartes.setForeground(new Color(0, 51, 153));
			labelMartes.setFont(new Font("Century", Font.BOLD, 12));
			labelMartes.setBounds(527, 125, 19, 22);
			panelAñadirMedicoActivo.add(labelMartes);
			
			Label labelMiercoles = new Label("X");
			labelMiercoles.setForeground(new Color(0, 51, 153));
			labelMiercoles.setFont(new Font("Century", Font.BOLD, 12));
			labelMiercoles.setBounds(552, 125, 19, 22);
			panelAñadirMedicoActivo.add(labelMiercoles);
			
			Label labelJueves = new Label("J");
			labelJueves.setForeground(new Color(0, 51, 153));
			labelJueves.setFont(new Font("Century", Font.BOLD, 12));
			labelJueves.setBounds(577, 125, 19, 22);
			panelAñadirMedicoActivo.add(labelJueves);
			
			Label labelViernes = new Label("V");
			labelViernes.setForeground(new Color(0, 51, 153));
			labelViernes.setFont(new Font("Century", Font.BOLD, 12));
			labelViernes.setBounds(602, 125, 19, 22);
			panelAñadirMedicoActivo.add(labelViernes);
			
			JComboBox comboBoxHoraInicio = new JComboBox();
			comboBoxHoraInicio.setBounds(575, 200, 114, 20);
			panelAñadirMedicoActivo.add(comboBoxHoraInicio);
			
			JComboBox comboBoxHoraFinal = new JComboBox();
			comboBoxHoraFinal.setBounds(575, 244, 114, 20);
			panelAñadirMedicoActivo.add(comboBoxHoraFinal);
			
			JLabel lblHoraInicio = new JLabel("Hora Inicio");
			lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblHoraInicio.setForeground(new Color(0, 51, 153));
			lblHoraInicio.setBounds(485, 203, 61, 14);
			panelAñadirMedicoActivo.add(lblHoraInicio);
			
			JLabel lblHoraFinal = new JLabel("Hora Final");
			lblHoraFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblHoraFinal.setForeground(new Color(0, 51, 153));
			lblHoraFinal.setBounds(485, 247, 61, 14);
			panelAñadirMedicoActivo.add(lblHoraFinal);
			
			this.setMinimumSize(new Dimension(750, 500));
			
			
		}
}
