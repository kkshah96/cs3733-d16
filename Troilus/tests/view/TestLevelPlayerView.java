package view;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Kabasuji;
import model.Level;

public class TestLevelPlayerView {

	@Test
	public void test() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selectorView = new LevelSelectorView(game);
		Level level = game.getLevels().get(0);
		LevelPlayerView playerView = new LevelPlayerView(selectorView, game, level);
		
		assertEquals(playerView.game, game);
		assertEquals(playerView.level, level);
		assertEquals(playerView.bullpenView.bullpen, level.getBullpen());
		assertEquals(playerView.boardView.board, level.getBoard());
		
	}


}
