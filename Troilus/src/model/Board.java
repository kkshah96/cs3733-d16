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
	
	// TODO: We need these two methods, right? Should they return void or boolean?
	public void addPiece(Piece p){
		this.pieces.add(p);
	}
	
	//remove the given piece from the board
	public void removePiece(Piece p){
		this.pieces.remove(p);
	}
	
	//Find the piece at the given row and column on the board
	public Piece getPiece(int row, int col){
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

