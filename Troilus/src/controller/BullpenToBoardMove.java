package controller;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;
import model.PieceSquare;
import view.BoardView;

public class BullpenToBoardMove {
	Level level;
	Piece pieceMoved;
	int x;
	int y;

	public BullpenToBoardMove(Level level, Piece pieceMoved, int x, int y){
		this.level = level;
		this.pieceMoved = pieceMoved;
		this.x = x;
		this.y = y;
	}

	/** Adds the piece to the Board if valid */
	public boolean doMove() {
		Bullpen bpen = level.getBullpen();
		Board board = level.getBoard();

		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		int row = (y - BoardView.SQUARE_SIZE)/BoardView.SQUARE_SIZE;
		if (!isValid(pieceMoved, col, row)) {
			return false;
		}

		boolean status = board.addPiece(pieceMoved, col, row);

		if (status) {
			board.addPiece(pieceMoved, col, row);
			level.removeActivePiece();
			bpen.removePiece(pieceMoved);
		}

		return status;
	}

	/** Checks if adding a Piece from Bullpen to Board is valid */
	public boolean isValid(Piece piece, int col, int row) {
		// TODO: if level.canMakeMove()...
		return level.getBoard().validPlacement(piece, col, row);
	}

	//TODO: ADD UNDO
	public boolean undo() {
		return false;
	}
}