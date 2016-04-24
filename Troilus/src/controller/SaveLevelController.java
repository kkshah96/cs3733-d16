package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;


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
	
	Level level;
	String filePath;

	public SaveLevelController(Level level) {
		this.level = level;
		this.filePath = "./src/levels";
	}
	
	public SaveLevelController(Level level, String filePath) {
		this.level = level;
		this.filePath = filePath;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (level == null) {
			System.err.println("level is null");
		}
		// create new low level output object and store level
		LevelXMLOutputController output = new LevelXMLOutputController(level, filePath);
		output.storeLevelToFile();
		
		//TODO: When a level is saved, we need to add that level to the Kabausji Level arraylist--will that lgoci be handled here?
	}
}