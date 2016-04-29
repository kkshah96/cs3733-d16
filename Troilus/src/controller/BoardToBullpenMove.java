package controller;

import model.Board;
import model.Piece;
import model.Bullpen;
import model.Level;

/**
 * Class for implemenation of removing a piece from the board.
 * @author Maddy
 *
 */
public class BoardToBullpenMove extends Move{
	/** The level modified in this move */
	Level level;
	
	/** The piece utilized during this move */
	Piece pToRemove;
	
	/** The board destination used during this move */
	Board board;
	
	/** The bullpen source used during this move */
	Bullpen bpen;
	
	/** The column of the source square on the board */
	int col;
	
	/** The row of the source square on the board */
	int row;
	
	/**
	 * Creates an instance of a BoardToBullpenMove with the specified parameters
	 * @param level The level to be modified during the move
	 * @param col The column of the source square on the board
	 * @param row The row of the source square on the board
	 */
	public BoardToBullpenMove(Level level, int col, int row) {
		this.board = level.getBoard();
		this.bpen = level.getBullpen();
		this.pToRemove = board.getPiece(col, row);
		this.level = level;
	}
	
	/**
	 * Completes this BoardToBullpenMove
	 * @return True if the move is completed successfully, false otherwise
	 */
	public boolean doMove() {
		// First check if the move is valid. If not, return false
		if (!isValid()) {
			return false;
		}
		
		// Remove the requested piece from the board and add it to the bullpen
		bpen.addPiece(board.removePiece(pToRemove));
		
		// Remove the active piece reference in level and signal to refresh
		level.removeActivePiece();
		level.updateAfterMove();
		return true;
	}
	
	/**
	 * Checks if this BoardToBullpenMove is valid:<br />
	 * Valid if the piece selected is not null
	 * @return True if the move is valid, false otherwise
	 */
	//TODO: Shouldn't this have a check that the given piece is on the board?
	public boolean isValid() {
		return pToRemove != null;
	}
	
	/**
	 * Undoes this move and reverts to prior state
	 * @return True if completed successfully, false otherwise
	 */
	public boolean undo() {
		// TODO implement undo()
		return false;
	}
}