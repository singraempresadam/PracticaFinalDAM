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
	private JButton botonPaciente;
	private JButton botonCita;
	private JButton botonMedico;

	

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
		botonPaciente.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/paciente.png")));
		botonPaciente.setBounds(68, 225, 135, 160);
		panel.add(botonPaciente);
		
		botonMedico = new JButton("");
		botonMedico.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/medicuo.png")));
		botonMedico.setBounds(286, 225, 133, 160);
		panel.add(botonMedico);
		
		botonCita = new JButton("");
		botonCita.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cita.png")));
		botonCita.setBounds(490, 225, 181, 160);
		panel.add(botonCita);
		
		Image imgmedico= new ImageIcon("medico.png").getImage();
		ImageIcon img5=new ImageIcon(imgmedico.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
		
		Image imgcita= new ImageIcon("cita.png").getImage();
		ImageIcon img4=new ImageIcon(imgcita.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
	
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
