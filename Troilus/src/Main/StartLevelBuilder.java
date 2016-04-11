package Main;

import java.awt.EventQueue;

import MockupGUI.LB_LevelLoader;
import model.LevelBuilder;

public class StartLevelBuilder {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LB_LevelLoader window = new LB_LevelLoader(new LevelBuilder());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
