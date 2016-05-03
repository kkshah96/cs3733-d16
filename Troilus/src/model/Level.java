package model;

import java.util.ArrayList;

/**
 * Represents a Level in the Kabasuji game.
 * 
 * The Level structure stores information about the Level itself
 * (such as its index, whether or not it is locked, and how many stars have been obtained)
 * and also knows about a single Board, Bullpen, and Palette.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Connor Weeks
 */
public abstract class Level {
	/** Constant to represent the maximum number of stars that can be earned */
	public static final int MAX_STARS = 3;
	
	/** The number of this level in the Kabasuji entity */
	int levelNum;
	
	/** The status for if this level is locked */
	boolean locked;
	
	/** The bullpen used in this level */
	Bullpen bullpen;
	
	/** The board used in this level */
	Board board;
	
	/** The palette of pieces used in this level (for builder only) */
	Palette palette;
	
	/** The current number of stars earned on this level */
	int numStars;
	
	/** The active piece on this level */
	Piece activePiece;
	
	/** The source of any in-progress move*/
	Object moveSource;

	/**
	 * Updates the field in level with the following parameters
	 * @param levelNum The level number in the Kabasujin
	 * @param locked The status for if this level is locked or not
	 * @param bullpen Reference to the bullpen used in this level
	 * @param board Reference to the board used in this level
	 * @param palette Reference to the palette used in this level, if initialized by the levelbuilder application
	 */
	public Level(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		this.levelNum = levelNum;
		this.bullpen = bullpen;
		this.board = board;
		this.palette = palette;
		this.locked = locked;
	}

	/**
	 * Removes all pieces from the board and places them in the bullpen
	 */
	public void clearBoardToBullpen() {
		// Remove all pieces from the board
		ArrayList<Piece> toRemove = new ArrayList<Piece>();
		for (Piece p : board.getPieces().keySet()) {
			toRemove.add(p);
			bullpen.addPiece(p);
		}
		// Hack to avoid modifying board.pieces while looping through it
		for (Piece p : toRemove) {
			board.removePiece(p);
		}
	}

	/** 
	 * Do anything necessary after a move.
	 * @return True if the update causes the end of the game
	 */
	public abstract boolean updateAfterMove();
	
	/**
	 * Determines if this level is locked
	 * @return True if this level is locked, false if it is unlocked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Assigns the number of stars earned from this level
	 * @param numStars Number of stars earned
	 */
	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}

	/**
	 * Sets the active piece of this level
	 * @param activePiece Reference to the piece to set active on
	 */
	public void setActivePiece(Piece activePiece) {
		this.activePiece = activePiece;
	}

	/**
	 * Determines the active piece of this level <br />
	 * WARNING: returns null if no active piece
	 * @return The active piece of this level, or null if no active piece
	 */
	public Piece getActivePiece() {
		return activePiece;
	}

	/**
	 * Determines if this level has been won- at least 1 star has been earned
	 * @return True if the level has been won, false if not
	 */
	public boolean hasWon() {
		return numStars > 0;
	}

	/**
	 * Updates the locked status of this level
	 * @param locked Boolean true/false for if this level should be locked
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * Determines the number of this level
	 * @return The number associated with this level
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * Calculates the number of stars earned on this level
	 */
	public abstract void calcNumStars();

	/**
	 * Returns the name (corresponding to type) of this level
	 * @return String representation of this level type
	 */
	public abstract String getName();

	/**
	 * Determines the number of stars earned on this level
	 * @return Int representation of number of earned stars
	 */
	public int getNumStars() {
		return numStars;
	}

	/**
	 * @return Reference to the bullpen object for this level
	 */
	public Bullpen getBullpen() {
		return bullpen;
	}

	/**
	 * @return Reference to the board object for this level
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return Reference to the palette object for this level
	 */
	public Palette getPalette(){
		return palette;
	}

	/**
	 * Removes the active piece for this level
	 */
	public void removeActivePiece() {
		setActivePiece(null);
	}

	/**
	 * Updates the source of an in-progress move in this level
	 * @param s Object representation of the source for the move
	 */
	public void setMoveSource(Object source){
		this.moveSource = source;
	}

	/**
	 * Determines the source of an in-progress move for this level, or null if no move in-progress
	 * @return Move source as object
	 */
	public Object getMoveSource(){
		return moveSource;
	}

	/**
	 * Updates this level's number
	 * @param levelNum The level number to update to
	 */
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
}