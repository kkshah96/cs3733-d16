package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.LevelLoaderView;
import view.LevelEditorView;
import view.PaletteView;

public class MovePiecePaletteToBullpenController extends MouseAdapter {

	LevelBuilder builder;
	Level level;
	LevelLoaderView loaderView;
	LevelEditorView editorView;
	
	public MovePiecePaletteToBullpenController(LevelBuilder builder, Level level, LevelLoaderView loaderView, LevelEditorView editorView) {
		this.builder = builder;
		this.level = level;
		this.loaderView = loaderView;
		this.editorView = editorView;
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON2) {
			return;
		}
		Point p = e.getPoint();
		PaletteView pView = editorView.getPaletteView();
		Hashtable<Piece, Point> pieces = pView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			if((anchorPoint.getX() <= p.getX()) && (anchorPoint.getX() + PaletteView.SQUARE_SIZE >= p.getX()) && 
					(anchorPoint.getY() <= p.getY()) && (anchorPoint.getY() >= p.getY())) {
				
			}
			
			
		}
		
	}
	
}
