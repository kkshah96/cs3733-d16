package model;

import java.util.ArrayList;

/**
 * Represents a Palette in the Kabasuji game 
 * 
 * The Palette structure keeps track of a collection of each of the 35 unique Piece types in the Kabasuji game
 * 
 * @author Kunal Shah
 *
 */
public class Palette {
	/** Make this a singleton object because the Palette should never change after being instantiated. **/
	private static Palette instance = new Palette(); 
	
	/** Constant to identify the maximum number of a pieces a palette can contain. */
	public static final int NUM_PIECES = 35;
	
	/** The collection of pieces this palette contains*/
	ArrayList<Piece> pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? 
	// Don't we want to be flexible here?
	/**
	 * Creates a new instance of the Palette entity.
	 */
	private Palette(){
		if (instance == null) {
			pieces = new ArrayList<Piece>();
			initialize();
		}
	}
	
	/**
	 * @return Returns the instance of this Palette
	 */
	public static Palette getInstance(){
		return instance;
	}
	
	/**
	 * Provides a reference to the collection of pieces in the palette.
	 * @return ArrayList of Pieces in this palette.
	 */
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	/**
	 * Initializes the palette by filling it with the 35 unique pieces.
	 */
	private void initialize() {
		for(int i = 0; i < NUM_PIECES; i++) {
			pieces.add(PieceFactory.getPiece(i+1));
		}
	}
}