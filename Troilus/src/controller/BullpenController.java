package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.ILevelView;
import view.LevelEditorView;

/**
 * Class that handles events related to Bullpen.
 * @author Maddy
 *
 */
public class BullpenController extends MouseAdapter {
	/** The level that this bullpen is in */
	protected Level level;

	/** The view for this bullpen */
	protected BullpenView bullpenView;

	/** The view for the level containing this bullpen */
	ILevelView levelView;

	/** Any active piece in the level */
	Piece activePiece;

	/** The view for the board in this level */
	BoardView boardView;
	
	LevelBuilder builder;

	/**
	 * Creates a new instance of the BullpenController with the given parameters
	 * @param level The level of this bullpen
	 * @param levelView The view for the level of this bullpen
	 */
	public BullpenController(Level level, ILevelView levelView, LevelBuilder builder) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
		this.builder = builder;
	}
	
	public BullpenController(Level level, ILevelView levelView) {
		super();
		this.level = level;
		this.levelView = levelView;
		this.bullpenView = levelView.getBullpenView();
		this.boardView = levelView.getBoardView();
	}
	
	

	// TODO why do this??
	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}

	void handleMousePressed(Point p, int mouseButton) {
		// If a piece is being dragged we don't want to interact with the bullpen
		//if(boardView.getDraggedPiece() != null) { return; }
		
		// First obtain the x and y coordinates from the mouse press
		int x = p.x;
		int y = p.y;

		System.out.println(x);
		System.out.println(y);

		// Create a reference to the bullpen
		Bullpen bullpen = level.getBullpen();

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
				break;
			}
		}

		// check if we didn't find a piece, deselect currently selected piece
		if (activePiece == null && level.getMoveSource() == bullpen) {
			level.setActivePiece(null);
			boardView.removeDraggedPiece();
			bullpenView.repaint();
			boardView.repaint();
			return;
		}

		// a right click will remove the selected piece from the bullpen
		if(boardView.getDraggedPiece() == null) {
			if (mouseButton == MouseEvent.BUTTON3) {
				if(levelView instanceof LevelEditorView) {
					bullpen.removePiece(activePiece);
					level.setActivePiece(null);
				}
			} else {
				if (level.getActivePiece() == activePiece) {
					// if the piece is already selected, deselect it
					level.setActivePiece(null);
				} else {
					// set piece as active piece and set the source as the bullpenview and redraw
					level.setMoveSource(bullpenView);
					level.setActivePiece(activePiece); 
				}
			}
		} else {
			if (mouseButton == MouseEvent.BUTTON3) {
				if(levelView instanceof LevelEditorView) {
					bullpen.addPiece(level.getActivePiece());
					boardView.removeDraggedPiece();
					level.setMoveSource(null);
					level.setActivePiece(null);
					bullpenView.repaint();
					boardView.repaint();
				}
			} else {
				if (boardView.getDraggedPiece() == activePiece) {
					// if the piece is already selected, deselect it
					boardView.removeDraggedPiece();
					level.setActivePiece(null);
					
				} else {
					// set piece as active piece and set the source as the bullpenview and redraw
					level.setMoveSource(bullpenView);
					level.setActivePiece(activePiece); 
					//boardView.removeDraggedPiece();
					boardView.repaint();
				}
			}
		}
		// Refresh view regardless of what happened
		levelView.refresh();
	}
}
