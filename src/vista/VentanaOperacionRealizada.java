package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaOperacionRealizada extends JFrame{
	public VentanaOperacionRealizada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblRealizada = new JLabel("Operación realizada correctamente");
		lblRealizada.setIcon(new ImageIcon(VentanaOperacionRealizada.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")));
		lblRealizada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblRealizada, BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(300, 150));
	}
}
