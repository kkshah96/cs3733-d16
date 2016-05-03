package controller;

import model.Bullpen;
import model.Level;
import model.Piece;

/** 
 * Class for implementation of moving a piece from palette to bullpen.
 * @author Kunal Shah
 */
public class PaletteToBullpenMove extends Move{
	/** The level utilized in this move */
	Level level;
	
	/** The piece selected in the Palette **/
	Piece selectedPiece;
	
	/**
	 * Creates a new instance of the PaletteToBullpenMove with the given parameters
	 * @param level The level to perform the move on
	 * @param selectedPiece A reference to the selectedPiece in the level
	 */
	public PaletteToBullpenMove(Level level, Piece selectedPiece) {
		super();
		this.level = level;
		this.selectedPiece = selectedPiece;
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

		// Add the piece to the bullpen
		bullpen.addPiece(selectedPiece);

		return true;
	}

	/** Checks if adding a Piece from Palette to Bullpen is valid.
	 * Should always return true as this move can never be invalid
	 * @return True
	 */
	public boolean isValid() {
		return true;
	}
	
	/** Logic for undoing this PaletteToBullpenMove. Removes the piece from the bullpen
	 * @return True if the move is valid, false otherwise
	 */
	public boolean undo() {
		Bullpen bpen = level.getBullpen();

		bpen.removePiece(selectedPiece);
		return true;
	}
}