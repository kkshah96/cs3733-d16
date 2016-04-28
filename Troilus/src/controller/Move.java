package controller;

public abstract class Move {
	
	protected Move(){ }
	
	public abstract boolean doMove();
	
	public abstract boolean isValid();
	
	public abstract boolean undo();
	
}
