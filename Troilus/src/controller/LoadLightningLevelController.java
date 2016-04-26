package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LevelBuilder;
import model.LightningLevel;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * Controls the display of a loaded level for editing.
 * @author Connor Weeks
 *
 */
public class LoadLightningLevelController implements ActionListener {
	LevelBuilder builder;
	LightningLevel level;
	LevelLoaderView levelLoader;

	public LoadLightningLevelController(LevelLoaderView levelLoader, LightningLevel level, LevelBuilder builder) {
		this.levelLoader = levelLoader;
		this.level = level;
		this.builder = builder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		final LevelEditorView editorView = new LevelEditorView(builder, levelLoader, level);
		
		editorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				editorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, editorView, levelLoader).process();
			}      
		});

		// set visibility of level view elements to account for level type
		editorView.setMaxMovesPanelVisibility(false);
		editorView.setReleaseSquarePanelVisibility(false);
		editorView.setTimeLimitPanelVisibility(true);
		
		// set text fields to show current state
		editorView.getMinutesField().setText(Integer.toString(level.getTime() / 60));
		editorView.getSecondsField().setText(Integer.toString(level.getTime() % 60));
		
		// add action listeners for changing minutes and seconds
		editorView.getMinutesField().addActionListener(new SetTimeLimitController(level, editorView));
		editorView.getSecondsField().addActionListener(new SetTimeLimitController(level, editorView));
		

		// show level view
		editorView.setLevelType("Lightning");
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
