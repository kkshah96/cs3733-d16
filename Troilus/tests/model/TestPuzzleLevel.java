package model;

import org.junit.Test;

import junit.framework.TestCase;

public class TestPuzzleLevel extends TestCase {
	PuzzleLevel level;
	
	public void setUp() {
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), new Palette(), 15);
	}
	
	@Test
	public void testMoves() {
		assertEquals(15, level.getMaxMoves());
		assertEquals(15, level.movesLeft);
	}
}