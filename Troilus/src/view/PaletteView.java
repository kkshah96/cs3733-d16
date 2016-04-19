package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Palette;

public class PaletteView extends JPanel {
	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 10;
	static final int BUFFER_SIZE = 1;
	ArrayList<SquareView> squares = new ArrayList<SquareView>();

	Palette p = new Palette();

	/**
	 * Create the panel.
	 */
	public PaletteView() {
		setLayout(null);
		
		this.setPreferredSize(new Dimension(500, 500));

		JLabel lblNewLabel = new JLabel("There should be a scrollbar here..");
		lblNewLabel.setBounds(10, 11, 436, 14);
		add(lblNewLabel);

		JLabel lblIfYouCan = new JLabel("If you can see this it works!");
		lblIfYouCan.setBounds(944, 11, 210, 14);
		add(lblIfYouCan);



	}

	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		PieceDrawer pDrawer = new PieceDrawer();

		for(int i = 0; i < 35; i++){
			//pDrawer.paint(g, piece, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
			pDrawer.paint(g, p.getPiece(i), SQUARE_SIZE, 60, 10);
		}
	}

	private void initialize(){
		//JLabel lblBoard = new JLabel("Bullpen");
		//lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		//lblBoard.setForeground(Color.BLACK);
		//lblBoard.setBounds(201, 5, 100, 23);

		//int count = 0;
		/*for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
squares.add(new SquareView(SQUARE_SIZE));
squares.get(count).setBounds(i + 10, j + 30, SQUARE_SIZE + BUFFER_SIZE, SQUARE_SIZE + BUFFER_SIZE);
add(squares.get(count));
count++;
}
}*/

		//setLayout(null);
		//add(lblBoard);
	}
}