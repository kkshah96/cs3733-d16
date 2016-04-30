package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.BoardView;
import view.ILevelView;

/**
 * Class to control events related to Board.
 * @author Maddy
 * @author Alex Kasparek
 */
public class BoardController extends MouseAdapter {
	/** The BoardView modified in this controller. */
	protected BoardView boardView;

	/** The Level for this context. */
	protected Level level;

	/** The View that this controller modifies. */
	ILevelView levelView;

	/** The active piece for this. */
	Piece activePiece;
	
	/** This board controller's builder (if in levelbuilder)**/
	LevelBuilder builder;

	/**
	 * Creates a new BoardController object with the specified parameters.
	 * @param level The level this controller modifies
	 * @param levelView The view for the level this controller calls to update
	 */
	public BoardController(Level level, ILevelView levelView, LevelBuilder builder) {
		super();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.level = level;
		this.builder = builder;
	}
	
	public BoardController(Level level, ILevelView levelView) {
		super();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.level = level;
	}

	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}
	
	void handleMousePressed(Point p, int mouseButton) {
		if (boardView == null) {
			System.out.println("BoardView was null!");
			return;
		}

		// get mouse coordinates from press
		int x = p.x;
		int y = p.y;

		// Convert to col and row using our view offsets
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;

		// First check what type of click
		if (mouseButton == MouseEvent.BUTTON3) { // We have right clicked
			// Stop dragging on right click
			if (level.getActivePiece() != null) {
				boardView.removeDraggedPiece();
				level.setMoveSource(null);
				level.setActivePiece(null);
			} else {
				// This means we want to attempt a BoardToBullpen move (send a piece on the board back to bullpen)
				BoardToBullpenMove m = new BoardToBullpenMove(level, col, row);
				if (m.doMove()) {
					// If the move is valid (and completed), we remove the source and active pieces
					boardView.removeDraggedPiece();
					if (builder != null) {
						// TODO ugly code
						builder.pushMove(m);
					}
					level.setMoveSource(null);
					level.setActivePiece(null);
					
					// push move
				} else {
					// Otherwise, print an error
					System.err.println("Error: Unable to remove piece from board");
				}
			}
		} else { // Not right-clicked
			// TODO fix this logic!

			// Check to see if no move has been started (source is null)
			if (level.getMoveSource() == null) {
				// Then check if there is a piece at the click location
				if (level.getBoard().getPiece(col, row) != null) {
					Piece pieceToDrag = level.getBoard().removePiece(level.getBoard().getPiece(col, row));

					// If present, we remove the piece, set active source, add call BoardView to render it
					if (pieceToDrag != null) {
						level.setMoveSource("Board");
						level.setActivePiece(pieceToDrag);
						boardView.addDraggedPiece(pieceToDrag, p);
					}
				}
			} else if (level.getMoveSource() == "Bullpen") {
				// If our source is the bullpen, then we are trying to do a BullpenToBoard move
				BullpenToBoardMove m = new BullpenToBoardMove(level, level.getActivePiece(), col, row);

				if (m.doMove()) {
					//push move here
					System.out.println("Success!");
					boardView.removeDraggedPiece();
					if (builder != null) {
						// TODO ugly code
						builder.pushMove(m);
					}
					level.setMoveSource(null);
					level.setActivePiece(null);
				} else {
					System.out.println("Failure!");
				}
			} else if (level.getMoveSource() == "Board") {
				BoardToBoardMove m = new BoardToBoardMove(level, level.getActivePiece(), col, row);

				if (m.doMove()) {
					//push move here
					boardView.removeDraggedPiece();
					level.setMoveSource(null);
					level.setActivePiece(null);
					if (builder != null) {
						// TODO this is ugly
						builder.pushMove(m);
					}
					System.out.println("Success!");
				} else {
					System.out.println("Failure!");
				}
			} else {
				System.err.println("Invalid source when moving to Board");
			}
		}
		// TODO update display of stars, etc!
		levelView.refresh();
	}

	public void mouseMoved(MouseEvent me){
		// Whenever the mouse is moved, check if there is an active piece
		activePiece = level.getActivePiece();

		// If so, we need to have the BoardView set and render it
		if (activePiece != null) {
			boardView.addDraggedPiece(activePiece, me.getPoint());
			boardView.repaint();
		}
	}

	//@Override
	// TODO does this work?
	// TODO Kunal has decided against this. We should instead let the piece follow the cursor unless the mouseMoved event is trigged in Bullpen (I think)
	/*public void mouseExited(MouseEvent me) {
		boardView.removeDraggedPiece();
		level.setMoveSource(null);
		level.setActivePiece(null);
		boardView.repaint();
	}*/
}