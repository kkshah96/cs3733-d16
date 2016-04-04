package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class LevelBuilder_Editor {

	private JFrame frame;
	private JTextField txtEnterLevelName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtEnterColor;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelBuilder_Editor window = new LevelBuilder_Editor();
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
	public LevelBuilder_Editor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 113, 503, 408);
		frame.getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(501, 37, 363, 484);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(6, 6, 349, 33);
		panel_2.add(panel_3);
		
		JLabel label_3 = new JLabel("Bullpen");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		label_3.setBounds(6, 6, 80, 23);
		panel_3.add(label_3);
		
		JButton button_2 = new JButton("Rotate CW");
		button_2.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_2.setBounds(76, 4, 99, 29);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("Rotate CCW");
		button_3.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_3.setBounds(166, 4, 93, 29);
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("Flip");
		button_4.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_4.setBounds(250, 4, 93, 29);
		panel_3.add(button_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 0, 864, 38);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnNewButton.setBounds(0, 0, 102, 38);
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(175, 0, 149, 38);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Puzzle");
		lblNewLabel.setFont(new Font("PT Sans Caption", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 124, 26);
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(325, 0, 308, 38);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		txtEnterLevelName = new JTextField();
		txtEnterLevelName.setText("Enter level name here...");
		txtEnterLevelName.setBounds(6, 0, 288, 38);
		panel_6.add(txtEnterLevelName);
		txtEnterLevelName.setColumns(10);
		
		JButton btnLoadNewLevel = new JButton("Load New Level");
		btnLoadNewLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnLoadNewLevel.setBounds(638, 0, 189, 38);
		panel_4.add(btnLoadNewLevel);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnUndo.setBounds(102, 0, 74, 38);
		panel_4.add(btnUndo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 37, 503, 38);
		frame.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBoardSize = new JLabel("Board:");
		lblBoardSize.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoardSize.setBounds(0, 0, 106, 32);
		panel_7.add(lblBoardSize);
		
		textField = new JTextField();
		textField.setBounds(92, 1, 50, 28);
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBackground(Color.LIGHT_GRAY);
		lblX.setBounds(139, 10, 25, 13);
		panel_7.add(lblX);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 1, 50, 28);
		panel_7.add(textField_1);
		
		JButton btnNew = new JButton("New");
		btnNew.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnNew.setBounds(222, -2, 74, 38);
		panel_7.add(btnNew);
		
		JLabel lblMaximumMoves = new JLabel("Maximum Moves:");
		lblMaximumMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximumMoves.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		lblMaximumMoves.setBounds(297, 1, 126, 32);
		panel_7.add(lblMaximumMoves);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(423, 4, 74, 28);
		panel_7.add(textField_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(0, 520, 864, 209);
		frame.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 199, 425, -14);
		panel_8.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setToolTipText("");
		scrollPane_1.setBounds(6, 49, 852, 154);
		panel_8.add(scrollPane_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(0, 0, 88, 36);
		panel_8.add(panel_9);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setLayout(null);
		
		JLabel lblPalette = new JLabel("Palette");
		lblPalette.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		lblPalette.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalette.setBounds(6, 6, 76, 24);
		panel_9.add(lblPalette);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 76, 503, 38);
		frame.getContentPane().add(panel_1);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnRemove.setBounds(382, 2, 121, 38);
		panel_1.add(btnRemove);
		
		JButton btnSquare = new JButton("Square");
		btnSquare.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnSquare.setBounds(0, 2, 96, 38);
		panel_1.add(btnSquare);
		
		txtEnterColor = new JTextField();
		txtEnterColor.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		txtEnterColor.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterColor.setText("Enter Color...");
		txtEnterColor.setBounds(101, 7, 134, 28);
		panel_1.add(txtEnterColor);
		txtEnterColor.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblNumber.setBounds(241, 13, 61, 16);
		panel_1.add(lblNumber);
		
		textField_3 = new JTextField();
		textField_3.setText("#...");
		textField_3.setBounds(304, 5, 36, 28);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 864, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
