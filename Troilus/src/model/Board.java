package model;

import java.util.ArrayList;

public class Board {
	ArrayList<Square> squares;
	ArrayList<Piece> pieces;
	
	// TODO: Is there any case where we will need to pass parameters to the constructor?
	public Board(){
		squares = new ArrayList<Square>();
		pieces = new ArrayList<Piece>();
	}
	
	public void addSquare(Square s){
		this.squares.add(s);
	}
	
	/** Add the given piece to the board if valid
	 * @param p
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean addPiece(Piece p, int row, int col) {
		for (Square square : p.squares) {
			// check if placement is valid
		}
		this.pieces.add(p.place(row, col));
		return true;
	}
	
	/** Remove the given piece from the board and return it
	 * @param p
	 */
	public Piece removePiece(Piece p){
		this.pieces.remove(p);
		return p;
	}
	
	/** Find the piece at the given location (don't change)
	 * @param row
	 * @param col
	 * @return
	 */
	public Piece getPiece(int row, int col) {
		if (row > 11 || col > 11) {
			return null;
		}
		for(int i = 0; i < pieces.size(); i++){
			if(pieces.get(i).row == row && pieces.get(i).col == col){
				return pieces.get(i);
			}
		}
		return null;
	}
	
	//Get the square of the board at the indicated row and column
	public Square getSquare(int row, int col){
		for(int i = 0; i < squares.size(); i++){
			if(squares.get(i).row == row && squares.get(i).col == col){
				return squares.get(i);
			}
		}
		return null;
	}
}