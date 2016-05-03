package controller;

import java.awt.Color;

import model.Level;
import model.ReleaseSquare;

/**
 * Move class for implementation of setting a board release square number color.
 * @author Alex Kasparek
 */
public class SetSquareNumberColorMove extends Move {
	/**The square whose number color is being set. */
	ReleaseSquare setSquare;
	
	/**The current release level. */
	Level level;
	
	/**The color that setSquare's number color is being set to. */
	Color c;
	
	/** setSquare's previous color. */
	Color previousColor;

	
	/**
	 * Creates a new instance of a SetSquareNumberColorMove with the given parameters.
	 * @param setSquare The square whose number color is being set.
	 * @param level The current ReleaseLevel.
	 * @param c The color to set setSquare's number color to.
	 */
	public SetSquareNumberColorMove(ReleaseSquare setSquare, Level level, Color c) {
		this.level = level;
		this.setSquare = setSquare;
		this.c = c;
		previousColor = setSquare.getNumberColor();
	}
	
	/**
	 * Completes this instance of SetSquareNumberColorMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	@Override
	public boolean doMove() {
		if(isValid()){
			setSquare.setNumberColor(c);
		}
		return false;
	}
	
	/**
	 * Checks if this SetSquareNumberColorMove is valid.
	 *  @return True if the move is valid, false if it is not a valid move.
	 */
	@Override
	public boolean isValid() {
		boolean validation = false;
		if(setSquare.isValid()){
			validation = true;
		}
		return validation;
	}
	
	/**
	 * Undoes this SetSquareNumberColorMove and sets setSquare's number color to
	 * what it was prior to this move being done.
	 * @return True if the move was undone successfully, or false otherwise.
	 */
	@Override
	public boolean undo() {
		if (setSquare.isValid()) {
			setSquare.setNumberColor(previousColor);
			return true;
		}
		return false;
	}
}