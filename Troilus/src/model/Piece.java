package model;

// TODO: Should we make Piece subclasses for level types so square types are consistent?
public class Piece {

	Square[] squares;
	Square anchor;
	int row, col; // TODO: Do we need this? If so, update constructor(s)

	public Piece(Square[] squares, Square anchor) {
		this.squares = squares;
		this.anchor = anchor;
		this.row = 0;
		this.col = 0;
	}
	
	// TODO: Make sure we check that the Square array is an appropriate size at execution time (throw exception if it isn't?)
	public Piece(Square[] squares, Square anchor, int row, int col) {
		this.squares = squares;
		this.anchor = anchor;
		this.row = row;
		this.col = col;
	}
	
	public Piece place(int row, int col) {
		return new Piece(squares, anchor, row, col);
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

			if(degree >= 0){ //ROTATE CW
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare(tempCol, -1*tempRow);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor); // TODO: Implement this
	}

	public Piece flipPiece(int degree){
		Square[] newSquares = new Square[5];

		for(int i = 0; i < 4; i++){
			if(degree < 0){ //FLIP HORIZONTAL
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare( tempRow, (tempCol*-1));
				newSquares[i] = newSquare;
			}

			if(degree >= 0){ //FLIP VERTICAL
				int tempRow;
				int tempCol;
				tempRow = squares[i].getRow();
				tempCol = squares[i].getCol();
				Square newSquare = new PieceSquare((tempRow*-1), tempCol);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor); // TODO: Implement this
	}
}