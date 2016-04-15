package view;

import java.awt.Color;
import java.awt.Graphics;

public class SquareDrawer {
	
	int x, y, width;
	Integer releaseNumber;
	Color c;
	
	public SquareDrawer(){
		releaseNumber = null;
		c = null;
	}
	
	// TODO: Shitty code is shitty, do we want to pass this in to the constructor instead of the paint method or something?
	public void paint(Graphics g, int x, int y, int width, Integer releaseNumber, Color c){
		
		if(!(c == null)){
			g.setColor(c);
		}
		
		if(!(releaseNumber == null)){
			g.drawString("" + releaseNumber, x + 5, y + 5); //TODO: Change 5 to some buffer value
		}
		
		g.drawRect(x, y, width, width);
	}
}
