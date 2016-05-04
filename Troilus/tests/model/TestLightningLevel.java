package model;

import controller.BullpenToBoardMove;
import junit.framework.TestCase;

public class TestLightningLevel extends TestCase {
	LightningLevel level;
	
	public void setUp() {
		LightningSquare[][] squares = new LightningSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new LightningSquare(i, j, true);
			}
		}
		level = new LightningLevel(1, false, new Bullpen(), new Board(squares), Palette.getInstance(), 60);
		
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
		level.getBullpen().addPiece(PieceFactory.getPiece(1));
		level.getBoard().setDimensions(3, 6);
	}
	
	public void testMoves() {
		BullpenToBoardMove move1 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 0, 5, true);
		assertTrue(move1.doMove());
		assertEquals(1, level.getNumStars());
		
		BullpenToBoardMove move2 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 1, 5, true);
		assertTrue(move2.doMove());
		assertEquals(2, level.getNumStars());
		
		BullpenToBoardMove move3 = new BullpenToBoardMove(level,
				level.getBullpen().getPieces().get(0), 2, 5, true);
		assertTrue(move3.doMove());
		assertEquals(3, level.getNumStars());
	}
}