package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Board;
import model.Level;
import view.LevelEditorView;

/**
 * Controls the resizing of the board in Level Editor.
 * 
 * When the Designer enters new desired dimensions, the 
 * board recreates itself to the specified dimensions
 * (if valid).
 *
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetBoardDimensionsController implements ActionListener {
	/** The level entity */
	Level level;
	
	/** The view for the editor of the level above */
	LevelEditorView editorView;

	/**
	 * Creates a new instance of the SetBoardDimensionsController with the following parameters
	 * @param level Reference to the level entity used 
	 * @param editorView Reference to the view for the level editor
	 */
	public SetBoardDimensionsController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	
	/** 
	 * Handles the "Set" button for the board dimensions being pressed. <p>
	 * @param e The ActionEvent to be handled.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get references to the text fields for col/rows, and get their values
		JTextField r = editorView.getRowField();
		JTextField c = editorView.getColField();

		int rows = Integer.parseInt(r.getText());
		int cols = Integer.parseInt(c.getText());

		// Ensure the values entered are within the bounds of the board
		if (cols < 0 || cols > Board.BOARD_WIDTH || rows > Board.BOARD_HEIGHT || rows < 0) {
			System.out.printf("Error: Invalid Board Dimensions of (%d, %d)\n", cols, rows);
			return;
		}
		
		level.clearBoardToBullpen(); // Moves pieces to bullpen

		// Update the board size and repaint
		level.getBoard().setDimensions(cols, rows);
		editorView.repaint();
	}
}