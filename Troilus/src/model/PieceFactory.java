package model;

import java.awt.Color;
import java.util.Random;

/**
 * This class is used as an interface to obtain pieces.
 * 
 * This class provides a layer of abstraction between the developer and the piece they receive. All
 * logic pertaining to the creation of pieces and their shape (relative coordinates) are defined in here,
 * to prevent definition elsewhere
 * @author Dan Alfred
 *
 */
public class PieceFactory {

	public static Piece getPiece(int pieceType) {
		PieceSquare anchorSquare = new PieceSquare(0, 0);
		PieceSquare[] pieceSquares = new PieceSquare[5];
		
		Random r = new Random();
		
		switch(pieceType) {
		case 1:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, 0);
			pieceSquares[2] = new PieceSquare(-3, 0);
			pieceSquares[3] = new PieceSquare(-4, 0);
			pieceSquares[4] = new PieceSquare(-5, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, Color.RED);
		case 2:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-3, 0);
			pieceSquares[4] = new PieceSquare(-4, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, Color.YELLOW);
		case 3:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-3, 0);
			pieceSquares[4] = new PieceSquare(-4, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 4:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-3, +1);
			pieceSquares[4] = new PieceSquare(-4, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 5:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(0, +2);
			pieceSquares[2] = new PieceSquare(-1, 0);
			pieceSquares[3] = new PieceSquare(-2, 0);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 6:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, +1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-3, 0);
			pieceSquares[4] = new PieceSquare(-4, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 7:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-2, -0);
			pieceSquares[4] = new PieceSquare(-3, -0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 8:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, 0);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-3, +1);
			pieceSquares[4] = new PieceSquare(-4, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 9:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-1, +2);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 10:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, 0);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 11:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, 0);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 12:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-2, +3);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 13:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-3, 0);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 14:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 15:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 16:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(0, +2);
			pieceSquares[2] = new PieceSquare(-1, 0);
			pieceSquares[3] = new PieceSquare(-1, +1);
			pieceSquares[4] = new PieceSquare(-2, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 17:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-3, +1);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 18:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 19:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 20:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 21:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-1, +2);
			pieceSquares[4] = new PieceSquare(-2, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 22:
			pieceSquares[0] = new PieceSquare(0, +2);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-1, +2);
			pieceSquares[4] = new PieceSquare(-2, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 23:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-1, +2);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 24:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-2, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 25:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(0, +2);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 26:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-1, +2);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 27:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-2, +2);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 28:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, +1);
			pieceSquares[3] = new PieceSquare(-3, +1);
			pieceSquares[4] = new PieceSquare(-3, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 29:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(0, +2);
			pieceSquares[2] = new PieceSquare(-1, 0);
			pieceSquares[3] = new PieceSquare(-1, +2);
			pieceSquares[4] = new PieceSquare(-2, +2);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 30:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, +0);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-3, 0);
			pieceSquares[4] = new PieceSquare(-3, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 31:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-2, 0);
			pieceSquares[4] = new PieceSquare(-2, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 32:
			pieceSquares[0] = new PieceSquare(0, +1);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-1, +2);
			pieceSquares[4] = new PieceSquare(-2, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 33:
			pieceSquares[0] = new PieceSquare(0, +2);
			pieceSquares[1] = new PieceSquare(-1, 0);
			pieceSquares[2] = new PieceSquare(-1, +1);
			pieceSquares[3] = new PieceSquare(-1, +2);
			pieceSquares[4] = new PieceSquare(-2, +1);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 34:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-1, +1);
			pieceSquares[2] = new PieceSquare(-2, -1);
			pieceSquares[3] = new PieceSquare(-2, 0);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		case 35:
			pieceSquares[0] = new PieceSquare(-1, 0);
			pieceSquares[1] = new PieceSquare(-2, -1);
			pieceSquares[2] = new PieceSquare(-2, 0);
			pieceSquares[3] = new PieceSquare(-2, +1);
			pieceSquares[4] = new PieceSquare(-3, 0);
			return new Piece(pieceSquares, anchorSquare, pieceType, new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		default:
			return null;
		}
	}
}