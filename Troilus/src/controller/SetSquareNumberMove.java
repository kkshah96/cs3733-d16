package controller;

import model.Level;
import model.ReleaseSquare;

public class SetSquareNumberMove extends Move{
	
	ReleaseSquare setSquare;
	Level level;
	int num;
	int previousNum;

	public SetSquareNumberMove(ReleaseSquare setSquare, Level level, int num){
		this.level = level;
		this.setSquare = setSquare;
		this.num = num;
		previousNum = setSquare.getNumber();
		
	}
	
	@Override
	public boolean doMove() {
		if(isValid()){
			setSquare.setNumber(num);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		boolean validation = false;
		if(!(num < 0 || num > 6) && setSquare.isValid()){
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean undo() {
		if(setSquare.isValid()){
			setSquare.setNumber(previousNum);
			return true;
		}
		return false;
	}

}
