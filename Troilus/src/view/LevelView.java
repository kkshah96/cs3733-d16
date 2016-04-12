package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import controller.StartLevelController;
import controller.ExitLevelController;

import model.Kabasuji;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;

public class LevelView extends JFrame{

	private JPanel panelTitle;
	private JLabel lblLevelPuzzle;
	private JPanel panelPuzzleStats;
	private JPanel panelLightningStats;
	private JPanel panelReleaseStats;
	
	LevelSelectorView levelSelector;
	Kabasuji game;
	Level level;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public LevelView(LevelSelectorView levelSelector, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.game = game;
		this.level = game.getActiveLevel();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 953, 565);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panelTitle = new JPanel();
		panelTitle.setBorder(null);
		panelTitle.setBackground(Color.DARK_GRAY);
		panelTitle.setBounds(0, 0, 953, 46);
		panel.add(panelTitle);
		
		lblLevelPuzzle = new JLabel("Level 1: Puzzle");
		lblLevelPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelPuzzle.setForeground(Color.LIGHT_GRAY);
		lblLevelPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panelTitle.add(lblLevelPuzzle);
		
		JPanel panelBoard = new BoardView();
		panelBoard.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelBoard.setBackground(Color.LIGHT_GRAY);
		panelBoard.setBounds(0, 88, 461, 455);
		panel.add(panelBoard);
		panelBoard.setLayout(null);
		
		JPanel panelBullpen = new JPanel();
		panelBullpen.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelBullpen.setBackground(Color.LIGHT_GRAY);
		panelBullpen.setBounds(458, 88, 495, 455);
		panel.add(panelBullpen);
		panelBullpen.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(6, 6, 483, 33);
		panelBullpen.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblBullpen = new JLabel("Bullpen");
		lblBullpen.setBounds(6, 6, 80, 23);
		lblBullpen.setForeground(Color.BLACK);
		lblBullpen.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		panel_5.add(lblBullpen);
		
		JButton btnNewButton_1 = new JButton("Rotate CW");
		btnNewButton_1.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(76, 4, 99, 29);
		panel_5.add(btnNewButton_1);
		
		JButton btnRotateCcw = new JButton("Rotate CCW");
		btnRotateCcw.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnRotateCcw.setBounds(166, 4, 93, 29);
		panel_5.add(btnRotateCcw);
		
		JButton btnFlip = new JButton("Flip Horizontal");
		btnFlip.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlip.setBounds(250, 4, 110, 29);
		panel_5.add(btnFlip);
		
		JButton btnFlipVertical = new JButton("Flip Vertical");
		btnFlipVertical.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlipVertical.setBounds(361, 4, 110, 29);
		panel_5.add(btnFlipVertical);
		
		JButton btnExitLevel = new JButton("Exit Level");
		btnExitLevel.addMouseListener(new ExitLevelController(this, levelSelector, game));
		btnExitLevel.setBounds(771, 50, 176, 36);
		panel.add(btnExitLevel);
		
		panelPuzzleStats = new JPanel();
		panelPuzzleStats.setLayout(null);
		panelPuzzleStats.setBorder(null);
		panelPuzzleStats.setBackground(Color.LIGHT_GRAY);
		panelPuzzleStats.setBounds(569, 52, 115, 34);
		panel.add(panelPuzzleStats);
		
		JLabel label_1 = new JLabel("Moves: 40/50");
		label_1.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		label_1.setBounds(6, 7, 99, 22);
		panelPuzzleStats.add(label_1);
		
		JLabel labelStars = new JLabel("Stars: 0/3");
		labelStars.setBounds(689, 60, 82, 16);
		panel.add(labelStars);
		labelStars.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		
		panelReleaseStats = new JPanel();
		panelReleaseStats.setBounds(10, 48, 383, 38);
		panel.add(panelReleaseStats);
		panelReleaseStats.setLayout(null);
		panelReleaseStats.setBorder(null);
		panelReleaseStats.setBackground(Color.LIGHT_GRAY);
		
		JLabel label_4 = new JLabel("Red Squares:");
		label_4.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_4.setBounds(0, 16, 82, 16);
		panelReleaseStats.add(label_4);
		
		JLabel label_5 = new JLabel("0/6");
		label_5.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_5.setBounds(85, 16, 31, 16);
		panelReleaseStats.add(label_5);
		
		JLabel label_6 = new JLabel("Green Squares:");
		label_6.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_6.setBounds(115, 16, 103, 16);
		panelReleaseStats.add(label_6);
		
		JLabel label_7 = new JLabel("0/6");
		label_7.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_7.setBounds(218, 16, 31, 16);
		panelReleaseStats.add(label_7);
		
		JLabel label_8 = new JLabel("Yellow Squares:");
		label_8.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_8.setBounds(249, 16, 103, 16);
		panelReleaseStats.add(label_8);
		
		JLabel label_9 = new JLabel("0/6");
		label_9.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_9.setBounds(356, 16, 31, 16);
		panelReleaseStats.add(label_9);
		
		panelLightningStats = new JPanel();
		panelLightningStats.setBounds(394, 50, 175, 34);
		panel.add(panelLightningStats);
		panelLightningStats.setLayout(null);
		panelLightningStats.setBorder(null);
		panelLightningStats.setBackground(Color.LIGHT_GRAY);
		
		JLabel label = new JLabel("Time Remaining: 1:30");
		label.setBounds(6, 6, 161, 20);
		panelLightningStats.add(label);
		label.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		
		
	}
	
	public JPanel getPanelPuzzleStats() {
		return panelPuzzleStats;
	}
	
	public JPanel getPanelLightningStats() {
		return panelLightningStats;
	}
	
	public JPanel getPanelReleaseStats() {
		return panelReleaseStats;
	}
}
