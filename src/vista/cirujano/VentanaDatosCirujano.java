package vista.cirujano;

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

public class VentanaDatosCirujano extends JDialog {
	protected JTextField getTxtNombre;
	protected JTextField getTxtApellidos;
	protected JTextField getTxtTelefono;
	protected JTextField getTxtDireccion;
	protected JTextField getTxtBuscar;
	
	public VentanaDatosCirujano() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
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
		
		getTxtDireccion = new JTextField();
		getTxtDireccion.setBackground(Color.WHITE);
		getTxtDireccion.setEditable(false);
		getTxtDireccion.setBounds(283, 194, 169, 20);
		getContentPane().add(getTxtDireccion);
		getTxtDireccion.setColumns(10);
		getTxtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		JButton btnGestionarIntervencion = new JButton("Gestionar Intervenci\u00F3n");
		btnGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarIntervencion.setBackground(new Color(204, 255, 204));
		btnGestionarIntervencion.setContentAreaFilled(false);
		btnGestionarIntervencion.setBorderPainted(false);
		btnGestionarIntervencion.setOpaque(true);
		btnGestionarIntervencion.setRequestFocusEnabled(false);
		btnGestionarIntervencion.setFocusable(false);
		btnGestionarIntervencion.setBounds(474, 391, 185, 23);
		getContentPane().add(btnGestionarIntervencion);
		
		JLabel lblCirujano = new JLabel("CIRUJANO");
		lblCirujano.setOpaque(true);
		lblCirujano.setBackground(new Color(0, 102, 204));
		lblCirujano.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCirujano.setForeground(Color.WHITE);
		lblCirujano.setHorizontalAlignment(SwingConstants.CENTER);
		lblCirujano.setBounds(10, 11, 714, 41);
		getContentPane().add(lblCirujano);
	}

}
