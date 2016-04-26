package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Level;
import model.Piece;
import view.BoardView;
import view.BullpenView;
import view.LevelEditorView;

public class BoardController extends MouseAdapter{
	
	protected LevelEditorView lV;
	protected BoardView bV;
	protected Level level;
	Piece activePiece;
	
	public BoardController(Level level, BoardView bV, LevelEditorView lV) {
		super();

		this.lV = lV;
		this.bV = bV;
		this.level = level;
	}
	
	
	public void MousePressed(MouseEvent me){
		
		//get mouse coordinates
		int x = me.getX();
		int y = me.getY();
		
		if(bV == null){
			System.out.println("BoardView was null!");
			return;
		}
		
		
		int row = y/BoardView.SQUARE_SIZE - BoardView.HEIGHT_OFFSET;
		int col = x/BoardView.SQUARE_SIZE - BoardView.WIDTH_OFFSET;
		
		activePiece = level.getBoard().getPiece(row, col);
		
		if(activePiece == null){
			System.out.println("No piece clicked");
		}
		bV.addDraggedPiece(activePiece, new Point(row, col));
		
	}
	
	public void mouseReleased(MouseEvent me) {
		//From the bullpen
		if(me.getSource() instanceof BullpenView){
			BullpenToBoardMove m = new BullpenToBoardMove (level.getBullpen(), 
					level.getBoard(), activePiece, me.getX(), me.getY());

			if (m.doMove ()) {
			//push move here
				System.out.println("Success!");
			} else {
				System.out.println("Failure!");
				//fromTableau.push (col);
			}
		}
		//Dragging from board to board:
		else if(me.getSource() instanceof BoardView){
			
		}
		
	bV.removeDraggedPiece();
	level.getBullpen().removePiece(activePiece);
	level.setActivePiece(null);
		
	}//end mouseReleased
	

}
