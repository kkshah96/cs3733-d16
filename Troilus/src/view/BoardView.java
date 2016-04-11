package view;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardView extends JPanel {

	/**
	 * Create the panel.
	 */
	public BoardView() {
		
		JLabel lblBoard = new JLabel("Board");
		add(lblBoard);

	}
	
	public void paintComponent(Graphics g){
		int width = getWidth();
	    int height = getHeight();
	   
	    super.paintComponent(g);

	    int start = 0;
	    
	    for(int i = 0; i < 10; i++){
	    	
	        start = i*(width/10);
	        g.drawLine(start, 0, start, height);
	    }
	}

}
