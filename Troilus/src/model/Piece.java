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
	
	/**
	 * Creates a new instance of Piece with the following parameters:
	 * @param squares 2D array of PieceSquares containing a relative row and column
	 * @param anchor Reference to the anchor square for this piece
	 * @param type Int representation of the type of this piece (1-35)
	 * @param c The color for this piece
	 */
	public Piece(PieceSquare[] squares, PieceSquare anchor, int type, Color c) {
		this.squares = squares;
		this.anchor = anchor;
		this.type = type;
		this.color = c;
		
		// Ensure the number of PieceSquares passed in is proper
		if(squares.length != PIECE_SIZE - 1) {
			throw new RuntimeException("Piece [" + type + "] must have an array of " + PIECE_SIZE + " squares. " + squares.length + " were passed in.");
		}
	}
	
	/**
	 * Returns int representation of anchor square's row.
	 * @return Row of the anchor square
	 */
	public int getRow() {
		return anchor.getRow();
	}
	
	/**
	 * Returns int representation of anchor square's col.
	 * @return Col of the anchor square
	 */
	public int getCol() {
		return anchor.getCol();
	}
	
	// TODO fix logic here
	/** Creates an array containing all piecesquares in this piece, including the anchor
	 * @return Array of PieceSquares, including the anchor square
	 */
	public PieceSquare[] getAllSquares() {
		PieceSquare[] allSquares = new PieceSquare[PIECE_SIZE];
		allSquares[0] = anchor;
		allSquares[1] = squares[0];
		allSquares[2] = squares[1];
		allSquares[3] = squares[2];
		allSquares[4] = squares[3];
		allSquares[5] = squares[4];
		return allSquares;
	}
	
	/**
	 * Provides the array of squares of a piece, not including the anchor square.
	 * @return Array of piece squares, NOT including anchor.
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
				
				PieceSquare newSquare = new PieceSquare(oldRow, (-1) * oldCol);
				newSquares[i] = newSquare;
			} else if(direction == Piece.ROTATE_CW){ //ROTATE CW
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();

				PieceSquare newSquare = new PieceSquare((-1) * oldRow, oldCol);
				newSquares[i] = newSquare;
			} else {
				// If an invalid rotation degree was provided, just return this
				return this;
			}
		}
		
		return new Piece(newSquares, anchor, type, color); 
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

				PieceSquare newSquare = new PieceSquare((-1) * oldCol, oldRow);
				newSquares[i] = newSquare;
			} else if(direction == Piece.FLIP_VERTICALLY){ //FLIP VERTICAL
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();

				PieceSquare newSquare = new PieceSquare(oldCol, (-1) * oldRow);
				newSquares[i] = newSquare;
			} else {
				// If an invalid flip direction was provided, just return this
				return this;
			}
		}
		
		return new Piece(newSquares, anchor, type, color);
	}
	
	/**
	 * Determines if this piece is the same shape as another provided piece <br />
	 * Any identical pieces that have been rotated/flipped are no longer considered the same shape
	 * @param other The piece to compare shape with this
	 * @return True if the shape is the same, false otherwise
	 */
	public boolean sameShape(Piece other) {
		// First ensure that the types of the two pieces are the same- if not, they're definitely different shapes
		if (type != other.type) {
			return false;
		}
		
		// Loop through each square in both pieces to ensure the relative coordinates match
		for (int i = 0; i < PIECE_SIZE - 1; i++) {
			int row = squares[i].getRow();
			int col = squares[i].getCol();
			int otherRow = other.squares[i].getRow();
			int otherCol = other.squares[i].getCol();
			
			// Any irregularities means the pieces are different
			if (!(row == otherRow && col == otherCol)) {
				return false;
			}
		}
		
		// No irregularities mean the pieces are the same shape
		return true;
	}
	
	/**
	 * Determines the color of this piece
	 * @return AWT Color object representing the color of this piece
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Updates the color of this piece
	 * @param c AWT Color object representing the new color
	 */
	public void setColor(Color c) {
		this.color = c;
	}
}