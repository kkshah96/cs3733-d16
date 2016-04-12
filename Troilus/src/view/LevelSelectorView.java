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

import controller.StartLevelController;

import javax.swing.SwingConstants;

import model.Kabasuji;

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

public class LevelSelectorView extends JFrame{

	ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	ArrayList<JLabel> levelLabels = new ArrayList<JLabel>();
	Kabasuji game;

	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public LevelSelectorView(Kabasuji game) {
		this.game = game;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBorder(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		JLabel lblLevelSelection = new JLabel("Level Selection");
		lblLevelSelection.setBounds(259, 6, 210, 38);
		lblLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelection.setForeground(Color.LIGHT_GRAY);
		lblLevelSelection.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panel_2.add(lblLevelSelection);
		panel.setLayout(null);
		
		JLabel labelLevels = new JLabel("Game Levels");
		labelLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		labelLevels.setBounds(293, 0, 117, 29);
		panel.add(labelLevels);
		
		JButton btnLevel1 = new JButton("Level 1: Puzzle");
		btnLevel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel1.setBackground(UIManager.getColor("Button.background"));
		btnLevel1.setBounds(0, 35, 136, 29);
		panel.add(btnLevel1);
		btnLevel1.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel4 = new JButton("Level 4: Puzzle");
		btnLevel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel4.setBackground(UIManager.getColor("Button.background"));
		btnLevel4.setBounds(0, 75, 136, 29);
		panel.add(btnLevel4);
		btnLevel4.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel7 = new JButton("Level 7: Puzzle");
		btnLevel7.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel7.setBackground(UIManager.getColor("Button.background"));
		btnLevel7.setBounds(0, 115, 136, 29);
		panel.add(btnLevel7);
		btnLevel7.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel10 = new JButton("Level 10: Puzzle");
		btnLevel10.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel10.setBackground(UIManager.getColor("Button.background"));
		btnLevel10.setBounds(0, 155, 136, 29);
		panel.add(btnLevel10);
		btnLevel10.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel13 = new JButton("Level 13: Puzzle");
		btnLevel13.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel13.setBackground(UIManager.getColor("Button.background"));
		btnLevel13.setBounds(0, 195, 136, 29);
		panel.add(btnLevel13);
		btnLevel13.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel1 = new JLabel("Stars: 0/3");
		labelLevel1.setBounds(143, 35, 75, 29);
		panel.add(labelLevel1);
		
		JLabel labelLevel4 = new JLabel("Stars: 0/3");
		labelLevel4.setBounds(143, 75, 75, 29);
		panel.add(labelLevel4);
		
		JLabel labelLevel7 = new JLabel("Stars: 0/3");
		labelLevel7.setBounds(143, 115, 75, 29);
		panel.add(labelLevel7);
		
		JLabel labelLevel10 = new JLabel("Stars: 0/3");
		labelLevel10.setBounds(143, 155, 75, 29);
		panel.add(labelLevel10);
		
		JLabel labelLevel13 = new JLabel("Stars: 0/3");
		labelLevel13.setBounds(143, 195, 75, 29);
		panel.add(labelLevel13);
		
		JButton btnLevel2 = new JButton("Level 2: Lightning");
		btnLevel2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel2.setBackground(UIManager.getColor("Button.background"));
		btnLevel2.setBounds(218, 35, 148, 29);
		panel.add(btnLevel2);
		btnLevel2.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel5 = new JButton("Level 5: Lightning");
		btnLevel5.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel5.setBackground(UIManager.getColor("Button.background"));
		btnLevel5.setBounds(218, 75, 148, 29);
		panel.add(btnLevel5);
		btnLevel5.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel8 = new JButton("Level 8: Lightning");
		btnLevel8.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel8.setBackground(UIManager.getColor("Button.background"));
		btnLevel8.setBounds(218, 115, 148, 29);
		panel.add(btnLevel8);
		btnLevel8.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel11 = new JButton("Level 11: Lightning");
		btnLevel11.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel11.setBackground(UIManager.getColor("Button.background"));
		btnLevel11.setBounds(218, 155, 148, 29);
		panel.add(btnLevel11);
		btnLevel11.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel14 = new JButton("Level 14: Lightning");
		btnLevel14.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel14.setBackground(UIManager.getColor("Button.background"));
		btnLevel14.setBounds(218, 195, 148, 29);
		panel.add(btnLevel14);
		btnLevel14.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel2 = new JLabel("Stars: 0/3");
		labelLevel2.setBounds(370, 35, 83, 29);
		panel.add(labelLevel2);
		
		JLabel labelLevel5 = new JLabel("Stars: 0/3");
		labelLevel5.setBounds(370, 75, 83, 29);
		panel.add(labelLevel5);
		
		JLabel labelLevel8 = new JLabel("Stars: 0/3");
		labelLevel8.setBounds(370, 115, 83, 29);
		panel.add(labelLevel8);
		
		JLabel labelLevel11 = new JLabel("Stars: 0/3");
		labelLevel11.setBounds(370, 155, 83, 29);
		panel.add(labelLevel11);
		
		JLabel labelLevel14 = new JLabel("Stars: 0/3");
		labelLevel14.setBounds(370, 195, 83, 29);
		panel.add(labelLevel14);
		
		JButton btnLevel3 = new JButton("Level 3: Release");
		btnLevel3.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel3.setBackground(UIManager.getColor("Button.background"));
		btnLevel3.setBounds(465, 35, 148, 29);
		panel.add(btnLevel3);
		btnLevel3.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel6 = new JButton("Level 6: Release");
		btnLevel6.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel6.setBackground(UIManager.getColor("Button.background"));
		btnLevel6.setBounds(465, 75, 148, 29);
		panel.add(btnLevel6);
		btnLevel6.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel9 = new JButton("Level 9: Release");
		btnLevel9.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel9.setBackground(UIManager.getColor("Button.background"));
		btnLevel9.setBounds(465, 115, 148, 29);
		panel.add(btnLevel9);
		btnLevel9.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel12 = new JButton("Level 12: Release");
		btnLevel12.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel12.setBackground(UIManager.getColor("Button.background"));
		btnLevel12.setBounds(465, 155, 148, 29);
		panel.add(btnLevel12);
		btnLevel12.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel15 = new JButton("Level 15: Release");
		btnLevel15.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel15.setBackground(UIManager.getColor("Button.background"));
		btnLevel15.setBounds(463, 195, 148, 29);
		panel.add(btnLevel15);
		btnLevel15.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel3 = new JLabel("Stars: 0/3");
		labelLevel3.setBounds(618, 35, 85, 29);
		panel.add(labelLevel3);
		
		JLabel labelLevel6 = new JLabel("Stars: 0/3");
		labelLevel6.setBounds(618, 75, 85, 29);
		panel.add(labelLevel6);
		
		JLabel labelLevel9 = new JLabel("Stars: 0/3");
		labelLevel9.setBounds(618, 115, 85, 29);
		panel.add(labelLevel9);
		
		JLabel labelLevel12 = new JLabel("Stars: 0/3");
		labelLevel12.setBounds(618, 155, 85, 29);
		panel.add(labelLevel12);
		
		JLabel labelLevel15 = new JLabel("Stars: 0/3");
		labelLevel15.setBounds(618, 195, 85, 29);
		panel.add(labelLevel15);
		
		JButton btnLevel16 = new JButton("Level 16: Puzzle");
		btnLevel16.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel16.setBackground(UIManager.getColor("Button.background"));
		btnLevel16.setBounds(0, 235, 136, 29);
		panel.add(btnLevel16);
		btnLevel16.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel16 = new JLabel("Stars: 0/3");
		labelLevel16.setBounds(143, 235, 75, 29);
		panel.add(labelLevel16);
		
		JButton btnLevel17 = new JButton("Level 17: Lightning");
//		btnLevel17.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		btnLevel17.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel17.setBackground(UIManager.getColor("Button.background"));
		btnLevel17.setBounds(218, 235, 148, 29);
		panel.add(btnLevel17);
		btnLevel17.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel17 = new JLabel("Stars: 0/3");
		labelLevel17.setBounds(370, 235, 83, 29);
		panel.add(labelLevel17);
		
		JButton btnLevel18 = new JButton("Level 18: Release");
//		btnLevel18.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		btnLevel18.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel18.setBackground(UIManager.getColor("Button.background"));
		btnLevel18.setBounds(463, 235, 148, 29);
		panel.add(btnLevel18);
		
		JLabel labelLevel18 = new JLabel("Stars: 0/3");
		labelLevel18.setBounds(618, 235, 85, 29);
		panel.add(labelLevel18);
		
		JButton btnLevel19 = new JButton("Level 19: Puzzle");
		btnLevel19.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel19.setBackground(UIManager.getColor("Button.background"));
		btnLevel19.setBounds(0, 275, 136, 29);
		panel.add(btnLevel19);
		
		JLabel labelLevel19 = new JLabel("Stars: 0/3");
		labelLevel19.setBounds(143, 275, 75, 29);
		panel.add(labelLevel19);
		
		JButton btnLevel20 = new JButton("Level 20: Lightning");
		btnLevel20.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel20.setBackground(UIManager.getColor("Button.background"));
		btnLevel20.setBounds(218, 275, 148, 29);
		panel.add(btnLevel20);
		
		JLabel labelLevel20 = new JLabel("Stars: 0/3");
		labelLevel20.setBounds(370, 275, 83, 29);
		panel.add(labelLevel20);
		
		JButton btnLevel21 = new JButton("Level 21: Release");
		btnLevel21.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel21.setBackground(UIManager.getColor("Button.background"));
		btnLevel21.setBounds(463, 275, 148, 29);
		panel.add(btnLevel21);
		
		JLabel labelLevel21 = new JLabel("Stars: 0/3");
		labelLevel21.setBounds(618, 275, 85, 29);
		panel.add(labelLevel21);
		
		JButton btnLevel22 = new JButton("Level 22: Puzzle");
		btnLevel22.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel22.setBackground(UIManager.getColor("Button.background"));
		btnLevel22.setBounds(0, 315, 136, 29);
		
		panel.add(btnLevel22);
		
		JLabel labelLevel22 = new JLabel("Stars: 0/3");
		labelLevel22.setBounds(143, 315, 75, 29);
		panel.add(labelLevel22);
		
		JButton btnLevel23 = new JButton("Level 23: Lightning");
		btnLevel23.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel23.setBackground(UIManager.getColor("Button.background"));
		btnLevel23.setBounds(218, 315, 148, 29);
		panel.add(btnLevel23);
		
		JLabel labelLevel23 = new JLabel("Stars: 0/3");
		labelLevel23.setBounds(370, 315, 83, 29);
		panel.add(labelLevel23);
		
		JButton btnLevel24 = new JButton("Level 24: Release");
		btnLevel24.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel24.setBackground(UIManager.getColor("Button.background"));
		btnLevel24.setBounds(463, 315, 148, 29);
		panel.add(btnLevel24);
		
		JLabel labelLevel24 = new JLabel("Stars: 0/3");
		labelLevel24.setBounds(618, 315, 85, 29);
		panel.add(labelLevel24);
		
		JButton btnLevel25 = new JButton("Level 25: Puzzle");
		btnLevel25.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel25.setBackground(UIManager.getColor("Button.background"));
		btnLevel25.setBounds(0, 355, 136, 29);
		panel.add(btnLevel25);
		
		JLabel labelLevel25 = new JLabel("Stars: 0/3");
		labelLevel25.setBounds(143, 355, 75, 29);
		panel.add(labelLevel25);
		
		JButton btnLevel26 = new JButton("Level 26: Lightning");
		btnLevel26.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel26.setBackground(UIManager.getColor("Button.background"));
		btnLevel26.setBounds(218, 355, 148, 29);
		panel.add(btnLevel26);
		
		JLabel labelLevel26 = new JLabel("Stars: 0/3");
		labelLevel26.setBounds(370, 355, 83, 29);
		panel.add(labelLevel26);
		
		JButton btnLevel27 = new JButton("Level 27: Release");
		btnLevel27.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel27.setBackground(UIManager.getColor("Button.background"));
		btnLevel27.setBounds(463, 355, 148, 29);
		panel.add(btnLevel27);
		
		JLabel labelLevel27 = new JLabel("Stars: 0/3");
		labelLevel27.setBounds(618, 355, 85, 29);
		panel.add(labelLevel27);
		
		
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
		
		levelLabels.add(labelLevel1);
		levelLabels.add(labelLevel2);
		levelLabels.add(labelLevel3);
		levelLabels.add(labelLevel4);
		levelLabels.add(labelLevel5);
		levelLabels.add(labelLevel6);
		levelLabels.add(labelLevel7);
		levelLabels.add(labelLevel8);
		levelLabels.add(labelLevel9);
		levelLabels.add(labelLevel10);
		levelLabels.add(labelLevel11);
		levelLabels.add(labelLevel12);
		levelLabels.add(labelLevel13);
		levelLabels.add(labelLevel14);
		levelLabels.add(labelLevel15);
		levelLabels.add(labelLevel16);
		levelLabels.add(labelLevel17);
		levelLabels.add(labelLevel18);
		levelLabels.add(labelLevel19);
		levelLabels.add(labelLevel20);
		levelLabels.add(labelLevel21);
		levelLabels.add(labelLevel22);
		levelLabels.add(labelLevel23);
		levelLabels.add(labelLevel24);
		levelLabels.add(labelLevel25);
		levelLabels.add(labelLevel26);
		levelLabels.add(labelLevel27);
	}
	public ArrayList<JButton> getLevelButtons(){
		return levelButtons;
	}
	
	public ArrayList<JLabel> getLevelLabels() {
		return levelLabels;
	}
}
