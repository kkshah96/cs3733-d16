package view;

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

import controller.NewLightningLevelController;
import controller.NewPuzzleLevelController;
import controller.NewReleaseLevelController;
import controller.StartLightningLevelController;
import controller.StartPuzzleLevelController;
import controller.StartReleaseLevelController;

import javax.swing.SwingConstants;

import model.LevelBuilder;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LevelLoaderView extends JFrame{

	ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	LevelBuilder builder;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public LevelLoaderView(LevelBuilder builder) {
		setResizable(false);
		this.builder = builder;
		initialize();
	}

	public void setFrameVisible() {
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		getContentPane().setBackground(Color.LIGHT_GRAY);

		JPanel pnlLevels = new JPanel();
		pnlLevels.setBackground(Color.LIGHT_GRAY);
		pnlLevels.setForeground(Color.LIGHT_GRAY);
		pnlLevels.setBorder(null);

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(Color.DARK_GRAY);
		pnlTitle.setBorder(null);
		
		JButton btnNewPuzzleLevel = new JButton("New Puzzle Level");
		btnNewPuzzleLevel.addActionListener(new NewPuzzleLevelController(builder, this));
		btnNewPuzzleLevel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewPuzzleLevel.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnNewLightningLevel = new JButton("New Lightning Level");
		btnNewLightningLevel.addActionListener(new NewLightningLevelController(builder, this));
		btnNewLightningLevel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewLightningLevel.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnNewReleaseLevel = new JButton("New Release Level");
		btnNewReleaseLevel.addMouseListener(new NewReleaseLevelController(builder, this));
		btnNewReleaseLevel.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewReleaseLevel.setBackground(UIManager.getColor("Button.background"));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewPuzzleLevel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewLightningLevel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewReleaseLevel)
					.addContainerGap(262, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(pnlLevels, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewPuzzleLevel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewLightningLevel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewReleaseLevel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlLevels, GroupLayout.PREFERRED_SIZE, 383, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlTitle.setLayout(null);

		JLabel lblLevelSelection = new JLabel("Level Loader");
		lblLevelSelection.setBounds(12, 6, 709, 38);
		lblLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelection.setForeground(Color.LIGHT_GRAY);
		lblLevelSelection.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		pnlTitle.add(lblLevelSelection);
		pnlLevels.setLayout(null);

		JLabel lblLevels = new JLabel("Game Levels");
		lblLevels.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblLevels.setBounds(0, 0, 707, 29);
		pnlLevels.add(lblLevels);

		JButton btnLevel1 = new JButton("Level 1: Puzzle");
		btnLevel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel1.setBackground(UIManager.getColor("Button.background"));
		btnLevel1.setBounds(0, 35, 136, 29);
		pnlLevels.add(btnLevel1);

		JButton btnLevel4 = new JButton("Level 4: Puzzle");
		btnLevel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel4.setBackground(UIManager.getColor("Button.background"));
		btnLevel4.setBounds(0, 75, 136, 29);
		pnlLevels.add(btnLevel4);

		JButton btnLevel7 = new JButton("Level 7: Puzzle");
		btnLevel7.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel7.setBackground(UIManager.getColor("Button.background"));
		btnLevel7.setBounds(0, 115, 136, 29);
		pnlLevels.add(btnLevel7);

		JButton btnLevel10 = new JButton("Level 10: Puzzle");
		btnLevel10.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel10.setBackground(UIManager.getColor("Button.background"));
		btnLevel10.setBounds(0, 155, 136, 29);
		pnlLevels.add(btnLevel10);

		JButton btnLevel13 = new JButton("Level 13: Puzzle");
		btnLevel13.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel13.setBackground(UIManager.getColor("Button.background"));
		btnLevel13.setBounds(0, 195, 136, 29);
		pnlLevels.add(btnLevel13);

		JButton btnLevel2 = new JButton("Level 2: Lightning");
		btnLevel2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel2.setBackground(UIManager.getColor("Button.background"));
		btnLevel2.setBounds(218, 35, 148, 29);
		pnlLevels.add(btnLevel2);

		JButton btnLevel5 = new JButton("Level 5: Lightning");
		btnLevel5.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel5.setBackground(UIManager.getColor("Button.background"));
		btnLevel5.setBounds(218, 75, 148, 29);
		pnlLevels.add(btnLevel5);

		JButton btnLevel8 = new JButton("Level 8: Lightning");
		btnLevel8.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel8.setBackground(UIManager.getColor("Button.background"));
		btnLevel8.setBounds(218, 115, 148, 29);
		pnlLevels.add(btnLevel8);

		JButton btnLevel11 = new JButton("Level 11: Lightning");
		btnLevel11.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel11.setBackground(UIManager.getColor("Button.background"));
		btnLevel11.setBounds(218, 155, 148, 29);
		pnlLevels.add(btnLevel11);

		JButton btnLevel14 = new JButton("Level 14: Lightning");
		btnLevel14.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel14.setBackground(UIManager.getColor("Button.background"));
		btnLevel14.setBounds(218, 195, 148, 29);
		pnlLevels.add(btnLevel14);

		JButton btnLevel3 = new JButton("Level 3: Release");
		btnLevel3.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel3.setBackground(UIManager.getColor("Button.background"));
		btnLevel3.setBounds(465, 35, 148, 29);
		pnlLevels.add(btnLevel3);

		JButton btnLevel6 = new JButton("Level 6: Release");
		btnLevel6.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel6.setBackground(UIManager.getColor("Button.background"));
		btnLevel6.setBounds(465, 75, 148, 29);
		pnlLevels.add(btnLevel6);

		JButton btnLevel9 = new JButton("Level 9: Release");
		btnLevel9.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel9.setBackground(UIManager.getColor("Button.background"));
		btnLevel9.setBounds(465, 115, 148, 29);
		pnlLevels.add(btnLevel9);

		JButton btnLevel12 = new JButton("Level 12: Release");
		btnLevel12.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel12.setBackground(UIManager.getColor("Button.background"));
		btnLevel12.setBounds(465, 155, 148, 29);
		pnlLevels.add(btnLevel12);

		JButton btnLevel15 = new JButton("Level 15: Release");
		btnLevel15.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel15.setBackground(UIManager.getColor("Button.background"));
		btnLevel15.setBounds(463, 195, 148, 29);
		pnlLevels.add(btnLevel15);

		JButton btnLevel16 = new JButton("Level 16: Puzzle");
		btnLevel16.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel16.setBackground(UIManager.getColor("Button.background"));
		btnLevel16.setBounds(0, 235, 136, 29);
		pnlLevels.add(btnLevel16);

		JButton btnLevel17 = new JButton("Level 17: Lightning");
		btnLevel17.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel17.setBackground(UIManager.getColor("Button.background"));
		btnLevel17.setBounds(218, 235, 148, 29);
		pnlLevels.add(btnLevel17);

		JButton btnLevel18 = new JButton("Level 18: Release");
		btnLevel18.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel18.setBackground(UIManager.getColor("Button.background"));
		btnLevel18.setBounds(463, 235, 148, 29);
		pnlLevels.add(btnLevel18);

		JButton btnLevel19 = new JButton("Level 19: Puzzle");
		btnLevel19.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel19.setBackground(UIManager.getColor("Button.background"));
		btnLevel19.setBounds(0, 275, 136, 29);
		pnlLevels.add(btnLevel19);

		JButton btnLevel20 = new JButton("Level 20: Lightning");
		btnLevel20.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel20.setBackground(UIManager.getColor("Button.background"));
		btnLevel20.setBounds(218, 275, 148, 29);
		pnlLevels.add(btnLevel20);

		JButton btnLevel21 = new JButton("Level 21: Release");
		btnLevel21.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel21.setBackground(UIManager.getColor("Button.background"));
		btnLevel21.setBounds(463, 275, 148, 29);
		pnlLevels.add(btnLevel21);

		JButton btnLevel22 = new JButton("Level 22: Puzzle");
		btnLevel22.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel22.setBackground(UIManager.getColor("Button.background"));
		btnLevel22.setBounds(0, 315, 136, 29);
		pnlLevels.add(btnLevel22);

		JButton btnLevel23 = new JButton("Level 23: Lightning");
		btnLevel23.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel23.setBackground(UIManager.getColor("Button.background"));
		btnLevel23.setBounds(218, 315, 148, 29);
		pnlLevels.add(btnLevel23);

		JButton btnLevel24 = new JButton("Level 24: Release");
		btnLevel24.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel24.setBackground(UIManager.getColor("Button.background"));
		btnLevel24.setBounds(463, 315, 148, 29);
		pnlLevels.add(btnLevel24);

		JButton btnLevel25 = new JButton("Level 25: Puzzle");
		btnLevel25.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel25.setBackground(UIManager.getColor("Button.background"));
		btnLevel25.setBounds(0, 355, 136, 29);
		pnlLevels.add(btnLevel25);

		JButton btnLevel26 = new JButton("Level 26: Lightning");
		btnLevel26.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel26.setBackground(UIManager.getColor("Button.background"));
		btnLevel26.setBounds(218, 355, 148, 29);
		pnlLevels.add(btnLevel26);

		JButton btnLevel27 = new JButton("Level 27: Release");
		btnLevel27.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel27.setBackground(UIManager.getColor("Button.background"));
		btnLevel27.setBounds(463, 355, 148, 29);
		pnlLevels.add(btnLevel27);

		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 733, 514);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add buttons and labels to lists
		levelButtons.add(btnLevel1);
		levelButtons.add(btnLevel2);
		levelButtons.add(btnLevel3);
		levelButtons.add(btnLevel4);
		levelButtons.add(btnLevel5);
		levelButtons.add(btnLevel6);
		levelButtons.add(btnLevel7);
		levelButtons.add(btnLevel8);
		levelButtons.add(btnLevel9);
		levelButtons.add(btnLevel10);
		levelButtons.add(btnLevel11);
		levelButtons.add(btnLevel12);
		levelButtons.add(btnLevel13);
		levelButtons.add(btnLevel14);
		levelButtons.add(btnLevel15);
		levelButtons.add(btnLevel16);
		levelButtons.add(btnLevel17);
		levelButtons.add(btnLevel18);
		levelButtons.add(btnLevel19);
		levelButtons.add(btnLevel20);
		levelButtons.add(btnLevel21);
		levelButtons.add(btnLevel22);
		levelButtons.add(btnLevel23);
		levelButtons.add(btnLevel24);
		levelButtons.add(btnLevel25);
		levelButtons.add(btnLevel26);
		levelButtons.add(btnLevel27);
		
		// add mouse listeners to all level buttons
		for (int i = 0; i < levelButtons.size(); i++){
			if (i % 3 == 0) {
				levelButtons.get(i).addActionListener(new NewPuzzleLevelController(builder, this));
			}
			else if (i % 3 == 1) {
				levelButtons.get(i).addActionListener(new NewLightningLevelController(builder, this));
			}
			else {
				levelButtons.get(i).addMouseListener(new NewReleaseLevelController(builder, this));
			}
		}
	}
	
	public ArrayList<JButton> getLevelButtons(){
		return levelButtons;
	}
}