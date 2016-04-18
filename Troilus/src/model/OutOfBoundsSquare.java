package model;

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