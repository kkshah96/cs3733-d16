package model;

import java.awt.Color;

/**
 * Class allows for storage and manipulation of Release Square.
 * <p>
 * Allows for implementation of Release-level squares in Kabasuji.
 * Keeps track of its number and the number's color.
 * <p>
 * @author Maddy Longo
 * @author Kunal Shah
 */
public class ReleaseSquare extends Square {
	/** The number on this release square */
	int number;
	
	/** The color of the number on this release square*/
	Color numberColor;
	
	/** Status for if this square is a hint or not */
	boolean hint;
	
	/** 
	 * Creates a ReleaseSquare with the following parameters. <br />
	 * Sets number to 0, Color to null, and hint to false by default.
	 * 
	 * @param col The column of this ReleaseSquare on the board.
	 * @param row The row of this ReleaseSquare on the board.
	 * @param isValid The validity of this ReleaseSquare.
	 */
	public ReleaseSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
		number = 0;
		numberColor = null;
	}
	
	/**
	 * Creates a Release Square with the following parameters. <br />
	 * Sets hint to false by default.
	 * 
	 * @param col The column of this ReleaseSquare on the board.
	 * @param row The row of this ReleaseSquare on the board.
	 * @param isValid The validity of this ReleaseSquare.
	 * @param number The number on this ReleaseSquare.
	 * @param numberColor The color of the number on this ReleaseSquare.
	 */
	public ReleaseSquare(int col, int row, boolean isValid, int number, Color numberColor) {
		super(col, row, isValid);
		this.number = number;
		this.numberColor = numberColor;
	}
	
	/**
	 * Creates a LightningSquare with the following parameters
	 * (all parameters specified through this constructor).
	 * @param col The column of the square.
	 * @param row The row of the square.
	 * @param number The number on this square.
	 * @param numberColor The color of the number on this square.
	 * @param isValid If the square is valid.
	 * @param isHint If the square is to be highlighted as a hint.
	 */
	public ReleaseSquare(int col, int row, boolean isValid,
			int number, Color numberColor, boolean isHint) {
		super(col, row, isValid, isHint);
		this.number = number;
		this.numberColor = numberColor;
	}

	/**
	 * Returns a string representation of the Square type ("ReleaseSquare");
	 */
	public String getName() {
		return "ReleaseSquare";
	}
	
	/**
	 * Determines the number on this square.
	 * @return int representation of the number, which defaults to 0 if no number.
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * Determines the color of the number on this squares.
	 * @return AWT Color object, or null if no color.
	 */
	public Color getNumberColor() {
		return numberColor;
	}
	
	/**
	 * Updates the number on this square. Must be between 1 and 6, inclusive.
	 * Default of 0 will not be displayed
	 * @param num The new number to set on this square.
	 * @return True if the update was successful, false otherwise.
	 */
	public boolean setNumber(int num) {
		// Value of 0 indicates no number
		if (num < 0 || num > 6) {
			return false;
		} else {
			this.number = num;
			return true;
		}
	}
	
	/**
	 * Updates the color of the number on this square.
	 * @param color The new Color object to set.
	 * @return True if the update was successful.
	 */
	public boolean setNumberColor(Color color) {
		this.numberColor = color;
		return true;
	}
}