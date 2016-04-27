package model;

import java.util.ArrayList;

import controller.LoadLevelsController;

/**
 * Top level entity for the Kabasuji game
 * 
 * The Kabasuji game consists of a collection of Levels, and always keeps track of the active Level (or level currently loaded)
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class Kabasuji {

	ArrayList<Level> levels;
	//Level activeLevel;
	
	public Kabasuji() {
		
		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();

		// load levels into the list of levels
		levels = loader.loadLevels();
		
		// automatically unlock first level
		levels.get(0).setLocked(false);
		
		
		
		// stubs for testing:
		
//		levels = new ArrayList<Level>();
//		for(int i = 0; i < 24; i++){
//			Level level;
//			if (i % 3 == 0) {
//				level = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
//			}
//			else if (i % 3 == 1) {
//				level = new LightningLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
//			}
//			else {
//				level = new ReleaseLevel(i, false, new Bullpen(), new Board(), new  Palette());
//			}
//			
//			// show only the first level as unlocked, lock every other level
//			if(i >= 1) {
//				level.setLocked(true);
//			}
//			
//			levels.add(level);
//		}
		
	}

	
	/**
	 * Returns an ordered list of the game's levels.
	 * @return ArrayList<Level> list of levels
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	/**
	 * Returns the number of levels in the game
	 * @return int
	 */
	public int getNumLevels() {
		return levels.size();
	}
	
//	public void setActiveLevel(Level level) {
	//	activeLevel = level;
	//}
	
	//public Level getActiveLevel() {
		//return activeLevel;
	//}
}