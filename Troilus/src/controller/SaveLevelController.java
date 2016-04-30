package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;


/**
 * Controls the abstract saving of the level.
 * This controller is linked to the save button in the level builder;
 * when the designer clicks the button, the current level is saved, 
 * overwriting any previous versions. For the low level 
 * implementation, see LevelXMLOutputController.
 * 
 * @author Connor Weeks
 *
 */
public class SaveLevelController implements ActionListener {
	/** Top-level LevelBuilder entity */
	LevelBuilder levelBuilder;
	
	/** Path to folder to store levels at */
	String filePath;

	/**
	 * Creates a new instance of SaveLevelController, assuming default path
	 * @param levelBuilder Reference to the builder entity to save with
	 */
	public SaveLevelController(LevelBuilder levelBuilder) {
		this.levelBuilder = levelBuilder;
		this.filePath = "./src/levels/";
	}
	
	/**
	 * Creates a new instance of SaveLevelController, with a provided path
	 * @param levelBuilder Reference to the builer entity to save with
	 * @param filePath Path to the folder to save files to (end with a /)
	 */
	public SaveLevelController(LevelBuilder levelBuilder, String filePath) {
		this.levelBuilder = levelBuilder;
		this.filePath = filePath;
	}
	
	/**
	 * Saves levels on the click of the save button.
	 * @param e The ActionEvent triggered by the button press.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// create new low level output object and store level
		new LevelFileOutputController(levelBuilder);
	}
}