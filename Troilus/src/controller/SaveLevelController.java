package controller;

import model.Level;

public class SaveLevelController {
	
	String filePath;
	
	public SaveLevelController() {
		this.filePath = "/some/default/path";
	}
	
	public SaveLevelController(String filePath) {
		this.filePath = filePath;
	}
	
	public void saveLevel(Level level) {
		// do save operation here regarding XML
	}

}
