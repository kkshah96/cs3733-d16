package controller;


import model.Level;
import model.LevelBuilder;


/**
 * Controls the deletion of levels.  This controller is instantiated
 * by the Load Level controllers when the designer clicks a level button
 * while holding the shift key.
 * 
 * @author Connor Weeks
 *
 */
public class DeleteLevelController {

	LevelBuilder levelBuilder;
	Level level;

	DeleteLevelController(LevelBuilder levelBuilder, Level level) {
		this.levelBuilder = levelBuilder;
		this.level = level;
	}


	public void process() {
		// remove level from level builder
		levelBuilder.getLevels().remove(level);

		// save all levels 
		new LevelFileOutputController(levelBuilder);
	}

}
