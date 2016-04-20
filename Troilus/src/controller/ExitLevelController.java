package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;


/**
 * Controls the actions required to exit a level and display the level selector.
 * This controller saves the plaer's progress, disposes of the current level view,
 * and returns the player to the level selector screen, where he / she may select a 
 * new level to play.
 * 
 * @author Connor Weeks
 *
 */
public class ExitLevelController implements ActionListener {
	Kabasuji game;
	LevelView level;
	LevelSelectorView levelSelector;

	public ExitLevelController(LevelView level, LevelSelectorView levelSelector, Kabasuji game) {
		this.level = level;
		this.levelSelector = levelSelector;
		this.game = game;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//if(lvlSelection.)
		// TODO Auto-generated method stub\
		level.dispose();
		levelSelector.setVisible(true);

	}
}
