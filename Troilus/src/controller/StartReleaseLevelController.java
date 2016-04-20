package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

/**
 * Controller to initialize new release level in Kabasuji.
 */
public class StartReleaseLevelController implements ActionListener {
	Kabasuji game;
	int levelNumber;
	LevelSelectorView levelSelector;

	public StartReleaseLevelController(LevelSelectorView levelSelector, int levelNumber, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.levelNumber = levelNumber;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Level selectedLevel = game.getLevels().get(levelNumber - 1);

		// if level is locked, take no action
		if (selectedLevel.isLocked()) {
			return;
		}

		// set active level in top model to selected level
		game.setActiveLevel(selectedLevel);
		
		LevelView levelView = new LevelView(levelSelector, game);

		// set visibility of level view elements to account for level type
		levelView.getPanelPuzzleStats().setVisible(false);
		levelView.getPanelLightningStats().setVisible(false);

		// show level view
		levelView.setVisible(true);
		levelSelector.setVisible(false);
	}
}