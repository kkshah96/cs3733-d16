package controller;


import java.util.ArrayList;

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
	/** The LevelBuilder being modified */
	LevelBuilder levelBuilder;
	
	/** The chosen level to delete */
	Level level;

	/**
	 * Creates a new instance of the DeleteLevelController with the given parameters
	 * @param levelBuilder The main levelbuilder application
	 * @param level Reference to the level to delete
	 */
	DeleteLevelController(LevelBuilder levelBuilder, Level level) {
		this.levelBuilder = levelBuilder;
		this.level = level;
	}

	/**
	 * Completes the deletion of the given level.
	 */
	public void process() {
		// remove level from level builder
		ArrayList<Level> levels = levelBuilder.getLevels();
		levels.remove(level);
		
		// reset level number
		// TODO: Wouldn't doing this eventually cause the level numbers to start above 1?
		for (int i = 0; i < levels.size(); i++) {
			levels.get(i).setLevelNum(i + 1);
		}

		// save all levels 
		new LevelFileOutputController(levelBuilder);
	}

}
