package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LB_LevelEditor;
import MockupGUI.LevelLoaderView;
import model.LevelBuilder;

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
		LB_LevelEditor newReleaseLevel = new LB_LevelEditor();
		newReleaseLevel.setVisible(true);
	}
	
}

