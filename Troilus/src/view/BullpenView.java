package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Bullpen;
import model.Level;
import model.Piece;
import model.PieceFactory;



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

		/*JLabel lblBoard = new JLabel("Bullpen");
		lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setBounds(201, 5, 100, 23);
	
		setLayout(null);
		add(lblBoard);*/
	}
	
	public Hashtable<Piece,Point> getDrawnPieces() {
		return pieces;
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
		//TESTING TODO: Remove
		//Hashtable<Piece, Point> pieces = bullpen.getPieces();
		PieceDrawer pDrawer = new PieceDrawer(); //TODO: Should we make PieceDrawer a static class?
		
		// reset pieces 
		pieces = new Hashtable<Piece, Point>();
		
		for(int i = 0; i < bullpen.getPieces().size(); i++){
			//TODO: Ensure I did this correctly
			pieces.put(bullpen.getPieces().get(i), new Point((i % NUM_COLUMNS) * SPACING * SQUARE_SIZE + WIDTH_OFFSET, (i / NUM_COLUMNS) * SPACING * SQUARE_SIZE + HEIGHT_OFFSET));
			pieces.put(bullpen.getPieces().get(i), new Point((i % NUM_COLUMNS) * SPACING * SQUARE_SIZE + WIDTH_OFFSET, (i / NUM_COLUMNS) * SPACING * SQUARE_SIZE + HEIGHT_OFFSET));
			pDrawer.paint(g, bullpen.getPieces().get(i), new Point((i  % NUM_COLUMNS) * SPACING, (i / NUM_COLUMNS) * SPACING), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
		
		scrollPane.repaint();
		
	}
}



