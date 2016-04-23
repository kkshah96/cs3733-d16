package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

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
 *
 */
public class PaletteView extends JPanel {
	//static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	public static final int SQUARE_SIZE = 10;
	public static final int HEIGHT_OFFSET = 100;
	public static final int WIDTH_OFFSET = 10;
	public static final int SPACING = 6;
	Hashtable<Piece, Point> pieces;

	Palette palette;
	/**
	 * Create the panel.
	 */
	public PaletteView(Palette palette) {
		this.palette = palette;
		pieces = new Hashtable<Piece, Point>();
		initialize();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

		PieceDrawer pDrawer = new PieceDrawer();

		
		for(int i = 0; i < Palette.NUM_PIECES; i++){
			pieces.put(palette.getPieces().get(i), new Point(i * SPACING, 0));
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
