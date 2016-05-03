package view;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Board;
import model.Bullpen;
import model.Kabasuji;
import model.Level;
import model.Palette;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.Square;

public class TestLevelPlayerView {

	@Test
	public void test() {
		Kabasuji game = new Kabasuji();
		LevelSelectorView selectorView = new LevelSelectorView(game);
		Square[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		Level level = new PuzzleLevel(1, false, new Bullpen(), new Board(squares), Palette.getInstance(), 8);
		
		LevelPlayerView playerView = new LevelPlayerView(selectorView, game, level);
		
		assertEquals(playerView.game, game);
		assertEquals(playerView.level, level);
		assertEquals(playerView.bullpenView.bullpen, level.getBullpen());
		assertEquals(playerView.boardView.board, level.getBoard());
		
	}


}
