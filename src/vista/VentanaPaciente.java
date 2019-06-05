package vista;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;

public class VentanaPaciente extends JFrame {
	protected JPanel contentPane;
	protected JTextField getTxtNombre;
	protected JTextField getTxtApellidos;
	protected JTextField getTxtTelefono;
	protected JTextField getTxtFechaNacimiento;
	protected JTextField getTxtDireccion;
	protected JTextField getTxtBuscar;
	private JPanel panelBuscarPaciente;

	/**
	 * Create the frame.
	 */
	public VentanaPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
		ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 734, 461);
		getContentPane().add(tabbedPane);
		
		panelBuscarPaciente = new JPanel();
		panelBuscarPaciente.setBackground(Color.WHITE);
		tabbedPane.addTab("Buscar Paciente", iconbuscar, panelBuscarPaciente, null);
		panelBuscarPaciente.setLayout(null);
		
		getTxtBuscar = new JTextField();
		getTxtBuscar.setBounds(79, 43, 345, 27);
		panelBuscarPaciente.add(getTxtBuscar);
		getTxtBuscar.setColumns(10);
		getTxtBuscar.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setRequestFocusEnabled(false);
		btnBuscar.setFocusable(false);
		btnBuscar.setBackground(new Color(0, 102, 204));
		btnBuscar.setBounds(511, 45, 89, 23);
		panelBuscarPaciente.add(btnBuscar);
		
		
		
		
		
		JPanel panelDarAltaPaciente = new JPanel();
		panelDarAltaPaciente.setBorder(null);
		panelDarAltaPaciente.setBackground(Color.WHITE);
		tabbedPane.addTab("Añadir Paciente", iconagregar, panelDarAltaPaciente, null);
		panelDarAltaPaciente.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 102, 204));
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setBounds(24, 47, 86, 26);
		panelDarAltaPaciente.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(new Color(0, 102, 204));
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApellidos.setBounds(24, 99, 86, 26);
		panelDarAltaPaciente.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelefono.setForeground(new Color(0, 102, 204));
		lblTelefono.setBounds(24, 151, 86, 19);
		panelDarAltaPaciente.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setForeground(new Color(0, 102, 204));
		lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDireccion.setBounds(24, 189, 86, 26);
		panelDarAltaPaciente.add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(new Color(0, 102, 204));
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(24, 238, 160, 19);
		panelDarAltaPaciente.add(lblFechaDeNacimiento);
		
		
		getTxtNombre = new JTextField();
		getTxtNombre.setBackground(new Color(255, 255, 255));
		getTxtNombre.setBounds(223, 52, 169, 20);
		panelDarAltaPaciente.add(getTxtNombre);
		getTxtNombre.setColumns(10);
		getTxtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtApellidos = new JTextField();
		getTxtApellidos.setBounds(223, 97, 169, 20);
		panelDarAltaPaciente.add(getTxtApellidos);
		getTxtApellidos.setColumns(10);
		getTxtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtTelefono = new JTextField();
		getTxtTelefono.setBounds(223, 152, 169, 20);
		panelDarAltaPaciente.add(getTxtTelefono);
		getTxtTelefono.setColumns(10);
		getTxtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtFechaNacimiento = new JTextField();
		getTxtFechaNacimiento.setBounds(223, 239, 169, 20);
		panelDarAltaPaciente.add(getTxtFechaNacimiento);
		getTxtFechaNacimiento.setColumns(10);
		getTxtFechaNacimiento.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtDireccion = new JTextField();
		getTxtDireccion.setBounds(223, 194, 169, 20);
		panelDarAltaPaciente.add(getTxtDireccion);
		getTxtDireccion.setColumns(10);
		getTxtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		this.setMinimumSize(new Dimension(750, 500));
		
		
	}

	public JPanel getPanelBuscarPaciente() {
		return panelBuscarPaciente;
	}

	

	
	
}
