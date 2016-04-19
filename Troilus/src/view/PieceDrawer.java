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
	
	private Random rand;
	
	public PieceDrawer(){
		this.squares = new PieceSquare[6]; // TODO: Where do we want to define constants such as the number of squares per piece (6)
		
		rand = new Random();
	}
	
	public void paint(Graphics g, Piece piece, int width, int height_offset, int width_offset){
		squares = piece.getSquares();
		anchorSquare = piece.getAnchor();
		
		g.setColor(getRandomColor());
		for(int i = 0; i < 5; i++){
			g.fillRect((anchorSquare.getRow() + squares[i].getRow()) * width + width_offset,( anchorSquare.getCol() + squares[i].getCol()) * width + height_offset, width, width);
		}
		
		g.fillRect(anchorSquare.getRow() * width + width_offset, anchorSquare.getCol() * width + height_offset, width, width);
	}
	
	private Color getRandomColor(){
		return new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
	}
}