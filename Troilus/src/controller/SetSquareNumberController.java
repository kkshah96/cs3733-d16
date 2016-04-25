package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import model.LevelBuilder;
import model.ReleaseSquare;
import view.LevelEditorView;

/**
 * 
 * @author Alexander Kasparek
 *
 */
public class SetSquareNumberController implements ActionListener{
	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	String num;
	
	public SetSquareNumberController(LevelBuilder builder, Level level, LevelEditorView editorView){
		this.builder = builder;
		this.level = level;
		this.editorView = editorView;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		num = (String) editorView.getNumberComboBox().getSelectedItem();
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
	if(!(num.equals("None")) && square != null){
		System.out.println("New Number:" + num);
		int n = Integer.parseInt(num);
		square.setNumber(n);
		}
	else {
		square.setNumber(-1);
	}
	editorView.getBoardView().repaint();
	
	}
}