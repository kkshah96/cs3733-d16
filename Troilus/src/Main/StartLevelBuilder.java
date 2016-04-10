package Main;

import java.awt.EventQueue;

import MockupGUI.LevelBuilder_Selection;
import model.LevelBuilder;

public class StartLevelBuilder {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilder_Selection window = new LevelBuilder_Selection(new LevelBuilder());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
