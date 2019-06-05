package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class VentanaDatosMedico extends JFrame {
	protected JTextField getTxtNombre;
	protected JTextField getTxtApellidos;
	protected JTextField getTxtTelefono;
	protected JTextField getTxtFechaNacimiento;
	protected JTextField getTxtDireccion;
	protected JTextField getTxtBuscar;
	
	public VentanaDatosMedico() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 102, 204));
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setBounds(83, 81, 86, 26);
		getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(new Color(0, 102, 204));
		lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
		lblApellidos.setBounds(83, 118, 86, 26);
		getContentPane().add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTelefono.setForeground(new Color(0, 102, 204));
		lblTelefono.setBounds(83, 159, 86, 19);
		getContentPane().add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setForeground(new Color(0, 102, 204));
		lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDireccion.setBounds(83, 189, 86, 26);
		getContentPane().add(lblDireccion);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setForeground(new Color(0, 102, 204));
		lblFechaDeNacimiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFechaDeNacimiento.setBounds(83, 238, 160, 19);
		getContentPane().add(lblFechaDeNacimiento);
		
		getTxtNombre = new JTextField();
		getTxtNombre.setEditable(false);
		getTxtNombre.setBackground(new Color(255, 255, 255));
		getTxtNombre.setBounds(283, 86, 169, 20);
		getContentPane().add(getTxtNombre);
		getTxtNombre.setColumns(10);
		getTxtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtApellidos = new JTextField();
		getTxtApellidos.setBackground(Color.WHITE);
		getTxtApellidos.setEditable(false);
		getTxtApellidos.setBounds(283, 123, 169, 20);
		getContentPane().add(getTxtApellidos);
		getTxtApellidos.setColumns(10);
		getTxtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtTelefono = new JTextField();
		getTxtTelefono.setBackground(Color.WHITE);
		getTxtTelefono.setEditable(false);
		getTxtTelefono.setBounds(283, 160, 169, 20);
		getContentPane().add(getTxtTelefono);
		getTxtTelefono.setColumns(10);
		getTxtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtFechaNacimiento = new JTextField();
		getTxtFechaNacimiento.setBackground(Color.WHITE);
		getTxtFechaNacimiento.setEditable(false);
		getTxtFechaNacimiento.setBounds(283, 239, 169, 20);
		getContentPane().add(getTxtFechaNacimiento);
		getTxtFechaNacimiento.setColumns(10);
		getTxtFechaNacimiento.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		getTxtDireccion = new JTextField();
		getTxtDireccion.setBackground(Color.WHITE);
		getTxtDireccion.setEditable(false);
		getTxtDireccion.setBounds(283, 194, 169, 20);
		getContentPane().add(getTxtDireccion);
		getTxtDireccion.setColumns(10);
		getTxtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnModificar.setBackground(new Color(204, 255, 204));
		btnModificar.setContentAreaFilled(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setOpaque(true);
		btnModificar.setRequestFocusEnabled(false);
		btnModificar.setFocusable(false);
		btnModificar.setBounds(102, 361, 103, 23);
		getContentPane().add(btnModificar);
		
		JButton btnDardebaja = new JButton("Dar de Baja");
		btnDardebaja.setFont(new Font("Verdana", Font.BOLD, 12));
		btnDardebaja.setBackground(new Color(204, 255, 204));
		btnDardebaja.setContentAreaFilled(false);
		btnDardebaja.setBorderPainted(false);
		btnDardebaja.setOpaque(true);
		btnDardebaja.setRequestFocusEnabled(false);
		btnDardebaja.setFocusable(false);
		btnDardebaja.setBounds(254, 361, 126, 23);
		getContentPane().add(btnDardebaja);
		
		JButton btnGestionarCita = new JButton("Gestionar Cita");
		btnGestionarCita.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarCita.setBackground(new Color(204, 255, 204));
		btnGestionarCita.setContentAreaFilled(false);
		btnGestionarCita.setBorderPainted(false);
		btnGestionarCita.setOpaque(true);
		btnGestionarCita.setRequestFocusEnabled(false);
		btnGestionarCita.setFocusable(false);
		btnGestionarCita.setBounds(432, 361, 136, 23);
		getContentPane().add(btnGestionarCita);
		
		JLabel lblMedico = new JLabel("MEDICO");
		lblMedico.setOpaque(true);
		lblMedico.setBackground(new Color(0, 102, 204));
		lblMedico.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMedico.setForeground(Color.WHITE);
		lblMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedico.setBounds(10, 11, 714, 41);
		getContentPane().add(lblMedico);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}
}
