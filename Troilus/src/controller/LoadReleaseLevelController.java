package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Level;
import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * 
 * @author Connor Weeks
 *
 */
public class LoadReleaseLevelController implements ActionListener {
	LevelBuilder builder;
	Level level;
	LevelLoaderView levelLoader;

	public LoadReleaseLevelController(LevelLoaderView levelLoader, Level level, LevelBuilder builder) {
		this.levelLoader = levelLoader;
		this.level = level;
		this.builder = builder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// do ont open level if it is locked TODO implement this
		if (level.isLocked()) {
			//return;
		}
		if (level.getPalette() == null) {
			System.out.println("no palette");
		}

		final LevelEditorView editorView = new LevelEditorView(builder, levelLoader, level);
		
		editorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				editorView.dispose();
				levelLoader.setVisible(true);
			}      
		});

		// set visibility of level view elements to account for level type
		editorView.setMaxMovesPanelVisibility(false);
		editorView.setReleaseSquarePanelVisibility(true);
		editorView.setTimeLimitPanelVisibility(false);

		// show level view
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
