package vista.paciente;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import vista.ventanaPrincipal;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaDatosPaciente extends JDialog{
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtFechaNacimiento;
	private JTextField txtDireccion;
	private JTextField getTxtBuscar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnHistorial;
	private JButton btnSolicitarCita;
	int pX,pY;
	
	public VentanaDatosPaciente() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 650, 450);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			JPanel panelDatosPaciente = new JPanel();
			panelDatosPaciente.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelDatosPaciente.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelDatosPaciente.setBackground(Color.WHITE);
			panelDatosPaciente.setBounds(0, 0, 734, 461);
			getContentPane().add(panelDatosPaciente);
			panelDatosPaciente.setLayout(null);
			
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
				btnCerrar.setBounds(613, 0, 37, 31);
				panelDatosPaciente.add(btnCerrar);
				
				JLabel lblDatosPaciente = new JLabel("DATOS PACIENTE");
				lblDatosPaciente.setIcon(new ImageIcon(VentanaDatosPaciente.class.getResource("/images/iconventana.png")));
				lblDatosPaciente.setOpaque(true);
				lblDatosPaciente.setHorizontalAlignment(SwingConstants.LEFT);
				lblDatosPaciente.setForeground(Color.WHITE);
				lblDatosPaciente.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblDatosPaciente.setBackground(SystemColor.textHighlight);
				lblDatosPaciente.setBounds(0, 0, 650, 31);
				panelDatosPaciente.add(lblDatosPaciente);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(150, 80, 86, 26);
				lblNombre.setForeground(new Color(0, 102, 204));
				lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosPaciente.add(lblNombre);
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setBounds(150, 120, 86, 26);
				lblApellidos.setForeground(new Color(0, 102, 204));
				lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosPaciente.add(lblApellidos);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setBounds(150, 160, 86, 19);
				lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTelefono.setForeground(new Color(0, 102, 204));
				panelDatosPaciente.add(lblTelefono);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setBounds(150, 200, 86, 26);
				lblDireccion.setForeground(new Color(0, 102, 204));
				lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosPaciente.add(lblDireccion);
				
				JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
				lblFechaDeNacimiento.setBounds(76, 240, 160, 19);				
				lblFechaDeNacimiento.setForeground(new Color(0, 102, 204));
				lblFechaDeNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosPaciente.add(lblFechaDeNacimiento);
				
				txtNombre = new JTextField();
				txtNombre.setBounds(280, 80, 169, 20);	
				txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombre.setForeground(new Color(0, 0, 102));
				txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombre.setEditable(false);
				txtNombre.setBackground(new Color(255, 255, 255));
				txtNombre.setColumns(10);
				txtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				panelDatosPaciente.add(txtNombre);
				
				txtApellidos = new JTextField();
				txtApellidos.setBounds(280, 120, 169, 20);	
				txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
				txtApellidos.setForeground(new Color(0, 0, 102));
				txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtApellidos.setBackground(Color.WHITE);
				txtApellidos.setEditable(false);
				txtApellidos.setColumns(10);
				txtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				panelDatosPaciente.add(txtApellidos);
				
				txtTelefono = new JTextField();
				txtTelefono.setBounds(280, 160, 169, 20);		
				txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
				txtTelefono.setForeground(new Color(0, 0, 102));
				txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtTelefono.setBackground(Color.WHITE);
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				panelDatosPaciente.add(txtTelefono);
				
				txtDireccion = new JTextField();
				txtDireccion.setBounds(280, 200, 169, 20);				
				txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
				txtDireccion.setForeground(new Color(0, 0, 102));
				txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtDireccion.setBackground(Color.WHITE);
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				panelDatosPaciente.add(txtDireccion);
				
				txtFechaNacimiento = new JTextField();
				txtFechaNacimiento.setBounds(280, 240, 169, 20);	
				txtFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
				txtFechaNacimiento.setForeground(new Color(0, 0, 102));
				txtFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtFechaNacimiento.setBackground(Color.WHITE);
				txtFechaNacimiento.setEditable(false);
				txtFechaNacimiento.setColumns(10);
				txtFechaNacimiento.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				panelDatosPaciente.add(txtFechaNacimiento);
				
				btnModificar = new JButton("Modificar");
				btnModificar.setBounds(60, 380, 110, 25);
				btnModificar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnModificar.setBackground(new Color(204, 255, 204));
				btnModificar.setContentAreaFilled(false);
				btnModificar.setBorderPainted(false);
				btnModificar.setOpaque(true);
				panelDatosPaciente.add(btnModificar);
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBounds(200, 380, 95, 25);
				btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnEliminar.setBackground(new Color(204, 255, 204));
				btnEliminar.setContentAreaFilled(false);
				btnEliminar.setBorderPainted(false);
				btnEliminar.setOpaque(true);
				panelDatosPaciente.add(btnEliminar);
			
				btnHistorial = new JButton("Historial");
				btnHistorial.setBounds(325, 380, 90, 25);
				btnHistorial.setFont(new Font("Verdana", Font.BOLD, 12));
				btnHistorial.setBackground(new Color(204, 255, 204));
				btnHistorial.setContentAreaFilled(false);
				btnHistorial.setBorderPainted(false);
				btnHistorial.setOpaque(true);
				panelDatosPaciente.add(btnHistorial);
				
				btnSolicitarCita = new JButton("Solicitar Cita");
				btnSolicitarCita.setBounds(450, 380, 145, 25);
				btnSolicitarCita.setFont(new Font("Verdana", Font.BOLD, 12));
				btnSolicitarCita.setBackground(new Color(204, 255, 204));
				btnSolicitarCita.setContentAreaFilled(false);
				btnSolicitarCita.setBorderPainted(false);
				btnSolicitarCita.setOpaque(true);
				panelDatosPaciente.add(btnSolicitarCita);
				
	}

	public JTextField getGetTxtNombre() {
		return txtNombre;
	}

	public JTextField getGetTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getGetTxtTelefono() {
		return txtTelefono;
	}

	public JTextField getGetTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public JTextField getGetTxtDireccion() {
		return txtDireccion;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnHistorial() {
		return btnHistorial;
	}

	public void setBtnHistorial(JButton btnHistorial) {
		this.btnHistorial = btnHistorial;
	}

	public JButton getBtnSolicitarCita() {
		return btnSolicitarCita;
	}

	public void setBtnSolicitarCita(JButton btnSolicitarCita) {
		this.btnSolicitarCita = btnSolicitarCita;
	}

	public JTextField getGetTxtBuscar() {
		return getTxtBuscar;
	}
	
}