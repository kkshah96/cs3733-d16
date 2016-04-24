package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Board;
import model.LightningSquare;
import model.ReleaseSquare;
import model.Square;

/**
 * Contains logic for drawing Kabasuji Squares
 * 
 * SquareDrawer handles painting a Square as an AWT Rectangle given an x, y, width, releaseNumber (if drawing a ReleaseSquare) and color
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 *
 */
public class SquareDrawer {
	public static final Color VALID_COLOR = Color.CYAN;
	public static final Color VALID_ACTIVE_COLOR = Color.BLUE;
	public static final Color INVALID_ACTIVE_COLOR = Color.DARK_GRAY;
	public static final Color INVALID_COLOR = null;
	int x, y, size;
	Integer releaseNumber; // TODO How do we handle this without instanceof?
	Board board;

	public SquareDrawer(Board board) {
		this.board = board;
		releaseNumber = null;
		size = BoardView.SQUARE_SIZE;
	}

	private Color findColor(Square square) {
		if (square instanceof LightningSquare) {
			if (((LightningSquare) square).isCovered()) {
				return Color.GREEN;
			}
		}

		if (square.equals(board.getActiveSquare())) {
			if (square.isValid()) {
				return VALID_ACTIVE_COLOR;
			} else {
				return INVALID_ACTIVE_COLOR;
			}
		} else {
			if (square.isValid()) {
				return VALID_COLOR;
			} else {
				return INVALID_COLOR;
			}
		}
	}

	public void paint(Graphics g, int x, int y, Square square) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, size, size);

		Color c = findColor(square);
		if (c != null) {
			g.setColor(c);
			g.fillRect(x+1, y+1, size-2, size-2);
		}

		if (square instanceof ReleaseSquare) {
			int releaseNumber = ((ReleaseSquare) square).getNumber();
			Color releaseColor = ((ReleaseSquare) square).getNumberColor();

			if (releaseNumber == 0 || releaseColor == null) {
				return;
			}

			if (releaseColor.equals("Yellow")) {
				g.setColor(Color.YELLOW);
			} else if (releaseColor.equals("Red")) {
				g.setColor(Color.RED);
			} else {
				g.setColor(Color.GREEN);
			}
			
			g.drawString("" + releaseNumber, x + 5, y + 5); //TODO: Change 5 to some buffer value
		}
	}
}