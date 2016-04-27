package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.BoardController;
import controller.BullpenController;
import controller.ExitLevelEditorController;
import controller.FlipPieceController;
import controller.MovePieceBoardToBullpenController;
import controller.MovePieceBullpenToBoardController;
import controller.MovePiecePaletteToBullpenController;
import controller.RotatePieceController;
import controller.SaveLevelController;
import controller.SelectPieceBullpenController;
import controller.SelectSquareController;
import controller.SetBoardDimensionsController;
import controller.SetMaxMovesController;
import controller.SetSquareNumberColorController;
import controller.SetSquareNumberController;
import controller.SetTimeLimitController;
import controller.ToggleSquareController;
import model.Level;
import model.LevelBuilder;
import model.Piece;

/**
 * GUI for editing Kabausji levels in the LevelBuilder application.
 * 
 * The LevelEditorView displays a BoardView, BullpenView and PaletteView
 * as well as necessary buttons, labels and text fields for editing any type of Kabasuji Level.
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 * @author Maddy Longo
 *
 */
public class LevelEditorView extends JFrame {
	private JTextField boardRowField;
	private JTextField boardColField;
	private JTextField maxMovesField;
	private JTextField timeMinutesField;
	private JTextField timeSecondsField;
	JLabel levelTypeLabel;
	JPanel maxMovesPanel;
	JPanel releaseSquareOptionsPanel;
	JPanel timePanel;

	LevelLoaderView levelLoader;
	LevelBuilder builder;
	Level activeLevel;
	BoardView boardView;
	PaletteView paletteView;
	JPanel bullpenContainer;
	BullpenView bullpenView;

	// TODO parameterize raw type
	JComboBox releaseNumberComboBox;
	JComboBox releaseColorComboBox;

	/**
	 * Create the application.
	 */
	public LevelEditorView (LevelBuilder builder, LevelLoaderView levelLoader, Level activeLevel) {
		setResizable(false);
		this.builder = builder;
		this.levelLoader = levelLoader;
		this.activeLevel = activeLevel;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		boardView = new BoardView(activeLevel);
		boardView.setLayout(null);
		boardView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		boardView.setBackground(Color.LIGHT_GRAY);
		boardView.setBounds(0, 114, 747, 408);
		getContentPane().add(boardView);
		
		//OLD STUFF:
//		boardView.addMouseListener(new MovePieceBoardToBullpenController(activeLevel, boardView));
//		boardView.addMouseMotionListener(new MovePieceBullpenToBoardController(activeLevel, boardView, bullpenView));
//		boardView.addMouseListener(new MovePieceBullpenToBoardController(activeLevel, boardView, bullpenView));

		
		//NEW STUFF:
		boardView.addMouseListener(new BoardController(activeLevel, boardView, this));
		boardView.addMouseMotionListener(new BoardController(activeLevel, boardView, this));
		boardView.addMouseListener(new SelectSquareController(activeLevel, boardView));
		
		bullpenContainer = new JPanel(); //BullpenView(activeLevel.getBullpen());
		bullpenContainer.setLayout(null);
		bullpenContainer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bullpenContainer.setBackground(Color.LIGHT_GRAY);
		bullpenContainer.setBounds(748, 38, 457, 484);
		getContentPane().add(bullpenContainer);

		JPanel bullPenOptionsPanel = new JPanel();
		bullPenOptionsPanel.setLayout(null);
		bullPenOptionsPanel.setBackground(Color.LIGHT_GRAY);
		bullPenOptionsPanel.setBounds(6, 6, 446, 33);
		bullpenContainer.add(bullPenOptionsPanel);

		JLabel bullpenLabel = new JLabel("Bullpen");
		bullpenLabel.setForeground(Color.BLACK);
		bullpenLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		bullpenLabel.setBounds(6, 6, 80, 23);
		bullPenOptionsPanel.add(bullpenLabel);

		// create actual bullpen view and add it to the scroll pane

		JScrollPane bullpenScrollPane = new JScrollPane();
		bullpenView = new BullpenView(activeLevel, bullpenScrollPane);
		bullpenView.setLayout(null);
		bullpenView.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		bullpenView.setBackground(Color.LIGHT_GRAY);
		bullpenView.setBounds(748, 38, 457, 484);
		
		//NEW STUFF:
		bullpenView.addMouseListener(new BullpenController(activeLevel, bullpenView));
		
		//OLD STUFF:
//		bullpenView.addMouseMotionListener(new MovePieceBullpenToBoardController(activeLevel, 
//				 boardView,  bullpenView));
//		bullpenView.addMouseListener(new SelectPieceBullpenController(activeLevel, bullpenView));
		
		
		bullpenScrollPane.setBounds(6, 50, 446, 423);
		bullpenScrollPane.setViewportView(bullpenView);
		getContentPane().add(bullpenScrollPane, BorderLayout.CENTER);
		//bullpenContainer.add(bullpenScrollPane);
		bullpenContainer.add(bullpenScrollPane);

		JButton rotateCWButton = new JButton("Rotate CW");
		rotateCWButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		rotateCWButton.setBounds(76, 4, 87, 29);
		rotateCWButton.addActionListener(new RotatePieceController(activeLevel, bullpenView, Piece.ROTATE_CW));
		bullPenOptionsPanel.add(rotateCWButton);

		JButton rotateCCWButton = new JButton("Rotate CCW");
		rotateCCWButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		rotateCCWButton.setBounds(158, 4, 87, 29);
		rotateCCWButton.addActionListener(new RotatePieceController(activeLevel, bullpenView, Piece.ROTATE_CCW));
		bullPenOptionsPanel.add(rotateCCWButton);

		JButton flipHorizontalButton = new JButton("Flip Horizontal");
		flipHorizontalButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		flipHorizontalButton.setBounds(237, 4, 105, 29);
		flipHorizontalButton.addActionListener(new FlipPieceController(activeLevel, bullpenView, Piece.FLIP_HORIZONTALLY));
		bullPenOptionsPanel.add(flipHorizontalButton);

		JButton flipVerticalButton = new JButton("Flip Vertical");
		flipVerticalButton.setBounds(335, 4, 105, 29);
		flipVerticalButton.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		flipVerticalButton.addActionListener(new FlipPieceController(activeLevel, bullpenView, Piece.FLIP_VERTICALLY));
		bullPenOptionsPanel.add(flipVerticalButton);

		//		JPanel panel_2 = new BullpenView(activeLevel.getBullpen());
		//		bullpenScrollPane.setViewportView(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 0, 1205, 38);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		saveButton.setBounds(0, 0, 102, 38);
		saveButton.addActionListener(new SaveLevelController(builder));
		panel_4.add(saveButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(256, 0, 149, 38);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		levelTypeLabel = new JLabel("Puzzle");
		levelTypeLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		levelTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelTypeLabel.setBounds(6, 6, 124, 26);
		panel_5.add(levelTypeLabel);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(404, 0, 351, 38);
		panel_4.add(panel_6);
		panel_6.setLayout(null);

		JButton levelLoaderButton = new JButton("Level Loader");
		levelLoaderButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		levelLoaderButton.setBounds(871, 0, 199, 38);
		levelLoaderButton.addActionListener(new ExitLevelEditorController(builder, this, levelLoader));
		panel_4.add(levelLoaderButton);

		JButton undoButton = new JButton("Undo");
		undoButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		undoButton.setBounds(102, 0, 74, 38);
		panel_4.add(undoButton);

		JButton redoButton = new JButton("Redo");
		redoButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		redoButton.setBounds(176, 0, 74, 38);
		panel_4.add(redoButton);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 37, 747, 40);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);

