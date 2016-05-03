package controller;

import model.Level;
import model.Square;

public class ToggleSquareHintEdit extends Move{
	Square toggledSquare;
	Level level;
	int col;
	int row;

	
	//TODO: Still need to finish logic for undoing and redoing....
	public ToggleSquareHintEdit(Square toggledSquare, Level level, int col, int row){
		super();
		this.toggledSquare = toggledSquare;
		this.level = level;
		this.col = col;
		this.row = row;
	}
	@Override
	public boolean doMove() {
		boolean validation = false;
		if(isValid()){
			level.getBoard().toggleHint();
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean isValid() {
		boolean validation = false;
		if(level.getBoard().getActiveSquare() != null && level.getBoard().getActiveSquare().getCol() == col
				&& level.getBoard().getActiveSquare().getRow() == row){
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean undo() {
		level.getBoard().setActiveSquare(toggledSquare.getCol(), toggledSquare.getRow());
		System.out.println("Mean to toggle hint of: col " + toggledSquare.getCol() + " row " + toggledSquare.getRow());
		level.getBoard().toggleHint();
		System.out.println("Mean to toggle hint of: col " + level.getBoard().getActiveSquare().getCol() 
				+ " row " + level.getBoard().getActiveSquare().getRow());
		return true;
	}

}
