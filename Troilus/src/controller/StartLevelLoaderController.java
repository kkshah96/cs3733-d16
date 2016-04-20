package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import model.LevelBuilder;
import model.Level;
import view.LevelLoaderView;


/** 
 * Controls the display of level buttons corresponding to the loaded levels.
 * Buttons are displayed only for levels loaded at initialization; the text
 * of these buttons are set dynamically, depending on the type of level loaded.
 * 
 * @author Connor Weeks
 *
 */
public class StartLevelLoaderController {
	LevelBuilder builder;
	LevelLoaderView levelLoaderView;

	public StartLevelLoaderController(LevelLoaderView levelLoaderView, LevelBuilder builder) {
		this.levelLoaderView = levelLoaderView;
		this.builder = builder;
	}

	public void process() {
		ArrayList<Level> levels = builder.getLevels();
		int numLevels = levels.size();
		
		ArrayList<JButton> buttons = levelLoaderView.getLevelButtons();
		// first set all buttons to invisible and disabled
		for (JButton button : buttons) {
			button.setVisible(false);
			button.setEnabled(false);
		}
		
		System.out.println(levels.size());
		
		for (int i = 0; i < numLevels; i++) {
			// enable buttons if level exists; set text accordingly
			buttons.get(i).setText("Level " + levels.get(i).getLevelNum() + ": " + levels.get(i).getName());
			buttons.get(i).setVisible(true);
			buttons.get(i).setEnabled(true);
			
		}
	}
}