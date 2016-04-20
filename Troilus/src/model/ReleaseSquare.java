package model;

import java.awt.Color;

/**
 * Class allows for storage and manipulation of Release Square.
 * 
 * Allows for implementation of Release-level squares in Kabasuji.
 * Keeps track of its number and the number's color.
 * 
 * @author Maddy
 *
 */
public class ReleaseSquare extends Square {
	int number;
	Color numberColor;
	
	public ReleaseSquare(int row, int col, boolean isValid, int number, Color color) {
		super(row, col, isValid);
		this.number = number;
		this.numberColor = color;
	}

	@Override
	public String getType() {
		return "ReleaseSquare";
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getNumberColor() {
		return numberColor.toString();
	}
}