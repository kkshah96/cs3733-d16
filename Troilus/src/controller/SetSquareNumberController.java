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
	Level level;
	LevelEditorView editorView;

	public SetSquareNumberController(Level level, LevelEditorView editorView) {
		this.level = level;
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if there is an active square
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
		if (square == null) {
			return;
		}

		String num = (String) editorView.getNumberComboBox().getSelectedItem();
		System.out.println(num);
		
		if (!(num.equals("None"))) {
			int n = Integer.parseInt(num);
			square.setNumber(n);
		} else {
			square.setNumber(0);
		}

		editorView.getBoardView().repaint();
		System.out.println("New Number: " + square.getNumber());
	}
}