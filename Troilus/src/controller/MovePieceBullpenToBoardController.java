package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Board;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.BoardView;
import view.LevelEditorView;
import view.LevelLoaderView;


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

	public MovePieceBullpenToBoardController(LevelBuilder builder,
			Level level, LevelLoaderView loaderView, LevelEditorView editorView) {
		this.builder = builder;
		this.level = level;
		this.loaderView = loaderView;
		this.editorView = editorView;
	}

/*	public void mouseEntered(MouseEvent e){
		activePiece = level.getActivePiece();
		Board b = level.getBoard();
		BoardView bView = editorView.getBoardView();

		//
		if(activePiece != null){
			//TODO: THis doesnt work because our current implmentation doesnt allow for drawing
			// outside of the actual grid
			b.addDraggedPiece(activePiece, e.getPoint());
			System.out.println("Dragged piece added!");
			bView.repaint();
		}
		//}
	}*/
	
	@Override
	public void mouseMoved(MouseEvent e) {
		activePiece = level.getActivePiece();
		Board b = level.getBoard();
		BoardView bView = editorView.getBoardView();

		//
		if(activePiece != null){
			//TODO: THis doesnt work because our current implmentation doesnt allow for drawing
			// outside of the actual grid
			b.addDraggedPiece(activePiece, e.getPoint());
			bView.repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right click");
			return;
		}

		activePiece = level.getActivePiece();
		
		//TODO: Do we need a mousePressed method here? Heineman does it in Tangram and has some logic for if the activePiece is null :o 
		if(activePiece == null){
			System.err.print("Somehow encountered null piece in drag");
			return;
		}
		
		Board b = level.getBoard();
		b.addPiece(activePiece, e.getX() / BoardView.SQUARE_SIZE,
				(e.getY() - BoardView.SQUARE_SIZE) / BoardView.SQUARE_SIZE);
				
		System.out.println("Added piece at (" + e.getX() / BoardView.SQUARE_SIZE + ", " + (e.getY() - BoardView.SQUARE_SIZE) / BoardView.SQUARE_SIZE
				+ ")");
		level.getBullpen().removePiece(activePiece); // TODO are we removing the piece, or just graying it out?
		level.removeActivePiece();
		level.getBoard().removeDraggedPiece(); // TODO: Get rid of dragged piece logic
		BoardView bView = editorView.getBoardView();
		bView.repaint();

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