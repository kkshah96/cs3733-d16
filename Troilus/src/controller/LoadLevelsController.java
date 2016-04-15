package controller;

import java.util.ArrayList;
import model.Level;

public class LoadLevelsController {

	String filePath;

	public LoadLevelsController() {
		this.filePath = "some/default/path";
	}

	public LoadLevelsController(String filePath) {
		this.filePath = filePath;

	}
	
	
	/**
	 * Loads levels from the file path
	 * @return ArrayList of Levels
	 */
	public ArrayList<Level> loadLevels() {
		ArrayList<Level> levels = new ArrayList<Level>();
		
		
		// TODO: load levels from file here
		
		
		return levels;
	}
}
