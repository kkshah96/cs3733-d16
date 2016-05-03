package controller;

import java.awt.Color;

import model.Level;
import model.ReleaseSquare;

public class SetSquareNumberColorMove extends Move{
	
	ReleaseSquare setSquare;
	Level level;
	int num;
	Color c;
	Color previousColor;

	public SetSquareNumberColorMove(ReleaseSquare setSquare, Level level, Color c){
		this.level = level;
		this.setSquare = setSquare;
		this.c = c;
		previousColor = setSquare.getNumberColor();
		
	}
	
	@Override
	public boolean doMove() {
		if(isValid()){
			setSquare.setNumberColor(c);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		boolean validation = false;
		if(setSquare.isValid()){
			validation = true;
		}
		return validation;
	}

	@Override
	public boolean undo() {
		if(setSquare.isValid()){
			setSquare.setNumberColor(previousColor);
			return true;
		}
		return false;
	}

}
