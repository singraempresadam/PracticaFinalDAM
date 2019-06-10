package vista.cirujano;

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
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class VentanaDatosCirujano extends JDialog {
	protected JTextField getTxtBuscar;
	int pX,pY;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JButton btnHistorialCirujano;
	private JButton btnGestionarIntervencion;
	
	public VentanaDatosCirujano() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 650, 450);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			JPanel panelDatosCirujano = new JPanel();
			panelDatosCirujano.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelDatosCirujano.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelDatosCirujano.setBackground(Color.WHITE);
			panelDatosCirujano.setBounds(0, 0, 734, 461);
			panelDatosCirujano.setLayout(null);
			getContentPane().add(panelDatosCirujano);
				
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
				btnCerrar.setBounds(613, 0, 37, 31);
				panelDatosCirujano.add(btnCerrar);
				
				JLabel lblDatosCirujano = new JLabel("DATOS CIRUJANO");
				lblDatosCirujano.setIcon(new ImageIcon(VentanaDatosCirujano.class.getResource("/images/iconventana.png")));
				lblDatosCirujano.setOpaque(true);
				lblDatosCirujano.setHorizontalAlignment(SwingConstants.LEFT);
				lblDatosCirujano.setForeground(Color.WHITE);
				lblDatosCirujano.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblDatosCirujano.setBackground(SystemColor.textHighlight);
				lblDatosCirujano.setBounds(0, 0, 650, 31);
				panelDatosCirujano.add(lblDatosCirujano);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(150, 80, 86, 26);
				lblNombre.setForeground(new Color(0, 102, 204));
				lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosCirujano.add(lblNombre);
				
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setBounds(150, 120, 86, 26);
				lblApellidos.setForeground(new Color(0, 102, 204));
				lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosCirujano.add(lblApellidos);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setBounds(150, 160, 86, 19);
				lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTelefono.setForeground(new Color(0, 102, 204));
				panelDatosCirujano.add(lblTelefono);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setBounds(150, 200, 86, 26);
				lblDireccion.setForeground(new Color(0, 102, 204));
				lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosCirujano.add(lblDireccion);
				
				txtNombre = new JTextField();
				txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombre.setForeground(new Color(0, 0, 102));
				txtNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtNombre.setBounds(280, 80, 169, 20);			
				txtNombre.setEditable(false);
				txtNombre.setBackground(new Color(255, 255, 255));
				txtNombre.setColumns(10);
				txtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosCirujano.add(txtNombre);
				
				txtApellidos = new JTextField();
				txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
				txtApellidos.setForeground(new Color(0, 0, 102));
				txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtApellidos.setBounds(280, 120, 169, 20);
				txtApellidos.setBackground(Color.WHITE);
				txtApellidos.setEditable(false);
				txtApellidos.setColumns(10);
				txtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosCirujano.add(txtApellidos);
				
				txtTelefono = new JTextField();
				txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
				txtTelefono.setForeground(new Color(0, 0, 102));
				txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtTelefono.setBounds(280, 160, 169, 20);
				txtTelefono.setBackground(Color.WHITE);
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosCirujano.add(txtTelefono);
				
				txtDireccion = new JTextField();
				txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
				txtDireccion.setForeground(new Color(0, 0, 102));
				txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
				txtDireccion.setBounds(280, 200, 169, 20);
				txtDireccion.setBackground(Color.WHITE);
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosCirujano.add(txtDireccion);
				
				btnGestionarIntervencion = new JButton("Gestionar Intervenci\u00F3n");
				btnGestionarIntervencion.setFont(new Font("Verdana", Font.BOLD, 12));
				btnGestionarIntervencion.setBackground(new Color(204, 255, 204));
				btnGestionarIntervencion.setContentAreaFilled(false);
				btnGestionarIntervencion.setBorderPainted(false);
				btnGestionarIntervencion.setOpaque(true);
				btnGestionarIntervencion.setBounds(369, 371, 200, 23);
				panelDatosCirujano.add(btnGestionarIntervencion);
				
				btnHistorialCirujano = new JButton("Historial");
				btnHistorialCirujano.setFont(new Font("Verdana", Font.BOLD, 12));
				btnHistorialCirujano.setBackground(new Color(204, 255, 204));
				btnHistorialCirujano.setContentAreaFilled(false);
				btnHistorialCirujano.setBorderPainted(false);
				btnHistorialCirujano.setOpaque(true);
				btnHistorialCirujano.setBounds(203, 372, 120, 23);
				panelDatosCirujano.add(btnHistorialCirujano);
	}

	public JButton getBtnHistorialCirujano() {
		return btnHistorialCirujano;
	}

	public void setBtnHistorialCirujano(JButton btnHistorialCirujano) {
		this.btnHistorialCirujano = btnHistorialCirujano;
	}

	public JButton getBtnGestionarIntervencion() {
		return btnGestionarIntervencion;
	}

	public void setBtnGestionarIntervencion(JButton btnGestionarIntervencion) {
		this.btnGestionarIntervencion = btnGestionarIntervencion;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

}