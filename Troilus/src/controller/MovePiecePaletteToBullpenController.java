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
		if(e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right click");
			return;
		}
		Point p = e.getPoint();
		PaletteView pView = editorView.getPaletteView();
		Hashtable<Piece, Point> pieces = pView.getDrawnPieces();
		Set<Piece> keySet = pieces.keySet();
		System.out.println(p);
		for(Piece piece : keySet) {
			Point anchorPoint = pieces.get(piece);
			//System.out.println(piece.getType());
			if((anchorPoint.getX() + PaletteView.WIDTH_OFFSET <= p.getX()) && 
					(anchorPoint.getX() + PaletteView.WIDTH_OFFSET + PaletteView.SQUARE_SIZE >= p.getX()) && 
					(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET <= p.getY()) && 
					(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET + PaletteView.SQUARE_SIZE >= p.getY())) {
				System.out.println("Within anchor point " + piece.getType() +"!");
			}
			/*System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET);
			System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET + PaletteView.SQUARE_SIZE);
			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET);
			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET + PaletteView.SQUARE_SIZE);
			System.out.println("---");*/

		}
		
	}
	
}
