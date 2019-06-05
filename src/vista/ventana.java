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
	
		Image imgpaciente= new ImageIcon("paciente.png").getImage();
		ImageIcon img2=new ImageIcon(imgpaciente.getScaledInstance(139, 137, Image.SCALE_SMOOTH));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 580);
		
		Image imgmedico= new ImageIcon("medico.png").getImage();
		ImageIcon img3=new ImageIcon(imgmedico.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
		
		Image imgcita= new ImageIcon("cita.png").getImage();
		ImageIcon img4=new ImageIcon(imgcita.getScaledInstance(100, 130, Image.SCALE_SMOOTH));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[173px][140px][105px][126px][170px]", "[98px][137px][][][]"));
		
		
		
		JLabel lblClnicaBuenaSalud = new JLabel("Healthy Code");
		lblClnicaBuenaSalud.setBackground(new Color(51, 153, 255));
		panel.add(lblClnicaBuenaSalud, "cell 0 0 5 1,grow");
		lblClnicaBuenaSalud.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 39));
		lblClnicaBuenaSalud.setOpaque(true);
		lblClnicaBuenaSalud.setForeground(Color.WHITE);
		
		JLabel labelpaciente = new JLabel("");
		panel.add(labelpaciente, "cell 0 3,grow");
		labelpaciente.setIcon(img2); 
		
		JLabel labelmedico = new JLabel("");
		panel.add(labelmedico, "cell 2 3,growx,aligny top");
		labelmedico.setIcon(img3);
		
		JLabel labelcita = new JLabel("");
		panel.add(labelcita, "cell 4 3,alignx left,aligny top");
		labelcita.setIcon(img4);
	
	}
	
	
}
