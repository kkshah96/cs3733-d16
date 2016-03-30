package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class Puzzle_Mockup {

	private JFrame frame;
	private JTextField txtBoardGoesHere;
	private JTextField textField;
	private JTextField txtBullpenGoesHere;
	private JTextField txtScorestars;
	private JTextField txtMovesMade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzle_Mockup window = new Puzzle_Mockup();
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
	public Puzzle_Mockup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 528, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(148, 132, 260, 157);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtBoardGoesHere = new JTextField();
		panel_1.add(txtBoardGoesHere);
		txtBoardGoesHere.setBackground(Color.LIGHT_GRAY);
		txtBoardGoesHere.setText("Board goes Here");
		txtBoardGoesHere.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 528, 49);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBackground(Color.DARK_GRAY);
		textField.setText("Level 1");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("PT Sans Caption", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(167, 6, 204, 38);
		panel_2.add(textField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(105, 61, 337, 62);
		panel.add(panel_3);
		
		txtBullpenGoesHere = new JTextField();
		txtBullpenGoesHere.setBackground(Color.WHITE);
		txtBullpenGoesHere.setText("BullPen Goes Here");
		panel_3.add(txtBullpenGoesHere);
		txtBullpenGoesHere.setColumns(10);
		
		txtMovesMade = new JTextField();
		txtMovesMade.setText("Moves Made:");
		txtMovesMade.setForeground(Color.BLACK);
		txtMovesMade.setColumns(10);
		txtMovesMade.setBackground(Color.LIGHT_GRAY);
		txtMovesMade.setBounds(6, 168, 130, 34);
		panel.add(txtMovesMade);
		
		txtScorestars = new JTextField();
		txtScorestars.setBounds(6, 234, 130, 34);
		panel.add(txtScorestars);
		txtScorestars.setText("Score/Stars:");
		txtScorestars.setForeground(Color.BLACK);
		txtScorestars.setColumns(10);
		txtScorestars.setBackground(Color.LIGHT_GRAY);
		
		JButton btnEndLevel = new JButton("End Level");
		btnEndLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		btnEndLevel.setForeground(Color.DARK_GRAY);
		btnEndLevel.setBackground(Color.LIGHT_GRAY);
		btnEndLevel.setBounds(411, 145, 117, 29);
		panel.add(btnEndLevel);
	}
}
