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

public class VentanaMedico extends JFrame {
	protected JPanel contentPane;
	protected JTextField getTxtBuscar;
	private JTextField textField;

		public VentanaMedico() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/images/iconsalud.png")));
			getContentPane().setBackground(new Color(255, 255, 255));
			getContentPane().setLayout(null);
			
			ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
			ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.setBounds(0, 0, 734, 461);
			getContentPane().add(tabbedPane);
			
			JPanel panelAñadirMedicoActivo = new JPanel();
			panelAñadirMedicoActivo.setBackground(Color.WHITE);
			tabbedPane.addTab("Añadir Medico Activo", iconagregar, panelAñadirMedicoActivo, null);
			panelAñadirMedicoActivo.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(27, 47, 486, 25);
			panelAñadirMedicoActivo.add(textField);
			textField.setColumns(10);
			
			
			JPanel panelDarAltaMedico = new JPanel();
			panelDarAltaMedico.setBorder(null);
			panelDarAltaMedico.setBackground(Color.WHITE);
			tabbedPane.addTab("Gestionar Cita", iconagregar, panelDarAltaMedico, null);
			panelDarAltaMedico.setLayout(null);
			
			this.setMinimumSize(new Dimension(750, 500));
			
			
		}
}
