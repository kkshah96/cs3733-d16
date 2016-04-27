package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.Piece;
import view.BoardView;

/**
 * Class to control events related to Board.
 * @author Maddy
 * @author Alex Kasparek
 */
public class BoardController extends MouseAdapter {
	protected BoardView boardView;
	protected Level level;
	Piece activePiece;

	public BoardController(Level level, BoardView boardView) {
		super();
		this.boardView = boardView;
		this.level = level;
	}

	public void mousePressed(MouseEvent me) {
		if (boardView == null) {
			System.out.println("BoardView was null!");
			return;
		}

		// get mouse coordinates
		int x = me.getX();
		int y = me.getY();
		// TODO Someone remind me how we calculated these values
		// They are from the GUI (converting so Entity can understand)
		// Convert to col and row for Board <--- This
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;

		// TODO WE SHOULD DELEGATE THIS TO THE UNDO MOVE THING
		// TODO NO BECAUSE IT IS NOT UNDOING A MOVE
		if (me.getButton() == MouseEvent.BUTTON3) { // We have right clicked
			BoardToBullpenMove m = new BoardToBullpenMove(level, col, row);
			if (m.doMove()) {
				boardView.removeDraggedPiece();
				// push move
			} else {
				System.out.println("Error: Unable to remove piece from board");
			}
		} else {
			// TODO fix this logic!
			if (level.getMoveSource() == null) {
				level.setMoveSource("Board");
				
				// do nothing if no piece at click
				if(level.getBoard().getPiece(col, row) != null) {
					Piece pieceToDrag = level.getBoard().removePiece(level.getBoard().getPiece(col, row));
					if(pieceToDrag != null) {
						level.setActivePiece(pieceToDrag);
						boardView.addDraggedPiece(pieceToDrag, me.getPoint());
						boardView.repaint();
				}
				
				}
				//boardView.addDraggedPiece(activePiece, me.getPoint());
			} else if (level.getMoveSource() == "Bullpen") {

				BullpenToBoardMove m = new BullpenToBoardMove(level, level.getActivePiece(), col, row);
				if (m.doMove()) {
					//push move here
					System.out.println("Success!");
					boardView.removeDraggedPiece();
				} else {
					System.out.println("Failure!");
				}
				level.setMoveSource(null);
			} else if (level.getMoveSource() == "Board") {
				BoardToBoardMove m = new BoardToBoardMove(level, level.getActivePiece(), col, row);

				if (m.doMove()) {
					//push move here
					boardView.removeDraggedPiece();
					System.out.println("Success!");
				} else {
					System.out.println("Failure!");
				}
				level.setMoveSource(null);
			} else {
				System.err.println("Invalid source when moving to Board");
			}
		}
		boardView.repaint();
	}

	public void mouseMoved(MouseEvent me){
		activePiece = level.getActivePiece();

		if (activePiece != null) {
			boardView.addDraggedPiece(activePiece, me.getPoint());
			boardView.repaint();
		}
	}

	@Override
	// TODO does this work?
	public void mouseExited(MouseEvent me) {
		boardView.removeDraggedPiece();
		boardView.repaint();
	}
}