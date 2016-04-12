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
		// Since this only varies by Level type and must also be done in gameplay, we
		// might be able to have an Initialize() method for each Level subclass that
		// sets the appropriate visibility...
		newPuzzleLevel.setMaxMovesPanelVisibility(true);
		newPuzzleLevel.setReleaseSquarePanelVisibility(false);
		newPuzzleLevel.setTimeLimitPanelVisibility(false);
		
		levelLoader.setVisible(false);
		newPuzzleLevel.setVisible(true);
	}	
}