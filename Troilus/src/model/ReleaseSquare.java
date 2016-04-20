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
	
	public ReleaseSquare(int number, Color color) {
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