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
import javax.swing.SwingConstants;

public class VentanaDatosPaciente extends JFrame{
	protected JTextField getTxtNombre;
	protected JTextField getTxtApellidos;
	protected JTextField getTxtTelefono;
	protected JTextField getTxtFechaNacimiento;
	protected JTextField getTxtDireccion;
	protected JTextField getTxtBuscar;
	
	public VentanaDatosPaciente() {
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
		btnModificar.setBounds(71, 361, 109, 23);
		getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(204, 255, 204));
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setBorderPainted(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBounds(226, 361, 97, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnSolicitarCita = new JButton("Solicitar Cita");
		btnSolicitarCita.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSolicitarCita.setBackground(new Color(204, 255, 204));
		btnSolicitarCita.setContentAreaFilled(false);
		btnSolicitarCita.setBorderPainted(false);
		btnSolicitarCita.setOpaque(true);
		btnSolicitarCita.setBounds(528, 361, 136, 23);
		getContentPane().add(btnSolicitarCita);
		
		JLabel lblPaciente = new JLabel("PACIENTE");
		lblPaciente.setOpaque(true);
		lblPaciente.setBackground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPaciente.setForeground(Color.WHITE);
		lblPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaciente.setBounds(10, 11, 714, 41);
		getContentPane().add(lblPaciente);
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.setFont(new Font("Verdana", Font.BOLD, 12));
		btnHistorial.setBackground(new Color(204, 255, 204));
		btnHistorial.setContentAreaFilled(false);
		btnHistorial.setBorderPainted(false);
		btnHistorial.setOpaque(true);
		btnHistorial.setBounds(381, 361, 109, 23);
		getContentPane().add(btnHistorial);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}

	public JTextField getGetTxtNombre() {
		return getTxtNombre;
	}

	public JTextField getGetTxtApellidos() {
		return getTxtApellidos;
	}

	public JTextField getGetTxtTelefono() {
		return getTxtTelefono;
	}

	public JTextField getGetTxtFechaNacimiento() {
		return getTxtFechaNacimiento;
	}

	public JTextField getGetTxtDireccion() {
		return getTxtDireccion;
	}

	public JTextField getGetTxtBuscar() {
		return getTxtBuscar;
	}
	
}
