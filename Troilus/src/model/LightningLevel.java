package model;

public class LightningLevel extends Level{
	
	int squaresMarked;
	int timeLimit;
	
	public LightningLevel(int levelNum, Bullpen bullpen, Board board, Palette palette, int timeLimit) {
		super(levelNum, bullpen, board, palette);
		
		this.timeLimit = timeLimit;
		
	}

	@Override
	public void calcNumStars() {
		// TODO Implement this
	}
	
	public void updateSquaresMarked(int i){
		squaresMarked += i;
	}
}
