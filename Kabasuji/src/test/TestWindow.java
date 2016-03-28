package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JList;

public class TestWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow window = new TestWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel boardPanel = new Panel();
		boardPanel.setBounds(10, 10, 240, 240);
		frame.getContentPane().add(boardPanel);
		
		Panel bullpenPanel = new Panel();
		bullpenPanel.setBounds(256, 10, 95, 240);
		frame.getContentPane().add(bullpenPanel);
	}
}
