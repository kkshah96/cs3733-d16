package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.ReleaseSquare;
import view.LevelEditorView;

/**
 * Controls setting a Release Square's Number Color.
 * @author Alexander Kasparek
 * @author Maddy Longo
 */
public class SetSquareNumberColorController implements ActionListener {
	Level level;
	LevelEditorView editorView;

	public SetSquareNumberColorController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
		if (square == null) {
			return;
		}
		
		String color = (String) editorView.getNumberColorComboBox().getSelectedItem();

		if (color.equals("Red")) {
			square.setNumberColor(Color.RED);
		} else if (color.equals("Yellow")) {
			square.setNumberColor(Color.YELLOW);
		} else if (color.equals("Green")) {
			square.setNumberColor(Color.GREEN);
		} else {
			System.out.printf("Error: Invalid color of %s\n", color);
			return;
		}
		
		editorView.getBoardView().repaint();
	}
}