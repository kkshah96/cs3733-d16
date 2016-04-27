package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Bullpen;
import model.Level;
import model.Piece;
import model.PieceFactory;
import model.Square;
import view.BullpenView;
import view.PaletteView;

/**
 * @author Dan Alfred
 * @author Connor Weeks
 * @author Maddy Longo
 *
 */
public class MovePiecePaletteToBullpenController extends MouseAdapter {
	//LevelBuilder builder;
	Level level;
	//LevelLoaderView loaderView;
	//LevelEditorView editorView;
	BullpenView bullpenView;
	PaletteView paletteView;

	public MovePiecePaletteToBullpenController(Level level, BullpenView bullpenView, PaletteView paletteView) {
		this.level = level;
		this.bullpenView = bullpenView;
		this.paletteView = paletteView;
	}

	public void mousePressed(MouseEvent me) {
		if(me.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right click");
			return;
		}

		Bullpen bp = level.getBullpen();
		//BullpenView bpView = editorView.getBullpenView();

		Point clickPoint = me.getPoint();
		//PaletteView pView = editorView.getPaletteView();
		Hashtable<Piece, Point> pieces = paletteView.getDrawnPieces();
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
			if (isPieceClicked (anchorPoint, clickPoint)) {
				bp.addPiece(PieceFactory.getPiece(piece.getType()));
				bullpenView.repaint();
				return;
			}

			for(Square s : piece.getSquares()) {
				if (isSquareClicked(anchorPoint, clickPoint, s)) {
					bp.addPiece(PieceFactory.getPiece(piece.getType()));
					bullpenView.repaint();
					return;
				}
			}
		}
	}

	// TODO clean these up
	/** Helper function for mousePressed */
	private boolean isPieceClicked(Point anchorPoint, Point clickPoint) {
		return (anchorPoint.getX() <= clickPoint.getX()) && 
				(anchorPoint.getX() + PaletteView.SQUARE_SIZE >= clickPoint.getX()) && 
				(anchorPoint.getY() <= clickPoint.getY()) && 
				(anchorPoint.getY() + PaletteView.SQUARE_SIZE >= clickPoint.getY());
	}
	
	/** Helper function for mousePressed */
	private boolean isSquareClicked(Point anchorPoint, Point clickPoint, Square s) {
		return (anchorPoint.getX() + (s.getCol() * PaletteView.SQUARE_SIZE) <= clickPoint.getX()) && 
				(anchorPoint.getX() + (s.getCol() * PaletteView.SQUARE_SIZE) + PaletteView.SQUARE_SIZE >= clickPoint.getX()) && 
				(anchorPoint.getY() + (s.getRow() * PaletteView.SQUARE_SIZE) <= clickPoint.getY()) && 
				(anchorPoint.getY() + (s.getRow() * PaletteView.SQUARE_SIZE) + PaletteView.SQUARE_SIZE >= clickPoint.getY());
	}
}