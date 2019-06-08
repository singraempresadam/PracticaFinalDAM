package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class VentanaError extends JDialog {
	private JLabel lblInfo;
	public VentanaError() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPrincipal.class.getResource("/images/iconsalud.png")));
		setLocationRelativeTo(null);
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		
		JLabel lblError = new JLabel("Error: la operaci\u00F3n no pudo realizarse");
		lblError.setIcon(new ImageIcon(VentanaError.class.getResource("/images/error.png")));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblError, BorderLayout.CENTER);
		
		lblInfo = new JLabel("");
		getContentPane().add(lblInfo, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(300, 150));
		
	}
	public JLabel getLblInfo() {
		return lblInfo;
	}
	public void setLblInfo(JLabel lblInfo) {
		this.lblInfo = lblInfo;
	}
	
}
