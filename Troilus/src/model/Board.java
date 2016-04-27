package model;

import java.awt.Point;
import java.util.Hashtable;
import java.util.Set;

/**
 * Class allows for storage and manipulation of Board structure.
 * 
 * Allows for implementation of the board in Kabasuji. The board is made up of a set
 * number of Squares, which can be in-bounds or out-of-bounds, and has Pieces at
 * locations within the board. This class provides methods to interact with the
 * board and the pieces on it.
 * 
 * @author Maddy Longo
 * @author Dan Alfred
 * @author Kunal Shah
 * @author Connor Weeks
 */
public class Board {
	/** Constant denoting the maximum width of the board. */
	public static final int BOARD_WIDTH = 12;

	/** Constant denoting the maximum height of the board. */
	public static final int BOARD_HEIGHT = 12;

	/** The 2D array of squares that compose the board. */
	Square[][] squares; // uses squares[col][row]
	
	/** Pieces on the Board, where Point holds (col, row) */
	Hashtable<Piece, Point> pieces;

	/** A reference to a square that has been clicked. */
	Square activeSquare;

	/** Holds a reference to a dragged piece */
	//Piece draggedPiece = null;

	/**
	 * Constructor for the board to take in a predefined 2D array of squares
	 * Will throw a RuntimeException if the number of rows or number of columns in the 2D array exceeds max board size
	 * @param squares 2D array of squares for the board
	 */
	public Board(Square[][] squares) {
		if (squares[0].length > BOARD_WIDTH || squares.length > BOARD_HEIGHT) {
			throw new RuntimeException("Board Constructor exception: 2D array of Squares provided to Board exceeds max size of board!");
		} else {
			this.squares = squares;
			this.pieces = new Hashtable<Piece, Point>();
		}
	}

	/**
	 * Sets the currently active square on this board for events
	 * @param col Column of the square selected
	 * @param row Row of the square selected
	 */
	public void setActiveSquare(int col, int row) {
		this.activeSquare = squares[col][row];
	}

	/**
	 * Returns the active square of this board
	 * @return Reference to active Square object
	 */
	public Square getActiveSquare() {
		return activeSquare;
	}

	/** Add the given piece to the board
	 * @param p Piece to be added
	 * @param col Requested column for the piece anchor
	 * @param row Requested row for the piece anchor
	 * @return Returns true if piece was added successfully, false otherwise
	 */
	public boolean addPiece(Piece p, int col, int row) {
		this.pieces.put(p, new Point(col, row));
		return true;
	}

	/** Remove the given piece from the board and return it
	 * @param p The piece to be removed
	 */
	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	/** Find the Piece at the given location (leave Piece unchanged)
	 * WARNING: Returns NULL if not on board
	 * @param col Requested column
	 * @param row Requested row
	 * @return
	 */
	public Piece getPiece(int col, int row) {
		// Bounds check
		if (row >= Board.BOARD_HEIGHT || row < 0 || col >= Board.BOARD_WIDTH || col < 0) {
			return null;
		}

		Set<Piece> keySet = pieces.keySet();
		for (Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			int anchorCol = anchorPoint.x;
			int anchorRow = anchorPoint.y;

			if (anchorCol == col && anchorRow == row) {
				return piece;
			}

			for (Square square : piece.getSquares()) {
				if ((square.getRow() + anchorRow == row) && (square.getCol() + anchorCol == col)) {
					return piece;
				}
			}
		}

		return null;
	}

	/** Find the Square at the given location (don't change).
	 * WARNING: Returns NULL if not on board.
	 * @param col Column of the requested square
	 * @param row Row of the requested square
	 * @return Returns a reference to the requested square
	 */
	public Square getSquare(int col, int row) {
		// Bounds check
		if (row >= BOARD_HEIGHT || row < 0 || col >= BOARD_WIDTH || col < 0) {
			return null;
		}

		return squares[col][row];
	}

	/**
	 * Resets the dimensions and squares inside the board.
	 * Will throw a RuntimeException if the sizes given are greater than max size.
	 * <p>
	 * @param cols
	 * @param rows Size
	 */
	public void setDimensions(int cols, int rows) {
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int column = 0; column < BOARD_WIDTH; column++) {
				boolean valid = (row < rows) && (column < cols);
				squares[column][row].setIsValid(valid);
			}
		}
	}

	/**
	 * Retrieves the listing of pieces on this board.
	 * Point uses (row, col).
	 * @return Hashtable of Piece for this board
	 */
	public Hashtable<Piece, Point> getPieces() {
		return this.pieces;
	}

	/**
	 * Toggles the validity of the active square for this board
	 */
	public void toggleActiveSquare() {
		// make sure an active square exists
		if (activeSquare == null) {
			return;
		}

		activeSquare.isValid = !activeSquare.isValid;
	}
}