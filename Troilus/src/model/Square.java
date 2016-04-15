package model;

public abstract class Square {
	int row, col;
	//boolean hintSquare; TODO: Do we want to remove this?
	
	public Square(int row, int col){//, boolean hintSquare){
		this.row = row;
		this.col = col;
		//this.hintSquare = hintSquare; TODO: See above
	}
	
	// TODO: Does this have to be an abstract method?
	public abstract boolean isValid();
	
	public int getRow(){
		return this.row;
	}
	
	public int getCol(){
		return this.col;
	}
}
