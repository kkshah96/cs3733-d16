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

public class Lightning_Mockup {

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
					window.setVisible(true);
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
	public Lightning_Mockup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 953, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 953, 46);
		panel.add(panel_1);
		
		lblLevelPuzzle = new JLabel("Level 4: Lightning");
		lblLevelPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelPuzzle.setForeground(Color.LIGHT_GRAY);
		lblLevelPuzzle.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		panel_1.add(lblLevelPuzzle);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 88, 461, 455);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBorder(null);
		panel_4.setBounds(6, 6, 434, 34);
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
		panel_3.setBounds(458, 88, 495, 455);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(6, 6, 483, 33);
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
		btnNewButton_2.setBounds(771, 50, 176, 36);
		panel.add(btnNewButton_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(175, 50, 286, 38);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time Remaining: 1:30");
		lblNewLabel.setBounds(6, 6, 161, 20);
		panel_6.add(lblNewLabel);
		lblNewLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		
		JLabel lblStars = new JLabel("Stars: 0/3");
		lblStars.setBounds(186, 8, 82, 16);
		panel_6.add(lblStars);
		lblStars.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
	}
}
