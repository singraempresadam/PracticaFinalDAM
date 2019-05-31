package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class ventana extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ventana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/images/iconsalud.png")));
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 714, 541);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clean Life");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 80, 120, 23);
		panel.add(lblNewLabel);
		
		
		
		JLabel lblClnicaBuenaSalud = new JLabel("Healthy Code");
		lblClnicaBuenaSalud.setBackground(new Color(51, 153, 255));
		lblClnicaBuenaSalud.setBounds(0, 0, 714, 103);
		panel.add(lblClnicaBuenaSalud);
		lblClnicaBuenaSalud.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 39));
		lblClnicaBuenaSalud.setOpaque(true);
		lblClnicaBuenaSalud.setForeground(Color.WHITE);
		
		
		Image imgpaciente= new ImageIcon("paciente.png").getImage();
		ImageIcon img2=new ImageIcon(imgpaciente.getScaledInstance(139, 137, Image.SCALE_SMOOTH));
		
		JLabel labelpaciente = new JLabel("");
		labelpaciente.setBounds(137, 240, 120, 130);
		panel.add(labelpaciente);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 580);
		labelpaciente.setIcon(img2); 
		
		Image imgmedico= new ImageIcon("medico.png").getImage();
		ImageIcon img3=new ImageIcon(imgmedico.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
		
		JLabel labelmedico = new JLabel("");
		labelmedico.setBounds(456, 240, 110, 130);
		panel.add(labelmedico);
		labelmedico.setIcon(img3);
		
	
		
	}
}
