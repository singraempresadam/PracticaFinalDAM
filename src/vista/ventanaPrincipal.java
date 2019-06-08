package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class ventanaPrincipal extends JFrame {

	protected JPanel contentPane;
	protected JButton botonPaciente;
	protected JButton botonCirujano;
	protected JButton botonMedico;
	int pX,pY;

	/**
	 * Create the frame.
	 */
	public ventanaPrincipal() {
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
			
		
		JPanel panelPrincipal = new JPanel();	
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
		btnCerrar.setBackground(new Color(0, 153, 255));
		btnCerrar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cerrar.png")));
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(true);
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0); 
			}
		});
		btnCerrar.setBounds(714, 0, 36, 31);
		panelPrincipal.add(btnCerrar);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setBackground(new Color(0, 153, 255));
		btnMinimizar.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/minimizar.png")));
		btnMinimizar.setContentAreaFilled(false);
		btnMinimizar.setBorderPainted(false);
		btnMinimizar.setOpaque(true);
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED); 
			}
		});
		btnMinimizar.setBounds(681, 0, 36, 31);
		panelPrincipal.add(btnMinimizar);
		
		
		JLabel lblClinicaBuenaSalud = new JLabel("HEALTHY CODE");
		lblClinicaBuenaSalud.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/iconventana.png")));
		lblClinicaBuenaSalud.setHorizontalAlignment(SwingConstants.LEFT);
		lblClinicaBuenaSalud.setBounds(0, 0, 750, 31);
		lblClinicaBuenaSalud.setBackground(new Color(51, 153, 255));
		lblClinicaBuenaSalud.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
		lblClinicaBuenaSalud.setOpaque(true);
		lblClinicaBuenaSalud.setForeground(Color.WHITE);
		panelPrincipal.add(lblClinicaBuenaSalud);

		
		botonPaciente = new JButton("");
		botonPaciente.setContentAreaFilled(false);
		botonPaciente.setBorderPainted(false);
		botonPaciente.setOpaque(true);
		botonPaciente.setBackground(new Color(204, 255, 255));
		botonPaciente.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/paciente.png")));
		botonPaciente.setBounds(85, 110, 133, 140);
		panelPrincipal.add(botonPaciente);
		
		botonMedico = new JButton("");
		botonMedico.setContentAreaFilled(false);
		botonMedico.setBorderPainted(false);
		botonMedico.setOpaque(true);
		botonMedico.setBackground(new Color(204, 255, 255));
		botonMedico.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/medico.png")));
		botonMedico.setBounds(85, 260, 133, 140);
		panelPrincipal.add(botonMedico);
		
		botonCirujano = new JButton("");
		botonCirujano.setContentAreaFilled(false);
		botonCirujano.setBorderPainted(false);
		botonCirujano.setOpaque(true);
		botonCirujano.setBackground(new Color(204, 255, 255));
		botonCirujano.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/cirujano.png")));
		botonCirujano.setBounds(85, 410, 133, 140);
		panelPrincipal.add(botonCirujano);
		
		JPanel panelAvanzar = new JPanel();
		panelAvanzar.setBackground(new Color(204, 255, 255));
		panelAvanzar.setBounds(310, 309, 393, 50);
		panelPrincipal.add(panelAvanzar);
		GridBagLayout gbl_panelAvanzar = new GridBagLayout();
		gbl_panelAvanzar.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelAvanzar.rowHeights = new int[]{0, 0, 0};
		gbl_panelAvanzar.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAvanzar.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelAvanzar.setLayout(gbl_panelAvanzar);
		
		JButton btnUnaHora = new JButton("+1 hora");
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
		
		JButton btnTresHoras = new JButton("+3 horas");
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
		
		JButton btnDoceHoras = new JButton("+12 horas");
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
		
		JButton btnVeinticuatroHoras = new JButton("+24 horas");
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
		
		JButton btnUnDia = new JButton("+1 D\u00EDa");
		btnUnDia.setFont(new Font("Verdana", Font.BOLD, 11));
		btnUnDia.setForeground(Color.WHITE);
		btnUnDia.setContentAreaFilled(false);
		btnUnDia.setBorderPainted(false);
		btnUnDia.setOpaque(true);
		btnUnDia.setBackground(new Color(0, 102, 204));
		GridBagConstraints gbc_btnUnDia = new GridBagConstraints();
		gbc_btnUnDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnDia.gridwidth = 4;
		gbc_btnUnDia.insets = new Insets(0, 0, 0, 5);
		gbc_btnUnDia.gridx = 0;
		gbc_btnUnDia.gridy = 1;
		panelAvanzar.add(btnUnDia, gbc_btnUnDia);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(204, 255, 255)));
		lblFecha.setBounds(310, 278, 283, 31);
		panelPrincipal.add(lblFecha);
		
		JLabel lblHora = new JLabel("");
		lblHora.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(204, 255, 255)));
		lblHora.setBounds(593, 278, 110, 31);
		panelPrincipal.add(lblHora);
		
	
	}





	public JButton getBotonPaciente() {
		return botonPaciente;
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
