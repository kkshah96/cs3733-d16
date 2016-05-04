package controller;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;

/** 
 * Class for implementation of moving a piece from board to bullpen.
 * @author Maddy Longo
 * @author Dan Alfred
 * @author Connor Weeks
 */
public class BullpenToBoardMove extends Move {
	/** The level utilized in this move. */
	Level level;

	/** The moving, or active piece used in the move. */
	Piece movingPiece;

	/** The column of the square as the requested destination in the board. */
	int col;

	/** The row of the square as the requested destination in the board. */
	int row;

	/** The current level's bullpen. */
	Bullpen bullpen;

	/** The current level's board. */
	Board board;

	/** Keep track of when in player (needed for Lightning Level in Builder) */
	boolean inPlayer;
	
	/**
	 * Creates a new instance of the BullpentoBoardMove with the given parameters.
	 * @param level The level to perform the move on.
	 * @param movingPiece A reference to the active piece for the level.
	 * @param col The column on the board as the destination.
	 * @param row The row on the board as the destination.
	 */
	public BullpenToBoardMove(Level level, Piece movingPiece, int col, int row, boolean inPlayer) {
		super();
		this.inPlayer = inPlayer;
		this.level = level;
		this.movingPiece = movingPiece;
		this.col = col;
		this.row = row;
		this.board = level.getBoard();
		this.bullpen = level.getBullpen();
	}

	/** Adds the piece to the Board if valid.
	 * @return True if the move is completed successfully, false otherwise.
	 */
	public boolean doMove() {
		// Check if the move is valid. If not, return false
		if (!isValid()) {
			return false;
		}

		// Add the piece to the board, remove the active drawn piece in the level,
		// and remove the piece from the bullpen
		board.addPiece(movingPiece, col, row);
		bullpen.removePiece(movingPiece);
		level.removeActivePiece();

		if (inPlayer) {
			// Signal to the level to update, set end status to return value
			endGameStatus = level.updateAfterMove();
		}
		return true;
	}

	/** Checks if adding a Piece from Bullpen to Board is valid.
	 * Valid if the requested piece destination doesn't contain any invalid squares or other pieces.
	 * @return True if the move is valid, false otherwise.
	 */
	public boolean isValid() {
		return board.validPlacement(movingPiece, col, row);
	}

	/** Logic for undoing this BullpenToBoardMove. Places the piece back into
	 * the bullpen and removes it from the board.
	 * Valid if the requested piece destination doesn't contain any invalid squares or other pieces.
	 * @return True if the move is valid, false otherwise.
	 */
	public boolean undo() {
		board.removePiece(movingPiece);
		bullpen.addPiece(movingPiece);
		level.removeActivePiece();
		return true;
	}
}