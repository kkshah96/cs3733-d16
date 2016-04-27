package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Palette;
import model.Piece;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.BoardView;
import view.LevelEditorView;
import view.LevelLoaderView;


public class TestHintToggle extends TestCase{
	Board board;
	LevelBuilder lb;
	Level level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;
	
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
		level = new PuzzleLevel(0, false, new Bullpen(), board, new Palette(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
//		bpController = new BullpenController(level, lsView.getBullpenView());
//		boardController = new BoardController(level, lsView.getBoardView());
	}
	
	public void testHintToggle() {
		ActionEvent e = new ActionEvent(lsView.getHintButton(), 0, "", 0, 0);
		board.setActiveSquare(1, 1);
		Square s = board.getActiveSquare();
		
		assertEquals(board.getSquare(1, 1), s);
		assertEquals(false, board.getActiveSquare().getHintStatus());
		ToggleHintController h = new ToggleHintController(level,  lsView.getBoardView());
		h.actionPerformed(e);
		assertEquals(true, board.getActiveSquare().getHintStatus());
		
		h = new ToggleHintController(level,  lsView.getBoardView());
		h.actionPerformed(e);
		
		assertEquals(false, board.getActiveSquare().getHintStatus());
		
	}
}