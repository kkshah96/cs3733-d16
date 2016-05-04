package model;

import java.util.ArrayList;
import java.util.Stack;

import controller.LoadLevelsController;
import controller.Move;

/**
 * Top level entity for the LevelBuilder application.
 * 
 * The LevelBuilder structure, similar to Kabasuji, contains a collection of Levels and keeps track of the 
 * active level (or level being edited).
 * 
 * @author Kunal Shah
 * @author Connor Weeks
 * @author Alex Kasparek
 */
public class LevelBuilder {
	/** A collection of levels this LevelBuilder can open, edit, or save. */
	ArrayList<Level> levels;

	/** Contains any moves that have been completed. */
	Stack<Move> undoMoves;

	/** Contains any moves that have been undone. */
	Stack<Move> redoMoves;

	/**
	 * Creates a new instance of the LevelBuilder entity.
	 */
	public LevelBuilder() {
		initialize();
	}

	/**
	 * Initializes the LevelBuilder entity for first use through loading levels and creating undo/redo stacks.
	 */
	public void initialize() {
		// create level loader controller
		LoadLevelsController loader = new LoadLevelsController();

		// load levels into the list of levels
		levels = loader.loadLevels();

		// Initialize stacks for undo/redo
		undoMoves = new Stack<Move>();
		redoMoves = new Stack<Move>();
	}

	/**
	 * Returns the listing of levels stored in this LevelBuilder.
	 * @return ArrayList of levels.
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}

	/**
	 * Returns the number of levels stored in this LevelBuilder.
	 * @return Size of the ArrayList of levels.
	 */
	public int getNumLevels() {
		return levels.size();
	}

	/**
	 * Adds a given level to this LevelBuilder.
	 * @param level Level object to be added.
	 */
	public void addLevel(Level level){
		levels.add(level);
	}

	/**
	 * Adds a move to the stack of completed moves.
	 * @param m The move object to add.
	 * @param undoingMove False if not redoing a previously-done move.
	 * Should ONLY be true in RedoMoveController.
	 * @return Returns true if the move was added successfully.
	 */
	public boolean pushMove(Move m, boolean undoingMove) {
		undoMoves.push(m);
		// If not undoing a move, then clear redo stack to avoid conflict.
		if (!undoingMove) {
			redoMoves = new Stack<Move>();
		}
		
		return true;
	}

	/**
	 * Pops and returns the move at the top of the stack.
	 * @return The Move object at the top of the stack, or NULL if empty stack.
	 */
	public Move popUndoMove() {
		if (canUndo()) {
			return undoMoves.pop();
		}
		return null;
	}

	/**
	 * Adds a move to the top of the redo stack.
	 * @param m The move object to be added to the redo stack.
	 * @return The move object added.
	 */
	public Move pushRedoMove(Move m){
		return redoMoves.push(m);
	}

	/**
	 * Determines if there are moves that can be undone.
	 * @return True if there is an undoable move, false otherwise.
	 */
	public boolean canUndo() {
		return undoMoves.size() > 0;
	}

	/**
	 * Determines if there are moves that can be redone.
	 * @return True if there is a redoable move, false otherwise.
	 */
	public boolean canRedo() {
		return redoMoves.size() > 0;
	}

	/**
	 * Pops and returns the move at the top of the redoMoves stack.
	 * @return The Move object at the top of the redo stack.
	 */
	public Move popRedoMove(){
		return redoMoves.pop();
	}
}