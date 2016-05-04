package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LightningLevel;
import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelPlayerView;

/**
 * Controller to initialize new lightning level in Kabasuji.
 * @author Connor Weeks
 */
public class StartLightningLevelController implements ActionListener {
	/** The top-level game entity */
	Kabasuji game;
	
	/** The lightning level to play */
	LightningLevel level;
	
	/** The view for the top-level entity */
	LevelSelectorView levelSelector;

	/**
	 * Creates a new instance of StartLightningLevelController with the following parameters
	 * @param levelSelector Reference to the view for the level selection window
	 * @param level Reference to the level to be selected for playing
	 * @param game Reference to the top-level entity, containing the level
	 */
	public StartLightningLevelController(LevelSelectorView levelSelector, LightningLevel level, Kabasuji game) {
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
		
		// Otherwise, create the new view for the level and add a controller to handle window close
		final LevelPlayerView levelView = new LevelPlayerView(levelSelector, game, level);
		levelView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				levelView.dispose();

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
		
		// set title of level and set stars to 0
		levelView.getLevelLabel().setText("Level " + level.getLevelNum() + ": " + level.getName());
		level.setNumStars(0);

		// set visibility of level view elements to account for level type
		levelView.getPanelPuzzleStats().setVisible(false);
		levelView.getPanelReleaseStats().setVisible(false);
		
		// set initial time left and create timer controller
		int seconds  = level.getTime() % 60;
		String secondsString = Integer.toString(seconds);
		if (seconds < 10) {
			secondsString = "0" + seconds;
		}
		levelView.getTimeLabel().setText("Time Remaining: " + (level.getTime() / 60) + ":" + secondsString);
		new TimerController(levelView, game, level, level.getTime()).process();
		

		// show level view
		levelView.setVisible(true);

		// dispose of level selector view
		levelSelector.dispose();
	}
}