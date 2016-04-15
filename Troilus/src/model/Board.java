package model;

import java.util.ArrayList;

public class Board {
	public static final int BOARD_WIDTH = 12;
	public static final int BOARD_HEIGHT = 12;
	
	Square[] squares;
	ArrayList<Piece> pieces;
	
	// TODO: Is there any case where we will need to pass parameters to the constructor?
	public Board() {
		squares = new Square[BOARD_WIDTH*BOARD_HEIGHT];
		pieces = new ArrayList<Piece>();
	}
	
	/** Add the given piece to the board if valid
	 * Return true if valid, false if invalid
	 * @param p
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean addPiece(Piece p, int row, int col) {
		if (row < 0 || row > 11 || col < 0 || col > 11) {
			return false;
		}
		for (Square square : p.squares) {
			// check if placement is valid
			int absRow = square.row + row;
			int absCol = square.col + col;
			if (absRow > 11 || absRow < 0 || absCol > 11 || absCol < 0) {
				return false;
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
			if (piece.getRow() == row && piece.getCol() == col) {
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
		return squares[row*BOARD_WIDTH + col];
	}
}