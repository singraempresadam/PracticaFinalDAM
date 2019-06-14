package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import vista.ventanaPrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.event.MouseMotionAdapter;

public class VentanaMedico extends JDialog {
	private JTextField txtBuscarMedico;
	private JTextField txtNombreEspecialista;
	private JTextField txtNombreMedicoAP;
	private JTextField txtNombreMedico;
	private JTextField txtApellidosMedico;
	private JTextField txtTelefonoMedico;
	private JTextField txtDireccionMedico;
	private JPanel panelBuscarMedico;
	private JButton btnBuscar;
	private JButton btnConsultarMedico;
	private JButton btnBuscarEspecialista;
	private Checkbox checkLMV;
	private Checkbox checkMJ;
	private JComboBox comboBoxTurnoEspecialista;
	private JButton btnAnadirEspecialista;
	private JButton btnBuscarMedicoAP;
	private JComboBox comboBoxTurnoMedicoAP;
	private JButton btnAnadirAtencionPrimaria;
	private JComboBox comboBoxEspecialidad;
	private JButton btnAnadirMedico;
	private JPanel panelAnadirMedico;
	private JPanel panelAnadirMedicoEspecialista;
	private JPanel panelAnadirMedicoAP;
	private JLabel lblConsultaEspecialista;
	int pX,pY;
	private JComboBox comboBoxConsultaEspecialista;
	private JComboBox comboBoxConsulta;
	
