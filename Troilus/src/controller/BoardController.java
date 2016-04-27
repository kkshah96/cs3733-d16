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

/**
 * Class to control events related to Board.
 * @author Maddy
 *
 */
public class BoardController extends MouseAdapter {
	protected LevelEditorView editorView;
	protected BoardView boardView;
	protected Level level;
	Piece activePiece;

	public BoardController(Level level, LevelEditorView editorView) {
		super();
		this.editorView = editorView;
		this.boardView = editorView.getBoardView();
		this.level = level;
	}

	public void mousePressed(MouseEvent me){
		//get mouse coordinates
		int x = me.getX();
		int y = me.getY();

		if (boardView == null) {
			System.out.println("BoardView was null!");
			return;
		}

		// TODO Someone remind me how we calculated these values
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;

		// TODO WE SHOULD DELEGATE THIS TO THE UNDO MOVE THING
		// TODO NO BECAUSE IT IS NOT UNDOING A MOVE
		if (me.getButton() == MouseEvent.BUTTON3) { // We have right clicked
			Piece pToRemove = level.getBoard().getPiece(col, row);	

			if (pToRemove == null) {
				return; // TODO: Is there a better way to handle this?
			}

			Piece p = level.getBoard().removePiece(pToRemove);
			level.getBullpen().addPiece(level.getBoard().removePiece(p));

			boardView.repaint();
		} else {
			level.setMoveSource("Bullpen");
			if (level.getMoveSource() == "Bullpen") {
				BullpenToBoardMove m = new BullpenToBoardMove(level,
						level.getActivePiece(), me.getX(), me.getY());
				if (m.doMove()) {
				//push move here
					System.out.println("Success!");
					boardView.repaint();
				} else {
					System.out.println("Failure!");
				}
				
				boardView.removeDraggedPiece();
				//level.getBullpen().removePiece(activePiece); I Put this in the move itself instead
				//level.removeActivePiece();
			} else if (level.getMoveSource() == "Board") {
				BoardToBoardMove m = new BoardToBoardMove(level, activePiece, me.getX(), me.getY());
				
				if (m.doMove ()) {
					//push move here
						System.out.println("Success!");
					} else {
						System.out.println("Failure!");
					}
				//	level.getBullpen().removePiece(activePiece);
					//level.removeActivePiece();
				boardView.removeDraggedPiece();
			} else {
				System.err.println("Invalid source when moving to Board");
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
			boardView.addDraggedPiece(activePiece, me.getPoint());
			boardView.repaint();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent me) {
		boardView.removeDraggedPiece();
		boardView.repaint();
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