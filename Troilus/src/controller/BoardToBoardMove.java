package controller;

import model.Board;
import model.Level;
import model.Piece;

/**
 * Class for implementation of moving a piece on the board.
 * TODO THIS NEEDS TO BE FINISHED!
 * @author Alex Kasparek
 * @author Maddy
 * @author Dan Alfred
 *
 */
public class BoardToBoardMove {
	/** The level this move acts on. */
	Level level;
	
	/** The piece utilized during the move. */
	Piece movingPiece;
	
	/** The column on the board for destination. */
	int col;
	
	/** The row on the board for destination. */
	int row;

	/**
	 * Creates a new instance of a BoardToBoardMove with the given parameters.
	 * @param level The level to complete the move on
	 * @param movingPiece A reference to the active, or moving piece
	 * @param col The column of the destination square on the board
	 * @param row The row of the destination square on the board
	 */
	public BoardToBoardMove(Level level, Piece movingPiece, int col, int row) {
		this.level = level;
		this.movingPiece = movingPiece;	
		this.col = col;
		this.row = row;
	}

	/**
	 * Completes this instance of BoardToBoardMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	public boolean doMove() {
		// First check if the move is valid. Return false if invalid
		if (!isValid(movingPiece, col, row)) {
			System.out.println("Invalid move!");
			return false;
		}
		
		// Obtain a reference to the board and add the piece at the specified location
		Board board  = level.getBoard();
		board.addPiece(movingPiece, col, row);

		// Remove the active piece stored in level, and signal to update
		level.removeActivePiece();
		level.updateAfterMove();
		return true;
	}

	/**
	 * Checks if this BoardToBoardMove is valid with the given parameters<br />
	 * -Valid if all squares inside the piece are not on an invalid squares and <br />
	 * -There are no pieces underneath the requested piece 
	 * 
	 * @param piece Reference to the piece to use in the move
	 * @param col Column on the board as the destination
	 * @param row Row on the board as the destination
	 * @return True if this BoardToBoardMove is valid with the given parameters, false otherwise
	 */
	public boolean isValid(Piece piece, int col, int row) {
		// TODO: if level.canMakeMove()...
		return level.getBoard().validPlacement(piece, col, row);
	}

	//TODO: ADD UNDO
	/**
	 * Undoes this BoardToBoardMove
	 * @return True if the move was undone successfully, or false otherwise
	 */
	public boolean undo() {
		return false;
	}
}