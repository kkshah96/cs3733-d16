package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.LevelEditorView;
import view.LevelLoaderView;
import view.LevelView;

/**
 * 
 *
 * @author Alexander Kasparek
 */
public class SetTimeLimitController implements ActionListener{

	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	int time;
	
	public SetTimeLimitController(LevelBuilder builder,Level level, LevelEditorView editorView, int time){
		this.level = level;
		this.builder = builder;
		this.time = time;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField m = editorView.getMinutesField();
		JTextField s = editorView.getSecondsField();
		
		int rows = Integer.parseInt(r.getText());
		int cols = Integer.parseInt(c.getText());
		
		
		
		
	}
}
