package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.Square;
import view.LevelLoaderView;

/**
 * 
 * 
 * @author Alexander Kasparek
 */
public class ToggleSquareController implements ActionListener{
	Level level;
	LevelBuilder builder;
	LevelLoaderView editorView;

	public ToggleSquareController(LevelBuilder builder,Level level, LevelLoaderView editorView) {
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if(x > 370 || x < 10 || y > 390 || y < 30) {
			System.out.println("Error: Did not click within the board");
		}

		else {	
			int row = (x-10)/30;
			int col = (y-30)/30;
			
			Board board = level.getBoard();
			if (board.getActiveSquare() == null){
				System.out.print("No piece selected.");
			} else {
				board.toggleSquare();
			}
		}//end check bounds else
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Square toggle = level.getBoard().getActiveSquare();
		level.getBoard().toggleSquare();
	}
}