package controller;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;
import view.BoardView;

public class BullpenToBoardMove {
	
	Level l;
	Piece pieceMoved;
	int x;
	int y;
	
	public BullpenToBoardMove(Level l, Piece pieceMoved, int x, int y){
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
			Bullpen bpen = l.getBullpen();
			Board b = l.getBoard();
			
			bpen.removePiece(pieceMoved);
			
			boolean status = b.addPiece(pieceMoved, (x - BoardView.WIDTH_OFFSET) / BoardView.SQUARE_SIZE,
					(y - BoardView.SQUARE_SIZE) / BoardView.SQUARE_SIZE);
			
			l.removeActivePiece();
			
			return status;
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
