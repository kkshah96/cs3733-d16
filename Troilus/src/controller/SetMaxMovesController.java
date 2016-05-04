package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Level;
import model.LevelBuilder;
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
	
	/** The level builder instance containing the level*/
	LevelBuilder builder;
	
	/** View for the PuzzleLevel being edited */
	LevelEditorView editorView;
	
	/**
	 * Creates a new SetMaxMovesController with the following parameters
	 * @param level Reference to the level being edited
	 * @param builder Reference to the builder being used
	 * @param editorView Reference to the view of the level being edited
	 */
	public SetMaxMovesController(Level level, LevelBuilder builder, LevelEditorView editorView) {
		this.level = (PuzzleLevel) level;
		this.builder = builder;
		this.editorView = editorView;
	}
	
	/** Handles the ActionEvent that sets the max moves for a puzzle level.
	 * @param ae the ActionEvent.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Move m = new SetMaxMovesMove(level, editorView);
		
		if(m.doMove()) {
			builder.pushMove(m, false);	
		}
	}
}