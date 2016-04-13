package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView extends JPanel {

	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 30;
	static final int BUFFER_SIZE = 1;
	ArrayList<TileView> tiles = new ArrayList<TileView>();
	
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
		
		int count = 0;
		for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
			for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
				tiles.add(new TileView(SQUARE_SIZE));
				tiles.get(count).setBounds(i + 10, j + 30, SQUARE_SIZE + BUFFER_SIZE, SQUARE_SIZE + BUFFER_SIZE);
				add(tiles.get(count));
				count++;
			}
		}
		
		setLayout(null);
		add(lblBoard);
		
	}
}
