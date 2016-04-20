package model;

// TODO: Shouldn't this be an interface now that we aren't storing anything?

/**
 * Class allows for consistent manipulation of square structure.
 * 
 * Allows for implementation of squares for Kabasuji. Squares can be
 * valid or invalid and have a type.
 * 
 * @author Maddy
 *
 */
public abstract class Square {
	int row;
	int col;
	
	public Square(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	// TODO: Does this have to be an abstract method?
	public abstract boolean isValid();
	
	public abstract String getType();
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
}