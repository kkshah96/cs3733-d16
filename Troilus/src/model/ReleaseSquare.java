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
	boolean hint;
	
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
	
	/**
	 * Creates a LightningSquare with the following parameters.
	 * @param col The column of the square
	 * @param row The row of the square
	 * @param isValid If the square is valid
	 * @param isHint If the square is to be highlighted as a hint
	 */
	public ReleaseSquare(int col, int row, boolean isValid, int number, Color numberColor, boolean isHint) {
		super(col, row, isValid, isHint);
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
	
	public boolean getHintStatus(){
		return false;
	}
	
	public void setHint(){
		return;
	}
	
	
}