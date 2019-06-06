package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class VentanaError extends JFrame {
	public VentanaError() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblError = new JLabel("Error: la operaci\u00F3n no pudo realizarse");
		lblError.setIcon(new ImageIcon(VentanaError.class.getResource("/images/error.png")));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblError, BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(300, 150));
	}

}
