package controller;

import java.util.ArrayList;
import model.Level;

/** 
 * Controls the high-level loading of levels.
 * This controller obtains level classes from the low-level 
 * XML classes and returns them in a list format.
 * 
 * @author Connor Weeks
 *
 */
public class LoadLevelsController {
	/** The path to load levels from */
	String filePath;

	/**
	 * Creates a new instance of LoadLevelsController, using default path
	 */
	public LoadLevelsController() {
		this.filePath = "./src/levels/";
	}

	/**
	 * Creates a new instance of LoadLevelsController with a user-specified path
	 * @param filePath
	 */
	public LoadLevelsController(String filePath) {
		this.filePath = filePath;

	}
	
	/**
	 * Loads levels from the file path
	 * @return ArrayList of Levels
	 */
	public ArrayList<Level> loadLevels() {
		LevelFileInputController fileInput = new LevelFileInputController();
		return fileInput.getLevels();
	}
}