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
	Square[][] squares; // uses squares[row][col]
	
	/** An ArrayList of Piece to hold references to pieces on the board. */
	//ArrayList<Piece> pieces;
	/** Pieces on the Board, where Point holds (row, col) */
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
		if(squares[0].length > BOARD_HEIGHT || squares.length > BOARD_WIDTH) {
			throw new RuntimeException("Board Constructor exception: 2D array of Squares provided to Board exceeds max size of board!");
		} else {
			this.squares = squares;
			this.pieces = new Hashtable<Piece, Point>();
		}
	}
	
	/**
	 * Sets the currently active square on this board for events
	 * @param row Row of the square selected
	 * @param col Column of the square selected
	 */
	public void setActiveSquare(int row, int col) {
		this.activeSquare = squares[row][col];
	}
	
	/**
	 * Returns the active square of this board
	 * @return Reference to active Square object
	 */
	public Square getActiveSquare() {
		return activeSquare;
	}
	
	/** Add the given piece to the board if valid
	 * @param p Piece to be added
	 * @param row Requested row for the piece anchor
	 * @param col Requested column for the piece anchor
	 * @return Returns true if piece was added successfully, false otherwise
	 */
	public boolean addPiece(Piece p, int row, int col) {
		// Ensure the anchor is not trying to be placed outside the board
		if (row < 0 || row >= BOARD_HEIGHT || col < 0 || col >= BOARD_WIDTH) {
			System.out.println("Not in bounds");
			return false;
		}
		
		for (PieceSquare square : p.squares) {
			// check if each square is in bounds
			int absRow = square.row + col; // TODO: HOUSTON WE FUCKED UP THE COORDINATE SYSTEM
			int absCol = square.col + row;

			if (!(absRow < BOARD_HEIGHT && absRow >= 0 && absCol < BOARD_WIDTH && absCol >= 0)) {
				return false;
			}
			
			if (!squares[absRow][absCol].isValid()) {
				System.out.println("Not in bounds");
				return false;
			}
			
			if (getPiece(absRow, absCol) != null) {
				System.out.println("Overlapping pieces");
				return false;
			}	
		}
		
		this.pieces.put(p, new Point(row, col));
		return true;
	}

	/** Remove the given piece from the board and return it
	 * @param p The piece to be removed
	 */
	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	/** Find the Piece at the given location (don't change) //TODO: Sorry I changed this
	 * WARNING: Returns NULL if not on board
	 * WARNING: Coordinates are fucked up.
	 * @param row The 
	 * @param col
	 * @return
	 */
	 public Piece getPiece(int row, int col) {
		if (row >= Board.BOARD_HEIGHT || row < 0 || col >= Board.BOARD_WIDTH || col < 0) {
			return null;
		}
				
		Set<Piece> keySet = pieces.keySet();
		for (Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			int anchorCol = anchorPoint.x;
			int anchorRow = anchorPoint.y;
			
			System.out.println(anchorPoint);
			
			if (anchorCol == col && anchorRow == row) {
				return piece;
			}
			
			for (Square square : piece.getSquares()) {
				System.out.println(anchorRow + square.getRow() + " Row");
				System.out.println(anchorCol + square.getCol() + " Col");
				if (square.getRow() + anchorRow == row && square.getCol() + anchorCol == col) {
					return piece;
				}
			}
		}
		
		return null;
	}

	/** Find the Square at the given location (don't change)
	 * WARNING: Returns NULL if not on board
	 * @param row Row of the requested square
	 * @param col Column of the requested square
	 * @return Returns a reference to the requested square
	 */
	public Square getSquare(int row, int col) {
		if (row >= BOARD_HEIGHT || row < 0 || col >= BOARD_WIDTH || col < 0) {
			return null;
		}
		return squares[row][col];
	}
	
	/**
	 * Resets the dimensions and squares inside the board.
	 * Will throw a RuntimeException if the sizes given are greater than max size.
	 * <p>
	 * @param rows Size
	 * @param cols
	 */
	public void setDimensions(int rows, int cols) {
		for (int row = 0; row < BOARD_HEIGHT; row++) {
			for (int column = 0; column < BOARD_WIDTH; column++) {
				boolean valid = (row < rows) && (column < cols);
				squares[row][column].setIsValid(valid);
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
		//activeSquare = null; // TODO We don't want to do this, do we?
	}
	
	/** Returns the currently-set height for LevelEditorView */
	//public int getRows(){
		//return this.currentHeight;
	//}
	
	/** Returns the currently-set width for LevelEditorView */
	//public int getCols(){
		//return this.currentWidth;
	//}
}