package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import java.awt.Panel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Level_Selection {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level_Selection window = new Level_Selection();
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
	public Level_Selection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(11, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		JLabel lblLevelSelection = new JLabel("Level Selection");
		lblLevelSelection.setBounds(259, 6, 210, 38);
		lblLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelection.setForeground(Color.LIGHT_GRAY);
		lblLevelSelection.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panel_2.add(lblLevelSelection);
		panel.setLayout(null);
		
		JLabel lblGameLevels = new JLabel("Game Levels");
		lblGameLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblGameLevels.setBounds(299, 0, 117, 16);
		panel.add(lblGameLevels);
		
		JButton button = new JButton("Level 1: Puzzle");
		button.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(6, 17, 136, 29);
		panel.add(button);
		
		JButton btnLevelPuzzle = new JButton("Level 4: Puzzle");
		btnLevelPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle.setBounds(6, 45, 136, 29);
		panel.add(btnLevelPuzzle);
		
		JButton btnLevelPuzzle_1 = new JButton("Level 7: Puzzle");
		btnLevelPuzzle_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_1.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_1.setBounds(6, 75, 136, 29);
		panel.add(btnLevelPuzzle_1);
		
		JButton btnLevelPuzzle_2 = new JButton("Level 10: Puzzle");
		btnLevelPuzzle_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_2.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_2.setBounds(6, 102, 136, 29);
		panel.add(btnLevelPuzzle_2);
		
		JButton btnLevelPuzzle_3 = new JButton("Level 13: Puzzle");
		btnLevelPuzzle_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_3.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_3.setBounds(6, 130, 136, 29);
		panel.add(btnLevelPuzzle_3);
		
		JLabel label_9 = new JLabel("Stars: 0/3");
		label_9.setBounds(142, 20, 85, 16);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("Stars: 0/3");
		label_10.setBounds(142, 48, 85, 16);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("Stars: 0/3");
		label_11.setBounds(142, 78, 85, 16);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("Stars: 0/3");
		label_12.setBounds(142, 105, 85, 16);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("Stars: 0/3");
		label_13.setBounds(142, 133, 85, 16);
		panel.add(label_13);
		
		JButton btnLevelLightning = new JButton("Level 2: Lightning");
		btnLevelLightning.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning.setBackground(Color.DARK_GRAY);
		btnLevelLightning.setBounds(224, 17, 148, 29);
		panel.add(btnLevelLightning);
		
		JButton btnLevelLightning_1 = new JButton("Level 5: Lightning");
		btnLevelLightning_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_1.setBackground(Color.DARK_GRAY);
		btnLevelLightning_1.setBounds(224, 44, 148, 29);
		panel.add(btnLevelLightning_1);
		
		JButton btnLevelLightning_2 = new JButton("Level 8: Lightning");
		btnLevelLightning_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_2.setBackground(Color.DARK_GRAY);
		btnLevelLightning_2.setBounds(224, 72, 148, 29);
		panel.add(btnLevelLightning_2);
		
		JButton btnLevelLightning_3 = new JButton("Level 11: Lightning");
		btnLevelLightning_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_3.setBackground(Color.DARK_GRAY);
		btnLevelLightning_3.setBounds(224, 101, 148, 29);
		panel.add(btnLevelLightning_3);
		
		JButton btnLevelLightning_4 = new JButton("Level 14: Lightning");
		btnLevelLightning_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_4.setBackground(Color.DARK_GRAY);
		btnLevelLightning_4.setBounds(224, 130, 148, 29);
		panel.add(btnLevelLightning_4);
		
		JLabel label_4 = new JLabel("Stars: 0/3");
		label_4.setBounds(374, 20, 85, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Stars: 0/3");
		label_5.setBounds(374, 47, 85, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Stars: 0/3");
		label_6.setBounds(374, 75, 85, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Stars: 0/3");
		label_7.setBounds(374, 104, 85, 16);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Stars: 0/3");
		label_8.setBounds(374, 133, 85, 16);
		panel.add(label_8);
		
		JButton btnLevelRelease = new JButton("Level 3: Release");
		btnLevelRelease.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease.setBackground(Color.DARK_GRAY);
		btnLevelRelease.setBounds(471, 17, 148, 29);
		panel.add(btnLevelRelease);
		
		JButton btnLevelRelease_1 = new JButton("Level 6: Release");
		btnLevelRelease_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_1.setBackground(Color.DARK_GRAY);
		btnLevelRelease_1.setBounds(471, 46, 148, 29);
		panel.add(btnLevelRelease_1);
		
		JButton btnLevelRelease_2 = new JButton("Level 9: Release");
		btnLevelRelease_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_2.setBackground(Color.DARK_GRAY);
		btnLevelRelease_2.setBounds(471, 76, 148, 29);
		panel.add(btnLevelRelease_2);
		
		JButton btnLevelRelease_3 = new JButton("Level 12: Release");
		btnLevelRelease_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_3.setBackground(Color.DARK_GRAY);
		btnLevelRelease_3.setBounds(471, 105, 148, 29);
		panel.add(btnLevelRelease_3);
		
		JButton btnLevelRelease_4 = new JButton("Level 15: Release");
		btnLevelRelease_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_4.setBackground(Color.DARK_GRAY);
		btnLevelRelease_4.setBounds(471, 130, 148, 29);
		panel.add(btnLevelRelease_4);
		
		JLabel label = new JLabel("Stars: 0/3");
		label.setBounds(624, 20, 85, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Stars: 0/3");
		label_1.setBounds(624, 49, 85, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Stars: 0/3");
		label_2.setBounds(624, 79, 85, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Stars: 0/3");
		label_3.setBounds(624, 108, 85, 16);
		panel.add(label_3);
		
		JLabel label_14 = new JLabel("Stars: 0/3");
		label_14.setBounds(624, 133, 85, 16);
		panel.add(label_14);
		
		JButton btnLevelPuzzle_4 = new JButton("Level 16: Puzzle");
		btnLevelPuzzle_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_4.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_4.setBounds(6, 161, 136, 29);
		panel.add(btnLevelPuzzle_4);
		
		JLabel label_15 = new JLabel("Stars: 0/3");
		label_15.setBounds(142, 164, 85, 16);
		panel.add(label_15);
		
		JButton btnLevelRelease_5 = new JButton("Level 7: Release");
		btnLevelRelease_5.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_5.setBackground(Color.DARK_GRAY);
		btnLevelRelease_5.setBounds(224, 161, 136, 29);
		panel.add(btnLevelRelease_5);
		
		JLabel label_16 = new JLabel("Stars: 0/3");
		label_16.setBounds(360, 164, 85, 16);
		panel.add(label_16);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 733, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
