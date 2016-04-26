package model;

import java.awt.Color;

/**
 * Class allows for storage and manipulation of Piece structure.
 * 
 * Allows for implementation of pieces for Kabasuji. Each piece has an anchor square, and 5 additional squares
 * to create the "hexomino" relationship. These squares hold relative locations to the anchor square. This class
 * provides methods to allow interactions with pieces.
 * 
 * @author Dan Alfred
 * @author Maddy Longo
 * @author Kunal Shah
 *
 */
public class Piece {
	/** Constant to denote Piece size (number of squares) */
	public static final int PIECE_SIZE = 6;
	
	/** A constant provided to indicate a CCW rotation is requested. */
	public static final int ROTATE_CCW = -1;
	
	/** A constant provided to indicate a CW rotation is requested. */
	public static final int ROTATE_CW = 1;
	
	/** A constant provided to indicate a horizontal flip is requested. */
	public static final int FLIP_HORIZONTALLY = -2;
	
	/** A constant provided to indicate a vertical flip is requested. */
	public static final int FLIP_VERTICALLY = 2;
	
	/** The squares of the piece, not including anchor */
	PieceSquare[] squares;
	
	/** The anchor square of the piece */
	PieceSquare anchor;
	
	/** The color of the selected piece */
	Color color;
	
	/** An int representation of the piece type, from 1-35 */
	int type;
	
	public Piece(PieceSquare[] squares, PieceSquare anchor, int type, Color c) {
		this.squares = squares;
		this.anchor = anchor;
		this.type = type;
		this.color = c;
		
		if(squares.length != PIECE_SIZE - 1) {
			throw new RuntimeException("Piece [" + type + "] must have an array of " + PIECE_SIZE + " squares. " + squares.length + " were passed in.");
		}
	}
	
	/**
	 * Returns int representation of anchor square's row.
	 * @return Row of the anchor square
	 */
	public int getRow() {
		return anchor.row;
	}
	
	/**
	 * Returns int representation of anchor square's col.
	 * @return Col of the anchor square
	 */
	public int getCol() {
		return anchor.col;
	}
	
	/**
	 * Provides the array of squares of a piece, not including the anchor square.
	 * @return Array of piece squares
	 */
	public PieceSquare[] getSquares() {
		return squares;
	}
	
	/**
	 * Provides a reference to the anchor square.
	 * @return The anchor square
	 */
	public PieceSquare getAnchor() {
		return anchor;
	}
	
	/**
	 * Returns the int representation of the piece's type.
	 * @return int from 1-35 indicating piece type
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Returns this piece rotated either CCW or CW, or not rotated if given invalid input.
	 * @param direction Must be Piece.ROTATE_CW or Piece.ROTATE_CCW
	 * @return Returns newly rotated piece, or this if given an invalid input
	 */
	public Piece rotatePiece(int direction){ //CCW: degree < 0
		PieceSquare[] newSquares = new PieceSquare[5];

		for (int i = 0; i < PIECE_SIZE - 1; i++) {
			if(direction == Piece.ROTATE_CCW){ //ROTATE CCW
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();
				
				PieceSquare newSquare = new PieceSquare((-1) * oldCol, oldRow);
				newSquares[i] = newSquare;
			} else if(direction == Piece.ROTATE_CW){ //ROTATE CW
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();

				PieceSquare newSquare = new PieceSquare(oldCol, (-1) * oldRow);
				newSquares[i] = newSquare;
			} else {
				return this;
			}
		}
		
		return new Piece(newSquares, anchor, type, color); // TODO: Implement this
	}
	
	
	/**
	 * Returns this piece flipped either horizontally or vertically, or not flipped if given invalid input.
	 * @param direction Must be Piece.FLIP_HORIZONTALLY or Piece.FLIP_VERTICALLY
	 * @return Returns newly flipped piece, or this if given an invalid input
	 */
	public Piece flipPiece(int direction){
		PieceSquare[] newSquares = new PieceSquare[5];
		
		for (int i = 0; i < PIECE_SIZE - 1; i++) {
			if(direction == Piece.FLIP_HORIZONTALLY){ // FLIP HORIZONTAL
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();

				PieceSquare newSquare = new PieceSquare(oldRow, (-1) * oldCol);
				newSquares[i] = newSquare;
			} else if(direction == Piece.FLIP_VERTICALLY){ //FLIP VERTICAL
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();

				PieceSquare newSquare = new PieceSquare((-1) * oldRow, oldCol);
				newSquares[i] = newSquare;
			} else {
				return this;
			}
		}
		
		return new Piece(newSquares, anchor, type, color); // TODO: Implement this
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
}