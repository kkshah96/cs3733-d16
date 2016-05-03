package model;

import java.util.ArrayList;

/**
 * Represents a storage area for Pieces in the Kabasuji game.
 * 
 * The Bullpen structure is similar to the Board structure in the sense that it maintains a collection of Pieces,
 * but it has no notion of a grid.
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class Bullpen {
	/** Storage for pieces in the bullpen */
	ArrayList<Piece> pieces;

	/**
	 * Constructor for Bullpen. Instantiates an array of Pieces.
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
	}
	
	/**
	 * Adds the given piece to this bullpen.
	 * @param p The piece object to add.
	 * @return Returns true if the piece was added successfully, false if not.
	 */
	public boolean addPiece(Piece p) {
		if (p == null) {
			return false;
		} else {
			// Check to avoid duplicates
			for (Piece otherPiece : pieces) {
				if (otherPiece == p) {
					return true;
				}
			}
			pieces.add(p);
			return true;
		}
	}

	/**
	 * Removes the specified piece from the bullpen and returns it.
	 * The piece is still returned even if it is not in the bullpen.
	 * @param p Piece to be removed from the bullpen.
	 * @return The piece removed.
	 */
	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	/**
	 * Provides a listing of pieces in the bullpen.
	 * @return ArrayList of pieces in the bullpen.
	 */
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}

	/**
	 * Determines the number of pieces currently in the bullpen.
	 * @return Size of ArrayList of pieces.
	 */
	public int getNumPieces() {
		return pieces.size();
	}
}