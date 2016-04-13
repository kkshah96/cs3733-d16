package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Level;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

/**
 * Controller to initialize new puzzle level in Kabasuji.
 */
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



		final LevelView levelView = new LevelView(levelSelector, game);
		levelView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				levelView.dispose();
				levelSelector.setVisible(true);
			}      
		});
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
