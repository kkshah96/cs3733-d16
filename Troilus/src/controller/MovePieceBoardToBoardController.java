package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
import model.Level;
import model.Piece;
import view.BoardView;

/**
 * Controls moving a Piece from the Board in the active Level to another location on the Board
 *
 * @author Kunal Shah
 */
public class MovePieceBoardToBoardController extends MouseAdapter {
	Board board;
	BoardView boardView;
	Level level;
	Piece activePiece;

	public MovePieceBoardToBoardController(Level level, BoardView boardView, Board board) {
		this.level = level;
		this.board = board;
		this.boardView = boardView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		int row = y/BoardView.SQUARE_SIZE - BoardView.HEIGHT_OFFSET;
		int col = x/BoardView.SQUARE_SIZE - BoardView.WIDTH_OFFSET;
		
		activePiece = board.getPiece(row, col);
		board.addDraggedPiece(activePiece, new Point(row, col));
	}
}