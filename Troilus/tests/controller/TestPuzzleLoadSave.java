package controller;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestPuzzleLoadSave extends TestCase {
	PuzzleLevel level;
	LevelEditorView editorView;
	LevelLoaderView loaderView;
	LevelBuilder builder;
	
	public void setUp() {
		PuzzleSquare[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		level = new PuzzleLevel(1, true, new Bullpen(), new Board(squares), Palette.getInstance(), 15);
		
		// Initialize view
		builder = new LevelBuilder();
		loaderView = new LevelLoaderView(builder);
		editorView = new LevelEditorView(builder, loaderView, level);
		
		editorView.getSaveButton().doClick();
	}
	
	public void testLoad() {
	}
}