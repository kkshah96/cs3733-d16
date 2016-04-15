package model;

public class LightningSquare extends Square {

	boolean isCovered;
	
	public LightningSquare(int row, int col){//, boolean hintSquare) {
		super(row, col);//, hintSquare);
	}

	// TODO: Can a LightningSquare become invalid?
	@Override
	public boolean isValid() {
		return true;
	}

}
