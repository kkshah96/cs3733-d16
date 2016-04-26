package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Level;
import model.LightningLevel;
import view.LevelEditorView;

/**
 * 
 *
 * @author Alexander Kasparek
 * @author Connor Weeks
 */
public class SetTimeLimitController implements ActionListener {
	LightningLevel level;
	LevelEditorView editorView;
	
	
	public SetTimeLimitController(Level level, LevelEditorView editorView){
		this.level = (LightningLevel) level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField m = editorView.getMinutesField();
		JTextField s = editorView.getSecondsField();
		
		int minutes = Integer.parseInt(m.getText());
		int seconds = Integer.parseInt(s.getText());
		
		// check for valid time
		if (minutes < 0 || seconds < 0) {
			return;
		}
		
		int newLimit = (minutes * 60) + seconds;
		System.out.println("set time");
		
		level.setTimeLimit(newLimit);
	}
}