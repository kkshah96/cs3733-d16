package controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

import model.Kabasuji;
import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.LevelSelectorView;

/**
 * Controls the display of level buttons corresponding to the levels loaded.
 * Buttons are displayed only for levels loaded at initialization; the text
 * of these buttons are set dynamically, depending on the type of level loaded.
 * 
 * @author Connor Weeks
 *
 */
public class StartLevelSelectorController {
	/** The top-level Kabasuji game */
	Kabasuji game;
	
	/** The view for the top-level model */
	LevelSelectorView levelSelectorView;

	/**
	 * Creates a new instance of StartLevelSelectorController with the following parameters
	 * @param levelSelector Reference to the view of the top-level model
	 * @param game Reference to the top-level entity to use
	 */
	public StartLevelSelectorController(LevelSelectorView levelSelector, Kabasuji game) {
		this.levelSelectorView = levelSelector;
		this.game = game;
	}

	/**
	 * Initializes the level selector in Kabasuji for interaction
	 */
	public void process() {
		// Get the levels from the entity
		ArrayList<Level> levels = game.getLevels();
		int numLevels = levels.size();
		
		// Get the corresponding buttons
		ArrayList<JButton> buttons = levelSelectorView.getLevelButtons();
		ArrayList<JLabel> labels = levelSelectorView.getLevelLabels();
		
		// first set all buttons to invisible and disabled
		for (JButton button : buttons) {
			button.setVisible(false);
			button.setEnabled(false);
		}
		
		// Set all corresponding labels to disabled to start
		for (JLabel label : labels) {
			label.setVisible(false);
		}
		
		// Loop through all loaded levels
		for (int i = 0; i < numLevels; i++) {
			Level currentLevel = levels.get(i);
			
			// enable buttons if level exists
			JButton currentButton = buttons.get(i);
			String name = currentLevel.getName();
			currentButton.setVisible(true);
			currentButton.setText("Level " + currentLevel.getLevelNum() + ": " + name);
			
			// Add the correct controller in the listener depending on level type
			if (name.equals("Puzzle")) {
				currentButton.addActionListener(new StartPuzzleLevelController(levelSelectorView, (PuzzleLevel)currentLevel, game));
			} else if (name.equals("Lightning")) {
				currentButton.addActionListener(new StartLightningLevelController(levelSelectorView, (LightningLevel)currentLevel, game));
			} else if (name.equals("Release")) {
				currentButton.addActionListener(new StartReleaseLevelController(levelSelectorView, (ReleaseLevel)currentLevel, game));
			}
			labels.get(i).setVisible(true);
			labels.get(i).setText("Stars: " + currentLevel.getNumStars() + "/" + Level.MAX_STARS);
			
			// grey out button if locked
			if (currentLevel.isLocked()) {
				currentButton.setEnabled(false);
			} else {
				currentButton.setEnabled(true);
			}
		}
	}
}