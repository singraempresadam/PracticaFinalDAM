package vista.cirujano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaGestionarIntervención extends JFrame {
	private JTextField getTxtObservaciones;
	private JTextField txtIntervencion;
	private JTextField txtEspecialista;
	private JTextField txtCirujano;
	private JTextField txtPaciente;
	private JTextField txtFecha;
	public VentanaGestionarIntervención() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(850, 500));
		
		JLabel lblGestionarIntervencion = new JLabel("GESTIONAR INTERVENCION");
		lblGestionarIntervencion.setOpaque(true);
		lblGestionarIntervencion.setBackground(new Color(0, 102, 204));
		lblGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 15));
		lblGestionarIntervencion.setForeground(Color.WHITE);
		lblGestionarIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarIntervencion.setBounds(10, 11, 814, 41);
		getContentPane().add(lblGestionarIntervencion);
		
		JLabel lblNombreIntervencion = new JLabel("Intervencion");
		lblNombreIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreIntervencion.setForeground(new Color(0, 102, 204));
		lblNombreIntervencion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreIntervencion.setBounds(48, 78, 270, 19);
		getContentPane().add(lblNombreIntervencion);
		
		txtIntervencion = new JTextField();
		txtIntervencion.setEditable(false);
		txtIntervencion.setBounds(48, 108, 270, 19);
		getContentPane().add(txtIntervencion);
		txtIntervencion.setColumns(10);
		
		JLabel lblObservacion = new JLabel("Observaciones");
		lblObservacion.setForeground(new Color(0, 102, 204));
		lblObservacion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblObservacion.setBounds(48, 171, 145, 19);
		getContentPane().add(lblObservacion);
		
		getTxtObservaciones = new JTextField();
		getTxtObservaciones.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(51, 153, 255)));
		getTxtObservaciones.setBounds(48, 209, 270, 163);
		getContentPane().add(getTxtObservaciones);
		getTxtObservaciones.setColumns(10);
		
		JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setForeground(new Color(0, 102, 204));
		lblEspecialista.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialista.setBounds(473, 138, 100, 19);
		getContentPane().add(lblEspecialista);
		
		txtEspecialista = new JTextField();
		txtEspecialista.setEditable(false);
		txtEspecialista.setBounds(583, 139, 230, 18);
		getContentPane().add(txtEspecialista);
		txtEspecialista.setColumns(10);
		
		JLabel lblCirujano = new JLabel("Cirujano");
		lblCirujano.setForeground(new Color(0, 102, 204));
		lblCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCirujano.setBounds(473, 182, 100, 19);
		getContentPane().add(lblCirujano);
		
		txtCirujano = new JTextField();
		txtCirujano.setEditable(false);
		txtCirujano.setBounds(583, 183, 230, 19);
		getContentPane().add(txtCirujano);
		txtCirujano.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPaciente.setBounds(473, 225, 100, 19);
		getContentPane().add(lblPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(583, 226, 230, 19);
		getContentPane().add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(0, 102, 204));
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFecha.setBounds(473, 279, 100, 19);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(583, 280, 230, 19);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JCheckBox chckbxConfirmarAsistencia = new JCheckBox("Confirmar asistencia");
		chckbxConfirmarAsistencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxConfirmarAsistencia.setBackground(new Color(204, 255, 255));
		chckbxConfirmarAsistencia.setBounds(583, 326, 230, 23);
		getContentPane().add(chckbxConfirmarAsistencia);
		
		JButton btnGestionarIntervencion = new JButton("Gestionar");
		btnGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarIntervencion.setBackground(new Color(204, 255, 204));
		btnGestionarIntervencion.setContentAreaFilled(false);
		btnGestionarIntervencion.setBorderPainted(false);
		btnGestionarIntervencion.setOpaque(true);
		btnGestionarIntervencion.setBounds(652, 404, 145, 23);
		getContentPane().add(btnGestionarIntervencion);
	}
}