package controller;

import model.PuzzleLevel;
import view.LevelEditorView;

/** 
 * This Move class handles setting the max moves for a PuzzleLevel. <p>
 * @author Connor Weeks
 *
 */
public class SetMaxMovesMove extends Move {
	
	int numMoves;
	int previousNumMoves;
	
	/** PuzzleLevel entity */
	PuzzleLevel level;
	
	/** View for the PuzzleLevel being edited */
	LevelEditorView editorView;
	
	public SetMaxMovesMove(PuzzleLevel level, LevelEditorView editorView) {
		// set value
		this.level = level;
		this.editorView = editorView;
		try {
			// if some error occurs
			this.numMoves = Integer.parseInt(editorView.getMaxMovesField().getText());
		}
		catch (Exception e) {
			// set to invalid amount
			this.numMoves = -1;
		}
		this.previousNumMoves = level.getMaxMoves();
	}

	
	/**
	 * Sets the max moves for this PuzzleLevel if numMoves is valid. 
	 * 
	 * @return true if the move was valid, false otherwise.
	 */
	@Override
	public boolean doMove() {
		boolean validation = false;
		if (isValid()) {
			level.setMaxMoves(numMoves);
			editorView.getMaxMovesField().setText(Integer.toString(numMoves));
			validation = true;
		}
		else {
			// reset text field to previous value
			editorView.getMaxMovesField().setText(Integer.toString(previousNumMoves));
			validation = false;
		}
		
		return validation;
	}

	/**
	 * Determines if the requested maxMoves field of this PuzzleLevel is a valid number.
	 * @return true if the numMoves is valid, false if it is not 
	 */
	@Override
	public boolean isValid() {
		// make sure number of moves is in bounds
		return (numMoves > 0) && (numMoves < 1024);
	}

	
	/**
	 * Logic for undoing setting the maxMoves for this PuzzleLevel.
	 * @return true if this move was undone successfully, false otherwise.
	 */
	@Override
	public boolean undo() {
		level.setMaxMoves(previousNumMoves);
		editorView.getMaxMovesField().setText(Integer.toString(previousNumMoves));
		return true;
	}

}
