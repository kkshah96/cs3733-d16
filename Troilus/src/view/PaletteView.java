package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
>>>>>>> branch 'master' of https://github.com/kshah96/cs3733-d16.git

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Palette;
import model.Piece;

/**
 * GUI for a Palette in the LevelBuilder application
 * 
 * Displays every Piece in the Kabasuji game in a window using a scrollbar as needed
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class PaletteView extends JPanel {
	//static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
<<<<<<< HEAD
	static final int SQUARE_SIZE = 10;
	
	static final int HEIGHT_OFFSET = 100;
	static final int WIDTH_OFFSET = 20;
	//static final int BUFFER_SIZE = 1;
	//ArrayList<SquareView> squares = new ArrayList<SquareView>();
=======
	public static final int SQUARE_SIZE = 10;
	public static final int HEIGHT_OFFSET = 100;
	public static final int WIDTH_OFFSET = 10;
	public static final int SPACING = 6;
	
	/*
	 * The PaletteView has a Hashtable of Pieces mapped to Points representing the locations where the Palette Pieces are
	 * drawn. NOTE: This is NOT keeping track of variable state because the PaletteView always draws the same number of pieces at the same locations
	 * We are simply storing these Pieces in locations in a HashTable as we draw them so we can access them later
	 */
	Hashtable<Piece, Point> pieces;
>>>>>>> branch 'master' of https://github.com/kshah96/cs3733-d16.git

	Palette palette;
	/**
	 * Create the panel.
	 */
	public PaletteView(Palette palette) {
		pieces = new Hashtable<Piece, Point>();
		this.palette = palette;
		initialize();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

		PieceDrawer pDrawer = new PieceDrawer();

		
		for(int i = 0; i < Palette.NUM_PIECES; i++){
			pieces.put(palette.getPieces().get(i), new Point(i * SPACING * SQUARE_SIZE + WIDTH_OFFSET, HEIGHT_OFFSET));
			pDrawer.paint(g, palette.getPieces().get(i), new Point(i * SPACING, 0), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
	}
	
	public Hashtable<Piece,Point> getDrawnPieces() {
		return pieces;
	}

	private void initialize(){
		setLayout(null);

		this.setPreferredSize(new Dimension(500, 500));

		JLabel lblBoard = new JLabel("Palette");
		lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setBounds(201, 5, 100, 23);
		
		this.add(lblBoard);
	}
}
