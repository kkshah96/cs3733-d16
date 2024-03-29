package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.ReleaseLevel;
import model.ReleaseSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the creation of a new release level in the level builder.
 * Upon the designer requesting to create a new release level, this
 * controller creates the new level, adds it to the level builder's list 
 * of levels, and shows the level editor screen for the newly created level.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
 */
public class NewReleaseLevelController implements ActionListener {
	/** The builder entity */
	LevelBuilder builder;
	
	/** The top level GUI for the builder */
	LevelLoaderView levelLoader;

	/**
	 * Creates a new instance of NewReleaseLevelController with the following parameters
	 * @param builder Reference to the builder entity used here
	 * @param levelLoader Reference to the top level GUI for the builder
	 */
	public NewReleaseLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Create a new Bullpen, Palette and Board for the Level
		Bullpen bpen = new Bullpen();
		
		// Initialize 2D array of squares for board
		Square[][] squares = new ReleaseSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for(int i = 0; i < Board.BOARD_WIDTH; i++){
			for(int j = 0; j < Board.BOARD_HEIGHT; j++){
				squares[i][j] = new ReleaseSquare(i, j, true);
			}
		}

		// Create board, palette, and level, and add level to builder entity
		Board board = new Board(squares);
		Palette p = Palette.getInstance();
		ReleaseLevel newReleaseLevel = new ReleaseLevel(builder.getLevels().size() + 1, true, bpen, board, p);
		builder.addLevel(newReleaseLevel);

		final LevelEditorView newEditorView = new LevelEditorView(builder, levelLoader, newReleaseLevel);

		// Add controller to handle window close
		newEditorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newEditorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, newEditorView, levelLoader).process();
			}      
		});

		//Show/hide specific elements to only show things relevant to release levels
		newEditorView.setLevelType("Release");
		newEditorView.setMaxMovesPanelVisibility(false);
		newEditorView.setReleaseSquarePanelVisibility(true);
		newEditorView.setTimeLimitPanelVisibility(false);

		// add listeners to handle input
		newEditorView.getNumberColorComboBox().addActionListener(new SetSquareNumberColorController(newReleaseLevel, newEditorView, builder));
		newEditorView.getNumberComboBox().addActionListener(new SetSquareNumberController(newReleaseLevel, newEditorView, builder));

		// Finalize visibility
		levelLoader.setVisible(false);
		newEditorView.setVisible(true);
	}
}