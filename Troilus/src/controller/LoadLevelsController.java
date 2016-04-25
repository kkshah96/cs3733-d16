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
	String filePath;

	public LoadLevelsController() {
		this.filePath = "./src/levels/";
	}

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