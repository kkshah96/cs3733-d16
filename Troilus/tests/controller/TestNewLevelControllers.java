package controller;

import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import model.LevelBuilder;
import view.LevelLoaderView;

public class TestNewLevelControllers extends TestCase {

	public void testNewPuzzleLevelController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		
		NewPuzzleLevelController newPuzzle = new NewPuzzleLevelController(builder, loader);
		ActionEvent event = new ActionEvent(loader.getPuzzleButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		newPuzzle.actionPerformed(event);
		assertFalse(loader.isVisible());
	}
	
	public void testNewLightningLevelController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		
		NewLightningLevelController newLightning = new NewLightningLevelController(builder, loader);
		ActionEvent event = new ActionEvent(loader.getPuzzleButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		newLightning.actionPerformed(event);
		assertFalse(loader.isVisible());
	}
	
	public void testNewReleaseLevelController() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		
		NewReleaseLevelController newRelease = new NewReleaseLevelController(builder, loader);
		ActionEvent event = new ActionEvent(loader.getPuzzleButton(), 0, null);
		loader.setVisible(true);
		
		assertTrue(loader.isVisible());
		newRelease.actionPerformed(event);
		assertFalse(loader.isVisible());
	}

}
