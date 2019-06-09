package vista.paciente;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class VentanaSolicitarCitaPaciente extends JDialog {
	protected JTextField txtPaciente;
	protected JTextField txtMedicoAP;
	protected JTextField getTxtBuscar;
	private JButton btnVerHorario;
	private JButton btnSolicitar;
	int pX,pY;
	private JButton btnBuscar;
	private JPanel panelSolicitarCitaPaciente;
	private JPanel panelHorario;
	
	public VentanaSolicitarCitaPaciente() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 740, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			panelSolicitarCitaPaciente = new JPanel();
			panelSolicitarCitaPaciente.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelSolicitarCitaPaciente.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelSolicitarCitaPaciente.setBackground(Color.WHITE);
			panelSolicitarCitaPaciente.setBounds(0, 0, 734, 461);
			getContentPane().add(panelSolicitarCitaPaciente);
			panelSolicitarCitaPaciente.setLayout(null);
				
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
				panelSolicitarCitaPaciente.add(btnCerrar);
				
				JLabel lblSolicitarCitaPaciente = new JLabel("SOLICITAR CITA PACIENTE");
				lblSolicitarCitaPaciente.setIcon(new ImageIcon(VentanaSolicitarCitaPaciente.class.getResource("/images/iconventana.png")));
				lblSolicitarCitaPaciente.setOpaque(true);
				lblSolicitarCitaPaciente.setHorizontalAlignment(SwingConstants.LEFT);
				lblSolicitarCitaPaciente.setForeground(Color.WHITE);
				lblSolicitarCitaPaciente.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblSolicitarCitaPaciente.setBackground(SystemColor.textHighlight);
				lblSolicitarCitaPaciente.setBounds(0, 0, 740, 31);
				panelSolicitarCitaPaciente.add(lblSolicitarCitaPaciente);
		
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setBounds(120, 42, 137, 26);
				panelSolicitarCitaPaciente.add(lblPaciente);
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
				
				JLabel lblMedico = new JLabel("M\u00E9dico");
				lblMedico.setBounds(120, 79, 86, 19);
				panelSolicitarCitaPaciente.add(lblMedico);
				lblMedico.setFont(new Font("Verdana", Font.BOLD, 14));
				lblMedico.setForeground(new Color(0, 102, 204));
				
				txtPaciente = new JTextField();
				txtPaciente.setBounds(286, 47, 169, 20);
				panelSolicitarCitaPaciente.add(txtPaciente);
				txtPaciente.setBackground(Color.WHITE);
				txtPaciente.setEditable(false);
				txtPaciente.setColumns(10);
				txtPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				txtMedicoAP = new JTextField();
				txtMedicoAP.setBounds(286, 80, 169, 20);
				panelSolicitarCitaPaciente.add(txtMedicoAP);
				txtMedicoAP.setBackground(Color.WHITE);
				txtMedicoAP.setColumns(10);
				txtMedicoAP.setBorder(new LineBorder(new Color(0, 102, 204), 2));
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(491, 78, 122, 23);
				panelSolicitarCitaPaciente.add(btnBuscar);
				btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setContentAreaFilled(false);
				btnBuscar.setBorderPainted(false);
				btnBuscar.setOpaque(true);
				btnBuscar.setBackground(new Color(0, 102, 204));
				
				btnVerHorario = new JButton("Ver horario");
				btnVerHorario.setBounds(491, 214, 122, 23);
				panelSolicitarCitaPaciente.add(btnVerHorario);
				btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 11));
				btnVerHorario.setForeground(Color.WHITE);
				btnVerHorario.setContentAreaFilled(false);
				btnVerHorario.setBorderPainted(false);
				btnVerHorario.setOpaque(true);
				btnVerHorario.setBackground(new Color(0, 102, 204));
				
				JLabel lblLunes = new JLabel("Lunes");
				lblLunes.setBounds(120, 250, 100, 50);
				panelSolicitarCitaPaciente.add(lblLunes);
				lblLunes.setBorder(new MatteBorder(2, 2, 0, 1, (Color) new Color(0, 102, 204)));
				lblLunes.setBackground(new Color(204, 255, 255));
				lblLunes.setOpaque(true);
				lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblMartes = new JLabel("Martes");
				lblMartes.setBounds(220, 250, 100, 50);
				panelSolicitarCitaPaciente.add(lblMartes);
				lblMartes.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMartes.setOpaque(true);
				lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
				lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMartes.setBackground(new Color(204, 255, 255));
				
				JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
				lblMiercoles.setBounds(320, 250, 100, 50);
				panelSolicitarCitaPaciente.add(lblMiercoles);
				lblMiercoles.setOpaque(true);
				lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
				lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMiercoles.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMiercoles.setBackground(new Color(204, 255, 255));
				
				JLabel lblJueves = new JLabel("Jueves");
				lblJueves.setBounds(420, 250, 100, 50);
				panelSolicitarCitaPaciente.add(lblJueves);
				lblJueves.setOpaque(true);
				lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
				lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblJueves.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblJueves.setBackground(new Color(204, 255, 255));
				
				JLabel lblViernes = new JLabel("Viernes");
				lblViernes.setBounds(520, 250, 100, 50);
				panelSolicitarCitaPaciente.add(lblViernes);
				lblViernes.setOpaque(true);
				lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
				lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblViernes.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(0, 102, 204)));
				lblViernes.setBackground(new Color(204, 255, 255));
				
				JLabel lblHoraInicio = new JLabel("");
				lblHoraInicio.setBounds(20, 300, 100, 50);
				panelSolicitarCitaPaciente.add(lblHoraInicio);
				lblHoraInicio.setOpaque(true);
				lblHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraInicio.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraInicio.setBackground(new Color(204, 255, 255));
				
				JLabel lblHoraDos = new JLabel("");
				lblHoraDos.setBounds(20, 350, 100, 50);
				panelSolicitarCitaPaciente.add(lblHoraDos);
				lblHoraDos.setOpaque(true);
				lblHoraDos.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraDos.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraDos.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraDos.setBackground(new Color(204, 255, 255));
				
				JLabel lblHoraTres = new JLabel("");
				lblHoraTres.setBounds(20, 400, 100, 50);
				panelSolicitarCitaPaciente.add(lblHoraTres);
				lblHoraTres.setOpaque(true);
				lblHoraTres.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraTres.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraTres.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraTres.setBackground(new Color(204, 255, 255));
				
				JLabel lblHoraFinal = new JLabel("");
				lblHoraFinal.setBounds(20, 450, 100, 50);
				panelSolicitarCitaPaciente.add(lblHoraFinal);
				lblHoraFinal.setOpaque(true);
				lblHoraFinal.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraFinal.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraFinal.setBorder(new MatteBorder(0, 2, 2, 1, (Color) new Color(0, 102, 204)));
				lblHoraFinal.setBackground(new Color(204, 255, 255));
				
				
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.setBounds(626, 435, 89, 23);
				panelSolicitarCitaPaciente.add(btnSolicitar);
				btnSolicitar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnSolicitar.setBackground(new Color(204, 255, 204));
				btnSolicitar.setContentAreaFilled(false);
				btnSolicitar.setBorderPainted(false);
				btnSolicitar.setOpaque(true);
				btnSolicitar.setRequestFocusEnabled(false);
				btnSolicitar.setFocusable(false);
				
				panelHorario = new JPanel();
				panelHorario.setBounds(120, 300, 500, 200);
				panelSolicitarCitaPaciente.add(panelHorario);
				panelHorario.setLayout(new GridLayout(4, 5, 0, 0));
		
		
	}

	public JTextField getSetTxtIdPaciente() {
		return txtPaciente;
	}

	public void setSetTxtIdPaciente(JTextField setTxtIdPaciente) {
		this.txtPaciente = setTxtIdPaciente;
	}

	public JTextField getSetTxtIdMedico() {
		return txtMedicoAP;
	}

	public void setSetTxtIdMedico(JTextField setTxtIdMedico) {
		this.txtMedicoAP = setTxtIdMedico;
	}

	public JTextField getGetTxtBuscar() {
		return getTxtBuscar;
	}

	public void setGetTxtBuscar(JTextField getTxtBuscar) {
		this.getTxtBuscar = getTxtBuscar;
	}

	public JButton getBtnVerHorario() {
		return btnVerHorario;
	}

	public void setBtnVerHorario(JButton btnVerHorario) {
		this.btnVerHorario = btnVerHorario;
	}

	public JButton getBtnSolicitar() {
		return btnSolicitar;
	}

	public void setBtnSolicitar(JButton btnSolicitar) {
		this.btnSolicitar = btnSolicitar;
	}

	public JTextField getTxtPaciente() {
		return txtPaciente;
	}

	public void setTxtPaciente(JTextField txtPaciente) {
		this.txtPaciente = txtPaciente;
	}

	public JTextField getTxtMedicoAP() {
		return txtMedicoAP;
	}

	public void setTxtMedicoAP(JTextField txtMedicoAP) {
		this.txtMedicoAP = txtMedicoAP;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JPanel getPanelSolicitarCitaPaciente() {
		return panelSolicitarCitaPaciente;
	}
	public void actualizarPantalla() {
        JPanel temp = (JPanel) this.getContentPane();
        SwingUtilities.updateComponentTreeUI(temp);
    }
	public JPanel getPanelHorario() {
		return panelHorario;
	}

	
}