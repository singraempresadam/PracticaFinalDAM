package vista.medico;

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

import vista.ventanaPrincipal;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JList;

public class VentanaSolicitarIntervencion extends JFrame {
	private JButton btnVerHorario;
	private JPanel panelHorarioMedico;
	private JTextField getTxtCirujano;
	private JComboBox comboBoxIntervencion;

	public VentanaSolicitarIntervencion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		this.setMinimumSize(new Dimension(950, 500));
		JLabel lblSolicitarIntervencion = new JLabel("SOLICITAR INTERVENCION");
		lblSolicitarIntervencion.setOpaque(true);
		lblSolicitarIntervencion.setBackground(new Color(0, 102, 204));
		lblSolicitarIntervencion.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSolicitarIntervencion.setForeground(Color.WHITE);
		lblSolicitarIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitarIntervencion.setBounds(10, 11, 914, 41);
		getContentPane().add(lblSolicitarIntervencion);
		
		btnVerHorario = new JButton("Ver horario");
		btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVerHorario.setBackground(new Color(204, 255, 204));
		btnVerHorario.setContentAreaFilled(false);
		btnVerHorario.setBorderPainted(false);
		btnVerHorario.setOpaque(true);
		btnVerHorario.setBounds(498, 124, 122, 23);
		getContentPane().add(btnVerHorario);
		
		panelHorarioMedico = new JPanel();
		panelHorarioMedico.setBounds(120, 257, 500, 100);
		getContentPane().add(panelHorarioMedico);
		panelHorarioMedico.setLayout(null);
		
		JLabel lblCirujano = new JLabel("Cirujano");
		lblCirujano.setForeground(new Color(0, 102, 204));
		lblCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCirujano.setBounds(50, 78, 89, 19);
		getContentPane().add(lblCirujano);
		
		getTxtCirujano = new JTextField();
		getTxtCirujano.setColumns(10);
		getTxtCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
		getTxtCirujano.setBackground(Color.WHITE);
		getTxtCirujano.setBounds(149, 79, 303, 20);
		getContentPane().add(getTxtCirujano);
		
		JLabel lblLunes = new JLabel("Lunes");
		lblLunes.setBorder(new MatteBorder(2, 2, 0, 1, (Color) new Color(0, 102, 204)));
		lblLunes.setBackground(new Color(204, 255, 255));
		lblLunes.setOpaque(true);
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunes.setBounds(120, 209, 100, 50);
		getContentPane().add(lblLunes);
		
		JLabel lblMartes = new JLabel("Martes");
		lblMartes.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblMartes.setOpaque(true);
		lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMartes.setBackground(new Color(204, 255, 255));
		lblMartes.setBounds(220, 209, 100, 50);
		getContentPane().add(lblMartes);
		
		JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
		lblMiercoles.setOpaque(true);
		lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
		lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMiercoles.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblMiercoles.setBackground(new Color(204, 255, 255));
		lblMiercoles.setBounds(320, 209, 100, 50);
		getContentPane().add(lblMiercoles);
		
		JLabel lblJueves = new JLabel("Jueves");
		lblJueves.setOpaque(true);
		lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
		lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJueves.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
		lblJueves.setBackground(new Color(204, 255, 255));
		lblJueves.setBounds(420, 209, 100, 50);
		getContentPane().add(lblJueves);
		
		JLabel lblViernes = new JLabel("Viernes");
		lblViernes.setOpaque(true);
		lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
		lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblViernes.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(0, 102, 204)));
		lblViernes.setBackground(new Color(204, 255, 255));
		lblViernes.setBounds(520, 209, 100, 50);
		getContentPane().add(lblViernes);
		
		JLabel lblHoraInicio = new JLabel("10:00");
		lblHoraInicio.setOpaque(true);
		lblHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraInicio.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraInicio.setBackground(new Color(204, 255, 255));
		lblHoraInicio.setBounds(20, 257, 100, 50);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraDos = new JLabel("17:00");
		lblHoraDos.setOpaque(true);
		lblHoraDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraDos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoraDos.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
		lblHoraDos.setBackground(new Color(204, 255, 255));
		lblHoraDos.setBounds(20, 307, 100, 50);
		getContentPane().add(lblHoraDos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnBuscar.setBackground(new Color(204, 255, 204));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setOpaque(true);
		btnBuscar.setBounds(498, 78, 122, 23);
		getContentPane().add(btnBuscar);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(149, 110, 303, 75);
		getContentPane().add(list);
		
		JLabel lblEspecialista = new JLabel("Especialista ");
		lblEspecialista.setForeground(new Color(0, 102, 204));
		lblEspecialista.setFont(new Font("Verdana", Font.BOLD, 14));
		lblEspecialista.setBounds(642, 229, 100, 19);
		getContentPane().add(lblEspecialista);
		
		JLabel lblNombreEspecialista = new JLabel("");
		lblNombreEspecialista.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblNombreEspecialista.setBounds(765, 229, 159, 19);
		getContentPane().add(lblNombreEspecialista);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setForeground(new Color(0, 102, 204));
		lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPaciente.setBounds(642, 277, 100, 19);
		getContentPane().add(lblPaciente);
		
		JLabel lblIntervencion = new JLabel("Intervencion");
		lblIntervencion.setForeground(new Color(0, 102, 204));
		lblIntervencion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIntervencion.setBounds(642, 327, 113, 19);
		getContentPane().add(lblIntervencion);
		
		comboBoxIntervencion = new JComboBox();
		comboBoxIntervencion.setBounds(765, 329, 159, 18);
		getContentPane().add(comboBoxIntervencion);
		
		JButton btnSolicitarIntervencion = new JButton("Solicitar");
		btnSolicitarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSolicitarIntervencion.setBackground(new Color(204, 255, 204));
		btnSolicitarIntervencion.setContentAreaFilled(false);
		btnSolicitarIntervencion.setBorderPainted(false);
		btnSolicitarIntervencion.setOpaque(true);
		btnSolicitarIntervencion.setBounds(820, 415, 89, 23);
		getContentPane().add(btnSolicitarIntervencion);
		
		JLabel lblNombrePaciente = new JLabel("");
		lblNombrePaciente.setBorder(new LineBorder(new Color(204, 255, 255), 2));
		lblNombrePaciente.setBounds(765, 277, 159, 19);
		getContentPane().add(lblNombrePaciente);
		
		
		this.setMinimumSize(new Dimension(750, 500));
	}

	public JComboBox getComboBoxIntervencion() {
		return comboBoxIntervencion;
	}

	

}
