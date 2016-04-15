package model;

public abstract class Level {
	
	int levelNum;
	boolean locked;
	Bullpen bullpen;
	Board board;
	Palette palette;
	int numStars;
	Piece activePiece;
	
	
	public Level(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		this.levelNum = levelNum;
		this.bullpen = bullpen;
		this.board = board;
		this.palette = palette;
		this.locked = locked;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setNumStars(int numStars){
		this.numStars = numStars;
	}
	
	public void setActivePiece(Piece activePiece){
		this.activePiece = activePiece;
	}
	
	public boolean hasWon(){
		return numStars > 0; // TODO: Is this valid lol
	}
	
	public void setLocked(boolean locked){
		this.locked = locked;
	}
	
	public abstract void calcNumStars();
	
	/**
	 * Returns the name (corresponding to type) of this level
	 * @return String
	 */
	public abstract String getName();
}
