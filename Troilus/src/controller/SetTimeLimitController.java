package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.Level;
import model.LevelBuilder;
import model.LightningLevel;
import view.LevelEditorView;

/**
 * Class to handle update of time for Lightning Levels.
 *
 * @author Alexander Kasparek
 * @author Connor Weeks
 */
public class SetTimeLimitController implements ActionListener {
	/** The lightning level being edited */
	LightningLevel level;

	/** The view for the level being edited */
	LevelEditorView editorView;

	/** The LevelBuilder **/
	LevelBuilder builder;

	/**
	 * Creates a new instance of SetTimeLimitController with the following parameters
	 * @param level Reference to the level being edited
	 * @param editorView Reference to the view of the level being edited
	 * @param builder The LevelBuilder 
	 */
	public SetTimeLimitController(Level level, LevelEditorView editorView, LevelBuilder builder){
		this.level = (LightningLevel) level;
		this.editorView = editorView;
		this.builder = builder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Move m = new SetTimeLimitMove(level, editorView);
		m.doMove();
		if(m.isValid()){
			builder.pushMove(m);
		}
	}
}