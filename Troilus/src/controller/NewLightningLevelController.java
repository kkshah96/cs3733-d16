package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.Board;
import model.Bullpen;
import model.LevelBuilder;
import model.LightningLevel;
import model.LightningSquare;
import model.Palette;
import model.Square;
import view.LevelEditorView;
import view.LevelLoaderView;

/**
 * Controls the creation of a new lightning level in the level builder.
 * Upon the designer requesting to create a new lightning level, this
 * controller creates the new level, adds it to the level builder's list 
 * of levels, and shows the level editor screen for the newly created level.
 * 
 * @author Connor Weeks
 * @author Kunal Shah
 *
 */
public class NewLightningLevelController implements ActionListener {
	LevelBuilder builder;
	LevelLoaderView levelLoader;

	public NewLightningLevelController(LevelBuilder builder, LevelLoaderView levelLoader) {
		this.builder = builder;
		this.levelLoader = levelLoader;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Create a new Bullpen, Palette and Board for the Level
		Bullpen bpen = new Bullpen();
		Square[][] squares = new LightningSquare[Board.BOARD_WIDTH][Board.BOARD_HEIGHT];
		for(int i = 0; i < Board.BOARD_WIDTH; i++){
			for(int j = 0; j < Board.BOARD_HEIGHT; j++){
				squares[i][j] = new LightningSquare(j, i, true);
			}
		}

		Board board = new Board(squares);

		Palette p = new Palette();
		LightningLevel newLevel = new LightningLevel(builder.getLevels().size() + 1, true, bpen, board, p, 0);
		builder.addLevel(newLevel);
		//builder.setActiveLevel(l); // TODO: Will we have to handle setting activeLevel to null in the future when a level is exited?

		final LevelEditorView newEditorView = new LevelEditorView(builder, levelLoader, newLevel);

		newEditorView.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				newEditorView.dispose();
				// handle reset
				new ExitLevelEditorController(builder, newEditorView, levelLoader).process();
			}      
		});

		//Show/hide specific elements to only show things relevant to lightning levels
		newEditorView.setLevelType("Lightning");
		newEditorView.setMaxMovesPanelVisibility(false);
		newEditorView.setReleaseSquarePanelVisibility(false);
		newEditorView.setTimeLimitPanelVisibility(true);

		// add listeners to handle input
		newEditorView.getSecondsField().addActionListener(new SetTimeLimitController(newLevel, newEditorView));
		newEditorView.getMinutesField().addActionListener(new SetTimeLimitController(newLevel, newEditorView));
		newEditorView.getSetTimeButton().addActionListener(new SetTimeLimitController(newLevel, newEditorView));

		levelLoader.setVisible(false);
		newEditorView.setVisible(true);
	}
}