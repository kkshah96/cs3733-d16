package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.LightningLevel;
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

	LightningLevel level;
	LevelBuilder builder;
	LevelEditorView editorView;
	
	
	public SetTimeLimitController(LevelBuilder builder, Level level, LevelEditorView editorView){
		this.level = (LightningLevel) level;
		this.builder = builder;
		this.editorView = editorView;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField m = editorView.getMinutesField();
		JTextField s = editorView.getSecondsField();
		
		int minutes = Integer.parseInt(m.getText());
		int seconds = Integer.parseInt(s.getText());
		
		int newLimit = (minutes*60)+seconds;
		
		level.setTimeLimit(newLimit);
		
	}
}
