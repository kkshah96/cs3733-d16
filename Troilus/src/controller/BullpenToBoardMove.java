package controller;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;

/** 
 * Class for implementation of moving a piece from board to bullpen.
 * @author Maddy
 * @author Dan Alfred
 * @author Connor Weeks
 */
public class BullpenToBoardMove extends Move{
	/** The level utilized in this move */
	Level level;
	
	/** The moving, or active piece used in the move */
	Piece movingPiece;
	
	/** The column of the square as the requested destination in the board */
	int col;
	
	/** The row of the square as the requested destination in the board */
	int row;
	
	/**
	 * Creates a new instance of the BullpentoBoardMove with the given parameters
	 * @param level The level to perform the move on
	 * @param movingPiece A reference to the active piece for the level
	 * @param col The column on the board as the destination
	 * @param row The row on the board as the destination
	 */
	public BullpenToBoardMove(Level level, Piece movingPiece, int col, int row) {
		super();
		this.level = level;
		this.movingPiece = movingPiece;
		this.col = col;
		this.row = row;
	}

	/** Adds the piece to the Board if valid 
	 * @return True if the move is completed successfully, false otherwise
	 */
	public boolean doMove() {
		// Create references to the bullpen and board
		Bullpen bpen = level.getBullpen();
		Board board = level.getBoard();

		// Check if the move is valid. If not, return false
		if (!isValid()) {
			return false;
		}

		// Add the piece to the board, remove the active drawn piece in the level, and remove the piece from the bullpen
		board.addPiece(movingPiece, col, row);
		level.removeActivePiece();
		bpen.removePiece(movingPiece);

		// Signal to the level to update, set end status to return value
		endGameStatus = level.updateAfterMove();
		return true;
	}

	/** Checks if adding a Piece from Bullpen to Board is valid.
	 * Valid if the requested piece destination doesn't contain any invalid squares or other pieces.
	 * @return True if the move is valid, false otherwise.
	 */
	public boolean isValid() {
		// TODO Check if moves left in Puzzle
		return level.getBoard().validPlacement(movingPiece, col, row);
	}
	
	/** Logic for undoing this BullpenToBoardMove. Places the piece back into the bullpen and removes it from the board.<br /> 
	 * Valid if the requested piece destination doesn't contain any invalid squares or other pieces.
	 * @return True if the move is valid, false otherwise
	 */
	public boolean undo() {
		Bullpen bpen = level.getBullpen();
		Board board = level.getBoard();

		bpen.addPiece(movingPiece);
		level.removeActivePiece();
		board.removePiece(movingPiece);

		return true;
	}
}