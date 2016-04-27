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
 * @author Someone else
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

	public void mousePressed(MouseEvent me) {
		//get mouse coordinates
		int x = me.getX();
		int y = me.getY();

		if (boardView == null) {
			System.out.println("BoardView was null!");
			return;
		}
		
		// TODO Someone remind me how we calculated these values
		// They are from the GUI (converting so Entity can understand)
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;

		// TODO WE SHOULD DELEGATE THIS TO THE UNDO MOVE THING
		// TODO NO BECAUSE IT IS NOT UNDOING A MOVE
		if (me.getButton() == MouseEvent.BUTTON3) { // We have right clicked
			BoardToBullpenMove mBToBP = new BoardToBullpenMove(level, col, row);
			if (mBToBP.doMove()) {
				boardView.removeDraggedPiece();
				// push move
			} else {
				System.out.println("Error: Unable to remove piece from board");
			}
		} else {
			level.setMoveSource("Bullpen");
			if (level.getMoveSource() == "Bullpen") {
				BullpenToBoardMove m = new BullpenToBoardMove(level, level.getActivePiece(), col, row);
				if (m.doMove()) {
					//push move here
					System.out.println("Success!");
					boardView.removeDraggedPiece();
				} else {
					System.out.println("Failure!");
				}
			} else if (level.getMoveSource() == "Board") {
				BoardToBoardMove m = new BoardToBoardMove(level, activePiece, col, row);

				if (m.doMove()) {
					//push move here
					boardView.removeDraggedPiece();
					System.out.println("Success!");
				} else {
					System.out.println("Failure!");
				}
			} else {
				System.err.println("Invalid source when moving to Board");
			}
		}

		//TODO what were these lines for again?

		//activePiece = level.getBoard().getPiece(row, col);

		//if(activePiece == null){
		//System.out.println("No piece clicked");
		//	}
		boardView.repaint();
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
}