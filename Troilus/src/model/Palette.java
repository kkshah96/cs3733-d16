package model;

import java.awt.Point;
import java.util.Hashtable;
import java.util.Set;

/**
 * Represents a Palette in the Kabasuji game 
 * 
 * The Palette structure keeps track of a collection of each of the 35 unique Piece types in the Kabasuji game
 * 
 * @author Kunal Shah
 *
 */
public class Palette {
	Hashtable<Piece, Point> pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? NO (could change!)
	// TODO: Can we just pass in all of the pieces to the constructor or should we make an addPiece method?
	public Palette(){
		//this.pieces = pieces;
		pieces = new Hashtable<Piece, Point>(35);
		initialize();
	}
	
	/*public Piece getPiece(int index){
		return pieces[index];
	}*/

	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	public Piece getPiece(int row, int col){
		Set<Piece> keySet = pieces.keySet();
		for (Piece piece : keySet) {
			Point p = pieces.get(piece);
			if (p.getY() == row && p.getX() == col) {
				return piece;
			}
		}
		return null;
	}
	
	public Hashtable<Piece, Point> getPieces(){
		return this.pieces;
	}
	
	private void initialize(){
		for(int i = 0; i < 35; i++){
			pieces.put(PieceFactory.getPiece(i+1), new Point(0, i * 6));
		}
	}
}