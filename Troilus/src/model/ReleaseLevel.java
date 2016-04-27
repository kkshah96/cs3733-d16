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

	@Override
	public void calcNumStars() {
		// TODO Implement this
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
	
	public String getName() {
		return "Release";
	}
}