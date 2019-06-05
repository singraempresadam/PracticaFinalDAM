package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ventanaPrincipal extends JFrame {

	protected JPanel contentPane;
	protected JButton botonPaciente;
	protected JButton botonCita;
	protected JButton botonMedico;

	

	/**
	 * Create the frame.
	 */
	public ventanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		this.setMinimumSize(new Dimension(750, 500));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 580);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 734, 541);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblClnicaBuenaSalud = new JLabel("Healthy Code");
		lblClnicaBuenaSalud.setBounds(10, 0, 717, 98);
		lblClnicaBuenaSalud.setBackground(new Color(51, 153, 255));
		panel.add(lblClnicaBuenaSalud);
		lblClnicaBuenaSalud.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 39));
		lblClnicaBuenaSalud.setOpaque(true);
		lblClnicaBuenaSalud.setForeground(Color.WHITE);
		
		botonPaciente = new JButton("");
		botonPaciente.setContentAreaFilled(false);
		botonPaciente.setBorderPainted(false);
		botonPaciente.setOpaque(true);
		botonPaciente.setBackground(new Color(204, 255, 255));
		botonPaciente.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/paciente.png")));
		botonPaciente.setBounds(68, 225, 135, 160);
		panel.add(botonPaciente);
		
		botonMedico = new JButton("");
		botonMedico.setContentAreaFilled(false);
		botonMedico.setBorderPainted(false);
		botonMedico.setOpaque(true);
		botonMedico.setBackground(new Color(204, 255, 255));
		botonMedico.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/medicuo.png")));
		botonMedico.setBounds(291, 225, 133, 160);
		panel.add(botonMedico);
		
		botonCita = new JButton("");
		botonCita.setContentAreaFilled(false);
		botonCita.setBorderPainted(false);
		botonCita.setOpaque(true);
		botonCita.setBackground(new Color(204, 255, 255));
		botonCita.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cirujano.png")));
		botonCita.setBounds(502, 225, 157, 160);
		panel.add(botonCita);
		
	
	}





	public JButton getBotonPaciente() {
		return botonPaciente;
	}



	public void setBotonPaciente(JButton botonPaciente) {
		this.botonPaciente = botonPaciente;
	}



	public JButton getBotonCita() {
		return botonCita;
	}



	public void setBotonCita(JButton botonCita) {
		this.botonCita = botonCita;
	}



	public JButton getBotonMedico() {
		return botonMedico;
	}



	public void setBotonMedico(JButton botonMedico) {
		this.botonMedico = botonMedico;
	}
	
}
