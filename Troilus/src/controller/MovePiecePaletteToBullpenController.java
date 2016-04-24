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
import model.PieceFactory;
import model.Square;
import view.LevelLoaderView;
import view.BullpenView;
import view.LevelEditorView;
import view.PaletteView;


/**
 * @author Dan Alfred
 * @author Connor Weeks
 *
 */
public class MovePiecePaletteToBullpenController extends MouseAdapter {

	LevelBuilder builder;
	Level level;
	LevelLoaderView loaderView;
	LevelEditorView editorView;

	public MovePiecePaletteToBullpenController(LevelBuilder builder, Level level, LevelLoaderView loaderView, LevelEditorView editorView) {
		this.builder = builder;
		this.level = level;
		this.loaderView = loaderView;
		this.editorView = editorView;
	}

	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right click");
			return;
		}
		
		Bullpen bp = level.getBullpen();
		BullpenView bpView = editorView.getBullpenView();
		
		Point p = e.getPoint();
		PaletteView pView = editorView.getPaletteView();
		Hashtable<Piece, Point> pieces = pView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		//System.out.println(p);
		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
//			System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET);
//			System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET + PaletteView.SQUARE_SIZE);
//			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET);
//			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET + PaletteView.SQUARE_SIZE);
//			System.out.println("---");

			// added by Connor <-- stud muffin
			if((anchorPoint.getX() <= p.getX()) && 
					(anchorPoint.getX() + PaletteView.SQUARE_SIZE >= p.getX()) && 
					(anchorPoint.getY() <= p.getY()) && 
					(anchorPoint.getY() + PaletteView.SQUARE_SIZE >= p.getY())) {
				bp.addPiece(PieceFactory.getPiece(piece.getType()));
				bpView.repaint();
				return;
			}
			
			for(Square s : piece.getSquares()) {
				if((anchorPoint.getX() + (s.getCol() * PaletteView.SQUARE_SIZE) <= p.getX()) && 
						(anchorPoint.getX() + (s.getCol() * PaletteView.SQUARE_SIZE) + PaletteView.SQUARE_SIZE >= p.getX()) && 
						(anchorPoint.getY() + (s.getRow() * PaletteView.SQUARE_SIZE) <= p.getY()) && 
						(anchorPoint.getY() + (s.getRow() * PaletteView.SQUARE_SIZE) + PaletteView.SQUARE_SIZE >= p.getY())) {
					bp.addPiece(PieceFactory.getPiece(piece.getType()));
					bpView.repaint();
					return;
				}
			}

		}

	}

}
