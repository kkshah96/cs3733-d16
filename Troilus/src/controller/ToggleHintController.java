package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import view.BoardView;

/**
 * Toggles the selected Square on the board to be or not be a hint square, depending on its current state.
 * <p>
 * level = the current level being edited. <br>
 * <p>
 * @author Alexander Kasparek
 * @author Dan Alfred
 */
public class ToggleHintController implements ActionListener {
	/** The level to toggle hints on */
	Level level;
	
	/** The view for the board in this level */
	BoardView boardView;
	
	/**The LevelBuilder that contains the board**/
	LevelBuilder editor;

	/**
	 * Creates a new instance of ToggleHintController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param editor Reference to the LevelBuilder containing the level
	 * @param boardView Reference to the view of the board in this level
	 */
	public ToggleHintController(Level level, LevelBuilder editor, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
		this.editor = editor;
	}

	
	/**
	 * Handles the event where the "Hint" button is pressed to toggle the hint status of the active square.
	 * @param e the ActionEvent.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Toggles the hint on the board and updates the view
		Move m = new ToggleHintMove(level);
		if(m.doMove()) {
			editor.pushMove(m, false);	
		}
		
		boardView.repaint();
	}
}