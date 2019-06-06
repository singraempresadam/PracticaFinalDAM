package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaGestionarCitaCirujano extends JFrame {
	public VentanaGestionarCitaCirujano() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		JLabel lblGestionarCitaCirujano = new JLabel("GESTIONAR CITA CIRUJANO");
		lblGestionarCitaCirujano.setOpaque(true);
		lblGestionarCitaCirujano.setBackground(new Color(0, 102, 204));
		lblGestionarCitaCirujano.setFont(new Font("Verdana", Font.BOLD, 15));
		lblGestionarCitaCirujano.setForeground(Color.WHITE);
		lblGestionarCitaCirujano.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarCitaCirujano.setBounds(10, 11, 714, 41);
		getContentPane().add(lblGestionarCitaCirujano);
	}

}
