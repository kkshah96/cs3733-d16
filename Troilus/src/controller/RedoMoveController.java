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
	LevelEditorView lEV;
	
	/**
	 * Creates a new instance of UndoMoveController with the following parameters
	 * @param builder Reference to the top-level builder entity
	 * @param lEV Reference to the view for a level in the builder entity
	 */
	public RedoMoveController(LevelBuilder builder, LevelEditorView lEV){
		this.builder = builder;
		this.lEV = lEV;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Check if no redos are available- if so, return
		if (!builder.canRedo()) {
			System.out.println("Nothing to redo.");
			return;
		}
		// Otherwise, retrieve the last move from the stack, undo it, and update the boundary
		Move m = builder.popRedoMove();
		builder.pushMove(m);
		m.doMove();
		lEV.repaint();
		
	}
	
	

}
