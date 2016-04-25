package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BullpenView;

/**
 * 
 * 
 * @author Alexander Kasparek
 * @author Connor Weeks
 */

public class RotatePieceController implements ActionListener {
	
	Level level;
	BullpenView bullpenView;
	int degree;
	
	
	
	public RotatePieceController(Level level, BullpenView bullpenView, int degree) {
		this.bullpenView = bullpenView;
		this.level = level;
		this.degree = degree;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// get active level piece
		Piece activePiece = level.getActivePiece();
		if (activePiece == null) {
			return;
		}
		
		// rotate piece
		Bullpen bullpen = level.getBullpen();
		Piece rotatedPiece = activePiece.rotatePiece(degree);
		
		// reset the active piece and the bullpen
		bullpen.getPieces().set(bullpen.getPieces().indexOf(activePiece), rotatedPiece);
		level.setActivePiece(rotatedPiece);
		
		bullpenView.repaint();
	}
}