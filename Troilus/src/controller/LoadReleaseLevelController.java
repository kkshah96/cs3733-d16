package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LevelBuilder;
import model.ReleaseLevel;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the loading of a puzzle level for editing.
 * @author Connor Weeks
 *
 */
public class LoadReleaseLevelController implements ActionListener {
	/** The builder entity */
	LevelBuilder builder;
	
	/** The ReleaseLevel this controller refers to */
	ReleaseLevel level;
	
	/** The top level GUI for this */
	LevelLoaderView levelLoader;

	/**
	 * Creates a new instance of LoadReleaseLevelController with the following parameters
	 * @param levelLoader The top level GUI for this controller
	 * @param level The ReleaseLevel object being loaded
	 * @param builder The builder entity for the controller
	 */
	public LoadReleaseLevelController(LevelLoaderView levelLoader, ReleaseLevel level, LevelBuilder builder) {
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

		// Add controller to handle window close
		editorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				editorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, editorView, levelLoader).process();
			}      
		});

		// set level title
		editorView.getLevelTypeLabel().setText("Release");

		// set visibility of level view elements to account for level type
		editorView.setMaxMovesPanelVisibility(false);
		editorView.setReleaseSquarePanelVisibility(true);
		editorView.setTimeLimitPanelVisibility(false);

		// add listeners to handle input
		editorView.getNumberColorComboBox().addActionListener(new SetSquareNumberColorController(level, editorView));
		editorView.getNumberComboBox().addActionListener(new SetSquareNumberController(level, editorView));

		// show level view
		editorView.setLevelType("Release");
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
