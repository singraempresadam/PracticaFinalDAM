package vista.cirujano;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import vista.ventanaPrincipal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaCirujano extends JDialog{
	private JTextField txtNombreCirujano;
	private JTextField txtApellidoCirujano;
	private JTextField txtTelefonoCirujano;
	private JTextField txtDireccionCirujano;
	private JButton btnBuscarCirujano;
	private JButton btnConsultarCirujano;
	private JTextField txtBuscarCirujano;
	private JPanel panelBuscar;
	private JButton btnAnadirCirujano;
	int pX,pY;
	
	public VentanaCirujano() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 741, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
		ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));
		
		JPanel panelCirujano = new JPanel();
		panelCirujano.setBackground(Color.WHITE);
		panelCirujano.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY(); 
			}
		});
		panelCirujano.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		panelCirujano.setBounds(0, 0, 734, 461);
		getContentPane().add(panelCirujano);
		panelCirujano.setLayout(null);
				
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
				btnCerrar.setBounds(705, 0, 35, 31);
				panelCirujano.add(btnCerrar);
				
				JLabel lblCirujano = new JLabel("CIRUJANO");
				lblCirujano.setIcon(new ImageIcon(VentanaCirujano.class.getResource("/images/iconventana.png")));
				lblCirujano.setOpaque(true);
				lblCirujano.setHorizontalAlignment(SwingConstants.LEFT);
				lblCirujano.setForeground(Color.WHITE);
				lblCirujano.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblCirujano.setBackground(new Color(51, 153, 255));
				lblCirujano.setBounds(0, 0, 740, 31);
				panelCirujano.add(lblCirujano);
				
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
						tabbedPane.setBounds(0, 31, 740, 469);
						panelCirujano.add(tabbedPane);
						tabbedPane.setBackground(Color.WHITE);
						
						panelBuscar = new JPanel();
						panelBuscar.setBackground(Color.WHITE);
						tabbedPane.addTab("Buscar Cirujano", iconbuscar, panelBuscar, null);
						panelBuscar.setLayout(null);
						
						txtBuscarCirujano = new JTextField();
						txtBuscarCirujano.setForeground(new Color(0, 0, 102));
						txtBuscarCirujano.setFont(new Font("Tahoma", Font.PLAIN, 13));
						txtBuscarCirujano.setColumns(10);
						txtBuscarCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2, true));
						txtBuscarCirujano.setBounds(80, 50, 345, 27);
						panelBuscar.add(txtBuscarCirujano);
						
						btnBuscarCirujano = new JButton("Buscar");
						btnBuscarCirujano.setFont(new Font("Verdana", Font.BOLD, 11));
						btnBuscarCirujano.setForeground(Color.WHITE);
						btnBuscarCirujano.setContentAreaFilled(false);
						btnBuscarCirujano.setBorderPainted(false);
						btnBuscarCirujano.setOpaque(true);
						btnBuscarCirujano.setBackground(new Color(0, 102, 204));
						btnBuscarCirujano.setBounds(520, 50, 89, 23);
						panelBuscar.add(btnBuscarCirujano);
						
						btnConsultarCirujano = new JButton("Consultar");
						btnConsultarCirujano.setFont(new Font("Verdana", Font.BOLD, 11));
						btnConsultarCirujano.setForeground(Color.WHITE);
						btnConsultarCirujano.setContentAreaFilled(false);
						btnConsultarCirujano.setBorderPainted(false);
						btnConsultarCirujano.setOpaque(true);
						btnConsultarCirujano.setBackground(new Color(0, 102, 204));
						btnConsultarCirujano.setBounds(520, 130, 125, 25);
						panelBuscar.add(btnConsultarCirujano);
						
						JPanel panelAnadirCirujano = new JPanel();
						panelAnadirCirujano.setBackground(Color.WHITE);
						tabbedPane.addTab("Alta Cirujano", iconagregar, panelAnadirCirujano, null);
						panelAnadirCirujano.setLayout(null);
						
						JLabel lblNombre = new JLabel("Nombre");
						lblNombre.setBounds(173, 45, 86, 26);
						panelAnadirCirujano.add(lblNombre);
						lblNombre.setForeground(new Color(0, 102, 204));
						lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblApellidos = new JLabel("Apellidos");
						lblApellidos.setBounds(173, 91, 86, 26);
						panelAnadirCirujano.add(lblApellidos);
						lblApellidos.setForeground(new Color(0, 102, 204));
						lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblTelefono = new JLabel("Tel\u00E9fono");
						lblTelefono.setBounds(173, 147, 86, 19);
						panelAnadirCirujano.add(lblTelefono);
						lblTelefono.setForeground(new Color(0, 102, 204));
						lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblDireccion = new JLabel("Direcci\u00F3n");
						lblDireccion.setBounds(173, 189, 86, 26);
						panelAnadirCirujano.add(lblDireccion);
						lblDireccion.setForeground(new Color(0, 102, 204));
						lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
						
						txtNombreCirujano = new JTextField();
						txtNombreCirujano.setFont(new Font("Tahoma", Font.BOLD, 13));
						txtNombreCirujano.setBounds(310, 50, 169, 20);
						panelAnadirCirujano.add(txtNombreCirujano);
						txtNombreCirujano.setColumns(10);
						txtNombreCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtNombreCirujano.setBackground(Color.WHITE);
						
						txtApellidoCirujano = new JTextField();
						txtApellidoCirujano.setFont(new Font("Tahoma", Font.BOLD, 13));
						txtApellidoCirujano.setBounds(310, 96, 169, 20);
						panelAnadirCirujano.add(txtApellidoCirujano);
						txtApellidoCirujano.setColumns(10);
						txtApellidoCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtApellidoCirujano.setBackground(Color.WHITE);
						
						txtTelefonoCirujano = new JTextField();
						txtTelefonoCirujano.setFont(new Font("Tahoma", Font.BOLD, 13));
						txtTelefonoCirujano.setBounds(310, 148, 169, 20);
						panelAnadirCirujano.add(txtTelefonoCirujano);
						txtTelefonoCirujano.setColumns(10);
						txtTelefonoCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtTelefonoCirujano.setBackground(Color.WHITE);
						
						txtDireccionCirujano = new JTextField();
						txtDireccionCirujano.setFont(new Font("Tahoma", Font.BOLD, 13));
						txtDireccionCirujano.setBounds(310, 194, 169, 20);
						panelAnadirCirujano.add(txtDireccionCirujano);
						txtDireccionCirujano.setColumns(10);
						txtDireccionCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
						txtDireccionCirujano.setBackground(Color.WHITE);
						
						btnAnadirCirujano = new JButton("Añadir");
						btnAnadirCirujano.setBounds(580, 367, 97, 23);
						panelAnadirCirujano.add(btnAnadirCirujano);
						btnAnadirCirujano.setFont(new Font("Verdana", Font.BOLD, 12));
						btnAnadirCirujano.setBackground(new Color(204, 255, 204));
						btnAnadirCirujano.setContentAreaFilled(false);
						btnAnadirCirujano.setBorderPainted(false);
						btnAnadirCirujano.setOpaque(true);
	}

	public JTextField getTxtNombreCirujano() {
		return txtNombreCirujano;
	}

	public void setTxtNombreCirujano(JTextField txtNombreCirujano) {
		this.txtNombreCirujano = txtNombreCirujano;
	}

	public JTextField getTxtApellidoCirujano() {
		return txtApellidoCirujano;
	}

	public void setTxtApellidoCirujano(JTextField txtApellidoCirujano) {
		this.txtApellidoCirujano = txtApellidoCirujano;
	}

	public JTextField getTxtTelefonoCirujano() {
		return txtTelefonoCirujano;
	}

	public void setTxtTelefonoCirujano(JTextField txtTelefonoCirujano) {
		this.txtTelefonoCirujano = txtTelefonoCirujano;
	}

	public JTextField getTxtDireccionCirujano() {
		return txtDireccionCirujano;
	}

	public void setTxtDireccionCirujano(JTextField txtDireccionCirujano) {
		this.txtDireccionCirujano = txtDireccionCirujano;
	}

	public JButton getBtnAnadirCirujano() {
		return btnAnadirCirujano;
	}

	public void setBtnAnadirCirujano(JButton btnAnadirCirujano) {
		this.btnAnadirCirujano = btnAnadirCirujano;
	}

	public JPanel getPanelBuscar() {
		return panelBuscar;
	}

	public void setPanelBuscar(JPanel panelBuscar) {
		this.panelBuscar = panelBuscar;
	}

	public JButton getBtnBuscarCirujano() {
		return btnBuscarCirujano;
	}

	public void setBtnBuscarCirujano(JButton btnBuscarCirujano) {
		this.btnBuscarCirujano = btnBuscarCirujano;
	}

	public JButton getBtnConsultarCirujano() {
		return btnConsultarCirujano;
	}

	public void setBtnConsultarCirujano(JButton btnConsultarCirujano) {
		this.btnConsultarCirujano = btnConsultarCirujano;
	}

	public JTextField getTxtBuscarCirujano() {
		return txtBuscarCirujano;
	}

	public void setTxtBuscarCirujano(JTextField txtBuscarCirujano) {
		this.txtBuscarCirujano = txtBuscarCirujano;
	}
}
