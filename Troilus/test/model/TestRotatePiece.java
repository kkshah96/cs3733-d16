package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Piece;
import model.PieceFactory;

public class TestRotatePiece {
	@Test
	public void test1() {
		Piece piece1 = PieceFactory.getPiece(0, 0, 1);
		Piece p1RotatedCCW = piece1.rotatePiece(Piece.ROTATE_CCW); //Should rotate CCW
		
		for(int i = 0; i < 4; i++){
			assertTrue(p1RotatedCCW.squares[i].getCol() == piece1.squares[i].getRow());
			assertTrue(p1RotatedCCW.squares[i].getRow() == (-1*piece1.squares[i].getCol()));
		}
		
		Piece p1RotatedCW = piece1.rotatePiece(Piece.ROTATE_CW); //Should rotate CW
		for(int i = 0; i < 4; i++){
			assertTrue(p1RotatedCW.squares[i].getCol() == (-1*piece1.squares[i].getRow()));
			assertTrue(p1RotatedCW.squares[i].getRow() == (piece1.squares[i].getCol()));
		}
	}
}