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
	 * @param col
	 * @param row
	 * @param isValid
	 */
	public LightningSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);
	}

	@Override
	public String getType() {
		return "LightningSquare";
	}
	
	public boolean isCovered() {
		return isCovered;
	}
}