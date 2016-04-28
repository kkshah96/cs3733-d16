package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Palette;
import model.Piece;
import model.PieceFactory;
import model.PieceSquare;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;


public class TestFlipPieceController extends TestCase{
	Board board;
	LevelBuilder lb;
	Level level;
	LevelEditorView lsView;
	BullpenController bpController;
	BoardController boardController;
	Bullpen bPen;
	
	public void setUp() {
		// Initialization things
		Square[][] squares = new PuzzleSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		bPen = new Bullpen();
		board = new Board(squares);
		lb = new LevelBuilder();
		level = new PuzzleLevel(0, false, bPen, board, new Palette(), 0);
		LevelLoaderView lView = new LevelLoaderView(lb);
		lsView = new LevelEditorView(lb, lView, level);
		bpController = new BullpenController(level, lsView);
//		boardController = new BoardController(level, lsView.getBoardView());
	}
	
	public void testFlipHorizontal() {
		ActionEvent e = new ActionEvent(lsView.getFlipHorizontal(), 0, "", 0, 0);
		
		
		PieceSquare anchorSquare = new PieceSquare(1, 5);
		PieceSquare[] pieceSquares = new PieceSquare[5];
		pieceSquares[0] = new PieceSquare(0, -1);
		pieceSquares[1] = new PieceSquare(0, -2);
		pieceSquares[2] = new PieceSquare(0, -3);
		pieceSquares[3] = new PieceSquare(0, -4);
		pieceSquares[4] = new PieceSquare(0, -5);
		Piece p = new Piece(pieceSquares, anchorSquare, 1, Color.RED);
		
		
		Square[] sBefore = p.getSquares();
		bPen.addPiece(p);

		level.setActivePiece(p);
		
		assertEquals(p, level.getActivePiece());
			
		FlipPieceController r = new FlipPieceController(level, lsView.getBullpenView(), Piece.FLIP_HORIZONTALLY);
		r.actionPerformed(e);
		
		
		Square[] sAfter = level.getActivePiece().getSquares();
		

		assertEquals(sBefore[1].getRow(), sAfter[1].getRow());
		assertEquals(sBefore[2].getRow(), sAfter[2].getRow());
		assertEquals(sBefore[3].getRow(), sAfter[3].getRow());
		assertEquals(sBefore[4].getRow(), sAfter[4].getRow());
		assertEquals(sBefore[0].getCol(), (-1) * sAfter[0].getCol());
		assertEquals(sBefore[1].getCol(), (-1) * sAfter[1].getCol());
		assertEquals(sBefore[2].getCol(), (-1) * sAfter[2].getCol());
		assertEquals(sBefore[3].getCol(), (-1) * sAfter[3].getCol());
		assertEquals(sBefore[4].getCol(), (-1) * sAfter[4].getCol());

	}
	
	public void testFlipVertical(){
ActionEvent e = new ActionEvent(lsView.getFlipVertical(), 0, "", 0, 0);
		
		
		PieceSquare anchorSquare = new PieceSquare(1, 5);
		PieceSquare[] pieceSquares = new PieceSquare[5];
		pieceSquares[0] = new PieceSquare(0, -1);
		pieceSquares[1] = new PieceSquare(0, -2);
		pieceSquares[2] = new PieceSquare(0, -3);
		pieceSquares[3] = new PieceSquare(0, -4);
		pieceSquares[4] = new PieceSquare(0, -5);
		Piece p = new Piece(pieceSquares, anchorSquare, 1, Color.RED);
		
		
		Square[] sBefore = p.getSquares();
		bPen.addPiece(p);

		level.setActivePiece(p);
		
		assertEquals(p, level.getActivePiece());
			
		FlipPieceController r = new FlipPieceController(level, lsView.getBullpenView(), Piece.FLIP_VERTICALLY);
		r.actionPerformed(e);
		
		
		Square[] sAfter = level.getActivePiece().getSquares();
		

		assertEquals(sBefore[1].getRow(), (-1) *sAfter[1].getRow());
		assertEquals(sBefore[2].getRow(), (-1) *sAfter[2].getRow());
		assertEquals(sBefore[3].getRow(), (-1) *sAfter[3].getRow());
		assertEquals(sBefore[4].getRow(), (-1) *sAfter[4].getRow());
		assertEquals(sBefore[0].getCol(),  sAfter[0].getCol());
		assertEquals(sBefore[1].getCol(), sAfter[1].getCol());
		assertEquals(sBefore[2].getCol(), sAfter[2].getCol());
		assertEquals(sBefore[3].getCol(), sAfter[3].getCol());
		assertEquals(sBefore[4].getCol(), sAfter[4].getCol());
	}
}