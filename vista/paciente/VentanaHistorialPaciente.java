package vista.paciente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import vista.ventanaPrincipal;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VentanaHistorialPaciente extends JDialog {
	protected JTextField txtPaciente;
	private JTable tablaTratamiento;
	private JTable tablaIntervencion;
	private JTextField getTxtBuscar;
	int pX,pY;
	
	public VentanaHistorialPaciente() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 700, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		JPanel panelHistorialPaciente = new JPanel();
		panelHistorialPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY();
			}
		});
		panelHistorialPaciente.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		panelHistorialPaciente.setBackground(Color.WHITE);
	
		getContentPane().add(panelHistorialPaciente);
		panelHistorialPaciente.setLayout(null);
				
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
				btnCerrar.setBounds(663, 0, 37, 31);
				panelHistorialPaciente.add(btnCerrar);
				
				JLabel lblHistorialPaciente = new JLabel("HISTORIAL PACIENTE");
				lblHistorialPaciente.setIcon(new ImageIcon(VentanaHistorialPaciente.class.getResource("/images/iconventana.png")));
				lblHistorialPaciente.setOpaque(true);
				lblHistorialPaciente.setHorizontalAlignment(SwingConstants.LEFT);
				lblHistorialPaciente.setForeground(Color.WHITE);
				lblHistorialPaciente.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblHistorialPaciente.setBackground(SystemColor.textHighlight);
				lblHistorialPaciente.setBounds(0, 0, 700, 31);
				panelHistorialPaciente.add(lblHistorialPaciente);
		
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setBounds(31, 40, 81, 26);
				panelHistorialPaciente.add(lblPaciente);
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 13));
				
				txtPaciente = new JTextField();
				txtPaciente.setBounds(132, 45, 206, 19);
				panelHistorialPaciente.add(txtPaciente);
				txtPaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtPaciente.setForeground(new Color(0, 0, 102));
				txtPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtPaciente.setBackground(Color.WHITE);
				txtPaciente.setEditable(false);
				txtPaciente.setColumns(10);
				txtPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				JLabel lblTratamiento = new JLabel("Tratamiento");
				lblTratamiento.setBounds(31, 141, 129, 26);
				panelHistorialPaciente.add(lblTratamiento);
				lblTratamiento.setForeground(new Color(0, 102, 204));
				lblTratamiento.setFont(new Font("Verdana", Font.BOLD, 13));
				
				getTxtBuscar = new JTextField();
				getTxtBuscar.setBounds(31, 178, 193, 20);
				panelHistorialPaciente.add(getTxtBuscar);
				getTxtBuscar.setForeground(new Color(0, 0, 102));
				getTxtBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
				getTxtBuscar.setColumns(10);
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(249, 177, 89, 23);
				panelHistorialPaciente.add(btnBuscar);
				btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setContentAreaFilled(false);
				btnBuscar.setBorderPainted(false);
				btnBuscar.setOpaque(true);
				btnBuscar.setBackground(new Color(0, 102, 204));
				
				JButton btnVer = new JButton("Ver");
				btnVer.setBounds(249, 224, 89, 23);
				panelHistorialPaciente.add(btnVer);
				btnVer.setFont(new Font("Verdana", Font.BOLD, 11));
				btnVer.setForeground(Color.WHITE);
				btnVer.setContentAreaFilled(false);
				btnVer.setBorderPainted(false);
				btnVer.setOpaque(true);
				btnVer.setBackground(new Color(0, 102, 204));
				
				JLabel lblCitasPendientes = new JLabel("Citas Pendientes");
				lblCitasPendientes.setBounds(400, 40, 270, 15);
				panelHistorialPaciente.add(lblCitasPendientes);
				lblCitasPendientes.setForeground(new Color(0, 102, 204));
				lblCitasPendientes.setFont(new Font("Verdana", Font.BOLD, 13));
				
				JLabel lblCitasRealizadas = new JLabel("Citas Realizadas");
				lblCitasRealizadas.setBounds(400, 260, 270, 15);
				panelHistorialPaciente.add(lblCitasRealizadas);
				lblCitasRealizadas.setForeground(new Color(0, 102, 204));
				lblCitasRealizadas.setFont(new Font("Verdana", Font.BOLD, 13));
		
	}
	}