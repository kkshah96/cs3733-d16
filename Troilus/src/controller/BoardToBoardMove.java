package controller;

import model.Board;
import model.Level;
import model.Piece;
import view.BoardView;

/**
 * 
 * THIS NEEDS TO BE FINISHED!
 * @author Alex Kasparek
 *
 */
public class BoardToBoardMove {
	
	Level l;
	Piece pieceMoved;
	int x;
	int y;
	
	public BoardToBoardMove(Level l, Piece pieceMoved, int x, int y){
		this.l = l;
		this.pieceMoved = pieceMoved;	
		this.x = x;
		this.y = y;
	}
	
	public boolean doMove(){
		if(isValid() == false){
			System.out.println("Invalid move!");
			return false;
		}
		else{
			Board b  = l.getBoard();
			
			b.removePiece(pieceMoved);
			
			boolean result = b.addPiece(pieceMoved, x / BoardView.SQUARE_SIZE,
					(y - BoardView.SQUARE_SIZE) / BoardView.SQUARE_SIZE);
			
			l.removeActivePiece();
			
			return result;
		}	
	}
	
	public boolean isValid(){
		boolean validation = false;
		
		validation = true; //TODO: ADD THIS LOGIC!!!
		
		
		return validation;
	}

	//TODO: ADD UNDO
	public boolean undo(){
	
		
		return false;
	}
}
