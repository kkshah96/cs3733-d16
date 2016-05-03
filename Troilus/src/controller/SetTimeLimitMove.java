package controller;

import model.Level;
import model.LightningLevel;
import view.LevelEditorView;

public class SetTimeLimitMove extends Move{

	LightningLevel level;
	int previousTime;
	int time;
	LevelEditorView lEV;
	String previousSeconds;
	String previousMinutes;
	
	public SetTimeLimitMove(LightningLevel level, int time, LevelEditorView lEV){
		this.level = level;
		this.time = time;
		this.previousTime = level.getTime();
		this.lEV = lEV;
		this.previousSeconds = lEV.getSecondsField().getText();
		this.previousMinutes = lEV.getMinutesField().getText();
	}


	@Override
	public boolean doMove() {
	if(isValid()){
		level.setTimeLimit(time);
	}
		return false;
	}


	@Override
	public boolean isValid() {
		if(time >= 0){
			return true;
		}
		return false;
	}


	@Override
	
	//TODO: Still need to properly update the text fields after an undo
	public boolean undo() {
		level.setTimeLimit(previousTime);
		lEV.setTimeMinutesField(previousMinutes);
		lEV.setTimeSecondsField(previousSeconds);
		lEV.repaint();
		return true;
	}
	
	
	

}
