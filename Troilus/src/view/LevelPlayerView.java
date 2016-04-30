package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import model.Kabasuji;
import model.Level;
import model.LightningLevel;
import model.Piece;
import model.PuzzleLevel;
import model.ReleaseLevel;

/**
 * GUI for a playable level in the Kabasuji game.
 * 
 * Contains a BoardView, BullpenView, and Paletteview as well as
 * necessary buttons and labels for playing a Kabasuji Level.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Connor Weeks
 *
 */
public class LevelPlayerView extends JFrame implements ILevelView {
	private JPanel panelTitle;
	private JLabel levelLabel;
	private JPanel panelPuzzleStats;
	private JPanel panelLightningStats;
	private JPanel panelReleaseStats;
	private JLabel labelYellow;
	private JLabel labelGreen;
	private JLabel labelRed;
	JButton flipPieceHButton;
	
	JLabel movesLabel;
	JLabel timeLabel;
	JLabel labelStars;

	LevelSelectorView levelSelector;
	Kabasuji game;
	Level level;
	BullpenView bullpenView;
	BoardView boardView;
	
	// flag for the timer
	private boolean isActive;

	/**
	 * Create the application.
	 */
	public LevelPlayerView(LevelSelectorView levelSelector, Kabasuji game, Level level) { 
		setResizable(false);
		this.levelSelector = levelSelector;
		this.game = game;
		this.level = level;
		this.isActive = true;
		// set isActive to false for timer when window closes
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
                isActive = false;
            }
        });
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

		levelLabel = new JLabel("Level 1: Puzzle");
		levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelLabel.setForeground(Color.LIGHT_GRAY);
		levelLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panelTitle.add(levelLabel);

		boardView = new BoardView(level);
		boardView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		boardView.setBackground(Color.LIGHT_GRAY);
		boardView.setBounds(0, 88, 461, 455);
		panel.add(boardView);
		boardView.setLayout(null);
		// BoardController
		boardView.addMouseListener(new BoardController(level, this, game));
		boardView.addMouseMotionListener(new BoardController(level, this, game));
		
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
		bullpenView.addMouseListener(new BullpenController(level, this));
		
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
		btnExitLevel.addActionListener(new ExitLevelController(this, game, level));
		btnExitLevel.setBounds(771, 50, 176, 36);
		panel.add(btnExitLevel);

		panelPuzzleStats = new JPanel();
		panelPuzzleStats.setLayout(null);
		panelPuzzleStats.setBorder(null);
		panelPuzzleStats.setBackground(Color.LIGHT_GRAY);
		panelPuzzleStats.setBounds(530, 52, 154, 34);
		panel.add(panelPuzzleStats);

		// TODO remove hard-coded vals!
		movesLabel = new JLabel("Moves: 40/50");
		movesLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		movesLabel.setBounds(6, 7, 136, 22);
		panelPuzzleStats.add(movesLabel);

		labelStars = new JLabel("0/3");
		labelStars.setBounds(689, 60, 82, 16);
		panel.add(labelStars);
		labelStars.setFont(new Font("PT Sans Caption", Font.BOLD, 14));

		panelReleaseStats = new JPanel();
		panelReleaseStats.setBounds(10, 48, 383, 38);
		panel.add(panelReleaseStats);
		panelReleaseStats.setLayout(null);
		panelReleaseStats.setBorder(null);
		panelReleaseStats.setBackground(Color.LIGHT_GRAY);

		JLabel reSquaresLabel = new JLabel("Red Squares:");
		reSquaresLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		reSquaresLabel.setBounds(0, 16, 82, 16);
		panelReleaseStats.add(reSquaresLabel);

		labelRed = new JLabel("0/6");
		labelRed.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		labelRed.setBounds(85, 16, 31, 16);
		panelReleaseStats.add(labelRed);

		JLabel greenSquaresLabel = new JLabel("Green Squares:");
		greenSquaresLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		greenSquaresLabel.setBounds(115, 16, 103, 16);
		panelReleaseStats.add(greenSquaresLabel);

		labelGreen = new JLabel("0/6");
		labelGreen.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		labelGreen.setBounds(218, 16, 31, 16);
		panelReleaseStats.add(labelGreen);

		JLabel yellowSquaresLabel = new JLabel("Yellow Squares:");
		yellowSquaresLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		yellowSquaresLabel.setBounds(249, 16, 103, 16);
		panelReleaseStats.add(yellowSquaresLabel);

		labelYellow = new JLabel("0/6");
		labelYellow.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		labelYellow.setBounds(356, 16, 31, 16);
		panelReleaseStats.add(labelYellow);

		panelLightningStats = new JPanel();
		panelLightningStats.setBounds(339, 52, 210, 34);
		panel.add(panelLightningStats);
		panelLightningStats.setLayout(null);
		panelLightningStats.setBorder(null);
		panelLightningStats.setBackground(Color.LIGHT_GRAY);

		timeLabel= new JLabel("Time Remaining: 1:30");
		timeLabel.setBounds(6, 6, 192, 20);
		panelLightningStats.add(timeLabel);
		timeLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
	}
	
	// TODO fix messy code!
	public void refresh() {
		if (level instanceof PuzzleLevel) {
			movesLabel.setText(((PuzzleLevel) level).getMovesLeft() + "/" + ((PuzzleLevel) level).getMaxMoves());
		} else if (level instanceof ReleaseLevel) {
			labelRed.setText(((ReleaseLevel) level).getRedCovered() + "/" + ReleaseLevel.MAX_NUM);
			labelGreen.setText(((ReleaseLevel) level).getGreenCovered() + "/" + ReleaseLevel.MAX_NUM);
			labelYellow.setText(((ReleaseLevel) level).getYellowCovered() + "/" + ReleaseLevel.MAX_NUM);
		}
		
		labelStars.setText(level.getNumStars() + "/" + Level.MAX_STARS);
		repaint();
	}
	
	public JLabel getMovesLabel() {
		return movesLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
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
	
	public BullpenView getBullpenView() {
		return bullpenView;
	}
	
	public BoardView getBoardView() {
		return boardView;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public JLabel getLevelLabel() {
		return levelLabel;
	}
}