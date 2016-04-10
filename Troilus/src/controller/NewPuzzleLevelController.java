package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import MockupGUI.LevelBuilder_Editor;
import MockupGUI.LevelBuilder_Selection;
import MockupGUI.Puzzle_Mockup;
import model.LevelBuilder;

public class NewPuzzleLevelController extends MouseAdapter {

	LevelBuilder builder;
	LevelBuilder_Selection selector;
	
	public NewPuzzleLevelController(LevelBuilder builder, LevelBuilder_Selection selector) {
		this.builder = builder;
		this.selector = selector;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		LevelBuilder_Editor newPuzzleLevel = new LevelBuilder_Editor();
		newPuzzleLevel.setVisible(true);
	}
	
}

