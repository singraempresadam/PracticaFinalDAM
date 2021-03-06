package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;

public class ventanaPrincipal extends JFrame {

	protected JButton botonPaciente;
	protected JButton botonCirujano;
	protected JButton botonMedico;
	private JLabel lblFechaYHora;
	private JButton btnUnaHora;
	private JButton btnTresHoras;
	private JButton btnDoceHoras;
	private JButton btnVeinticuatroHoras;
	private JButton btnUnDia;
	int pX,pY;
	private JLabel lblClinicaBuenaSalud;
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Create the frame.
	 */
	public ventanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconprograma.png")));
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel panelPrincipal = new JPanel();	
		panelPrincipal.setBorder(new LineBorder(new Color(153, 204, 255)));
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY(); 
			}
		});
		panelPrincipal.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		panelPrincipal.setBounds(0, 0, 750, 561);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setLayout(null);
		getContentPane().add(panelPrincipal);
		
			JButton btnCerrar = new JButton("");
			btnCerrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0); 
				}
			});
			
			btnCerrar.setBackground(new Color(0, 153, 255));
			btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
			btnCerrar.setContentAreaFilled(false);
			btnCerrar.setBorderPainted(false);
			btnCerrar.setOpaque(true);
			btnCerrar.setBounds(714, 0, 36, 31);
			panelPrincipal.add(btnCerrar);
			
			JButton btnMinimizar = new JButton("");
			btnMinimizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setExtendedState(ICONIFIED);
				}
			});
			btnMinimizar.setBackground(Color.WHITE);
			btnMinimizar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/minimizar.png")));
			btnMinimizar.setContentAreaFilled(false);
			btnMinimizar.setBorderPainted(false);
			btnMinimizar.setOpaque(true);
			btnMinimizar.setBounds(678, 0, 36, 31);
			panelPrincipal.add(btnMinimizar);
		
			lblClinicaBuenaSalud = new JLabel("HEALTHY CODE");
			lblClinicaBuenaSalud.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/iconventana.png")));
			lblClinicaBuenaSalud.setHorizontalAlignment(SwingConstants.LEFT);
			lblClinicaBuenaSalud.setBounds(0, 0, 750, 31);
			lblClinicaBuenaSalud.setBackground(Color.WHITE);
			lblClinicaBuenaSalud.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
			lblClinicaBuenaSalud.setOpaque(true);
			lblClinicaBuenaSalud.setForeground(new Color(0, 102, 153));
			panelPrincipal.add(lblClinicaBuenaSalud);
	
			
			botonPaciente = new JButton("");
			botonPaciente.setContentAreaFilled(false);
			botonPaciente.setBorderPainted(false);
			botonPaciente.setOpaque(true);
			botonPaciente.setBackground(new Color(51, 153, 255));
			botonPaciente.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/paciente.png")));
			botonPaciente.setBounds(85, 110, 133, 140);
			panelPrincipal.add(botonPaciente);
			
			botonMedico = new JButton("");
			botonMedico.setContentAreaFilled(false);
			botonMedico.setBorderPainted(false);
			botonMedico.setOpaque(true);
			botonMedico.setBackground(new Color(51, 153, 255));
			botonMedico.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/medico.png")));
			botonMedico.setBounds(85, 260, 133, 140);
			panelPrincipal.add(botonMedico);
			
			botonCirujano = new JButton("");
			botonCirujano.setContentAreaFilled(false);
			botonCirujano.setBorderPainted(false);
			botonCirujano.setOpaque(true);
			botonCirujano.setBackground(new Color(51, 153, 255));
			botonCirujano.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cirujano.png")));
			botonCirujano.setBounds(85, 410, 133, 140);
			panelPrincipal.add(botonCirujano);
			
			JPanel panelAvanzar = new JPanel();
			panelAvanzar.setBackground(new Color(204, 255, 255));
			panelAvanzar.setBounds(297, 311, 403, 50);
			panelPrincipal.add(panelAvanzar);
			GridBagLayout gbl_panelAvanzar = new GridBagLayout();
			gbl_panelAvanzar.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panelAvanzar.rowHeights = new int[]{0, 0, 0};
			gbl_panelAvanzar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panelAvanzar.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			panelAvanzar.setLayout(gbl_panelAvanzar);
			
			btnUnaHora = new JButton("+ 1 hora");
			btnUnaHora.setFont(new Font("Verdana", Font.BOLD, 11));
			btnUnaHora.setForeground(Color.WHITE);
			btnUnaHora.setContentAreaFilled(false);
			btnUnaHora.setBorderPainted(false);
			btnUnaHora.setOpaque(true);
			btnUnaHora.setBackground(new Color(0, 102, 204));
			GridBagConstraints gbc_btnUnaHora = new GridBagConstraints();
			btnUnaHora.setOpaque(true);
			gbc_btnUnaHora.insets = new Insets(0, 0, 5, 5);
			gbc_btnUnaHora.gridx = 0;
			gbc_btnUnaHora.gridy = 0;
			panelAvanzar.add(btnUnaHora, gbc_btnUnaHora);
			
			btnTresHoras = new JButton("+ 3 horas");
			btnTresHoras.setFont(new Font("Verdana", Font.BOLD, 11));
			btnTresHoras.setForeground(Color.WHITE);
			btnTresHoras.setContentAreaFilled(false);
			btnTresHoras.setBorderPainted(false);
			btnTresHoras.setOpaque(true);
			btnTresHoras.setBackground(new Color(0, 102, 204));
			GridBagConstraints gbc_btnTresHoras = new GridBagConstraints();
			gbc_btnTresHoras.insets = new Insets(0, 0, 5, 5);
			gbc_btnTresHoras.gridx = 1;
			gbc_btnTresHoras.gridy = 0;
			panelAvanzar.add(btnTresHoras, gbc_btnTresHoras);
			
			btnDoceHoras = new JButton("+ 12 horas");
			btnDoceHoras.setFont(new Font("Verdana", Font.BOLD, 11));
			btnDoceHoras.setForeground(Color.WHITE);
			btnDoceHoras.setContentAreaFilled(false);
			btnDoceHoras.setBorderPainted(false);
			btnDoceHoras.setOpaque(true);
			btnDoceHoras.setBackground(new Color(0, 102, 204));
			GridBagConstraints gbc_btnDoceHoras = new GridBagConstraints();
			gbc_btnDoceHoras.insets = new Insets(0, 0, 5, 5);
			gbc_btnDoceHoras.gridx = 2;
			gbc_btnDoceHoras.gridy = 0;
			panelAvanzar.add(btnDoceHoras, gbc_btnDoceHoras);
			
			btnVeinticuatroHoras = new JButton("+ 24 horas");
			btnVeinticuatroHoras.setFont(new Font("Verdana", Font.BOLD, 11));
			btnVeinticuatroHoras.setForeground(Color.WHITE);
			btnVeinticuatroHoras.setContentAreaFilled(false);
			btnVeinticuatroHoras.setBorderPainted(false);
			btnVeinticuatroHoras.setOpaque(true);
			btnVeinticuatroHoras.setBackground(new Color(0, 102, 204));
			GridBagConstraints gbc_btnVeinticuatroHoras = new GridBagConstraints();
			gbc_btnVeinticuatroHoras.insets = new Insets(0, 0, 5, 0);
			gbc_btnVeinticuatroHoras.gridx = 3;
			gbc_btnVeinticuatroHoras.gridy = 0;
			panelAvanzar.add(btnVeinticuatroHoras, gbc_btnVeinticuatroHoras);
			
			lblFechaYHora = new JLabel("");
			lblFechaYHora.setHorizontalAlignment(SwingConstants.CENTER);
			lblFechaYHora.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblFechaYHora.setBorder(new LineBorder(new Color(204, 255, 255), 1, true));
			lblFechaYHora.setBounds(310, 265, 393, 31);
			panelPrincipal.add(lblFechaYHora);
			
			btnUnDia = new JButton("Dia siguiente 10:00");
			btnUnDia.setBounds(307, 366, 388, 23);
			panelPrincipal.add(btnUnDia);
			btnUnDia.setFont(new Font("Verdana", Font.BOLD, 11));
			btnUnDia.setForeground(Color.WHITE);
			btnUnDia.setContentAreaFilled(false);
			btnUnDia.setBorderPainted(false);
			btnUnDia.setOpaque(true);
			btnUnDia.setBackground(new Color(0, 102, 204));
		
	}





	public JLabel getLblFechaYHora() {
		return lblFechaYHora;
	}





	public void setLblFechaYHora(JLabel lblFechaYHora) {
		this.lblFechaYHora = lblFechaYHora;
	}





	public JButton getBotonPaciente() {
		return botonPaciente;
	}



	public JButton getBtnUnaHora() {
		return btnUnaHora;
	}





	public void setBtnUnaHora(JButton btnUnaHora) {
		this.btnUnaHora = btnUnaHora;
	}





	public JButton getBtnTresHoras() {
		return btnTresHoras;
	}





	public void setBtnTresHoras(JButton btnTresHoras) {
		this.btnTresHoras = btnTresHoras;
	}





	public JButton getBtnDoceHoras() {
		return btnDoceHoras;
	}





	public void setBtnDoceHoras(JButton btnDoceHoras) {
		this.btnDoceHoras = btnDoceHoras;
	}





	public JButton getBtnVeinticuatroHoras() {
		return btnVeinticuatroHoras;
	}





	public void setBtnVeinticuatroHoras(JButton btnVeinticuatroHoras) {
		this.btnVeinticuatroHoras = btnVeinticuatroHoras;
	}





	public JButton getBtnUnDia() {
		return btnUnDia;
	}





	public void setBtnUnDia(JButton btnUnDia) {
		this.btnUnDia = btnUnDia;
	}





	public void setBotonPaciente(JButton botonPaciente) {
		this.botonPaciente = botonPaciente;
	}



	public JButton getBotonCirujano() {
		return botonCirujano;
	}



	public void setBotonCirujano(JButton botonCirujano) {
		this.botonCirujano = botonCirujano;
	}



	public JButton getBotonMedico() {
		return botonMedico;
	}



	public void setBotonMedico(JButton botonMedico) {
		this.botonMedico = botonMedico;
	}
}