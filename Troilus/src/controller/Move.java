package controller;

/**
 * Class to provide basic format for moves in builder and game.
 * 
 *
 */
public abstract class Move {
	
	protected Move(){ }
	
	public abstract boolean doMove();
	
	public abstract boolean isValid();
	
	public abstract boolean undo();
	
}
