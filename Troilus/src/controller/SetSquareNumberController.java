package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.ReleaseSquare;
import view.LevelEditorView;

/**
 * Controller to set a Release Square's Number.
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetSquareNumberController implements ActionListener{
	/** The level entity being edited */
	Level level;
	
	/** The view for the level being edited */
	LevelEditorView editorView;

	/**
	 * Creates a new SetSquareNumberController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param editorView Reference to the view of the level being edited
	 */
	public SetSquareNumberController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if there is an active square (Return if not, nothing we can do)
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
		if (square == null) {
			return;
		}

		// Get the value from the drop-down
		String num = (String) editorView.getNumberComboBox().getSelectedItem();
		System.out.println(num);
		
		// Ensure a valid number was chosen
		if (!(num.equals("None"))) {
			int n = Integer.parseInt(num);
			square.setNumber(n);
		} else {
			// Assign the number to the square
			square.setNumber(0);
		}

		// Repaint to reflect changes
		editorView.getBoardView().repaint();
		System.out.println("New Number: " + square.getNumber());
	}
}