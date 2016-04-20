package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.Square;
import view.LevelLoaderView;


/**
 * 
 * 
 * @author Alexander Kasparek
 */
public class ToggleSquareController implements ActionListener{
	
	

	Level level;
	LevelBuilder builder;
	LevelLoaderView editorView;

	
	public ToggleSquareController(LevelBuilder builder,Level level, LevelLoaderView editorView){
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			Square toggle = level.getBoard().getActiveSquare();
				 if(toggle.isValid() == false)//OutOfBoundsSquare, toggle on
					level.getBoard().toggleSquareOn(toggle.getRow(), toggle.getCol());
				 if(toggle.isValid() == true){
					level.getBoard().toggleSquareOff(toggle.getRow(), toggle.getCol());
					
				}
	}
		
		
}
	


