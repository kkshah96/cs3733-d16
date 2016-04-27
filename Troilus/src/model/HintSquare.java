package model;

public class HintSquare extends Square{

	public HintSquare(int col, int row, boolean isValid) {
		super(col, row, isValid);	
	}

	@Override
	public String getType() {
		return "HintSquare";
	}

}
