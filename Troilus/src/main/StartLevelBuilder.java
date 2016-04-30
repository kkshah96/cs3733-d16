package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import controller.StartLevelLoaderController;
import model.LevelBuilder;
import view.LevelLoaderView;
import view.SplashScreenView;

/**
 * Class to handle launching of the LevelBuilder application.
 * @author Dan Alfred
 */
public class StartLevelBuilder {
	
	/**
	 * Main method to handle LevelBuilder launch
	 * @param args Command line arguments, which are disregarded
	 */
	public static void main(String[] args) {
		// Define new Runnable for splash screen execution
		EventQueue.invokeLater(new Runnable() {
			SplashScreenView splash;
			Timer timer;
			public void run() {
				try {
					// Create splash screen boundary object and set visible
					splash = new SplashScreenView();
					splash.setVisible(true);

					// Begin timer for 2 seconds to display
					timer = new Timer(2000, new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							// Create event on timer completion that hide the splash screen, and creates
							// the LevelBuilder and corresponding view for interactions
							splash.setVisible(false);
							LevelBuilder builder = new LevelBuilder();
							LevelLoaderView window = new LevelLoaderView(builder);
							
							// allow controller to set up GUI based on the levels loaded by 'builder'
							StartLevelLoaderController loaderController = new StartLevelLoaderController(window, builder);
							loaderController.process();
							
							// show the window
							window.setVisible(true);
						}
					});
					// Start the timer and ensure it only runs once
					timer.setRepeats(false);
					timer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}