package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Kabasuji;
import model.Level;
import model.LevelBuilder;
import model.Piece;
import view.LevelLoaderView;
import view.LevelView;

/** 
 * Controls the selection of a piece on the board or bullpen.
 * When a user clicks on a piece on the board or bullpen, this 
 * controller selects the given piece, deselecting the previously
 * selected piece if needed.
 * 
 * @author Connor Weeks
 * @author Alexander Kasparek
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
		this.level = level;
		this.builder = builder;
		this.editorView = editorView;
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if(x > 370 || x < 10 || y > 390 || y < 30) {
			System.out.println("Error: Did not click within the board");
		}
		else {	
			Piece activePiece = level.getBoard().getPiece(((x-10)/30), ((y-30)/30));
			if(activePiece == null){
				System.out.print("No piece here.");
			}
			else 
				level.setActivePiece(activePiece);
		}//end check bounds else
	}
}