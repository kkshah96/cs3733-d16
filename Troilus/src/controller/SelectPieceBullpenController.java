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
 * Controls the selection and removal of pieces in the bullpen.
 * 
 * @author Connor Weeks
 *
 */
public class SelectPieceBullpenController extends MouseAdapter {

	Level level;
	BullpenView bullpenView;
	
	public SelectPieceBullpenController(Level level, BullpenView bullpenView) {
		this.level = level;
		this.bullpenView = bullpenView;
	}
	
	public void mousePressed(MouseEvent e) {
				
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("Clicked on (" + x + ", " + y + ")");
		
		Bullpen bullpen = level.getBullpen();
		
		// find the piece that was clicked
		Hashtable<Piece, Point> pieces = bullpenView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		Piece selectedPiece = null;
		
		// check anchor square and relative squares for each piece in the bullpen
		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);

			if((anchorPoint.getX() <= x) && 
					(anchorPoint.getX() + BullpenView.SQUARE_SIZE >= x) && 
					(anchorPoint.getY() <= y) && 
					(anchorPoint.getY() + BullpenView.SQUARE_SIZE >= y)) {
				selectedPiece = piece;
				break;
			}
			
			for(Square s : piece.getSquares()) {
				if((anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) <= x) && 
						(anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= x) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) <= y) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= y)) {
					selectedPiece = piece;
					break;
				}
			}
			
			if (selectedPiece != null) {
				break;
			}
		}
		
		// check if a piece was clicked on
		if (selectedPiece == null) {
			return;
		}
		
		System.out.println("Selected Piece");
		
		// a right click will remove the selected piece from the bullpen
		if(e.getButton() == MouseEvent.BUTTON3) {
			bullpen.removePiece(selectedPiece);
			bullpenView.repaint();
		}
		else {
			// set piece as active piece and redraw
			level.setActivePiece(selectedPiece);
			bullpenView.repaint();
		}
		
		
	}
	

}
