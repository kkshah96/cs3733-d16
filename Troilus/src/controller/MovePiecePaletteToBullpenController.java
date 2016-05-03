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
 * Class to encapsulate data for piece move from Palette to Bullpen.
 * @author Dan Alfred
 * @author Connor Weeks
 * @author Maddy Longo
 *
 */
public class MovePiecePaletteToBullpenController extends MouseAdapter {
	/** The level containing the palette and bullpen */
	Level level;
	
	/** The view for the bullpen here */
	BullpenView bullpenView;
	
	/** The view for the palette here */
	PaletteView paletteView;

	/**
	 * Creates a new instance of MovePiecePaletteToBullpenController with the specified objects
	 * @param level Level objecting containing bullpen and board to be modified
	 * @param bullpenView The view for the bullpen object modified
	 * @param paletteView The view for the palette object modified
	 */
	public MovePiecePaletteToBullpenController(Level level, BullpenView bullpenView, PaletteView paletteView) {
		this.level = level;
		this.bullpenView = bullpenView;
		this.paletteView = paletteView;
	}

	public void mousePressed(MouseEvent me) {
		// First check if a right click occurred- if so, do nothing
		if (me.getButton() == MouseEvent.BUTTON3) {
			return;
		}

		Bullpen bp = level.getBullpen();

		// Obtain the coordinates from the mouse click, and flatten our piece table into a set for iteration
		Point clickPoint = me.getPoint();
		Hashtable<Piece, Point> pieces = paletteView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();

		// Loop through each piece in the set
		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);

			// Loop through each square in the piece
			for(Square s : piece.getAllSquares()) {
				// Check if a square within the piece is clicked (means this is the piece selected)
				if (isSquareClicked(anchorPoint, clickPoint, s)) {
					// If so, add to bullpen and repaint view
					bp.addPiece(PieceFactory.getPiece(piece.getType()));
					bullpenView.repaint();
					return;
				}
			}
		}
	}

	// TODO clean these up
	/** Helper function for mousePressed
	 * @param anchorPoint Point object containing top-left coordinate for the anchorSquare
	 * @param clickPoint Point object for the location of the mouse event
	 * @return True if any squares in the given anchor point fall within the click point, false otherwise
	 */
	private boolean isPieceClicked(Point anchorPoint, Point clickPoint) {
		return (anchorPoint.getX() <= clickPoint.getX()) && 
				(anchorPoint.getX() + PaletteView.SQUARE_SIZE >= clickPoint.getX()) && 
				(anchorPoint.getY() <= clickPoint.getY()) && 
				(anchorPoint.getY() + PaletteView.SQUARE_SIZE >= clickPoint.getY());
	}

	/** Helper function for mousePressed
	 * @param anchorPoint Point object containing the top-left coordinate for the anchorSquare
	 * @param clickPoint Point object for the location of the mouse event
	 * @param s The square object to check the bounds of
	 * @return True if the given square falls within the click point, false otherwise
	 */
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