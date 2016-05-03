package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.StartLevelSelectorController;

import javax.swing.*;

import model.Kabasuji;
import view.LevelSelectorView;
import view.SplashScreenView;

/**
 * Class to handle launching of Kabasuji application.
 * @author Dan Alfred
 */
public class StartKabasuji {
	/**
	 * Main method to handle Kabasuji launch.
	 * @param args Command line arguments, which are disregarded.
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
							// the Kabasuji and corresponding view for interactions
							splash.setVisible(false);
							Kabasuji game = new Kabasuji();
							LevelSelectorView window = new LevelSelectorView(game);

							// allow controller to set up GUI based on the levels loaded by 'game'
							StartLevelSelectorController selectorController = new StartLevelSelectorController(window, game);
							selectorController.process();

							// show window
							window.setVisible(true);
							ImageIcon image = new ImageIcon(StartKabasuji.class.getResource("/images/heineman.jpg"));
							window.setIconImage(image.getImage().getScaledInstance(40, 40, 0));
							System.out.println(image);	
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