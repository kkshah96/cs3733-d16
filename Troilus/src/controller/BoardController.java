package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.PuzzleLevel;
import view.BoardView;
import view.ILevelView;
import view.LevelPlayerView;

/**
 * Class to control events related to Board.
 * @author Maddy Longo
 * @author Alex Kasparek
 * @author Connor Weeks
 * @author Kunal Shah
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

	/** This board controller's builder (if in Level Builder). */
	LevelBuilder builder;

	/** This board controller's game (if in player). */
	Kabasuji game;

	/** This keeps track of the source column of the dragging piece if doing a BoardToBoardMove. */
	int sourceCol;

	/** This keeps track of the source row of the dragging piece if doing a BoardToBoardMove. */
	int sourceRow;

	/**
	 * Creates a new BoardController object with the specified parameters.
	 * @param level The level this controller modifies.
	 * @param levelView The view for the level this controller calls to update.
	 * @param builder The top-level application (Builder in this case - required for some logic).
	 */
	public BoardController(Level level, ILevelView levelView, LevelBuilder builder) {
		super();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.level = level;
		this.builder = builder;
	}

	/**
	 * Creates a new BoardController object with the specified parameters.
	 * @param level The level this controller modifies.
	 * @param levelView The view for the level this controller calls to update.
	 * @param game The top-level application (Kabasuji in this case - required for some logic).
	 */
	public BoardController(Level level, ILevelView levelView, Kabasuji game) {
		super();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.level = level;
		this.game = game;
	}

	/**
	 * Top-level function for handling mouse events (calls other function for testing).
	 */
	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}

	/**
	 * Function for handling mouse clicks (easier to use for testing).
	 * @param p Point at which the mouse was clicked.
	 * @param mouseButton Button that was clicked (used to check right or left).
	 */
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

		if (mouseButton == MouseEvent.BUTTON3) { // right click
			if (boardView.getDraggedPiece() != null) {
				level.removeActivePiece();
				level.setMoveSource(null);
				boardView.updateDraggedPiece(null);
			} else if (level.getBoard().getPiece(col, row) != null) {
				if (level instanceof PuzzleLevel || builder != null) {
					Move m;
					if (builder != null) {
						m = new BoardToBullpenMove(level, col, row, false);
					} else {
						System.out.println("In player");
						m = new BoardToBullpenMove(level, col, row, true);
					}

					if (m.doMove()) {
						if (builder != null) {
							// if we are in the level builder
							// If the move is valid (and completed), we remove the source and active pieces
							builder.pushMove(m, false);

						} else if (game != null) {
							// if we are in the player
							// end game if needed
							if (m.getEndGameStatus()) {
								new ExitLevelController((LevelPlayerView)levelView, game, level).process();
							}
						}
						level.setMoveSource(null);
						level.setActivePiece(null);
						boardView.updateDraggedPiece(null);
					}
				}
			}
		} else { // left click
			if (boardView.getDraggedPiece() != null) { // left click and dragging a piece
				Move m;
				if (level.getMoveSource() == level.getBoard()) {
					if (builder != null) {
						m = new BoardToBoardMove(level, col, row, sourceCol, sourceRow, false);
					} else {
						m = new BoardToBoardMove(level, col, row, sourceCol, sourceRow, true);
					}
				} else {
					if (builder != null) {
						m = new BullpenToBoardMove(level, level.getActivePiece(), col, row, false);
					} else {
						m = new BullpenToBoardMove(level, level.getActivePiece(), col, row, true);	
					}
				}

				if (m.doMove()) {
					if (builder != null) {
						// if we are in the level builder
						// If the move is valid (and completed), we remove the source and active pieces
						builder.pushMove(m, false);

					} else if (game != null) {
						// if we are in the player
						// end game if needed
						if (m.getEndGameStatus()) {
							new ExitLevelController((LevelPlayerView)levelView, game, level).process();
						}
					}
					level.setMoveSource(null);
					level.setActivePiece(null);
					boardView.updateDraggedPiece(null);
				}
			} else if (level.getBoard().getPiece(col, row) != null) { // left click and not dragging
				if (level instanceof PuzzleLevel || builder != null) {
					Piece pieceToDrag = level.getBoard().getPiece(col, row);
					if (pieceToDrag != null) {
						//set sourceCol and sourceRow if the activePiece was on the board
						sourceCol = level.getBoard().getPieces().get(pieceToDrag).x;
						sourceRow = level.getBoard().getPieces().get(pieceToDrag).y;

						level.setMoveSource(level.getBoard());
						level.setActivePiece(pieceToDrag);
						boardView.updateDraggedPiece(p);
					}
				}
			}
		}
		levelView.refresh();
	}

	/**
	 * Function for handling mouse movements (to update position of dragged piece).
	 */
	public void mouseMoved(MouseEvent me) {
		// Whenever the mouse is moved, check if there is an active piece
		activePiece = level.getActivePiece();

		// If so, we need to have the BoardView set and render it
		if (activePiece != null) {
			boardView.updateDraggedPiece(me.getPoint());
			boardView.repaint();
		}
	}
}