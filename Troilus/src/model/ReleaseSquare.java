package model;

import java.awt.Color;

public class ReleaseSquare extends Square {

	int number;
	Color numberColor;
	
	public ReleaseSquare(int row, int col){//, boolean hintSquare) {
		super(row, col);//, hintSquare);
	}

	// TODO: Can a ReleaseSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

}
