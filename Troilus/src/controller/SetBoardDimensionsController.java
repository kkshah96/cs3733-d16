package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Board;
import model.Level;
import view.LevelEditorView;

/**
 * Controls the resizing of the board in Level Editor.
 * 
 * When the Designer enters new desired dimensions, the 
 * board recreates itself to the specified dimensions
 * (if valid).
 *
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetBoardDimensionsController implements ActionListener {
	Level level;
	LevelEditorView editorView;

	public SetBoardDimensionsController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField r = editorView.getRowField();
		JTextField c = editorView.getColField();

		int rows = Integer.parseInt(r.getText());
		int cols = Integer.parseInt(c.getText());

		if (cols < 0 || cols > Board.BOARD_WIDTH || rows > Board.BOARD_HEIGHT || rows < 0){
			System.out.println("Error: Invalid Dimensions");
			return;
		}

		//System.out.println(rows);
		//System.out.println(cols);
		level.getBoard().setDimensions(rows, cols);
		editorView.getBoardView().repaint();
	}
}