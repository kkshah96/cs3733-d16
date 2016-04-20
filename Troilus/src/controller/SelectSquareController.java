package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.LevelBuilder;
import model.Square;
import view.LevelEditorView;


/**
 * 
 * @author Alexander Kasparek
 *
 */
public class SelectSquareController extends MouseAdapter {

	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;

	public SelectSquareController(LevelBuilder builder,Level level, LevelEditorView editorView){
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

			level.getBoard().setActiveSquare(row, col);
		}//end check bounds else
	}
}