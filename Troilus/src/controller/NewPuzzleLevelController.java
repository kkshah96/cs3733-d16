package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * Controls the creation of a new puzzle level in the level builder.
 * Upon the designer requesting to create a new puzzle level, this
 * controller creates the new level, adds it to the level builder's list 
 * of levels, and shows the level editor screen for the newly created level.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
 */
public class NewPuzzleLevelController implements ActionListener {
	/** The builder entity */
	LevelBuilder builder;
	
	/** The top level GUI for the builder */
	LevelLoaderView loaderView;

	/**
	 * Creates a new instance of NewPuzzleLevelController with the following parameters
	 * @param builder Reference to the builder entity used
	 * @param loaderView Reference to the top leve GUI for the builder used
	 */
	public NewPuzzleLevelController(LevelBuilder builder, LevelLoaderView loaderView) {
		this.builder = builder;
		this.loaderView = loaderView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Create a new Bullpen, Palette and Board for the Level
		Bullpen bpen = new Bullpen();
		
		// Initialize 2D array of squares for the board
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for(int i = 0; i < Board.BOARD_WIDTH; i++){
			for(int j = 0; j < Board.BOARD_HEIGHT; j++){
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		// Create board and palette, and add parameters to new level
		Board board = new Board(squares);
		Palette p = new Palette();
		PuzzleLevel newPuzzleLevel = new PuzzleLevel(builder.getLevels().size() + 1, true, bpen, board, p, 0);
		builder.addLevel(newPuzzleLevel);
		
		// Add controller to handle window close
		final LevelEditorView newEditorView = new LevelEditorView(builder, loaderView, newPuzzleLevel);
		newEditorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newEditorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, newEditorView, loaderView).process();
			}      
		});
		
		// Update view for the Puzzle level
		newEditorView.setMaxMovesPanelVisibility(true);
		newEditorView.setReleaseSquarePanelVisibility(false);
		newEditorView.setTimeLimitPanelVisibility(false);
		
		// set listener
		newEditorView.getMaxMovesField().addActionListener(new SetMaxMovesController(newPuzzleLevel, newEditorView));

		// Finalize visiblity
		loaderView.setVisible(false);
		newEditorView.setVisible(true);
	}	
}