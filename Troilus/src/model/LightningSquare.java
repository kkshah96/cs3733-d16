package model;

/**
 * Class allows for storage and manipulation of Lightning Square.
 * 
 * Allows for implementation of Lightning-level squares in Kabasuji.
 * Keeps track of whether it has been covered by a Piece.
 * 
 * @author Maddy
 *
 */
public class LightningSquare extends Square {
	boolean isCovered;
	
	public LightningSquare() {
		super();
	}

	/** Returns true if square is not already covered
	 * 
	 */
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "LightningSquare";
	}
}