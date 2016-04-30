package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import model.Kabasuji;
import view.LevelSelectorView;

public class TestStartLevelSelectorController {

	@Test
	public void test() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView window = new LevelSelectorView(game);

		// allow controller to set up GUI based on the levels loaded by 'game'
		StartLevelSelectorController selectorController = new StartLevelSelectorController(window, game);
		selectorController.process();

		// show window
		window.setVisible(true);
		
		// test number of visible levels
		ArrayList<JButton> buttons = window.getLevelButtons();
		int visibleButtons;
		for (visibleButtons = 0; visibleButtons < buttons.size(); visibleButtons++) {
			// break at first invisible button
			if (!buttons.get(visibleButtons).isVisible()) {
				break;
			}
		}
		
		assertEquals(game.getNumLevels(), visibleButtons);
	}

}
