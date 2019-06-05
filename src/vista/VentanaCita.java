package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class VentanaCita extends JFrame {
	protected JTextField setTxtIdPaciente;
	protected JTextField setTxtIdMedico;
	protected JTextField getTxtBuscar;
	
	public VentanaCita() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblidPaciente = new JLabel("Id Paciente");
		lblidPaciente.setForeground(new Color(0, 102, 204));
		lblidPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblidPaciente.setBounds(83, 79, 137, 26);
		getContentPane().add(lblidPaciente);
		
		JLabel lblidMedico = new JLabel("Id M\u00E9dico");
		lblidMedico.setFont(new Font("Verdana", Font.BOLD, 14));
		lblidMedico.setForeground(new Color(0, 102, 204));
		lblidMedico.setBounds(83, 116, 86, 19);
		getContentPane().add(lblidMedico);
		
		setTxtIdPaciente = new JTextField();
		setTxtIdPaciente.setBackground(Color.WHITE);
		setTxtIdPaciente.setEditable(false);
		setTxtIdPaciente.setBounds(283, 84, 169, 20);
		getContentPane().add(setTxtIdPaciente);
		setTxtIdPaciente.setColumns(10);
		setTxtIdPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		setTxtIdMedico = new JTextField();
		setTxtIdMedico.setBackground(Color.WHITE);
		setTxtIdMedico.setBounds(283, 117, 169, 20);
		getContentPane().add(setTxtIdMedico);
		setTxtIdMedico.setColumns(10);
		setTxtIdMedico.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		
		JLabel lblSolicitarCita = new JLabel("SOLICITAR CITA");
		lblSolicitarCita.setOpaque(true);
		lblSolicitarCita.setBackground(new Color(0, 102, 204));
		lblSolicitarCita.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSolicitarCita.setForeground(Color.WHITE);
		lblSolicitarCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitarCita.setBounds(10, 11, 714, 41);
		getContentPane().add(lblSolicitarCita);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSolicitar.setBackground(new Color(204, 255, 204));
		btnSolicitar.setContentAreaFilled(false);
		btnSolicitar.setBorderPainted(false);
		btnSolicitar.setOpaque(true);
		btnSolicitar.setRequestFocusEnabled(false);
		btnSolicitar.setFocusable(false);
		btnSolicitar.setBounds(622, 416, 89, 23);
		getContentPane().add(btnSolicitar);
		
		JButton btnVerHorario = new JButton("Ver horario");
		btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVerHorario.setBackground(new Color(204, 255, 204));
		btnVerHorario.setContentAreaFilled(false);
		btnVerHorario.setBorderPainted(false);
		btnVerHorario.setOpaque(true);
		btnVerHorario.setRequestFocusEnabled(false);
		btnVerHorario.setFocusable(false);
		btnVerHorario.setBounds(492, 115, 122, 23);
		getContentPane().add(btnVerHorario);
		
		JPanel panelHorarioMedico = new JPanel();
		panelHorarioMedico.setBounds(126, 207, 500, 200);
		getContentPane().add(panelHorarioMedico);
		panelHorarioMedico.setLayout(null);
		
		JLabel lblLunes = new JLabel("Lunes");
		lblLunes.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		lblLunes.setBackground(new Color(204, 255, 255));
		lblLunes.setOpaque(true);
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunes.setBounds(126, 159, 100, 50);
		getContentPane().add(lblLunes);
		
		JLabel lblMartes = new JLabel("Martes");
		lblMartes.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		lblMartes.setOpaque(true);
		lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMartes.setBackground(new Color(204, 255, 255));
		lblMartes.setBounds(226, 159, 100, 50);
		getContentPane().add(lblMartes);
		
		JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
		lblMiercoles.setOpaque(true);
		lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiercoles.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		lblMiercoles.setBackground(new Color(204, 255, 255));
		lblMiercoles.setBounds(326, 159, 100, 50);
		getContentPane().add(lblMiercoles);
		
		JLabel lblJueves = new JLabel("Jueves");
		lblJueves.setOpaque(true);
		lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
		lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJueves.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		lblJueves.setBackground(new Color(204, 255, 255));
		lblJueves.setBounds(426, 159, 100, 50);
		getContentPane().add(lblJueves);
		
		JLabel lblViernes = new JLabel("Viernes");
		lblViernes.setOpaque(true);
		lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblViernes.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
		lblViernes.setBackground(new Color(204, 255, 255));
		lblViernes.setBounds(526, 159, 100, 50);
		getContentPane().add(lblViernes);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}
}
