package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.Kabasuji;
import view.LevelSelectorView;
import view.LevelView;

/**
 * Controls the behavior of the timer during lightning levels.
 * @author Connor
 *
 */
public class TimerController {

	public final static int ONE_SECOND = 1000;

	LevelView levelView;
	Kabasuji game;
	int startTime;
	Timer timer;

	public TimerController(LevelView levelView, Kabasuji game, int startTime) {
		this.levelView = levelView;
		this.game = game;
		this.startTime = startTime;
	}

	/**
	 * Begins counting down the timer.  On reaching zero, the timer will create an
	 * ExitLevelController and end the level.
	 */
	public void process() {
		System.out.println("process 1");
		// create timer 
		timer = new Timer(ONE_SECOND, new ActionListener() {

			int timeLeft = startTime * ONE_SECOND;

			public void actionPerformed(ActionEvent e) {

				// decrease time left and update gui
				timeLeft -= ONE_SECOND;
				int displayTime = timeLeft / ONE_SECOND;
				levelView.getTimeLabel().setText("Time Remaining: " + (displayTime / 60) + ":" + (displayTime % 60));

				if (timeLeft <= 0) {
					// exit level and stop timer
					new ExitLevelController(levelView, game).process();
					timer.stop();
				}
			}    
		});
		System.out.println("process");
		timer.start();

	}

}
