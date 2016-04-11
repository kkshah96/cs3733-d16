package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.LevelBuilder;
import view.LevelEditorView;
import view.LevelLoaderView;

public class ExitLevelEditorController extends MouseAdapter {
	LevelBuilder builder;
	LevelEditorView levelEditor;
	LevelLoaderView levelLoader;
	
	public ExitLevelEditorController(LevelBuilder builder, LevelEditorView levelEditor, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelEditor = levelEditor;
		this.levelLoader = levelLoader;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		levelEditor.dispose();
		levelLoader.setVisible(true);
	}
}