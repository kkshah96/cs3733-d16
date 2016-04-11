package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Splash_Screen extends JFrame {

	/**
	 * Launch the application.
	 */
		
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash_Screen window = new Splash_Screen();
					window.setVisible(true);
					
					//window.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Splash_Screen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 534, 427);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 305);
		panel.setBorder(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Kabasuji");
		label.setBounds(151, 38, 248, 108);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.LIGHT_GRAY);
		label.setFont(new Font("PT Sans Caption", Font.BOLD, 55));
		panel.add(label);
		
		JLabel lblTroilus = new JLabel("Troilus");
		lblTroilus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTroilus.setForeground(Color.LIGHT_GRAY);
		lblTroilus.setFont(new Font("PT Sans Caption", Font.BOLD, 26));
		lblTroilus.setBounds(171, 173, 204, 54);
		panel.add(lblTroilus);
		
		JLabel lblInsertLogoHere = new JLabel("Insert Logo Here");
		lblInsertLogoHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertLogoHere.setForeground(Color.LIGHT_GRAY);
		lblInsertLogoHere.setFont(new Font("PT Sans Caption", Font.BOLD, 26));
		lblInsertLogoHere.setBounds(161, 121, 238, 62);
		panel.add(lblInsertLogoHere);
		
		JLabel lblDanAlfredConnor = new JLabel("Dan Alfred, Connor Weeks, Maddy Longo,");
		lblDanAlfredConnor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanAlfredConnor.setForeground(Color.LIGHT_GRAY);
		lblDanAlfredConnor.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		lblDanAlfredConnor.setBounds(61, 226, 447, 73);
		panel.add(lblDanAlfredConnor);
		
		JLabel lblKunalAlex = new JLabel("Alex Kasparek, Kunal Shah");
		lblKunalAlex.setHorizontalAlignment(SwingConstants.CENTER);
		lblKunalAlex.setForeground(Color.LIGHT_GRAY);
		lblKunalAlex.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		lblKunalAlex.setBounds(61, 256, 447, 73);
		panel.add(lblKunalAlex); 
		
		
		setPreferredSize(new Dimension(500,500));
		getContentPane().add(panel);
	}

}
