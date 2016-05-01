package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Level;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelLoaderView;

public class TestFileInOutControllers extends TestCase {

	public void test() {
		LevelBuilder lb = new LevelBuilder();
		LevelLoaderView loaderView = new LevelLoaderView(lb);
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		Level level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), new Palette(), 8);
		
		int oldNumLevels = lb.getNumLevels();
		lb.addLevel(level);
		assertEquals(oldNumLevels+1, lb.getNumLevels());
		SaveLevelController save = new SaveLevelController(lb);
		save.actionPerformed(new ActionEvent(loaderView, 0, null));
		
		LevelFileInputController input = new LevelFileInputController();
		ArrayList<Level> levels = input.getLevels();		
		
	}
	
}
