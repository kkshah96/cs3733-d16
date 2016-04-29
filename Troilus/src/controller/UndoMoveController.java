package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilder;
import view.LevelEditorView;

public class UndoMoveController implements ActionListener{
	
	LevelBuilder builder;
	LevelEditorView lEV;
	
	public UndoMoveController(LevelBuilder builder, LevelEditorView lEV){
		this.builder = builder;
		this.lEV = lEV;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!builder.canUndo()) {
			System.out.println("Nothing to undo.");
			return;
		}
		Move m = builder.popUndoMove();
		m.undo();
		lEV.repaint();
		
	}
	
	

}
