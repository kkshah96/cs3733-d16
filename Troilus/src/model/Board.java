package model;

import java.util.ArrayList;

/**
 * Class allows for storage and manipulation of Board structure.
 * 
 * Allows for implemenation of the board in Kabasuji. The board is made up of a set
 * number of Squares, which can be in-bounds or out-of-bounds, and has Pieces at
 * locations within the board. This class provides methods to interact with the
 * board and the pieces on it.
 * 
 * @author Maddy Longo
 *
 */
public class Board {
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;

	Square[][] squares; // uses squares[row][col]
	ArrayList<Piece> pieces;

	// TODO: Is there any case where we will need to pass parameters to the constructor?
	// Yes- when loading a board from storage, where we will need to set the squares accordingly
	public Board() {
		squares = new Square[BOARD_HEIGHT][BOARD_WIDTH];
		pieces = new ArrayList<Piece>();
	}
	
	public Board(int rows, int cols, Square squareType) {
		if (rows > BOARD_HEIGHT || cols > BOARD_WIDTH) {
			//return; // Should this check be here?
		}
		for (int i = 0; i < BOARD_HEIGHT; i++) {
			for (int j = 0; j < BOARD_WIDTH; j++) {
				if (i < rows && j < cols) {
					//squares[i][j] = (Square) squareType.clone();
				} else {
					squares[i][j] = new OutOfBoundsSquare();
				}
			}
		}
	}

	public Board(Square[][] squares) {
		this.squares = squares;
		this.pieces = new ArrayList<Piece>();
	}

	/** Add the given piece to the board if valid
	 * Return true if valid, false if invalid
	 * @param p
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean addPiece(Piece p, int row, int col) {
		if (row < 0 || row >= BOARD_HEIGHT || col < 0 || col >= BOARD_WIDTH) {
			return false;
		}
		
		for (PieceSquare square : p.squares) {
			// check if each square is in bounds
			int absRow = square.row + row;
			int absCol = square.col + col;
			if (!(absRow < BOARD_HEIGHT && absRow >= 0 && absCol < BOARD_WIDTH && absCol >= 0)) {
				if (!squares[absRow][absCol].isValid()) {
					return false;
				}
			}
		}

		this.pieces.add(p.place(row, col));
		return true;
	}

	/** Remove the given piece from the board and return it
	 * @param p
	 */
	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	/** Find the Piece at the given location (don't change)
	 * WARNING: Returns NULL if not on board
	 * @param row
	 * @param col
	 * @return
	 */
	public Piece getPiece(int row, int col) {
		if (row > 11 || row < 0 || col > 11 || col < 0) {
			return null;
		}
		for (Piece piece : pieces) {
			if (piece.overlaps(row,col)) {
				return piece;
			}
		}
		
		return null;
	}

	/** Find the Square at the given location (don't change)
	 * WARNING: Returns NULL if not on board
	 * @param row
	 * @param col
	 * @return
	 */
	public Square getSquare(int row, int col) {
		if (row >= BOARD_HEIGHT || row < 0 || col >= BOARD_WIDTH || col < 0) {
			return null;
		}
		return squares[row][col];
	}
	
	public void setDimensions(int rows, int cols){
		squares = new Square[rows][cols];
	}
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public void toggleSquareOff(int row, int col){
		squares[row][col] = new OutOfBoundsSquare();
	}
	
	//TODO: Fix this method:
	public void toggleSquareOn(int row, int col){
		squares[row][col] = new PuzzleSquare(); // TODO HOW DO WE DETERMINE WHICH TYPE OF SQUARE IT IS?
	}
	
}