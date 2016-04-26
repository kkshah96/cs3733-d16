package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	LevelBuilder builder;
	ReleaseLevel level;
	LevelLoaderView levelLoader;

	public LoadReleaseLevelController(LevelLoaderView levelLoader, ReleaseLevel level, LevelBuilder builder) {
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
