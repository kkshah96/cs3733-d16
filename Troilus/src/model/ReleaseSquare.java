package model;

import java.awt.Color;

public class ReleaseSquare extends Square {

	int number;
	Color numberColor;
	
	public ReleaseSquare(int row, int col, int number, Color color){//, boolean hintSquare) {
		super(row, col);//, hintSquare);
		this.number = number;
		this.numberColor = color;
	}

	// TODO: Can a ReleaseSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "ReleaseSquare";
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getNumberColor() {
		return numberColor.toString();
	}

}
