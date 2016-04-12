package model;

import java.util.ArrayList;


public class Kabasuji {

	ArrayList<Level> levels;
	Level activeLevel;
	
	public Kabasuji() {
		// TODO: load levels from file
		//For now, create levels in the model
		for(int i = 0; i < 18; i++){
		
					if(i != 0) {Level l = new PuzzleLevel(i, false, new Bullpen(), new Board(), new  Palette(null), 10); levels.add(l);}
					else{Level l = new PuzzleLevel(i, true, new Bullpen(), new Board(), new  Palette(null), 10); levels.add(l);}
					
				
			
				
			
			}
		
	}	
}