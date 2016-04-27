package model;

/**
 * Class allows for storage and manipulation of Lightning Square.
 * 
 * Allows for implementation of Lightning-level squares in Kabasuji.
 * Keeps track of whether it has been covered by a Piece.
 * 
 * @author Maddy
 * @author Kunal Shah
 *
 */
public class LightningSquare extends Square {
	boolean isCovered;
	
	/**
	 * Creates a LightningSquare with the following parameters.
	 * @param col The column of the square
	 * @param row The row of the square
	 * @param isValid If the square is valid
	 */
	public LightningSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
	}
	
	/**
	 * Creates a LightningSquare with the following parameters.
	 * @param col The column of the square
	 * @param row The row of the square
	 * @param isValid If the square is valid
	 * @param isHint If the square is to be highlighted as a hint
	 */
	public LightningSquare(int col, int row, boolean isValid, boolean isHint) {
		super(col, row, isValid, isHint);
	}

	@Override
	public String getType() {
		return "LightningSquare";
	}
	
	public boolean isCovered() {
		return isCovered;
	}
}