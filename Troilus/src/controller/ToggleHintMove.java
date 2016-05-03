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
	/** The square being toggled. */
	Square toggledSquare;
	
	/** The level being edited. */
	Level level;

	/**
	 * Constructor for ToggleHintMove.
	 * 
	 * @param level The level currently being edited.
	 */
	public ToggleHintMove(Level level) {
		super();
		this.toggledSquare = level.getBoard().getActiveSquare();
		this.level = level;
	}
	
	/**
	 * Toggles the hint for the current active square.
	 * 
	 * @return True if move is valid; false otherwise.
	 */
	@Override
	public boolean doMove() {
		// TODO used to change active square: Check that this is still valid
		if (isValid()) {
			level.getBoard().toggleHint();
			return true;
		}
		return false;
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