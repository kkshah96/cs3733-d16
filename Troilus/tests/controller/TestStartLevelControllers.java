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
		LevelSelectorView selectorView = new LevelSelectorView(game);
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
		
		StartPuzzleLevelController loadPuzzle = new StartPuzzleLevelController(selectorView, level, game);
		ActionEvent event = new ActionEvent(selectorView, 0, null);
		selectorView.setVisible(true);
		
		assertTrue(selectorView.isVisible());
		loadPuzzle.actionPerformed(event);
		assertFalse(selectorView.isVisible());
	}

	public void testStartLightningController() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selectorView = new LevelSelectorView(game);
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
		
		StartLightningLevelController loadLightning = new StartLightningLevelController(selectorView, level, game);
		ActionEvent event = new ActionEvent(selectorView, 0, null);
		selectorView.setVisible(true);
		
		assertTrue(selectorView.isVisible());
		loadLightning.actionPerformed(event);
		assertFalse(selectorView.isVisible());
	}

	public void testStartReleaseController() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selectorView = new LevelSelectorView(game);
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
		
		StartReleaseLevelController loadRelease = new StartReleaseLevelController(selectorView, level, game);
		ActionEvent event = new ActionEvent(selectorView, 0, null);
		selectorView.setVisible(true);
		
		assertTrue(selectorView.isVisible());
		loadRelease.actionPerformed(event);
		assertFalse(selectorView.isVisible());
	}

	
}