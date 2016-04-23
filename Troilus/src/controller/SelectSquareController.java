package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.LevelBuilder;
import view.BoardView;
import view.LevelEditorView;

/**
 * 
 * @author Alexander Kasparek
 *
 */
public class SelectSquareController extends MouseAdapter {
	Level level;
	//LevelBuilder builder;
	BoardView boardView;

	public SelectSquareController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		// TODO: Change from hard-coded values!!!
		if (x > BoardView.WIDTH + BoardView.WIDTH_OFFSET || x < BoardView.WIDTH_OFFSET
				|| y > BoardView.HEIGHT + BoardView.HEIGHT_OFFSET || y < BoardView.HEIGHT_OFFSET) {
			System.out.println("Error: Did not click within the board");
		} else {	
			int row = (x-BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
			int col = (y-BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;

			level.getBoard().setActiveSquare(row, col);
			boardView.repaint();
		}//end check bounds else
	}
}