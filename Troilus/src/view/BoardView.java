package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Piece;
import model.PieceFactory;

public class BoardView extends JPanel {
	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 30;
	static final int WIDTH_OFFSET = 10;
	static final int HEIGHT_OFFSET = 30;
	ArrayList<SquareView> squares = new ArrayList<SquareView>();
	
	/**
	 * Create the panel.
	 */
	public BoardView() {
		initialize();
		
	}
	
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
	
	public void paintComponent(Graphics g){
		SquareDrawer drawer = new SquareDrawer();
		PieceDrawer pDrawer = new PieceDrawer();

		//int count = 0;
		for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
			for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
				drawer.paint(g, i + WIDTH_OFFSET, j + HEIGHT_OFFSET, SQUARE_SIZE, null, Color.BLACK);
			}
		}
		
		Piece piece = PieceFactory.getPiece(4, 4, 1);
		Piece piece2 = PieceFactory.getPiece(6, 6, 2);
		piece2 = piece2.rotatePiece(-1);
		
		pDrawer.paint(g, piece, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		pDrawer.paint(g, piece2, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
	}
}
