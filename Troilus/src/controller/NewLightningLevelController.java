package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewLightningLevelController extends MouseAdapter {
	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewLightningLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		final LevelEditorView newLightningLevel = new LevelEditorView(builder, levelLoader);
		
		newLightningLevel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newLightningLevel.dispose();
				levelLoader.setVisible(true);
			}      
		});
		
		//Show/hide specific elements to only show things relevant to lightning levels
		newLightningLevel.setLevelType("Lightning");
		newLightningLevel.setMaxMovesPanelVisibility(false);
		newLightningLevel.setReleaseSquarePanelVisibility(false);
		newLightningLevel.setTimeLimitPanelVisibility(true);
		
		levelLoader.setVisible(false);
		newLightningLevel.setVisible(true);
	}
}