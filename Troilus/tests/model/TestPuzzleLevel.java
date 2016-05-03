package model;

import org.junit.Test;

import controller.BoardToBoardMove;
import controller.BoardToBullpenMove;
import controller.BullpenToBoardMove;
import junit.framework.TestCase;

public class TestPuzzleLevel extends TestCase {
	PuzzleLevel level;
	
	public void setUp() {
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), new Palette(), 8);
		
		assertEquals(8, level.getMaxMoves());
		assertEquals(8, level.movesLeft);
		assertEquals(0, level.getNumStars());
		
		level.getBoard().setDimensions(6, 6);
		// initialize bullpen
		Piece piece1 = PieceFactory.getPiece(1);
		Piece piece2 = PieceFactory.getPiece(1);
		Piece piece3 = PieceFactory.getPiece(1);
		Piece piece4 = PieceFactory.getPiece(1);
		Piece piece5 = PieceFactory.getPiece(1);
		Piece piece6 = PieceFactory.getPiece(1);
		level.getBullpen().addPiece(piece1);
		level.getBullpen().addPiece(piece2);
		level.getBullpen().addPiece(piece3);
		level.getBullpen().addPiece(piece4);
		level.getBullpen().addPiece(piece5);
		level.getBullpen().addPiece(piece6);
	}
	
	@Test
	public void testMoves() {
		Piece piece1 = level.getBullpen().getPieces().get(0);
		Piece piece2 = level.getBullpen().getPieces().get(1);
		Piece piece3 = level.getBullpen().getPieces().get(2);
		Piece piece4 = level.getBullpen().getPieces().get(3);
		Piece piece5 = level.getBullpen().getPieces().get(4);
		Piece piece6 = level.getBullpen().getPieces().get(5);
		
		// Test moving piece out of bounds
		BullpenToBoardMove m_invalid = new BullpenToBoardMove(level, piece1, 6, 5);
		assertFalse(m_invalid.isValid());
		assertFalse(m_invalid.doMove());
		
		// Test valid moves
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
		
		BoardToBoardMove mInvalid2 = new BoardToBoardMove(level, 5, 5, 0, 5);
		assertFalse(mInvalid2.doMove());
		
		BoardToBullpenMove m7 = new BoardToBullpenMove(level, 1, 1);
		assertTrue(m7.doMove());
		assertEquals(1, level.movesLeft);
		assertEquals(2, level.getNumStars());
		
		BoardToBoardMove m8 = new BoardToBoardMove(level, 1, 5, 0, 5);
		assertTrue(m8.doMove());
		assertEquals(0, level.movesLeft);
		assertEquals(2, level.getNumStars());
		
		// TODO implement checking move limit
		//BoardToBullpenMove mInvalid3 = new BoardToBullpenMove(level, 1, 1);
		//assertFalse(mInvalid3.doMove());
		//assertEquals(0, level.movesLeft);
	}
}