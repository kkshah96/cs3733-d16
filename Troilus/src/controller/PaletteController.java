package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.PieceFactory;
import model.Square;
import view.BullpenView;
import view.ILevelView;
import view.PaletteView;

/**
 * Class to encapsulate data for piece move from Palette to Bullpen.
 * @author Dan Alfred
 * @author Connor Weeks
 * @author Maddy Longo
 * @author Kunal Shah
 *
 */
public class PaletteController extends MouseAdapter {
	/** The level containing the palette and bullpen */
	Level level;

	/** The view for the bullpen here */
	BullpenView bullpenView;

	/** The view for the palette here */
	PaletteView paletteView;
	
	/** The builder containing this palette */
	LevelBuilder builder;

	/**
	 * Creates a new instance of MovePiecePaletteToBullpenController with the specified objects
	 * @param level Level objecting containing bullpen and board to be modified
	 * @param levelView The view interface for the player/builder
	 * @param builder Reference to the builder this palette controller refers to
	 */
	public PaletteController(Level level, ILevelView levelView, LevelBuilder builder) {
		this.level = level;
		this.bullpenView = levelView.getBullpenView();
		this.paletteView = levelView.getPaletteView();
		this.builder = builder;
	}

	public void mousePressed(MouseEvent me) {
		// First check if a right click occurred- if so, do nothing
		if (me.getButton() == MouseEvent.BUTTON3) {
			return;
		}

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

					PaletteToBullpenMove m = new PaletteToBullpenMove(level, PieceFactory.getPiece(piece.getType()));
					if (m.doMove()) {
						builder.pushMove(m, false);
					}
					
					bullpenView.repaint();
					return;
				}
			}
		}
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