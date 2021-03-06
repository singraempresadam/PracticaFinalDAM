package vista.medico;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;

public class VentanaGestionarCitaMedicaAtencionPrimaria extends JDialog{
	private JTextField txtDosis;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtObservaciones;
	private JTextField txtNombrePaciente;
	private JTextField txtNombreMedico;
	private JComboBox comboBoxTratamiento;
	private JCheckBox chckbxConfirmarAsistencia;
	private JButton btnGestionar;
	private JButton btnSolicitar;
	int pX,pY;
	private JLabel lblConsulta;
	private JTextField txtConsulta;
	private JLabel lblGestionarCitaMedicaAP;
	
	public VentanaGestionarCitaMedicaAtencionPrimaria() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 750, 500);
		setUndecorated(true);
		setModal(true);
		
			JPanel panelGestionarCitaAtencionPrimaria = new JPanel();
			panelGestionarCitaAtencionPrimaria.setBorder(new LineBorder(new Color(153, 204, 255)));
			panelGestionarCitaAtencionPrimaria.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelGestionarCitaAtencionPrimaria.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelGestionarCitaAtencionPrimaria.setBackground(Color.WHITE);
			getContentPane().add(panelGestionarCitaAtencionPrimaria);
			panelGestionarCitaAtencionPrimaria.setLayout(null);
				
				JButton btnCerrar = new JButton("");
				btnCerrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				btnCerrar.setBackground(new Color(0, 153, 255));
				btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
				btnCerrar.setContentAreaFilled(false);
				btnCerrar.setBorderPainted(false);
				btnCerrar.setOpaque(true);
				btnCerrar.setBounds(713, 0, 37, 31);
				panelGestionarCitaAtencionPrimaria.add(btnCerrar);
				
				lblGestionarCitaMedicaAP = new JLabel("GESTIONAR CITA ATENCION PRIMARIA");
				lblGestionarCitaMedicaAP.setIcon(new ImageIcon(VentanaGestionarCitaEspecialista.class.getResource("/images/iconventana.png")));
				lblGestionarCitaMedicaAP.setOpaque(true);
				lblGestionarCitaMedicaAP.setHorizontalAlignment(SwingConstants.LEFT);
				lblGestionarCitaMedicaAP.setForeground(Color.WHITE);
				lblGestionarCitaMedicaAP.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblGestionarCitaMedicaAP.setBackground(SystemColor.textHighlight);
				lblGestionarCitaMedicaAP.setBounds(0, 0, 750, 31);
				panelGestionarCitaAtencionPrimaria.add(lblGestionarCitaMedicaAP);
				
				JLabel lblTratamiento = new JLabel("Tratamiento");
				lblTratamiento.setBounds(71, 68, 222, 23);
				lblTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
				lblTratamiento.setForeground(new Color(0, 102, 204));
				lblTratamiento.setFont(new Font("Verdana", Font.BOLD, 14));
				panelGestionarCitaAtencionPrimaria.add(lblTratamiento);
				
				JLabel lblDosis = new JLabel("Dosis");
				lblDosis.setForeground(new Color(0, 102, 204));
				lblDosis.setFont(new Font("Verdana", Font.BOLD, 12));
				lblDosis.setBounds(71, 142, 78, 14);
				panelGestionarCitaAtencionPrimaria.add(lblDosis);
				
				JLabel lblFechaInicio = new JLabel("Fecha Inicio");
				lblFechaInicio.setForeground(new Color(0, 102, 204));
				lblFechaInicio.setFont(new Font("Verdana", Font.BOLD, 12));
				lblFechaInicio.setBounds(71, 181, 92, 14);
				panelGestionarCitaAtencionPrimaria.add(lblFechaInicio);
				
				JLabel lblFechaFin = new JLabel("Fecha Fin");
				lblFechaFin.setFont(new Font("Verdana", Font.BOLD, 12));
				lblFechaFin.setForeground(new Color(0, 102, 204));
				lblFechaFin.setBounds(71, 219, 78, 14);
				panelGestionarCitaAtencionPrimaria.add(lblFechaFin);
				
				JLabel lblMedico = new JLabel("Medico");
				lblMedico.setForeground(new Color(0, 102, 204));
				lblMedico.setFont(new Font("Verdana", Font.BOLD, 12));
				lblMedico.setBounds(382, 142, 46, 14);
				panelGestionarCitaAtencionPrimaria.add(lblMedico);
				
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 12));
				lblPaciente.setBounds(382, 104, 61, 14);
				panelGestionarCitaAtencionPrimaria.add(lblPaciente);
				
				JLabel lblObservaciones = new JLabel("Observaciones");
				lblObservaciones.setForeground(new Color(0, 102, 204));
				lblObservaciones.setFont(new Font("Verdana", Font.BOLD, 12));
				lblObservaciones.setBounds(71, 258, 132, 14);
				panelGestionarCitaAtencionPrimaria.add(lblObservaciones);
				
				comboBoxTratamiento = new JComboBox();
				comboBoxTratamiento.setForeground(new Color(0, 0, 102));
				comboBoxTratamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
				comboBoxTratamiento.setBounds(71, 104, 222, 20);
				panelGestionarCitaAtencionPrimaria.add(comboBoxTratamiento);
				
				txtDosis = new JTextField();
				txtDosis.setHorizontalAlignment(SwingConstants.CENTER);
				txtDosis.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtDosis.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtDosis.setBounds(180, 140, 113, 20);				
				txtDosis.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtDosis);
				
				txtFechaInicio = new JTextField();
				txtFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
				txtFechaInicio.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtFechaInicio.setBounds(180, 179, 113, 20);				
				txtFechaInicio.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtFechaInicio);
				
				txtFechaFin = new JTextField();
				txtFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
				txtFechaFin.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtFechaFin.setBounds(180, 217, 113, 20);	
				txtFechaFin.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtFechaFin);
				
				txtObservaciones = new JTextField();
				txtObservaciones.setBounds(71, 288, 222, 110);
				txtObservaciones.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
				txtObservaciones.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtObservaciones);
				
				txtNombrePaciente = new JTextField();
				txtNombrePaciente.setBackground(Color.WHITE);
				txtNombrePaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombrePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombrePaciente.setForeground(new Color(0, 0, 102));
				txtNombrePaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombrePaciente.setBounds(487, 101, 222, 20);		
				txtNombrePaciente.setEditable(false);
				txtNombrePaciente.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtNombrePaciente);
				
				txtNombreMedico = new JTextField();
				txtNombreMedico.setBackground(Color.WHITE);
				txtNombreMedico.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombreMedico.setForeground(new Color(0, 0, 102));
				txtNombreMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombreMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombreMedico.setBounds(487, 140, 222, 20);			
				txtNombreMedico.setEditable(false);
				txtNombreMedico.setColumns(10);
				panelGestionarCitaAtencionPrimaria.add(txtNombreMedico);
				
				chckbxConfirmarAsistencia = new JCheckBox("Confirmar Asistencia");
				chckbxConfirmarAsistencia.setBounds(487, 288, 222, 23);	
				chckbxConfirmarAsistencia.setFont(new Font("Tahoma", Font.BOLD, 11));
				chckbxConfirmarAsistencia.setBackground(new Color(204, 255, 255));
				panelGestionarCitaAtencionPrimaria.add(chckbxConfirmarAsistencia);
				
				btnGestionar = new JButton("Gestionar");
				btnGestionar.setBounds(416, 430, 108, 23);			
				btnGestionar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnGestionar.setBackground(new Color(204, 255, 204));
				btnGestionar.setContentAreaFilled(false);
				btnGestionar.setBorderPainted(false);
				btnGestionar.setOpaque(true);
				panelGestionarCitaAtencionPrimaria.add(btnGestionar);
				
				btnSolicitar = new JButton("Solicitar Especialista");
				btnSolicitar.setBounds(534, 430, 184, 23);			
				btnSolicitar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnSolicitar.setBackground(new Color(204, 255, 204));
				btnSolicitar.setContentAreaFilled(false);
				btnSolicitar.setBorderPainted(false);
				btnSolicitar.setOpaque(true);
				panelGestionarCitaAtencionPrimaria.add(btnSolicitar);
				
				lblConsulta = new JLabel("Consulta");
				lblConsulta.setForeground(new Color(0, 102, 204));
				lblConsulta.setFont(new Font("Verdana", Font.BOLD, 12));
				lblConsulta.setBounds(382, 182, 78, 14);
				panelGestionarCitaAtencionPrimaria.add(lblConsulta);
				
				txtConsulta = new JTextField();
				txtConsulta.setHorizontalAlignment(SwingConstants.CENTER);
				txtConsulta.setForeground(new Color(0, 0, 102));
				txtConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtConsulta.setEditable(false);
				txtConsulta.setColumns(10);
				txtConsulta.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtConsulta.setBackground(Color.WHITE);
				txtConsulta.setBounds(487, 179, 222, 20);
				panelGestionarCitaAtencionPrimaria.add(txtConsulta);
		
	}

	public JTextField getTxtDosis() {
		return txtDosis;
	}

	public void setTxtDosis(JTextField txtDosis) {
		this.txtDosis = txtDosis;
	}

	public JTextField getTxtFechaInicio() {
		return txtFechaInicio;
	}

	public void setTxtFechaInicio(JTextField txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}

	public JTextField getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(JTextField txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	public JTextField getTxtObservaciones() {
		return txtObservaciones;
	}

	public void setTxtObservaciones(JTextField txtObservaciones) {
		this.txtObservaciones = txtObservaciones;
	}

	public JTextField getTxtNombrePaciente() {
		return txtNombrePaciente;
	}

	public void setTxtNombrePaciente(JTextField txtNombrePaciente) {
		this.txtNombrePaciente = txtNombrePaciente;
	}

	public JTextField getTxtNombreMedico() {
		return txtNombreMedico;
	}

	public void setTxtNombreMedico(JTextField txtNombreMedico) {
		this.txtNombreMedico = txtNombreMedico;
	}

	public JComboBox getComboBoxTratamiento() {
		return comboBoxTratamiento;
	}

	public void setComboBoxTratamiento(JComboBox comboBoxTratamiento) {
		this.comboBoxTratamiento = comboBoxTratamiento;
	}

	public JCheckBox getChckbxConfirmarAsistencia() {
		return chckbxConfirmarAsistencia;
	}

	public void setChckbxConfirmarAsistencia(JCheckBox chckbxConfirmarAsistencia) {
		this.chckbxConfirmarAsistencia = chckbxConfirmarAsistencia;
	}

	public JButton getBtnGestionar() {
		return btnGestionar;
	}

	public void setBtnGestionar(JButton btnGestionar) {
		this.btnGestionar = btnGestionar;
	}


	public JButton getBtnSolicitar() {
		return btnSolicitar;
	}

	public void setBtnSolicitar(JButton btnSolicitar) {
		this.btnSolicitar = btnSolicitar;
	}

	public JLabel getLblConsulta() {
		return lblConsulta;
	}

	public void setLblConsulta(JLabel lblConsulta) {
		this.lblConsulta = lblConsulta;
	}

	public JTextField getTxtConsulta() {
		return txtConsulta;
	}

	public void setTxtConsulta(JTextField txtConsulta) {
		this.txtConsulta = txtConsulta;
	}

	public JLabel getLblGestionarCitaMedicaAP() {
		return lblGestionarCitaMedicaAP;
	}

	public void setLblGestionarCitaMedicaAP(JLabel lblGestionarCitaMedicaAP) {
		this.lblGestionarCitaMedicaAP = lblGestionarCitaMedicaAP;
	}
	
	
}