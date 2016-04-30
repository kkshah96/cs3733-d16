package model;

import java.util.Random;
import java.util.Set;

/**
 * Represents a Level of game type Lightning in the Kabasuji game.
 * 
 * The LightningLevel structure stores the time limit in seconds the Level
 * must be completed in and the number of squares that have been covered by Piece(s).
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Connor Weeks
 */
public class LightningLevel extends Level{
	/** The number of covered squares in this level */
	protected int coveredSquares;
	
	/** The number of total valid squares in this level */
	protected int validSquares;
	
	/** The total time limit for this level */
	protected int timeLimit;
	
	/**
	 * Creates a new instance of the LightningLevel entity with the following parameters
	 * @param levelNum The number of this level
	 * @param locked The status of if this level is locked or not
	 * @param bullpen Reference to the bullpen object for this level
	 * @param board Reference to the board object for this level
	 * @param palette Reference to the palette object for this level (LevelBuilder only)
	 * @param timeLimit Total time limit at the start of this level
	 */
	public LightningLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette, int timeLimit) {
		super(levelNum, locked, bullpen, board, palette);
		
		this.timeLimit = timeLimit;
		this.countValidSquares();
		this.coveredSquares = 0;
	}

	/**
	 * Refreshes the entity after completing a move by updating the number of squares covered, placing a new piece in the bullpen,
	 * and updating the number of stars earned
	 * @return True if the number of stars is 3, false otherwise
	 */
	public boolean updateAfterMove() {
		coverSquares();
		replacePiece();
		calcNumStars();
		return (numStars == 3);
	}
	
	/** Generate a new random piece and put in bullpen */
	private void replacePiece() {
		Random rand = new Random();
		int randNum = rand.nextInt(36);
		System.out.println(randNum);
		Piece newPiece = PieceFactory.getPiece(randNum);
		bullpen.addPiece(newPiece);
	}
	
	/** Replace any pieces with covered squares on the board */
	private void coverSquares() {
		Set<Piece> pSet = board.getPieces().keySet();
		
		// Loop through the pieces in the board to replace them with covered squares
		for (Piece piece : pSet) {
			int anchorCol = board.getPieces().get(piece).x;
			int anchorRow = board.getPieces().get(piece).y;
			
			// Loop through the squares for each piece and replace the board square covered by that
			// piece square with a covered square
			for (PieceSquare square : piece.getAllSquares()) {
				int currentCol = anchorCol + square.getCol();
				int currentRow = anchorRow + square.getRow();

				((LightningSquare) board.squares[currentCol][currentRow]).isCovered = true;
			}
			
			// Remove the piece to prevent duplicate computations
			board.removePiece(piece);
		}
	}
	
	@Override
	/** 1 star if covered all but 12 squares, 2 if covered all but 6, 3 if won */
	public void calcNumStars() {
		validSquares = countValidSquares(); // Just in case in Level Editor
		coveredSquares = countCoveredSquares();
		
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

	/** Count the number of covered squares on the board (needed for LevelEditor) 
	 * @return Int representation of the number of covered squares on the board
	 */
	int countCoveredSquares() {
		int coveredSquares = 0;
		
		for (Square[] col : board.squares) {
			for (Square square : col) {
				if (square.isValid() && ((LightningSquare) square).isCovered()) {
					// Check if valid, just in case
					coveredSquares++;
				}
			}
		}
		
		return coveredSquares;
	}
	
	/** Count the number of squares on the board (needed for LevelEditor)
	 * @return Int representation of the total number of valid squares on the board
	 */
	int countValidSquares() {
		int validSquares = 0;
		
		for (Square[] col : board.squares) {
			for (Square square : col) {
				if (square.isValid()) {
					validSquares++;
				}
			}
		}
		
		return validSquares;
	}
	
	// TODO fix! Entity doesn't know how much time is left!
	/** Determines if a move can be done on this level
	 * @return True if moves can be completed, false if not
	 */
	public boolean canMove() {
		return timeLimit > 0;
	}
	
	/**
	 * @return String representation of the name of this level type
	 */
	public String getName() {
		return "Lightning";
	}
	
	/**
	 * Determines the starting time limit for this level
	 * @return Int representation of starting time limit
	 */
	public int getTime() {
		return timeLimit;
	}
	
	/**
	 * Sets the time limit for this level
	 * @param limit The time limit to set for this level
	 * @return True if the limit was updateed successfully, false if otherwise
	 */
	public boolean setTimeLimit(int limit) {
		if (limit < 0) {
			System.out.println("Error! Invalid time limit.");
			return false;
		} else {
			this.timeLimit = limit;
			return true;
		}	
	}
}