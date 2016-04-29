package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Kabasuji;
import model.Level;
import view.LevelSelectorView;
import view.LevelPlayerView;

/**
 * Controls the actions required to exit a level and display the level selector.
 * This controller saves the plaer's progress, disposes of the current level view,
 * and returns the player to the level selector screen, where he / she may select a 
 * new level to play.
 * 
 * @author Connor Weeks
 *
 */
public class ExitLevelController implements ActionListener {
	/** The game */
	Kabasuji game;

	/** The levelview for the current level */
	LevelPlayerView levelView;

	/** The current level object */
	Level level;

	/** The number of stars the level has before the start of the game */
	int initialStars;

	/**
	 * Creates a new ExitLevelController for the given parameters
	 * @param levelView Boundary object for the current level
	 * @param game Reference to the main game entity
	 */
	public ExitLevelController(LevelPlayerView levelView, Kabasuji game, Level level) {
		this.levelView = levelView;
		this.game = game;
		this.level = level;
		this.initialStars = level.getNumStars();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}

	/**
	 * Completes the exiting of the current level
	 */
	public void process() {

		// check if the stars earned is greater than the initial stars
		if (level.getNumStars() > initialStars) {
			System.out.println("Tying to save level stars");
			// save current level progress
			new LevelXMLOutputController(level).saveLevelStars();;
		}

		// tell the timer the level is over if need be
		levelView.setActive(false);

		// reset game
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
}