package controller;

import model.Board;
import model.Level;
import model.Piece;

/**
 * Class for implementation of moving a piece on the board.
 * TODO THIS NEEDS TO BE FINISHED!
 * @author Alex Kasparek
 * @author Maddy
 * @author Dan Alfred
 *
 */
public class BoardToBoardMove extends Move{
	/** The level this move acts on. */
	Level level;
	
	/** The piece utilized during the move. */
	Piece movingPiece;
	
	/** The column on the board for destination. */
	int col;
	
	/** The row on the board for destination. */
	int row;
	
	/** movingPiece's previous row **/
	int previousRow;
	
	/** movingPiece's previous column**/
	int previousCol;

	/**
	 * Creates a new instance of a BoardToBoardMove with the given parameters.
	 * @param level The level to complete the move on
	 * @param movingPiece A reference to the active, or moving piece
	 * @param col The column of the destination square on the board
	 * @param row The row of the destination square on the board
	 */
	public BoardToBoardMove(Level level, Piece movingPiece, int col, int row, int previousCol, int previousRow) {
		super();
		
		this.level = level;
		this.movingPiece = movingPiece;	
		this.col = col;
		this.row = row;
	
		this.previousCol = previousCol;
		this.previousRow = previousRow;
		
		System.out.println("Col: " + previousCol);
		System.out.println("Row: " + previousRow);
	}

	/**
	 * Completes this instance of BoardToBoardMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	public boolean doMove() {
		// First check if the move is valid. Return false if invalid
		if (!isValid()) {
			System.out.println("Invalid move!");
			return false;
		}
		
		// Obtain a reference to the board and add the piece at the specified location
		Board board  = level.getBoard();
		board.addPiece(movingPiece, col, row);

		// Remove the active piece stored in level, and signal to update
		level.removeActivePiece();
		level.updateAfterMove();
		return true;
	}

	/**
	 * Checks if this BoardToBoardMove is valid with the given parameters<br />
	 * -Valid if all squares inside the piece are not on an invalid squares and <br />
	 * -There are no pieces underneath the requested piece 
	 * 
	 * @param piece Reference to the piece to use in the move
	 * @param col Column on the board as the destination
	 * @param row Row on the board as the destination
	 * @return True if this BoardToBoardMove is valid with the given parameters, false otherwise
	 */
	public boolean isValid() {
		// TODO: if level.canMakeMove()...
		return level.getBoard().validPlacement(movingPiece, col, row);
	}

	//TODO: FINISH
	/**
	 * Undoes this BoardToBoardMove
	 * @return True if the move was undone successfully, or false otherwise
	 */
	public boolean undo() {
		boolean validation = false;
	
//		BoardToBoardMove m = new BoardToBoardMove(level, movingPiece, previousCol, previousRow, col, row);
//		if(m.isValid()){
//			m.doMove();
//			System.out.println("Done with undo BoardToBoard!");
//			validation = true;
//		}
		
			if(level.getBoard().getPiece(previousCol, previousRow)!=null){
				Piece p = movingPiece;
				level.getBoard().removePiece(movingPiece);
				level.getBoard().addPiece(p, previousCol, previousRow);
				
				System.out.println("Valid Undo!");
			}
			
		validation = true;
		
		
//		if(level.getBoard().getPiece(col, row) != null){
//			BoardToBoardMove undo = new BoardToBoardMove(level, movingPiece, previousCol, previousRow);
//			validation = undo.doMove();
//		}
		
		return validation;
	}
}