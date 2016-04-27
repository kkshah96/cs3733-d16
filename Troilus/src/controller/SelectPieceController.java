package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.BoardView;
import view.LevelLoaderView;
import view.LevelView;

/** 
 * Controls the selection of a piece on the board or bullpen.
 * When the user clicks on a piece on the board or bullpen, this 
 * controller selects the given piece, deselecting the previously
 * selected piece if needed.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
 * @author Maddy Longo
 *
 */
public class SelectPieceController extends MouseAdapter {
	Kabasuji game;
	Level level;
	LevelView levelView;
	LevelBuilder builder;
	LevelLoaderView editorView;

	public SelectPieceController(Kabasuji game,Level level, LevelView levelView){
		this.level = level;
		this.game = game;
		this.levelView = levelView;
	}

	public SelectPieceController(LevelBuilder builder,Level level, LevelLoaderView editorView){
		// initialize
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
	}

	// TODO Change from hard-coded values!!!
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (x > BoardView.WIDTH + BoardView.WIDTH_OFFSET || x < BoardView.WIDTH_OFFSET
				|| y > BoardView.HEIGHT + BoardView.HEIGHT_OFFSET || y < BoardView.HEIGHT_OFFSET) {
			System.out.println("Error: Did not click within the board");
		} else {
			int col = (x-BoardView.WIDTH_OFFSET)/BoardView.SQUARE_SIZE; // row and col were switched here
			int row = (y-BoardView.HEIGHT_OFFSET)/BoardView.SQUARE_SIZE;
			
			Piece activePiece = level.getBoard().getPiece(row, col);
			
			if (activePiece == null) {
				System.out.print("No piece here.");
			} else {
				level.setActivePiece(activePiece);
			}
		}//end check bounds else
	}
}