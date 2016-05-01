package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.BoardView;
import view.ILevelView;
import view.LevelPlayerView;

/**
 * Class to control events related to Board.
 * @author Maddy
 * @author Alex Kasparek
 * @author Connor Weeks
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

	/** This board controller's game (if in player)**/
	Kabasuji game;

	int previousCol;
	int previousRow;

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

	public BoardController(Level level, ILevelView levelView, Kabasuji game) {
		super();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.level = level;
		this.game = game;
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
		// TODO Will this cause rounding error? Is there a better way to do this?
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;


		//TODO: Pass these in as parameters to BoardToBoardMove?
		previousCol = col;
		previousRow = row;
		System.out.println("Col: " + previousCol);
		System.out.println("Row: " + previousRow);

		// First check what type of click
		if (mouseButton == MouseEvent.BUTTON3) { // We have right clicked
			// Stop dragging on right click
			//if (level.getActivePiece() != null) {
				//boardView.removeDraggedPiece();
				//level.setMoveSource(null);
				//level.removeActivePiece(); // level.setActivePiece(null)
			//} else {
				// This means we want to attempt a BoardToBullpen move (send a piece on the board back to bullpen)
			
				// TODO OK THIS IS MESSY, BUT IT FIXES BUG #2 IN THE BUGS GOOGLE DOC. Can we just pass a Piece to move classes instead of a row and column
			    // so I dont need two constructors or will this not work?
				BoardToBullpenMove m;
				if(boardView.getDraggedPiece() != null){
					m = new BoardToBullpenMove(level, boardView.getDraggedPiece());
					if(level.getBullpen().getPieces().contains(boardView.getDraggedPiece())) return;
				}else{
					m = new BoardToBullpenMove(level, col, row);
				}
				if (m.doMove()) {

					if (builder != null) {
						// if we are in the level builder
						// If the move is valid (and completed), we remove the source and active pieces
						boardView.removeDraggedPiece();
						builder.pushMove(m);

						level.setMoveSource(null);
						level.setActivePiece(null);
					}
					else if (game != null) {
						// if we are in the player
						boardView.removeDraggedPiece();
						// end game if needed
						if (m.getEndGameStatus()) {
							new ExitLevelController((LevelPlayerView)levelView, game, level).process();
						}
					}
					else {
						System.err.println("Player and builder are null");
					}
					// push move
				} else {
					// Otherwise, print an error
					System.err.println("Error: Unable to remove piece from board");
				}
			//}
		} else { // Not right-clicked
			// TODO fix this logic!

			// Check to see if no move has been started (source is null)
			if (level.getMoveSource() == null) {
				// Then check if there is a piece at the click location
				if (level.getBoard().getPiece(col, row) != null) {
					Piece pieceToDrag = level.getBoard().removePiece(level.getBoard().getPiece(col, row));

					// If present, we remove the piece, set active source, add call BoardView to render it
					if (pieceToDrag != null) {
						level.setMoveSource(boardView);
						level.setActivePiece(pieceToDrag);
						boardView.addDraggedPiece(pieceToDrag, p);
					}
				}
			} else if (level.getMoveSource().equals(levelView.getBullpenView())) {
				// If our source is the bullpen, then we are trying to do a BullpenToBoard move
				BullpenToBoardMove m = new BullpenToBoardMove(level, level.getActivePiece(), col, row);

				if (m.doMove()) {
					if (builder != null) {
						//push move here
						System.out.println("Success!");
						boardView.removeDraggedPiece();
						builder.pushMove(m);
						
						level.setMoveSource(null);
						level.setActivePiece(null);
					}
					else if (game != null) {
						// push move
						System.out.println("Success!");
						boardView.removeDraggedPiece();
						level.setMoveSource(null);
						level.setActivePiece(null);
						// exit game if needed
						if (m.getEndGameStatus()) {
							new ExitLevelController((LevelPlayerView)levelView, game, level).process();
						}
					}
					else {
						System.err.println("Player and builder are null");
					}
					
				} else {
					System.out.println("Failure!");
				}
			} else if (level.getMoveSource() == boardView) {
				BoardToBoardMove m = new BoardToBoardMove(level, level.getActivePiece(), col, row, previousCol, previousRow);

				if (m.doMove()) {
					if (builder != null) {
						//push move here
						boardView.removeDraggedPiece();
						level.setMoveSource(null);
						level.setActivePiece(null);
						builder.pushMove(m);
						System.out.println("Success!");
					}
					else if (game != null) {
						//push move here
						boardView.removeDraggedPiece();
						level.setMoveSource(null);
						level.setActivePiece(null);
						// exit game if needed
						if (m.getEndGameStatus()) {
							new ExitLevelController((LevelPlayerView)levelView, game, level).process();
						}
					}
					else {
						System.err.println("Player and builder are null");
					}
					
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