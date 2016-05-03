package model;

/**
 * Class allows for storage and manipulation of Piece Square.
 * 
 * Allows for implementation of squares of Pieces in Kabasuji.
 * Keeps track of location as row, col.
 * 
 * @author Maddy
 *
 */
public class PieceSquare extends Square {
	/**
	 * Creates a PieceSquare with the following parameters.
	 * @param col The column of this PieceSquare relative to the anchor
	 * @param row The row of this PieceSquare relative to the anchor
	 */
	public PieceSquare(int col, int row) {
		super(col, row, true);
	}
	
	/**
	 * Check if PieceSquare is valid (always true).
	 */
	public boolean isValid() {
		return true;
	}

	/**
	 * Get string representation of type ("PieceSquare").
	 */
	public String getName() {
		return "PieceSquare";
	}
}