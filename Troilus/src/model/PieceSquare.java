package model;

public class PieceSquare extends Square {
	int row;
	int col;
	
	public PieceSquare(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	// TODO: Can a PuzzleSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "PieceSquare";
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
}