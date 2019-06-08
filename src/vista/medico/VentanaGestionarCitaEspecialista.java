package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import vista.ventanaPrincipal;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VentanaGestionarCitaEspecialista extends JDialog{
	private JTextField getTxtDosis;
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
		lblGestionarCitaEspecialista.setBounds(10, 0, 714, 41);
		getContentPane().add(lblGestionarCitaEspecialista);
		
		JButton btnGestionarEspecialista = new JButton("Gestionar");
		btnGestionarEspecialista.setFont(new Font("Verdana", Font.BOLD, 12));
		btnGestionarEspecialista.setBackground(new Color(204, 255, 204));
		btnGestionarEspecialista.setContentAreaFilled(false);
		btnGestionarEspecialista.setBorderPainted(false);
		btnGestionarEspecialista.setOpaque(true);
		btnGestionarEspecialista.setBounds(394, 411, 108, 23);
		getContentPane().add(btnGestionarEspecialista);
		
		JButton btnSolicitarIntervencion = new JButton("Solicitar Intervenci\u00F3n");
		btnSolicitarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSolicitarIntervencion.setBackground(new Color(204, 255, 204));
		btnSolicitarIntervencion.setContentAreaFilled(false);
		btnSolicitarIntervencion.setBorderPainted(false);
		btnSolicitarIntervencion.setOpaque(true);
		btnSolicitarIntervencion.setBounds(522, 411, 184, 23);
		getContentPane().add(btnSolicitarIntervencion);
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratamiento.setForeground(new Color(0, 102, 204));
		lblTratamiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTratamiento.setBounds(30, 63, 188, 23);
		getContentPane().add(lblTratamiento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(30, 97, 188, 20);
		getContentPane().add(comboBox);
		
		getTxtDosis = new JTextField();
		getTxtDosis.setBounds(30, 142, 188, 23);
		getContentPane().add(getTxtDosis);
		getTxtDosis.setColumns(10);
		
		
	}
}
