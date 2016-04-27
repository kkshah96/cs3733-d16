package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Level;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

/**
 * Controller to initialize new release level in Kabasuji.
 * @author Connor Weeks
 */
public class StartReleaseLevelController implements ActionListener {
	Kabasuji game;
	Level level;
	LevelSelectorView levelSelector;

	public StartReleaseLevelController(LevelSelectorView levelSelector, Level level, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.level = level;
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if level is locked, take no action
		if (level.isLocked()) {
			return;
		}
		System.out.println("Starting Release level");
		final LevelView levelView = new LevelView(levelSelector, game, level);
		levelView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				levelView.dispose();
				// TODO save level progress?
				
				// dispose of level view and reload all levels
				levelView.dispose();
				game.initialize();
				
				// create new window
				LevelSelectorView window = new LevelSelectorView(game);
				
				// allow controller to set up GUI based on the levels loaded by 'game'
				StartLevelSelectorController selectorController = new StartLevelSelectorController(window, game);
				selectorController.process();
				
				// show window
				window.setVisible(true);
			}      
		});
		// set active level in top model to selected level
		//game.setActiveLevel(selectedLevel);

		// set visibility of level view elements to account for level type
		levelView.getPanelLightningStats().setVisible(false);
		levelView.getPanelPuzzleStats().setVisible(false);

		// show level view
		levelView.setVisible(true);
		
		// dispose of level selector view
		// old levelSelector.setVisible(false);
		levelSelector.dispose();
		
	}
}