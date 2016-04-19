package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.LightningLevel;
import model.Palette;
import model.ReleaseLevel;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewReleaseLevelController extends MouseAdapter {
	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewReleaseLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		final LevelEditorView newReleaseLevel = new LevelEditorView(builder, levelLoader);
		
		newReleaseLevel.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newReleaseLevel.dispose();
				levelLoader.setVisible(true);
			}      
		});
		
		//Show/hide specific elements to only show things relevant to release levels
		newReleaseLevel.setLevelType("Release");
		newReleaseLevel.setMaxMovesPanelVisibility(false);
		newReleaseLevel.setReleaseSquarePanelVisibility(true);
		newReleaseLevel.setTimeLimitPanelVisibility(false);
		
		Bullpen bpen = new Bullpen();
		Board board = new Board();
		Palette p = new Palette();
		ReleaseLevel r = new ReleaseLevel(0, true, bpen, board, p);
		builder.addLevel(r);

		levelLoader.setVisible(false);
		newReleaseLevel.setVisible(true);
	}
}