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
import view.LevelEditorView;

public class BullpenController extends MouseAdapter{
	
	protected BullpenView bullpenView;
	protected Level level;
	Piece activePiece;
	
	public BullpenController(Level level, BullpenView bullpenBiew) {
		super();
		this.bullpenView = bullpenBiew;
		this.level = level;
	}
	
	
	public void mousePressed(MouseEvent me){
		int x = me.getX();
		int y = me.getY();
		
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
		
		// check if a piece was clicked on, deselect currently selected piece
		if (selectedPiece == null) {
			System.out.println("Selectedpiece is NULL");
			level.setActivePiece(null);
			bullpenView.repaint();
			return;
		}
		
		
		// a right click will remove the selected piece from the bullpen
		if(me.getButton() == MouseEvent.BUTTON3) {
			bullpen.removePiece(selectedPiece);
			bullpenView.repaint();
		} else {
			if (level.getActivePiece() == selectedPiece) {
				// if the piece is already selected, deselect it
				level.setActivePiece(null);
			} else {
				// set piece as active piece and redraw
				level.setActivePiece(selectedPiece);
				bullpenView.addDraggedPiece(selectedPiece, new Point(selectedPiece.getRow(), selectedPiece.getCol()));
				bullpenView.repaint();
			}
			
			// refresh the view
			bullpenView.repaint();
		}
	}
		
	
	
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
