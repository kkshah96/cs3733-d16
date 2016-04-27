package model;

import java.awt.Color;

/**
 * Represents a Level of game type Release in the Kabasuji game.
 * 
 * The ReleaseLevel structure stores three boolean arrays that capture
 * which numbers of each color type have been covered.
 * 
 * @author Kunal Shah
 * @author Maddy
 */
public class ReleaseLevel extends Level {
	public static final int MAX_NUM = 6;
	boolean redCovered[];
	boolean yellowCovered[];
	boolean greenCovered[];
	
	public ReleaseLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		super(levelNum, locked, bullpen, board, palette);
		
		redCovered = new boolean[MAX_NUM];
		yellowCovered = new boolean[MAX_NUM];
		greenCovered = new boolean[MAX_NUM];
	}

	public void updateAfterMove() {
		calcNumStars();
	}
	
	@Override
	/** 1 star for completing 1 color set, 2 for 2 color sets, win if get all 3 */
	public void calcNumStars() {
		if (!(setComplete(redCovered) || setComplete(yellowCovered) || setComplete(greenCovered))) {
			numStars = 0; // No sets are complete
		} else if (setComplete(redCovered) && setComplete(yellowCovered) && setComplete(greenCovered)) {
			numStars = 3; // All sets are complete
		} else if ((setComplete(redCovered) && setComplete(yellowCovered) && !setComplete(greenCovered)) ||
				(setComplete(redCovered) && setComplete(greenCovered) && !setComplete(yellowCovered)) ||
				(setComplete(greenCovered) && setComplete(yellowCovered) && !setComplete(redCovered))) {
			// TODO clean up logic!
			numStars = 2;
		} else {
			numStars = 1;
		}
	}
	
	/** Helper function for calculating stars */
	private boolean setComplete(boolean[] numSet) {
		for (boolean covered : numSet) {
			if (!covered) {
				return false;
			}
		}
		
		return true;
	}
	
	// TODO: There has to be a better way to do this
	public void updateCoveredNumbers(Color c, int i) {
		if (i >= MAX_NUM || i < 0) {
			return;
		}
		
		if (c.equals(Color.RED)) {
			redCovered[i] = true;
		}
		
		if (c.equals(Color.YELLOW)) {
			yellowCovered[i] = true;
		}
		
		if (c.equals(Color.GREEN)) {
			greenCovered[i] = true;
		}
	}
	
	// TODO implement stubs!
	public int getRedCovered() {
		return 0;
	}
	
	public int getGreenCovered() {
		return 0;
	}
	
	public int getYellowCovered() {
		return 0;
	}
	public String getName() {
		return "Release";
	}
}