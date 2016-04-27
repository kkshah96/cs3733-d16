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


public class TestSetBoardDimensions extends TestCase{
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
	
	public void testSetDimensions() {
		ActionEvent e = new ActionEvent(lsView.getToggleButton(), 0, "", 0, 0);

		
		assertEquals(12,board.getNumRows());
		assertEquals(12,board.getNumCols());
		
		lsView.setHeightField("10");
		lsView.setWidthField("10");
		SetBoardDimensionsController h = new SetBoardDimensionsController(level,  lsView);
		
		h.actionPerformed(e);
		assertEquals(10,board.getNumRows());
		assertEquals(10,board.getNumCols());
		
		lsView.setWidthField("9");
		h =  new SetBoardDimensionsController(level,  lsView);
		h.actionPerformed(e);
		assertEquals(10,board.getNumRows());
		assertEquals(9,board.getNumCols());
		
		lsView.setWidthField("13");
		lsView.setHeightField("13");
		h =  new SetBoardDimensionsController(level,  lsView);
		h.actionPerformed(e);
		assertEquals(10,board.getNumRows());
		assertEquals(9,board.getNumCols());
		
		lsView.setWidthField("-1");
		lsView.setHeightField("-1");
		h =  new SetBoardDimensionsController(level,  lsView);
		h.actionPerformed(e);
		assertEquals(10,board.getNumRows());
		assertEquals(9,board.getNumCols());
		
	}
}