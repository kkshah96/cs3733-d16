package controller;

import model.Board;
import model.Piece;
import model.Bullpen;
import model.Level;

/**
 * Class for implemenation of removing a piece from the board.
 * @author Maddy
 *
 */
public class BoardToBullpenMove {
	Level level;
	Piece movingPiece;
	Board board;
	Bullpen bpen;
	int col;
	int row;
	
	public BoardToBullpenMove(Level level, int col, int row) {
		this.board = level.getBoard();
		this.bpen = level.getBullpen();
		this.movingPiece = board.getPiece(col, row);
		this.level = level;
	}
	
	public boolean doMove() {
		if (!isValid()) {
			return false;
		}
		
		bpen.addPiece(board.removePiece(movingPiece));
		
		level.removeActivePiece();
		level.updateAfterMove();
		return true;
	}
	
	public boolean isValid() {
		return movingPiece != null;
	}
	
	public boolean undo() {
		// TODO implement undo()
		return false;
	}
}