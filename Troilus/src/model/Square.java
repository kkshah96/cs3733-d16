package model;

public abstract class Square {
	//int row, col;
	//boolean hintSquare; TODO: Do we want to remove this?
	
	public Square() {//, boolean hintSquare){
		//this.row = row;
		//this.col = col;
		//this.hintSquare = hintSquare; TODO: See above
	}
	
	// TODO: Does this have to be an abstract method?
	public abstract boolean isValid();
	
	public abstract String getType();
}
