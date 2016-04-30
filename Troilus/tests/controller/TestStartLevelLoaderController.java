package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import model.LevelBuilder;
import view.LevelLoaderView;

public class TestStartLevelLoaderController {

	@Test
	public void test() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView window = new LevelLoaderView(builder);

		// allow controller to set up GUI based on the levels loaded by 'game'
		StartLevelLoaderController loaderController = new StartLevelLoaderController(window, builder);
		loaderController.process();

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
		
		assertEquals(builder.getNumLevels(), visibleButtons);
	}

}
