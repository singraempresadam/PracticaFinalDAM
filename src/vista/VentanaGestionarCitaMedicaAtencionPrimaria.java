package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaGestionarCitaMedicaAtencionPrimaria extends JFrame{
	
	public VentanaGestionarCitaMedicaAtencionPrimaria() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
	getContentPane().setBackground(new Color(255, 255, 255));
	getContentPane().setLayout(null);
	this.setMinimumSize(new Dimension(750, 500));
	JLabel lblGestionarCitaAP = new JLabel("GESTIONAR CITA ATENCION PRIMARIA");
	lblGestionarCitaAP.setOpaque(true);
	lblGestionarCitaAP.setBackground(new Color(0, 102, 204));
	lblGestionarCitaAP.setFont(new Font("Verdana", Font.BOLD, 15));
	lblGestionarCitaAP.setForeground(Color.WHITE);
	lblGestionarCitaAP.setHorizontalAlignment(SwingConstants.CENTER);
	lblGestionarCitaAP.setBounds(10, 11, 714, 41);
	getContentPane().add(lblGestionarCitaAP);
	
	JLabel lblNombre = new JLabel("Nombre");
	lblNombre.setBounds(56, 97, 46, 14);
	getContentPane().add(lblNombre);
	
	JButton btnNewButton = new JButton("Solicitar Especialista");
	btnNewButton.setBounds(567, 405, 139, 23);
	getContentPane().add(btnNewButton);
	
	JButton btnGestionar = new JButton("Gestionar");
	btnGestionar.setBounds(455, 405, 89, 23);
	getContentPane().add(btnGestionar);
	
	JLabel lblObservaciones = new JLabel("Observaciones");
	lblObservaciones.setBounds(56, 143, 101, 14);
	getContentPane().add(lblObservaciones);
	
	JLabel lblTratamiento = new JLabel("Tratamiento");
	lblTratamiento.setBounds(56, 207, 123, 14);
	getContentPane().add(lblTratamiento);
	}
}
