package vista.medico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import vista.ventanaPrincipal;
import vista.paciente.VentanaDatosPaciente;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaDatosMedico extends JDialog {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JTextField txtTelefono;
	protected JTextField txtDireccion;
	protected JTextField txtEspecialidad;
	protected JTextField txtEstado;
	private JButton btnModificar;
	private JButton btnDarDeBaja;
	private JButton btnHistorialMedico;
	private JButton btnGestionarCita;
	int pX,pY;
	
	public VentanaDatosMedico() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 650, 450);
		setLocationRelativeTo(null);
		setModal(true);
		setUndecorated(true);
		
			JPanel panelDatosMedico = new JPanel();
			panelDatosMedico.setBorder(new LineBorder(new Color(153, 204, 255)));
			panelDatosMedico.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pX=e.getX();
					pY=e.getY();
				}
			});
			panelDatosMedico.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
				}
			});
			panelDatosMedico.setBackground(Color.WHITE);
			panelDatosMedico.setBounds(0, 0, 734, 461);
			getContentPane().add(panelDatosMedico);
			panelDatosMedico.setLayout(null);
			
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
				panelDatosMedico.add(btnCerrar);
				
				JLabel lblDatosMedico = new JLabel("DATOS MEDICO");
				lblDatosMedico.setIcon(new ImageIcon(VentanaDatosPaciente.class.getResource("/images/iconventana.png")));
				lblDatosMedico.setOpaque(true);
				lblDatosMedico.setHorizontalAlignment(SwingConstants.LEFT);
				lblDatosMedico.setForeground(Color.WHITE);
				lblDatosMedico.setFont(new Font("Eras Demi ITC", Font.BOLD, 12));
				lblDatosMedico.setBackground(SystemColor.textHighlight);
				lblDatosMedico.setBounds(0, 0, 650, 31);
				panelDatosMedico.add(lblDatosMedico);
				
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setBounds(150, 80, 86, 26);
				lblNombre.setForeground(new Color(0, 102, 204));
				lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosMedico.add(lblNombre);
				
				JLabel lblApellidos = new JLabel("Apellidos");
				lblApellidos.setBounds(150, 120, 86, 26);
				lblApellidos.setForeground(new Color(0, 102, 204));
				lblApellidos.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosMedico.add(lblApellidos);
				
				JLabel lblTelefono = new JLabel("Tel\u00E9fono");
				lblTelefono.setBounds(150, 160, 86, 19);
				lblTelefono.setFont(new Font("Verdana", Font.BOLD, 14));
				lblTelefono.setForeground(new Color(0, 102, 204));
				panelDatosMedico.add(lblTelefono);
				
				JLabel lblDireccion = new JLabel("Direcci\u00F3n");
				lblDireccion.setBounds(150, 200, 86, 26);
				lblDireccion.setForeground(new Color(0, 102, 204));
				lblDireccion.setFont(new Font("Verdana", Font.BOLD, 14));
				panelDatosMedico.add(lblDireccion);
				
				JLabel lblEspecialidad = new JLabel("Especialidad");
				lblEspecialidad.setForeground(new Color(0, 102, 204));
				lblEspecialidad.setFont(new Font("Verdana", Font.BOLD, 14));
				lblEspecialidad.setBounds(150, 240, 118, 26);
				panelDatosMedico.add(lblEspecialidad);
				
				JLabel lblEstado = new JLabel("Estado");
				lblEstado.setForeground(new Color(0, 102, 204));
				lblEstado.setFont(new Font("Verdana", Font.BOLD, 14));
				lblEstado.setBounds(150, 280, 118, 26);
				panelDatosMedico.add(lblEstado);
				
				txtNombre = new JTextField();
				txtNombre.setBounds(280, 80, 169, 20);	
				txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
				txtNombre.setForeground(new Color(0, 0, 102));
				txtNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtNombre.setEditable(false);
				txtNombre.setBackground(Color.WHITE);
				txtNombre.setColumns(10);
				txtNombre.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosMedico.add(txtNombre);
				
				txtApellidos = new JTextField();
				txtApellidos.setBounds(280, 120, 169, 20);	
				txtApellidos.setHorizontalAlignment(SwingConstants.CENTER);
				txtApellidos.setForeground(new Color(0, 0, 102));
				txtApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtApellidos.setBackground(Color.WHITE);
				txtApellidos.setEditable(false);
				txtApellidos.setColumns(10);
				txtApellidos.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosMedico.add(txtApellidos);
				
				txtTelefono = new JTextField();
				txtTelefono.setBounds(280, 160, 169, 20);		
				txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
				txtTelefono.setForeground(new Color(0, 0, 102));
				txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtTelefono.setBackground(Color.WHITE);
				txtTelefono.setEditable(false);
				txtTelefono.setColumns(10);
				txtTelefono.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosMedico.add(txtTelefono);
				
				txtDireccion = new JTextField();
				txtDireccion.setBounds(280, 200, 169, 20);				
				txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
				txtDireccion.setForeground(new Color(0, 0, 102));
				txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtDireccion.setBackground(Color.WHITE);
				txtDireccion.setEditable(false);
				txtDireccion.setColumns(10);
				txtDireccion.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				panelDatosMedico.add(txtDireccion);
				
				txtEspecialidad = new JTextField();
				txtEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
				txtEspecialidad.setForeground(new Color(0, 0, 102));
				txtEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtEspecialidad.setEditable(false);
				txtEspecialidad.setColumns(10);
				txtEspecialidad.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtEspecialidad.setBackground(Color.WHITE);
				txtEspecialidad.setBounds(280, 240, 169, 20);
				panelDatosMedico.add(txtEspecialidad);
				
				txtEstado = new JTextField();
				txtEstado.setHorizontalAlignment(SwingConstants.CENTER);
				txtEstado.setForeground(new Color(0, 0, 102));
				txtEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
				txtEstado.setEditable(false);
				txtEstado.setColumns(10);
				txtEstado.setBorder(new LineBorder(new Color(0, 102, 204), 1, true));
				txtEstado.setBackground(Color.WHITE);
				txtEstado.setBounds(280, 280, 169, 20);
				panelDatosMedico.add(txtEstado);
				
				btnModificar = new JButton("Modificar");
				btnModificar.setBounds(52, 380, 110, 25);
				btnModificar.setFont(new Font("Verdana", Font.BOLD, 12));
				btnModificar.setBackground(new Color(204, 255, 204));
				btnModificar.setContentAreaFilled(false);
				btnModificar.setBorderPainted(false);
				btnModificar.setOpaque(true);
				panelDatosMedico.add(btnModificar);
				
				btnDarDeBaja = new JButton("Dar de baja");
				btnDarDeBaja.setBounds(172, 380, 145, 25);
				btnDarDeBaja.setFont(new Font("Verdana", Font.BOLD, 12));
				btnDarDeBaja.setBackground(new Color(204, 255, 204));
				btnDarDeBaja.setContentAreaFilled(false);
				btnDarDeBaja.setBorderPainted(false);
				btnDarDeBaja.setOpaque(true);
				panelDatosMedico.add(btnDarDeBaja);
			
				btnHistorialMedico = new JButton("Historial");
				btnHistorialMedico.setBounds(333, 380, 90, 25);
				btnHistorialMedico.setFont(new Font("Verdana", Font.BOLD, 12));
				btnHistorialMedico.setBackground(new Color(204, 255, 204));
				btnHistorialMedico.setContentAreaFilled(false);
				btnHistorialMedico.setBorderPainted(false);
				btnHistorialMedico.setOpaque(true);
				panelDatosMedico.add(btnHistorialMedico);
				
				btnGestionarCita = new JButton("Gestionar Cita");
				btnGestionarCita.setBounds(456, 380, 152, 25);
				btnGestionarCita.setFont(new Font("Verdana", Font.BOLD, 12));
				btnGestionarCita.setBackground(new Color(204, 255, 204));
				btnGestionarCita.setContentAreaFilled(false);
				btnGestionarCita.setBorderPainted(false);
				btnGestionarCita.setOpaque(true);
				panelDatosMedico.add(btnGestionarCita);
				
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

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnDarDeBaja() {
		return btnDarDeBaja;
	}

	public void setBtnDarDeBaja(JButton btnDarDeBaja) {
		this.btnDarDeBaja = btnDarDeBaja;
	}

	public JButton getBtnHistorialMedico() {
		return btnHistorialMedico;
	}

	public void setBtnHistorialMedico(JButton btnHistorialMedico) {
		this.btnHistorialMedico = btnHistorialMedico;
	}

	public JButton getBtnGestionarCita() {
		return btnGestionarCita;
	}

	public void setBtnGestionarCita(JButton btnGestionarCita) {
		this.btnGestionarCita = btnGestionarCita;
	}

		
	
}