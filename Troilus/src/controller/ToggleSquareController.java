package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
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
 * @author Connor Weeks
 */
public class ToggleSquareController implements ActionListener {
	/** The level being edited */
	Level level;
	
	/** The view for the board in this level */
	BoardView boardView;
	
	/** The level builder instance containing the level*/
	LevelBuilder builder;
	

	/**
	 * Creates a new instance of ToggleSquareController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param builder Reference to the builder containing the above level
	 * @param boardView Reference to the view for the board in this level
	 */
	public ToggleSquareController(Level level, LevelBuilder builder, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
		this.builder = builder;
	}

	/**
	 * Handles the pressing of the button to toggle a board square on or off.
	 * @param e The ActionEvent.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Toggles the active square and updates the boundary
		Move m = new ToggleSquareMove(level.getBoard().getActiveSquare(),level);
		if(m.doMove()) {
			builder.pushMove(m);	
		}
		
		boardView.repaint();
	}
}