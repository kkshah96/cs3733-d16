package model;

import java.awt.Color;

/**
 * Represents a Level of game type Release in the Kabasuji game.
 * 
 * The ReleaseLevel structure stores three boolean arrays that capture
 * which numbers of each color type have been covered.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Connor Weeks
 */
public class ReleaseLevel extends Level {
	/** Constant to indicate the quantity of numbers for each color */
	public static final int MAX_NUM = 6;

	/** Array to store which red numbers have been covered. */
	boolean redCovered[];

	/** Array to store which yellow numbers have been covered. */
	boolean yellowCovered[];

	/** Array to store which green numbers have been covered. */
	boolean greenCovered[];

	/**
	 * Creates a new instance of the ReleaseLevel entity with the following parameters:
	 * @param levelNum The number of this level
	 * @param locked The lock status of this level
	 * @param bullpen Reference to the Bullpen object for this level
	 * @param board Reference to the Board object for this level
	 * @param palette Reference to the Palette object for this level (LevelBuilder only)
	 */
	public ReleaseLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		super(levelNum, locked, bullpen, board, palette);
		redCovered = new boolean[MAX_NUM];
		yellowCovered = new boolean[MAX_NUM];
		greenCovered = new boolean[MAX_NUM];
	}

	/**
	 * Updates the entity after a move by updating the colored numbers that have been covered and 
	 * determining the number of stars earned.
	 * @return True if the number of stars equals 3.
	 */
	public boolean updateAfterMove() {
		findCoveredNumbers();
		calcNumStars();
		return (numStars == 3);
	}

	@Override
	/** 1 star for completing 1 color set, 2 for 2 color sets, win if get all 3. */
	public void calcNumStars() {
		int setsComplete = 0;
		// Take advantage of rounding down to calculate stars
		setsComplete += getRedCovered()/MAX_NUM;
		setsComplete += getGreenCovered()/MAX_NUM;
		setsComplete += getYellowCovered()/MAX_NUM;

		numStars = setsComplete;
	}
	
	/** Helper function for calculating stars */
	private void findCoveredNumbers() {
		// Reset values (not applicable, since Pieces are never removed in gameplay)
		redCovered = new boolean[MAX_NUM];
		yellowCovered = new boolean[MAX_NUM];
		greenCovered = new boolean[MAX_NUM];

		// Loop through each piece on the board
		for (Piece piece : board.getPieces().keySet()) {
			// Determine the absolute position of the anchor square
			int anchorCol = board.getPieces().get(piece).x;
			int anchorRow = board.getPieces().get(piece).y;

			// Loop through each PieceSquare
			for (Square square : piece.getAllSquares()) {
				// Obtain absolute coordinates for each PieceSquare
				int absCol = anchorCol + square.getCol();
				int absRow = anchorRow + square.getRow();

				// Get the square at the location of the overlaid PieceSquare
				ReleaseSquare currentSquare = (ReleaseSquare) board.getSquare(absCol, absRow);
				int currentNum = currentSquare.getNumber();
				Color currentColor = currentSquare.getNumberColor();

				// If it has a color and number, determine the color, and label it as marked in the appropriate array
				if (currentNum > 0  && currentNum <= MAX_NUM && currentColor != null) {
					if (currentColor.equals(Color.RED)) {
						redCovered[currentNum - 1] = true;
					} else if (currentColor.equals(Color.GREEN)) {
						greenCovered[currentNum - 1] = true;
					} else if (currentColor.equals(Color.YELLOW)) {
						yellowCovered[currentNum - 1] = true;
					}
				}
			}
		}
	}

	/**
	 * Determines the number of red squares covered.
	 * @return int representation of number of red squares covered.
	 */
	public int getRedCovered() {
		int red = 0;

		// Loop through red array and count each 'true'
		for (boolean covered : redCovered) {
			if (covered) {
				red++;
			}
		}
		return red;
	}

	/**
	 * Determines the number of green squares covered.
	 * @return int representation of number of green squares covered.
	 */
	public int getGreenCovered() {
		int green = 0;

		// Loop through green array and count each 'true'
		for (boolean covered : greenCovered) {
			if (covered) {
				green++;
			}
		}
		return green;
	}

	/**
	 * Determines the number of yellow squares covered.
	 * @return int representation of number of yellow squares covered.
	 */
	public int getYellowCovered() {
		int yellow = 0;

		// Loop through yellow array and count each 'true'
		for (boolean covered : yellowCovered) {
			if (covered) {
				yellow++;
			}
		}
		return yellow;
	}

	/**
	 * Returns a string representation of the Level type.
	 */
	public String getName() {
		return "Release";
	}
}