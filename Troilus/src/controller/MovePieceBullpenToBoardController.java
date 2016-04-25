package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.Set;

import model.Board;
import model.Bullpen;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import model.Square;
import view.BoardView;
import view.BullpenView;
import view.LevelEditorView;
import view.LevelLoaderView;
import view.PaletteView;


/**
 * @author Dan Alfred
 * @author Connor Weeks
 *
 */
public class MovePieceBullpenToBoardController extends MouseAdapter {

	LevelBuilder builder;
	Level level;
	LevelLoaderView loaderView;
	LevelEditorView editorView;

	Piece activePiece;
	Point activePieceLocation;

	public MovePieceBullpenToBoardController(LevelBuilder builder, Level level, LevelLoaderView loaderView, LevelEditorView editorView) {
		this.builder = builder;
		this.level = level;
		this.loaderView = loaderView;
		this.editorView = editorView;
	}

	public void mouseEntered(MouseEvent e){
		//if(e.getSource().equals(editorView.getBoardView())){
		activePiece = level.getActivePiece();
		Board b = level.getBoard();
		BoardView bView = editorView.getBoardView();
		
		if(activePiece != null){
			System.out.println("Hi");
			b.addPiece(activePiece, e.getY(), e.getX());
			bView.repaint();
		}
		//}
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right click");
			return;
		}

		activePiece = level.getActivePiece();
		
		//TODO: Do we need a mousePressed method here? Heineman does it in Tangram and has some logic for if the activePiece is null :o 
		if(activePiece == null){
			
		}

		//Bullpen bp = level.getBullpen();
		//BullpenView bpView = editorView.getBullpenView();

		//Board b = level.getBoard();
		//BoardView boardView = editorView.getBoardView();

		//Point p = e.getPoint();
		//	BullpenView bullpenView = editorView.getBullpenView();
		//Hashtable<Piece, Point> pieces = bullpenView.getDrawnPieces();
		//Set<Piece> keySet = pieces.keySet();
		//System.out.println(p);
		//for(Piece piece : keySet) {
		//Point anchorPoint = pieces.get(piece);
		//			System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET);
		//			System.out.println(anchorPoint.getX() + PaletteView.WIDTH_OFFSET + PaletteView.SQUARE_SIZE);
		//			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET);
		//			System.out.println(anchorPoint.getY() + PaletteView.HEIGHT_OFFSET + PaletteView.SQUARE_SIZE);
		//			System.out.println("---");
		//

		// added by Connor <-- stud muffin
		/*	if((anchorPoint.getX() <= p.getX()) && 
					(anchorPoint.getX() + BullpenView.SQUARE_SIZE >= p.getX()) && 
					(anchorPoint.getY() <= p.getY()) && 
					(anchorPoint.getY() + BullpenView.SQUARE_SIZE >= p.getY())) {

				System.out.println("Anchor");
				//b.addPiece(piece);
				//boardView.repaint();
				level.setActivePiece(piece);
				return;
			}

			for(Square s : piece.getSquares()) {
				if((anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) <= p.getX()) && 
						(anchorPoint.getX() + (s.getCol() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= p.getX()) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) <= p.getY()) && 
						(anchorPoint.getY() + (s.getRow() * BullpenView.SQUARE_SIZE) + BullpenView.SQUARE_SIZE >= p.getY())) {
					//b.addPiece(piece, );
					System.out.println("Square");
				 	//boardView.repaint();
					level.setActivePiece(piece);
					return;
				}
			}*/
	}

}

