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

	LevelBuilder levelBuilder;
	Level level;

	DeleteLevelController(LevelBuilder levelBuilder, Level level) {
		this.levelBuilder = levelBuilder;
		this.level = level;
	}


	public void process() {
		// remove level from level builder
		ArrayList<Level> levels = levelBuilder.getLevels();
		levels.remove(level);
		
		// reset level number
		for (int i = 0; i < levels.size(); i++) {
			levels.get(i).setLevelNum(i + 1);
		}

		// save all levels 
		new LevelFileOutputController(levelBuilder);
	}

}
