package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class TileView extends JComponent{
	
	int x, y, width, height;
	Color c;
	int number;
	
	public TileView(int width){
		x = this.getX();
		y = this.getY();
		this.width = width;
		this.height = width; // It's a square :D
		c = Color.BLACK;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
	
		g.setColor(c);
		g2.drawRect(x, y, width, height);
	}
}
