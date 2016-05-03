package controller;

import model.Level;
import model.Square;


/**
 * Class for implementing toggling a hint in the level builder.
 * This move class stores the row and column of the square being
 * toggled, and may use this information to undo and redo actions.
 * 
 * @author Connor Weeks
 *
 */
public class ToggleHintMove extends Move {
	
	/** The square being toggled */
	Square toggledSquare;
	
	/** The level being edited */
	Level level;

	/**
	 * Constructor for ToggleHintMove.
	 * 
	 * @param toggledSquare The square being toggled.
	 * @param level The level currently being edited.
	 */
	public ToggleHintMove(Square toggledSquare, Level level){
		super();
		this.toggledSquare = toggledSquare;
		this.level = level;
	}
	
	/**
	 * Sets the active square to the square being toggled and toggle the hint for that square.
	 * 
	 * @return True if move is valid; false otherwise;
	 */
	@Override
	public boolean doMove() {
		boolean validation = false;

		// set active square 
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		
		if(isValid()){
			level.getBoard().toggleHint();
			validation = true;
		}
		return validation;
	}

	/**
	 * Returns true if the boards active square is not null and it is valid.
	 */
	@Override
	public boolean isValid() {
		return (level.getBoard().getActiveSquare() != null && level.getBoard().getActiveSquare().isValid());
	}

	/**
	 * Sets the active square to the square being toggled and performs the toggle operation again,
	 * returning the hint of that square to its initial state.
	 */
	@Override
	public boolean undo() {
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		level.getBoard().toggleHint();
		return true;
	}

}
