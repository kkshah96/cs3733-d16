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
	public PuzzleSquare(int row, int col, boolean isValid) {
		super(row, col, isValid);
	}

	@Override
	public String getType() {
		return "PuzzleSquare";
	}
}