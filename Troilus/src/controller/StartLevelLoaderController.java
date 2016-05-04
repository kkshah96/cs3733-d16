package controller;

import java.util.ArrayList;

import javax.swing.JButton;

import model.LevelBuilder;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
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
	/** The level builder entity */
	LevelBuilder builder;
	
	/** The view for the top-level builder */
	LevelLoaderView levelLoaderView;

	/**
	 * Creates a new instance of StartLevelLoaderController with the following parameters
	 * @param levelLoaderView Reference to the view of the level builder
	 * @param builder Reference to the builder entity being represented
	 */
	public StartLevelLoaderController(LevelLoaderView levelLoaderView, LevelBuilder builder) {
		this.levelLoaderView = levelLoaderView;
		this.builder = builder;
	}

	/**
	 * Initializes the level loader for interaction.
	 */
	public void process() {
		// Get the levels from the builder
		ArrayList<Level> levels = builder.getLevels();
		int numLevels = levels.size();
		
		ArrayList<JButton> buttons = levelLoaderView.getLevelButtons();
		// first set all buttons to invisible and disabled
		for (JButton button : buttons) {
			button.setVisible(false);
			button.setEnabled(false);
		}
		
		// Loop through all levels to update their corresponding buttons and apply the proper controller
		// based on level type
		for (int i = 0; i < numLevels; i++) {
			Level level = levels.get(i);
			// enable buttons if level exists; set text accordingly
			buttons.get(i).setText("Level " + level.getLevelNum() + ": " + level.getName());
			buttons.get(i).setVisible(true);
			buttons.get(i).setEnabled(true);
			if (level.getName().equals("Puzzle")) {
				buttons.get(i).addActionListener(new LoadPuzzleLevelController(levelLoaderView, (PuzzleLevel)level, builder));
			}
			else if (level.getName().equals("Lightning")) {
				buttons.get(i).addActionListener(new LoadLightningLevelController(levelLoaderView, (LightningLevel)level, builder));
			}
			else if (level.getName().equals("Release")) {
				buttons.get(i).addActionListener(new LoadReleaseLevelController(levelLoaderView, (ReleaseLevel)level, builder));
			}
			else {
				throw new RuntimeException("Unexpected level type found");
			}
		}
	}
}