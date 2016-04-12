package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

public class StartPuzzleLevelController extends MouseAdapter {
	Kabasuji game;
	int levelNumber;
	LevelSelectorView levelSelector;

	public StartPuzzleLevelController(LevelSelectorView levelSelector, int levelNumber, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.levelNumber = levelNumber;
		this.game = game;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Level selectedLevel = game.getLevels().get(levelNumber - 1);

		// if level is locked, take no action
		if (selectedLevel.isLocked()) {
			return;
		}



		LevelView levelView = new LevelView(levelSelector, game);

		// set active level in top model to selected level
		game.setActiveLevel(selectedLevel);

		// set visibility of level view elements to account for level type
		levelView.getPanelLightningStats().setVisible(false);
		levelView.getPanelReleaseStats().setVisible(false);

		// show level view
		levelView.setVisible(true);
		levelSelector.setVisible(false);
	}
}
