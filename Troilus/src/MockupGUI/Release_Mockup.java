package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import java.awt.Panel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Release_Mockup {

	JFrame frame;
	private JPanel panel_1;
	private JLabel lblLevelPuzzle;

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
	 * @wbp.parser.entryPoint
	 */
	public Release_Mockup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1034, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1034, 46);
		panel.add(panel_1);
		
		lblLevelPuzzle = new JLabel("Level 15: Release");
		lblLevelPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelPuzzle.setForeground(Color.LIGHT_GRAY);
		lblLevelPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panel_1.add(lblLevelPuzzle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 88, 536, 455);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBorder(null);
		panel_4.setBounds(6, 6, 524, 34);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblBoard = new JLabel("Board");
		lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		lblBoard.setForeground(Color.BLACK);
		lblBoard.setBounds(6, 6, 90, 28);
		panel_4.add(lblBoard);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(535, 88, 499, 455);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(6, 6, 485, 33);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblBullpen = new JLabel("Bullpen");
		lblBullpen.setBounds(6, 6, 80, 23);
		lblBullpen.setForeground(Color.BLACK);
		lblBullpen.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		panel_5.add(lblBullpen);
		
		JButton btnNewButton_1 = new JButton("Rotate CW");
		btnNewButton_1.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(76, 4, 99, 29);
		panel_5.add(btnNewButton_1);
		
		JButton btnRotateCcw = new JButton("Rotate CCW");
		btnRotateCcw.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnRotateCcw.setBounds(166, 4, 93, 29);
		panel_5.add(btnRotateCcw);
		
		JButton btnFlip = new JButton("Flip Horizontal");
		btnFlip.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlip.setBounds(250, 4, 110, 29);
		panel_5.add(btnFlip);
		
		JButton btnFlipVertical = new JButton("Flip Vertical");
		btnFlipVertical.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlipVertical.setBounds(361, 4, 110, 29);
		panel_5.add(btnFlipVertical);
		
		JButton btnNewButton_2 = new JButton("Exit Level");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(852, 50, 176, 36);
		panel.add(btnNewButton_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(null);
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(68, 48, 453, 38);
		panel.add(panel_6);
		
		JLabel label_3 = new JLabel("Stars: 0/3");
		label_3.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		label_3.setBounds(388, 15, 65, 16);
		panel_6.add(label_3);
		
		JLabel label_5 = new JLabel("Red Squares:");
		label_5.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_5.setBounds(0, 16, 82, 16);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("0/6");
		label_6.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_6.setBounds(85, 16, 31, 16);
		panel_6.add(label_6);
		
		JLabel label_7 = new JLabel("Green Squares:");
		label_7.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_7.setBounds(115, 16, 103, 16);
		panel_6.add(label_7);
		
		JLabel label_8 = new JLabel("0/6");
		label_8.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_8.setBounds(218, 16, 31, 16);
		panel_6.add(label_8);
		
		JLabel label_9 = new JLabel("Yellow Squares:");
		label_9.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_9.setBounds(249, 16, 103, 16);
		panel_6.add(label_9);
		
		JLabel label_10 = new JLabel("0/6");
		label_10.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		label_10.setBounds(356, 16, 31, 16);
		panel_6.add(label_10);
	}
}
