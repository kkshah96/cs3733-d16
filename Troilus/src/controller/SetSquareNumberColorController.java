package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import view.LevelEditorView;

/**
 * 
 * @author Alexander Kasparek
 *
 */
public class SetSquareNumberColorController implements ActionListener{
	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	Color color;
	
	public SetSquareNumberColorController(LevelBuilder builder,Level level, LevelEditorView editorView, Color color){
		this.builder = builder;
		this.level = level;
		this.editorView = editorView;
		this.color = color;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		builder.getActiveLevel().getActiveSquare().setColor(color);
		
	}
	
	
}


