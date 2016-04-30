package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Level;
import model.PuzzleLevel;
import view.LevelEditorView;

/**
 * Controls setting the Max Moves in a Puzzle Level.
 * 
 * @author Alexander Kasparek
 * @author Maddy Longo
 * @author Connor Weeks
 */
public class SetMaxMovesController implements ActionListener {
	/** PuzzleLevel entity */
	PuzzleLevel level;
	
	/** View for the PuzzleLevel being edited */
	LevelEditorView editorView;
	
	/**
	 * Creates a new SetMaxMovesController with the following parameters
	 * @param level Reference to the level being edited
	 * @param editorView Reference to the view of the level being edited
	 */
	public SetMaxMovesController(Level level, LevelEditorView editorView) {
		this.level = (PuzzleLevel) level;
		this.editorView = editorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Get the value in the moves textbox
		int maxMoves = Integer.parseInt(editorView.getMaxMovesField().getText());
		
		// Ensure it is within bounds
		if (maxMoves <= 0 || maxMoves > 1024) {
			System.out.printf("Error: %d is an invalid number of moves\n", maxMoves);
		} else {
			// If so, update the value stored in the entity
			level.setMaxMoves(maxMoves);
		}
	}
}