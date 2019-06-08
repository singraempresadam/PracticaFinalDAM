package vista.paciente;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;

import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.event.MouseMotionAdapter;

public class VentanaPaciente extends JDialog {
	protected JPanel contentPane;
	protected JTextField getTxtNombre;
	protected JTextField getTxtApellidos;
	protected JTextField getTxtTelefono;
	protected JTextField getTxtFechaNacimiento;
	protected JTextField getTxtDireccion;
	protected JTextField getTxtBuscar;
	private JPanel panelBuscarPaciente;
	private JButton btnConsultarPaciente;
	private JButton btnBuscar;
	private JButton btnAnadir;
	private JPanel panelPaciente;
	int pX,pY;

	/**
	 * Create the frame.
	 */
	public VentanaPaciente() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 740, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		
		ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
		ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));
		
		JPanel panelPaciente = new JPanel();
		panelPaciente.setBackground(Color.WHITE);
		panelPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY(); 
			}
		});
		panelPaciente.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		getContentPane().add(panelPaciente, BorderLayout.CENTER);
		panelPaciente.setLayout(null);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setBackground(new Color(0, 153, 255));
		btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(true);
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
			}
		});
		btnCerrar.setBounds(704, 0, 36, 31);
		panelPaciente.add(btnCerrar);
	
		JLabel lblClinicaBuenaSalud = new JLabel("PACIENTE");
		lblClinicaBuenaSalud.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/iconventana.png")));
		lblClinicaBuenaSalud.setHorizontalAlignment(SwingConstants.LEFT);
		lblClinicaBuenaSalud.setBounds(0, 0, 750, 31);
		lblClinicaBuenaSalud.setBackground(new Color(51, 153, 255));
		lblClinicaBuenaSalud.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
		lblClinicaBuenaSalud.setOpaque(true);
		lblClinicaBuenaSalud.setForeground(Color.WHITE);
		panelPaciente.add(lblClinicaBuenaSalud);
		
		
		
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				panelPaciente.add(tabbedPane);
				tabbedPane.setBackground(Color.WHITE);
				tabbedPane.setBounds(0, 31, 740, 466);
				
				panelBuscarPaciente = new JPanel();
				panelBuscarPaciente.setBackground(Color.WHITE);
				tabbedPane.addTab("Buscar Paciente", iconbuscar, panelBuscarPaciente, null);
				panelBuscarPaciente.setLayout(null);
				
				getTxtBuscar = new JTextField();
				getTxtBuscar.setBounds(80, 50, 345, 27);
				panelBuscarPaciente.add(getTxtBuscar);
				getTxtBuscar.setColumns(10);
				getTxtBuscar.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setContentAreaFilled(false);
				btnBuscar.setBorderPainted(false);
				btnBuscar.setOpaque(true);
				btnBuscar.setBackground(new Color(0, 102, 204));
				btnBuscar.setBounds(520, 50, 89, 23);
				panelBuscarPaciente.add(btnBuscar);
				
				btnConsultarPaciente = new JButton("Consultar");
				btnConsultarPaciente.setFont(new Font("Verdana", Font.BOLD, 11));
				btnConsultarPaciente.setForeground(Color.WHITE);
				btnConsultarPaciente.setContentAreaFilled(false);
				btnConsultarPaciente.setBorderPainted(false);
				btnConsultarPaciente.setOpaque(true);
				btnConsultarPaciente.setBackground(new Color(0, 102, 204));
				btnConsultarPaciente.setBounds(520, 130, 125, 25);
				panelBuscarPaciente.add(btnConsultarPaciente);
				
				
				JPanel panelAñadirPaciente = new JPanel();
				panelAñadirPaciente.setBorder(null);
				panelAñadirPaciente.setBackground(Color.WHITE);
				tabbedPane.addTab("Añadir Paciente", iconagregar, panelAñadirPaciente, null);
				panelAñadirPaciente.setLayout(null);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setForeground(new Color(0, 102, 204));
				lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
				lblNombre.setBounds(24, 47, 86, 26);
				panelAñadirPaciente.add(lblNombre);
				
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setForeground(new Color(0, 102, 204));
				lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
				lblApellidos.setBounds(24, 99, 86, 26);
				panelAñadirPaciente.add(lblApellidos);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTelefono.setForeground(new Color(0, 102, 204));
				lblTelefono.setBounds(24, 151, 86, 19);
				panelAñadirPaciente.add(lblTelefono);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setForeground(new Color(0, 102, 204));
				lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
				lblDireccion.setBounds(24, 189, 86, 26);
				panelAñadirPaciente.add(lblDireccion);
				
				JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
				lblFechaNacimiento.setForeground(new Color(0, 102, 204));
				lblFechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
				lblFechaNacimiento.setBounds(24, 238, 160, 19);
				panelAñadirPaciente.add(lblFechaNacimiento);
				
				
				getTxtNombre = new JTextField();
				getTxtNombre.setBackground(new Color(255, 255, 255));
				getTxtNombre.setBounds(223, 52, 169, 20);
				panelAñadirPaciente.add(getTxtNombre);
				getTxtNombre.setColumns(10);
				getTxtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				getTxtApellidos = new JTextField();
				getTxtApellidos.setBounds(223, 97, 169, 20);
				panelAñadirPaciente.add(getTxtApellidos);
				getTxtApellidos.setColumns(10);
				getTxtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				getTxtTelefono = new JTextField();
				getTxtTelefono.setBounds(223, 152, 169, 20);
				panelAñadirPaciente.add(getTxtTelefono);
				getTxtTelefono.setColumns(10);
				getTxtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				getTxtFechaNacimiento = new JTextField();
				getTxtFechaNacimiento.setBounds(223, 239, 169, 20);
				panelAñadirPaciente.add(getTxtFechaNacimiento);
				getTxtFechaNacimiento.setColumns(10);
				getTxtFechaNacimiento.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				getTxtDireccion = new JTextField();
				getTxtDireccion.setBounds(223, 194, 169, 20);
				panelAñadirPaciente.add(getTxtDireccion);
				getTxtDireccion.setColumns(10);
				getTxtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				btnAnadir = new JButton("A\u00F1adir");
				
				btnAnadir.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAnadir.setBackground(new Color(204, 255, 204));
				btnAnadir.setContentAreaFilled(false);
				btnAnadir.setBorderPainted(false);
				btnAnadir.setOpaque(true);
				btnAnadir.setBounds(600, 361, 89, 23);
				panelAñadirPaciente.add(btnAnadir);
		
	}
	
	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public JButton getBtnConsultarPaciente() {
		return btnConsultarPaciente;
	}

	public JPanel getPanelBuscarPaciente() {
		return panelBuscarPaciente;
	}

	public JTextField getGetTxtNombre() {
		return getTxtNombre;
	}

	public void setGetTxtNombre(JTextField getTxtNombre) {
		this.getTxtNombre = getTxtNombre;
	}

	public JTextField getGetTxtApellidos() {
		return getTxtApellidos;
	}

	public void setGetTxtApellidos(JTextField getTxtApellidos) {
		this.getTxtApellidos = getTxtApellidos;
	}

	public JTextField getGetTxtTelefono() {
		return getTxtTelefono;
	}

	public void setGetTxtTelefono(JTextField getTxtTelefono) {
		this.getTxtTelefono = getTxtTelefono;
	}

	public JTextField getGetTxtFechaNacimiento() {
		return getTxtFechaNacimiento;
	}

	public void setGetTxtFechaNacimiento(JTextField getTxtFechaNacimiento) {
		this.getTxtFechaNacimiento = getTxtFechaNacimiento;
	}

	public JTextField getGetTxtDireccion() {
		return getTxtDireccion;
	}

	public void setGetTxtDireccion(JTextField getTxtDireccion) {
		this.getTxtDireccion = getTxtDireccion;
	}

	public JTextField getGetTxtBuscar() {
		return getTxtBuscar;
	}

	public void setGetTxtBuscar(JTextField getTxtBuscar) {
		this.getTxtBuscar = getTxtBuscar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
}
