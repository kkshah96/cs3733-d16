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
	Level level;
	BoardView boardView;

	public SelectSquareController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	public void mousePressed(MouseEvent e) {
		if (level.getActivePiece() != null) {
			return; // Draging a piece
		}
		
		int x = e.getX();
		int y = e.getY();
		
		if (x > BoardView.WIDTH + BoardView.WIDTH_OFFSET || x < BoardView.WIDTH_OFFSET
				|| y > BoardView.HEIGHT + BoardView.HEIGHT_OFFSET || y < BoardView.HEIGHT_OFFSET) {
			System.out.println("Error: Did not click within the board");
		} else {
			int col = (x-BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE; // row and col were switched here
			int row = (y-BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;

			level.getBoard().setActiveSquare(col, row);
			boardView.repaint();
		}//end check bounds else
	}
}