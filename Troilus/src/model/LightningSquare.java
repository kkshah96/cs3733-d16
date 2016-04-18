package model;

public class LightningSquare extends Square {

	boolean isCovered;
	
	public LightningSquare() {//, boolean hintSquare) {
		super();//, hintSquare);
	}

	// TODO: Can a LightningSquare become invalid?
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