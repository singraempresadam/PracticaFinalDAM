package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class panelPaciente extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelPaciente() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 714, 541);
		setLayout(null);
		
		JButton botonDarDeAlta = new JButton("Dar de alta");
		botonDarDeAlta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		botonDarDeAlta.setContentAreaFilled(false);
		botonDarDeAlta.setForeground(Color.WHITE);
		botonDarDeAlta.setBackground(new Color(0, 153, 255));
		botonDarDeAlta.setBounds(72, 67, 174, 33);
		botonDarDeAlta.setOpaque(true);
		
		
		add(botonDarDeAlta);
	}
}
