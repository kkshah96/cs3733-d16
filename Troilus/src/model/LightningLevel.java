package model;

/**
 * Represents a Level of game type Lightning in the Kabasuji game
 * 
 * The LightningLevel structure stores the time limit in seconds the Level must be completed in and the number of squares that have been covered by Piece(s)
 * 
 * @author Kunal Shah
 *
 */
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
	
	public boolean setTimeLimit(int limit){
		if(limit < 0){
			System.out.println("Error! Invalid time limit.");
			return false;
		}
		else{
			this.timeLimit = limit;
			return true;
		}
		
			
	}
}
