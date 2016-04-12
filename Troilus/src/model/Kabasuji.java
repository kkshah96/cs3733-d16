package model;

import java.util.ArrayList;


public class Kabasuji {

	ArrayList<Level> levels;
	Level activeLevel;

	public ArrayList<Level> getLevels() {
		return levels;
	}
	
	public int getNumLevels() {
		return levels.size();
	}
	
	public Kabasuji() {
		// TODO: load levels from file
		//For now, create levels in the model
		levels = new ArrayList<Level>();
		for(int i = 0; i < 24; i++){

			if(i == 0) {
				Level level1 = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(null), 10); 
				levels.add(level1);}
			else {
				Level other = new PuzzleLevel(i, true, new Bullpen(), new Board(), new  Palette(null), 10); 
				levels.add(other);
			}

		}

	}	
}