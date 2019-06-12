package vista.paciente;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
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
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JTextField txtTelefono;
	protected JTextField txtFechaNacimiento;
	protected JTextField txtDireccion;
	protected JTextField txtBuscarPaciente;
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
			panelPaciente.setBackground(Color.WHITE);
			panelPaciente.setLayout(null);
			panelPaciente.setBounds(0, 0, 750, 500);
			getContentPane().add(panelPaciente);
		
				JButton btnCerrar = new JButton("");
				btnCerrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose(); 
					}
				});
				btnCerrar.setBackground(new Color(0, 153, 255));
				btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
				btnCerrar.setContentAreaFilled(false);
				btnCerrar.setBorderPainted(false);
				btnCerrar.setOpaque(true);
				btnCerrar.setBounds(705, 0, 35, 31);
				panelPaciente.add(btnCerrar);
			
				JLabel lblClinicaBuenaSalud = new JLabel("PACIENTE");
				lblClinicaBuenaSalud.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/iconventana.png")));
				lblClinicaBuenaSalud.setHorizontalAlignment(SwingConstants.LEFT);
				lblClinicaBuenaSalud.setBounds(0, 0, 740, 31);
				lblClinicaBuenaSalud.setBackground(new Color(51, 153, 255));
				lblClinicaBuenaSalud.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblClinicaBuenaSalud.setOpaque(true);
				lblClinicaBuenaSalud.setForeground(Color.WHITE);
				panelPaciente.add(lblClinicaBuenaSalud);
		
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						pX=e.getX();
						pY=e.getY(); 
					}
				});
				tabbedPane.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
					}
				});
				panelPaciente.add(tabbedPane);
				tabbedPane.setBackground(Color.WHITE);
				tabbedPane.setBounds(0, 31, 740, 466);
				
				panelBuscarPaciente = new JPanel();
				panelBuscarPaciente.setBackground(Color.WHITE);
				tabbedPane.addTab("Buscar Paciente", iconbuscar, panelBuscarPaciente, null);
				panelBuscarPaciente.setLayout(null);
				
				txtBuscarPaciente = new JTextField();
				txtBuscarPaciente.setBounds(80, 50, 345, 27);
				panelBuscarPaciente.add(txtBuscarPaciente);
				txtBuscarPaciente.setColumns(10);
				txtBuscarPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
				
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
				lblNombre.setBounds(165, 47, 86, 26);
				panelAñadirPaciente.add(lblNombre);
				
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setForeground(new Color(0, 102, 204));
				lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
				lblApellidos.setBounds(165, 95, 86, 26);
				panelAñadirPaciente.add(lblApellidos);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTelefono.setForeground(new Color(0, 102, 204));
				lblTelefono.setBounds(165, 151, 86, 19);
				panelAñadirPaciente.add(lblTelefono);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setForeground(new Color(0, 102, 204));
				lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
				lblDireccion.setBounds(165, 189, 86, 26);
				panelAñadirPaciente.add(lblDireccion);
				
				JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
				lblFechaNacimiento.setForeground(new Color(0, 102, 204));
				lblFechaNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
				lblFechaNacimiento.setBounds(165, 238, 160, 19);
				panelAñadirPaciente.add(lblFechaNacimiento);
				
				
				txtNombre = new JTextField();
				txtNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtNombre.setBackground(new Color(255, 255, 255));
				txtNombre.setBounds(347, 51, 169, 20);			
				txtNombre.setColumns(10);
				txtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelAñadirPaciente.add(txtNombre);
				
				txtApellidos = new JTextField();
				txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtApellidos.setBounds(347, 99, 169, 20);		
				txtApellidos.setColumns(10);
				txtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelAñadirPaciente.add(txtApellidos);
				
				txtTelefono = new JTextField();
				txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtTelefono.setBounds(347, 151, 169, 20);			
				txtTelefono.setColumns(10);
				txtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelAñadirPaciente.add(txtTelefono);
				
				txtFechaNacimiento = new JTextField();
				txtFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtFechaNacimiento.setBounds(347, 238, 169, 20);				
				txtFechaNacimiento.setColumns(10);
				txtFechaNacimiento.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelAñadirPaciente.add(txtFechaNacimiento);
				
				txtDireccion = new JTextField();
				txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtDireccion.setBounds(347, 193, 169, 20);				
				txtDireccion.setColumns(10);
				txtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelAñadirPaciente.add(txtDireccion);
				
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

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTxtBuscarPaciente() {
		return txtBuscarPaciente;
	}

	public void setTxtBuscarPaciente(JTextField txtBuscarPaciente) {
		this.txtBuscarPaciente = txtBuscarPaciente;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
}
