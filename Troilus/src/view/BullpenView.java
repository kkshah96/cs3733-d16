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
	/**
	 * Default ID to get rid of warnings.
	 */
	private static final long serialVersionUID = 1L;

	/** Constant to define the width of the bullpen in pixels. */
	public static final int BULLPEN_WIDTH = 420;
	
	/** Constant to define the length of each square in pixels for drawing. */
	public static final int SQUARE_SIZE = 10;

	/** Constant to define the offset between the left of the panel and the left of the bullpen. */
	public static final int WIDTH_OFFSET = 8 * SQUARE_SIZE;

	/** Constant to define the offset between the top of the panel and the top of the bullpen. */
	public static final int HEIGHT_OFFSET = 100;

	/** Constant to define how many pieces will be stored per row in the bullpen. */
	public static final int NUM_COLUMNS = 4;

	/** Constant to define the spacing in pixels between pieces in the bullpen rows. */
	public static final int SPACING = 8;

	/** Storage for pieces in the bullpen. */
	Hashtable<Piece, Point> pieces;

	/** The scrollpane this bullpenview belongs inside. */
	JScrollPane scrollPane;
	
	/** The bullpen entity this view draws. */
	Bullpen bullpen;
	
	/** The level entity this bullpen is from. */
	Level level;

	/**
	 * Creates a new instance of BullpenView from the following parameters
	 * @param level Reference to the level object where the containing bullpen is represented through this
	 * @param scrollPane Reference to the scrollpane to place the bullpen inside of
	 */
	public BullpenView(Level level, JScrollPane scrollPane) {
		this.level = level;
		this.bullpen = level.getBullpen();
		this.pieces = new Hashtable<Piece, Point>();
		this.scrollPane = scrollPane;
		initialize();
	}

	/**
	 * Initializes the bullpenview by setting the size and layout
	 */
	private void initialize(){
		setLayout(null);
		this.setPreferredSize(new Dimension(BULLPEN_WIDTH, 1000)); // 473
	}

	/**
	 * Provides the collection of pieces and corresponding points in the bullpen
	 * @return Hashtable of Pieces in the bullpen
	 */
	public Hashtable<Piece,Point> getDrawnPieces() {
		return pieces;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		PieceDrawer pDrawer = new PieceDrawer();

		// reset pieces 
		pieces = new Hashtable<Piece, Point>();

		// Loop through each piece in the bullpen and redraw
		for(int i = 0; i < bullpen.getPieces().size(); i++){
			Piece piece = bullpen.getPieces().get(i);
			Color color = piece.getColor();

			// if the piece is selected, highlight it
			if (piece == level.getActivePiece()) {
				color = Color.ORANGE;
			}

			if (piece != null) {
				pieces.put(piece, new Point((i % NUM_COLUMNS) * SPACING * SQUARE_SIZE + WIDTH_OFFSET,
						(i / NUM_COLUMNS) * SPACING * SQUARE_SIZE + HEIGHT_OFFSET));
				pDrawer.paint(g, color, piece, new Point((i  % NUM_COLUMNS) * SPACING, (i / NUM_COLUMNS) * SPACING),
						SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
			}
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