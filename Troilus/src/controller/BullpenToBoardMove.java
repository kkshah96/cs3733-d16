package controller;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;

/** 
 * Class for implementation of moving a piece from board to bullpen
 * @author Maddy
 * @author Someone Else
 */
public class BullpenToBoardMove {
	Level level;
	Piece pieceMoved;
	int col;
	int row;

	public BullpenToBoardMove(Level level, Piece pieceMoved, int col, int row) {
		this.level = level;
		this.pieceMoved = pieceMoved;
		this.col = col;
		this.row = row;
	}

	/** Adds the piece to the Board if valid */
	public boolean doMove() {
		Bullpen bpen = level.getBullpen();
		Board board = level.getBoard();

		if (!isValid(pieceMoved, col, row)) {
			return false;
		}

		board.addPiece(pieceMoved, col, row);
		level.removeActivePiece();
		bpen.removePiece(pieceMoved);

		level.updateAfterMove();
		return true;
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