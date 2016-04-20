package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Level;
import model.LevelBuilder;
import model.PuzzleLevel;
import view.LevelLoaderView;

/**
 * 
 * 
 * @author Alexander Kasparek
 */

public class SetMaxMovesController implements ActionListener{
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
		if(maxMoves <= 0){
			System.out.println("Error: Invalid number of moves.");
		} else {
			System.out.println("Changed the max moves!");
			level.setMaxMoves(maxMoves);
		}
	}
}