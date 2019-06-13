package vista.cirujano;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import vista.ventanaPrincipal;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

public class VentanaHistorialCirujano extends JDialog{
	int pX,pY;
	private JLabel txtNombreCirujano;
	private JPanel panelHistorialCirujano;
	public VentanaHistorialCirujano() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 540, 450);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		panelHistorialCirujano = new JPanel();	
		panelHistorialCirujano.setBorder(new LineBorder(new Color(153, 204, 255)));
		panelHistorialCirujano.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY();
			}
		});	
		panelHistorialCirujano.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		panelHistorialCirujano.setBackground(Color.WHITE);
		getContentPane().add(panelHistorialCirujano, BorderLayout.CENTER);
		panelHistorialCirujano.setLayout(null);
		
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
			btnCerrar.setBounds(503, 0, 37, 31);
			panelHistorialCirujano.add(btnCerrar);
			
			JLabel lblHistorialCirujano = new JLabel("HISTORIAL CIRUJANO");
			lblHistorialCirujano.setIcon(new ImageIcon(VentanaHistorialCirujano.class.getResource("/images/iconventana.png")));
			lblHistorialCirujano.setOpaque(true);
			lblHistorialCirujano.setHorizontalAlignment(SwingConstants.LEFT);
			lblHistorialCirujano.setForeground(Color.WHITE);
			lblHistorialCirujano.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
			lblHistorialCirujano.setBackground(SystemColor.textHighlight);
			lblHistorialCirujano.setBounds(0, 0, 540, 31);
			panelHistorialCirujano.add(lblHistorialCirujano);
			
			JLabel lblCitasPendientes = new JLabel("Citas Pendientes");
			lblCitasPendientes.setForeground(new Color(0, 102, 204));
			lblCitasPendientes.setFont(new Font("Verdana", Font.BOLD, 13));
			lblCitasPendientes.setBounds(10, 55, 270, 15);
			panelHistorialCirujano.add(lblCitasPendientes);
			
			JLabel lblCitasRealizadas = new JLabel("Citas Realizadas");
			lblCitasRealizadas.setForeground(new Color(0, 102, 204));
			lblCitasRealizadas.setFont(new Font("Verdana", Font.BOLD, 13));
			lblCitasRealizadas.setBounds(10, 240, 270, 15);
			panelHistorialCirujano.add(lblCitasRealizadas);
			
			JLabel txtNombre = new JLabel("Nombre:");
			txtNombre.setForeground(new Color(0, 102, 204));
			txtNombre.setFont(new Font("Verdana", Font.BOLD, 13));
			txtNombre.setBounds(292, 55, 67, 15);
			panelHistorialCirujano.add(txtNombre);
			
			txtNombreCirujano = new JLabel("New label");
			txtNombreCirujano.setBounds(375, 55, 153, 16);
			panelHistorialCirujano.add(txtNombreCirujano);
		
	}
	public JLabel getTxtNombreCirujano() {
		return txtNombreCirujano;
	}
	public JPanel getPanelHistorialCirujano() {
		return panelHistorialCirujano;
	}
	
}
