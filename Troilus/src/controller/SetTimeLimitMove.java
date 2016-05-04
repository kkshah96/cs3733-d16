package controller;

import model.LightningLevel;
import view.LevelEditorView;

/**
 * Class for implementing a change in the time limit of a lightning level.
 * This move class stores the previous time limit and the intended next 
 * time limit.  Checks are made to be sure that the designer input is correct,
 * and the text fields revert to the last valid value upon an invalid entry.
 * 
 * @author Connor Weeks
 *
 */
public class SetTimeLimitMove extends Move{
	/** The level in which the move takes place. */
	LightningLevel level;
	
	/** The LevelEditorView displaying the current level being edited. */
	LevelEditorView editorView;
	
	/** The time limit before the designer made this change. */
	int previousTime;
	
	/** The new possible time limit. */
	int time;	

	/**
	 * Standard constructor.
	 * @param level The level being edited.
	 * @param editorView The LevelEditorView corresponding to the current level.
	 */
	public SetTimeLimitMove(LightningLevel level, LevelEditorView editorView) {
		this.level = level;
		this.previousTime = level.getTime();
		this.editorView = editorView;
		this.previousTime = level.getTime();
		
		// try to get current values
		try {
			int seconds = Integer.parseInt(editorView.getSecondsField().getText());
			int minutes = Integer.parseInt(editorView.getMinutesField().getText());
			this.time = seconds + minutes * 60;
		} catch (Exception e) {
			// if parsing failed, set time to invalid value
			this.time = -1;
		}
	}

	/**
	 * Performs the move if it is valid. This will update the time limit.
	 * in the level and change the appropriate text fields.
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			// update display
			editorView.getMinutesField().setText(Integer.toString(time / 60));
			editorView.getSecondsField().setText(Integer.toString(time % 60));
			
			// update level
			level.setTimeLimit(time);
			return true;
		} else {
			// reset text
			editorView.getMinutesField().setText(Integer.toString(previousTime / 60));
			editorView.getSecondsField().setText(Integer.toString(previousTime % 60));
			return false;
		}
	}

	/**
	 * Returns true if the new time limit is greater than 0.
	 * @return true If the time parameter is valid (> 0).
	 */
	@Override
	public boolean isValid() {
		return time > 0;
	}

	/**
	 * Restores the time limit in both the level and view to the previous time.
	 *  @return true If this move was successfully undone.
	 */
	@Override
	public boolean undo() {
		// update level
		level.setTimeLimit(previousTime);
		
		// update display
		editorView.getMinutesField().setText(Integer.toString(previousTime / 60));
		editorView.getSecondsField().setText(Integer.toString(previousTime % 60));
		return true;
	}
}