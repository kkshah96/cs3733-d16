package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BullpenView;


/**
 * 
 * @author Connor Weeks
 *
 */
public class FlipPieceController implements ActionListener {

	Level level;
	BullpenView bullpenView;
	int direction;

	public FlipPieceController(Level level, BullpenView bullpenView, int direction) {
		this.bullpenView = bullpenView;
		this.level = level;
		this.direction = direction;
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
		Piece rotatedPiece = activePiece.flipPiece(direction);
		
		// reset the active piece and the bullpen
		bullpen.getPieces().set(bullpen.getPieces().indexOf(activePiece), rotatedPiece);
		level.setActivePiece(rotatedPiece);
		
		bullpenView.repaint();
	}
}