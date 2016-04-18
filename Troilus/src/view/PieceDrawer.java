package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import model.Piece;
import model.PieceSquare;
import model.Square;

public class PieceDrawer {
	
	PieceSquare[] squares;
	PieceSquare anchorSquare;
	
	public PieceDrawer(){
		this.squares = new PieceSquare[6]; // TODO: Where do we want to define constants such as the number of squares per piece (6)
	}
	
	public void paint(Graphics g, Piece piece, int width, int height_offset, int width_offset){
		squares = piece.getSquares();
		anchorSquare = piece.getAnchor();
		
		Random rand = new Random();
		float red = rand.nextFloat();
		float green = rand.nextFloat();
		float blue = rand.nextFloat();
		
		Color c = new Color(red, green, blue);
		
		g.setColor(c);
		for(int i = 0; i < 5; i++){
			g.fillRect(squares[i].getRow() * width + width_offset, squares[i].getCol() * width + height_offset, width, width);
		}
		
		g.fillRect(anchorSquare.getRow() * width + width_offset, anchorSquare.getCol() * width + height_offset, width, width);
	}
}