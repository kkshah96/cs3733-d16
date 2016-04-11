package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LevelBuilder_Editor;
import MockupGUI.LevelBuilder_Selection;
import MockupGUI.Release_Mockup;
import model.LevelBuilder;

public class NewReleaseLevelController extends MouseAdapter {

	LevelBuilder builder;
	LevelBuilder_Selection selector;
	
	public NewReleaseLevelController(LevelBuilder builder, LevelBuilder_Selection selector) {
		this.builder = builder;
		this.selector = selector;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LevelBuilder_Editor newReleaseLevel = new LevelBuilder_Editor();
		newReleaseLevel.setVisible(true);
	}
	
}

