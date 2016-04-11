package Main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import MockupGUI.LevelBuilder_Editor;
import MockupGUI.LevelBuilder_Selection;
import MockupGUI.Level_Selection;
import MockupGUI.Splash_Screen;
import model.Kabasuji;
import model.LevelBuilder;

public class StartLevelBuilder {

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
								LevelBuilder_Editor window = new LevelBuilder_Editor();
								window.setVisible(true);
								timer.stop();
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
