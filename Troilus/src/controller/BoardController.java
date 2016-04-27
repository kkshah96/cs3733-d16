package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
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

	public void mousePressed(MouseEvent me){

		//get mouse coordinates
		int x = me.getX();
		int y = me.getY();

		if(bV == null){
			System.out.println("BoardView was null!");
			return;
		}

		// TODO Someone remind me how we calculated these values
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;

		// TODO WE SHOULD DELEGATE THIS TO THE UNDO MOVE THING
		if(me.getButton() == MouseEvent.BUTTON3){ // We have right clicked
			Piece pToRemove = level.getBoard().getPiece(col, row);	

			if(pToRemove == null) return; // TODO: Is there a better way to handle this?

			Piece p = level.getBoard().removePiece(pToRemove);
			level.getBullpen().addPiece(level.getBoard().removePiece(p));

			bV.repaint();
		}else{
			level.setMoveSource("Bullpen");
			if(level.getMoveSource() == "Bullpen"){
				BullpenToBoardMove m = new BullpenToBoardMove (level, level.getActivePiece(), me.getX(), me.getY());

				if (m.doMove ()) {
				//push move here
					System.out.println("Success!");
					bV.repaint();
				} else {
					System.out.println("Failure!");
				}
				
				bV.removeDraggedPiece();
				//level.getBullpen().removePiece(activePiece); I Put this in the move itself instead
				//level.removeActivePiece();
			}else if (level.getMoveSource() == "Board"){
				BoardToBoardMove m = new BoardToBoardMove(level, activePiece, me.getX(), me.getY());
				
				if (m.doMove ()) {
					//push move here
						System.out.println("Success!");
					} else {
						System.out.println("Failure!");
					}
				//	level.getBullpen().removePiece(activePiece);
					//level.removeActivePiece();
				bV.removeDraggedPiece();
			}else{
				System.err.println("Invalid source");
			}
		}
		
		//TODO what were these lines for again?

		//activePiece = level.getBoard().getPiece(row, col);

		//if(activePiece == null){
			//System.out.println("No piece clicked");
	//	}
		
	}

	public void mouseMoved(MouseEvent me){
		activePiece = level.getActivePiece();
		//BoardView bView = editorView.getBoardView();

		if (activePiece != null) {

			System.out.println("adding dragged piece");
			bV.addDraggedPiece(activePiece, me.getPoint());
			bV.repaint();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent me) {
		bV.removeDraggedPiece();
		bV.repaint();
	}

	/*public void mouseReleased(MouseEvent me) {
		//From the bullpen

		if(me.getSource() instanceof BoardView){ //this is incorrect, want to handle dragging something whose source is the bullpen
			System.out.println("Should be here");
			System.out.println("In board now!");

			activePiece = level.getActivePiece();

			if(activePiece == null) {
				System.err.println("Unexpectedly encountered null piece during BullpenToBoard");
				return;
			}
			BullpenToBoardMove m = new BullpenToBoardMove (level.getBullpen(), 
					level.getBoard(), activePiece, me.getX(), me.getY());

			if (m.doMove ()) {
			//push move here
				System.out.println("Success!");
			} else {
				System.out.println("Failure!");
				//fromTableau.push (col);
			}

			level.getBullpen().removePiece(activePiece);
			level.removeActivePiece();
		}
		//Dragging from board to board:
		else if(me.getSource() instanceof BoardView){

		}

	lV.repaint();

	}//end mouseReleased*/

}
