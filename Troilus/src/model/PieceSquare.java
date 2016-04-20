package model;

/**
 * Class allows for storage and manipulation of Piece Square.
 * 
 * Allows for implementation of squares of Pieces in Kabasuji.
 * Keeps track of location as row, col
 * 
 * @author Maddy
 *
 */
public class PieceSquare extends Square {
	public PieceSquare(int row, int col) {
		super(row, col, true);
	}
	
	// TODO: Can a PieceSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		return "PieceSquare";
	}
}