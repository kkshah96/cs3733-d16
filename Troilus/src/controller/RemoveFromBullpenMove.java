package controller;

import model.Bullpen;
import model.Level;
import model.Piece;

/** 
 * Class for implementation of deleting a piece from the bullpen
 * @author Kunal Shah
 */
public class RemoveFromBullpenMove extends Move{
	/** The level utilized in this move */
	Level level;
	
	/** The piece clicked in the Bullpen **/
	Piece clickedPiece;
	
	/**
	 * Creates a new instance of the RemoveFromBullpenMove with the given parameters
	 * @param level The level to perform the move on
	 * @param clickedPiece A reference to the piece right clicked in the bullpen
	 */
	public RemoveFromBullpenMove(Level level, Piece clickedPiece) {
		super();
		this.level = level;
		this.clickedPiece = clickedPiece;
	}

	/** Adds the piece to the Board if valid 
	 * @return True if the move is completed successfully, false otherwise
	 */
	public boolean doMove() {
		// Create references to the bullpen
		Bullpen bullpen = level.getBullpen();

		// Check if the move is valid. If not, return false
		if (!isValid()) {
			return false;
		}

		// Remove the piece from the bullpen
		bullpen.removePiece(clickedPiece);

		return true;
	}

	/** Checks if removing a Piece from Bullpen is valid.
	 * Should always return true as this move can never be invalid
	 * @return True
	 */
	public boolean isValid() {
		return true;
	}
	
	/** Logic for undoing this RemoveFromBullpenMove. Adds the piece back to the bullpen
	 * @return True if the move is valid, false otherwise
	 */
	public boolean undo() {
		Bullpen bpen = level.getBullpen();

		bpen.addPiece(clickedPiece);
		return true;
	}
}