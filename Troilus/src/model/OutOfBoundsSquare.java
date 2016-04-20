package model;

/**
 * Class allows for storage and manipulation of out-of-bounds Squares.
 * 
 * Allows for implementation of out-of-bounds squares in Kabasuji.
 * Invalid square
 * 
 * @author Maddy
 *
 */
public class OutOfBoundsSquare extends Square {
	public OutOfBoundsSquare(int row, int col) {
		super(row, col, false);
	}

	@Override
	public String getType() {
		return "OutOfBoundsSquare";
	}
}