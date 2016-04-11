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
	
	public void setNumStars(int numStars){
		this.numStars = numStars;
	}
	
	public void setActivePiece(Piece activePiece){
		this.activePiece = activePiece;
	}
	
	public boolean hasWon(){
		return numStars > 0; // TODO: Is this valid lol
	}
	
	public void unlockLevel(){
		locked = false;
	}
	
	public abstract void calcNumStars();
}
