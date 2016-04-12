package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.StartLevelSelectorController;

import javax.swing.*;

import model.Kabasuji;
import view.LevelSelectorView;
import view.SplashScreenView;


public class StartKabasuji {

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
							Kabasuji game = new Kabasuji();
							LevelSelectorView window = new LevelSelectorView(game);
							StartLevelSelectorController selectorController = new StartLevelSelectorController(window, game);
							selectorController.process();
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