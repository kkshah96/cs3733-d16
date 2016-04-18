package test.model;

import model.Level;

public class TestLevel1 {
	
	@Test
	public void testInitialization() {
		Level puzzle = new PuzzleLevel(1, false, new Bullpen(), new Board(), new Palette(), 15);
	}
}