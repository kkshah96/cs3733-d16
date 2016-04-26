package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Board;
import model.LightningSquare;
import model.ReleaseSquare;
import model.Square;

/**
 * Contains logic for drawing Kabasuji Squares.
 * 
 * SquareDrawer handles painting a Square as an AWT Rectangle given an
 * x, y, width, releaseNumber (if drawing a ReleaseSquare) and color.
 * 
 * @author Kunal Shah
 * @author Maddy Longo
 *
 */
public class SquareDrawer {
	public static final Color COVERED_COLOR = Color.GREEN;
	public static final Color VALID_COLOR = Color.BLACK;
	public static final Color VALID_ACTIVE_COLOR = Color.GRAY;
	public static final Color INVALID_ACTIVE_COLOR = Color.RED;
	public static final Color INVALID_COLOR = Color.LIGHT_GRAY;
	public static final int BUFFER_HEIGHT = 20;
	public static final int BUFFER_WIDTH = 10;
	int x, y, size;
	Board board;

	public SquareDrawer(Board board) {
		this.board = board;
		size = BoardView.SQUARE_SIZE;
	}

	private Color findColor(Square square) {
		if (square instanceof LightningSquare) {
			if (((LightningSquare) square).isCovered()) {
				return COVERED_COLOR;
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
			g.fillRect(x + 1, y + 1, size - 2, size - 2);
		}

		if (square instanceof ReleaseSquare) {
			int releaseNumber = ((ReleaseSquare) square).getNumber();
			Color releaseColor = ((ReleaseSquare) square).getNumberColor();

			if (releaseColor != null && releaseNumber > 0 && square.isValid()) {
				g.setColor(releaseColor);
				g.drawString("" + releaseNumber, x + BUFFER_WIDTH, y + BUFFER_HEIGHT);
			} else {
				g.fillRect(x + 1, y + 1, size - 2, size - 2);
			}
		}
	}
}