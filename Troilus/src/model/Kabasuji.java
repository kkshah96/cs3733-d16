package model;

import java.util.ArrayList;

import controller.LoadLevelsController;

public class Kabasuji {

	ArrayList<Level> levels;
	Level activeLevel;
	
	public Kabasuji() {
		
		// TODO: UNCOMMENT THIS LATER
		/*
		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();
		
		// load levels into the list of levels
		levels = loader.loadLevels();
		*/
		// stubs for testing:
		
		levels = new ArrayList<Level>();
		for(int i = 0; i < 24; i++){
			Level level;
			if (i % 3 == 0) {
				level = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(null), 10);
			}
			else if (i % 3 == 1) {
				level = new LightningLevel(i, false, new Bullpen(), new Board(), new  Palette(null), 10);
			}
			else {
				level = new ReleaseLevel(i, false, new Bullpen(), new Board(), new  Palette(null));
			}
			
			// show only the first level as unlocked, lock every other level
			if(i >= 1) {
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
}