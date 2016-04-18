package model;

public class PieceFactory {

	public static Piece getPiece(int row, int col, int pieceType) {
		PieceSquare anchorSquare = new PieceSquare(row, col);
		PieceSquare[] pieceSquares = new PieceSquare[5];

		switch(pieceType) {
		case 1:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 2:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row+1, col+1);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 3:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 4:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 5:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 6:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 7:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 8:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 9:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 10:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 11:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 12:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 13:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 14:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 15:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 16:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 17:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 18:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 19:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 20:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 21:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 22:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 23:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 24:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 25:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 26:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 27:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 28:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 29:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 30:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 31:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 32:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 33:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 34:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		case 35:
			pieceSquares[0] = new PieceSquare(row, col+1);
			pieceSquares[1] = new PieceSquare(row, col+2);
			pieceSquares[2] = new PieceSquare(row, col-1);
			pieceSquares[3] = new PieceSquare(row, col-2);
			pieceSquares[4] = new PieceSquare(row, col-3);
			return new Piece(pieceSquares, anchorSquare, pieceType);
		default:
			return null;
		}
	}
}