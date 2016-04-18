package model;

public class Palette {
	Piece[] pieces;

	// TODO: Handle checking there are exactly 35 pieces at execution time? NO (could change!)
	// TODO: Can we just pass in all of the pieces to the constructor or should we make an addPiece method?
	public Palette(){
		//this.pieces = pieces;
		pieces = new Piece[35];
		initialize();
	}
	
	public Piece getPiece(int index){
		return pieces[index];
	}

	// TODO: Assumed we would need to be able to get a piece from the Palette so I added this
	public Piece getPiece(int row, int col){
		for (Piece piece : pieces) {
			if (piece.getRow() == row && piece.getCol() == col) {
				return piece;
			}
		}
		return null;
	}
	
	private void initialize(){
		for(int i = 0; i < 35; i++){
			pieces[i] = PieceFactory.getPiece(i * 6, 0, i + 1);
		}
	}
}