package model;

/**
 * Represents a Level of game type Puzzle in the Kabasuji game.
 * 
 * The PuzzleLevel structure stores the the maximum number of moves
 * the Player is allowed to perform as well as the number of moves remaining.
 * 
 * @author Kunal Shah
 * @author Maddy
 */
public class PuzzleLevel extends Level {
	int maxMoves;
	int movesLeft;

	public PuzzleLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int maxMoves) {
		super(levelNum, locked, bullpen, board, palette);
		this.maxMoves = maxMoves;
		this.movesLeft = this.maxMoves; // TODO: Can I do dis
	}

	@Override
	/** Calculates stars based on the number of pieces placed.
	 * 1 star for all but 2 pieces, 2 for all but 1 piece, 3 if won.
	 */
	public void calcNumStars() {
		if (bullpen.getNumPieces() > 2) {
			numStars.setValue(0);;
		} else {
			numStars.setValue(3 - bullpen.getNumPieces());
		}
	}

	public void updateMovesLeft(int i) {
		movesLeft += i;
	}

	public String getName() {
		return "Puzzle";
	}

	public int getMaxMoves() {
		return maxMoves;
	}

	public void setMaxMoves(int maxMoves){
		this.maxMoves = maxMoves;
	}
}