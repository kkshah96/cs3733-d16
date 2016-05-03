package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.SwingConstants;

import model.Kabasuji;

import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 * GUI for selecting Levels in the Kabasuji game.
 * 
 * Displays buttons for every playable level in the game, as well as labels containing
 * the number of stars received for respective Levels.
 * 
 * @author Kunal Shah
 *
 */
public class LevelSelectorView extends JFrame{
	/**
	 * Default ID to get rid of warnings.
	 */
	private static final long serialVersionUID = 1L;

	/** The collection of buttons for levels loaded */
	ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	
	/** The collection of labels displaying progress for levels loaded */
	ArrayList<JLabel> levelLabels = new ArrayList<JLabel>();
	
	/** The top-level entity */
	Kabasuji game;


	/**
	 * Creates a new instance of LevelSelectorView with the provided game entity
	 * @param game Reference to the Kabasuji entity object to use
	 */
	public LevelSelectorView(Kabasuji game) {
		setResizable(false);
		this.game = game;
		initialize();
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

		JPanel pnlTitle = new JPanel();
		pnlTitle.setBackground(Color.DARK_GRAY);
		pnlTitle.setBorder(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlTitle, GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(10)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(pnlTitle, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
						.addContainerGap())
				);
		pnlTitle.setLayout(null);

		JLabel lblLevelSelection = new JLabel("Level Selection");
		lblLevelSelection.setBounds(12, 6, 709, 38);
		lblLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSelection.setForeground(Color.LIGHT_GRAY);
		lblLevelSelection.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		pnlTitle.add(lblLevelSelection);
		panel.setLayout(null);

		JLabel lblLevels = new JLabel("Game Levels");
		lblLevels.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblLevels.setBounds(0, 0, 703, 29);
		panel.add(lblLevels);

		// Initialize level buttons and progress labels
		JButton btnLevel1 = new JButton("Level 1: Puzzle");
		btnLevel1.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel1.setBackground(UIManager.getColor("Button.background"));
		btnLevel1.setBounds(0, 35, 136, 29);
		panel.add(btnLevel1);

		JButton btnLevel4 = new JButton("Level 4: Puzzle");
		btnLevel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel4.setBackground(UIManager.getColor("Button.background"));
		btnLevel4.setBounds(0, 75, 136, 29);
		panel.add(btnLevel4);

		JButton btnLevel7 = new JButton("Level 7: Puzzle");
		btnLevel7.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel7.setBackground(UIManager.getColor("Button.background"));
		btnLevel7.setBounds(0, 115, 136, 29);
		panel.add(btnLevel7);

		JButton btnLevel10 = new JButton("Level 10: Puzzle");
		btnLevel10.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel10.setBackground(UIManager.getColor("Button.background"));
		btnLevel10.setBounds(0, 155, 136, 29);
		panel.add(btnLevel10);

		JButton btnLevel13 = new JButton("Level 13: Puzzle");
		btnLevel13.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel13.setBackground(UIManager.getColor("Button.background"));
		btnLevel13.setBounds(0, 195, 136, 29);
		panel.add(btnLevel13);

		JLabel lblLevel1 = new JLabel("Stars: 0/3");
		lblLevel1.setBounds(143, 35, 75, 29);
		panel.add(lblLevel1);

		JLabel lblLevel4 = new JLabel("Stars: 0/3");
		lblLevel4.setBounds(143, 75, 75, 29);
		panel.add(lblLevel4);

		JLabel lblLevel7 = new JLabel("Stars: 0/3");
		lblLevel7.setBounds(143, 115, 75, 29);
		panel.add(lblLevel7);

		JLabel lblLevel10 = new JLabel("Stars: 0/3");
		lblLevel10.setBounds(143, 155, 75, 29);
		panel.add(lblLevel10);

		JLabel lblLevel13 = new JLabel("Stars: 0/3");
		lblLevel13.setBounds(143, 195, 75, 29);
		panel.add(lblLevel13);

		JButton btnLevel2 = new JButton("Level 2: Lightning");
		btnLevel2.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel2.setBackground(UIManager.getColor("Button.background"));
		btnLevel2.setBounds(218, 35, 148, 29);
		panel.add(btnLevel2);

		JButton btnLevel5 = new JButton("Level 5: Lightning");
		btnLevel5.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel5.setBackground(UIManager.getColor("Button.background"));
		btnLevel5.setBounds(218, 75, 148, 29);
		panel.add(btnLevel5);

		JButton btnLevel8 = new JButton("Level 8: Lightning");
		btnLevel8.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel8.setBackground(UIManager.getColor("Button.background"));
		btnLevel8.setBounds(218, 115, 148, 29);
		panel.add(btnLevel8);

		JButton btnLevel11 = new JButton("Level 11: Lightning");
		btnLevel11.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel11.setBackground(UIManager.getColor("Button.background"));
		btnLevel11.setBounds(218, 155, 148, 29);
		panel.add(btnLevel11);

		JButton btnLevel14 = new JButton("Level 14: Lightning");
		btnLevel14.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel14.setBackground(UIManager.getColor("Button.background"));
		btnLevel14.setBounds(218, 195, 148, 29);
		panel.add(btnLevel14);

		JLabel lblLevel2 = new JLabel("Stars: 0/3");
		lblLevel2.setBounds(370, 35, 83, 29);
		panel.add(lblLevel2);

		JLabel lblLevel5 = new JLabel("Stars: 0/3");
		lblLevel5.setBounds(370, 75, 83, 29);
		panel.add(lblLevel5);

		JLabel lblLevel8 = new JLabel("Stars: 0/3");
		lblLevel8.setBounds(370, 115, 83, 29);
		panel.add(lblLevel8);

		JLabel lblLevel11 = new JLabel("Stars: 0/3");
		lblLevel11.setBounds(370, 155, 83, 29);
		panel.add(lblLevel11);

		JLabel lblLevel14 = new JLabel("Stars: 0/3");
		lblLevel14.setBounds(370, 195, 83, 29);
		panel.add(lblLevel14);

		JButton btnLevel3 = new JButton("Level 3: Release");
		btnLevel3.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel3.setBackground(UIManager.getColor("Button.background"));
		btnLevel3.setBounds(465, 35, 148, 29);
		panel.add(btnLevel3);

		JButton btnLevel6 = new JButton("Level 6: Release");
		btnLevel6.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel6.setBackground(UIManager.getColor("Button.background"));
		btnLevel6.setBounds(465, 75, 148, 29);
		panel.add(btnLevel6);

		JButton btnLevel9 = new JButton("Level 9: Release");
		btnLevel9.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel9.setBackground(UIManager.getColor("Button.background"));
		btnLevel9.setBounds(465, 115, 148, 29);
		panel.add(btnLevel9);

		JButton btnLevel12 = new JButton("Level 12: Release");
		btnLevel12.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel12.setBackground(UIManager.getColor("Button.background"));
		btnLevel12.setBounds(465, 155, 148, 29);
		panel.add(btnLevel12);

		JButton btnLevel15 = new JButton("Level 15: Release");
		btnLevel15.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel15.setBackground(UIManager.getColor("Button.background"));
		btnLevel15.setBounds(463, 195, 148, 29);
		panel.add(btnLevel15);

		JLabel lblLevel3 = new JLabel("Stars: 0/3");
		lblLevel3.setBounds(618, 35, 85, 29);
		panel.add(lblLevel3);

		JLabel lblLevel6 = new JLabel("Stars: 0/3");
		lblLevel6.setBounds(618, 75, 85, 29);
		panel.add(lblLevel6);

		JLabel lblLevel9 = new JLabel("Stars: 0/3");
		lblLevel9.setBounds(618, 115, 85, 29);
		panel.add(lblLevel9);

		JLabel lblLevel12 = new JLabel("Stars: 0/3");
		lblLevel12.setBounds(618, 155, 85, 29);
		panel.add(lblLevel12);

		JLabel lblLevel15 = new JLabel("Stars: 0/3");
		lblLevel15.setBounds(618, 195, 85, 29);
		panel.add(lblLevel15);

		JButton btnLevel16 = new JButton("Level 16: Puzzle");
		btnLevel16.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel16.setBackground(UIManager.getColor("Button.background"));
		btnLevel16.setBounds(0, 235, 136, 29);
		panel.add(btnLevel16);

		JLabel lblLevel16 = new JLabel("Stars: 0/3");
		lblLevel16.setBounds(143, 235, 75, 29);
		panel.add(lblLevel16);

		JButton btnLevel17 = new JButton("Level 17: Lightning");
		btnLevel17.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel17.setBackground(UIManager.getColor("Button.background"));
		btnLevel17.setBounds(218, 235, 148, 29);
		panel.add(btnLevel17);

		JLabel lblLevel17 = new JLabel("Stars: 0/3");
		lblLevel17.setBounds(370, 235, 83, 29);
		panel.add(lblLevel17);

		JButton btnLevel18 = new JButton("Level 18: Release");
		btnLevel18.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel18.setBackground(UIManager.getColor("Button.background"));
		btnLevel18.setBounds(463, 235, 148, 29);
		panel.add(btnLevel18);

		JLabel lblLevel18 = new JLabel("Stars: 0/3");
		lblLevel18.setBounds(618, 235, 85, 29);
		panel.add(lblLevel18);

		JButton btnLevel19 = new JButton("Level 19: Puzzle");
		btnLevel19.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel19.setBackground(UIManager.getColor("Button.background"));
		btnLevel19.setBounds(0, 275, 136, 29);
		panel.add(btnLevel19);

		JLabel lblLevel19 = new JLabel("Stars: 0/3");
		lblLevel19.setBounds(143, 275, 75, 29);
		panel.add(lblLevel19);

		JButton btnLevel20 = new JButton("Level 20: Lightning");
		btnLevel20.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel20.setBackground(UIManager.getColor("Button.background"));
		btnLevel20.setBounds(218, 275, 148, 29);
		panel.add(btnLevel20);

		JLabel lblLevel20 = new JLabel("Stars: 0/3");
		lblLevel20.setBounds(370, 275, 83, 29);
		panel.add(lblLevel20);

		JButton btnLevel21 = new JButton("Level 21: Release");
		btnLevel21.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel21.setBackground(UIManager.getColor("Button.background"));
		btnLevel21.setBounds(463, 275, 148, 29);
		panel.add(btnLevel21);

		JLabel lblLevel21 = new JLabel("Stars: 0/3");
		lblLevel21.setBounds(618, 275, 85, 29);
		panel.add(lblLevel21);

		JButton btnLevel22 = new JButton("Level 22: Puzzle");
		btnLevel22.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel22.setBackground(UIManager.getColor("Button.background"));
		btnLevel22.setBounds(0, 315, 136, 29);

		panel.add(btnLevel22);

		JLabel lblLevel22 = new JLabel("Stars: 0/3");
		lblLevel22.setBounds(143, 315, 75, 29);
		panel.add(lblLevel22);

		JButton btnLevel23 = new JButton("Level 23: Lightning");
		btnLevel23.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel23.setBackground(UIManager.getColor("Button.background"));
		btnLevel23.setBounds(218, 315, 148, 29);
		panel.add(btnLevel23);

		JLabel lblLevel23 = new JLabel("Stars: 0/3");
		lblLevel23.setBounds(370, 315, 83, 29);
		panel.add(lblLevel23);

		JButton btnLevel24 = new JButton("Level 24: Release");
		btnLevel24.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel24.setBackground(UIManager.getColor("Button.background"));
		btnLevel24.setBounds(463, 315, 148, 29);
		panel.add(btnLevel24);

		JLabel lblLevel24 = new JLabel("Stars: 0/3");
		lblLevel24.setBounds(618, 315, 85, 29);
		panel.add(lblLevel24);

		JButton btnLevel25 = new JButton("Level 25: Puzzle");
		btnLevel25.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel25.setBackground(UIManager.getColor("Button.background"));
		btnLevel25.setBounds(0, 355, 136, 29);
		panel.add(btnLevel25);

		JLabel lblLevel25 = new JLabel("Stars: 0/3");
		lblLevel25.setBounds(143, 355, 75, 29);
		panel.add(lblLevel25);

		JButton btnLevel26 = new JButton("Level 26: Lightning");
		btnLevel26.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel26.setBackground(UIManager.getColor("Button.background"));
		btnLevel26.setBounds(218, 355, 148, 29);
		panel.add(btnLevel26);

		JLabel lblLevel26 = new JLabel("Stars: 0/3");
		lblLevel26.setBounds(370, 355, 83, 29);
		panel.add(lblLevel26);

		JButton btnLevel27 = new JButton("Level 27: Release");
		btnLevel27.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnLevel27.setBackground(UIManager.getColor("Button.background"));
		btnLevel27.setBounds(463, 355, 148, 29);
		panel.add(btnLevel27);

		JLabel lblLevel27 = new JLabel("Stars: 0/3");
		lblLevel27.setBounds(618, 355, 85, 29);
		panel.add(lblLevel27);


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

		levelLabels.add(lblLevel1);
		levelLabels.add(lblLevel2);
		levelLabels.add(lblLevel3);
		levelLabels.add(lblLevel4);
		levelLabels.add(lblLevel5);
		levelLabels.add(lblLevel6);
		levelLabels.add(lblLevel7);
		levelLabels.add(lblLevel8);
		levelLabels.add(lblLevel9);
		levelLabels.add(lblLevel10);
		levelLabels.add(lblLevel11);
		levelLabels.add(lblLevel12);
		levelLabels.add(lblLevel13);
		levelLabels.add(lblLevel14);
		levelLabels.add(lblLevel15);
		levelLabels.add(lblLevel16);
		levelLabels.add(lblLevel17);
		levelLabels.add(lblLevel18);
		levelLabels.add(lblLevel19);
		levelLabels.add(lblLevel20);
		levelLabels.add(lblLevel21);
		levelLabels.add(lblLevel22);
		levelLabels.add(lblLevel23);
		levelLabels.add(lblLevel24);
		levelLabels.add(lblLevel25);
		levelLabels.add(lblLevel26);
		levelLabels.add(lblLevel27);
	}
	
	/**
	 * Provides the collection of 15 level buttons in this view
	 * @return ArrayList of JButton for the 15 level buttons
	 */
	public ArrayList<JButton> getLevelButtons(){
		return levelButtons;
	}

	/**
	 * Provides the collection of corresponding 15 level progress labels in this view
	 * @return Arraylist of JLabel for the 15 level progress statuses
	 */
	public ArrayList<JLabel> getLevelLabels() {
		return levelLabels;
	}
}