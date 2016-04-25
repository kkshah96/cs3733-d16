package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import model.Piece;
import model.PieceSquare;

/**
 * This class contains the logic to render a given piece.
 * 
 * PieceDrawer provides a paint method, given a calling class' graphics object, and a piece
 * and information to draw the piece.
 * @author Dan Alfred
 * @author Kunal Shah
 * @author Connor Weeks
 *
 */
public class PieceDrawer {
	/** Holds the non-anchor squares of the piece to draw */
	PieceSquare[] squares;
	
	/** Holds the anchor square of the piece to draw */
	PieceSquare anchorSquare;
	
	/** Holds a random object to use for color generation*/
	private Random rand;
	
	public PieceDrawer(){
		this.squares = new PieceSquare[6]; // TODO: Where do we want to define constants such as the number of squares per piece (6)
		
		rand = new Random();
	}
	
	/**
	 * Paints a given piece with the specified parameters.
	 * @param g Graphics object from calling class
	 * @param color The color of the piece to be drawn
	 * @param piece The piece to be drawn
	 * @param width The width of each square in pixels
	 * @param heightOffset The height offset of the piece in pixels
	 * @param widthOffset The width offset of the piece in pixels
	 */
	public void paint(Graphics g, Color color, Piece piece, Point p, int width, int heightOffset, int widthOffset){
		squares = piece.getSquares();
		anchorSquare = piece.getAnchor();
		
		g.setColor(color);
		
		// fill anchor square
		g.fillRect(p.x * width + widthOffset, p.y * width + heightOffset, width, width);
		
		// fill other squares
		for(int i = 0; i < 5; i++){
			g.fillRect((p.x + squares[i].getCol()) * width + widthOffset, (p.y + squares[i].getRow()) * width + heightOffset, width, width);
		}
	}
	
	/**
	 * Paints a given piece with the specified parameters and a color set to red.
	 * @param g Graphics object from calling class
	 * @param piece The piece to be drawn
	 * @param width The width of each square in pixels
	 * @param heightOffset The height offset of the piece in pixels
	 * @param widthOffset The width offset of the piece in pixels
	 */
	public void paint(Graphics g, Piece piece, Point p, int width, int heightOffset, int widthOffset){
		paint(g, Color.RED, piece, p, width, heightOffset, widthOffset);
	}
	
}