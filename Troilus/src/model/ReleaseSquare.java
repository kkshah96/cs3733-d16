package model;

import java.awt.Color;

/**
 * Class allows for storage and manipulation of Release Square.
 * <p>
 * Allows for implementation of Release-level squares in Kabasuji.
 * Keeps track of its number and the number's color.
 * <p>
 * @author Maddy
 * @author Kunal Shah
 */
public class ReleaseSquare extends Square {
	int number;
	Color numberColor;
	
	/** 
	 * Creates a ReleaseSquare with the following parameters.
	 * @param col
	 * @param row
	 * @param isValid
	 * @param a
	 */
	public ReleaseSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
		number = 0;
		numberColor = null;
		
	}
	
	/**
	 * Creates a Release Square with the following parameters.
	 * @param row
	 * @param col
	 * @param isValid
	 * @param number
	 * @param numberColor
	 */
	public ReleaseSquare(int col, int row, boolean isValid, int number, Color numberColor) {
		super(col, row, isValid);
		this.number = number;
		this.numberColor = numberColor;
	}

	@Override
	public String getType() {
		return "ReleaseSquare";
	}
	
	public int getNumber() {
		return number;
	}
	
	public Color getNumberColor() {
		return numberColor;
	}
	
	public boolean setNumber(int num) {
		// Value of 0 indicates no number
		if (num < 0 || num > 6) {
			return false;
		} else {
			this.number = num;
			return true;
		}
	}
	
	public boolean setNumberColor(Color color){
		this.numberColor = color;
		return true;
	}
}