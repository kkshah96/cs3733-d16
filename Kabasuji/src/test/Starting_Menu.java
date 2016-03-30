package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Starting_Menu {

	private JFrame frame;
	private JTextField txtKabasuji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Starting_Menu window = new Starting_Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Starting_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtKabasuji = new JTextField();
		txtKabasuji.setFont(new Font("PT Sans Caption", Font.BOLD, 35));
		txtKabasuji.setForeground(Color.LIGHT_GRAY);
		txtKabasuji.setBackground(Color.DARK_GRAY);
		txtKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		txtKabasuji.setText("Kabasuji");
		txtKabasuji.setBounds(-11, -15, 467, 100);
		frame.getContentPane().add(txtKabasuji);
		txtKabasuji.setColumns(10);
		
		JButton btnNewButton = new JButton("Select Level");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(156, 113, 130, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Level Builder");
		button.setSelectedIcon(null);
		button.setForeground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(156, 154, 130, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("About");
		button_1.setForeground(Color.DARK_GRAY);
		button_1.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		button_1.setBackground(Color.DARK_GRAY);
		button_1.setBounds(156, 195, 130, 40);
		frame.getContentPane().add(button_1);
	}
}
