package model;

/**
 * Class allows for storage and manipulation of Puzzle Square.
 * 
 * Allows for implementation of Puzzle-level squares in Kabasuji.
 * 
 * @author Maddy
 *
 */
public class PuzzleSquare extends Square {
	public PuzzleSquare(int row, int col) {
		super(row, col);
	}

	// TODO: Can a PuzzleSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "PuzzleSquare";
	}
}