package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JPanel;

import model.Piece;
import model.PieceFactory;

public class SquareView extends JPanel {
	
	int x, y, width, height;
	Color outlineColor, fillColor;
	int number;
	
	public SquareView(int width){
		x = this.getX();
		y = this.getY();
		this.width = width;
		this.height = width; // It's a square :D
		fillColor = Color.WHITE;
		outlineColor = Color.BLACK;
	}
	
	public SquareView(int width, Color color) {
		x = this.getX();
		y = this.getY();
		this.width = width;
		this.height = width; // It's a square :D
		outlineColor = Color.BLACK;
		fillColor = color;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(outlineColor);
		g2.drawRect(x, y, width, height);
		g2.setColor(fillColor);
		g2.fillRect(x+1, y+1, width-2, height-2);
		g2.setColor(Color.BLACK);
	}
}
