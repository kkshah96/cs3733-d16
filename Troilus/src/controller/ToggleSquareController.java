package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import view.BoardView;

/**
 * Toggles the selected Square on the board on or off, depending on its current state.
 * <p>
 * builder = the current builder instance. <br>
 * <p>
 * level = the current level being edited. <br>
 * <p>
 * editorView = the level editor window. <br>
 * <p>
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class ToggleSquareController implements ActionListener {
	/** The level being edited */
	Level level;
	
	/** The view for the board in this level */
	BoardView boardView;

	/**
	 * Creates a new instance of ToggleSquareController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param boardView Reference to the view for the board in this level
	 */
	public ToggleSquareController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Toggles the active square and updates the boundary
		level.getBoard().toggleActiveSquare();
		boardView.repaint();
	}
}