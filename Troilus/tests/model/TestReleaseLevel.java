package model;

import junit.framework.TestCase;

public class TestReleaseLevel extends TestCase {
	ReleaseLevel level;
	
	public void setUp() {
		ReleaseSquare[][] squares = new ReleaseSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new ReleaseSquare(i, j, true);
			}
		}
		level = new ReleaseLevel(1, false, new Bullpen(), new Board(squares), new Palette());
	}
	
	public void testLevel() {
		assertEquals(1, level.getLevelNum());
	}
}
