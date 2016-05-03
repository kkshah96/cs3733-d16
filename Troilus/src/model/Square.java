package model;

/**
 * Class allows for consistent manipulation of square structure.
 * 
 * Allows for implementation of squares for Kabasuji. Squares can be
 * valid or invalid and have a type.
 * 
 * @author Maddy Longo
 * @author Kunal Shah
 * @author Connor Weeks
 * @author Alex Kasparek
 *
 */
public abstract class Square {
	/** The row of this square on the board. */
	int row;
	
	/** The column of this square on the board */
	int col;
	
	/** The status for if this square is valid. */
	boolean isValid;
	
	/** The status for if this square is part of a hint, */
	boolean isHint;
	
	/**
	 * Constructor called by a child class to store the following state (hint is false by default):
	 * @param col The column of this square.
	 * @param row The row of this square.
	 * @param isValid If this square is valid.
	 */
	public Square(int col, int row, boolean isValid) {
		this.row = row;
		this.col = col;
		this.isValid = isValid;
		isHint = false;
	}
	
	/**
	 * Constructor called by a child class to store the following state (hint is specified as a parameter):
	 * @param col The column of this square.
	 * @param row The row of this square.
	 * @param isValid If this square is valid.
	 * @param isHint If this square is part of a hint.
	 */
	public Square(int col, int row, boolean isValid, boolean isHint) {
		this.row = row;
		this.col = col;
		this.isValid = isValid;
		this.isHint = isHint;
	}
	
	/**
	 * Determines if this square is valid.
	 * @return True if this square is valid, false if not.
	 */
	public boolean isValid() {
		return this.isValid;
	}
	
	/**
	 * Returns a string representation of the type, or name of this square.
	 */
	public abstract String getName();
	
	/**
	 * Determines the row of this square.
	 * @return int representation of this square's row.
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Determines the column of this square.
	 * @return int representation of this square's column.
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * Updates the valid of this square
	 * @param isValid New value for the validity of this square
	 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/**
	 * Toggles the validity of this square.
	 */
	public void toggleIsValid() {
		isValid = !isValid;
	}
	
	/**
	 * Toggles the hintedness (hint status) of this square.
	 */
	public void toggleHint() {
		isHint = !isHint;
	}
	
	/**
	 * Returns whether or not the given square is a hint.
	 * @return True if this is a hint square, false if not.
	 */
	public boolean isHint() {
		return this.isHint;
	}

	/**
	 * Updates the hint status of this squares.
	 * @param isHint Boolean for new hint status (true if hint, false otherwise).
	 */
	public void setIsHint(boolean isHint) {
		this.isHint = isHint;
	}
}