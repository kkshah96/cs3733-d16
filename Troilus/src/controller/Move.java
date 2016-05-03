package controller;

/**
 * Class to provide basic format for moves in builder and game.<p>
 * 
 *@author Alexander Kasparek
 *@author Connor Weeks
 *@author Dan Alfred
 *@author Kunal Shah
 *@author Maddy Longo
 */
public abstract class Move {
	
	/**Value corresponding to whether or not this move results in the game ending*/
	protected boolean endGameStatus;
	
	/**
	 * Default constructor; sets endGameStatus to false.
	 */
	protected Move(){
		endGameStatus = false;
	}
	
	/**
	 * Performs the specified move if it is valid and
	 * updates the display to correspond to the move performed.
	 * @return True if the move was performed.
	 */
	public abstract boolean doMove();
	
	/**
	 * Returns true if the move can be performed under the current conditions.
	 * @return True if move is valid.
	 */
	public abstract boolean isValid();
	
	/**
	 * Undoes the move (if implemented), restoring the view and model
	 * to its state before the move was performed.
	 * @return true if the move was undone.
	 */
	public abstract boolean undo();
	
	/**
	 * Returns whether or not this move ends the game.
	 * @return True if this move ends the game; false otherwise.
	 */
	public boolean getEndGameStatus() {
		return endGameStatus;
	}
	
}
