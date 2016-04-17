package model;

// TODO: Should we make Piece subclasses for level types so square types are consistent?
public class Piece {
	Square[] squares;
	Square anchor;
	int type;
	//int row, col; // TODO: Do we need this? If so, update constructor(s)
	
	// TODO: Make sure we check that the Square array is an appropriate size at execution time (throw exception if it isn't?)
	public Piece(Square[] squares, Square anchor, int type) {
		this.squares = squares;
		this.anchor = anchor;
		this.type = type;
	}
	
	public int getRow() {
		return anchor.row;
	}
	
	public int getCol() {
		return anchor.col;
	}
	
	/** Update location of anchor
	 * @param row
	 * @param col
	 * @return
	 */
	public Piece place(int row, int col) {
		return new Piece(squares, new PieceSquare(row, col), type);
	}
	
	public int getType() {
		return type;
	}
	
	public Piece rotatePiece(int degree){ //CCW: degree < 0
		Square[] newSquares = new Square[5];

		for(int i = 0; i < 4; i++){
			if(degree < 0){ //ROTATE CCW
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare( tempCol, tempRow);
				newSquares[i] = newSquare;
			}
			
			else if(degree >= 0){ //ROTATE CW
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare(tempCol, -1*tempRow);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor, type); // TODO: Implement this
	}
	
	public Piece flipPiece(int degree){
		Square[] newSquares = new Square[5];
		
		for(int i = 0; i < 4; i++){
			if(degree < 0){ // FLIP HORIZONTAL
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare( tempRow, (tempCol*-1));
				newSquares[i] = newSquare;
			}
			
			else if(degree >= 0){ //FLIP VERTICAL
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare((tempRow*-1), tempCol);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor, type); // TODO: Implement this
	}
}