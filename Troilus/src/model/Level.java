package model;

/**
 * Represents a Level in the Kabasuji game.
 * 
 * The Level structure stores information about the Level itself
 * (such as its index, whether or not it is locked, and how many stars have been obtained)
 * and also knows about a single Board, Bullpen, and Palette.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 */
public abstract class Level {
	public static final int MAX_STARS = 3;
	int levelNum;
	boolean locked;
	Bullpen bullpen;
	Board board;
	Palette palette;
	int numStars;
	Piece activePiece;
	String moveSource;

	public Level(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		this.levelNum = levelNum;
		this.bullpen = bullpen;
		this.board = board;
		this.palette = palette;
		this.locked = locked;
	}
	
	/** Do anything necessary after a move */
	public abstract void updateAfterMove();
	
	public boolean canMove() {
		return true;
	}
	public boolean isLocked() {
		return locked;
	}

	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}

	public void setActivePiece(Piece activePiece) {
		this.activePiece = activePiece;
	}

	public Piece getActivePiece() {
		return activePiece;
	}

	public boolean hasWon() {
		return numStars > 0; // TODO: Is this valid lol
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public abstract void calcNumStars();

	/**
	 * Returns the name (corresponding to type) of this level
	 * @return String
	 */
	public abstract String getName();
	
	public int getNumStars() {
		return numStars;
	}
	
	public Bullpen getBullpen() {
		return bullpen;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public Palette getPalette(){
		return palette;
	}

	public void removeActivePiece() {
		setActivePiece(null);
	}
	
	public void setMoveSource(String s){
		this.moveSource = s;
	}
	
	public String getMoveSource(){
		return moveSource;
	}
}