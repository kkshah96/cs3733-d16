package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView extends JPanel {

	static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
	static final int SQUARE_SIZE = 35;
	
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
		lblBoard.setBounds(6, 6, 90, 28);
		this.add(lblBoard);
	}
	
	public void paintComponent(Graphics g){
	   
	    super.paintComponent(g);

	    
	    for(int i = 10; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
	    	for(int j = 40; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
	    		g.drawRect(i, j, SQUARE_SIZE, SQUARE_SIZE);
	    	}
	    }
	}
}
