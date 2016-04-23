package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import view.LevelEditorView;

/**
 * 
 *
 * @author Alexander Kasparek
 */
public class SetBoardDimensionsController implements ActionListener {
	Kabasuji game;
	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	int rows;
	int cols;

	public SetBoardDimensionsController(LevelBuilder builder,Level level, LevelEditorView editorView) {
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField r = editorView.getRowField();
		JTextField c = editorView.getColField();

		int rows = Integer.parseInt(r.getText());
		int cols = Integer.parseInt(c.getText());

		if(cols <= 0 || cols > 12 || rows > 12 || rows <= 0){
			System.out.println("Invalid Dimensions");
			return;
		}

		System.out.println(rows);
		System.out.println(cols);
		level.getBoard().setDimensions(rows, cols);
	}
}