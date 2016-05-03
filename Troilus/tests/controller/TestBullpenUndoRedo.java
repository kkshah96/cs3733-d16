package controller;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestBullpenUndoRedo extends TestCase {
	PuzzleLevel level;
	LevelBuilder builder;
	Bullpen bullpen;
	LevelEditorView editorView;
	UndoMoveController undoController;
	RedoMoveController redoController;
	
	public void setUp() {
		PuzzleSquare[][] squares = new PuzzleSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for (int i = 0; i < Board.BOARD_WIDTH; i++) {
			for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
				squares[i][j] = new PuzzleSquare(i, j, true);
			}
		}
		
		builder = new LevelBuilder();
		int numLevels = builder.getNumLevels() + 1;
		level = new PuzzleLevel(numLevels, false, new Bullpen(), new Board(squares), Palette.getInstance(), 15);
		builder.addLevel(level);
		bullpen = level.getBullpen();
		bullpen.addPiece(PieceFactory.getPiece(1));
		editorView = new LevelEditorView(builder, new LevelLoaderView(builder), level);
		UndoMoveController undoController = new UndoMoveController(builder, editorView);
		RedoMoveController redoController = new RedoMoveController(builder, editorView);
	}
	
	public void testUndo() {
		// Do initial move
		RemoveFromBullpenMove remove1 = new RemoveFromBullpenMove(level, bullpen.getPieces().get(0));
		remove1.doMove();
		builder.pushMove(remove1);
		
		assertEquals(0, bullpen.getNumPieces());
		
		// Undo
	}
}