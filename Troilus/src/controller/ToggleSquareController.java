package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import model.Board;
import model.Level;
import model.LevelBuilder;
import view.LevelLoaderView;

/**
 * Toggles the selected Square on the board on or off, depending on its current state.
 * <p>
 * builder = the current builder instance. <br>
 * <p>
 * level = the current level being edited. <br>
 * <p>
 * editorView = the level editor window. <br>
 * <p>
 * @author Alexander Kasparek
 */
public class ToggleSquareController implements ActionListener {
	Level level;
	LevelBuilder builder;
	LevelLoaderView editorView;

	public ToggleSquareController(LevelBuilder builder,Level level, LevelLoaderView editorView) {
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if(x > 370 || x < 10 || y > 390 || y < 30) {
			System.out.println("Error: Did not click within the board");
		}

		else {
			Board board = level.getBoard();
			if (board.getActiveSquare() == null){
				System.out.print("No piece selected.");
			} else {
				board.toggleSquare();
			}
		}//end check bounds else
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.getBoard().toggleSquare();
	}
}