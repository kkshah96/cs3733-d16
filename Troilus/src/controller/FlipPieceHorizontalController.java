package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Kabasuji;
import model.Level;
import view.BullpenView;



public class FlipPieceHorizontalController extends MouseAdapter{
	Kabasuji game;

	Level level;
	BullpenView bullpen;
	
	static final int FLIP_HORIZONTAL = -1;
	
	public FlipPieceHorizontalController(Level level, Kabasuji game, BullpenView bullpen){

		this.game = game;
		this.bullpen = bullpen;
		this.level = level;
		
	}
	
	public void mousePressed(MouseEvent e) {
		level.getActivePiece().flipPiece(FLIP_HORIZONTAL);
	}
	
	

}
