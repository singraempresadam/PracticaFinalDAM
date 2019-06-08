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
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;

public class VentanaGestionarCitaEspecialista extends JDialog{
	private JTextField getTxtDosis;
	private JTextField getTxtFechaInicio;
	private JTextField getTxtFechaFin;
	private JTextField getTxtObservaciones;
	private JTextField txtNombrePaciente;
	private JTextField txtNombreMedico;
	public VentanaGestionarCitaEspecialista() {
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
		
		JLabel lblTratamiento = new JLabel("Tratamiento");
		lblTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTratamiento.setForeground(new Color(0, 102, 204));
		lblTratamiento.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTratamiento.setBounds(81, 62, 188, 23);
		getContentPane().add(lblTratamiento);
		
		JComboBox comboBoxTratamiento = new JComboBox();
		comboBoxTratamiento.setBounds(81, 97, 188, 20);
		getContentPane().add(comboBoxTratamiento);
		
		getTxtDosis = new JTextField();
		getTxtDosis.setBounds(183, 142, 86, 20);
		getContentPane().add(getTxtDosis);
		getTxtDosis.setColumns(10);
		
		getTxtFechaInicio = new JTextField();
		getTxtFechaInicio.setBounds(183, 176, 86, 20);
		getContentPane().add(getTxtFechaInicio);
		getTxtFechaInicio.setColumns(10);
		
		getTxtFechaFin = new JTextField();
		getTxtFechaFin.setBounds(183, 210, 86, 20);
		getContentPane().add(getTxtFechaFin);
		getTxtFechaFin.setColumns(10);
		
		JLabel lblDosis = new JLabel("Dosis");
		lblDosis.setBounds(81, 146, 78, 14);
		getContentPane().add(lblDosis);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(81, 179, 78, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(81, 213, 78, 14);
		getContentPane().add(lblFechaFin);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(81, 256, 78, 14);
		getContentPane().add(lblObservaciones);
		
		getTxtObservaciones = new JTextField();
		getTxtObservaciones.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(51, 153, 255)));
		getTxtObservaciones.setBounds(81, 281, 188, 110);
		getContentPane().add(getTxtObservaciones);
		getTxtObservaciones.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setBounds(378, 100, 61, 14);
		getContentPane().add(lblPaciente);
		
		txtNombrePaciente = new JTextField();
		txtNombrePaciente.setEditable(false);
		txtNombrePaciente.setBounds(484, 97, 222, 20);
		getContentPane().add(txtNombrePaciente);
		txtNombrePaciente.setColumns(10);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setBounds(378, 146, 46, 14);
		getContentPane().add(lblMedico);
		
		txtNombreMedico = new JTextField();
		txtNombreMedico.setEditable(false);
		txtNombreMedico.setBounds(484, 143, 222, 20);
		getContentPane().add(txtNombreMedico);
		txtNombreMedico.setColumns(10);
		
		JCheckBox chckbxConfirmarAsistencia = new JCheckBox("Confirmar Asistencia");
		chckbxConfirmarAsistencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxConfirmarAsistencia.setBackground(new Color(204, 255, 255));
		chckbxConfirmarAsistencia.setBounds(484, 232, 222, 23);
		getContentPane().add(chckbxConfirmarAsistencia);
		
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
		
		
	}
}
