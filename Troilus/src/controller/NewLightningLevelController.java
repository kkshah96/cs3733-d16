package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewLightningLevelController extends MouseAdapter {

	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewLightningLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LevelEditorView newLightningLevel = new LevelEditorView();
		newLightningLevel.setLevelType("Lightning");
		newLightningLevel.setVisible(true);
	}
	
}

