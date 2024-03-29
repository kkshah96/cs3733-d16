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

	/** The 2D array of squares that compose the board. Access with squares[col][row]. */
	Square[][] squares;

	/** Pieces on the Board, where Point holds (col, row) */
	Hashtable<Piece, Point> pieces;

	/** A reference to a square that has been clicked. */
	Square activeSquare;

	/**
	 * Constructor for the board to take in a predefined 2D array of squares.
	 * Will throw a RuntimeException if the number of rows or number of columns in
	 * the 2D array exceeds max board size.
	 * @param squares 2D array of squares for the board.
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
	 * Sets the currently active square on this board for events.
	 * @param col Column of the square selected.
	 * @param row Row of the square selected.
	 */
	public void setActiveSquare(int col, int row) {
		if (col < 0 || col >= Board.BOARD_WIDTH || row < 0 || row >= Board.BOARD_HEIGHT) {
			return;
		}
		this.activeSquare = squares[col][row];
	}

	/**
	 * Returns the active square of this board.
	 * @return Reference to active Square object.
	 */
	public Square getActiveSquare() {
		return activeSquare;
	}

	/** Add the given piece to the board.
	 * @param p Piece to be added.
	 * @param col Requested column for the piece anchor.
	 * @param row Requested row for the piece anchor.
	 * @return Returns true if piece was added successfully, false otherwise.
	 */
	public boolean addPiece(Piece p, int col, int row) {
		this.pieces.put(p, new Point(col, row));
		return true;
	}

	/**
	 * Checks if a given piece can be placed at a provided location on the board.
	 * @param piece The piece to check placement of.
	 * @param col The column of the square on the board to check.
	 * @param row The row of the square on the board to check.
	 * @return True if the piece can be placed, false otherwise.
	 */
	public boolean validPlacement(Piece piece, int col, int row) {
		// Bounds check
		if (row < 0 || row >= Board.BOARD_HEIGHT || col < 0 || col >= Board.BOARD_WIDTH) {
			return false;
		}

		// Check if the piece provided is null, cannot proceed if it is
		if (piece == null) {
			return false;
		}

		// Check if there is already a piece at the requested location- cannot place if so
		Piece getP = getPiece(col, row);
		if (getP != null && getP != piece) {
			return false;
		}

		for (PieceSquare square : piece.getAllSquares()) {
			// check if each square is in board area
			int absRow = square.getRow() + row; 
			int absCol = square.getCol() + col;

			// Ensure each square of the piece is within the bounds
			if (!(absRow < Board.BOARD_HEIGHT && absRow >= 0 && absCol < Board.BOARD_WIDTH && absCol >= 0)) {
				return false;
			}

			// Check if each board square is valid
			if (!getSquare(absCol, absRow).isValid()) {
				return false;
			}

			// Check for overlapping pieces (and ensure not same piece instance)
			if (getPiece(absCol, absRow) != null && getPiece(absCol, absRow) != piece) {
				return false;
			}	
		}

		return true;
	}

	/** Remove the given piece from the board and return it.
	 * @param p The piece to be removed.
	 * @return Returns this piece removed, if any
	 */
	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	/** Find the Piece at the given location, using (col, row).
	 * WARNING: Returns NULL if not on board.
	 * @param col Requested column.
	 * @param row Requested row.
	 * @return The piece at the requested location if present, or null if no piece at location.
	 */
	public Piece getPiece(int col, int row) {
		// Bounds check
		if (row >= Board.BOARD_HEIGHT || row < 0 || col >= Board.BOARD_WIDTH || col < 0) {
			return null;
		}

		// Convert map of pieces to list, and iterate through each
		Set<Piece> keySet = pieces.keySet();
		for (Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			int anchorCol = anchorPoint.x;
			int anchorRow = anchorPoint.y;

			// If any of the piece squares are at the provided row & col, return the piece
			for (Square square : piece.getAllSquares()) {
				if ((square.getRow() + anchorRow == row) && (square.getCol() + anchorCol == col)) {
					return piece;
				}
			}
		}

		// Otherwise no piece, return null
		return null;
	}

	/** Find the Square at the given location (using col, row).
	 * WARNING: Returns NULL if not on board.
	 * @param col Column of the requested square.
	 * @param row Row of the requested square.
	 * @return Returns a reference to the requested square.
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
	 * @param cols Number of columns to utilize.
	 * @param rows Number of rows to utilize.
	 */
	public void setDimensions(int cols, int rows) {
		// Check for bounds of cols, rows before proceeding
		if(cols > BOARD_WIDTH || rows > BOARD_HEIGHT || cols < 0 || rows < 0) {
			throw new RuntimeException("Invalid dimensions for resizing board!");
		}

		// Otherwise, loop through rows and columns, and reset the square validity
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int column = 0; column < BOARD_WIDTH; column++) {
				boolean valid = (row < rows) && (column < cols);
				squares[column][row].setIsValid(valid);
				squares[column][row].setIsHint(false);
			}
		}
	}

	/**
	 * Retrieves the listing of pieces on this board.
	 * Point uses (col, row).
	 * @return Hashtable of Piece for this board
	 */
	public Hashtable<Piece, Point> getPieces() {
		return this.pieces;
	}

	/**
	 * Toggles the validity of the active square for this board.
	 */
	public void toggleActiveSquare() {
		// make sure an active square exists
		if (activeSquare == null) {
			return;
		}
		activeSquare.toggleIsValid();
	}

	/** 
	 * Toggle hint status of active square for this board, if applicable 
	 */
	public void toggleHint() {
		// Make sure active square exists
		if (activeSquare == null) {
			return;
		}
		activeSquare.toggleHint();
	}
}