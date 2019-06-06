package vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class VentanaCirujano extends JFrame{
	public VentanaCirujano() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		JLabel lblCirujano = new JLabel("CIRUJANO");
		lblCirujano.setOpaque(true);
		lblCirujano.setBackground(new Color(0, 102, 204));
		lblCirujano.setFont(new Font("Verdana", Font.BOLD, 15));
		lblCirujano.setForeground(Color.BLACK);
		lblCirujano.setHorizontalAlignment(SwingConstants.CENTER);
		lblCirujano.setBounds(10, 11, 714, 41);
		getContentPane().add(lblCirujano);
		
		JLabel label = new JLabel("Nombre");
		label.setForeground(new Color(0, 102, 204));
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setBounds(38, 103, 86, 26);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Apellidos");
		label_1.setForeground(new Color(0, 102, 204));
		label_1.setFont(new Font("Verdana", Font.BOLD, 14));
		label_1.setBounds(38, 157, 86, 26);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Tel\u00E9fono");
		label_2.setForeground(new Color(0, 102, 204));
		label_2.setFont(new Font("Verdana", Font.BOLD, 14));
		label_2.setBounds(38, 210, 86, 19);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n");
		label_3.setForeground(new Color(0, 102, 204));
		label_3.setFont(new Font("Verdana", Font.BOLD, 14));
		label_3.setBounds(38, 256, 86, 26);
		getContentPane().add(label_3);
	}

}
