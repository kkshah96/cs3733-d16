package model;

public class PuzzleSquare extends Square {

	public PuzzleSquare() {//, boolean hintSquare) {
		super(); //, hintSquare;
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