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
		assertTrue(!(board.getSquare(4, 4).isValid()));
		assertTrue(!(board.getSquare(5, 5).isValid()));
		assertTrue(board.getSquare(3, 3).isValid());
	}
	
	@Test
	public void testPlacement() {
		Piece piece1 = PieceFactory.getPiece(1);
		
		assertTrue(!board.addPiece(piece1, 0, 0));
		assertTrue(board.addPiece(piece1, 7, 3));
		
		assertEquals(piece1, board.getPiece(7, 3));
		
		assertEquals(piece1, board.removePiece(piece1));

		assertEquals(null, board.getPiece(7, 3));
	}
	
	@Test
	public void testToggle() {
		board.setDimensions(4, 4);
		
		assertTrue(!(board.getSquare(5, 7).isValid()));
		board.setActiveSquare(5, 7);
		board.toggleActiveSquare();
		assertTrue(board.getSquare(5, 7).isValid());
		
		board.setActiveSquare(3, 2);
		board.toggleActiveSquare();
		assertTrue(!board.getSquare(3, 2).isValid());
	}
}