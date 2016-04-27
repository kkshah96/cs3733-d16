package model;

import org.junit.Test;

import controller.BullpenToBoardMove;
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
		assertEquals(0, level.getNumStars());
		
		level.getBoard().setDimensions(6, 6);
		Piece piece1 = PieceFactory.getPiece(1);
		Piece piece2 = PieceFactory.getPiece(1);
		Piece piece3 = PieceFactory.getPiece(1);
		Piece piece4 = PieceFactory.getPiece(1);
		Piece piece5 = PieceFactory.getPiece(1);
		Piece piece6 = PieceFactory.getPiece(1);
		
		BullpenToBoardMove m_invalid = new BullpenToBoardMove(level, piece1, 6, 5);
		assertFalse(m_invalid.isValid());
		assertFalse(m_invalid.doMove());
		
		BullpenToBoardMove m1 = new BullpenToBoardMove(level, piece1, 0, 5);
		BullpenToBoardMove m2 = new BullpenToBoardMove(level, piece2, 1, 5);
		BullpenToBoardMove m3 = new BullpenToBoardMove(level, piece3, 2, 5);
		BullpenToBoardMove m4 = new BullpenToBoardMove(level, piece4, 3, 5);
		BullpenToBoardMove m5 = new BullpenToBoardMove(level, piece5, 4, 5);
		BullpenToBoardMove m6 = new BullpenToBoardMove(level, piece6, 5, 5);
		
		assertTrue(m1.doMove());
		assertEquals(7, level.movesLeft);
		assertEquals(0, level.getNumStars());
		
		assertTrue(m2.doMove());
		assertEquals(6, level.movesLeft);
		assertEquals(0, level.getNumStars());
		
		assertTrue(m3.doMove());
		assertEquals(5, level.movesLeft);
		assertEquals(0, level.getNumStars());
		
		assertTrue(m4.doMove());
		assertEquals(4, level.movesLeft);
		assertEquals(1, level.getNumStars());
		
		assertTrue(m5.doMove());
		assertEquals(3, level.movesLeft);
		assertEquals(2, level.getNumStars());
		
		assertTrue(m6.doMove());
		assertEquals(2, level.movesLeft);
		assertEquals(3, level.getNumStars());
	}
}