package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LevelBuilder;
import model.LightningLevel;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * Controls the display of a loaded level for editing.
 * @author Connor Weeks
 * @author Alex Kasparek
 *
 */
public class LoadLightningLevelController implements ActionListener {
	/** The builder entity used */
	LevelBuilder builder;
	
	/** The lightning level to load */
	LightningLevel level;
	
	/** The view for the lightning level */
	LevelLoaderView levelLoader;

	/**
	 * Creates a new instance of the LoadLightningLevelController with the given parameters
	 * @param levelLoader Boundary object for the lightning level
	 * @param level Reference to the lightning level to load
	 * @param builder Main builder entity
	 */
	public LoadLightningLevelController(LevelLoaderView levelLoader, LightningLevel level, LevelBuilder builder) {
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
		
		editorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				editorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, editorView, levelLoader).process();
			}      
		});
		
		// set level title
		editorView.getLevelTypeLabel().setText("Lightning");

		// set visibility of level view elements to account for level type
		editorView.setMaxMovesPanelVisibility(false);
		editorView.setReleaseSquarePanelVisibility(false);
		editorView.setTimeLimitPanelVisibility(true);
		
		// set text fields to show current state
		editorView.getMinutesField().setText(Integer.toString(level.getTime() / 60));
		editorView.getSecondsField().setText(Integer.toString(level.getTime() % 60));
		
		// add action listeners for changing minutes and seconds as well as the set button
		editorView.getMinutesField().addActionListener(new SetTimeLimitController(level, editorView, builder));
		editorView.getSecondsField().addActionListener(new SetTimeLimitController(level, editorView, builder));
		editorView.getSetTimeButton().addActionListener(new SetTimeLimitController(level, editorView, builder));

		// show level view
		editorView.setLevelType("Lightning");
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
