package controller;

import java.awt.event.ActionEvent;
import org.junit.Test;
import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestSetMaxMovesController extends TestCase{
	Board board;
	LevelBuilder lb;
	PuzzleLevel level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;
	Bullpen bPen;
	
	public void setUp(){
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), new Palette(), 8);
		
		lb = new LevelBuilder();
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
	}
	
	@Test
	public void testSetMaxMoves(){
		assertEquals(8, level.getMaxMoves());

		lsView.setMovesField("2");
		ActionEvent e = new ActionEvent(lsView.getMaxMovesField(), 0, "", 0, 0);
		SetMaxMovesController s = new SetMaxMovesController(level, lsView);
		s.actionPerformed(e);
		
		assertEquals(2, level.getMaxMoves());
		
	}
}
