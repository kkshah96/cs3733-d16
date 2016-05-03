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


public class TestToggleSquare extends TestCase{
	Board board;
	LevelBuilder builder;
	Level level;
	LevelEditorView editorView;
	BullpenController bpController;
	BoardController boardController;
	ToggleSquareController toggleSquareController;
	UndoMoveController undoController;
	
	public void setUp() {
		// Initialization things
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		board = new Board(squares);
		builder = new LevelBuilder();
		level = new PuzzleLevel(0, false, new Bullpen(), board, new Palette(), 0);
		LevelLoaderView lView = new LevelLoaderView(builder);
		editorView = new LevelEditorView(builder, lView, level);
		undoController = new UndoMoveController(builder, editorView);
		toggleSquareController = new ToggleSquareController(level, builder, editorView.getBoardView());
//		bpController = new BullpenController(level, lsView.getBullpenView());
//		boardController = new BoardController(level, lsView.getBoardView());
	}
	
	public void testHintToggle() {
		ActionEvent toggle = new ActionEvent(editorView.getToggleButton(), 0, "", 0, 0);
		board.setActiveSquare(1, 1);
		Square activeSquare = board.getActiveSquare();
		
		assertEquals(activeSquare, board.getSquare(1, 1));
		assertTrue(board.getActiveSquare().isValid());
		
		toggleSquareController.actionPerformed(toggle);
		assertFalse(board.getActiveSquare().isValid());
		
		toggleSquareController.actionPerformed(toggle);
		
		assertTrue(board.getActiveSquare().isValid());
	}
	
	public void testUndo() {
		// Set up and test
		ActionEvent toggle = new ActionEvent(editorView.getToggleButton(), 0, "", 0, 0);
		board.setActiveSquare(1, 1);
		Square activeSquare = board.getActiveSquare();
		assertEquals(activeSquare, board.getSquare(1, 1));
		assertTrue(board.getActiveSquare().isValid());
		
		// Toggle active square off
		toggleSquareController.actionPerformed(toggle);
		assertFalse(board.getActiveSquare().isValid());
		
		// Toggle active square on
		toggleSquareController.actionPerformed(toggle);
		assertTrue(board.getActiveSquare().isValid());
		
		// Undo last two moves
		ActionEvent undo = new ActionEvent(editorView.getUndoButton(), 0, "", 0, 0);
		undoController.actionPerformed(undo);
		assertFalse(board.getActiveSquare().isValid());
		
		undoController.actionPerformed(undo);
		assertTrue(board.getActiveSquare().isValid());
		
		// No more moves to undo
		undoController.actionPerformed(undo);
		assertTrue(board.getActiveSquare().isValid());
	}
}