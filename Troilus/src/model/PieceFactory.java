package model;

public class PieceFactory {
	
	public static Piece getPiece(int row, int col, int pieceType) {
		Square anchorSquare = new PieceSquare(row, col);
		Square[] pieceSquares = new Square[5];
		
		switch(pieceType) {
			case 1:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 2:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row+1, col+1);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 3:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 4:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 5:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 6:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 7:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 8:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 9:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 10:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 11:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 12:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 13:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 14:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 15:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 16:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 17:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 18:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 19:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 20:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 21:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 22:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 23:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 24:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 25:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 26:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 27:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 28:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 29:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 30:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 31:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 32:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 33:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 34:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			case 35:
				pieceSquares[0] = new PieceSquare(row, col+1);
				pieceSquares[1] = new PieceSquare(row, col+2);
				pieceSquares[2] = new PieceSquare(row, col-1);
				pieceSquares[3] = new PieceSquare(row, col-2);
				pieceSquares[4] = new PieceSquare(row, col-3);
				return new Piece(pieceSquares, anchorSquare);
			default:
				return null;
			}
	}
	
}
