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
	Level level;
	BullpenView bullpenView;
	PaletteView paletteView;

	public MovePiecePaletteToBullpenController(Level level, BullpenView bullpenView, PaletteView paletteView) {
		this.level = level;
		this.bullpenView = bullpenView;
		this.paletteView = paletteView;
	}

	public void mousePressed(MouseEvent me) {
		if (me.getButton() == MouseEvent.BUTTON3) {
			return;
		}

		Bullpen bp = level.getBullpen();

		Point clickPoint = me.getPoint();
		Hashtable<Piece, Point> pieces = paletteView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();

		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			// added by Connor <-- stud muffin
			/*
			if (isPieceClicked (anchorPoint, clickPoint)) {
				bp.addPiece(PieceFactory.getPiece(piece.getType()));
				bullpenView.repaint();
				return;
			}
			 */

			for(Square s : piece.getAllSquares()) {
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
		int aCol = anchorPoint.x;
		int aRow = anchorPoint.y;
		int sCol = s.getCol();
		int sRow = s.getRow();
		int size = PaletteView.SQUARE_SIZE;
		int cCol = clickPoint.x;
		int cRow = clickPoint.y;

		return (aCol + (sCol * size) <= cCol) && 
				(aCol + (sCol * size) + size >= cCol) && 
				(aRow + (sRow * size) <= cRow) && 
				(aRow+ (sRow * size) + size >= cRow);
	}
}