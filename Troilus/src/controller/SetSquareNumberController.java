package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import model.ReleaseSquare;
import view.LevelEditorView;

/**
 * 
 * @author Alexander Kasparek
 *
 */
public class SetSquareNumberController implements ActionListener{
	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	int num;
	
	public SetSquareNumberController(LevelBuilder builder,Level level, LevelEditorView editorView, int num){
		this.builder = builder;
		this.level = level;
		this.editorView = editorView;
		this.num = num;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ReleaseSquare square = (ReleaseSquare) builder.getActiveLevel().getBoard().getActiveSquare();
		square.setNumber(num);
	}
}