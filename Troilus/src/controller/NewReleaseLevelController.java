package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewReleaseLevelController extends MouseAdapter {
	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewReleaseLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LevelEditorView newReleaseLevel = new LevelEditorView(builder, levelLoader);
		newReleaseLevel.setLevelType("Release");
		newReleaseLevel.setMaxMovesPanelVisibility(false);
		newReleaseLevel.setReleaseSquareOptionsPanel(true);
		newReleaseLevel.setTimePanel(false);

		levelLoader.setVisible(false);
		newReleaseLevel.setVisible(true);
	}
}