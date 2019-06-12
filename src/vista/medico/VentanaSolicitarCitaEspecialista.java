package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;
import vista.paciente.VentanaSolicitarCitaPaciente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class VentanaSolicitarCitaEspecialista extends JDialog {
	protected JTextField txtPaciente;
	protected JTextField txtMedicoEspecialista;
	private JButton btnVerHorario;
	private JButton btnBuscar;
	private JPanel panelSolicitarCitaEspecialista;
	private JPanel panelHorario;
	int pX,pY;
	private JLabel lblHoraInicio;
	private JLabel lblHoraDos;
	private JLabel lblHoraTres;
	
	public VentanaSolicitarCitaEspecialista() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 740, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			panelSolicitarCitaEspecialista = new JPanel();
			panelSolicitarCitaEspecialista.setBorder(new LineBorder(new Color(153, 204, 255)));
			panelSolicitarCitaEspecialista.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelSolicitarCitaEspecialista.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelSolicitarCitaEspecialista.setBackground(Color.WHITE);
			panelSolicitarCitaEspecialista.setBounds(0, 0, 734, 461);
			getContentPane().add(panelSolicitarCitaEspecialista);
			panelSolicitarCitaEspecialista.setLayout(null);
				
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
				btnCerrar.setBounds(703, 0, 37, 31);
				panelSolicitarCitaEspecialista.add(btnCerrar);
				
				JLabel lblSolicitarCitaEspecialista = new JLabel("SOLICITAR CITA ESPECIALISTA");
				lblSolicitarCitaEspecialista.setIcon(new ImageIcon(VentanaSolicitarCitaPaciente.class.getResource("/images/iconventana.png")));
				lblSolicitarCitaEspecialista.setOpaque(true);
				lblSolicitarCitaEspecialista.setHorizontalAlignment(SwingConstants.LEFT);
				lblSolicitarCitaEspecialista.setForeground(Color.WHITE);
				lblSolicitarCitaEspecialista.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblSolicitarCitaEspecialista.setBackground(SystemColor.textHighlight);
				lblSolicitarCitaEspecialista.setBounds(0, 0, 740, 31);
				panelSolicitarCitaEspecialista.add(lblSolicitarCitaEspecialista);
		
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setBounds(120, 42, 137, 26);
				panelSolicitarCitaEspecialista.add(lblPaciente);
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
				
				JLabel lblMedico = new JLabel("M\u00E9dico");
				lblMedico.setBounds(120, 79, 86, 19);
				panelSolicitarCitaEspecialista.add(lblMedico);
				lblMedico.setFont(new Font("Verdana", Font.BOLD, 14));
				lblMedico.setForeground(new Color(0, 102, 204));
				
				txtPaciente = new JTextField();
				txtPaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtPaciente.setForeground(new Color(0, 0, 102));
				txtPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtPaciente.setBounds(286, 47, 169, 20);
				panelSolicitarCitaEspecialista.add(txtPaciente);
				txtPaciente.setBackground(Color.WHITE);
				txtPaciente.setEditable(false);
				txtPaciente.setColumns(10);
				txtPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				
				txtMedicoEspecialista = new JTextField();
				txtMedicoEspecialista.setBounds(286, 80, 169, 20);
				panelSolicitarCitaEspecialista.add(txtMedicoEspecialista);
				txtMedicoEspecialista.setBackground(Color.WHITE);
				txtMedicoEspecialista.setColumns(10);
				txtMedicoEspecialista.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(491, 78, 122, 23);
				panelSolicitarCitaEspecialista.add(btnBuscar);
				btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setContentAreaFilled(false);
				btnBuscar.setBorderPainted(false);
				btnBuscar.setOpaque(true);
				btnBuscar.setBackground(new Color(0, 102, 204));
				
				btnVerHorario = new JButton("Ver horario");
				btnVerHorario.setBounds(491, 214, 122, 23);
				panelSolicitarCitaEspecialista.add(btnVerHorario);
				btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 11));
				btnVerHorario.setForeground(Color.WHITE);
				btnVerHorario.setContentAreaFilled(false);
				btnVerHorario.setBorderPainted(false);
				btnVerHorario.setOpaque(true);
				btnVerHorario.setBackground(new Color(0, 102, 204));
				
				JLabel lblLunes = new JLabel("Lunes");
				lblLunes.setBounds(120, 250, 100, 50);
				panelSolicitarCitaEspecialista.add(lblLunes);
				lblLunes.setBorder(new MatteBorder(2, 2, 0, 1, (Color) new Color(0, 102, 204)));
				lblLunes.setBackground(new Color(153, 204, 255));
				lblLunes.setOpaque(true);
				lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblMartes = new JLabel("Martes");
				lblMartes.setBounds(220, 250, 100, 50);
				panelSolicitarCitaEspecialista.add(lblMartes);
				lblMartes.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMartes.setOpaque(true);
				lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
				lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMartes.setBackground(new Color(153, 204, 255));
				
				JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
				lblMiercoles.setBounds(320, 250, 100, 50);
				panelSolicitarCitaEspecialista.add(lblMiercoles);
				lblMiercoles.setOpaque(true);
				lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
				lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMiercoles.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMiercoles.setBackground(new Color(153, 204, 255));
				
				JLabel lblJueves = new JLabel("Jueves");
				lblJueves.setBounds(420, 250, 100, 50);
				panelSolicitarCitaEspecialista.add(lblJueves);
				lblJueves.setOpaque(true);
				lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
				lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblJueves.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblJueves.setBackground(new Color(153, 204, 255));
				
				JLabel lblViernes = new JLabel("Viernes");
				lblViernes.setBounds(520, 250, 100, 50);
				panelSolicitarCitaEspecialista.add(lblViernes);
				lblViernes.setOpaque(true);
				lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
				lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblViernes.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(0, 102, 204)));
				lblViernes.setBackground(new Color(153, 204, 255));
				
				lblHoraInicio = new JLabel("");
				lblHoraInicio.setBounds(20, 300, 100, 50);
				panelSolicitarCitaEspecialista.add(lblHoraInicio);
				lblHoraInicio.setOpaque(true);
				lblHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraInicio.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraInicio.setBackground(new Color(153, 204, 255));
				
				lblHoraDos = new JLabel("");
				lblHoraDos.setBounds(20, 350, 100, 50);
				panelSolicitarCitaEspecialista.add(lblHoraDos);
				lblHoraDos.setOpaque(true);
				lblHoraDos.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraDos.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraDos.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraDos.setBackground(new Color(153, 204, 255));
				
				lblHoraTres = new JLabel("");
				lblHoraTres.setBounds(20, 400, 100, 50);
				panelSolicitarCitaEspecialista.add(lblHoraTres);
				lblHoraTres.setOpaque(true);
				lblHoraTres.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraTres.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraTres.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraTres.setBackground(new Color(153, 204, 255));
				
				panelHorario = new JPanel();
				panelHorario.setBounds(120, 300, 500, 150);
				panelSolicitarCitaEspecialista.add(panelHorario);
				panelHorario.setLayout(null);
		
		
	}

	public JTextField getTxtPaciente() {
		return txtPaciente;
	}

	public void setTxtPaciente(JTextField txtPaciente) {
		this.txtPaciente = txtPaciente;
	}

	public JTextField getTxtMedicoEspecialista() {
		return txtMedicoEspecialista;
	}

	public void setTxtMedicoEspecialista(JTextField txtMedicoEspecialista) {
		this.txtMedicoEspecialista = txtMedicoEspecialista;
	}

	public JButton getBtnVerHorario() {
		return btnVerHorario;
	}

	public void setBtnVerHorario(JButton btnVerHorario) {
		this.btnVerHorario = btnVerHorario;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JPanel getPanelSolicitarCitaEspecialista() {
		return panelSolicitarCitaEspecialista;
	}

	public void setPanelSolicitarCitaEspecialista(JPanel panelSolicitarCitaEspecialista) {
		this.panelSolicitarCitaEspecialista = panelSolicitarCitaEspecialista;
	}

	public JPanel getPanelHorario() {
		return panelHorario;
	}

	public void setPanelHorario(JPanel panelHorario) {
		this.panelHorario = panelHorario;
	}

	public JLabel getLblHoraInicio() {
		return lblHoraInicio;
	}

	public void setLblHoraInicio(JLabel lblHoraInicio) {
		this.lblHoraInicio = lblHoraInicio;
	}

	public JLabel getLblHoraDos() {
		return lblHoraDos;
	}

	public void setLblHoraDos(JLabel lblHoraDos) {
		this.lblHoraDos = lblHoraDos;
	}

	public JLabel getLblHoraTres() {
		return lblHoraTres;
	}

	public void setLblHoraTres(JLabel lblHoraTres) {
		this.lblHoraTres = lblHoraTres;
	}
	
}
