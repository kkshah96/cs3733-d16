package model;

import java.awt.Color;

/**
 * Represents a Level of game type Release in the Kabasuji game.
 * 
 * The ReleaseLevel structure stores three boolean arrays that capture
 * which numbers of each color type have been covered.
 * 
 * @author Kunal Shah
 * @author Maddy
 */
public class ReleaseLevel extends Level {
	public static final int MAX_NUM = 6;
	boolean redCovered[];
	boolean yellowCovered[];
	boolean greenCovered[];

	public ReleaseLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		super(levelNum, locked, bullpen, board, palette);

		redCovered = new boolean[MAX_NUM];
		yellowCovered = new boolean[MAX_NUM];
		greenCovered = new boolean[MAX_NUM];
	}

	public void updateAfterMove() {
		findCoveredNumbers();
		calcNumStars();
	}

	@Override
	/** 1 star for completing 1 color set, 2 for 2 color sets, win if get all 3 */
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
		for (Piece piece : board.getPieces().keySet()) {
			int anchorCol = board.getPieces().get(piece).x;
			int anchorRow = board.getPieces().get(piece).y;
			
			for (Square square : piece.getSquares()) {
				int absCol = anchorCol + square.getCol();
				int absRow = anchorRow + square.getRow();
				
				ReleaseSquare currentSquare = (ReleaseSquare) board.squares[absCol][absRow];
				int currentNum = currentSquare.getNumber();
				Color currentColor = currentSquare.getNumberColor();
				if (currentNum > 0 && currentColor != null) {
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

	// TODO: There has to be a better way to do this
	public void updateCoveredNumbers(Color c, int i) {
		if (i >= MAX_NUM || i < 0) {
			return;
		}

		if (c.equals(Color.RED)) {
			redCovered[i] = true;
		}

		if (c.equals(Color.YELLOW)) {
			yellowCovered[i] = true;
		}

		if (c.equals(Color.GREEN)) {
			greenCovered[i] = true;
		}
	}

	// TODO implement stubs!
	public int getRedCovered() {
		int red = 0;

		for (boolean covered : redCovered) {
			if (covered) {
				red++;
			}
		}

		return red;
	}

	public int getGreenCovered() {
		int green = 0;

		for (boolean covered : greenCovered) {
			if (covered) {
				green++;
			}
		}

		return green;
	}

	public int getYellowCovered() {
		int yellow = 0;

		for (boolean covered : yellowCovered) {
			if (covered) {
				yellow++;
			}
		}

		return yellow;
	}
	
	public String getName() {
		return "Release";
	}
}