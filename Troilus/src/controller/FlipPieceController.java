package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Level;
import model.Piece;
import view.BullpenView;


/**
 * Handles the flipping of a given piece, either Horizontally or Vertically.
 * 
 * @author Connor Weeks
 *
 */
public class FlipPieceController implements ActionListener {
	/** The current level */
	Level level;

	/** The view for the bullpen in the current level */
	BullpenView bullpenView;

	/** The direction to flip */
	int direction;

	/**
	 * Creates a new instance of the FlipPieceController with the given parameters
	 * @param level The current level
	 * @param bullpenView The view for the current bullpen
	 * @param direction The direction to flip (Piece.FLIP_HORIZONTALLY or Piece.FLIP_VERTICALLY)
	 */
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

		// if the piece is not in the bullpen, return
		if (!bullpen.getPieces().contains(activePiece)) {
			return;
		}

		// reset the active piece and the bullpen
		bullpen.getPieces().set(bullpen.getPieces().indexOf(activePiece), rotatedPiece);
		level.setActivePiece(rotatedPiece);

		bullpenView.repaint();
	}
}