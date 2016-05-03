package controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.LightningLevel;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.ReleaseLevel;
import model.Square;
import view.LevelLoaderView;

public class TestLoadLevelControllers extends TestCase {

	public void testLoadPuzzleController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = Palette.getInstance();
		PuzzleLevel level = new PuzzleLevel(0, false, bullpen, board, palette, 0);
		
		LoadPuzzleLevelController loadPuzzle = new LoadPuzzleLevelController(loader, level, builder);
		ActionEvent event = new ActionEvent(loader.getPuzzleButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		loadPuzzle.actionPerformed(event);
		assertFalse(loader.isVisible());
	}

	public void testLoadLightningController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = Palette.getInstance();
		LightningLevel level = new LightningLevel(0, false, bullpen, board, palette, 0);
		
		LoadLightningLevelController loadLightning = new LoadLightningLevelController(loader, level, builder);
		ActionEvent event = new ActionEvent(loader.getLightningButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		loadLightning.actionPerformed(event);
		assertFalse(loader.isVisible());
	}

	public void testLoadReleaseController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = Palette.getInstance();
		ReleaseLevel level = new ReleaseLevel(0, false, bullpen, board, palette);
		
		LoadReleaseLevelController loadRelease = new LoadReleaseLevelController(loader, level, builder);
		ActionEvent event = new ActionEvent(loader.getReleaseButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		loadRelease.actionPerformed(event);
		assertFalse(loader.isVisible());
	}

	
}
