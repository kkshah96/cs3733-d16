package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LevelEditorView;
import MockupGUI.LevelLoaderView;
import model.LevelBuilder;

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
		LevelEditorView newPuzzleLevel = new LevelEditorView();
		newPuzzleLevel.setVisible(true);
	}
	
}

