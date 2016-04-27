package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Palette;
import model.Piece;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestBullpenController extends TestCase {

	public void testBullpenController() {
		// Initialization things
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		LevelBuilder lb = new LevelBuilder();
		Level level = new PuzzleLevel(0, false, new Bullpen(), board, new Palette(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		LevelEditorView lsView = new LevelEditorView(lb, lView, level);
		
		// Now for the fun stuff
		BullpenController bpController = new BullpenController(level, lsView.getBullpenView());
		
		// Handle a basic press at the topleft of the board
		bpController.handleMousePressed(new Point(0,0), MouseEvent.BUTTON1);
		
		// Assert that no activePiece is still null (defaulted)
		assertEquals(null, level.getActivePiece());
		
		// Now add the tall piece in the middle of the board and left click on it
		Piece piece1 = PieceFactory.getPiece(1);
		level.getBullpen().addPiece(piece1);
		lsView.getBullpenView().getDrawnPieces().put(piece1, new Point(0,0));
		assertEquals(1, lsView.getBullpenView().getDrawnPieces().size());
		bpController.handleMousePressed(new Point(5, 5), MouseEvent.BUTTON1);
		
		// Assert that this click has set the active piece
		assertEquals(piece1, level.getActivePiece());
	}
}