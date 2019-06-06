package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaGestionarCitaEspecialista extends JFrame{
	public VentanaGestionarCitaEspecialista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		JLabel lblGestionarCitaEspecialista = new JLabel("GESTIONAR CITA ESPECIALISTA");
		lblGestionarCitaEspecialista.setOpaque(true);
		lblGestionarCitaEspecialista.setBackground(new Color(0, 102, 204));
		lblGestionarCitaEspecialista.setFont(new Font("Verdana", Font.BOLD, 15));
		lblGestionarCitaEspecialista.setForeground(Color.WHITE);
		lblGestionarCitaEspecialista.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarCitaEspecialista.setBounds(10, 11, 714, 41);
		getContentPane().add(lblGestionarCitaEspecialista);
		
		JButton btnNewButton = new JButton("Gestionar");
		btnNewButton.setBounds(451, 411, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnSolicitarCirujano = new JButton("Solicitar Cirujano");
		btnSolicitarCirujano.setBounds(565, 411, 124, 23);
		getContentPane().add(btnSolicitarCirujano);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 98, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(37, 159, 118, 14);
		getContentPane().add(lblObservaciones);
		}
}
