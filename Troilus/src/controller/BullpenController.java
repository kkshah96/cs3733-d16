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
import view.BullpenView;

/**
 * Class that handles events related to Bullpen.
 * @author Maddy
 *
 */
public class BullpenController extends MouseAdapter {
	protected BullpenView bpView;
	protected Level level;
	Piece activePiece;

	public BullpenController(Level level, BullpenView bpView) {
		super();
		this.bpView = bpView;
		this.level = level;
	}

	// TODO why do this??
	public void mousePressed(MouseEvent me) {
		handleMousePressed(me.getPoint(), me.getButton());
	}
	
	void handleMousePressed(Point p, int mouseButton) {
		int x = p.x;
		int y = p.y;

		Bullpen bullpen = level.getBullpen();

		// find the piece that was clicked
		Hashtable<Piece, Point> pieces = bpView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		activePiece = null;

		// check anchor square and relative squares for each piece in the bullpen
		for (Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);

			if ((anchorPoint.getX() <= x) && 
					(anchorPoint.getX() + BullpenView.SQUARE_SIZE >= x) && 
					(anchorPoint.getY() <= y) && 
					(anchorPoint.getY() + BullpenView.SQUARE_SIZE >= y)) {
				activePiece = piece;
				break;
			}

			for(Square s : piece.getSquares()) {
				if((anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) <= x) && 
						(anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= x) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) <= y) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= y)) {
					activePiece = piece;
					break;
				}
			}

			if (activePiece != null) {
				break;
			}
		}
		
		// check if a piece was clicked on, deselect currently selected piece
		if (activePiece == null) {
			level.setActivePiece(null);
			bpView.repaint();
			return;
		}

		// a right click will remove the selected piece from the bullpen
		if (mouseButton == MouseEvent.BUTTON3) {
			bullpen.removePiece(activePiece);
			bpView.repaint();
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
			bpView.repaint();
		}
	}

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