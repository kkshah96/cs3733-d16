package model;

import java.util.ArrayList;

import controller.LoadLevelsController;

public class LevelBuilder {
	
	ArrayList<Level> levels;
	Level activeLevel;
	
	public LevelBuilder() {
		
		// TODO: UNCOMMENT THIS LATER
		/*
		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();
		
		// load levels into the list of levels
		levels = loader.loadLevels();
		
		 */
		
		
		// stubs for testing
		levels = new ArrayList<Level>();
		for(int i = 0; i < 24; i++){
			Level level;
			if (i % 3 == 0) {
				level = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
			}
			else if (i % 3 == 1) {
				level = new LightningLevel(i, false, new Bullpen(), new Board(), new  Palette(), 10);
			}
			else {
				level = new ReleaseLevel(i, false, new Bullpen(), new Board(), new  Palette());
			}
			
			// show the first three levels
			if(i >= 3) {
				level.setLocked(true);
			}
			
			levels.add(level);
		}
		
	}
	
	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	public int getNumLevels() {
		return levels.size();
	}
	
	public void setActiveLevel(Level level) {
		activeLevel = level;
	}
	
	public Level getActiveLevel() {
		return activeLevel;
	}
	
	public void addLevel(Level level){
		levels.add(level);
	}
}