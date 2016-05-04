package model;

/**
 * Represents a Level of game type Puzzle in the Kabasuji game.
 * 
 * The PuzzleLevel structure stores the the maximum number of moves
 * the Player is allowed to perform as well as the number of moves remaining.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Connor Weeks
 */
public class PuzzleLevel extends Level {
	/** The maximum moves for this level from the start. */
	int maxMoves;
	
	/** The moves remaining for this level. */
	int movesLeft;
	
	/**
	 * Creates a new instance of the PuzzleLevel entity with the following parameters.
	 * @param levelNum The number of this level.
	 * @param locked The status of the lock on this level.
	 * @param bullpen Reference to the bullpen object for this level.
	 * @param board Reference to the board object for this level.
	 * @param palette Reference to the palette object for this level (LevelBuilder only).
	 * @param maxMoves int representation of the maximum number of moves for this level.
	 */
	public PuzzleLevel(int levelNum, boolean locked, Bullpen bullpen,
			Board board, Palette palette, int maxMoves) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.maxMoves = maxMoves;
		this.movesLeft = this.maxMoves;
	}
	
	/**
	 * Updates this entity after a move has been completed, by refreshing the number of moves remaining.
	 * and updating the number of stars earned.
	 * @return True if the number of stars equals 3, or no moves remain; false otherwise.
	 */
	public boolean updateAfterMove() {
		updateMovesLeft(-1);
		System.out.println("Moves Left: " + this.getMovesLeft());
		calcNumStars();
		return (numStars == 3) || (movesLeft == 0);
	}

	@Override
	/** 1 star if 2 pieces left, 2 stars if 1 piece left, 3 if won. */
	public void calcNumStars() {
		if (bullpen.getNumPieces() > MAX_STARS - 1) { // more than 2 pieces left
			numStars = 0;
		} else { // 2 pieces or fewer left
			numStars = MAX_STARS - bullpen.getNumPieces();
		}
	}
	
	/**
	 * Updates the number of moves left for this level.
	 * @param i The difference in moves.
	 */
	public void updateMovesLeft(int i) {
		movesLeft += i;
	}
	
	/**
	 * Return string representation of this level ("Puzzle").
	 */
	public String getName() {
		return "Puzzle";
	}
	
	/**
	 * Determines the number of moves remaining in this level.
	 * @return int representation of the number of moves left.
	 */
	public int getMovesLeft() {
		return movesLeft;
	}
	
	/**
	 * Determines the maximum number of moves for this level.
	 * @return int representation of the total number of moves.
	 */
	public int getMaxMoves() {
		return maxMoves;
	}
	
	/**
	 * Updates the maximum number of moves for this level.
	 * @param maxMoves The new maximum number of moves.
	 */
	public void setMaxMoves(int maxMoves) {
		this.maxMoves = maxMoves;
	}
}