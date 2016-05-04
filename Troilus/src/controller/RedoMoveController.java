package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;
import view.LevelEditorView;

/**
 * Class to handle the redirection for undoing moves during level building.
 * 
 * @author Alex Kasparek
 *
 */
public class RedoMoveController implements ActionListener{
	/** The top-level level builder entity */
	LevelBuilder builder;
	
	/** The view for the level editor in the builder entity */
	LevelEditorView editorView;
	
	/**
	 * Creates a new instance of UndoMoveController with the following parameters.
	 * @param builder Reference to the top-level builder entity.
	 * @param editorView Reference to the view for a level in the builder entity.
	 */
	public RedoMoveController(LevelBuilder builder, LevelEditorView editorView) {
		this.builder = builder;
		this.editorView = editorView;
	}

	/** Handles action of the "Redo" button being pressed. Pops move off of the redo stack if there is one,
	 * and redoes the most recently undone move. <p>
	 * 
	 * @param e The ActionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if no redos are available- if so, return
		if (!builder.canRedo()) {
			return;
		}
		
		// can't redo if dragging a piece
		if (editorView.getBoardView().getDraggedPiece() != null) {
			System.out.println("Can't redo while dragging a piece");
			return;
		}
		
		// Otherwise, retrieve the last move from the stack, undo it, and update the boundary
		Move m = builder.popRedoMove();
		m.doMove();
		builder.pushMove(m, true);
		editorView.refresh();
	}
}