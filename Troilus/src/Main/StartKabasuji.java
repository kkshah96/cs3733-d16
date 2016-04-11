package Main;

import java.awt.EventQueue;

import MockupGUI.Level_Selection;
import MockupGUI.Splash_Screen;
import model.Kabasuji;

public class StartKabasuji {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash_Screen splash = new Splash_Screen();
					//splash.setFrameVisible();
					Splash_Screen.main(null); //Is this a good way to do that?
					
					
					//Timer time = new Timer()
				//add Timer here...
					//for()
					Level_Selection window = new Level_Selection(new Kabasuji());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
