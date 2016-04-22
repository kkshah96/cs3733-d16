package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Bullpen;
import model.PieceFactory;



/**
 * Displays the bullpen based on model data.
 * @author Connor Weeks
 * @author Kunal Shah
 *
 */
public class BullpenView extends JPanel {
	static final int BULLPEN_WIDTH = 440;
	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 10;
	static final int BUFFER_SIZE = 1;

	//Bullpen bullpen = new Bullpen();
	//ArrayList<SquareView> squares = new ArrayList<SquareView>();

	/**
	 * Create the panel.
	 */
	public BullpenView() {
		initialize();
	}

	private void initialize(){

		setLayout(null);

		this.setPreferredSize(new Dimension(423, 473));

		JLabel lblNewLabel = new JLabel("There should be a scrollbar here..");
		lblNewLabel.setBounds(10, 11, 436, 14);
		add(lblNewLabel);

		JLabel lblBoard = new JLabel("Bullpen");
		lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setBounds(201, 5, 100, 23);

		int count = 0;
		/*for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
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

	//TODO: Implement this using hashtable
	public void paintComponent(Graphics g){

		super.paintComponent(g);
		
		// add test pieces
		//bullpen.addPiece(PieceFactory.getPiece(0, 0, 1));
		//bullpen.addPiece(PieceFactory.getPiece(0, 6, 2));
		//bullpen.addPiece(PieceFactory.getPiece(0, 12, 3));
		//bullpen.addPiece(PieceFactory.getPiece(6, 0, 4));
		//bullpen.addPiece(PieceFactory.getPiece(6, 6, 5));
		
		
		PieceDrawer pDrawer = new PieceDrawer();
		//int numPieces = bullpen.getNumPieces();
		//for(int i = 0; i < numPieces; i++){
			//pDrawer.paint(g, piece, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
			//pDrawer.paint(g, bullpen.getPiece(i), SQUARE_SIZE, 120, 6 * SQUARE_SIZE);
		//}
	}
}



