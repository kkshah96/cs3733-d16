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
	Piece movingPiece;
	int col;
	int row;

	public BullpenToBoardMove(Level level, Piece movingPiece, int col, int row) {
		this.level = level;
		this.movingPiece = movingPiece;
		this.col = col;
		this.row = row;
	}

	/** Adds the piece to the Board if valid */
	public boolean doMove() {
		Bullpen bpen = level.getBullpen();
		Board board = level.getBoard();

		if (!isValid()) {
			return false;
		}

		board.addPiece(movingPiece, col, row);
		level.removeActivePiece();
		bpen.removePiece(movingPiece);

		level.updateAfterMove();
		return true;
	}

	/** Checks if adding a Piece from Bullpen to Board is valid */
	public boolean isValid() {
		// TODO: if level.canMakeMove()...
		return level.canMove() && level.getBoard().validPlacement(movingPiece, col, row);
	}

	//TODO: ADD UNDO
	public boolean undo() {
		return false;
	}
}