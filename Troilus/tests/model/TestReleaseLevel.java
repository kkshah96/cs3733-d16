package model;

import java.awt.Color;

import controller.BoardToBoardMove;
//import controller.BoardToBullpenMove;
import controller.BullpenToBoardMove;
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
		// Set up three cols of numbers
		for (int i = 0; i < 6; i++) {
			squares[0][i].setNumber(i + 1);
			squares[0][i].setNumberColor(Color.RED);

			squares[1][i].setNumber(i + 1);
			squares[1][i].setNumberColor(Color.GREEN);

			squares[2][i].setNumber(i + 1);
			squares[2][i].setNumberColor(Color.YELLOW);
		}
		level = new ReleaseLevel(1, false, new Bullpen(), new Board(squares), Palette.getInstance());
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
	}

	public void testLevel() {
		assertEquals(1, level.getLevelNum());
		
		// Cover red squares
		BullpenToBoardMove move1 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 0, 5, true);
		assertTrue(move1.doMove());
		
		assertEquals(6, level.getRedCovered());
		assertEquals(1, level.getNumStars());
		
		// Test invalid moves (can't move pieces from board in Release level)
		BoardToBoardMove invalidMove1 = new BoardToBoardMove(level, 0, 5, 1, 5, true);
		assertFalse(invalidMove1.doMove());
		
		// Cover green squares
		BullpenToBoardMove move2 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 1, 5, true);
		assertTrue(move2.doMove());
		assertEquals(6, level.getGreenCovered());
		assertEquals(2, level.getNumStars());

		// Cover yellow squares
		BullpenToBoardMove move3 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 2, 5, true);
		assertTrue(move3.doMove());
		assertEquals(6, level.getYellowCovered());
		assertEquals(3, level.getNumStars());
	}
}
