package vista.cirujano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class VentanaGestionarIntervención extends JFrame {
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
		
		JLabel lblIntervencion = new JLabel("");
		lblIntervencion.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblIntervencion.setBounds(198, 78, 195, 19);
		getContentPane().add(lblIntervencion);
		
		JLabel lblNombreIntervencion = new JLabel("Intervencion");
		lblNombreIntervencion.setForeground(new Color(0, 102, 204));
		lblNombreIntervencion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombreIntervencion.setBounds(48, 78, 100, 19);
		getContentPane().add(lblNombreIntervencion);
		
		JTextPane textObservacion = new JTextPane();
		textObservacion.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(0, 153, 255)));
		textObservacion.setBounds(48, 167, 341, 159);
		getContentPane().add(textObservacion);
		
		JLabel lblObservacion = new JLabel("Observaciones");
		lblObservacion.setForeground(new Color(0, 102, 204));
		lblObservacion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblObservacion.setBounds(48, 138, 145, 19);
		getContentPane().add(lblObservacion);
		
		JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setForeground(new Color(0, 102, 204));
		lblEspecialista.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialista.setBounds(473, 138, 100, 19);
		getContentPane().add(lblEspecialista);
		
		JLabel lblNombreEspecialista = new JLabel("");
		lblNombreEspecialista.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblNombreEspecialista.setBounds(583, 138, 230, 19);
		getContentPane().add(lblNombreEspecialista);
		
		JLabel lblCirujano = new JLabel("Cirujano");
		lblCirujano.setForeground(new Color(0, 102, 204));
		lblCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCirujano.setBounds(473, 182, 100, 19);
		getContentPane().add(lblCirujano);
		
		JLabel lblNombreCirujano = new JLabel("");
		lblNombreCirujano.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblNombreCirujano.setBounds(583, 182, 230, 19);
		getContentPane().add(lblNombreCirujano);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPaciente.setBounds(473, 225, 100, 19);
		getContentPane().add(lblPaciente);
		
		JLabel lblNombrePaciente = new JLabel("");
		lblNombrePaciente.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblNombrePaciente.setBounds(583, 225, 230, 19);
		getContentPane().add(lblNombrePaciente);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(new Color(0, 102, 204));
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 14));
		lblFecha.setBounds(473, 279, 100, 19);
		getContentPane().add(lblFecha);
		
		JLabel lblDarFecha = new JLabel("");
		lblDarFecha.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblDarFecha.setBounds(583, 279, 230, 19);
		getContentPane().add(lblDarFecha);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Confirmar asistencia");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBackground(new Color(204, 255, 255));
		chckbxNewCheckBox.setBounds(473, 326, 154, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JButton btnGestionarIntervencion = new JButton("Gestionar");
		btnGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarIntervencion.setBackground(new Color(204, 255, 204));
		btnGestionarIntervencion.setContentAreaFilled(false);
		btnGestionarIntervencion.setBorderPainted(false);
		btnGestionarIntervencion.setOpaque(true);
		btnGestionarIntervencion.setBounds(650, 414, 145, 23);
		getContentPane().add(btnGestionarIntervencion);
	}
}
