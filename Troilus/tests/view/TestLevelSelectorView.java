package view;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Kabasuji;

public class TestLevelSelectorView {

	@Test
	public void test() {
		// create and initialize Kabasuji
		Kabasuji game = new Kabasuji();
		LevelSelectorView selectorView = new LevelSelectorView(game);

		// make sure selector view has Kabasuji instance we created
		assertEquals(selectorView.game, game);

		
		// make sure the correct number of level buttons were loaded
		assertTrue(selectorView.getLevelButtons().size() >= game.getLevels().size());

		// make sure the correct number of level labels were loaded
		assertTrue(selectorView.getLevelLabels().size() >= game.getLevels().size());
	}

}
