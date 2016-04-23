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
	/** Constant for how large the BoardView can be */
	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	
	/** Constant to define how large each square is, in pixels*/
	static final int SQUARE_SIZE = 30;
	
	/** Constant to define the offset between the left of the panel and the left of the board */
	static final int WIDTH_OFFSET = 10;
	
	/** Constant to define the offset between the top of the panel and the top of the board*/
	static final int HEIGHT_OFFSET = 30;
	//ArrayList<SquareView> squares = new ArrayList<SquareView>();
	
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
		
		/*int count = 0;
		for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
			for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
				squares.add(new SquareView(SQUARE_SIZE));
				squares.get(count).setBounds(i + 10, j + 30, SQUARE_SIZE + BUFFER_SIZE, SQUARE_SIZE + BUFFER_SIZE);
				add(squares.get(count));
				count++;
			}
		}*/
		
		
		
		
		setLayout(null);
		add(lblBoard);
	}
	
	/**
	 * Paints the BoardView and squares on the Board
	 */
	public void paintComponent(Graphics g){
		
		SquareDrawer drawer = new SquareDrawer();
		PieceDrawer pDrawer = new PieceDrawer();
		
		Hashtable<Piece, Point> pieces = board.getPieces();

		
		//TEST adding pieces TODO: remove
	//	pieces.put(PieceFactory.getPiece(4), new Point(5, 5));
		Set<Piece> keySet = pieces.keySet();
		for(Piece p : keySet){
			pDrawer.paint(g, p, pieces.get(p), 30, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
		
		//int count = 0;
		for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
			for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
				drawer.paint(g, i + WIDTH_OFFSET, j + HEIGHT_OFFSET, SQUARE_SIZE, null, Color.BLACK);
			}
		}
		
	//	for(int i = 0; i < board.getPieces().size(); i++){
		//	pDrawer.paint(g, board.getPieces().get(i), width, height_offset, width_offset);
		//}
		
		/*Piece piece2 = PieceFactory.getPiece(4, 7, 2);
		//pDrawer.paint(g, piece, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		pDrawer.paint(g, piece2, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece3 = PieceFactory.getPiece(4, 5, 2);
		piece3 = piece3.flipPiece(Piece.FLIP_HORIZONTALLY);
		pDrawer.paint(g, piece3, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece4 = PieceFactory.getPiece(8, 5, 2);
		piece4 = piece4.rotatePiece(Piece.ROTATE_CCW);
		pDrawer.paint(g, piece4, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece5 = PieceFactory.getPiece(10, 1, 2);
		piece5 = piece5.rotatePiece(Piece.ROTATE_CW);
		pDrawer.paint(g, piece5, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece6 = PieceFactory.getPiece(7, 7, 2);
		piece6 = piece6.flipPiece(Piece.FLIP_VERTICALLY);
		pDrawer.paint(g, piece6, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece7 = PieceFactory.getPiece(11, 11, 1);
		pDrawer.paint(g, piece7, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece8 = PieceFactory.getPiece(4, 10, 15);
		pDrawer.paint(g, piece8, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		
		Piece piece9 = PieceFactory.getPiece(4, 0, 14);
		pDrawer.paint(g, piece9, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);*/
		
	}
}
