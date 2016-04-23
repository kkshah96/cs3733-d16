package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Board;
import model.Piece;
import model.PieceFactory;

public class TestBoard {
	@Test
	public void test() {
		Board board = new Board();
		Piece piece1 = PieceFactory.getPiece(1);
		boolean valid = board.addPiece(piece1, 4, 4);
		assert(!valid);
	}
}