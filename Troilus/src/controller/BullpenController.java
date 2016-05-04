package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.PuzzleLevel;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.ILevelView;
import view.LevelPlayerView;

/**
 * Class that handles events related to the Bullpen for the current level.
 * @author Maddy Longo 
 * @author Alex Kasparek
 * @author Connor Weeks
 * @author Kunal Kunal
 * @author Dan Alfred
 * 
 */
public class BullpenController extends MouseAdapter {
	/** The level that this bullpen is in. */
	protected Level level;

	/** The view for this bullpen. */
	protected BullpenView bullpenView;

	/** The view for the level containing this bullpen. */
	ILevelView levelView;

	/** Any active piece in the level. */
	Piece activePiece;

	/** The view for the board in this level. */
	BoardView boardView;

	/** The LevelBuilder. */
	LevelBuilder builder;

	/**The game**/
	Kabasuji game;

	/**
	 * Creates a new instance of the BullpenController with the given parameters, if in the LevelBuilder.
	 * @param level The level of this bullpen.
	 * @param levelView The view for the level of this bullpen.
	 * @param builder The LevelBuilder application.
	 */
	public BullpenController(Level level, ILevelView levelView, LevelBuilder builder) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
		this.builder = builder;
		boardView.updateDraggedPiece(null);
	}

	/**
	 * Creates a new instance of the BullpenController with the given parameters,
	 * if in the Kabasuji application.
	 * @param level The level of this bullpen.
	 * @param levelView The view for the level of this bullpen.
	 * @param game The Kabasuji game application.
	 */
	public BullpenController(Level level, ILevelView levelView, Kabasuji game) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
		this.game = game;
		boardView.updateDraggedPiece(null);
	}

	/**
	 * Top-level function for handling mouse events (Makes testing easier).
	 */
	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}

	/**
	 * Function to handle mouse clicks.
	 * @param p Point at which mouse was clicked.
	 * @param mouseButton Button which was clicked.
	 */
	void handleMousePressed(Point p, int mouseButton) {
		//get coordinates of the mouse press
		int x = p.x;
		int y = p.y;

		if (mouseButton == MouseEvent.BUTTON3) { // right click
			if (boardView.getDraggedPiece() != null) { // right click and dragging
				level.removeActivePiece();
				level.setMoveSource(null);
				boardView.updateDraggedPiece(null);
			} else if (builder != null) { // right click and not dragging
				RemoveFromBullpenMove m = new RemoveFromBullpenMove(level, getClickedPiece(x, y));
				if (m.doMove()) {
					level.setMoveSource(null);
					boardView.updateDraggedPiece(null);
					bullpenView.repaint();

					builder.pushMove(m, false);
					return;
				}
			}
		} else {
			if (boardView.getDraggedPiece() != null) { // left-click while dragging
				if (level.getMoveSource() == level.getBoard()) { // Move from Board
					Move m;
					if (builder != null) {
						m = new BoardToBullpenMove(level, level.getActivePiece(), false);
					} else {
						m = new BoardToBullpenMove(level, level.getActivePiece(), true);
					}
					if (m.doMove()) {
						if (builder != null) {
							// if we are in the level builder
							builder.pushMove(m, false);

						} else {
							// if we are in the player
							// end game if needed
							if (m.getEndGameStatus()) {
								new ExitLevelController((LevelPlayerView)levelView, game, level).process();
							}
						}
						// If the move is valid (and completed), we remove the source and active pieces
						level.setMoveSource(null);
						level.setActivePiece(null);
						boardView.updateDraggedPiece(null);
					}
				} else { // Click in bullpen
					if (level.getMoveSource() == level.getBullpen()) { // Piece came from bullpen
						level.setMoveSource(null);
						level.setActivePiece(null);
						boardView.updateDraggedPiece(null);
					} else { // Piece came from board
						Move btbm;
						if (builder != null) {
							btbm = new BoardToBullpenMove(level, level.getActivePiece(), false);
						} else {
							btbm = new BoardToBullpenMove(level, level.getActivePiece(), true);
						}
						if (btbm.doMove()) {
							if (builder != null) {
								builder.pushMove(btbm, false);
							} else if (level instanceof PuzzleLevel) {
								if (btbm.getEndGameStatus()) {
									new ExitLevelController((LevelPlayerView)levelView, game, level).process();
								}
							} else { // Not a valid move!
								levelView.refresh();
								return;
							}
							level.setMoveSource(level.getBullpen());
							level.setActivePiece(getClickedPiece(x, y));
						}
					}
				}
			} else { // left-click while not dragging
				Piece clickedPiece = getClickedPiece(x, y);
				if (clickedPiece != null) { // Clicked a piece
					level.setMoveSource(level.getBullpen());
					level.setActivePiece(clickedPiece);
				}
			}
		}
		levelView.refresh();
	}

	// Ugly quick hack to get stuff working quickly
	/**
	 * Finds and returns the piece at the given pixel coordinates.
	 * WARNING- Returns null if no piece at the given location
	 * @param x X pixel coordinate of requested piece
	 * @param y Y pixel coordinate of requested piece
	 * @return Returns a reference to the piece at the provided location, or null if no piece is there
	 */
	Piece getClickedPiece(int x, int y) {
		// find the piece that was clicked
		Hashtable<Piece, Point> pieces = bullpenView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		activePiece = null;

		int size = BullpenView.SQUARE_SIZE;
		// check anchor square and relative squares for each piece in the bullpen
		for (Piece piece : keySet) {
			int aCol = pieces.get(piece).x;
			int aRow = pieces.get(piece).y;

			// Piece was clicked if the x coordinate is within the SQUARE_SIZE constant of each point's
			// x coordinate and the SQUARE_SIZE constant of each point's y coordinate
			for (Square s : piece.getAllSquares()) {
				int sCol = s.getCol();
				int sRow = s.getRow();

				if ((aCol + (sCol * size) <= x) && 
						(aCol + (sCol * size) + size >= x) && 
						(aRow + (sRow * size) <= y) && 
						(aRow + (sRow * size) + size >= y)) {
					activePiece = piece;
					break;
				}
			}

			// If we have found a piece, exit the for loop
			if (activePiece != null) {
				return activePiece;
			}
		}

		return activePiece;
	}
}