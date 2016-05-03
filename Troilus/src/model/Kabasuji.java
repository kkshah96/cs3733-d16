package model;

import java.util.ArrayList;

import controller.LoadLevelsController;

/**
 * Top level entity for the Kabasuji game.
 * 
 * The Kabasuji game consists of a collection of Levels, and always keeps track of the
 * active Level (or level currently loaded).
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class Kabasuji {
	/** The levels in this entity */
	ArrayList<Level> levels;

	/**
	 * Creates a new instance of the Kabasuji entity with an empty collection of levels
	 */
	public Kabasuji() {
		initialize();
	}

	/**
	 * Loads levels from file.
	 */
	public void initialize() {
		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();

		// load levels into the list of levels
		levels = loader.loadLevels();
		
		// automatically unlock first level if it exists
		if(levels.size() >= 1 ) {
			levels.get(0).setLocked(false);
		}
	}

	/**
	 * Returns an ordered list of the game's levels.
	 * @return ArrayList<Level> list of levels.
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}

	/**
	 * Returns the number of levels in the game.
	 * @return int Number of levels.
	 */
	public int getNumLevels() {
		return levels.size();
	}
}