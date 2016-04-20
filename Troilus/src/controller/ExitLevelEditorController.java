package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;


/**
 * Controls the actions required to exit a level editor and display the level loader.
 * This controller disposes of the current level editor view and returns the designer 
 * to the level loader screen, where he / she may load a new level to edit.
 * 
 * @author Connor Weeks
 *
 */
public class ExitLevelEditorController implements ActionListener {
	LevelBuilder builder;
	LevelEditorView levelEditor;
	LevelLoaderView levelLoader;
	
	public ExitLevelEditorController(LevelBuilder builder, LevelEditorView levelEditor, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelEditor = levelEditor;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				levelEditor.dispose();
				levelLoader.setVisible(true);
		
	}
}