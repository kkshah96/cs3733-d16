package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Hashtable;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Bullpen;
import model.Level;
import model.Piece;

/**
 * Displays the bullpen based on model data.
 * @author Connor Weeks
 * @author Kunal Shah
 *
 */
public class BullpenView extends JPanel {
	public static final int BULLPEN_WIDTH = 420;
	public static final int SQUARE_SIZE = 10;
	
	/** Constant to define the offset between the left of the panel and the left of the bullpen */
	public static final int WIDTH_OFFSET = 8 * SQUARE_SIZE;
	
	/** Constant to define the offset between the top of the panel and the top of the bullpen*/
	public static final int HEIGHT_OFFSET = 100;
	
	public static final int NUM_COLUMNS = 4;

	public static final int SPACING = 8;
	
	Hashtable<Piece, Point> pieces;
	
	JScrollPane scrollPane;
	Bullpen bullpen;
	Level level;

	/**
	 * Create the panel.
	 */
	public BullpenView(Level level, JScrollPane scrollPane) {
		this.level = level;
		this.bullpen = level.getBullpen();
		this.pieces = new Hashtable<Piece, Point>();
		this.scrollPane = scrollPane;
		initialize();
	}

	private void initialize(){
		setLayout(null);
		this.setPreferredSize(new Dimension(BULLPEN_WIDTH, 1000)); // 473
	}
	
	public Hashtable<Piece,Point> getDrawnPieces() {
		return pieces;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		PieceDrawer pDrawer = new PieceDrawer();
		
		// reset pieces 
		pieces = new Hashtable<Piece, Point>();
		
		for(int i = 0; i < bullpen.getPieces().size(); i++){
			Piece piece = bullpen.getPieces().get(i);
			Color color = Color.RED;
			
			// if the piece is selected, highlight it
			if (piece == level.getActivePiece()) {
				color = Color.ORANGE;
			}
			
			pieces.put(piece, new Point((i % NUM_COLUMNS) * SPACING * SQUARE_SIZE + WIDTH_OFFSET,
					(i / NUM_COLUMNS) * SPACING * SQUARE_SIZE + HEIGHT_OFFSET));
			pDrawer.paint(g, color, piece, new Point((i  % NUM_COLUMNS) * SPACING, (i / NUM_COLUMNS) * SPACING),
					SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
		
		/*if(draggedPiece != null) {
			//System.out.println("Painting dragged piece");
			//System.out.println("Point " + board.getDraggedPiecePoint());
			
			//TODO: There is definitely a better way to do this
			int x = (draggedPiecePoint.x - WIDTH_OFFSET) / SQUARE_SIZE;
			int y = (draggedPiecePoint.y - HEIGHT_OFFSET) / SQUARE_SIZE;
			pDrawer.paint(g, draggedPiece.getColor(), draggedPiece, new Point(x, y), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}*/
		
		scrollPane.repaint();
	}
	
	/*public void addDraggedPiece(Piece piece, Point piecePoint) {
		this.draggedPiece = piece;
		this.draggedPiecePoint = piecePoint;
	}
	
	public void removeDraggedPiece() {
		this.draggedPiece = null;
		this.draggedPiecePoint = null;
	}*/
}