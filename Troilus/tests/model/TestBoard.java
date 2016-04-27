package model;

import org.junit.Test;

import junit.framework.TestCase;
import model.Board;
import model.Piece;
import model.PieceFactory;

public class TestBoard extends TestCase {
	private Board board;
	
	protected void setUp() {
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		this.board = board;
	}
	
	public void testDimensions() {
		board.setDimensions(4, 4);
		assertFalse((board.getSquare(4, 4).isValid()));
		assertFalse((board.getSquare(5, 5).isValid()));
		assertTrue(board.getSquare(3, 3).isValid());	
	}
	
	@Test
	public void testSquares() {
		board.setDimensions(4, 4);
		
		assertFalse((board.getSquare(5, 7).isValid()));
		board.setActiveSquare(5, 7);
		board.toggleActiveSquare();
		assertTrue(board.getSquare(5, 7).isValid());
		
		board.setActiveSquare(3, 2);
		board.toggleActiveSquare();
		assertFalse(board.getSquare(3, 2).isValid());
	}
	
	@Test
	public void testPlacement() {
		Piece piece1 = PieceFactory.getPiece(1);
		Piece piece2 = PieceFactory.getPiece(2);
		
		assertFalse(board.addPiece(piece1, 0, 0));
		assertTrue(board.addPiece(piece1, 7, 7));
		
		assertEquals(null, board.getPiece(7, 8));
		assertEquals(null, board.getPiece(8, 7));
		assertEquals(null, board.getPiece(1, 7));
		assertEquals(piece1, board.getPiece(2, 7));
		assertEquals(piece1, board.getPiece(7, 7));
		
		assertFalse(board.addPiece(piece2, 6, 7));
		assertFalse(board.addPiece(piece2, 7, 7));
		assertFalse(board.addPiece(piece2, 11, 7));
		
		assertEquals(piece1, board.removePiece(piece1));

		assertEquals(null, board.getPiece(7, 7));
		assertTrue(board.addPiece(piece2, 10, 7));
		
		assertEquals(piece2, board.getPiece(10, 7));
	}
	
	public void testPlacement2() {
		Piece piece1 = PieceFactory.getPiece(1);
		
		board.setActiveSquare(6, 9);
		board.toggleActiveSquare();
		
		assertFalse(board.getSquare(6, 9).isValid());

		// Off board edge
		assertFalse(board.addPiece(piece1, 0, 4));
		assertFalse(board.addPiece(piece1, 1, 9));
		assertFalse(board.addPiece(piece1, 2, 9));
		assertFalse(board.addPiece(piece1, 3, 9));
		assertFalse(board.addPiece(piece1, 4, 9));
		
		// Intersects with invalid square (out-of-bounds)
		assertFalse(board.addPiece(piece1, 6, 9));
		assertFalse(board.addPiece(piece1, 9, 9));
		assertFalse(board.addPiece(piece1, 10, 9));
		assertFalse(board.addPiece(piece1, 11, 9));
		
		// Valid
		assertTrue(board.addPiece(piece1, 5, 9));
	}
	
	public void testRemoval() {
		Piece piece1 = PieceFactory.getPiece(1);
		
		assertTrue(board.addPiece(piece1, 11, 11));
		assertEquals(piece1, board.removePiece(board.getPiece(7, 11)));
		assertEquals(null, board.getPiece(7, 11));
	}
}