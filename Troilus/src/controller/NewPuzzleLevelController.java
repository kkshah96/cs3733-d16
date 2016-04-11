package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LB_LevelEditor;
import MockupGUI.LB_LevelLoader;
import MockupGUI.Puzzle_Mockup;
import model.LevelBuilder;

public class NewPuzzleLevelController extends MouseAdapter {

	LevelBuilder builder;
	LB_LevelLoader selector;
	
	public NewPuzzleLevelController(LevelBuilder builder, LB_LevelLoader selector) {
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

