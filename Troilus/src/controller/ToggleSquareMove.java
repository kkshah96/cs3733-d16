package controller;

import model.Level;
import model.Square;

/**
 * Move Class for handling the toggling of the board's active square on or off.<p>
 * @author Connor Weeks
 * @author Maddy Longo
 */
public class ToggleSquareMove extends Move {
	/**The square being toggled (which is the board's active square). */
	Square toggledSquare;
	
	/**The current level. */
	Level level;
	
	/**The previous hint status for the active square. */
	boolean wasHint;

	/**
	 * Constructs a ToggleSquareMove with the given parameters.<p>
	 * @param toggledSquare The Square being toggled.
	 * @param level The current level.
	 */
	public ToggleSquareMove(Square toggledSquare, Level level) {
		super();
		this.toggledSquare = level.getBoard().getActiveSquare();
		this.level = level;
	}

	/**
	 * Turns this square on or off, depending on its previous status.<p>
	 * @return true If this move is valid and done successfully. 
	 */
	@Override
	public boolean doMove() {
		// set active square 
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		
		wasHint = level.getBoard().getActiveSquare().isHint();
		
		if(isValid()){
			level.getBoard().toggleActiveSquare();
			level.getBoard().getActiveSquare().setIsHint(false);
			return true;
		}
		return false;
	}

	
	/**
	 * Determines if this ToggleSquareMove is valid.
	 * @return true If there is an activeSquare set on the board, and there is no piece on top of this square.
	 */
	@Override
	public boolean isValid() {
		int col = level.getBoard().getActiveSquare().getCol();
		int row = level.getBoard().getActiveSquare().getRow();
		
		// Check if there is an active square and no piece is on it.
		if (level.getBoard().getActiveSquare() != null 
				&& level.getBoard().getPiece(col, row) == null) {
			return true;
		}
		
		return false;
	}

	/**
	 * Determines if this ToggleSquareMove can be undone, and undoes it if true.
	 * @return true If this ToggleSquareMove was successfully undone. 
	 */
	@Override
	public boolean undo() {
		// TODO is this ever false?
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		level.getBoard().toggleActiveSquare();
		level.getBoard().getActiveSquare().setIsHint(wasHint);
		return true;
	}
}