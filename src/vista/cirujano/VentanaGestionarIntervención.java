package vista.cirujano;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class VentanaGestionarIntervención extends JDialog {
	private JTextField txtObservaciones;
	private JTextField txtIntervencion;
	private JTextField txtEspecialista;
	private JTextField txtCirujano;
	private JTextField txtPaciente;
	private JTextField txtFecha;
	int pX,pY;

	public VentanaGestionarIntervención() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			JPanel panelGestionarIntervencion = new JPanel();
			panelGestionarIntervencion.setBorder(new LineBorder(new Color(153, 204, 255)));
			panelGestionarIntervencion.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelGestionarIntervencion.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelGestionarIntervencion.setBackground(Color.WHITE);
			getContentPane().add(panelGestionarIntervencion);
			panelGestionarIntervencion.setLayout(null);
		
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
				btnCerrar.setBounds(763, 0, 37, 31);
				panelGestionarIntervencion.add(btnCerrar);
				
				JLabel lblGestionarIntervencion = new JLabel("GESTIONAR INTERVENCION");
				lblGestionarIntervencion.setIcon(new ImageIcon(VentanaGestionarIntervención.class.getResource("/images/iconventana.png")));
				lblGestionarIntervencion.setOpaque(true);
				lblGestionarIntervencion.setHorizontalAlignment(SwingConstants.LEFT);
				lblGestionarIntervencion.setForeground(Color.WHITE);
				lblGestionarIntervencion.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblGestionarIntervencion.setBackground(SystemColor.textHighlight);
				lblGestionarIntervencion.setBounds(0, 0, 800, 31);
				panelGestionarIntervencion.add(lblGestionarIntervencion);
				
				JLabel lblNombreIntervencion = new JLabel("Intervencion");
				lblNombreIntervencion.setBounds(54, 78, 270, 19);
				panelGestionarIntervencion.add(lblNombreIntervencion);
				lblNombreIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
				lblNombreIntervencion.setForeground(new Color(0, 102, 204));
				lblNombreIntervencion.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtIntervencion = new JTextField();
				txtIntervencion.setBounds(54, 108, 270, 19);
				panelGestionarIntervencion.add(txtIntervencion);
				txtIntervencion.setForeground(new Color(0, 0, 102));
				txtIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
				txtIntervencion.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtIntervencion.setBackground(Color.WHITE);
				txtIntervencion.setEditable(false);
				txtIntervencion.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtIntervencion.setColumns(10);
				
				JLabel lblObservacion = new JLabel("Observaciones");
				lblObservacion.setBounds(54, 170, 145, 19);
				panelGestionarIntervencion.add(lblObservacion);
				lblObservacion.setForeground(new Color(0, 102, 204));
				lblObservacion.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtObservaciones = new JTextField();
				txtObservaciones.setBounds(54, 210, 270, 163);
				panelGestionarIntervencion.add(txtObservaciones);
				txtObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtObservaciones.setBackground(Color.WHITE);
				txtObservaciones.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
				txtObservaciones.setColumns(10);
				
				JLabel lblEspecialista = new JLabel("Especialista");
				lblEspecialista.setBounds(399, 170, 100, 19);
				panelGestionarIntervencion.add(lblEspecialista);
				lblEspecialista.setForeground(new Color(0, 102, 204));
				lblEspecialista.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtEspecialista = new JTextField();
				txtEspecialista.setBounds(509, 171, 230, 18);
				panelGestionarIntervencion.add(txtEspecialista);
				txtEspecialista.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtEspecialista.setHorizontalAlignment(SwingConstants.CENTER);
				txtEspecialista.setForeground(new Color(0, 0, 102));
				txtEspecialista.setBackground(Color.WHITE);
				txtEspecialista.setEditable(false);
				txtEspecialista.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtEspecialista.setColumns(10);
				
				JLabel lblCirujano = new JLabel("Cirujano");
				lblCirujano.setBounds(399, 210, 100, 19);
				panelGestionarIntervencion.add(lblCirujano);
				lblCirujano.setForeground(new Color(0, 102, 204));
				lblCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtCirujano = new JTextField();
				txtCirujano.setBounds(509, 210, 230, 19);
				panelGestionarIntervencion.add(txtCirujano);
				txtCirujano.setBackground(Color.WHITE);
				txtCirujano.setHorizontalAlignment(SwingConstants.CENTER);
				txtCirujano.setForeground(new Color(0, 0, 102));
				txtCirujano.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtCirujano.setEditable(false);
				txtCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtCirujano.setColumns(10);
				
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setBounds(399, 251, 100, 19);
				panelGestionarIntervencion.add(lblPaciente);
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtPaciente = new JTextField();
				txtPaciente.setBounds(509, 251, 230, 19);
				panelGestionarIntervencion.add(txtPaciente);
				txtPaciente.setBackground(Color.WHITE);
				txtPaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtPaciente.setForeground(new Color(0, 0, 102));
				txtPaciente.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtPaciente.setEditable(false);
				txtPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtPaciente.setColumns(10);
				
				JLabel lblFecha = new JLabel("Fecha");
				lblFecha.setBounds(399, 294, 100, 19);
				panelGestionarIntervencion.add(lblFecha);
				lblFecha.setForeground(new Color(0, 102, 204));
				lblFecha.setFont(new Font("Verdana", Font.BOLD, 14));
				
				txtFecha = new JTextField();
				txtFecha.setBounds(509, 294, 230, 19);
				panelGestionarIntervencion.add(txtFecha);
				txtFecha.setBackground(Color.WHITE);
				txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
				txtFecha.setForeground(new Color(0, 0, 102));
				txtFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtFecha.setEditable(false);
				txtFecha.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtFecha.setColumns(10);
				
				JCheckBox chckbxConfirmarAsistencia = new JCheckBox("Confirmar asistencia");
				chckbxConfirmarAsistencia.setBounds(509, 350, 230, 23);
				panelGestionarIntervencion.add(chckbxConfirmarAsistencia);
				chckbxConfirmarAsistencia.setFont(new Font("Tahoma", Font.BOLD, 11));
				chckbxConfirmarAsistencia.setBackground(new Color(204, 255, 255));
				
				JButton btnGestionarIntervencion = new JButton("Gestionar");
				btnGestionarIntervencion.setBounds(554, 437, 145, 23);
				btnGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
				btnGestionarIntervencion.setBackground(new Color(204, 255, 204));
				btnGestionarIntervencion.setContentAreaFilled(false);
				btnGestionarIntervencion.setOpaque(true);
				panelGestionarIntervencion.add(btnGestionarIntervencion);
	}
}