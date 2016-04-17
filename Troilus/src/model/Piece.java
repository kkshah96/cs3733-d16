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
	
	public Square[] getSquares() {
		return squares;
	}
	
	public Square getAnchor() {
		return anchor;
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

		for(int i = 0; i < 5; i++){
			if(degree < 0){ //ROTATE CCW
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();
				int distToFRow = anchor.getRow() - oldRow;
				int distToFCol = anchor.getCol() - oldCol;				
				int newRow = anchor.getRow() - distToFCol;
				int newCol = anchor.getCol() + distToFRow;
				
				Square newSquare = new PieceSquare(newRow, newCol);
				newSquares[i] = newSquare;
			}
			
			else { //ROTATE CW
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();
				int distToFRow = anchor.getRow() - oldRow;
				int distToFCol = anchor.getCol() - oldCol;				
				int newRow = anchor.getRow() + distToFCol;
				int newCol = anchor.getCol() - distToFRow;

				Square newSquare = new PieceSquare(newRow, newCol);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor, type); // TODO: Implement this
	}
	
	public Piece flipPiece(int degree){
		Square[] newSquares = new Square[5];
		
		for(int i = 0; i < 5; i++){
			if(degree < 0){ // FLIP HORIZONTAL
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();
				int distToFRow = anchor.getRow() - oldRow;
				int newRow = anchor.getRow() + distToFRow;

				Square newSquare = new PieceSquare(newRow, oldCol);
				newSquares[i] = newSquare;
			}
			
			else { //FLIP VERTICAL
				int oldRow = squares[i].getRow();
				int oldCol = squares[i].getCol();
				int distToFCol = anchor.getCol() - oldCol;				
				int newCol = anchor.getCol() + distToFCol;

				Square newSquare = new PieceSquare(oldRow, newCol);
				newSquares[i] = newSquare;
			}
		}
		return new Piece(newSquares, anchor, type); // TODO: Implement this
	}
}