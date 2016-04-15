package view;

import java.awt.Graphics;

import model.PieceSquare;
import model.Square;

public class PieceDrawer {
	
	Square[] squares;
	
	public PieceDrawer(){
		this.squares = new PieceSquare[6]; // TODO: Where do we want to define constants such as the number of squares per piece (6)
	}
	
	public void paint(Graphics g, PieceSquare[] squares, int width){
		for(int i = 0; i < 6; i++){
			g.drawRect(squares[i].getRow() * width, squares[i].getCol() * width, width, width);
		}
	}
}
