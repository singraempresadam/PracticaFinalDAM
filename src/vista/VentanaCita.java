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
import javax.swing.border.MatteBorder;

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
		panelHorarioMedico.setBounds(120, 207, 500, 200);
		getContentPane().add(panelHorarioMedico);
		panelHorarioMedico.setLayout(null);
		
		JLabel lblLunes = new JLabel("Lunes");
		lblLunes.setBorder(new MatteBorder(2, 2, 0, 1, (Color) new Color(0, 102, 204)));
		lblLunes.setBackground(new Color(204, 255, 255));
		lblLunes.setOpaque(true);
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunes.setBounds(120, 159, 100, 50);
		getContentPane().add(lblLunes);
		
		JLabel lblMartes = new JLabel("Martes");
		lblMartes.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblMartes.setOpaque(true);
		lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMartes.setBackground(new Color(204, 255, 255));
		lblMartes.setBounds(220, 159, 100, 50);
		getContentPane().add(lblMartes);
		
		JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
		lblMiercoles.setOpaque(true);
		lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiercoles.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblMiercoles.setBackground(new Color(204, 255, 255));
		lblMiercoles.setBounds(320, 159, 100, 50);
		getContentPane().add(lblMiercoles);
		
		JLabel lblJueves = new JLabel("Jueves");
		lblJueves.setOpaque(true);
		lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
		lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJueves.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblJueves.setBackground(new Color(204, 255, 255));
		lblJueves.setBounds(420, 159, 100, 50);
		getContentPane().add(lblJueves);
		
		JLabel lblViernes = new JLabel("Viernes");
		lblViernes.setOpaque(true);
		lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblViernes.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(0, 102, 204)));
		lblViernes.setBackground(new Color(204, 255, 255));
		lblViernes.setBounds(520, 159, 100, 50);
		getContentPane().add(lblViernes);
		
		JLabel lblHoraInicio = new JLabel("");
		lblHoraInicio.setOpaque(true);
		lblHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraInicio.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraInicio.setBackground(new Color(204, 255, 255));
		lblHoraInicio.setBounds(20, 207, 100, 50);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraDos = new JLabel("");
		lblHoraDos.setOpaque(true);
		lblHoraDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraDos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraDos.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraDos.setBackground(new Color(204, 255, 255));
		lblHoraDos.setBounds(20, 257, 100, 50);
		getContentPane().add(lblHoraDos);
		
		JLabel lblHoraTres = new JLabel("");
		lblHoraTres.setOpaque(true);
		lblHoraTres.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraTres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraTres.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraTres.setBackground(new Color(204, 255, 255));
		lblHoraTres.setBounds(20, 307, 100, 50);
		getContentPane().add(lblHoraTres);
		
		JLabel lblHoraFinal = new JLabel("");
		lblHoraFinal.setOpaque(true);
		lblHoraFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraFinal.setBorder(new MatteBorder(0, 2, 2, 1, (Color) new Color(0, 102, 204)));
		lblHoraFinal.setBackground(new Color(204, 255, 255));
		lblHoraFinal.setBounds(20, 357, 100, 50);
		getContentPane().add(lblHoraFinal);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}
}
