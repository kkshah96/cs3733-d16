package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


import model.Level;
import model.LevelBuilder;
import model.PuzzleLevel;
import view.LevelLoaderView;

public class SetMaxMovesController extends MouseAdapter implements ActionListener{


	PuzzleLevel level;
	LevelBuilder builder;
	LevelLoaderView editorView;
	int maxMoves;
	
	public SetMaxMovesController(LevelBuilder builder,Level level, LevelLoaderView editorView, int maxMoves){
		this.level = (PuzzleLevel) level;
		this.builder = builder;
		this.editorView = editorView;
		this.maxMoves = maxMoves;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.print("Gets here!");
		level.setMaxMoves(maxMoves);
		
		
	}

}
