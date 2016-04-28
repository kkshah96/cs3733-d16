package model;

import java.util.ArrayList;
import java.util.Stack;

import controller.LoadLevelsController;
import controller.Move;

/**
 * Top level entity for the LevelBuilder application
 * 
 * The LevelBuilder structure, similar to Kabasuji, contains a collection of Levels and keeps track of the active level (or level being edited)
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 * @author Alex Kasparek
 */
public class LevelBuilder {
	
	ArrayList<Level> levels;
	
	//Level activeLevel;
	
	Stack<Move> moves;
	
	public LevelBuilder() {
		initialize();
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