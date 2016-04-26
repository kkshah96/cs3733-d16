package controller;

import model.Board;
import model.Bullpen;
import model.Piece;
import view.BoardView;

public class BullpenToBoardMove {
	
	Bullpen bpen;
	Board b;
	Piece pieceMoved;
	int x;
	int y;
	
	public BullpenToBoardMove(Bullpen bpen, Board b, Piece pieceMoved, int x, int y){
		this.bpen = bpen;
		this.b = b;
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
			b.addPiece(pieceMoved, x / BoardView.SQUARE_SIZE,
					(y - BoardView.SQUARE_SIZE) / BoardView.SQUARE_SIZE);
		}
		
		return true;
		
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
