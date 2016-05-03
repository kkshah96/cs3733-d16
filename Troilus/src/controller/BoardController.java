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
import view.LevelEditorView;
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

	/** This board controller's builder (if in Level Builder)**/
	LevelBuilder builder;

	/** This board controller's game (if in player)**/
	Kabasuji game;

	int sourceCol;
	int sourceRow;

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
		int col = (x - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		int row = (y - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;

		if (mouseButton == MouseEvent.BUTTON3) { // right click
			if (boardView.getDraggedPiece() != null) {
				level.removeActivePiece();
				level.setMoveSource(null);
				boardView.updateDraggedPiece(null);
			} else if (level.getBoard().getPiece(col, row) != null) {
				Move m = new BoardToBullpenMove(level, col, row);
				
				if (m.doMove()) {
					if (builder != null) {
						// if we are in the level builder
						// If the move is valid (and completed), we remove the source and active pieces
						builder.pushMove(m);

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
		} else { // left click
			if (boardView.getDraggedPiece() != null) { // left click and dragging a piece
				Move m;
				if (level.getMoveSource() == level.getBoard()) {
					m = new BoardToBoardMove(level, col, row, sourceCol, sourceRow);
				} else {
					m = new BullpenToBoardMove(level, level.getActivePiece(), col, row);
				}

				if (m.doMove()) {
					if (builder != null) {
						// if we are in the level builder
						// If the move is valid (and completed), we remove the source and active pieces
						builder.pushMove(m);

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
				sourceCol = col;
				sourceRow = row;
				level.setMoveSource(level.getBoard());
				Piece pieceToDrag = level.getBoard().getPiece(sourceCol, sourceRow);
				if (pieceToDrag != null) {
					level.setActivePiece(pieceToDrag);
					boardView.updateDraggedPiece(p);
				}
			}
		}
		levelView.refresh();
	}

	public void mouseMoved(MouseEvent me){
		// Whenever the mouse is moved, check if there is an active piece
		activePiece = level.getActivePiece();

		// If so, we need to have the BoardView set and render it
		if (activePiece != null) {
			boardView.updateDraggedPiece(me.getPoint());
			boardView.repaint();
		}
	}

}