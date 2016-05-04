package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;
import view.ILevelView;

/**
 * Class to handle the redirection for undoing moves during level building.
 * 
 * @author Alex Kasparek
 * @author Connor Weeks
 *
 */
public class UndoMoveController implements ActionListener{
	/** The top-level level builder entity */
	LevelBuilder builder;

	/** The view for the level editor in the builder entity */
	ILevelView editorView;

	/**
	 * Creates a new instance of UndoMoveController with the following parameters
	 * @param builder Reference to the top-level builder entity
	 * @param editorView Reference to the view for a level in the builder entity
	 */
	public UndoMoveController(LevelBuilder builder, ILevelView editorView) {
		this.builder = builder;
		this.editorView = editorView;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if no undos are available- if so, return
		if (!builder.canUndo()) {
			return;
		}
		
		if (editorView.getBoardView().getDraggedPiece() != null) {
			System.out.println("Can't undo while dragging a piece");
			return;
		}
		
		// Otherwise, retrieve the last move from the stack, undo it, and update the boundary
		// TODO is this correct?
		Move m = builder.popUndoMove();
		m.undo();
		builder.pushRedoMove(m);
		editorView.refresh();
	}
}