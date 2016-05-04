package controller;

import model.Board;
import model.Level;
import model.Piece;

/**
 * Class for implementation of moving a piece on the board.
 * @author Alex Kasparek
 * @author Maddy Longo
 * @author Dan Alfred
 * @author Kunal Shah
 *
 */
public class BoardToBoardMove extends Move{
	/** The level this move acts on. */
	Level level;

	/** The piece utilized during the move. */
	Piece movingPiece;

	/** The column on the board for destination. */
	int toCol;

	/** The row on the board for destination. */
	int toRow;

	/** movingPiece's previous row **/
	int fromRow;

	/** movingPiece's previous column**/
	int fromCol;

	/** Current level's board. */
	Board board;
	
	/**
	 * Creates a new instance of a BoardToBoardMove with the given parameters.
	 * @param level The level to complete the move on
	 * @param toCol The column of the destination square on the board
	 * @param toRow The row of the anchor square on the board
	 * @param fromCol The current column of the anchor square on the board
	 * @param fromRow The current row of the anchor square on the board
	 */
	public BoardToBoardMove(Level level, int toCol, int toRow, int fromCol, int fromRow) {
		super();
		this.board = level.getBoard();
		this.level = level;
		this.movingPiece = board.getPiece(fromCol, fromRow);	
		this.toCol = toCol;
		this.toRow = toRow;

		this.fromCol = fromCol;
		this.fromRow = fromRow;

		System.out.println("previous Col, Row: " + fromCol + ", " + fromRow);
	}

	/**
	 * Completes this instance of BoardToBoardMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	public boolean doMove() {
		// First check if the move is valid. Return false if invalid
		if (!isValid()) {
			return false;
		}

		// Add the piece at the specified location
		board.addPiece(movingPiece, toCol, toRow);

		// Remove the active piece stored in level, and signal to update
		level.removeActivePiece();
		// set end game status
		endGameStatus = level.updateAfterMove();
		return true;
	}

	/**
	 * Checks if this BoardToBoardMove is valid with the given parameters<br />
	 * -Valid if all squares inside the piece are not on an invalid squares and <br />
	 * -There are no pieces underneath the requested piece 
	 * @return True if this BoardToBoardMove is valid with the given parameters, false otherwise
	 */
	public boolean isValid() {
		// TODO add test for ReleaseLevel, etc.
		return level.getBoard().validPlacement(movingPiece, toCol, toRow);
	}

	/**
	 * Undoes this BoardToBoardMove.
	 * @return True if the move was undone successfully, false otherwise.
	 */
	public boolean undo() {
		// TODO see if a check is needed here
		//if (isValidUndo()) {
			board.removePiece(movingPiece);
			board.addPiece(movingPiece, fromCol, fromRow);
			
			System.out.println("Piece moves back to: " + toCol + ", " + toRow);
			System.out.println("Previous Col, Row: " + fromCol + ", " + fromRow);
			level.removeActivePiece();
			return true;
		//}
		//return false;
	}

	/**
	 * Determines if undoing this move is valid.
	 * @return True if the move can be undone, false if not.
	 */
	public boolean isValidUndo() {
		return level.getBoard().validPlacement(movingPiece, fromCol, fromRow);
	}
}