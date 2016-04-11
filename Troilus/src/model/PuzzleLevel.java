package model;

public class PuzzleLevel extends Level{

	int maxMoves;
	int movesLeft;
	
	public PuzzleLevel(int levelNum, Bullpen bullpen, Board board, Palette palette, int maxMoves) {
		super(levelNum, bullpen, board, palette);
		
		this.maxMoves = maxMoves;
		this.movesLeft = this.maxMoves; // TODO: Can I do dis
	}

	@Override
	public void calcNumStars() {
		// TODO Implement this
	}
	
	public void updateMovesLeft(int i){
		movesLeft += i;
	}

}
