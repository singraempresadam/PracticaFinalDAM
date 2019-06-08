package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import vista.ventanaPrincipal;

public class VentanaDatosMedico extends JDialog {
	protected JTextField setTxtNombre;
	protected JTextField setTxtApellidos;
	protected JTextField setTxtTelefono;
	protected JTextField setTxtEspecialidad;
	protected JTextField setTxtDireccion;
	protected JTextField getTxtBuscar;
	
	public VentanaDatosMedico() {

		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		setModal(true);
		
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
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setForeground(new Color(0, 102, 204));
		lblEspecialidad.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialidad.setBounds(83, 238, 160, 19);
		getContentPane().add(lblEspecialidad);
		
		setTxtNombre = new JTextField();
		setTxtNombre.setEditable(false);
		setTxtNombre.setBackground(new Color(255, 255, 255));
		setTxtNombre.setBounds(283, 86, 169, 20);
		getContentPane().add(setTxtNombre);
		setTxtNombre.setColumns(10);
		setTxtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		setTxtApellidos = new JTextField();
		setTxtApellidos.setBackground(Color.WHITE);
		setTxtApellidos.setEditable(false);
		setTxtApellidos.setBounds(283, 123, 169, 20);
		getContentPane().add(setTxtApellidos);
		setTxtApellidos.setColumns(10);
		setTxtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		setTxtTelefono = new JTextField();
		setTxtTelefono.setBackground(Color.WHITE);
		setTxtTelefono.setEditable(false);
		setTxtTelefono.setBounds(283, 160, 169, 20);
		getContentPane().add(setTxtTelefono);
		setTxtTelefono.setColumns(10);
		setTxtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		setTxtEspecialidad = new JTextField();
		setTxtEspecialidad.setBackground(Color.WHITE);
		setTxtEspecialidad.setEditable(false);
		setTxtEspecialidad.setBounds(283, 239, 169, 20);
		getContentPane().add(setTxtEspecialidad);
		setTxtEspecialidad.setColumns(10);
		setTxtEspecialidad.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		setTxtDireccion = new JTextField();
		setTxtDireccion.setBackground(Color.WHITE);
		setTxtDireccion.setEditable(false);
		setTxtDireccion.setBounds(283, 194, 169, 20);
		getContentPane().add(setTxtDireccion);
		setTxtDireccion.setColumns(10);
		setTxtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
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
		btnDardebaja.setBounds(292, 361, 126, 23);
		getContentPane().add(btnDardebaja);
		
		JButton btnGestionarCita = new JButton("Gestionar Cita");
		btnGestionarCita.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarCita.setBackground(new Color(204, 255, 204));
		btnGestionarCita.setContentAreaFilled(false);
		btnGestionarCita.setBorderPainted(false);
		btnGestionarCita.setOpaque(true);
		btnGestionarCita.setRequestFocusEnabled(false);
		btnGestionarCita.setFocusable(false);
		btnGestionarCita.setBounds(483, 361, 136, 23);
		getContentPane().add(btnGestionarCita);
		
		JLabel lblMedico = new JLabel("MEDICO");
		lblMedico.setOpaque(true);
		lblMedico.setBackground(new Color(0, 102, 204));
		lblMedico.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMedico.setForeground(Color.WHITE);
		lblMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedico.setBounds(10, 11, 714, 41);
		getContentPane().add(lblMedico);
	}
}
