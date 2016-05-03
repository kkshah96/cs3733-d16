package controller;

import model.Level;
import model.Square;

/**
 * 
 * @author Connor Weeks
 *
 */
public class ToggleSquareMove extends Move {

	Square toggledSquare;
	Level level;
	Square activeSquare;

	int col;
	int row;
	
	boolean wasHint;

	//TODO: Still need to finish logic for undoing and redoing....
	public ToggleSquareMove(Square toggledSquare, Level level){
		super();
		this.toggledSquare = toggledSquare;
		this.level = level;
		this.activeSquare = level.getBoard().getActiveSquare();
	}
	
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

	@Override
	public boolean isValid() {
		boolean validation = false;
		if(level.getBoard().getActiveSquare() != null 
				&& level.getBoard().getPiece(level.getBoard().getActiveSquare().getCol(), level.getBoard().getActiveSquare().getRow()) == null){
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean undo() {
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		level.getBoard().toggleActiveSquare();
		level.getBoard().getActiveSquare().setIsHint(wasHint);
		return true;
	}

}

