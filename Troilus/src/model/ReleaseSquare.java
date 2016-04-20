package model;

import java.awt.Color;

/**
 * Class allows for storage and manipulation of Release Square.
 * 
 * Allows for implementation of Release-level squares in Kabasuji.
 * Keeps track of its number and the number's color.
 * 
 * @author Maddy
 *
 */
public class ReleaseSquare extends Square {
	int number;
	Color numberColor;
	
	public ReleaseSquare(int row, int col, boolean isValid) {
		super(row, col, isValid);
		number = 0;
		numberColor = null;
		
	}

	@Override
	public String getType() {
		return "ReleaseSquare";
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getNumberColor() {
		return numberColor.toString();
	}
	
	public boolean setNumber(int num){
		if(num < 1 || num > 6){
			System.out.println("Error! Invalid number");
			return false;
		}
		else{
			this.number = num;
			return true;
		}
	}
	
	public boolean setNumberColor(Color color){
		this.numberColor = color;
		return true;
	}
}