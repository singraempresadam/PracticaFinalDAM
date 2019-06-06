package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class VentanaSolicitarCitaCirujano extends JFrame {
	private JButton btnVerHorario;
	private JPanel panelHorarioMedico;
	private JTextField textField;
	private JTextField textField_1;

	public VentanaSolicitarCitaCirujano() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(750, 500));
		JLabel lblSolicitarCitaCirujano = new JLabel("SOLICITAR CITA CIRUJANO");
		lblSolicitarCitaCirujano.setOpaque(true);
		lblSolicitarCitaCirujano.setBackground(new Color(0, 102, 204));
		lblSolicitarCitaCirujano.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSolicitarCitaCirujano.setForeground(Color.WHITE);
		lblSolicitarCitaCirujano.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitarCitaCirujano.setBounds(10, 11, 714, 41);
		getContentPane().add(lblSolicitarCitaCirujano);
		
		btnVerHorario = new JButton("Ver horario");
		btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVerHorario.setBackground(new Color(204, 255, 204));
		btnVerHorario.setContentAreaFilled(false);
		btnVerHorario.setBorderPainted(false);
		btnVerHorario.setOpaque(true);
		btnVerHorario.setBounds(492, 115, 122, 23);
		getContentPane().add(btnVerHorario);
		
		panelHorarioMedico = new JPanel();
		panelHorarioMedico.setBounds(120, 207, 500, 150);
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
		
		JLabel lblHoraFinal = new JLabel("");
		lblHoraFinal.setOpaque(true);
		lblHoraFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraFinal.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraFinal.setBackground(new Color(204, 255, 255));
		lblHoraFinal.setBounds(20, 307, 100, 50);
		getContentPane().add(lblHoraFinal);
		
		JLabel label = new JLabel("Id Paciente");
		label.setForeground(new Color(0, 102, 204));
		label.setFont(new Font("Verdana", Font.BOLD, 14));
		label.setBounds(24, 83, 179, 26);
		getContentPane().add(label);
		
		JLabel lblIdCirujano = new JLabel("Id Cirujano");
		lblIdCirujano.setForeground(new Color(0, 102, 204));
		lblIdCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIdCirujano.setBounds(24, 120, 196, 19);
		getContentPane().add(lblIdCirujano);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		textField.setBackground(Color.WHITE);
		textField.setBounds(211, 88, 169, 20);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(211, 117, 169, 20);
		getContentPane().add(textField_1);
		
		JButton btnSolicitarCirujano = new JButton("Solicitar");
		btnSolicitarCirujano.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSolicitarCirujano.setBackground(new Color(204, 255, 204));
		btnSolicitarCirujano.setContentAreaFilled(false);
		btnSolicitarCirujano.setBorderPainted(false);
		btnSolicitarCirujano.setOpaque(true);
		btnSolicitarCirujano.setBounds(608, 410, 89, 23);
		getContentPane().add(btnSolicitarCirujano);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}

}
