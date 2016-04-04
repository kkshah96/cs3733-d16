package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LevelBuilder_MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilder_MainMenu window = new LevelBuilder_MainMenu();
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
	public LevelBuilder_MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 542, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 542, 70);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setBounds(181, 13, 182, 38);
		lblLevelBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelBuilder.setForeground(Color.LIGHT_GRAY);
		lblLevelBuilder.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panel.add(lblLevelBuilder);
		
		JButton btnCreateLevel = new JButton("Level Editor");
		btnCreateLevel.setForeground(Color.DARK_GRAY);
		btnCreateLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		btnCreateLevel.setBackground(Color.LIGHT_GRAY);
		btnCreateLevel.setBounds(167, 112, 200, 40);
		frame.getContentPane().add(btnCreateLevel);
		
		JButton btnSavedLevels = new JButton("Saved Levels");
		btnSavedLevels.setForeground(Color.DARK_GRAY);
		btnSavedLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		btnSavedLevels.setBackground(Color.LIGHT_GRAY);
		btnSavedLevels.setBounds(167, 164, 200, 40);
		frame.getContentPane().add(btnSavedLevels);
	}

}
