package controller;

import model.Level;
import model.ReleaseSquare;


/**
 * Move class for implementation of setting a board release square number.
 * @author Alex Kasparek
 */
public class SetSquareNumberMove extends Move{
	
	/**The square whose number is being set*/
	ReleaseSquare setSquare;
	
	/**The current release level*/
	Level level;
	
	/**The number that setSquare's number is being set to*/
	int num;
	
	/** setSquare's previous number*/
	int previousNum;

	
	/**
	 * Creates a new instance of a SetSquareNumberMove with the given parameters.
	 * @param setSquare The square whose number color is being set
	 * @param level The current ReleaseLevel
	 * @param num The number to set setSquare's number to
	 */
	public SetSquareNumberMove(ReleaseSquare setSquare, Level level, int num){
		this.level = level;
		this.setSquare = setSquare;
		this.num = num;
		previousNum = setSquare.getNumber();
		
	}
	
	
	/**
	 * Completes this instance of SetSquareNumberMove.
	 * @return True if the move completed successfully, or false if an error occurred.
	 */
	@Override
	public boolean doMove() {
		if(isValid()){
			setSquare.setNumber(num);
		}
		return false;
	}

	
	/**
	 * Checks if this SetSquareNumberMove is valid.
	 * @return True if the move is valid, false if it is not a valid move.
	 */
	@Override
	public boolean isValid() {
		boolean validation = false;
		if(!(num < 0 || num > 6) && setSquare.isValid()){
			validation = true;
		}
		return validation;
	}

	
	/**
	 * Undoes this SetSquareNumberMove by setting setSquare's number to what it was before this move was done.
	 * @return True if the move was undone successfully, or false otherwise
	 */
	@Override
	public boolean undo() {
		if(setSquare.isValid()){
			setSquare.setNumber(previousNum);
			return true;
		}
		return false;
	}

}
