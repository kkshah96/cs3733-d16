package model;

import java.util.ArrayList;

/**
 * Represents a storage area for Pieces in the Kabasuji game
 * 
 * The Bullpen structure is similar to the Board structure in the sense that it maintains a collection of Pieces,
 * but it has no notion of a grid
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class Bullpen {
	//Hashtable<Piece, Point> pieces;
	ArrayList<Piece> pieces;

	// TODO: Is there any case where we will need to pass parameters to the constructor?
	public Bullpen() {
		//pieces = new Hashtable<Piece, Point>();
		pieces = new ArrayList<Piece>();
	}

	// TODO: Do we need these methods? Should they return void or boolean?
	//Adds the specified piece to the bullpen
	public void addPiece(Piece p) {
		//Set<Piece> keySet = pieces.keySet();
		//int num = keySet.size();
		//this.pieces.put(p, new Point(num, 0));
		pieces.add(p);
	}

	public Piece removePiece(Piece p) {
		this.pieces.remove(p);
		return p;
	}

	// TODO: Assumed we would need to be able to get a piece from the bullpen so I added this
	public Piece getPiece(int row, int col) {
		//Set<Piece> keySet = pieces.keySet();
		//for (Piece piece : keySet) {
		//	Point p = pieces.get(piece);
		//	if (p.getX() == row && p.getY() == col) {
			//	return piece;
			//}
		//}
		for(int i = 0; i < pieces.size(); i++){
			if(pieces.get(i).getRow() == row && pieces.get(i).getCol() == col){
				return pieces.get(i);
			}
		}
		return null;
	}
	
	/*public Piece getPiece(int index) {
		return pieces.get(index);
	}*/
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	public int getNumPieces() {
		return pieces.size();
	}
}