package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ventana extends JFrame {

	protected JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public ventana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/images/iconsalud.png")));
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		this.setMinimumSize(new Dimension(750, 500));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 580);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-44, 5, 823, 567);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		JLabel lblPaciente = new JLabel("");
		lblPaciente.setIcon(new ImageIcon(ventana.class.getResource("/images/iconPaciente.png")));
		lblPaciente.setBounds(100, 204, 208, 193);
		panel.add(lblPaciente);


		
		JLabel lblClnicaBuenaSalud = new JLabel("Healthy Code");
		lblClnicaBuenaSalud.setBounds(45, 0, 731, 98);
		lblClnicaBuenaSalud.setBackground(new Color(51, 153, 255));
		panel.add(lblClnicaBuenaSalud);
		lblClnicaBuenaSalud.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 39));
		lblClnicaBuenaSalud.setOpaque(true);
		lblClnicaBuenaSalud.setForeground(Color.WHITE);
		
		
		
		
		
		Image imgmedico= new ImageIcon("medico.png").getImage();
		ImageIcon img3=new ImageIcon(imgmedico.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
		
		Image imgcita= new ImageIcon("cita.png").getImage();
		ImageIcon img4=new ImageIcon(imgcita.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
	
	}
}
