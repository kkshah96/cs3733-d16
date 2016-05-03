package controller;

import model.Level;
import model.Square;

/**
 * Move Class for handling the toggling of the board's active square on or off.<p>
 * @author Connor Weeks
 *
 */
public class ToggleSquareMove extends Move {

	/**The square being toggled**/
	Square toggledSquare;
	
	/**The current level**/
	Level level;
	
	/**The active square**/
	Square activeSquare;
	
	
	/**The previous hint status for the active square**/
	boolean wasHint;

	/**
	 * Constructs a ToggleSquareMove with the given parameters.<p>
	 * @param toggledSquare The Square being toggled.
	 * @param level The current level.
	 */
	public ToggleSquareMove(Square toggledSquare, Level level){
		super();
		this.toggledSquare = toggledSquare;
		this.level = level;
		this.activeSquare = level.getBoard().getActiveSquare();
	}
	

	/**
	 * Turns this square on or off, depending on its previous status.<p>
	 * @return true If this move is valid and done successfully. 
	 */
	@Override
	public boolean doMove() {
		boolean validation = false;
		
		// set active square 
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		
		wasHint = level.getBoard().getActiveSquare().isHint();
		
		if(isValid()){
			level.getBoard().toggleActiveSquare();
			level.getBoard().getActiveSquare().setIsHint(false);
			validation = true;
		}
		return validation;
	}

	
	/**
	 * Determines if this ToggleSquareMove is valid.
	 * @return true If there is an activeSquare set on the board, and there is no piece on top of this square.
	 */
	@Override
	public boolean isValid() {
		boolean validation = false;
		if(level.getBoard().getActiveSquare() != null 
				&& level.getBoard().getPiece(level.getBoard().getActiveSquare().getCol(), level.getBoard().getActiveSquare().getRow()) == null){
			validation = true;
		}
		return validation;
	}

	/**
	 * Determines if this ToggleSquareMove can be undone.
	 * @return true If this ToggleSquareMove was successfully undone. 
	 */
	@Override
	public boolean undo() {
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		level.getBoard().toggleActiveSquare();
		level.getBoard().getActiveSquare().setIsHint(wasHint);
		return true;
	}

}

