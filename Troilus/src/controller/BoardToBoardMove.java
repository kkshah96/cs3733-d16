package controller;

import model.Board;
import model.Level;
import model.Piece;
import view.BoardView;

/**
 * 
 * THIS NEEDS TO BE FINISHED!
 * @author Alex Kasparek
 * @author Maddy
 *
 */
public class BoardToBoardMove {
	Level level;
	Piece movingPiece;
	int col;
	int row;

	public BoardToBoardMove(Level level, Piece movingPiece, int col, int row) {
		this.level = level;
		this.movingPiece = movingPiece;	
		this.col = col;
		this.row = row;
	}

	public boolean doMove() {
		if (!isValid(movingPiece, col, row)) {
			System.out.println("Invalid move!");
			return false;
		}
		
		Board board  = level.getBoard();

		board.removePiece(movingPiece);
		board.addPiece(movingPiece, col, row);

		level.removeActivePiece();
		return true;
	}

	public boolean isValid(Piece piece, int col, int row) {
		// TODO: if level.canMakeMove()...
		return level.getBoard().validPlacement(piece, col, row);
	}

	//TODO: ADD UNDO
	public boolean undo() {
		return false;
	}
}