		JLabel boardField = new JLabel("Board:");
		boardField.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		boardField.setHorizontalAlignment(SwingConstants.CENTER);
		boardField.setBounds(0, 0, 74, 32);
		panel_7.add(boardField);

		boardRowField = new JTextField("12");
		boardRowField.setBounds(70, 1, 50, 28);
		panel_7.add(boardRowField);
		boardRowField.setColumns(10);

		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBackground(Color.LIGHT_GRAY);
		lblX.setBounds(120, 10, 25, 13);
		panel_7.add(lblX);

		boardColField = new JTextField("12");
		boardColField.setColumns(10);
		boardColField.setBounds(148, 1, 50, 28);
		panel_7.add(boardColField);

		JButton setButton = new JButton("Set");
		setButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		setButton.setBounds(209, -2, 74, 38);
		panel_7.add(setButton);

		////TODO: This still doesn't exactly work....
		//		setButton.addMouseListener(new SetBoardDimensionsController
		//				(builder, builder.getActiveLevel(), levelLoader, Integer.parseInt(boardHeightField.getText()), Integer.parseInt(boardWidthField.getText())));

		setButton.addActionListener(new SetBoardDimensionsController(activeLevel, this));

		maxMovesPanel = new JPanel();
		maxMovesPanel.setBounds(286, 0, 184, 40);
		panel_7.add(maxMovesPanel);
		maxMovesPanel.setLayout(null);
		maxMovesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		maxMovesPanel.setBackground(Color.LIGHT_GRAY);

		JLabel lblMaximumMoves = new JLabel("Maximum Moves:");
		lblMaximumMoves.setBounds(0, 0, 99, 32);
		maxMovesPanel.add(lblMaximumMoves);
		lblMaximumMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximumMoves.setFont(new Font("PT Sans Caption", Font.BOLD, 11));

		maxMovesField = new JTextField("0");
		maxMovesField.setBounds(101, 4, 74, 28);
		maxMovesPanel.add(maxMovesField);
		maxMovesField.setColumns(10);

