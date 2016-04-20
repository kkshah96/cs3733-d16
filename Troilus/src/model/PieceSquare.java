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
	int row;
	int col;
	
	public PieceSquare(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	// TODO: Can a PuzzleSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "PieceSquare";
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
}