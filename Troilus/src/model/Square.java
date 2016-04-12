package model;

public abstract class Square {
	int row, col;
	boolean hintSquare;
	
	public Square(int row, int col, boolean hintSquare){
		this.row = row;
		this.col = col;
		this.hintSquare = hintSquare;
	}
	
	// TODO: Does this have to be an abstract method?
	public abstract boolean isValid();
}