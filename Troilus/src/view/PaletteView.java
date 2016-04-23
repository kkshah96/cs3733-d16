package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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

	static final int SQUARE_SIZE = 10;
	static final int HEIGHT_OFFSET = 100;
	static final int WIDTH_OFFSET = 10;
	static final int SPACING = 6;
	
	Palette palette;
	/**
	 * Create the panel.
	 */
	public PaletteView(Palette palette) {
		this.palette = palette;
		initialize();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);

		PieceDrawer pDrawer = new PieceDrawer();
		ArrayList<Piece> pieces = palette.getPieces();

		
		for(int i = 0; i < Palette.NUM_PIECES; i++){
			pDrawer.paint(g, pieces.get(i), new Point(i * SPACING, 0), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
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