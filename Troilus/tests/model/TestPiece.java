package model;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * Test for proper behavior of piece class functionality.
 * @author Dan Alfred
 * @author Maddy Longo
 *
 */
public class TestPiece extends TestCase {
	public TestPiece() {}
	
	public void testPiece() {
		// Start by creating a test Piece- Piece1 in this case, by hand
		PieceSquare anchorSquare = new PieceSquare(1, 5);
		PieceSquare[] pieceSquares = new PieceSquare[Piece.PIECE_SIZE - 1];
		pieceSquares[0] = new PieceSquare(0, -1);
		pieceSquares[1] = new PieceSquare(0, -2);
		pieceSquares[2] = new PieceSquare(0, -3);
		pieceSquares[3] = new PieceSquare(0, -4);
		pieceSquares[4] = new PieceSquare(0, -5);
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
		assertEquals(5, piece1.getRow());
		assertEquals(1, piece1.getCol());
		
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
	
	public void testRotate() {
		Piece piece4 = PieceFactory.getPiece(4);
		
		Piece piece4CCW1 = piece4.rotatePiece(Piece.ROTATE_CCW);
		Piece piece4CCW2 = piece4CCW1.rotatePiece(Piece.ROTATE_CCW);
		Piece piece4CCW3 = piece4CCW2.rotatePiece(Piece.ROTATE_CCW);
		Piece piece4CCW4 = piece4CCW3.rotatePiece(Piece.ROTATE_CCW);

		Piece piece4CW1 = piece4.rotatePiece(Piece.ROTATE_CW);
		Piece piece4CW2 = piece4CW1.rotatePiece(Piece.ROTATE_CW);
		Piece piece4CW3 = piece4CW2.rotatePiece(Piece.ROTATE_CW);
		Piece piece4CW4 = piece4CW3.rotatePiece(Piece.ROTATE_CW);
		
		assertEquals(piece4CCW4.getType(), piece4CW4.getType());
		assertTrue(piece4CW4.sameShape(piece4CCW4));
		assertTrue(piece4CW4.sameShape(piece4));
		assertTrue(piece4CCW2.sameShape(piece4CW2));
	}
	
	public void testFlipH() {
		Piece piece5 = PieceFactory.getPiece(5);
		
		Piece piece5FH1 = piece5.flipPiece(Piece.FLIP_HORIZONTALLY);
		Piece piece5FH2 = piece5FH1.flipPiece(Piece.FLIP_HORIZONTALLY);
		
		assertTrue(piece5.sameShape(piece5FH2));
		assertFalse(piece5.sameShape(piece5FH1));
	}
	
	public void testFlipV() {
		Piece piece22 = PieceFactory.getPiece(22);
		
		Piece piece22FV1 = piece22.flipPiece(Piece.FLIP_VERTICALLY);
		Piece piece22FV2 = piece22FV1.flipPiece(Piece.FLIP_VERTICALLY);
		
		assertTrue(piece22FV2.sameShape(piece22));
		assertFalse(piece22FV1.sameShape(piece22));
	}
	
	public void testFlipRotate() {
		Piece piece21 = PieceFactory.getPiece(21);
		
		Piece piece21FV1 = piece21.flipPiece(Piece.FLIP_VERTICALLY);
		Piece piece21CW1 = piece21.rotatePiece(Piece.ROTATE_CW);
		Piece piece21CW2 = piece21CW1.rotatePiece(Piece.ROTATE_CW);
		
		assertFalse(piece21CW2.sameShape(piece21FV1));
	}
	
	public void testFactory() {
		Piece piece25 = PieceFactory.getPiece(25);
		
		PieceSquare[] pieceSquares = new PieceSquare[Piece.PIECE_SIZE - 1];
		pieceSquares[0] = new PieceSquare(+1, 0);
		pieceSquares[1] = new PieceSquare(+2, 0);
		pieceSquares[2] = new PieceSquare(+1, -1);
		pieceSquares[3] = new PieceSquare(+1, -2);
		pieceSquares[4] = new PieceSquare(+1, -3);
		Piece testPiece25 = new Piece(pieceSquares, new PieceSquare(0, 0), 25, Color.RED);
		
		assertTrue(piece25.sameShape(testPiece25));
		
		Piece piece24 = PieceFactory.getPiece(24);
		Piece piece23 = PieceFactory.getPiece(23);
		Piece piece23FV = piece23.flipPiece(Piece.FLIP_VERTICALLY);
		
		assertFalse(piece23.sameShape(piece24));
		assertFalse(piece23.sameShape(piece23FV));
		
		assertEquals("PieceSquare", piece25.getAnchor().getName());
		assertTrue(piece25.getAnchor().isValid());
	}
}