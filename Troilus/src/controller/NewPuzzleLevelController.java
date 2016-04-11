package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewPuzzleLevelController extends MouseAdapter {
	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewPuzzleLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LevelEditorView newPuzzleLevel = new LevelEditorView(builder, levelLoader);
		newPuzzleLevel.setMaxMovesPanelVisibility(true);
		newPuzzleLevel.setReleaseSquareOptionsPanel(false);
		newPuzzleLevel.setTimePanel(false);
		
		levelLoader.setVisible(false);
		newPuzzleLevel.setVisible(true);
	}	
}