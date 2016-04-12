package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

public class StartLevelController extends MouseAdapter {
	Kabasuji game;
	LevelSelectorView levelSelector;
	
	public StartLevelController(LevelSelectorView levelSelector, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.game = game;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//if(lvlSelection.)
		LevelView level = new LevelView(levelSelector);
		level.setVisible(true);
		levelSelector.setVisible(false);
	}
}
