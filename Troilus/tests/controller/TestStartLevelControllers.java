package controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.Kabasuji;
import model.LightningLevel;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.ReleaseLevel;
import model.Square;
import view.LevelSelectorView;

public class TestStartLevelControllers extends TestCase {

	public void testStartPuzzleController() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selector = new LevelSelectorView(game);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = new Palette();
		PuzzleLevel level = new PuzzleLevel(0, false, bullpen, board, palette, 0);
		
		StartPuzzleLevelController startPuzzle = new StartPuzzleLevelController(selector, level, game);
		ActionEvent event = new ActionEvent(selector.getLevelButtons().get(0), 0, null);
		selector.setVisible(true);
		
		assertTrue(selector.isVisible());
		startPuzzle.actionPerformed(event);
		assertFalse(selector.isVisible());
	}
	
	public void testStartLightningController() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selector = new LevelSelectorView(game);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = new Palette();
		LightningLevel level = new LightningLevel(0, false, bullpen, board, palette, 0);
		
		StartLightningLevelController startLightning = new StartLightningLevelController(selector, level, game);
		ActionEvent event = new ActionEvent(selector.getLevelButtons().get(0), 0, null);
		selector.setVisible(true);
		
		assertTrue(selector.isVisible());
		startLightning.actionPerformed(event);
		assertFalse(selector.isVisible());
	}
	
	public void testStartReleaseController() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selector = new LevelSelectorView(game);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = new Palette();
		ReleaseLevel level = new ReleaseLevel(0, false, bullpen, board, palette);
		
		StartReleaseLevelController startRelease = new StartReleaseLevelController(selector, level, game);
		ActionEvent event = new ActionEvent(selector.getLevelButtons().get(0), 0, null);
		selector.setVisible(true);
		
		assertTrue(selector.isVisible());
		startRelease.actionPerformed(event);
		assertFalse(selector.isVisible());
	}
	
}
