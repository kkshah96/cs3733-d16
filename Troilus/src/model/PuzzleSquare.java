package model;

public class PuzzleSquare extends Square {

	public PuzzleSquare(int row, int col, boolean hintSquare) {
		super(row, col, hintSquare);
	}

	// TODO: Can a PuzzleSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

}
