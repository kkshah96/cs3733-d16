package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Level;
import model.PuzzleLevel;
import view.LevelEditorView;

/**
 * Controls setting the Max Moves in a Puzzle Level.
 * 
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetMaxMovesController implements ActionListener {
	PuzzleLevel level;
	LevelEditorView editorView;
	
	public SetMaxMovesController(Level level, LevelEditorView editorView) {
		this.level = (PuzzleLevel) level;
		this.editorView = editorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		int maxMoves = Integer.parseInt(editorView.getMaxMovesField().getText());
		
		if (maxMoves <= 0 || maxMoves > 1024) {
			System.out.printf("Error: %d is an invalid number of moves\n", maxMoves);
		} else {
			level.setMaxMoves(maxMoves);
		}
	}
}