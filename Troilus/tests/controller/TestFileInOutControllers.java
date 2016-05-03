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

// TODO fill this in!
public class TestFileInOutControllers extends TestCase {
	LevelLoaderView loaderView;
	ArrayList<Level> levels;
	
	public void setUp() {
		LevelBuilder lb = new LevelBuilder();
		loaderView = new LevelLoaderView(lb);
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		Level level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), Palette.getInstance(), 8);
		
		int oldNumLevels = lb.getNumLevels();
		lb.addLevel(level);
		assertEquals(oldNumLevels+1, lb.getNumLevels());
		
		LevelFileInputController input = new LevelFileInputController();
		levels = input.getLevels();
	}
}