		timePanel = new JPanel();
		timePanel.setBounds(468, 0, 279, 38);
		panel_7.add(timePanel);
		timePanel.setLayout(null);
		timePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		timePanel.setBackground(Color.LIGHT_GRAY);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("PT Sans Caption", Font.BOLD, 11));
		lblTime.setBounds(0, 1, 42, 32);
		timePanel.add(lblTime);

		timeMinutesField = new JTextField("0");
		timeMinutesField.setColumns(10);
		timeMinutesField.setBounds(42, 5, 35, 28);
		timePanel.add(timeMinutesField);

		JLabel lblMinutes = new JLabel("minutes");
		lblMinutes.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblMinutes.setBounds(76, 13, 49, 13);
		timePanel.add(lblMinutes);

		timeSecondsField = new JTextField("00");
		timeSecondsField.setColumns(10);
		timeSecondsField.setBounds(120, 4, 35, 28);
		timePanel.add(timeSecondsField);

		JLabel lblSeconds = new JLabel("seconds");
		lblSeconds.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblSeconds.setBounds(156, 10, 48, 16);
		timePanel.add(lblSeconds);

		JButton btnSetTime = new JButton("Set Time");
		btnSetTime.setBounds(209, -1, 64, 38);
		timePanel.add(btnSetTime);
		btnSetTime.setFont(new Font("PT Sans Caption", Font.BOLD, 11));
		

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 76, 747, 38);
		getContentPane().add(panel_1);

		JButton ToggleButton = new JButton("Toggle");
		ToggleButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		ToggleButton.setBounds(437, 0, 115, 38);
		panel_1.add(ToggleButton);

		ToggleButton.addActionListener(new ToggleSquareController(activeLevel, boardView));

		JButton btnToggleHint = new JButton("Hint");
		btnToggleHint.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnToggleHint.setBounds(564, 0, 91, 38);
		panel_1.add(btnToggleHint);

		JLabel lblSquare = new JLabel("Square:");
		lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquare.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblSquare.setBounds(0, 2, 70, 32);
		panel_1.add(lblSquare);

		releaseSquareOptionsPanel = new JPanel();
		releaseSquareOptionsPanel.setBounds(84, 0, 341, 40);
		panel_1.add(releaseSquareOptionsPanel);
		releaseSquareOptionsPanel.setLayout(null);
		releaseSquareOptionsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		releaseSquareOptionsPanel.setBackground(Color.LIGHT_GRAY);

		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setBounds(6, 11, 61, 16);
		releaseSquareOptionsPanel.add(lblNumber);
		lblNumber.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));

		releaseNumberComboBox = new JComboBox<String>();
		releaseNumberComboBox.setBounds(66, 5, 85, 27);
		releaseSquareOptionsPanel.add(releaseNumberComboBox);
		releaseNumberComboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6"}));
		releaseNumberComboBox.addActionListener(new SetSquareNumberController(activeLevel, this));

		JLabel lblNumberColor = new JLabel("Number Color:");
		lblNumberColor.setBounds(150, 11, 97, 16);
		releaseSquareOptionsPanel.add(lblNumberColor);
		lblNumberColor.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));

		releaseColorComboBox = new JComboBox<String>();
		releaseColorComboBox.setBounds(250, 5, 85, 27);
		releaseSquareOptionsPanel.add(releaseColorComboBox);
		releaseColorComboBox.setModel(new DefaultComboBoxModel(new String[] {"Red", "Green", "Yellow"}));
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 1207, 751);
		//pView.setPreferredSize(new Dimension(500, 500));
		//pView.setLayout(null);
		releaseColorComboBox.addActionListener(new SetSquareNumberColorController(activeLevel, this));

		//releaseColorComboBox.getSelectedItem().toString() //TODO: This is how to get the selected option
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 522, 1205, 201);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		paletteView = new PaletteView(activeLevel);
		paletteView.setPreferredSize(new Dimension(2100, 100));
		scrollPane.setViewportView(paletteView);
		paletteView.addMouseListener(new MovePiecePaletteToBullpenController(activeLevel, bullpenView, paletteView));
		if (activeLevel.getName().equals("Lightning")) {
			btnSetTime.addActionListener(new SetTimeLimitController(activeLevel, this));
		}

	}

	public void setLevelType(String type){
		levelTypeLabel.setText(type);
		//this.initialize();
	}

	public void setMaxMovesPanelVisibility(boolean which){
		maxMovesPanel.setVisible(which);
	}

	public void setReleaseSquarePanelVisibility(boolean which){
		releaseSquareOptionsPanel.setVisible(which);

	}
	public void setTimeLimitPanelVisibility(boolean which){
		timePanel.setVisible(which);
	}

	public JTextField getRowField(){
		return boardRowField;
	}

	public JTextField getColField(){
		return boardColField;
	}

	public JTextField getMinutesField(){
		return timeMinutesField;
	}
	public JTextField getSecondsField(){
		return timeSecondsField;

	}

	public PaletteView getPaletteView() {
		return paletteView;
	}

	public BoardView getBoardView(){
		return boardView;
	}

	public BullpenView getBullpenView() {
		return bullpenView;
	}

	public void setBoardView(BoardView boardView) {
		this.boardView = boardView;
	}

	public JTextField getMaxMovesField() {
		return maxMovesField;
	}

	public JComboBox getNumberComboBox() {
		return releaseNumberComboBox;
	}

	public JComboBox getNumberColorComboBox() {
		return releaseColorComboBox;
	}
}