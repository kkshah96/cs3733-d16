package model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import model.Board;
import model.Piece;
import model.PieceFactory;

public class TestBoard extends TestCase {
	@Test
	public void test() {
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Piece piece1 = PieceFactory.getPiece(1);
		assertTrue(board.addPiece(piece1, 4, 4));
	}
}