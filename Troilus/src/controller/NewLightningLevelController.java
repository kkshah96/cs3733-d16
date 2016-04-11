package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LB_LevelEditor;
import MockupGUI.Level_Selection;
import model.LevelBuilder;

public class NewLightningLevelController extends MouseAdapter {

	LevelBuilder builder;
	Level_Selection selector;
	
	public NewLightningLevelController(LevelBuilder builder, Level_Selection selector) {
		this.builder = builder;
		this.selector = selector;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LB_LevelEditor newPuzzleLevel = new LB_LevelEditor();
		newPuzzleLevel.setVisible(true);
	}
	
}

