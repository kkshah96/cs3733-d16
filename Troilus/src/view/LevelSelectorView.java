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
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class LevelSelectorView extends JFrame{

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
		
		JLabel labelLevels = new JLabel("Game Levels");
		labelLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		labelLevels.setBounds(299, 0, 117, 16);
		panel.add(labelLevels);
		
		JButton btnLevel1 = new JButton("Level 1: Puzzle");
		btnLevel1.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel1.setBackground(UIManager.getColor("Button.background"));
		btnLevel1.setBounds(6, 17, 136, 29);
		panel.add(btnLevel1);
		btnLevel1.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel4 = new JButton("Level 4: Puzzle");
		btnLevel4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel4.setBackground(UIManager.getColor("Button.background"));
		btnLevel4.setBounds(6, 45, 136, 29);
		panel.add(btnLevel4);
		btnLevel4.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel7 = new JButton("Level 7: Puzzle");
		btnLevel7.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel7.setBackground(UIManager.getColor("Button.background"));
		btnLevel7.setBounds(6, 75, 136, 29);
		panel.add(btnLevel7);
		btnLevel7.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel10 = new JButton("Level 10: Puzzle");
		btnLevel10.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel10.setBackground(UIManager.getColor("Button.background"));
		btnLevel10.setBounds(6, 102, 136, 29);
		panel.add(btnLevel10);
		btnLevel10.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel13 = new JButton("Level 13: Puzzle");
		btnLevel13.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel13.setBackground(UIManager.getColor("Button.background"));
		btnLevel13.setBounds(6, 130, 136, 29);
		panel.add(btnLevel13);
		btnLevel13.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel1 = new JLabel("Stars: 0/3");
		labelLevel1.setBounds(142, 20, 85, 26);
		panel.add(labelLevel1);
		
		JLabel labelLevel4 = new JLabel("Stars: 0/3");
		labelLevel4.setBounds(142, 48, 85, 26);
		panel.add(labelLevel4);
		
		JLabel labelLevel7 = new JLabel("Stars: 0/3");
		labelLevel7.setBounds(142, 78, 85, 26);
		panel.add(labelLevel7);
		
		JLabel labelLevel10 = new JLabel("Stars: 0/3");
		labelLevel10.setBounds(142, 105, 85, 26);
		panel.add(labelLevel10);
		
		JLabel labelLevel13 = new JLabel("Stars: 0/3");
		labelLevel13.setBounds(142, 133, 85, 26);
		panel.add(labelLevel13);
		
		JButton btnLevel2 = new JButton("Level 2: Lightning");
		btnLevel2.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel2.setBackground(UIManager.getColor("Button.background"));
		btnLevel2.setBounds(224, 17, 148, 29);
		panel.add(btnLevel2);
		btnLevel2.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel5 = new JButton("Level 5: Lightning");
		btnLevel5.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel5.setBackground(UIManager.getColor("Button.background"));
		btnLevel5.setBounds(224, 44, 148, 29);
		panel.add(btnLevel5);
		btnLevel5.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel8 = new JButton("Level 8: Lightning");
		btnLevel8.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel8.setBackground(UIManager.getColor("Button.background"));
		btnLevel8.setBounds(224, 72, 148, 29);
		panel.add(btnLevel8);
		btnLevel8.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel11 = new JButton("Level 11: Lightning");
		btnLevel11.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel11.setBackground(UIManager.getColor("Button.background"));
		btnLevel11.setBounds(224, 101, 148, 29);
		panel.add(btnLevel11);
		btnLevel11.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel14 = new JButton("Level 14: Lightning");
		btnLevel14.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel14.setBackground(UIManager.getColor("Button.background"));
		btnLevel14.setBounds(224, 130, 148, 29);
		panel.add(btnLevel14);
		btnLevel14.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel2 = new JLabel("Stars: 0/3");
		labelLevel2.setBounds(374, 20, 85, 26);
		panel.add(labelLevel2);
		
		JLabel labelLevel5 = new JLabel("Stars: 0/3");
		labelLevel5.setBounds(374, 47, 85, 27);
		panel.add(labelLevel5);
		
		JLabel labelLevel8 = new JLabel("Stars: 0/3");
		labelLevel8.setBounds(374, 75, 85, 29);
		panel.add(labelLevel8);
		
		JLabel labelLevel11 = new JLabel("Stars: 0/3");
		labelLevel11.setBounds(374, 104, 85, 27);
		panel.add(labelLevel11);
		
		JLabel labelLevel14 = new JLabel("Stars: 0/3");
		labelLevel14.setBounds(374, 133, 85, 26);
		panel.add(labelLevel14);
		
		JButton btnLevel3 = new JButton("Level 3: Release");
		btnLevel3.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel3.setBackground(UIManager.getColor("Button.background"));
		btnLevel3.setBounds(471, 17, 148, 29);
		panel.add(btnLevel3);
		btnLevel3.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel6 = new JButton("Level 6: Release");
		btnLevel6.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel6.setBackground(UIManager.getColor("Button.background"));
		btnLevel6.setBounds(471, 46, 148, 29);
		panel.add(btnLevel6);
		btnLevel6.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel9 = new JButton("Level 9: Release");
		btnLevel9.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel9.setBackground(UIManager.getColor("Button.background"));
		btnLevel9.setBounds(471, 76, 148, 29);
		panel.add(btnLevel9);
		btnLevel9.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel12 = new JButton("Level 12: Release");
		btnLevel12.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel12.setBackground(UIManager.getColor("Button.background"));
		btnLevel12.setBounds(471, 105, 148, 29);
		panel.add(btnLevel12);
		btnLevel12.addMouseListener(new StartLevelController(this, game));
		
		JButton btnLevel15 = new JButton("Level 15: Release");
		btnLevel15.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel15.setBackground(UIManager.getColor("Button.background"));
		btnLevel15.setBounds(471, 130, 148, 29);
		panel.add(btnLevel15);
		btnLevel15.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel3 = new JLabel("Stars: 0/3");
		labelLevel3.setBounds(624, 20, 85, 26);
		panel.add(labelLevel3);
		
		JLabel labelLevel6 = new JLabel("Stars: 0/3");
		labelLevel6.setBounds(624, 49, 85, 25);
		panel.add(labelLevel6);
		
		JLabel labelLevel9 = new JLabel("Stars: 0/3");
		labelLevel9.setBounds(624, 79, 85, 25);
		panel.add(labelLevel9);
		
		JLabel labelLevel12 = new JLabel("Stars: 0/3");
		labelLevel12.setBounds(624, 108, 85, 23);
		panel.add(labelLevel12);
		
		JLabel labelLevel15 = new JLabel("Stars: 0/3");
		labelLevel15.setBounds(624, 133, 85, 26);
		panel.add(labelLevel15);
		
		JButton btnLevel16 = new JButton("Level 16: Puzzle");
		btnLevel16.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel16.setBackground(UIManager.getColor("Button.background"));
		btnLevel16.setBounds(6, 161, 136, 29);
		panel.add(btnLevel16);
		btnLevel16.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel16 = new JLabel("Stars: 0/3");
		labelLevel16.setBounds(142, 164, 85, 26);
		panel.add(labelLevel16);
		
		JButton btnLevel17 = new JButton("Level 17: Release");
		btnLevel17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLevel17.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnLevel17.setBackground(UIManager.getColor("Button.background"));
		btnLevel17.setBounds(224, 160, 148, 29);
		panel.add(btnLevel17);
		btnLevel17.addMouseListener(new StartLevelController(this, game));
		
		JLabel labelLevel17 = new JLabel("Stars: 0/3");
		labelLevel17.setBounds(374, 160, 85, 30);
		panel.add(labelLevel17);
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 733, 514);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
