package model;

import java.awt.Color;
import java.util.Random;

/**
 * This class is used as an interface to obtain pieces.
 * 
 * This class provides a layer of abstraction between the developer and the piece they receive. All
 * logic pertaining to the creation of pieces and their shape (relative coordinates) are defined in here,
 * to prevent definition elsewhere.
 * @author Dan Alfred
 *
 */
public class PieceFactory {
	public static Piece getPiece(int pieceType) {
		PieceSquare anchorSquare = new PieceSquare(0, 0);
		PieceSquare[] pieceSquares = new PieceSquare[Piece.PIECE_SIZE - 1];

		switch(pieceType) {
		case 1:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(0, -2);
			pieceSquares[2] = new PieceSquare(0, -3);
			pieceSquares[3] = new PieceSquare(0, -4);
			pieceSquares[4] = new PieceSquare(0, -5);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 2:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(0, -3);
			pieceSquares[4] = new PieceSquare(0, -4);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 3:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(0, -3);
			pieceSquares[4] = new PieceSquare(0, -4);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 4:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+1, -3);
			pieceSquares[4] = new PieceSquare(+1, -4);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 5:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+2, 0);
			pieceSquares[2] = new PieceSquare(0, -1);
			pieceSquares[3] = new PieceSquare(0, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 6:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -2);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(0, -3);
			pieceSquares[4] = new PieceSquare(0, -4);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 7:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(0, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 8:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(0, -2);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+1, -3);
			pieceSquares[4] = new PieceSquare(+1, -4);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 9:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+2, -1);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+2, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 10:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(0, -2);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 11:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(0, -2);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 12:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+3, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 13:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(0, -3);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 14:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 15:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 16:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+2, 0);
			pieceSquares[2] = new PieceSquare(0, -1);
			pieceSquares[3] = new PieceSquare(+1, -1);
			pieceSquares[4] = new PieceSquare(0, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 17:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+1, -3);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 18:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+2, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 19:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 20:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+2, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 21:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+2, -1);
			pieceSquares[4] = new PieceSquare(0, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 22:
			pieceSquares[0] = new PieceSquare(+2, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+2, -1);
			pieceSquares[4] = new PieceSquare(0, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 23:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+2, -2);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 24:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(+2, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 25:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+2, 0);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 26:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+2, -2);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 27:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+2, -2);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 28:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(+1, -2);
			pieceSquares[3] = new PieceSquare(+1, -3);
			pieceSquares[4] = new PieceSquare(+2, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 29:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(+2, 0);
			pieceSquares[2] = new PieceSquare(0, -1);
			pieceSquares[3] = new PieceSquare(+2, -1);
			pieceSquares[4] = new PieceSquare(+2, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 30:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(0, -3);
			pieceSquares[4] = new PieceSquare(+1, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 31:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(0, -2);
			pieceSquares[4] = new PieceSquare(+1, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 32:
			pieceSquares[0] = new PieceSquare(+1, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+2, -1);
			pieceSquares[4] = new PieceSquare(+1, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 33:
			pieceSquares[0] = new PieceSquare(+2, 0);
			pieceSquares[1] = new PieceSquare(0, -1);
			pieceSquares[2] = new PieceSquare(+1, -1);
			pieceSquares[3] = new PieceSquare(+2, -1);
			pieceSquares[4] = new PieceSquare(+1, -2);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 34:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(+1, -1);
			pieceSquares[2] = new PieceSquare(-1, -2);
			pieceSquares[3] = new PieceSquare(0, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		case 35:
			pieceSquares[0] = new PieceSquare(0, -1);
			pieceSquares[1] = new PieceSquare(-1, -2);
			pieceSquares[2] = new PieceSquare(0, -2);
			pieceSquares[3] = new PieceSquare(+1, -2);
			pieceSquares[4] = new PieceSquare(0, -3);
			return new Piece(pieceSquares, anchorSquare, pieceType, getRandomColor());
		default:
			return null;
		}
	}

	private static Color getRandomColor(){
		Random rand = new Random();
		return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
}