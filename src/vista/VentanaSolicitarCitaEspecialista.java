package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSolicitarCitaEspecialista extends JFrame {
	public VentanaSolicitarCitaEspecialista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		JLabel lblSolicitarCitaEspecialista = new JLabel("SOLICITAR CITA ESPECIALISTA");
		lblSolicitarCitaEspecialista.setOpaque(true);
		lblSolicitarCitaEspecialista.setBackground(new Color(0, 102, 204));
		lblSolicitarCitaEspecialista.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSolicitarCitaEspecialista.setForeground(Color.WHITE);
		lblSolicitarCitaEspecialista.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitarCitaEspecialista.setBounds(10, 11, 714, 41);
		getContentPane().add(lblSolicitarCitaEspecialista);
		
		JButton btnNewButton = new JButton("Solicitar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(611, 414, 89, 23);
		getContentPane().add(btnNewButton);
		}
}
