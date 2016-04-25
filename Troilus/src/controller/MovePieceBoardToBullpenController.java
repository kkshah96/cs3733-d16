package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.Piece;
import view.BoardView;

public class MovePieceBoardToBullpenController extends MouseAdapter {
	Level level;
	BoardView boardView;
	
	public MovePieceBoardToBullpenController (Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}
	
	public void mouseClicked(MouseEvent me) {
		if(!(me.getButton() == MouseEvent.BUTTON3)) {
			System.out.println("Not right click");
			return;
		}
		
		int row = (me.getY() - BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
		int col = (me.getX() - BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE;
		
		Piece p = level.getBoard().removePiece(level.getBoard().getPiece(row, col));
		level.getBullpen().addPiece(p);
	}
}