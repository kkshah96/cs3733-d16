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
public class SetSquareNumberColorController implements ActionListener {
	Level level;
	LevelBuilder builder;
	LevelEditorView editorView;
	String color;
	
	public SetSquareNumberColorController(LevelBuilder builder, Level level, LevelEditorView editorView) {
		this.builder = builder;
		this.level = level;
		this.editorView = editorView;
		//this.color = color;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		color = (String)editorView.getNumberColorComboBox().getSelectedItem(); 
		ReleaseSquare square = (ReleaseSquare) level.getBoard().getActiveSquare();
		
		if(!(color.equals("None")) && square != null){
			
			if(color.equals("Red")){
				square.setNumberColor(Color.RED);
			}
			else if(color.equals("Yellow")){
				square.setNumberColor(Color.YELLOW);
			}
			else if(color.equals("Green")){
				square.setNumberColor(Color.GREEN);
			}
			System.out.println("New Color:" + color);
			
		}
		else {
			square.setNumberColor(null);
		}
		editorView.getBoardView().repaint();
	}
}