package model;

import java.awt.Color;

import junit.framework.TestCase;


/**
 * Test for proper behavior of piece class functionality.
 * @author Dan Alfred
 *
 */
public class TestPiece extends TestCase {

	public TestPiece() {}
	
	public void testPiece() {
		// Start by creating a test Piece- Piece1 in this case, by hand
		PieceSquare anchorSquare = new PieceSquare(1, 5);
		PieceSquare[] pieceSquares = new PieceSquare[5];
		pieceSquares[0] = new PieceSquare(-1, 0);
		pieceSquares[1] = new PieceSquare(-2, 0);
		pieceSquares[2] = new PieceSquare(-3, 0);
		pieceSquares[3] = new PieceSquare(-4, 0);
		pieceSquares[4] = new PieceSquare(-5, 0);
		Piece piece1 = new Piece(pieceSquares, anchorSquare, 1, Color.RED);
		
		// Assert an exception if we try to create a piece with more than 5 squares
		PieceSquare[] tooManySquares = new PieceSquare[6];
		for(int i = 0; i < 6; i++) {
			tooManySquares[i] = new PieceSquare(0, 0);
		}
		
		// This test will succeed if the message in the catch block is printed
		try {
			Piece invalidPiece = new Piece(tooManySquares, anchorSquare, 1, Color.RED);
		} catch(RuntimeException e) {
			System.out.println("5 squares should be used, no more no less");
		}
		
		// Assert that getRow() and getCol() return the row and column of the anchor
		assertEquals(1, piece1.getRow());
		assertEquals(5, piece1.getCol());
		
		// Assert that the piece can return its type correctly
		assertEquals(1, piece1.getType());
		
		// Assert that the anchor square provided is equivalent to the one in the piece
		assertEquals(anchorSquare, piece1.getAnchor());
		
		// Assert that the remaining square array returned is equivalent to what we pass in
		assertEquals(pieceSquares, piece1.getSquares());
		
		// Rotation-
		// Test the rotating a piece an invalid number returns itself
		assertEquals(piece1, piece1.rotatePiece(1234));
		
		// Test that rotating a piece CW is valid
		// This means that the row should be the old col, and the col should be the old row * -1 
		Piece piece2 = piece1.rotatePiece(Piece.ROTATE_CW);
		assertEquals(piece2.squares[0].row, piece1.squares[0].col);
		assertEquals(piece2.squares[1].row, piece1.squares[1].col);
		assertEquals(piece2.squares[2].row, piece1.squares[2].col);
		assertEquals(piece2.squares[3].row, piece1.squares[3].col);
		assertEquals(piece2.squares[4].row, piece1.squares[4].col);
		assertEquals(piece2.squares[0].col, (-1) * piece1.squares[0].row);
		assertEquals(piece2.squares[1].col, (-1) * piece1.squares[1].row);
		assertEquals(piece2.squares[2].col, (-1) * piece1.squares[2].row);
		assertEquals(piece2.squares[3].col, (-1) * piece1.squares[3].row);
		assertEquals(piece2.squares[4].col, (-1) * piece1.squares[4].row);
		
		// Test that rotating CCW is valid-
		// Col should be old row, and row should be old col * (-1)
		Piece piece3 = piece1.rotatePiece(Piece.ROTATE_CCW);
		assertEquals(piece3.squares[0].row, (-1) * piece1.squares[0].col);
		assertEquals(piece3.squares[1].row, (-1) * piece1.squares[1].col);
		assertEquals(piece3.squares[2].row, (-1) * piece1.squares[2].col);
		assertEquals(piece3.squares[3].row, (-1) * piece1.squares[3].col);
		assertEquals(piece3.squares[4].row, (-1) * piece1.squares[4].col);
		assertEquals(piece3.squares[0].col, piece1.squares[0].row);
		assertEquals(piece3.squares[1].col, piece1.squares[1].row);
		assertEquals(piece3.squares[2].col, piece1.squares[2].row);
		assertEquals(piece3.squares[3].col, piece1.squares[3].row);
		assertEquals(piece3.squares[4].col, piece1.squares[4].row);
		
		
		// Flipping-
		// Test that flipping with an invalid value returns the original piece
		Piece piece4 = piece1.flipPiece(1234);
		assertEquals(piece4, piece1);
		
		// Test that flipping a piece horizontally leaves rows the same, inverts col sign value
		Piece piece5 = piece1.flipPiece(Piece.FLIP_HORIZONTALLY);
		assertEquals(piece5.squares[0].col, (-1) * piece1.squares[0].col);
		assertEquals(piece5.squares[1].col, (-1) * piece1.squares[1].col);
		assertEquals(piece5.squares[2].col, (-1) * piece1.squares[2].col);
		assertEquals(piece5.squares[3].col, (-1) * piece1.squares[3].col);
		assertEquals(piece5.squares[4].col, (-1) * piece1.squares[4].col);
		assertEquals(piece5.squares[0].row, piece1.squares[0].row);
		assertEquals(piece5.squares[1].row, piece1.squares[1].row);
		assertEquals(piece5.squares[2].row, piece1.squares[2].row);
		assertEquals(piece5.squares[3].row, piece1.squares[3].row);
		assertEquals(piece5.squares[4].row, piece1.squares[4].row);
		
		// Test that flipping a piece vertically leaves cols the same, inverts row sign value
		Piece piece6 = piece1.flipPiece(Piece.FLIP_VERTICALLY);
		assertEquals(piece6.squares[0].row, (-1) * piece1.squares[0].row);
		assertEquals(piece6.squares[1].row, (-1) * piece1.squares[1].row);
		assertEquals(piece6.squares[2].row, (-1) * piece1.squares[2].row);
		assertEquals(piece6.squares[3].row, (-1) * piece1.squares[3].row);
		assertEquals(piece6.squares[4].row, (-1) * piece1.squares[4].row);
		assertEquals(piece6.squares[0].col, piece1.squares[0].col);
		assertEquals(piece6.squares[1].col, piece1.squares[1].col);
		assertEquals(piece6.squares[2].col, piece1.squares[2].col);
		assertEquals(piece6.squares[3].col, piece1.squares[3].col);
		assertEquals(piece6.squares[4].col, piece1.squares[4].col);
	}
	
}
