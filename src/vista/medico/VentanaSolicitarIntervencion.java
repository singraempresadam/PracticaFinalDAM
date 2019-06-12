package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import vista.ventanaPrincipal;
import vista.paciente.VentanaSolicitarCitaPaciente;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;

public class VentanaSolicitarIntervencion extends JDialog {
	protected JTextField txtPaciente;
	protected JTextField txtCirujano;
	private JButton btnVerHorario;
	private JButton btnBuscar;
	private JPanel panelSolicitarIntervencion;
	private JPanel panelHorario;
	private JComboBox comboBoxIntervencion;
	int pX,pY;
	
	public VentanaSolicitarIntervencion() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 840, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			panelSolicitarIntervencion = new JPanel();
			panelSolicitarIntervencion.setBorder(new LineBorder(new Color(153, 204, 255)));
			panelSolicitarIntervencion.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelSolicitarIntervencion.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelSolicitarIntervencion.setBackground(Color.WHITE);
			panelSolicitarIntervencion.setBounds(0, 0, 734, 461);
			getContentPane().add(panelSolicitarIntervencion);
			panelSolicitarIntervencion.setLayout(null);
				
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
				btnCerrar.setBounds(803, 0, 37, 31);
				panelSolicitarIntervencion.add(btnCerrar);
				
				JLabel lblSolicitarCitaPaciente = new JLabel("SOLICITAR INTERVENCION");
				lblSolicitarCitaPaciente.setIcon(new ImageIcon(VentanaSolicitarCitaPaciente.class.getResource("/images/iconventana.png")));
				lblSolicitarCitaPaciente.setOpaque(true);
				lblSolicitarCitaPaciente.setHorizontalAlignment(SwingConstants.LEFT);
				lblSolicitarCitaPaciente.setForeground(Color.WHITE);
				lblSolicitarCitaPaciente.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblSolicitarCitaPaciente.setBackground(SystemColor.textHighlight);
				lblSolicitarCitaPaciente.setBounds(0, 0, 840, 31);
				panelSolicitarIntervencion.add(lblSolicitarCitaPaciente);
		
				JLabel lblPaciente = new JLabel("Paciente");
				lblPaciente.setBounds(120, 42, 137, 26);
				panelSolicitarIntervencion.add(lblPaciente);
				lblPaciente.setForeground(new Color(0, 102, 204));
				lblPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
				
				JLabel lblCirujano = new JLabel("Cirujano");
				lblCirujano.setBounds(120, 79, 86, 19);
				panelSolicitarIntervencion.add(lblCirujano);
				lblCirujano.setFont(new Font("Verdana", Font.BOLD, 14));
				lblCirujano.setForeground(new Color(0, 102, 204));
				
				txtPaciente = new JTextField();
				txtPaciente.setHorizontalAlignment(SwingConstants.CENTER);
				txtPaciente.setForeground(new Color(0, 0, 102));
				txtPaciente.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtPaciente.setBounds(286, 47, 169, 20);
				panelSolicitarIntervencion.add(txtPaciente);
				txtPaciente.setBackground(Color.WHITE);
				txtPaciente.setEditable(false);
				txtPaciente.setColumns(10);
				txtPaciente.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				
				txtCirujano = new JTextField();
				txtCirujano.setBounds(286, 80, 169, 20);
				panelSolicitarIntervencion.add(txtCirujano);
				txtCirujano.setBackground(Color.WHITE);
				txtCirujano.setColumns(10);
				txtCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(491, 78, 122, 23);
				panelSolicitarIntervencion.add(btnBuscar);
				btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
				btnBuscar.setForeground(Color.WHITE);
				btnBuscar.setContentAreaFilled(false);
				btnBuscar.setBorderPainted(false);
				btnBuscar.setOpaque(true);
				btnBuscar.setBackground(new Color(0, 102, 204));
				
				btnVerHorario = new JButton("Ver horario");
				btnVerHorario.setBounds(491, 214, 122, 23);
				panelSolicitarIntervencion.add(btnVerHorario);
				btnVerHorario.setFont(new Font("Verdana", Font.BOLD, 11));
				btnVerHorario.setForeground(Color.WHITE);
				btnVerHorario.setContentAreaFilled(false);
				btnVerHorario.setBorderPainted(false);
				btnVerHorario.setOpaque(true);
				btnVerHorario.setBackground(new Color(0, 102, 204));
				
