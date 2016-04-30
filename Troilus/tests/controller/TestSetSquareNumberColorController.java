package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import junit.framework.TestCase;
import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.Palette;
import model.PuzzleSquare;
import model.ReleaseLevel;
import model.ReleaseSquare;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

public class TestSetSquareNumberColorController extends TestCase {

	
	public void testSet() {
		LevelBuilder builder = new LevelBuilder();
		LevelLoaderView loader = new LevelLoaderView(builder);
		Bullpen bullpen = new Bullpen();
		Square[][] squares = new ReleaseSquare[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
		for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
			for (int j = 0; j < Board.BOARD_WIDTH; j++) {
				squares[i][j] = new ReleaseSquare(i, j, true);
			}
		}
		Board board = new Board(squares);
		Palette palette = new Palette();
		ReleaseLevel level = new ReleaseLevel(0, false, bullpen, board, palette);
		LevelEditorView editorView = new LevelEditorView(builder, loader, level);
		level.getBoard().setActiveSquare(0, 0);
		editorView.getNumberColorComboBox().setSelectedItem("Red");
		editorView.getNumberComboBox().setSelectedItem("1");
		
		SetSquareNumberColorController setColor = new SetSquareNumberColorController(level, editorView);
		SetSquareNumberController setNumber = new SetSquareNumberController(level, editorView);
		ActionEvent ae = new ActionEvent(editorView.getNumberColorComboBox(), 0, null, 0, 0);
		setColor.actionPerformed(ae);
		ActionEvent ae2 = new ActionEvent(editorView.getNumberComboBox(), 0, null, 0, 0);
		setNumber.actionPerformed(ae2);
		
		assertEquals(Color.RED,((ReleaseSquare)board.getActiveSquare()).getNumberColor());
		assertEquals(1, ((ReleaseSquare)board.getActiveSquare()).getNumber());
	}
}
