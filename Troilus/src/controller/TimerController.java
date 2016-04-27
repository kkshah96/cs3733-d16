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
				
				// display "00" if seconds are 0
				int displayTime = timeLeft / ONE_SECOND;
				int minutes = displayTime / 60;
				int seconds = displayTime % 60;
				String secondsString = Integer.toString(seconds);
				if (seconds < 10) {
					secondsString = "0" + seconds;
				}
				levelView.getTimeLabel().setText("Time Remaining: " + minutes + ":" + secondsString);

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
