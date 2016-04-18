package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
import view.BoardView;


public class MovePieceBoardToBoardController extends MouseAdapter {
	Board board;
	BoardView boardView;

	public MovePieceBoardToBoardController(BoardView boardView, Board board) {
		this.board = board;
		this.boardView = boardView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		
	}
}
