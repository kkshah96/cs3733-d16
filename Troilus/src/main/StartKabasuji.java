package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
							LevelSelectorView window = new LevelSelectorView(new Kabasuji());
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