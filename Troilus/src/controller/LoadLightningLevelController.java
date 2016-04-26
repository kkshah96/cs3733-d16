package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Level;
import model.LevelBuilder;
import model.LightningLevel;
import view.LevelEditorView;
import view.LevelLoaderView;


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
		
		// TODO implement the below
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
		editorView.setReleaseSquarePanelVisibility(false);
		editorView.setTimeLimitPanelVisibility(true);
		
		// set text fields to show current state

		// show level view
		editorView.setLevelType("Lightning");
		editorView.setVisible(true);
		levelLoader.setVisible(false);
	}

}
