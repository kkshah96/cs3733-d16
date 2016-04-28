package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * Controls the actions required to exit a level editor and display the level loader.
 * This controller disposes of the current level editor view and returns the designer 
 * to the level loader screen, where he / she may load a new level to edit.
 * 
 * @author Connor Weeks
 *
 */
public class ExitLevelEditorController implements ActionListener {
	/** The builder entity */
	LevelBuilder builder;
	
	/** The view for the current LevelEditor */
	LevelEditorView levelEditor;
	
	/** The view for the prior LevelLoader */
	LevelLoaderView levelLoader;

	/**
	 * Creates a new instance of the ExitLevelEditorController with the given parameters
	 * @param builder The main builder entity object
	 * @param levelEditor The view for the current editor
	 * @param levelLoader The view for the prior loader
	 */
	public ExitLevelEditorController(LevelBuilder builder, LevelEditorView levelEditor, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelEditor = levelEditor;
		this.levelLoader = levelLoader;
	}

	/**
	 * This event is tied to a button click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}

	/**
	 * performs the reloading of the level loader to account for new levels.
	 */
	public void process() {
		// refresh levels in builder
		builder.initialize();

		// dispose of curret editor and builder
		levelEditor.dispose();
		levelLoader.dispose();

		// create new loader view
		LevelLoaderView window = new LevelLoaderView(builder);

		// allow controller to set up GUI based on the levels loaded by 'builder'
		StartLevelLoaderController loaderController = new StartLevelLoaderController(window, builder);
		loaderController.process();

		// show the window
		window.setVisible(true);
	}
}