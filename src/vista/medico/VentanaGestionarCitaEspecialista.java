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
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

public class VentanaGestionarCitaEspecialista extends JDialog{
	private JTextField txtDosis;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private JTextField txtObservaciones;
	private JTextField txtNombrePaciente;
	private JTextField txtNombreMedico;
	private JButton btnGestionarEspecialista;
	private JButton btnSolicitarIntervencion;
	int pX,pY;
	
	public VentanaGestionarCitaEspecialista() {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 750, 500);
		setUndecorated(true);
		setModal(true);
		
			JPanel panelGestionarCitaEspecialista = new JPanel();
			panelGestionarCitaEspecialista.setBorder(new LineBorder(new Color(153, 204, 255)));
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
				
				JLabel lblGestionarCitaEspecialista = new JLabel("GESTIONAR CITA ESPECIALISTA");
				lblGestionarCitaEspecialista.setIcon(new ImageIcon(VentanaGestionarCitaEspecialista.class.getResource("/images/iconventana.png")));
				lblGestionarCitaEspecialista.setOpaque(true);
				lblGestionarCitaEspecialista.setHorizontalAlignment(SwingConstants.LEFT);
				lblGestionarCitaEspecialista.setForeground(Color.WHITE);
				lblGestionarCitaEspecialista.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblGestionarCitaEspecialista.setBackground(SystemColor.textHighlight);
				lblGestionarCitaEspecialista.setBounds(0, 0, 750, 31);
				panelGestionarCitaEspecialista.add(lblGestionarCitaEspecialista);
				
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
				
				JComboBox comboBoxTratamiento = new JComboBox();
				comboBoxTratamiento.setForeground(new Color(0, 0, 102));
				comboBoxTratamiento.setFont(new Font("Tahoma", Font.BOLD, 13));
				comboBoxTratamiento.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				comboBoxTratamiento.setBounds(71, 102, 222, 20);
				panelGestionarCitaEspecialista.add(comboBoxTratamiento);
				
				txtDosis = new JTextField();
				txtDosis.setHorizontalAlignment(SwingConstants.CENTER);
				txtDosis.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtDosis.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtDosis.setBounds(180, 140, 113, 20);				
				txtDosis.setColumns(10);
				panelGestionarCitaEspecialista.add(txtDosis);
				
				txtFechaInicio = new JTextField();
				txtFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
				txtFechaInicio.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtFechaInicio.setBounds(180, 179, 113, 20);				
				txtFechaInicio.setColumns(10);
				panelGestionarCitaEspecialista.add(txtFechaInicio);
				
				txtFechaFin = new JTextField();
				txtFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
				txtFechaFin.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtFechaFin.setBounds(180, 217, 113, 20);	
				txtFechaFin.setColumns(10);
				panelGestionarCitaEspecialista.add(txtFechaFin);
				
				txtObservaciones = new JTextField();
				txtObservaciones.setBounds(71, 288, 222, 110);
				txtObservaciones.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
				txtObservaciones.setColumns(10);
				panelGestionarCitaEspecialista.add(txtObservaciones);
				
				txtNombrePaciente = new JTextField();
				txtNombrePaciente.setBackground(Color.WHITE);
				txtNombrePaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombrePaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombrePaciente.setForeground(new Color(0, 0, 102));
				txtNombrePaciente.setBounds(487, 101, 222, 20);			
				txtNombrePaciente.setEditable(false);
				txtNombrePaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombrePaciente.setColumns(10);
				panelGestionarCitaEspecialista.add(txtNombrePaciente);
				
				txtNombreMedico = new JTextField();
				txtNombreMedico.setBackground(Color.WHITE);
				txtNombreMedico.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombreMedico.setForeground(new Color(0, 0, 102));
				txtNombreMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombreMedico.setBounds(487, 140, 222, 20);			
				txtNombreMedico.setEditable(false);
				txtNombreMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtNombreMedico.setColumns(10);
				panelGestionarCitaEspecialista.add(txtNombreMedico);
				
				JCheckBox chckbxConfirmarAsistencia = new JCheckBox("Confirmar Asistencia");
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
				
				btnSolicitarIntervencion = new JButton("Solicitar Intervenci\u00F3n");
				btnSolicitarIntervencion.setBounds(534, 430, 184, 23);			
				btnSolicitarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
				btnSolicitarIntervencion.setBackground(new Color(204, 255, 204));
				btnSolicitarIntervencion.setContentAreaFilled(false);
				btnSolicitarIntervencion.setBorderPainted(false);
				btnSolicitarIntervencion.setOpaque(true);
				panelGestionarCitaEspecialista.add(btnSolicitarIntervencion);
		
	}
}