		public VentanaMedico() {
			getContentPane().setBackground(new Color(255, 255, 255));
			setBounds(100, 100, 750, 500);
			setLocationRelativeTo(null);
			setModal(true);
			setUndecorated(true);
			
			ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
			ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));
			
			JPanel panelMedico = new JPanel();
			panelMedico.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY(); 
				}
			});
			panelMedico.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelMedico.setBackground(Color.WHITE);
			panelMedico.setLayout(null);
			panelMedico.setBounds(0, 0, 750, 500);
			getContentPane().add(panelMedico);
						
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
						btnCerrar.setBounds(715, 0, 35, 31);
						panelMedico.add(btnCerrar);
						
						JLabel lblMedico = new JLabel("MEDICO");
						lblMedico.setIcon(new ImageIcon(ventanaPrincipal.class.getResource("/images/iconventana.png")));
						lblMedico.setHorizontalAlignment(SwingConstants.LEFT);
						lblMedico.setBounds(0, 0, 750, 31);
						lblMedico.setBackground(new Color(51, 153, 255));
						lblMedico.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
						lblMedico.setOpaque(true);
						lblMedico.setForeground(Color.WHITE);
						panelMedico.add(lblMedico);
			
						JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
						tabbedPane.addMouseListener(new MouseAdapter() {
							@Override
							public void mousePressed(MouseEvent e) {
								pX=e.getX();
								pY=e.getY();
							}
						});
						tabbedPane.addMouseMotionListener(new MouseMotionAdapter() {
							@Override
							public void mouseDragged(MouseEvent e) {
								setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
							}
						});
						tabbedPane.setBounds(0, 31, 750, 469);
						panelMedico.add(tabbedPane);
						tabbedPane.setBackground(Color.WHITE);
						
						panelBuscarMedico = new JPanel();
						panelBuscarMedico.setBackground(Color.WHITE);
						tabbedPane.addTab("Buscar Médico", iconbuscar, panelBuscarMedico, null);
						panelBuscarMedico.setLayout(null);
						
						txtBuscarMedico = new JTextField();
						txtBuscarMedico.setBounds(80, 50, 345, 27);
						panelBuscarMedico.add(txtBuscarMedico);
						txtBuscarMedico.setColumns(10);
						txtBuscarMedico.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
						
						btnBuscar = new JButton("Buscar");
						btnBuscar.setBackground(new Color(0, 102, 204));
						btnBuscar.setFont(new Font("Verdana", Font.BOLD, 11));
						btnBuscar.setForeground(Color.WHITE);
						btnBuscar.setContentAreaFilled(false);
						btnBuscar.setBorderPainted(false);
						btnBuscar.setOpaque(true);
						btnBuscar.setBounds(520, 50, 89, 23);
						panelBuscarMedico.add(btnBuscar);
						
						btnConsultarMedico = new JButton("Consultar");
						btnConsultarMedico.setBackground(new Color(0, 102, 204));
						btnConsultarMedico.setFont(new Font("Verdana", Font.BOLD, 11));
						btnConsultarMedico.setForeground(Color.WHITE);
						btnConsultarMedico.setContentAreaFilled(false);
						btnConsultarMedico.setBorderPainted(false);
						btnConsultarMedico.setOpaque(true);
						btnConsultarMedico.setBounds(520, 130, 125, 25);
						panelBuscarMedico.add(btnConsultarMedico);
						
						panelAnadirMedico = new JPanel();
						panelAnadirMedico.setBackground(Color.WHITE);
						tabbedPane.addTab("Añadir médico", iconagregar, panelAnadirMedico, null);
						panelAnadirMedico.setLayout(null);
						
						JLabel lblNombre = new JLabel("Nombre");
						lblNombre.setForeground(new Color(0, 102, 204));
						lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
						lblNombre.setBounds(178, 64, 86, 26);
						panelAnadirMedico.add(lblNombre);
						
						JLabel lblApellidos = new JLabel("Apellidos");
						lblApellidos.setForeground(new Color(0, 102, 204));
						lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
						lblApellidos.setBounds(178, 112, 86, 26);
						panelAnadirMedico.add(lblApellidos);
						
						JLabel lblTelefono = new JLabel("Tel\u00E9fono");
						lblTelefono.setForeground(new Color(0, 102, 204));
						lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
						lblTelefono.setBounds(178, 163, 86, 19);
						panelAnadirMedico.add(lblTelefono);
						
						JLabel lblDireccion = new JLabel("Direcci\u00F3n");
						lblDireccion.setForeground(new Color(0, 102, 204));
						lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
						lblDireccion.setBounds(178, 206, 86, 26);
						panelAnadirMedico.add(lblDireccion);
						
						JLabel lblEspecialidad = new JLabel("Especialidad");
						lblEspecialidad.setForeground(new Color(0, 102, 204));
						lblEspecialidad.setFont(new Font("Verdana", Font.BOLD, 14));
						lblEspecialidad.setBounds(178, 265, 115, 26);
						panelAnadirMedico.add(lblEspecialidad);
						
						txtNombreMedico = new JTextField();
						txtNombreMedico.setColumns(10);
						txtNombreMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtNombreMedico.setBackground(Color.WHITE);
						txtNombreMedico.setBounds(320, 69, 169, 20);
						panelAnadirMedico.add(txtNombreMedico);
						
						txtApellidosMedico = new JTextField();
						txtApellidosMedico.setColumns(10);
						txtApellidosMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtApellidosMedico.setBackground(Color.WHITE);
						txtApellidosMedico.setBounds(320, 117, 169, 20);
						panelAnadirMedico.add(txtApellidosMedico);
						
						txtTelefonoMedico = new JTextField();
						txtTelefonoMedico.setColumns(10);
						txtTelefonoMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtTelefonoMedico.setBackground(Color.WHITE);
						txtTelefonoMedico.setBounds(320, 164, 169, 20);
						panelAnadirMedico.add(txtTelefonoMedico);
						
						txtDireccionMedico = new JTextField();
						txtDireccionMedico.setColumns(10);
						txtDireccionMedico.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtDireccionMedico.setBackground(Color.WHITE);
						txtDireccionMedico.setBounds(320, 211, 169, 20);
						panelAnadirMedico.add(txtDireccionMedico);
						
						btnAnadirMedico = new JButton("A\u00F1adir");
						btnAnadirMedico.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnAnadirMedico.setBackground(new Color(204, 255, 204));
						btnAnadirMedico.setContentAreaFilled(false);
						btnAnadirMedico.setBorderPainted(false);
						btnAnadirMedico.setOpaque(true);
						btnAnadirMedico.setBounds(600, 361, 89, 23);
						panelAnadirMedico.add(btnAnadirMedico);
						
						comboBoxEspecialidad = new JComboBox();
						comboBoxEspecialidad.setBounds(320, 271, 169, 19);
						panelAnadirMedico.add(comboBoxEspecialidad);
						
						
						panelAnadirMedicoEspecialista = new JPanel();
						panelAnadirMedicoEspecialista.setBorder(null);
						panelAnadirMedicoEspecialista.setBackground(Color.WHITE);
						tabbedPane.addTab("Alta Médico Especialista", iconagregar, panelAnadirMedicoEspecialista, null);
						panelAnadirMedicoEspecialista.setLayout(null);
						
						txtNombreEspecialista = new JTextField();
						txtNombreEspecialista.setColumns(10);
						txtNombreEspecialista.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
						txtNombreEspecialista.setBounds(44, 56, 405, 25);
						panelAnadirMedicoEspecialista.add(txtNombreEspecialista);
						
						btnBuscarEspecialista = new JButton("Buscar");
						btnBuscarEspecialista.setContentAreaFilled(false);
						btnBuscarEspecialista.setBorderPainted(false);
						btnBuscarEspecialista.setOpaque(true);
						btnBuscarEspecialista.setForeground(Color.WHITE);
						btnBuscarEspecialista.setFont(new Font("Verdana", Font.BOLD, 11));
						btnBuscarEspecialista.setBackground(new Color(0, 102, 204));
						btnBuscarEspecialista.setBounds(517, 56, 89, 23);
						panelAnadirMedicoEspecialista.add(btnBuscarEspecialista);
						
						checkLMV = new Checkbox("Lunes Mi\u00E9rcoles Viernes");
						checkLMV.setFont(new Font("Georgia", Font.BOLD, 12));
						checkLMV.setForeground(new Color(0, 51, 102));
						checkLMV.setBackground(new Color(204, 255, 255));
						checkLMV.setBounds(502, 124, 160, 22);
						panelAnadirMedicoEspecialista.add(checkLMV);
						
						checkMJ = new Checkbox("Martes Jueves");
						checkMJ.setForeground(new Color(0, 51, 102));
						checkMJ.setFont(new Font("Georgia", Font.BOLD, 12));
						checkMJ.setBackground(new Color(204, 255, 255));
						checkMJ.setBounds(502, 152, 139, 22);
						panelAnadirMedicoEspecialista.add(checkMJ);
						
						btnAnadirEspecialista = new JButton("A\u00F1adir");
						btnAnadirEspecialista.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnAnadirEspecialista.setBackground(new Color(204, 255, 204));
						btnAnadirEspecialista.setContentAreaFilled(false);
						btnAnadirEspecialista.setBorderPainted(false);
						btnAnadirEspecialista.setOpaque(true);
						btnAnadirEspecialista.setBounds(600, 361, 89, 23);
						panelAnadirMedicoEspecialista.add(btnAnadirEspecialista);
						
						comboBoxTurnoEspecialista = new JComboBox();
						comboBoxTurnoEspecialista.setMaximumRowCount(2);
						comboBoxTurnoEspecialista.setBackground(Color.LIGHT_GRAY);
						comboBoxTurnoEspecialista.setForeground(new Color(0, 0, 0));
						comboBoxTurnoEspecialista.setBounds(575, 200, 114, 20);
						panelAnadirMedicoEspecialista.add(comboBoxTurnoEspecialista);
						
						JLabel lblTurno = new JLabel("Turno");
						lblTurno.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblTurno.setForeground(new Color(0, 51, 153));
						lblTurno.setBounds(485, 203, 61, 14);
						panelAnadirMedicoEspecialista.add(lblTurno);
						
						lblConsultaEspecialista = new JLabel("Consulta");
						lblConsultaEspecialista.setForeground(new Color(0, 51, 153));
						lblConsultaEspecialista.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblConsultaEspecialista.setBounds(485, 253, 80, 14);
						panelAnadirMedicoEspecialista.add(lblConsultaEspecialista);
						
						comboBoxConsultaEspecialista = new JComboBox();
						comboBoxConsultaEspecialista.setBounds(575, 251, 114, 20);
						panelAnadirMedicoEspecialista.add(comboBoxConsultaEspecialista);
						
						panelAnadirMedicoAP = new JPanel();
						panelAnadirMedicoAP.setBackground(Color.WHITE);
						tabbedPane.addTab("Alta Médico Atención Primaria", iconagregar, panelAnadirMedicoAP, null);
						panelAnadirMedicoAP.setLayout(null);
						
						txtNombreMedicoAP = new JTextField();
						txtNombreMedicoAP.setColumns(10);
						txtNombreMedicoAP.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
						txtNombreMedicoAP.setBounds(44, 56, 405, 25);
						panelAnadirMedicoAP.add(txtNombreMedicoAP);
						
						btnBuscarMedicoAP = new JButton("Buscar");
						btnBuscarMedicoAP.setForeground(Color.WHITE);
						btnBuscarMedicoAP.setContentAreaFilled(false);
						btnBuscarMedicoAP.setBorderPainted(false);
						btnBuscarMedicoAP.setOpaque(true);
						btnBuscarMedicoAP.setFont(new Font("Verdana", Font.BOLD, 11));
						btnBuscarMedicoAP.setBackground(new Color(0, 102, 204));
						btnBuscarMedicoAP.setBounds(517, 56, 89, 23);
						panelAnadirMedicoAP.add(btnBuscarMedicoAP);
						
						JLabel labelTurno = new JLabel("Turno");
						labelTurno.setForeground(new Color(0, 51, 153));
						labelTurno.setFont(new Font("Tahoma", Font.BOLD, 15));
						labelTurno.setBounds(496, 194, 75, 14);
						panelAnadirMedicoAP.add(labelTurno);
						
						comboBoxTurnoMedicoAP = new JComboBox();
						comboBoxTurnoMedicoAP.setMaximumRowCount(2);
						comboBoxTurnoMedicoAP.setForeground(Color.BLACK);
						comboBoxTurnoMedicoAP.setBackground(Color.LIGHT_GRAY);
						comboBoxTurnoMedicoAP.setBounds(581, 193, 114, 20);
						panelAnadirMedicoAP.add(comboBoxTurnoMedicoAP);
						
						btnAnadirAtencionPrimaria = new JButton("A\u00F1adir");
						btnAnadirAtencionPrimaria.setFont(new Font("Tahoma", Font.BOLD, 12));
						btnAnadirAtencionPrimaria.setBackground(new Color(204, 255, 204));
						btnAnadirAtencionPrimaria.setContentAreaFilled(false);
						btnAnadirAtencionPrimaria.setBorderPainted(false);
						btnAnadirAtencionPrimaria.setOpaque(true);
						btnAnadirAtencionPrimaria.setBounds(606, 354, 89, 23);
						panelAnadirMedicoAP.add(btnAnadirAtencionPrimaria);
						
						JLabel lblConsulta = new JLabel("Consulta");
						lblConsulta.setForeground(new Color(0, 51, 153));
						lblConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblConsulta.setBounds(496, 246, 75, 14);
						panelAnadirMedicoAP.add(lblConsulta);
						
						comboBoxConsulta = new JComboBox();
						comboBoxConsulta.setBounds(581, 244, 114, 20);
						panelAnadirMedicoAP.add(comboBoxConsulta);

		}


		public JTextField getTxtBuscarMedico() {
			return txtBuscarMedico;
		}

		public JTextField getTxtNombreEspecialista() {
			return txtNombreEspecialista;
		}

		public JTextField getTxtNombreMedicoAP() {
			return txtNombreMedicoAP;
		}

		public JTextField getTxtNombreMedico() {
			return txtNombreMedico;
		}

		public JTextField getTxtApellidosMedico() {
			return txtApellidosMedico;
		}

		public JTextField getTxtTelefonoMedico() {
			return txtTelefonoMedico;
		}

		public JTextField getTxtDireccionMedico() {
			return txtDireccionMedico;
		}

		public JPanel getPanelBuscarMedico() {
			return panelBuscarMedico;
		}

		public JButton getBtnBuscar() {
			return btnBuscar;
		}

		public JButton getBtnConsultarMedico() {
			return btnConsultarMedico;
		}

		public JButton getBtnBuscarEspecialista() {
			return btnBuscarEspecialista;
		}

		public Checkbox getCheckLMV() {
			return checkLMV;
		}

		public Checkbox getCheckMJ() {
			return checkMJ;
		}

		public JComboBox getComboBoxTurnoEspecialista() {
			return comboBoxTurnoEspecialista;
		}

		public JButton getBtnAnadirEspecialista() {
			return btnAnadirEspecialista;
		}
		
		public JPanel getPanelAnadirMedico() {
			return panelAnadirMedico;
		}

		public void setPanelAnadirMedico(JPanel panelAnadirMedico) {
			this.panelAnadirMedico = panelAnadirMedico;
		}

		public JPanel getPanelAnadirMedicoEspecialista() {
			return panelAnadirMedicoEspecialista;
		}

		public void setPanelAnadirMedicoEspecialista(JPanel panelAnadirMedicoEspecialista) {
			this.panelAnadirMedicoEspecialista = panelAnadirMedicoEspecialista;
		}

		public JPanel getPanelAnadirMedicoAP() {
			return panelAnadirMedicoAP;
		}

		public void setPanelAnadirMedicoAP(JPanel panelAnadirMedicoAP) {
			this.panelAnadirMedicoAP = panelAnadirMedicoAP;
		}

		public JButton getBtnBuscarMedicoAP() {
			return btnBuscarMedicoAP;
		}
		
		public JButton getBtnAnadirMedico() {
			return btnAnadirMedico;
		}

		public void setBtnAnadirMedico(JButton btnAnadirMedico) {
			this.btnAnadirMedico = btnAnadirMedico;
		}

		public void setBtnAnadirEspecialista(JButton btnAnadirEspecialista) {
			this.btnAnadirEspecialista = btnAnadirEspecialista;
		}

		public void setBtnAnadirAtencionPrimaria(JButton btnAnadirAtencionPrimaria) {
			this.btnAnadirAtencionPrimaria = btnAnadirAtencionPrimaria;
		}

		public JComboBox getComboBoxTurnoMedicoAP() {
			return comboBoxTurnoMedicoAP;
		}

		public JButton getBtnAnadirAtencionPrimaria() {
			return btnAnadirAtencionPrimaria;
		}

		public JComboBox getComboBoxEspecialidad() {
			return comboBoxEspecialidad;
		}


		public JComboBox getComboBoxConsultaEspecialista() {
			return comboBoxConsultaEspecialista;
		}



		public JComboBox getComboBoxConsulta() {
			return comboBoxConsulta;
		}

		
		
}