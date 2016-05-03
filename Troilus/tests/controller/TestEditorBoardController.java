package controller;


import junit.framework.TestCase;

import java.awt.Point;
import java.awt.event.MouseEvent;

import model.Board;
import model.Bullpen;
import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Palette;
import model.Piece;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestEditorBoardController extends TestCase {


	Kabasuji game;
	Board board;
	LevelBuilder lb;
	Level level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;

	public void setUp() {
		// Initialization things
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		game = new Kabasuji();
		board = new Board(squares);
		lb = new LevelBuilder();
		level = new PuzzleLevel(0, false, new Bullpen(), board, new Palette(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
		bpController = new BullpenController(level, lsView, game);
		boardController = new BoardController(level, lsView, game);
	}

	public void test() {
		bpController.handleMousePressed(new Point(5, 5), MouseEvent.BUTTON1);
		level.getBullpen().addPiece(PieceFactory.getPiece(0));
		bpController.handleMousePressed(new Point(5, 5), MouseEvent.BUTTON1);
		boardController.handleMousePressed(new Point(5, 5), MouseEvent.BUTTON1);
		boardController.handleMousePressed(new Point(5, 5), MouseEvent.BUTTON3);
		assertEquals(board.getPieces().size(), 0);
	}
}

