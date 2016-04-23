package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import view.LevelEditorView;

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
	Level level;
	//LevelBuilder builder;
	//LevelEditorView editorView; // changed this from LevelLoaderView

	public ToggleSquareController(Level level) {
		this.level = level;
		//this.builder = builder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.getBoard().toggleActiveSquare();
	}
}