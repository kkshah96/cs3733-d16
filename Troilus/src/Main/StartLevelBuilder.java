package Main;

import java.awt.EventQueue;

import MockupGUI.LevelLoaderView;
import model.LevelBuilder;

public class StartLevelBuilder {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelLoaderView window = new LevelLoaderView(new LevelBuilder());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
