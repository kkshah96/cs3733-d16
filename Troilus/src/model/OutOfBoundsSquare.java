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

	public OutOfBoundsSquare() {//, boolean hintSquare) {
		super();//, hintSquare);
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "OutOfBoundsSquare";
	}
}