package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BullpenView;

/**
 * Class to handle requested rotations to pieces in the bullpen.
 * 
 * @author Alexander Kasparek
 * @author Connor Weeks
 */

public class RotatePieceController implements ActionListener {
	/** The level entity referenced */
	Level level;
	
	/** The view for the bullpen */
	BullpenView bullpenView;
	
	/** Representation of the direction to rotate */
	int degree;
	
	/**
	 * Creates a new instance of RotatePieceController with the following parameters
	 * @param level Reference to the level used
	 * @param bullpenView View for the bullpen inside the level used
	 * @param degree Representation of the direction to rotate
	 */
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
		if (bullpenView == null) {
			System.out.println("no bp");
			return;
		}
		bullpenView.repaint();
	}
}