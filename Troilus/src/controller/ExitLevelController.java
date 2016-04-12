package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

public class ExitLevelController extends MouseAdapter {
	Kabasuji game;
	LevelView level;
	LevelSelectorView levelSelector;

	public ExitLevelController(LevelView level, LevelSelectorView levelSelector, Kabasuji game) {
		this.level = level;
		this.levelSelector = levelSelector;
		this.game = game;
	}

	public void mousePressed(MouseEvent e) {
		//if(lvlSelection.)
		// TODO Auto-generated method stub\
		level.dispose();
		levelSelector.setVisible(true);
	}
}
