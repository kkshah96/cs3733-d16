package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import view.BoardView;

/**
 * Handles logic for selecting a square in Level Builder.
 * @author Alexander Kasparek
 * @author Maddy Longo
 *
 */
public class SelectSquareController extends MouseAdapter {
	/** The level used */
	Level level;
	
	/** The view for the board inside the level */
	BoardView boardView;

	/**
	 * Creates a new instance of SelectSquareController with the following parameters
	 * @param level Reference to the level being used
	 * @param boardView Reference to the boundary object of the board
	 */
	public SelectSquareController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	/**
	 * Handles the mouse being pressed on a board square.<p>
	 * @param e The MouseEvent (press).
	 * 
	 */
	public void mousePressed(MouseEvent e) {
		// First check if there is an active piece
		if (level.getActivePiece() != null) {
			return; // Return if there is- we cannot select a square under a piece
		}
		
		// Obtain the coordinates of the click
		int x = e.getX();
		int y = e.getY();
		
		// Ensure the click occurred within the board bounds
		if (x > BoardView.WIDTH + BoardView.WIDTH_OFFSET || x < BoardView.WIDTH_OFFSET
				|| y > BoardView.HEIGHT + BoardView.HEIGHT_OFFSET || y < BoardView.HEIGHT_OFFSET) {
		} else {
			// Set the active square on the board and repaint
			int col = (x-BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE; // row and col were switched here
			int row = (y-BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
			
			level.getBoard().setActiveSquare(col, row);
			boardView.repaint();
		}//end check bounds else
	}
}