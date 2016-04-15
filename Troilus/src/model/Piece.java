package model;

// TODO: Should we make Piece subclasses for level types so square types are consistent?
public class Piece {
	
	Square[] squares;
	Square anchor;
	int row, col; // TODO: Do we need this? If so, update constructor(s)
	
	// TODO: Make sure we check that the Square array is an appropriate size at execution time (throw exception if it isn't?)
	public Piece(Square[] squares, Square anchor){
		this.squares = squares;
		this.anchor = anchor;
	}
	
	public Piece rotatePiece(int degree){ //CCW: degree < 0
		Square[] newSquares = new Square[5];
		
		
		for(int i = 0; i < 4; i++){
//			if(degree < 0){ //ROTATE CCW
//				int tempRow;
//				int tempCol;
//				tempRow = squares[i].getRow();
//				tempCol = squares[i].getCol();
//				Square newSquare = new PieceSquare( tempCol, tempRow);
//			}
			
//			if(degree >= 0){ //ROTATE CW
//				int tempRow;
//				int tempCol;
//				tempRow = squares[i].getRow();
//				tempCol = squares[i].getCol();
//				Square newSquare = new PieceSquare(tempCol, -1*tempRow);
//			}
			
			
			
		}
		
		return new Piece(newSquares, anchor); // TODO: Implement this
	}
	
	public Piece flipPiece(int degree){
		return new Piece(squares, anchor); // TODO: Implement this
	}
	
}
