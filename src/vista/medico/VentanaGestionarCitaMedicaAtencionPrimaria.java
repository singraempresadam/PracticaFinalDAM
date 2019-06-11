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
	
int pX,pY;
private JTextField getTxtDosis;
private JTextField getTxtFechaInicio;
private JTextField getTxtFechaFin;
private JTextField getTxtObservaciones;
private JTextField txtNombrePaciente;
private JTextField txtNombreMedico;
private JComboBox comboBoxTratamiento;
private JCheckBox chckbxConfirmarAsistencia;
private JButton btnGestionarEspecialista;
private JButton btnSolicitarEspecialista;
	
	public VentanaGestionarCitaMedicaAtencionPrimaria() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 750, 500);
		setUndecorated(true);
		
			JPanel panelGestionarCitaEspecialista = new JPanel();
			panelGestionarCitaEspecialista.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelGestionarCitaEspecialista.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelGestionarCitaEspecialista.setBackground(Color.WHITE);
			getContentPane().add(panelGestionarCitaEspecialista);
			panelGestionarCitaEspecialista.setLayout(null);
				
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
				panelGestionarCitaEspecialista.add(btnCerrar);
				
				JLabel lblGestionarCitaMedicaAP = new JLabel("GESTIONAR CITA ATENCION PRIMARIA");
				lblGestionarCitaMedicaAP.setIcon(new ImageIcon(VentanaGestionarCitaEspecialista.class.getResource("/images/iconventana.png")));
				lblGestionarCitaMedicaAP.setOpaque(true);
				lblGestionarCitaMedicaAP.setHorizontalAlignment(SwingConstants.LEFT);
				lblGestionarCitaMedicaAP.setForeground(Color.WHITE);
				lblGestionarCitaMedicaAP.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblGestionarCitaMedicaAP.setBackground(SystemColor.textHighlight);
				lblGestionarCitaMedicaAP.setBounds(0, 0, 750, 31);
				panelGestionarCitaEspecialista.add(lblGestionarCitaMedicaAP);
				
				JLabel lblTratamiento = new JLabel("Tratamiento");
				lblTratamiento.setBounds(71, 68, 222, 23);
				lblTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
				lblTratamiento.setForeground(new Color(0, 102, 204));
				lblTratamiento.setFont(new Font("Verdana", Font.BOLD, 14));
				panelGestionarCitaEspecialista.add(lblTratamiento);
				
				JLabel lblDosis = new JLabel("Dosis");
				lblDosis.setForeground(new Color(0, 102, 204));
				lblDosis.setFont(new Font("Verdana", Font.BOLD, 12));
				lblDosis.setBounds(71, 142, 78, 14);
				panelGestionarCitaEspecialista.add(lblDosis);
				
				JLabel lblFechaInicio = new JLabel("Fecha Inicio");
				lblFechaInicio.setForeground(new Color(0, 102, 204));
				lblFechaInicio.setFont(new Font("Verdana", Font.BOLD, 12));
				lblFechaInicio.setBounds(71, 181, 92, 14);
				panelGestionarCitaEspecialista.add(lblFechaInicio);
				
				JLabel lblFechaFin = new JLabel("Fecha Fin");
				lblFechaFin.setFont(new Font("Verdana", Font.BOLD, 12));
				lblFechaFin.setForeground(new Color(0, 102, 204));
				lblFechaFin.setBounds(71, 219, 78, 14);
				panelGestionarCitaEspecialista.add(lblFechaFin);
				
				JLabel lblMedico = new JLabel("Medico");
				lblMedico.setForeground(new Color(0, 102, 204));
				lblMedico.setFont(new Font("Verdana", Font.BOLD, 12));
				lblMedico.setBounds(382, 142, 46, 14);
				panelGestionarCitaEspecialista.add(lblMedico);
				
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 12));
				lblPaciente.setBounds(382, 104, 61, 14);
				panelGestionarCitaEspecialista.add(lblPaciente);
				
				JLabel lblObservaciones = new JLabel("Observaciones");
				lblObservaciones.setForeground(new Color(0, 102, 204));
				lblObservaciones.setFont(new Font("Verdana", Font.BOLD, 12));
				lblObservaciones.setBounds(71, 258, 132, 14);
				panelGestionarCitaEspecialista.add(lblObservaciones);
				
				comboBoxTratamiento = new JComboBox();
				comboBoxTratamiento.setForeground(new Color(0, 0, 102));
				comboBoxTratamiento.setFont(new Font("Tahoma", Font.BOLD, 12));
				comboBoxTratamiento.setBounds(71, 104, 222, 20);
				panelGestionarCitaEspecialista.add(comboBoxTratamiento);
				
				getTxtDosis = new JTextField();
				getTxtDosis.setHorizontalAlignment(SwingConstants.CENTER);
				getTxtDosis.setFont(new Font("Tahoma", Font.PLAIN, 11));
				getTxtDosis.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				getTxtDosis.setBounds(180, 140, 113, 20);				
				getTxtDosis.setColumns(10);
				panelGestionarCitaEspecialista.add(getTxtDosis);
				
				getTxtFechaInicio = new JTextField();
				getTxtFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
				getTxtFechaInicio.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				getTxtFechaInicio.setBounds(180, 179, 113, 20);				
				getTxtFechaInicio.setColumns(10);
				panelGestionarCitaEspecialista.add(getTxtFechaInicio);
				
				getTxtFechaFin = new JTextField();
				getTxtFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
				getTxtFechaFin.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				getTxtFechaFin.setBounds(180, 217, 113, 20);	
				getTxtFechaFin.setColumns(10);
				panelGestionarCitaEspecialista.add(getTxtFechaFin);
				
				getTxtObservaciones = new JTextField();
				getTxtObservaciones.setBounds(71, 288, 222, 110);
				getTxtObservaciones.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
				getTxtObservaciones.setColumns(10);
				panelGestionarCitaEspecialista.add(getTxtObservaciones);
				
				txtNombrePaciente = new JTextField();
				txtNombrePaciente.setBackground(Color.WHITE);
				txtNombrePaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombrePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombrePaciente.setForeground(new Color(0, 0, 102));
				txtNombrePaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombrePaciente.setBounds(487, 101, 222, 20);		
				txtNombrePaciente.setEditable(false);
				txtNombrePaciente.setColumns(10);
				panelGestionarCitaEspecialista.add(txtNombrePaciente);
				
				txtNombreMedico = new JTextField();
				txtNombreMedico.setBackground(Color.WHITE);
				txtNombreMedico.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombreMedico.setForeground(new Color(0, 0, 102));
				txtNombreMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombreMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombreMedico.setBounds(487, 140, 222, 20);			
				txtNombreMedico.setEditable(false);
				txtNombreMedico.setColumns(10);
				panelGestionarCitaEspecialista.add(txtNombreMedico);
				
				chckbxConfirmarAsistencia = new JCheckBox("Confirmar Asistencia");
				chckbxConfirmarAsistencia.setBounds(487, 288, 222, 23);	
				chckbxConfirmarAsistencia.setFont(new Font("Tahoma", Font.BOLD, 11));
				chckbxConfirmarAsistencia.setBackground(new Color(204, 255, 255));
				panelGestionarCitaEspecialista.add(chckbxConfirmarAsistencia);
				
				btnGestionarEspecialista = new JButton("Gestionar");
				btnGestionarEspecialista.setBounds(416, 430, 108, 23);			
				btnGestionarEspecialista.setFont(new Font("Verdana", Font.BOLD, 12));
				btnGestionarEspecialista.setBackground(new Color(204, 255, 204));
				btnGestionarEspecialista.setContentAreaFilled(false);
				btnGestionarEspecialista.setBorderPainted(false);
				btnGestionarEspecialista.setOpaque(true);
				panelGestionarCitaEspecialista.add(btnGestionarEspecialista);
				
				btnSolicitarEspecialista = new JButton("Solicitar Especialista");
				btnSolicitarEspecialista.setBounds(534, 430, 184, 23);			
				btnSolicitarEspecialista.setFont(new Font("Verdana", Font.BOLD, 12));
				btnSolicitarEspecialista.setBackground(new Color(204, 255, 204));
				btnSolicitarEspecialista.setContentAreaFilled(false);
				btnSolicitarEspecialista.setBorderPainted(false);
				btnSolicitarEspecialista.setOpaque(true);
				panelGestionarCitaEspecialista.add(btnSolicitarEspecialista);
		
	}

	public JTextField getGetTxtDosis() {
		return getTxtDosis;
	}

	public void setGetTxtDosis(JTextField getTxtDosis) {
		this.getTxtDosis = getTxtDosis;
	}

	public JTextField getGetTxtFechaInicio() {
		return getTxtFechaInicio;
	}

	public void setGetTxtFechaInicio(JTextField getTxtFechaInicio) {
		this.getTxtFechaInicio = getTxtFechaInicio;
	}

	public JTextField getGetTxtFechaFin() {
		return getTxtFechaFin;
	}

	public void setGetTxtFechaFin(JTextField getTxtFechaFin) {
		this.getTxtFechaFin = getTxtFechaFin;
	}

	public JTextField getGetTxtObservaciones() {
		return getTxtObservaciones;
	}

	public void setGetTxtObservaciones(JTextField getTxtObservaciones) {
		this.getTxtObservaciones = getTxtObservaciones;
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

	public JButton getBtnGestionarEspecialista() {
		return btnGestionarEspecialista;
	}

	public void setBtnGestionarEspecialista(JButton btnGestionarEspecialista) {
		this.btnGestionarEspecialista = btnGestionarEspecialista;
	}

	public JButton getBtnSolicitarEspecialista() {
		return btnSolicitarEspecialista;
	}

	public void setBtnSolicitarEspecialista(JButton btnSolicitarEspecialista) {
		this.btnSolicitarEspecialista = btnSolicitarEspecialista;
	}
	
}