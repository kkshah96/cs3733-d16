package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Bullpen;
import model.Level;
import model.Piece;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.ILevelView;

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

	/**
	 * Creates a new instance of the BullpenController with the given parameters
	 * @param level The level of this bullpen
	 * @param levelView The view for the level of this bullpen
	 */
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
	
	// TODO Is there a reason we need a different method? 
	// No, but it's easier than creating new mouse events for testing
	void handleMousePressed(Point p, int mouseButton) {
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

		// check anchor square and relative squares for each piece in the bullpen
		for (Piece piece : keySet) {
			int anchorCol = pieces.get(piece).x;
			int anchorRow = pieces.get(piece).y;
			
			// Piece was clicked if the x coordinate is within the SQUARE_SIZE constant of the anchor point x coordinate
			// and the SQUARE_SIZE constant of the anchor point y coordinate
			/*
			if ((anchorCol <= x) && 
					(anchorCol + BullpenView.SQUARE_SIZE >= x) && 
					(anchorRow <= y) && 
					(anchorRow + BullpenView.SQUARE_SIZE >= y)) {
				activePiece = piece;
				break;
			}
			*/
			
			// Additionally, check this same condition with the rest of the squares in the piece
			for (Square s : piece.getAllSquares()) {
				int sCol = s.getCol();
				int sRow = s.getRow();
				
				if ((anchorCol + (sCol * BullpenView.SQUARE_SIZE) <= x) && 
						(anchorCol + (sCol * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= x) && 
						(anchorRow + (sRow * BullpenView.SQUARE_SIZE) <= y) && 
						(anchorRow + (sRow * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= y)) {
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
		if (activePiece == null) {
			level.setActivePiece(null);
			bullpenView.repaint();
			return;
		}

		// a right click will remove the selected piece from the bullpen
		if (mouseButton == MouseEvent.BUTTON3) {
			bullpen.removePiece(activePiece);
			bullpenView.repaint();
		} else {
			if (level.getActivePiece() == activePiece) {
				// if the piece is already selected, deselect it
				level.setActivePiece(null);
			} else {
				// set piece as active piece and redraw
				level.setMoveSource("Bullpen");
				level.setActivePiece(activePiece);
			}
			// refresh the view
			levelView.refresh();
		}
	}
	
	// TODO This requires passing the BullpenController a BoardView. We can probably find a better solution
	// TODO How about NOT having it? It is actually really annoying
	/*
	public void mouseEntered(MouseEvent me){
		activePiece = level.getActivePiece();

		if (boardView.getDraggedPiece() != null) {
			
			if(!level.getBullpen().getPieces().contains(boardView.getDraggedPiece())){
				level.getBullpen().addPiece(boardView.getDraggedPiece());
			}
			
			boardView.removeDraggedPiece();
			level.setActivePiece(null);
			
			boardView.repaint();
			bullpenView.repaint();
			
			level.setMoveSource(null);
		}
	}
	*/

	// TODO explain commented-out code
	//	public void mouseReleased(MouseEvent me) {
	//		//TODO: Expand this? Right now it will just let go of the piece and do nothing if the mouse is released in the bullpen
	//		System.out.println("Let go of the mouse!");
	//
	//			bV.removeDraggedPiece();
	//			level.getBullpen().removePiece(activePiece);
	//			level.setActivePiece(null);
	//
	//	
	//
	//	}
}