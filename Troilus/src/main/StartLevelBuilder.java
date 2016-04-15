package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import controller.StartLevelLoaderController;
import controller.StartLevelSelectorController;
import model.LevelBuilder;
import view.LevelLoaderView;
import view.SplashScreenView;

public class StartLevelBuilder {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			SplashScreenView splash;
			Timer timer;
			public void run() {
				try {
					splash = new SplashScreenView();
					splash.setVisible(true);

					timer = new Timer(2000, new ActionListener(){      // Timer 4 seconds
						@Override
						public void actionPerformed(ActionEvent e) {
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
					timer.setRepeats(false);
					timer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}