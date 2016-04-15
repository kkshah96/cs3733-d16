package model;

public class OutOfBoundsSquare extends Square {

	public OutOfBoundsSquare(int row, int col){//, boolean hintSquare) {
		super(row, col);//, hintSquare);
	}

	@Override
	public boolean isValid() {
		return false;
	}

}
