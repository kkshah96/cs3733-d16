package controller;

/**
 * Class to provide basic format for moves in builder and game.
 * 
 *
 */
public abstract class Move {
	
	/**Value corresponding to whether or not this move results in the game ending*/
	protected boolean endGameStatus;
	
	protected Move(){
		endGameStatus = false;
	}
	
	public abstract boolean doMove();
	
	public abstract boolean isValid();
	
	public abstract boolean undo();
	
	/**
	 * Returns whether or not this move ends the game.
	 * @return True if this move ends the game; false otherwise.
	 */
	public boolean getEndGameStatus() {
		return endGameStatus;
	}
	
}
