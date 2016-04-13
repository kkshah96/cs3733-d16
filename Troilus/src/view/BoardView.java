package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BoardView extends JPanel {

	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 30;
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
		lblBoard.setBounds(201, 5, 48, 23);
		
		int count = 0;
		for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
			for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
				tiles.add(new TileView(SQUARE_SIZE));
				tiles.get(count).setBounds(i + 10, j + 30, 31, 31);
				add(tiles.get(count));
				count++;
			}
		}
		
		//JComponent tile = new TileView();
		//tile.setBounds(10, 40, 35, 35);
		setLayout(null);
		add(lblBoard);
		
		
		
		
		
	}
}
