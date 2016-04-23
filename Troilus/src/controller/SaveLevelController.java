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
		// TODO: do save operation here regarding XML
		
		//TODO: When a level is saved, we need to add that level to the Kabausji Level arraylist--will that lgoci be handled here?
	}
}