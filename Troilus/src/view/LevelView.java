package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.BoardController;
import controller.BullpenController;
import controller.ExitLevelController;
import controller.FlipPieceController;
import controller.RotatePieceController;
import controller.SelectPieceBullpenController;
import model.Kabasuji;
import model.Level;
import model.Piece;

/**
 * GUI for a playable level in the Kabasuji game.
 * 
 * Contains a BoardView, BullpenView, and Paletteview as well as
 * necessary buttons and labels for playing a Kabasuji Level.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 *
 */
public class LevelView extends JFrame{
	private JPanel panelTitle;
	private JLabel lblLevelPuzzle;
	private JPanel panelPuzzleStats;
	private JPanel panelLightningStats;
	private JPanel panelReleaseStats;
	JButton flipPieceHButton;
	
	JLabel movesLabel;

	LevelSelectorView levelSelector;
	Kabasuji game;
	Level level;
	BullpenView bullpenView;
	BoardView boardView;

	/**
	 * Create the application.
	 */
	public LevelView(LevelSelectorView levelSelector, Kabasuji game, Level level) { 
		setResizable(false);
		this.levelSelector = levelSelector;
		this.game = game;
		this.level = level;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 953, 565);

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

		boardView = new BoardView(level);
		boardView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		boardView.setBackground(Color.LIGHT_GRAY);
		boardView.setBounds(0, 88, 461, 455);
		panel.add(boardView);
		boardView.setLayout(null);
		// BoardController
		boardView.addMouseListener(new BoardController(level, boardView));
		boardView.addMouseMotionListener(new BoardController(level, boardView));
		
		JPanel bullpenContainer = new JPanel();
		bullpenContainer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bullpenContainer.setBackground(Color.LIGHT_GRAY);
		bullpenContainer.setBounds(458, 88, 495, 455);
		panel.add(bullpenContainer);
		bullpenContainer.setLayout(null);

		JPanel bullpenOptionsPanel = new JPanel();
		bullpenOptionsPanel.setBackground(Color.LIGHT_GRAY);
		bullpenOptionsPanel.setBounds(6, 6, 483, 33);
		bullpenContainer.add(bullpenOptionsPanel);
		bullpenOptionsPanel.setLayout(null);

		JLabel bullpenLabel = new JLabel("Bullpen");
		bullpenLabel.setBounds(6, 6, 80, 23);
		bullpenLabel.setForeground(Color.BLACK);
		bullpenLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		bullpenOptionsPanel.add(bullpenLabel);

		// create actual bullpen view and add it to the scroll pane
		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenView = new BullpenView(level, bullpenScrollPane);
		bullpenView.setLayout(null);
		bullpenView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bullpenView.setBackground(Color.LIGHT_GRAY);
		bullpenView.setBounds(748, 38, 457, 484);
		// BullpenController
		bullpenView.addMouseListener(new BullpenController(level, bullpenView));

		bullpenScrollPane.setBounds(6, 50, 479, 394);
		bullpenScrollPane.setViewportView(bullpenView);
		bullpenContainer.add(bullpenScrollPane);

		JButton rotateCWButton = new JButton("Rotate CW");
		rotateCWButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		rotateCWButton.setBounds(76, 4, 99, 29);
		rotateCWButton.addActionListener(new RotatePieceController(level, bullpenView, Piece.ROTATE_CW));
		bullpenOptionsPanel.add(rotateCWButton);

		JButton rotateCCWButton = new JButton("Rotate CCW");
		rotateCCWButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		rotateCCWButton.setBounds(166, 4, 93, 29);
		rotateCCWButton.addActionListener(new RotatePieceController(level, bullpenView, Piece.ROTATE_CCW));
		bullpenOptionsPanel.add(rotateCCWButton);

		JButton flipPieceHorizontalButton = new JButton("Flip Horizontal");
		flipPieceHorizontalButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		flipPieceHorizontalButton.setBounds(250, 4, 110, 29);
		flipPieceHorizontalButton.addActionListener(new FlipPieceController(level, bullpenView, Piece.FLIP_HORIZONTALLY));
		bullpenOptionsPanel.add(flipPieceHorizontalButton);

		JButton flipPieceVerticalButton = new JButton("Flip Vertical");
		flipPieceVerticalButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		flipPieceVerticalButton.setBounds(361, 4, 110, 29);
		flipPieceVerticalButton.addActionListener(new FlipPieceController(level, bullpenView, Piece.FLIP_VERTICALLY));
		bullpenOptionsPanel.add(flipPieceVerticalButton);

		JButton btnExitLevel = new JButton("Exit Level");
		btnExitLevel.addActionListener(new ExitLevelController(this, levelSelector, game));
		btnExitLevel.setBounds(771, 50, 176, 36);
		panel.add(btnExitLevel);

		panelPuzzleStats = new JPanel();
		panelPuzzleStats.setLayout(null);
		panelPuzzleStats.setBorder(null);
		panelPuzzleStats.setBackground(Color.LIGHT_GRAY);
		panelPuzzleStats.setBounds(569, 52, 115, 34);
		panel.add(panelPuzzleStats);

		// TODO remove hard-coded vals!
		movesLabel = new JLabel("Moves: 40/50");
		movesLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		movesLabel.setBounds(6, 7, 99, 22);
		panelPuzzleStats.add(movesLabel);

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
	
	public JLabel getMovesLabel() {
		return movesLabel;
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
	
	public BoardView getBoardView() {
		return boardView;
	}
}