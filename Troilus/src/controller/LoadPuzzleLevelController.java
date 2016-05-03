package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LevelBuilder;
import model.PuzzleLevel;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the loading of a puzzle level for editing.
 * @author Connor Weeks
 * @author Alex Kasparek
 *
 */
public class LoadPuzzleLevelController implements ActionListener {
	/** The builder entity */
	LevelBuilder builder;
	
	/** The PuzzleLevel object containing data to play the level */
	PuzzleLevel level;
	
	/** The top level GUI for this */
	LevelLoaderView levelLoader;

	/**
	 * Creates an instance of LoadPuzzleLevelController with the following parameters
	 * @param levelLoader The top level GUI for this controller
	 * @param level The PuzzleLevel object being loaded
	 * @param builder The builder entity for this controller
	 */
	public LoadPuzzleLevelController(LevelLoaderView levelLoader, PuzzleLevel level, LevelBuilder builder) {
		this.levelLoader = levelLoader;
		this.level = level;
		this.builder = builder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// check if shift was down when mouse was clicked; if so, delete level
		if ((e.getModifiers() & InputEvent.SHIFT_MASK) != 0) {
			// delete level
			new DeleteLevelController(builder, level).process();

			// reset level loader
			builder.initialize();
			new StartLevelLoaderController(levelLoader, builder).process();
			return;
		}

		final LevelEditorView editorView = new LevelEditorView(builder, levelLoader, level);

		// Add controller to handle window closes
		editorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				editorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, editorView, levelLoader).process();
			}      
		});

		// set level title
		editorView.getLevelTypeLabel().setText("Puzzle");

		// set visibility of level view elements to account for level type
		editorView.setMaxMovesPanelVisibility(true);
		editorView.setReleaseSquarePanelVisibility(false);
		editorView.setTimeLimitPanelVisibility(false);

		// change text fields to display current state
		editorView.getMaxMovesField().setText(Integer.toString(level.getMaxMoves()));

		// add event listener to handle input
		editorView.getMaxMovesField().addActionListener(new SetMaxMovesController(level, builder, editorView));

		// show level view
		editorView.setLevelType("Puzzle");
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
