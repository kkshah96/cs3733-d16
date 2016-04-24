package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Square;

/**
 * Contains logic for drawing Kabasuji Squares.
 * 
 * SquareDrawer handles painting a Square as an AWT Rectangle given an x, y,
 * width, releaseNumber (if drawing a ReleaseSquare) and color.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 *
 */
public class SquareDrawer {
	public static final Color VALID_COLOR = Color.BLUE;
	public static final Color INVALID_COLOR = Color.BLACK;
	public static final Color RED = Color.RED;
	public static final Color YELLOW = Color.YELLOW;
	public static final Color GREEN = Color.GREEN;
	int x, y, width;
	Integer releaseNumber; // TODO How do we handle this without instanceof?
	Color c;

	public SquareDrawer() {
		releaseNumber = null;
		c = null;
		width = BoardView.SQUARE_SIZE;
	}
	
	private Color findColor(Square square) {
		if (square.isValid()) {
			return VALID_COLOR;
		} else {
			return INVALID_COLOR;
		}
	}
	
	public void paint(Graphics g, int x, int y, Square square) {
		c = Color.BLACK;

		g.drawRect(x, y, width, width);
		
		if (!(releaseNumber == null)) {
			g.drawString("" + releaseNumber, x + 5, y + 5); //TODO: Change 5 to some buffer value
		}
		
		c = findColor(square);
		
		if (!(c == null)) {
			g.setColor(c);
		}
		g.fillRect(x+1, y+1, width-2, width-2);
	}

	// TODO: Shitty code is shitty, do we want to pass this in to the constructor instead of the paint method or something?
	public void paint(Graphics g, int x, int y, Integer releaseNumber, Color color) {
		c = Color.BLACK;
		
		g.drawRect(x, y, width, width);

		if (!(releaseNumber == null)) {
			g.drawString("" + releaseNumber, x + 5, y + 5); //TODO: Change 5 to some buffer value
		}

		c = color;
		if (!(c == null)) {
			g.setColor(c);
		}
		g.fillRect(x+1, y+1, width-2, width-2);
	}
}