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
	//Hashtable<Piece, Point> pieces;
	ArrayList<Piece> pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? NO (could change!)
	// TODO: Can we just pass in all of the pieces to the constructor or should we make an addPiece method?
	public Palette(){
		//this.pieces = pieces;
		//pieces = new Hashtable<Piece, Point>(35);
		pieces = new ArrayList<Piece>(35);
		initialize();
	}
	
	/*public Piece getPiece(int index){
		return pieces[index];
	}*/

	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	public Piece getPiece(int row, int col){
		//Set<Piece> keySet = pieces.keySet();
		//for (Piece piece : keySet) {
			//Point p = pieces.get(piece);
			//if (p.getY() == row && p.getX() == col) {
				//return piece;
			//}
		//}
		//return null;
		for(int i = 0; i < pieces.size(); i++){
			if(pieces.get(i).getRow() == row && pieces.get(i).getCol() == col){
				return pieces.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	private void initialize(){
		for(int i = 0; i < 35; i++){
			pieces.add(PieceFactory.getPiece(i+1));
		}
	}
}