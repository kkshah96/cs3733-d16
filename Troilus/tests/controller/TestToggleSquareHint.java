package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestToggleSquareHint {

	Board board;
	LevelBuilder lb;
	Level level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;
	Bullpen bPen;
	
	@Test
	public void testToggleHintSquare(){
		Square[][] squares = new Square[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		bPen = new Bullpen();
		board = new Board(squares);
		lb = new LevelBuilder();
		level = new PuzzleLevel(0, false, bPen, board, Palette.getInstance(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
		bpController = new BullpenController(level, lsView, lb);
		
		board.setActiveSquare(1, 1);
		
		assertFalse(board.getActiveSquare().isHint());
		
		ToggleHintMove m = new ToggleHintMove(level);
		
		m.doMove();
		assertTrue(board.getActiveSquare().isHint());
		
		m.undo();
		assertFalse(board.getActiveSquare().isHint());
		
		m.doMove();
		assertTrue(board.getActiveSquare().isHint());
		
		
		board.setActiveSquare(2, 2);
		m = new ToggleHintMove(level);
		assertFalse(board.getActiveSquare().isHint());
		m.doMove();
		assertTrue(board.getActiveSquare().isHint());
		
		//Undo setting (2,2) As a hint
		
		m.undo();
		assertFalse(board.getActiveSquare().isHint());
		
	
		
		
	}

}
