package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Level;
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
	/** Constant to define square size in pixels */
	public static final int SQUARE_SIZE = 10;
	
	/** Constant to define the pixel gap between the top of the panel and piece drawing */
	public static final int HEIGHT_OFFSET = 100;
	
	/** Constant to define the pixel gap between the left of the panel and piece drawing */
	public static final int WIDTH_OFFSET = 10;
	
	/** Constant to define the spacing between pieces in pixels*/
	public static final int SPACING = 6;
	
	/*
	 * The PaletteView has a Hashtable of Pieces mapped to Points representing the locations where the Palette Pieces are
	 * drawn. NOTE: This is NOT keeping track of variable state because the PaletteView always draws the same number of pieces at the same locations
	 * We are simply storing these Pieces in locations in a HashTable as we draw them so we can access them later
	 */
	/** Table of pieces in this palette and their corresponding anchor coordinates */
	Hashtable<Piece, Point> pieces;

	/** The level this PaletteView is contained in */
	Level level;
	
	/** The palette this view draws */
	Palette palette;
	
	
	/**
	 * Creates a new instance of PaletteView with the provided level
	 * @param level Reference to the level to be utilized
	 */
	public PaletteView(Level level) {
		pieces = new Hashtable<Piece, Point>();
		this.level = level;
		palette = level.getPalette();
		initialize();
	}

	
	public void paintComponent(Graphics g){

		// THIS WAS SUPER IMPORTANT. pls
		super.paintComponent(g);

		PieceDrawer pDrawer = new PieceDrawer();

		// Draw each piece in the palette
		Palette palette = level.getPalette();
		for(int i = 0; i < Palette.NUM_PIECES; i++){
			pieces.put(palette.getPieces().get(i), new Point(i * SPACING * SQUARE_SIZE + WIDTH_OFFSET, HEIGHT_OFFSET));
			pDrawer.paint(g, palette.getPieces().get(i), new Point(i * SPACING, 0), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);			
		}
	}
	
	/**
	 * Provides the table of pieces in this PaletteView and their points
	 * @return Hashtable of Piece,Point in this view
	 */
	public Hashtable<Piece,Point> getDrawnPieces() {
		return pieces;
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
