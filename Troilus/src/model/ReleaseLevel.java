package model;

import java.awt.Color;

/**
 * Represents a Level of game type Release in the Kabasuji game
 * 
 * The ReleaseLevel structure stores three boolean arrays that capture which numbers of each color type have been covered
 * 
 * @author Kunal Shah
 *
 */
public class ReleaseLevel extends Level{

	boolean redCovered[];
	boolean yellowCovered[];
	boolean greenCovered[];
	
	public ReleaseLevel(int levelNum, boolean locked, Bullpen bullpen, Board board, Palette palette) {
		super(levelNum, locked, bullpen, board, palette);
		
		//TODO: Am I initializing these correctly or..
		redCovered = new boolean[6];
		yellowCovered = new boolean[6];
		greenCovered = new boolean[6];
	}

	@Override
	public void calcNumStars() {
		// TODO Implement this
	}
	
	// TODO: There has to be a better way to do this
	public void updateCoveredNumbers(Color c, int i){
		if(c.equals(Color.RED) && i < redCovered.length){
			redCovered[i] = true;
		}
		
		if(c.equals(Color.YELLOW) && i < yellowCovered.length){
			yellowCovered[i] = true;
		}
		
		if(c.equals(Color.GREEN) && i < greenCovered.length){
			greenCovered[i] = true;
		}
	}
	
	public String getName() {
		return "Release";
	}

}
