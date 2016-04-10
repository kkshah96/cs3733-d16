package Main;

import java.awt.EventQueue;

import MockupGUI.Level_Selection;
import model.Kabasuji;

public class StartKabasuji {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level_Selection window = new Level_Selection(new Kabasuji());
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
