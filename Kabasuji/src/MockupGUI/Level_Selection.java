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
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(30);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JButton btnSpeedLightning = new JButton("Speed: Lightning");
		btnSpeedLightning.setForeground(Color.BLACK);
		btnSpeedLightning.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnSpeedLightning.setBackground(Color.LIGHT_GRAY);
		btnSpeedLightning.setBounds(6, 24, 140, 29);
		panel_1.add(btnSpeedLightning);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBorder(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_6.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBounds(6, 0, 144, 31);
		panel_6.add(btnMainMenu);
		btnMainMenu.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		
		JLabel lblCustomLevels = new JLabel("Custom Levels");
		lblCustomLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblCustomLevels.setBounds(293, 6, 117, 16);
		panel_1.add(lblCustomLevels);
		
		JButton btnMyLevel = new JButton("My Level: Release");
		btnMyLevel.setForeground(Color.BLACK);
		btnMyLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnMyLevel.setBackground(Color.LIGHT_GRAY);
		btnMyLevel.setBounds(6, 53, 140, 29);
		panel_1.add(btnMyLevel);
		
		JButton btnHardPuzzle = new JButton("Hard: Puzzle");
		btnHardPuzzle.setForeground(Color.BLACK);
		btnHardPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnHardPuzzle.setBackground(Color.LIGHT_GRAY);
		btnHardPuzzle.setBounds(6, 79, 140, 29);
		panel_1.add(btnHardPuzzle);
		
		JButton btnImpossibleLightning = new JButton("LevelX: Lightning");
		btnImpossibleLightning.setForeground(Color.BLACK);
		btnImpossibleLightning.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnImpossibleLightning.setBackground(Color.LIGHT_GRAY);
		btnImpossibleLightning.setBounds(6, 107, 140, 29);
		panel_1.add(btnImpossibleLightning);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(null);
		panel_3.setBounds(6, 17, 235, 166);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLevelPuzzle = new JButton("Level 1: Puzzle");
		btnLevelPuzzle.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle.setBounds(6, 6, 136, 29);
		panel_3.add(btnLevelPuzzle);
		
		JButton btnLevelPuzzle_1 = new JButton("Level 2: Puzzle");
		btnLevelPuzzle_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLevelPuzzle_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_1.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_1.setBounds(6, 34, 136, 29);
		panel_3.add(btnLevelPuzzle_1);
		
		JButton btnLevelPuzzle_2 = new JButton("Level 3: Puzzle");
		btnLevelPuzzle_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_2.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_2.setBounds(6, 64, 136, 29);
		panel_3.add(btnLevelPuzzle_2);
		
		JButton btnLevelPuzzle_3 = new JButton("Level 4: Puzzle");
		btnLevelPuzzle_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_3.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_3.setBounds(6, 91, 136, 29);
		panel_3.add(btnLevelPuzzle_3);
		
		JButton btnLevelPuzzle_4 = new JButton("Level 5: Puzzle");
		btnLevelPuzzle_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelPuzzle_4.setBackground(Color.DARK_GRAY);
		btnLevelPuzzle_4.setBounds(6, 119, 136, 29);
		panel_3.add(btnLevelPuzzle_4);
		
		JLabel label_9 = new JLabel("Stars: 0/3");
		label_9.setBounds(142, 9, 85, 16);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Stars: 0/3");
		label_10.setBounds(142, 37, 85, 16);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Stars: 0/3");
		label_11.setBounds(142, 67, 85, 16);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Stars: 0/3");
		label_12.setBounds(142, 94, 85, 16);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("Stars: 0/3");
		label_13.setBounds(142, 122, 85, 16);
		panel_3.add(label_13);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(253, 17, 247, 166);
		panel.add(panel_4);
		
		JButton btnLevelLightning = new JButton("Level 6: Lightning");
		btnLevelLightning.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning.setBackground(Color.DARK_GRAY);
		btnLevelLightning.setBounds(6, 6, 148, 29);
		panel_4.add(btnLevelLightning);
		
		JButton btnLevelLightning_1 = new JButton("Level 7: Lightning");
		btnLevelLightning_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_1.setBackground(Color.DARK_GRAY);
		btnLevelLightning_1.setBounds(6, 33, 148, 29);
		panel_4.add(btnLevelLightning_1);
		
		JButton btnLevelLightning_2 = new JButton("Level 8: Lightning");
		btnLevelLightning_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_2.setBackground(Color.DARK_GRAY);
		btnLevelLightning_2.setBounds(6, 61, 148, 29);
		panel_4.add(btnLevelLightning_2);
		
		JButton btnLevelLightning_3 = new JButton("Level 9: Lightning");
		btnLevelLightning_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_3.setBackground(Color.DARK_GRAY);
		btnLevelLightning_3.setBounds(6, 90, 148, 29);
		panel_4.add(btnLevelLightning_3);
		
		JButton btnLevelLightning_4 = new JButton("Level 10: Lightning");
		btnLevelLightning_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelLightning_4.setBackground(Color.DARK_GRAY);
		btnLevelLightning_4.setBounds(6, 119, 148, 29);
		panel_4.add(btnLevelLightning_4);
		
		JLabel label_4 = new JLabel("Stars: 0/3");
		label_4.setBounds(156, 9, 85, 16);
		panel_4.add(label_4);
		
		JLabel label_5 = new JLabel("Stars: 0/3");
		label_5.setBounds(156, 36, 85, 16);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Stars: 0/3");
		label_6.setBounds(156, 64, 85, 16);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("Stars: 0/3");
		label_7.setBounds(156, 93, 85, 16);
		panel_4.add(label_7);
		
		JLabel label_8 = new JLabel("Stars: 0/3");
		label_8.setBounds(156, 122, 85, 16);
		panel_4.add(label_8);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(512, 17, 252, 166);
		panel.add(panel_5);
		
		JButton btnLevel = new JButton("Level 11: Release");
		btnLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel.setBackground(Color.DARK_GRAY);
		btnLevel.setBounds(6, 6, 148, 29);
		panel_5.add(btnLevel);
		
		JButton btnLevelRelease = new JButton("Level 12: Release");
		btnLevelRelease.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease.setBackground(Color.DARK_GRAY);
		btnLevelRelease.setBounds(6, 35, 148, 29);
		panel_5.add(btnLevelRelease);
		
		JButton btnLevelRelease_1 = new JButton("Level 13: Release");
		btnLevelRelease_1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_1.setBackground(Color.DARK_GRAY);
		btnLevelRelease_1.setBounds(6, 65, 148, 29);
		panel_5.add(btnLevelRelease_1);
		
		JButton btnLevelRelease_2 = new JButton("Level 14: Release");
		btnLevelRelease_2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_2.setBackground(Color.DARK_GRAY);
		btnLevelRelease_2.setBounds(6, 94, 148, 29);
		panel_5.add(btnLevelRelease_2);
		
		JButton btnLevelRelease_3 = new JButton("Level 15: Release");
		btnLevelRelease_3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevelRelease_3.setBackground(Color.DARK_GRAY);
		btnLevelRelease_3.setBounds(6, 119, 148, 29);
		panel_5.add(btnLevelRelease_3);
		
		JLabel lblStars = new JLabel("Stars: 0/3");
		lblStars.setBounds(159, 9, 85, 16);
		panel_5.add(lblStars);
		
		JLabel label = new JLabel("Stars: 0/3");
		label.setBounds(159, 38, 85, 16);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("Stars: 0/3");
		label_1.setBounds(159, 68, 85, 16);
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("Stars: 0/3");
		label_2.setBounds(159, 97, 85, 16);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("Stars: 0/3");
		label_3.setBounds(159, 122, 85, 16);
		panel_5.add(label_3);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 782, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
