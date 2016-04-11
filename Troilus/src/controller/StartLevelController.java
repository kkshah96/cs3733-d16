package controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import MockupGUI.Level_Selection;
import MockupGUI.Puzzle_Mockup;
import model.Kabasuji;

public class StartLevelController extends MouseAdapter {

	Kabasuji game;
	Level_Selection lvlSelection;
	
	public StartLevelController(Level_Selection lvlSelection, Kabasuji game) {
		this.lvlSelection = lvlSelection;
		this.game = game;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//if(lvlSelection.)
		// TODO Auto-generated method stub
		Puzzle_Mockup puzzleLevel = new Puzzle_Mockup();
		puzzleLevel.setVisible(true);
	}

}
