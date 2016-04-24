package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.Timer;

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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 305);
		panel.setBorder(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Kabasuji");
		label.setBounds(12, 38, 496, 108);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("PT Sans Caption", Font.BOLD, 55));
		panel.add(label);
		
		JLabel lblInsertLogoHere = new JLabel(new ImageIcon(SplashScreenView.class.getResource("/images/logo.png")));
		lblInsertLogoHere.setEnabled(true);
		lblInsertLogoHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertLogoHere.setFont(new Font("PT Sans Caption", Font.BOLD, 26));
		lblInsertLogoHere.setBounds(22, 170, 496, 72);
		panel.add(lblInsertLogoHere);
		
		JLabel lblAlexKunal = new JLabel("Alex Kasparek, Kunal Shah");
		lblAlexKunal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexKunal.setForeground(Color.LIGHT_GRAY);
		lblAlexKunal.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		lblAlexKunal.setBounds(12, 333, 506, 54);
		panel.add(lblAlexKunal);
		
		
		setPreferredSize(new Dimension(500,500));
		getContentPane().add(panel);
		
		JLabel lblDanAlfredConnor = new JLabel("Dan Alfred, Connor Weeks, Maddy Longo,");
		lblDanAlfredConnor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanAlfredConnor.setForeground(Color.LIGHT_GRAY);
		lblDanAlfredConnor.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDanAlfredConnor.setBounds(12, 311, 506, 49);
		panel.add(lblDanAlfredConnor);
	}
}
