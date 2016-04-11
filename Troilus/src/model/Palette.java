package model;


public class Palette {
	Piece[] pieces;
	
	// TODO: Handle checking there are exactly 35 pieces at execution time?
	// TODO: Can we just pass in all of the pieces to the constructor or should we make an addPiece method?
	public Palette(Piece[] pieces){
		this.pieces = pieces;
	}
	
	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	public Piece getPiece(int row, int col){
		for(int i = 0; i < pieces.length; i++){
			if(pieces[i].row == row && pieces[i].col == col){
				return pieces[i];
			}
		}
		return null;
	}
}

