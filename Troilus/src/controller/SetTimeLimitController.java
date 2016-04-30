package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Level;
import model.LightningLevel;
import view.LevelEditorView;

/**
 * Class to handle update of time for Lightning Levels.
 *
 * @author Alexander Kasparek
 * @author Connor Weeks
 */
public class SetTimeLimitController implements ActionListener {
	/** The lightning level being edited */
	LightningLevel level;
	
	/** The view for the level being edited */
	LevelEditorView editorView;
	
	/**
	 * Creates a new instance of SetTimeLimitController with the following parameters
	 * @param level Reference to the level being edited
	 * @param editorView Reference to the view of the level being edited
	 */
	public SetTimeLimitController(Level level, LevelEditorView editorView){
		this.level = (LightningLevel) level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the values from the text boxes and convert to int
		JTextField minutesField = editorView.getMinutesField();
		JTextField secondsField = editorView.getSecondsField();
		
		int minutes = Integer.parseInt(minutesField.getText());
		int seconds = Integer.parseInt(secondsField.getText());
		
		// check for valid time
		if (minutes < 0 || seconds < 0) {
			return;
		}
		
		// Otherwise, convert to secounds and set time limit
		int newLimit = (minutes * 60) + seconds;
		level.setTimeLimit(newLimit);
		
		// reset minutes : seconds view so seconds < 60
		minutesField.setText(Integer.toString(newLimit / 60));
		secondsField.setText(Integer.toString(newLimit % 60));
		
	}
}