package MockupGUI;

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
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Starting_Menu {

	private JFrame frame;

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
		
		JButton btnNewButton = new JButton("Select Level");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(116, 108, 200, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Level Builder");
		button.setSelectedIcon(null);
		button.setForeground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(116, 160, 200, 40);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(100, 58, 226, 40);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Puzzle Game\nby Troilus");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(null);
		panel_1.setBounds(0, 0, 450, 46);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Kabasuji");
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
	}
}
