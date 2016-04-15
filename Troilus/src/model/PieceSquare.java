package model;

public class PieceSquare extends Square{
	

		public PieceSquare(int row, int col) {
			super(row, col);
		}

		// TODO: Can a PuzzleSquare become invalid?
		@Override
		public boolean isValid() {
			return true;
		

	}

}
