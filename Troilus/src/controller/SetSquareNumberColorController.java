package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import model.ReleaseSquare;
import view.LevelEditorView;

/**
 * Controls setting a Release Square's Number Color.
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetSquareNumberColorController implements ActionListener {
	/** The level entity being edited */
	Level level;
	
	/** The view for the level being edited */
	LevelEditorView editorView;

	LevelBuilder builder;
	/**
	 * Creates a new instance of SetSquareNumberColorController with the following parameters
	 * @param level Reference to the level entity being edited
	 * @param editorView Reference to the view for the level being edited
	 */
	public SetSquareNumberColorController(Level level, LevelEditorView editorView, LevelBuilder builder) {
		this.level = level;
		this.editorView = editorView;
		this.builder = builder;
	}

	
	/**
	 * Handles event when an option in the JComboBox is selected for the SquareNumber.
	 * @param ae The ActionEvent. 
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Obtain the active square (if there is one- if not, return)
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
		if (square == null) {
			return;
		}
		
		// Obtain the color from the drop-down
		String color = (String) editorView.getNumberColorComboBox().getSelectedItem();

		// Process based on value selected
		if (color.equals("Red")) {
			Move m = new SetSquareNumberColorMove((ReleaseSquare)level.getBoard().getActiveSquare(), 
					level, Color.RED);
			m.doMove();
			builder.pushMove(m);
		} else if (color.equals("Yellow")) {
			Move m = new SetSquareNumberColorMove((ReleaseSquare)level.getBoard().getActiveSquare(), 
					level, Color.YELLOW);
			m.doMove();
			builder.pushMove(m);
		} else if (color.equals("Green")) {
			Move m = new SetSquareNumberColorMove((ReleaseSquare)level.getBoard().getActiveSquare(), 
					level, Color.GREEN);
			m.doMove();
			builder.pushMove(m);
		} else {
			System.out.printf("Error: Invalid color of %s\n", color);
			return;
		}
		
		// Update the view to reflect changes
		editorView.getBoardView().repaint();
	}
}