package model;

public class LightningLevel extends Level{
	
	int squaresMarked;
	int timeLimit;
	
	public LightningLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int timeLimit) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.timeLimit = timeLimit;
		
	}

	@Override
	public void calcNumStars() {
		// TODO Implement this
	}
	
	public void updateSquaresMarked(int i){
		squaresMarked += i;
	}
	
	public String getName() {
		return "Lightning";
	}
	
	public int getTime() {
		return timeLimit;
	}
}
