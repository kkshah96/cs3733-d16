package model;

import java.util.ArrayList;

/**
 * Represents a storage area for Pieces in the Kabasuji game
 * 
 * The Bullpen structure is similar to the Board structure in the sense that it maintains a collection of Pieces,
 * but it has no notion of a grid
 * 
 * @author Kunal Shah
 *
 */
public class Bullpen {
	ArrayList<Piece> pieces;

	// TODO: Is there any case where we will need to pass parameters to the constructor?
	public Bullpen() {
		pieces = new ArrayList<Piece>();
	}

	// TODO: Do we need these methods? Should they return void or boolean?
	//Adds the specified piece to the bullpen
	public void addPiece(Piece p) {
		this.pieces.add(p);
	}

	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	// TODO: Assumed we would need to be able to get a piece from the bullpen so I added this
	public Piece getPiece(int row, int col) {
		for (Piece piece : pieces) {
			if (piece.getRow() == row && piece.getCol() == col) {
				return piece;
			}
		}
		return null;
	}
	
	public Piece getPiece(int index) {
		return pieces.get(index);
	}
	
	public int getNumPieces() {
		return pieces.size();
	}
}