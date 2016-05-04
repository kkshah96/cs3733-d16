package controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
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


public class TestHintToggle extends TestCase{
	Board board;
	LevelBuilder lb;
	Level level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;
	ToggleHintController toggleController;
	UndoMoveController undoController;
	RedoMoveController redoController;
	
	public void setUp() {
		// Initialization things
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		board = new Board(squares);
		lb = new LevelBuilder();
		level = new PuzzleLevel(0, false, new Bullpen(), board, Palette.getInstance(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
		toggleController = new ToggleHintController(level, lb, lsView.getBoardView());
		undoController = new UndoMoveController(lb, lsView);
		redoController = new RedoMoveController(lb, lsView);
	}
	
	public void testHintToggle() {
		ActionEvent toggle = new ActionEvent(lsView.getHintButton(), 0, "", 0, 0);
		board.setActiveSquare(1, 1);
		Square s = board.getActiveSquare();
		
		assertEquals(board.getSquare(1, 1), s);
		assertFalse(board.getActiveSquare().isHint());
		toggleController.actionPerformed(toggle);
		assertTrue(board.getActiveSquare().isHint());
		
		toggleController.actionPerformed(toggle);
		
		assertFalse(board.getActiveSquare().isHint());
		
		// Undo
		ActionEvent undo = new ActionEvent(lsView.getUndoButton(), 0, "", 0, 0);
		undoController.actionPerformed(undo);

		assertTrue(board.getActiveSquare().isHint());
		
		// Redo
		ActionEvent redo = new ActionEvent(lsView.getRedoButton(), 0, "", 0, 0);
		redoController.actionPerformed(redo);
		
		assertFalse(board.getActiveSquare().isHint());
		
		// Undo, do a move, then try to redo
		undoController.actionPerformed(undo);
		assertTrue(board.getActiveSquare().isHint());
		
		toggleController.actionPerformed(toggle);
		assertFalse(board.getActiveSquare().isHint());
		
		redoController.actionPerformed(redo);
		assertFalse(board.getActiveSquare().isHint());
	}
}