package controller;

import model.Level;
import model.Square;

public class ToggleSquareHintMove extends Move{
	Square toggledSquare;
	Level level;
	Square activeSquare;
	
	int col;
	int row;
	
	//TODO: Still need to finish logic for undoing and redoing....
	public ToggleSquareHintMove(Square toggledSquare, Level level){
		super();
		this.toggledSquare = toggledSquare;
		this.level = level;
		this.activeSquare = level.getBoard().getActiveSquare();
	}
	@Override
	public boolean doMove() {
		boolean validation = false;
		
		
		if(isValid()){
			// set active square 
			level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
			
			level.getBoard().toggleHint();
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean isValid() {
		boolean validation = false;
		if(level.getBoard().getActiveSquare() != null && level.getBoard().getActiveSquare().isValid()){
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean undo() {
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		level.getBoard().toggleHint();
		return true;
	}

}
