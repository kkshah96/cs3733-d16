package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;


/**
 * Controls the abstract saving of the level.  This controller
 * is linked to the save button in the level builder; when the 
 * designer clicks the button, the current level is saved, 
 * overwriting any previous versions. For the low level 
 * implementation, see LevelXMLOutputController.
 * 
 * @author Connor Weeks
 *
 */
public class SaveLevelController implements ActionListener {
	
	LevelBuilder levelBuilder;
	String filePath;

	public SaveLevelController(LevelBuilder levelBuilder) {
		this.levelBuilder = levelBuilder;
		this.filePath = "./src/levels/";
	}
	
	public SaveLevelController(LevelBuilder levelBuilder, String filePath) {
		this.levelBuilder = levelBuilder;
		this.filePath = filePath;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// create new low level output object and store level
		new LevelFileOutputController(levelBuilder);
		
		//TODO: When a level is saved, we need to add that level to the Kabausji Level arraylist--will that lgoci be handled here?
	}
}