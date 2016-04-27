package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import view.BoardView;

/**
 * Toggles the selected Square on the board to be or not be a hint square, depending on its current state.
 * <p>
 * level = the current level being edited. <br>
 * <p>
 * @author Alexander Kasparek
 */
public class ToggleHintController implements ActionListener {
	Level level;
	BoardView boardView;

	public ToggleHintController(Level level, BoardView boardView) {
		this.level = level;
		this.boardView = boardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Need to implement this.");
		level.getBoard().toggleHint();
		boardView.repaint();
	}
}