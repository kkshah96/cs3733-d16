package controller;

import model.Level;
import model.LightningLevel;
import view.LevelEditorView;


/**
 * 
 * @author Connor Weeks
 *
 */
public class SetTimeLimitMove extends Move{

	LightningLevel level;
	LevelEditorView editorView;
	
	int previousTime;
	int time;
	

	public SetTimeLimitMove(LightningLevel level, LevelEditorView editorView){
		this.level = level;
		this.previousTime = level.getTime();
		this.editorView = editorView;
		this.previousTime = level.getTime();
		
		// try to get current values
		try {
			int seconds = Integer.parseInt(editorView.getSecondsField().getText());
			int minutes = Integer.parseInt(editorView.getMinutesField().getText());
			this.time = seconds + minutes * 60;
		}
		catch (Exception e) {
			// if parsing failed, set time to invalid value
			this.time = -1;
		}
	}


	@Override
	public boolean doMove() {
		
		boolean validation = false;
		
		if(isValid()){
			// update display
			editorView.getMinutesField().setText(Integer.toString(time / 60));
			editorView.getSecondsField().setText(Integer.toString(time % 60));
			
			// update level
			level.setTimeLimit(time);
			validation = true;
		}
		else {
			System.out.println("not valid");
			// reset text
			editorView.getMinutesField().setText(Integer.toString(previousTime / 60));
			editorView.getSecondsField().setText(Integer.toString(previousTime % 60));
		}
		return validation;
	}


	@Override
	public boolean isValid() {
		return time > 0;
	}


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
