package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

public class StartLevelController extends MouseAdapter {
	Kabasuji game;
	int levelNumber;
	LevelSelectorView levelSelector;
	
	public StartLevelController(LevelSelectorView levelSelector, int levelNumber, Kabasuji game) {
		this.levelSelector = levelSelector;
		this.levelNumber = levelNumber;
		this.game = game;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Level selectedLevel = game.getLevels().get(levelNumber - 1);
		
		// if level is locked, take no action
		if (selectedLevel.isLocked()) {
			return;
		}
		
		LevelView level = new LevelView(levelSelector);
		level.setVisible(true);
		levelSelector.setVisible(false);
	}
}
