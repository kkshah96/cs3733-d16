package model;

import org.junit.Test;

import model.Level;

public class TestPuzzleLevel {
	
	@Test
	public void testInitialization() {
		Level puzzle = new PuzzleLevel(1, false, new Bullpen(), new Board(), new Palette(), 15);
	}
}