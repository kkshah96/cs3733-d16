package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SquareView extends JPanel {
	
	int x, y, width, height;
	Color color;
	int number;
	
	public SquareView(int width){
		x = this.getX();
		y = this.getY();
		this.width = width;
		this.height = width; // It's a square :D
		color = Color.BLACK;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		//g.setColor(c);
		g2.drawRect(x, y, width, height);
	}
}
