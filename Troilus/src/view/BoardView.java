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
import model.Piece;
import model.PieceFactory;

/**
 * Represents a way for a Board to be visible in a window.
 * 
 * This class handles the drawing of contents of the board panel, i.e:
 * the AWT board, and any pieces on the board
 * @author Dan Alfred
 * @author Kunal Shah
 *
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
	Board board;

	/**
	 * Constructor for the BoardView, for a given Board
	 * @param board The Board this BoardView is based on
	 */
	public BoardView(Board board) {
		this.board = board;
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
		SquareDrawer sDrawer = new SquareDrawer();
		PieceDrawer pDrawer = new PieceDrawer();

		Hashtable<Piece, Point> pieces = board.getPieces();

		//TEST adding pieces TODO: remove
		//	pieces.put(PieceFactory.getPiece(4), new Point(5, 5));
		Set<Piece> keySet = pieces.keySet();
		for(Piece p : keySet){
			pDrawer.paint(g, p, pieces.get(p), 30, HEIGHT_OFFSET, WIDTH_OFFSET);
		}

		int row;
		int col;
		// int count = 0;
		for(int i = 0; i < 12; i+= SQUARE_SIZE) {
			for(int j = 0; j < 12; j+= SQUARE_SIZE) {
				//row = i/SQUARE_SIZE;
				//col = j/SQUARE_SIZE;
				//sDrawer.paint(g, i + WIDTH_OFFSET, j + HEIGHT_OFFSET, SQUARE_SIZE, board.getSquare(row, col));
				sDrawer.paint(g, board, SQUARE_SIZE, null, null);
			}
		}		
	}
}