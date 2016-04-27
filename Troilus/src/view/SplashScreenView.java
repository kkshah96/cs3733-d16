package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class SplashScreenView extends JFrame {
	/**
	 * Create the application.
	 */
	public SplashScreenView() {
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 534, 427);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 534, 305);
		mainPanel.setBorder(null);
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("Kabasuji");
		lblKabasuji.setBounds(12, 38, 496, 108);
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(Color.LIGHT_GRAY);
		lblKabasuji.setFont(new Font("PT Sans Caption", Font.BOLD, 55));
		mainPanel.add(lblKabasuji);
		
		JLabel logo = new JLabel(new ImageIcon(SplashScreenView.class.getResource("/images/logo.png")));
		logo.setEnabled(true);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setFont(new Font("PT Sans Caption", Font.BOLD, 26));
		logo.setBounds(22, 170, 496, 72);
		mainPanel.add(logo);
		
		JLabel lblAlexKunal = new JLabel("Alex Kasparek, Kunal Shah");
		lblAlexKunal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexKunal.setForeground(Color.LIGHT_GRAY);
		lblAlexKunal.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		lblAlexKunal.setBounds(12, 333, 506, 54);
		mainPanel.add(lblAlexKunal);
		
		setPreferredSize(new Dimension(500,500));
		getContentPane().add(mainPanel);
		
		JLabel lblDanAlfredConnor = new JLabel("Dan Alfred, Connor Weeks, Maddy Longo,");
		lblDanAlfredConnor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanAlfredConnor.setForeground(Color.LIGHT_GRAY);
		lblDanAlfredConnor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDanAlfredConnor.setBounds(12, 311, 506, 49);
		mainPanel.add(lblDanAlfredConnor);
	}
}