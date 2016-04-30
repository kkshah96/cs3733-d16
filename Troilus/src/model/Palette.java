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
	/** Constant to identify the maximum number of a pieces a palette can contain*/
	public static final int NUM_PIECES = 35;
	
	/** The collection of pieces this palette contains*/
	ArrayList<Piece> pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? 
	/**
	 * Creates a new instance of the Palette entity
	 */
	public Palette(){
		pieces = new ArrayList<Piece>();
		initialize();
	}
	
	/*public Piece getPiece(int index){
		return pieces[index];
	}*/

	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	// TODO: This is a palette- do we need this?
	/*public Piece getPiece(int row, int col) {
		//Set<Piece> keySet = pieces.keySet();
		//for (Piece piece : keySet) {
			//Point p = pieces.get(piece);
			//if (p.getY() == row && p.getX() == col) {
				//return piece;
			//}
		//}
		//return null;
		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).getRow() == row && pieces.get(i).getCol() == col) {
				return pieces.get(i);
			}
		}
		return null;
	}*/
	
	/**
	 * Provides a reference to the collection of pieces in the palette
	 * @return ArrayList of Pieces in this palette
	 */
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	/**
	 * Initializes the palette by filling it with the 35 unique pieces
	 */
	private void initialize() {
		for(int i = 0; i < NUM_PIECES; i++) {
			pieces.add(PieceFactory.getPiece(i+1));
		}
	}
}