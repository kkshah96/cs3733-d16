package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Represents a Palette in the Kabasuji game 
 * 
 * The Palette structure keeps track of a collection of each of the 35 unique Piece types in the Kabasuji game
 * 
 * @author Kunal Shah
 *
 */
public class Palette {
	public static final int NUM_PIECES = 35;
	ArrayList<Piece> pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? 
	public Palette(){
		pieces = new ArrayList<Piece>();
		initialize();
	}
	
	/*public Piece getPiece(int index){
		return pieces[index];
	}*/

	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	public Piece getPiece(int row, int col) {
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
	}
	
	public ArrayList<Piece> getPieces() {
		return this.pieces;
	}
	
	private void initialize() {
		for(int i = 0; i < NUM_PIECES; i++) {
			pieces.add(PieceFactory.getPiece(i+1));
		}
	}
}