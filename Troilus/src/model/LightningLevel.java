package model;

/**
 * Represents a Level of game type Lightning in the Kabasuji game.
 * 
 * The LightningLevel structure stores the time limit in seconds the Level
 * must be completed in and the number of squares that have been covered by Piece(s).
 * 
 * @author Kunal Shah
 * @author Maddy
 */
public class LightningLevel extends Level{
	protected int coveredSquares;
	protected int validSquares;
	protected int timeLimit;
	
	public LightningLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int timeLimit) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.timeLimit = timeLimit;
		this.countValidSquares();
		this.coveredSquares = 0;
	}

	public void updateAfterMove() {
		countValidSquares(); // Just in case in Level Editor
		calcNumStars();
	}
	
	@Override
	/** 1 star if covered all but 12 squares, 2 if covered all but 6, 3 if won */
	public void calcNumStars() {
		int squaresLeft = validSquares - coveredSquares;
		
		if (squaresLeft > 12) {
			numStars = 0;
		} else if (squaresLeft > 6) {
			numStars = 1;
		} else if (squaresLeft > 0) {
			numStars = 2;
		} else {
			numStars = 3;
		}
	}
	
	void countValidSquares() {
		int squareCounter = 0;
		
		for (Square[] col : board.squares) {
			for (Square square : col) {
				if (square.isValid()) {
					squareCounter++;
				}
			}
		}
		
		validSquares = squareCounter;
	}
	
	// TODO make this reachable from Board/etc.
	public void updateSquaresCovered(int i) {
		coveredSquares += i;
	}
	
	public String getName() {
		return "Lightning";
	}
	
	public int getTime() {
		return timeLimit;
	}
	
	public boolean setTimeLimit(int limit){
		if (limit < 0) {
			System.out.println("Error! Invalid time limit.");
			return false;
		} else {
			this.timeLimit = limit;
			return true;
		}	
	}
}