				JLabel lblLunes = new JLabel("Lunes");
				lblLunes.setBounds(120, 250, 100, 50);
				panelSolicitarIntervencion.add(lblLunes);
				lblLunes.setBorder(new MatteBorder(2, 2, 0, 1, (Color) new Color(0, 102, 204)));
				lblLunes.setBackground(new Color(153, 204, 255));
				lblLunes.setOpaque(true);
				lblLunes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblMartes = new JLabel("Martes");
				lblMartes.setBounds(220, 250, 100, 50);
				panelSolicitarIntervencion.add(lblMartes);
				lblMartes.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMartes.setOpaque(true);
				lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
				lblMartes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMartes.setBackground(new Color(153, 204, 255));
				
				JLabel lblMiercoles = new JLabel("Mi\u00E9rcoles");
				lblMiercoles.setBounds(320, 250, 100, 50);
				panelSolicitarIntervencion.add(lblMiercoles);
				lblMiercoles.setOpaque(true);
				lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
				lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblMiercoles.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblMiercoles.setBackground(new Color(153, 204, 255));
				
				JLabel lblJueves = new JLabel("Jueves");
				lblJueves.setBounds(420, 250, 100, 50);
				panelSolicitarIntervencion.add(lblJueves);
				lblJueves.setOpaque(true);
				lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
				lblJueves.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblJueves.setBorder(new MatteBorder(2, 0, 0, 1, (Color) new Color(0, 102, 204)));
				lblJueves.setBackground(new Color(153, 204, 255));
				
				JLabel lblViernes = new JLabel("Viernes");
				lblViernes.setBounds(520, 250, 100, 50);
				panelSolicitarIntervencion.add(lblViernes);
				lblViernes.setOpaque(true);
				lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
				lblViernes.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblViernes.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(0, 102, 204)));
				lblViernes.setBackground(new Color(153, 204, 255));
				
				JLabel lblHoraInicio = new JLabel("Ma\u00F1ana");
				lblHoraInicio.setBounds(20, 300, 100, 50);
				panelSolicitarIntervencion.add(lblHoraInicio);
				lblHoraInicio.setOpaque(true);
				lblHoraInicio.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraInicio.setBorder(new MatteBorder(2, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraInicio.setBackground(new Color(153, 204, 255));
				
				JLabel lblHoraDos = new JLabel("Tarde");
				lblHoraDos.setBounds(20, 350, 100, 50);
				panelSolicitarIntervencion.add(lblHoraDos);
				lblHoraDos.setOpaque(true);
				lblHoraDos.setHorizontalAlignment(SwingConstants.CENTER);
				lblHoraDos.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblHoraDos.setBorder(new MatteBorder(0, 2, 1, 1, (Color) new Color(0, 102, 204)));
				lblHoraDos.setBackground(new Color(153, 204, 255));
				
				panelHorario = new JPanel();
				panelHorario.setBounds(120, 300, 500, 100);
				panelSolicitarIntervencion.add(panelHorario);
				panelHorario.setLayout(null);
				
				JLabel lblIntervencion = new JLabel("Intervencion");
				lblIntervencion.setHorizontalAlignment(SwingConstants.CENTER);
				lblIntervencion.setForeground(new Color(0, 102, 204));
				lblIntervencion.setFont(new Font("Verdana", Font.BOLD, 14));
				lblIntervencion.setBounds(665, 250, 152, 19);
				panelSolicitarIntervencion.add(lblIntervencion);
				
				comboBoxIntervencion = new JComboBox();
				comboBoxIntervencion.setBounds(665, 281, 152, 19);
				panelSolicitarIntervencion.add(comboBoxIntervencion);
		
		
	}
	
	public JTextField getTxtPaciente() {
		return txtPaciente;
	}

	public JTextField getTxtCirujano() {
		return txtCirujano;
	}
	
	public JButton getBtnVerHorario() {
		return btnVerHorario;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JPanel getPanelSolicitarIntervencion() {
		return panelSolicitarIntervencion;
	}

	public JPanel getPanelHorario() {
		return panelHorario;
	}

	public JComboBox getComboBoxIntervencion() {
		return comboBoxIntervencion;
	}
}
