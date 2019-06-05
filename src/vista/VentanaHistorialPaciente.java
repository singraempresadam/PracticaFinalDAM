package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class VentanaHistorialPaciente extends JFrame {
	protected JTextField setTxtIdPaciente;
	protected JTextField getTxtBuscar;
	private JTable tablaTratamiento;
	private JTable tablaIntervencion;
	
	private String [] nombresColumnas= {"Nombre","Radio","Lunas","Gaseoso"};
	
	private Object [][] datosFila= {
			{"Mercurio",2443,0,false},
			{"Mercurio",2443,0,false},
			{"Mercurio",2443,0,false},
			{"Mercurio",2443,0,false},
			{"Mercurio",2443,0,false}
			
	};
	
	public VentanaHistorialPaciente() {
	
	setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/images/iconsalud.png")));
	getContentPane().setBackground(new Color(255, 255, 255));
	getContentPane().setLayout(null);
	
	JLabel lblidPaciente = new JLabel("Id Paciente");
	lblidPaciente.setForeground(new Color(0, 102, 204));
	lblidPaciente.setFont(new Font("Verdana", Font.BOLD, 14));
	lblidPaciente.setBounds(20, 75, 103, 26);
	getContentPane().add(lblidPaciente);
	
	setTxtIdPaciente = new JTextField();
	setTxtIdPaciente.setBackground(Color.WHITE);
	setTxtIdPaciente.setEditable(false);
	setTxtIdPaciente.setBounds(133, 80, 82, 20);
	getContentPane().add(setTxtIdPaciente);
	setTxtIdPaciente.setColumns(10);
	setTxtIdPaciente.setBorder(new LineBorder(new Color(204, 255, 204)));
	
	JLabel lblHistorial = new JLabel("HISTORIAL");
	lblHistorial.setOpaque(true);
	lblHistorial.setBackground(new Color(0, 102, 204));
	lblHistorial.setFont(new Font("Verdana", Font.BOLD, 15));
	lblHistorial.setForeground(Color.WHITE);
	lblHistorial.setHorizontalAlignment(SwingConstants.CENTER);
	lblHistorial.setBounds(10, 11, 714, 41);
	getContentPane().add(lblHistorial);
	
	JLabel lblTratamiento = new JLabel("Tratamiento");
	lblTratamiento.setBounds(37, 129, 82, 14);
	getContentPane().add(lblTratamiento);
	
	JLabel lblCitas = new JLabel("Citas");
	lblCitas.setBounds(37, 293, 86, 14);
	getContentPane().add(lblCitas);
	
	JTable tablaTratamiento = new JTable(datosFila,nombresColumnas);
	tablaTratamiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tablaTratamiento.setBorder(new LineBorder(new Color(204, 255, 204), 3));
	tablaTratamiento.setBounds(37, 150, 533, 132);
	tablaTratamiento.setAutoscrolls(true);
	getContentPane().add(tablaTratamiento);
	
	JTable tablaCitas = new JTable();
	tablaCitas.setBorder(new LineBorder(new Color(204, 255, 204), 3));
	tablaCitas.setBounds(37, 318, 533, 120);
	getContentPane().add(tablaCitas);
	

	
	this.setMinimumSize(new Dimension(750, 500));
}
	
}
