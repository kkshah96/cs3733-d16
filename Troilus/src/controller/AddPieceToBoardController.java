package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
import model.Palette;
import model.Piece;
// TODO this shouldn't be a class! It should be MovePieceBullpenToBoard and MovePieceBoardToBoard instead
public class AddPieceToBoardController extends MouseAdapter {
	Board board;
	Piece piece;
	Palette palette;

	public AddPieceToBoardController(Palette palette, Piece piece, Board board) {
		this.board = board;
		this.piece = piece;
		this.palette = palette;
	}

	public void mousePressed(MouseEvent e) {
		
		
		
	}
}
