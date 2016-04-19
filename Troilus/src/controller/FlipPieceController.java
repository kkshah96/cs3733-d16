package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Kabasuji;
import model.Level;
import view.BullpenView;



public class FlipPieceController implements ActionListener{
	Kabasuji game;

	Level level;
	BullpenView bullpen;
	int degree;
	
	
	
	public FlipPieceController(Level level, Kabasuji game, BullpenView bullpen, int degree){

		this.game = game;
		this.bullpen = bullpen;
		this.level = level;
		this.degree = degree;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		level.getActivePiece().flipPiece(degree);
		
	}
	
	

}
