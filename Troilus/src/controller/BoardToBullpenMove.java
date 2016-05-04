package controller;

import model.Board;
import model.Piece;
import model.Bullpen;
import model.Level;

/**
 * Class for implementation of removing a piece from the board back to the bullpen.
 * @author Maddy Longo
 * @author Connor Weeks
 * @author Kunal Shah
 *
 */
public class BoardToBullpenMove extends Move{
	/** The level modified in this move. */
	Level level;

	/** The piece utilized during this move. */
	Piece piece;

	/** The board destination used during this move. */
	Board board;

	/** The bullpen source used during this move. */
	Bullpen bpen;

	/** The column of the source square on the board. */
	int col;

	/** The row of the source square on the board. */
	int row;

	/**
	 * Creates an instance of a BoardToBullpenMove with the specified parameters.
	 * @param level The level to be modified during the move.
	 * @param col The column of the source square on the board.
	 * @param row The row of the source square on the board.
	 */
	public BoardToBullpenMove(Level level, int col, int row) {
		this.board = level.getBoard();
		this.bpen = level.getBullpen();
		this.piece = board.getPiece(col, row);
		this.level = level;
		if (board.getPiece(col, row) != null) {
			this.row = board.getPieces().get(board.getPiece(col, row)).y;
			this.col = board.getPieces().get(board.getPiece(col, row)).x;
		}
	}

	/**
	 * Creates an instance of a BoardToBullpenMove with the specified parameters.
	 * @param level The level to be modified during the move.
	 * @param p The piece to be moved.
	 */
	public BoardToBullpenMove(Level level, Piece p){
		this.board = level.getBoard();
		this.bpen = level.getBullpen();
		this.piece = p;
		this.level = level;
		if (board.getPieces().containsKey(p)) {
			this.row = board.getPieces().get(p).y;
			this.col = board.getPieces().get(p).x;
		}
	}

	/**
	 * Completes this BoardToBullpenMove.
	 * @return True if the move is completed successfully, false otherwise.
	 */
	public boolean doMove() {
		// First check if the move is valid. If not, return false.
		if (!isValid()) {
			return false;
		}

		// Remove the requested piece from the board and add it to the bullpen
		bpen.addPiece(board.removePiece(piece));

		// Remove the active piece reference in level and signal to refresh
		level.removeActivePiece();
		// update and set status
		endGameStatus = level.updateAfterMove();
		return true;
	}

	/**
	 * Checks if this BoardToBullpenMove is valid:
	 * Valid if the piece selected is not null.
	 * @return True if the move is valid, false otherwise.
	 */
	public boolean isValid() {
		return (piece != null) && (board.getPieces().containsKey(piece)) && (!(bpen.getPieces().contains(piece)));
	}

	/**
	 * Undoes this move and reverts to prior state.
	 * @return True if completed successfully, false otherwise.
	 */
	public boolean undo() {
		// TODO see if a check is needed here
		System.out.println(row + " " + col);
		//if (level.getBoard().validPlacement(piece, col, row)) {
		level.getBoard().addPiece(piece, col, row);
		level.removeActivePiece();
		bpen.removePiece(piece);
		return true;
		//}
		//return false;
	}
}