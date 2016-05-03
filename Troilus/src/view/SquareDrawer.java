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
 * @author Alex Kasparek
 *
 */
public class SquareDrawer {
	/** Constant to define the color for covered squares on the board */
	public static final Color COVERED_COLOR = Color.GREEN;
	
	/** Constant to define the color for valid squares on the board */
	public static final Color VALID_COLOR = Color.BLACK;
	
	/** Constant to define the color for the valid active square on the board */
	public static final Color VALID_ACTIVE_COLOR = Color.GRAY;
	
	/** Constant to define the color for the active, invalid square on the board */
	public static final Color INVALID_ACTIVE_COLOR = Color.RED;
	
	/** Constant to define the color for invalid squares on the board */
	public static final Color INVALID_COLOR = Color.LIGHT_GRAY;
	
	/** Constant to define the color for hint squares */
	public static final Color HINT_COLOR = Color.YELLOW;
	
	/** Constant to define the gap in pixels between the top of a square and where a release number is drawn */
	public static final int BUFFER_HEIGHT = 20;
	
	/** Constant to define the gap in pixels between the left of a square and where a release number is drawn */
	public static final int BUFFER_WIDTH = 10;
	
	/** Contains the size of the BoardView's square size */
	int size;
	
	/** The board containing the squares to draw */
	Board board;

	/**
	 * Creates a new instance of SquareDrawer given the provided board
	 * @param board Reference to the board entity object
	 */
	public SquareDrawer(Board board) {
		this.board = board;
		size = BoardView.SQUARE_SIZE;
	}

	/**
	 * Determines the color of a given square depending on its characteristics
	 * @param square Reference to square entity object to obtain color for
	 * @return AWT Color object for the given square
	 */
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

	/**
	 * The main paint method for SquareDrawer. Draws a provided square to a provided graphics object at a project location
	 * @param g Reference to the Graphics object to draw to
	 * @param x X coordinate to draw the square at
	 * @param y Y coordinate to draw the square at
	 * @param square Reference to the square to be drawn
	 */
	public void paint(Graphics g, int x, int y, Square square) {
		// Draw correct edge color based on hint status
		if (square.isHint()) {
			g.setColor(HINT_COLOR);
		} else {
			g.setColor(Color.WHITE);
		}
		g.drawRect(x, y, size - 1, size - 1);
		
		// Draw correct fill color based on square type and status
		Color c = findColor(square);
		if (c != null) {
			g.setColor(c);
			g.fillRect(x + 1, y + 1, size - 2, size - 2);
		}
		
		// Display numbers for ReleaseSquares
		if (square instanceof ReleaseSquare) {
			int releaseNumber = ((ReleaseSquare) square).getNumber();
			Color releaseColor = ((ReleaseSquare) square).getNumberColor();

			if (releaseColor != null && releaseNumber > 0 && square.isValid()) {
				g.setColor(releaseColor);
				g.drawString("" + releaseNumber, x + BUFFER_WIDTH, y + BUFFER_HEIGHT);
			} else if(releaseNumber == 0 && square.isValid()){
				g.setColor(c);
				g.fillRect(x + 1, y + 1, size - 2, size - 2);
			}
		}
	}
}