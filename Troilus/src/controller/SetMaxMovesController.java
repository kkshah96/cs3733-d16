package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Level;
import model.LevelBuilder;
import model.PuzzleLevel;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * 
 * 
 * @author Alexander Kasparek
 * @author Connor Weeks
 */

public class SetMaxMovesController implements ActionListener{
	PuzzleLevel level;
	LevelEditorView editorView;
	
	public SetMaxMovesController(Level level, LevelEditorView editorView){
		this.level = (PuzzleLevel) level;
		this.editorView = editorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int maxMoves = Integer.parseInt(editorView.getMaxMovesField().getText());
		if(maxMoves <= 0){
			System.out.println("Error: Invalid number of moves.");
		} else {
			System.out.println("Changed the max moves!");
			level.setMaxMoves(maxMoves);
		}
	}
}