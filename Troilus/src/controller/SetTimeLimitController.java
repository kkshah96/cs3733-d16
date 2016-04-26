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
		JTextField minutesField = editorView.getMinutesField();
		JTextField secondsField = editorView.getSecondsField();
		
		int minutes = Integer.parseInt(minutesField.getText());
		int seconds = Integer.parseInt(secondsField.getText());
		
		// check for valid time
		if (minutes < 0 || seconds < 0) {
			return;
		}
		
		int newLimit = (minutes * 60) + seconds;
		level.setTimeLimit(newLimit);
		
		// reset minutes : seconds view so seconds < 60
		minutesField.setText(Integer.toString(newLimit / 60));
		secondsField.setText(Integer.toString(newLimit % 60));
		
	}
}