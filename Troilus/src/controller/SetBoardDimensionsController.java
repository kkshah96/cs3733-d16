package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Board;
import model.Bullpen;
import model.Level;
import model.Piece;
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
	Level level;
	LevelEditorView editorView;

	public SetBoardDimensionsController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField r = editorView.getRowField();
		JTextField c = editorView.getColField();

		int rows = Integer.parseInt(r.getText());
		int cols = Integer.parseInt(c.getText());

		if (cols < 0 || cols > Board.BOARD_WIDTH || rows > Board.BOARD_HEIGHT || rows < 0) {
			System.out.printf("Error: Invalid Board Dimensions of (%d, %d)\n", cols, rows);
			return;
		}
		
		Bullpen bullpen = level.getBullpen();
		// Remove all pieces from the board
		for (Piece p : level.getBoard().getPieces().keySet()) {
			bullpen.addPiece(level.getBoard().removePiece(p));
		}
		
		level.getBoard().setDimensions(cols, rows);
		editorView.repaint();
	}
}