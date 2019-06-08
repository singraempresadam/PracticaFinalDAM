package vista.paciente;

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

import vista.ventanaPrincipal;

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
	private JTextField setTxtNombre;
	
	public VentanaHistorialPaciente() {
	

	getContentPane().setBackground(new Color(255, 255, 255));
	getContentPane().setLayout(null);
	
	JLabel lblidPaciente = new JLabel("Id Paciente");
	lblidPaciente.setForeground(new Color(0, 102, 204));
	lblidPaciente.setFont(new Font("Verdana", Font.BOLD, 13));
	lblidPaciente.setBounds(20, 63, 103, 26);
	getContentPane().add(lblidPaciente);
	
	setTxtIdPaciente = new JTextField();
	setTxtIdPaciente.setBackground(Color.WHITE);
	setTxtIdPaciente.setEditable(false);
	setTxtIdPaciente.setBounds(136, 68, 82, 20);
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
	lblTratamiento.setForeground(new Color(0, 51, 153));
	lblTratamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblTratamiento.setBounds(37, 146, 82, 14);
	getContentPane().add(lblTratamiento);
	
	JLabel lblCitas = new JLabel("Citas");
	lblCitas.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblCitas.setForeground(new Color(0, 51, 153));
	lblCitas.setBounds(37, 303, 86, 14);
	getContentPane().add(lblCitas);
	
	JTable tablaTratamiento = new JTable(datosFila,nombresColumnas);
	tablaTratamiento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tablaTratamiento.setBorder(new LineBorder(new Color(204, 255, 204), 3));
	tablaTratamiento.setBounds(37, 160, 533, 132);
	tablaTratamiento.setAutoscrolls(true);
	getContentPane().add(tablaTratamiento);
	
	JTable tablaCitas = new JTable();
	tablaCitas.setBorder(new LineBorder(new Color(204, 255, 204), 3));
	tablaCitas.setBounds(37, 318, 533, 120);
	getContentPane().add(tablaCitas);
	
	JLabel lblNombre = new JLabel("Nombre");
	lblNombre.setForeground(new Color(0, 102, 204));
	lblNombre.setFont(new Font("Verdana", Font.BOLD, 13));
	lblNombre.setBounds(20, 100, 103, 26);
	getContentPane().add(lblNombre);
	
	setTxtNombre = new JTextField();
	setTxtNombre.setEditable(false);
	setTxtNombre.setColumns(10);
	setTxtNombre.setBorder(new LineBorder(new Color(204, 255, 204)));
	setTxtNombre.setBackground(Color.WHITE);
	setTxtNombre.setBounds(136, 99, 181, 20);
	getContentPane().add(setTxtNombre);
	

	
	this.setMinimumSize(new Dimension(750, 500));
}
	
}
