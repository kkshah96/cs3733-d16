package model;

import java.util.ArrayList;

import controller.LoadLevelsController;

/**
 * Top level entity for the LevelBuilder application
 * 
 * The LevelBuilder structure, similar to Kabasuji, contains a collection of Levels and keeps track of the active level (or level being edited)
 * 
 * @author Kunal Shah
 *
 */
public class LevelBuilder {
	
	ArrayList<Level> levels;
	//Level activeLevel;
	
	public LevelBuilder() {
		initialize();
		
		
		// stubs for testing
//		levels = new ArrayList<Level>();
//		for(int i = 0; i < 24; i++){
//			Level level;
//			if (i % 3 == 0) {
//				//level = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
//			}
//			else if (i % 3 == 1) {
//				//level = new LightningLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
//			}
//			else {
//				//level = new ReleaseLevel(i, false, new Bullpen(), new Board(), new  Palette());
//			}
//			
//			// show the first three levels
//			if(i >= 3) {
//				//level.setLocked(true);
//			}
//			
//			//levels.add(level);
//		}
		
	}
	
	public void initialize() {

		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();
		
		// load levels into the list of levels
		levels = loader.loadLevels();
		
		
	}
	
	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	public int getNumLevels() {
		return levels.size();
	}
	
	//public void setActiveLevel(Level level) {
	//	activeLevel = level;
	//}
	
	//public Level getActiveLevel() {
		//return activeLevel;
	//}
	
	public void addLevel(Level level){
		levels.add(level);
		System.out.println(levels.size());
	}
}