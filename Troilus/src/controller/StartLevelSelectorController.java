package controller;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;

import model.Kabasuji;
import model.Level;
import view.LevelSelectorView;

public class StartLevelSelectorController {
	Kabasuji game;
	LevelSelectorView levelSelectorView;

	public StartLevelSelectorController(LevelSelectorView levelSelector, Kabasuji game) {
		this.levelSelectorView = levelSelector;
		this.game = game;
	}

	public void process() {
		ArrayList<Level> levels = game.getLevels();
		int numLevels = levels.size();
		
		ArrayList<JButton> buttons = levelSelectorView.getLevelButtons();
		ArrayList<JLabel> labels = levelSelectorView.getLevelLabels();
		// first set all buttons to invisible and disabled
		for (JButton button : buttons) {
			button.setVisible(false);
			button.setEnabled(false);
		}
		
		for (JLabel label : labels) {
			label.setVisible(false);;
		}
		for (int i = 0; i < numLevels; i++) {
			Level currentLevel = levels.get(i);
			JButton currentButton = buttons.get(i);
			// enable buttons if level exists
			currentButton.setVisible(true);
			currentButton.setText("Level " + currentLevel.getLevelNum() + ": " + currentLevel.getName());
			
			labels.get(i).setVisible(true);
			
			// grey out button if locked
			if (!currentLevel.isLocked()) {
				currentButton.setEnabled(true);
			}
		}
	}
}
