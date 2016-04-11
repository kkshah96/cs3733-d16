package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MockupGUI.Level_Selection;
import MockupGUI.Splash_Screen;
import model.Kabasuji;


public class StartKabasuji {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			Splash_Screen splash;
			Timer timer;
			public void run() {
				try {	
					splash = new Splash_Screen();
					splash.setVisible(true);
					
					timer = new Timer(2000, new ActionListener(){      // Timer 4 seconds
						@Override
						public void actionPerformed(ActionEvent e) {
							splash.setVisible(false);
							Level_Selection window = new Level_Selection(new Kabasuji());
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
