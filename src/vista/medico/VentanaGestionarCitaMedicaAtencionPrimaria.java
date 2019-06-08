package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.text.JTextComponent;

import vista.ventanaPrincipal;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class VentanaGestionarCitaMedicaAtencionPrimaria extends JFrame{
	
	private JTextField getTxtObservaciones;
	private JTextField txtNombreMedico;
	private JTextField txtNombrePaciente;
	private JTextField getTxtDosis;
	private JTextField getTxtFechaInicio;
	private JTextField getTxtFechaFin;

	public VentanaGestionarCitaMedicaAtencionPrimaria() {
	setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
	getContentPane().setBackground(new Color(255, 255, 255));
	getContentPane().setLayout(null);
	
	this.setMinimumSize(new Dimension(750, 500));
	JLabel lblGestionarCitaAtencionPrimaria = new JLabel("GESTIONAR CITA ATENCION PRIMARIA");
	lblGestionarCitaAtencionPrimaria.setOpaque(true);
	lblGestionarCitaAtencionPrimaria.setBackground(new Color(0, 102, 204));
	lblGestionarCitaAtencionPrimaria.setFont(new Font("Verdana", Font.BOLD, 15));
	lblGestionarCitaAtencionPrimaria.setForeground(Color.WHITE);
	lblGestionarCitaAtencionPrimaria.setHorizontalAlignment(SwingConstants.CENTER);
	lblGestionarCitaAtencionPrimaria.setBounds(10, 0, 714, 41);
	getContentPane().add(lblGestionarCitaAtencionPrimaria);
	
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
	
	JButton btnGestionarMedicoAP = new JButton("Gestionar");
	btnGestionarMedicoAP.setFont(new Font("Verdana", Font.BOLD, 12));
	btnGestionarMedicoAP.setBackground(new Color(204, 255, 204));
	btnGestionarMedicoAP.setContentAreaFilled(false);
	btnGestionarMedicoAP.setBorderPainted(false);
	btnGestionarMedicoAP.setOpaque(true);
	btnGestionarMedicoAP.setBounds(397, 405, 111, 23);
	getContentPane().add(btnGestionarMedicoAP);
	
	JButton btnSolicitarEspecialista = new JButton("Solicitar Especialista");
	btnSolicitarEspecialista.setFont(new Font("Verdana", Font.BOLD, 12));
	btnSolicitarEspecialista.setBackground(new Color(204, 255, 204));
	btnSolicitarEspecialista.setContentAreaFilled(false);
	btnSolicitarEspecialista.setBorderPainted(false);
	btnSolicitarEspecialista.setOpaque(true);
	btnSolicitarEspecialista.setBounds(518, 405, 188, 23);
	getContentPane().add(btnSolicitarEspecialista);
	}
}
