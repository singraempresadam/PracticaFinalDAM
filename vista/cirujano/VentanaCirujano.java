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
	private JTextField getTxtNombreCirujano;
	private JTextField getTxtApellidoCirujano;
	private JTextField getTxtTelefonoCirujano;
	private JTextField getTxtDireccionCirujano;
	private JTextField getTxtCirujano;
	int pX,pY;
	
	public VentanaCirujano() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 740, 500);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
		ImageIcon iconagregar = new ImageIcon(this.getClass().getResource("/images/agregar.png"));
		ImageIcon iconbuscar = new ImageIcon(this.getClass().getResource("/images/buscar.png"));
		
		JPanel panelCirujano = new JPanel();
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
						tabbedPane.setBounds(0, 31, 740, 469);
						panelCirujano.add(tabbedPane);
						tabbedPane.setBackground(Color.WHITE);
						
						JPanel panelBuscar = new JPanel();
						panelBuscar.setBackground(Color.WHITE);
						tabbedPane.addTab("Buscar Cirujano", iconbuscar, panelBuscar, null);
						panelBuscar.setLayout(null);
						
						getTxtCirujano = new JTextField();
						getTxtCirujano.setColumns(10);
						getTxtCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
						getTxtCirujano.setBounds(80, 50, 345, 27);
						panelBuscar.add(getTxtCirujano);
						
						JButton btnBuscarCirujano = new JButton("Buscar");
						btnBuscarCirujano.setFont(new Font("Verdana", Font.BOLD, 11));
						btnBuscarCirujano.setForeground(Color.WHITE);
						btnBuscarCirujano.setContentAreaFilled(false);
						btnBuscarCirujano.setBorderPainted(false);
						btnBuscarCirujano.setOpaque(true);
						btnBuscarCirujano.setBackground(new Color(0, 102, 204));
						btnBuscarCirujano.setBounds(520, 50, 89, 23);
						panelBuscar.add(btnBuscarCirujano);
						
						JButton btnConsultarCirujano = new JButton("Consultar");
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
						lblNombre.setBounds(53, 45, 86, 26);
						panelAnadirCirujano.add(lblNombre);
						lblNombre.setForeground(new Color(0, 102, 204));
						lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblApellidos = new JLabel("Apellidos");
						lblApellidos.setBounds(53, 91, 86, 26);
						panelAnadirCirujano.add(lblApellidos);
						lblApellidos.setForeground(new Color(0, 102, 204));
						lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblTelefono = new JLabel("Tel\u00E9fono");
						lblTelefono.setBounds(53, 147, 86, 19);
						panelAnadirCirujano.add(lblTelefono);
						lblTelefono.setForeground(new Color(0, 102, 204));
						lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
						
						JLabel lblDireccion = new JLabel("Direcci\u00F3n");
						lblDireccion.setBounds(53, 189, 86, 26);
						panelAnadirCirujano.add(lblDireccion);
						lblDireccion.setForeground(new Color(0, 102, 204));
						lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
						
						getTxtNombreCirujano = new JTextField();
						getTxtNombreCirujano.setBounds(185, 50, 169, 20);
						panelAnadirCirujano.add(getTxtNombreCirujano);
						getTxtNombreCirujano.setColumns(10);
						getTxtNombreCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
						getTxtNombreCirujano.setBackground(Color.WHITE);
						
						getTxtApellidoCirujano = new JTextField();
						getTxtApellidoCirujano.setBounds(185, 96, 169, 20);
						panelAnadirCirujano.add(getTxtApellidoCirujano);
						getTxtApellidoCirujano.setColumns(10);
						getTxtApellidoCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
						getTxtApellidoCirujano.setBackground(Color.WHITE);
						
						getTxtTelefonoCirujano = new JTextField();
						getTxtTelefonoCirujano.setBounds(185, 148, 169, 20);
						panelAnadirCirujano.add(getTxtTelefonoCirujano);
						getTxtTelefonoCirujano.setColumns(10);
						getTxtTelefonoCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
						getTxtTelefonoCirujano.setBackground(Color.WHITE);
						
						getTxtDireccionCirujano = new JTextField();
						getTxtDireccionCirujano.setBounds(185, 194, 169, 20);
						panelAnadirCirujano.add(getTxtDireccionCirujano);
						getTxtDireccionCirujano.setColumns(10);
						getTxtDireccionCirujano.setBorder(new LineBorder(new Color(0, 102, 204), 2));
						getTxtDireccionCirujano.setBackground(Color.WHITE);
						
						JButton btnAnadirCirujano = new JButton("A�adir");
						btnAnadirCirujano.setBounds(584, 365, 97, 23);
						panelAnadirCirujano.add(btnAnadirCirujano);
						btnAnadirCirujano.setFont(new Font("Verdana", Font.BOLD, 12));
						btnAnadirCirujano.setBackground(new Color(204, 255, 204));
						btnAnadirCirujano.setContentAreaFilled(false);
						btnAnadirCirujano.setBorderPainted(false);
						btnAnadirCirujano.setOpaque(true);
	}
}
