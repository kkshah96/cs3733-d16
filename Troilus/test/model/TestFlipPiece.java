package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Piece;
import model.PieceFactory;

public class TestFlipPiece {
	static final int FLIP_HORIZONTAL = -1;
	static final int FLIP_VERTICAL = 1;

	@Test
	public void test() {
		Piece piece1 = PieceFactory.getPiece(0, 0, 1);
		Piece p1FlippedHorizontal = piece1.flipPiece(FLIP_HORIZONTAL); //Should flip horizontally
		
		for(int i = 0; i < 4; i++){
			assertTrue(p1FlippedHorizontal.squares[i].getCol() == (-1*piece1.squares[i].getCol()));
			assertTrue(p1FlippedHorizontal.squares[i].getRow() == piece1.squares[i].getRow());
		}

		Piece p1FlippedVertical = piece1.flipPiece(FLIP_VERTICAL); //Should rotate CW
		for (int i = 0; i < 4; i++) {
			assertTrue(p1FlippedVertical.squares[i].getRow() == (-1*piece1.squares[i].getRow()));
			assertTrue(p1FlippedVertical.squares[i].getCol() == (piece1.squares[i].getCol()));
		}
	}
}