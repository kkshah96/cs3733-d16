package model;

/**
 * Class allows for storage and manipulation of Puzzle Square.
 * 
 * Allows for implementation of Puzzle-level squares in Kabasuji.
 * 
 * @author Maddy
 * @author Kunal Shah
 *
 */
public class PuzzleSquare extends Square {
	
	/**
	 * Creates a PuzzleSquare with the following parameters.
	 * @param col
	 * @param row
	 * @param isValid
	 */
	public PuzzleSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
	}

	@Override
	public String getType() {
		return "PuzzleSquare";
	}
}