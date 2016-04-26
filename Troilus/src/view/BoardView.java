package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Hashtable;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.Level;
import model.Piece;

/**
 * Represents a way for a Board to be visible in a window.
 * 
 * This class handles the drawing of contents of the board panel, i.e:
 * the AWT board, and any pieces on the board.
 * @author Dan Alfred
 * @author Kunal Shah
 * @author Maddy Longo
 * @author Alexander Kasparek
 */
public class BoardView extends JPanel {
	/** Constant to define how large each square is, in pixels*/
	static final public int SQUARE_SIZE = 30;

	/** Constant to define board width in pixels */
	public static final int WIDTH = Board.BOARD_WIDTH*SQUARE_SIZE;

	/** Constant to define board height in pixels */
	public static final int HEIGHT = Board.BOARD_HEIGHT*SQUARE_SIZE;

	/** Constant to define the offset between the left of the panel and the left of the board */
	static final public int WIDTH_OFFSET = 10;

	/** Constant to define the offset between the top of the panel and the top of the board*/
	static final public int HEIGHT_OFFSET = 30;

	/** A reference to the Board entity */
	Level level;
	
	Board board;
	
	Piece draggedPiece;
	Point draggedPiecePoint;

	/**
	 * Constructor for the BoardView, for a given Board
	 * @param board The Board this BoardView is based on
	 */
	public BoardView(Level level) {
		this.level = level;
		board = level.getBoard();
		initialize();
	}

	/**
	 * Initializes the BoardView by initializing the label and drawing the grid
	 */
	private void initialize(){
		JLabel lblBoard = new JLabel("Board");
		lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setBounds(201, 5, 100, 23);

		setLayout(null);
		add(lblBoard);
	}

	/**
	 * Paints the BoardView and squares on the Board 
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		SquareDrawer sDrawer = new SquareDrawer(board);
		PieceDrawer pDrawer = new PieceDrawer();

		Hashtable<Piece, Point> pieces = board.getPieces();

		//TEST adding pieces TODO: remove
		//	pieces.put(PieceFactory.getPiece(4), new Point(5, 5));
		
		// i is y-coordinate, j is x-coordinate
		for (int i = 0; i < HEIGHT; i+= SQUARE_SIZE) {
			for (int j = 0; j < WIDTH; j+= SQUARE_SIZE) {
				sDrawer.paint(g, j + WIDTH_OFFSET, i + HEIGHT_OFFSET,
						board.getSquare(i/SQUARE_SIZE, j/SQUARE_SIZE));
			}
		}
		
		Set<Piece> keySet = pieces.keySet();
		//System.out.println(keySet.size() + " : Number of pieces stored in Board");
		for(Piece p : keySet) {
			pDrawer.paint(g, p.getColor(), p, pieces.get(p), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
		
		if(draggedPiece != null) {
			//System.out.println("Painting dragged piece");
			//System.out.println("Point " + board.getDraggedPiecePoint());
			
			//TODO: There is definitely a better way to do this
			int x = (draggedPiecePoint.x - WIDTH_OFFSET) / SQUARE_SIZE;
			int y = (draggedPiecePoint.y - HEIGHT_OFFSET) / SQUARE_SIZE;
			pDrawer.paint(g, draggedPiece.getColor(), draggedPiece, new Point(x, y), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
	}
	
	public void addDraggedPiece(Piece piece, Point piecePoint) {
		this.draggedPiece = piece;
		this.draggedPiecePoint = piecePoint;
	}
	
	public void removeDraggedPiece() {
		this.draggedPiece = null;
		this.draggedPiecePoint = null;
	}
}