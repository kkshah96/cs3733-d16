package controller;

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
	LevelLoaderView loaderView;
	ArrayList<Level> levels;
	LevelBuilder lb;
	Level level;
	
	public void setUp() {
		lb = new LevelBuilder();
		loaderView = new LevelLoaderView(lb);
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), Palette.getInstance(), 8);
		
		LevelFileInputController input = new LevelFileInputController();
		levels = input.getLevels();
	}
	
	public void testBasic() {
		int oldNumLevels = lb.getNumLevels();
		lb.addLevel(level);
		assertEquals(oldNumLevels+1, lb.getNumLevels());
	}
}