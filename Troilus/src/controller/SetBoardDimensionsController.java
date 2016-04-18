package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.LevelLoaderView;
import view.LevelView;

public class SetBoardDimensionsController extends MouseAdapter{
	Kabasuji game;

	Level level;
	LevelBuilder builder;
	LevelLoaderView editorView;
	int rows;
	int cols;
	
	public SetBoardDimensionsController(LevelBuilder builder,Level level, LevelLoaderView editorView, int rows, int cols){
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
		this.rows = rows;
		this.cols = cols;
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(cols <= 0 || cols > 12 || rows > 12 || rows <= 0){
			System.out.println("Invalid Dimensions");
		}
		else
			level.getBoard().setDimensions(rows, cols);
		
		
	}
}
