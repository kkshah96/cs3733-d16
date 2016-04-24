package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Bullpen;
import model.Piece;
import model.PieceFactory;



/**
 * Displays the bullpen based on model data.
 * @author Connor Weeks
 * @author Kunal Shah
 *
 */
public class BullpenView extends JPanel {
	static final int BULLPEN_WIDTH = 420;
	static final int SQUARE_SIZE = 10;
	
	/** Constant to define the offset between the left of the panel and the left of the bullpen */
	static final int WIDTH_OFFSET = 8 * SQUARE_SIZE;
	
	/** Constant to define the offset between the top of the panel and the top of the bullpen*/
	static final int HEIGHT_OFFSET = 100;
	
	static final int NUM_COLUMNS = 4;
	JScrollPane scrollPane;
	static final int SPACING = 8;
	Bullpen bullpen;

	/**
	 * Create the panel.
	 */
	public BullpenView(Bullpen bullpen, JScrollPane scrollPane) {
		this.bullpen = bullpen;
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

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
		//TESTING TODO: Remove
		//Hashtable<Piece, Point> pieces = bullpen.getPieces();
		ArrayList<Piece> pieces = bullpen.getPieces();
		PieceDrawer pDrawer = new PieceDrawer(); //TODO: Should we make PieceDrawer a static class?
		
		//TEST adding pieces TODO: remove
		//pieces.add(PieceFactory.getPiece(10));
		for(int i = 0; i < pieces.size(); i++){
			pDrawer.paint(g, pieces.get(i), new Point((i  % NUM_COLUMNS) * SPACING, (i / NUM_COLUMNS) * SPACING), SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
		}
		
		scrollPane.repaint();
		
	}
}



