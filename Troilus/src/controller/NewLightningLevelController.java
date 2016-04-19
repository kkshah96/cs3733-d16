package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.LightningLevel;
import model.Palette;
import view.LevelEditorView;
import view.LevelLoaderView;

public class NewLightningLevelController implements ActionListener {
	LevelBuilder builder;
	LevelLoaderView levelLoader;
	
	public NewLightningLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
		initialize();
	}
	
	private void initialize(){
		Bullpen bpen = new Bullpen();
		Board board = new Board();
		Palette p = new Palette();
		LightningLevel l = new LightningLevel(0, true, bpen, board, p, 0);
		builder.addLevel(l);
		builder.setActiveLevel(l); // TODO: Will we have to handle setting activeLevel to null in the future when a level is exited?
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

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