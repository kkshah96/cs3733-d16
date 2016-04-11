package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LB_LevelEditor;
import MockupGUI.LB_LevelLoader;
import MockupGUI.Release_Mockup;
import model.LevelBuilder;

public class NewReleaseLevelController extends MouseAdapter {

	LevelBuilder builder;
	LB_LevelLoader selector;
	
	public NewReleaseLevelController(LevelBuilder builder, LB_LevelLoader selector) {
		this.builder = builder;
		this.selector = selector;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LB_LevelEditor newReleaseLevel = new LB_LevelEditor();
		newReleaseLevel.setVisible(true);
	}
	
}

