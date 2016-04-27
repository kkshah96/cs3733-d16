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
		// Bounds check
		if (row < 0 || row >= Board.BOARD_HEIGHT || col < 0 || col >= Board.BOARD_WIDTH) {
			System.out.println("Not in bounds");
			return false;
		}

		if (piece == null) {
			System.out.println("No piece");
			return false;
		}
		
		Piece getP = level.getBoard().getPiece(col, row);
		if (getP != null) {
			System.out.print("Overlapping piece at location: " + getP.getCol() + ", " + getP.getRow());
			return false;
		}
		
		if (!(level.getBoard().getSquare(col, row).isValid())) {
			System.out.println("Anchor square placed at disabled square");
			return false;
		}
		
		for (PieceSquare square : piece.getSquares()) {
			// check if each square is in board area
			int absRow = square.getRow() + row; 
			int absCol = square.getCol() + col;
			System.out.printf("Piece square is at (%d,%d)", absCol, absRow);

			if (!(absRow < Board.BOARD_HEIGHT && absRow >= 0 && absCol < Board.BOARD_WIDTH && absCol >= 0)) {
				System.out.println("Out of bounds");
				return false;
			}
			
			// Check if each square is in bounds
			if (!level.getBoard().getSquare(absCol, absRow).isValid()) {
				System.out.printf("Not in bounds (%d, %d)\n", absCol, absRow);
				return false;
			}

			// Check for overlapping pieces
			if (level.getBoard().getPiece(absCol, absRow) != null) {
				System.out.println("Overlapping pieces");
				return false;
			}	
		}
		
		return true;
	}

	//TODO: ADD UNDO
	public boolean undo() {
		return false;
	}
}