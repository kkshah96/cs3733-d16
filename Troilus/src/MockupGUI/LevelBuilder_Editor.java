package MockupGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LevelBuilder_Editor extends JFrame {

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 113, 516, 408);
		getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(515, 37, 457, 484);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(6, 6, 459, 33);
		panel_2.add(panel_3);
		
		JLabel label_3 = new JLabel("Bullpen");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
		label_3.setBounds(6, 6, 80, 23);
		panel_3.add(label_3);
		
		JButton button_2 = new JButton("Rotate CW");
		button_2.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_2.setBounds(76, 4, 87, 29);
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("Rotate CCW");
		button_3.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		button_3.setBounds(158, 4, 87, 29);
		panel_3.add(button_3);
		
		JButton btnFlipHorizontal = new JButton("Flip Horizontal");
		btnFlipHorizontal.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		btnFlipHorizontal.setBounds(237, 4, 105, 29);
		panel_3.add(btnFlipHorizontal);
		
		JButton btnFlipVertical = new JButton("Flip Vertical");
		btnFlipVertical.setBounds(335, 4, 105, 29);
		panel_3.add(btnFlipVertical);
		btnFlipVertical.setFont(new Font("PT Sans Caption", Font.PLAIN, 11));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(0, 0, 972, 38);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnNewButton.setBounds(0, 0, 102, 38);
		panel_4.add(btnNewButton);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(256, 0, 149, 38);
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
		panel_6.setBounds(404, 0, 351, 38);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnLoadNewLevel = new JButton("Level Loader");
		btnLoadNewLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnLoadNewLevel.setBounds(767, 0, 199, 38);
		btnLoadNewLevel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		panel_4.add(btnLoadNewLevel);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnUndo.setBounds(102, 0, 74, 38);
		panel_4.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		btnRedo.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnRedo.setBounds(176, 0, 74, 38);
		panel_4.add(btnRedo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 37, 516, 38);
		getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblBoardSize = new JLabel("Board:");
		lblBoardSize.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblBoardSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoardSize.setBounds(0, 0, 74, 32);
		panel_7.add(lblBoardSize);
		
		textField = new JTextField();
		textField.setBounds(70, 1, 50, 28);
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBackground(Color.LIGHT_GRAY);
		lblX.setBounds(120, 10, 25, 13);
		panel_7.add(lblX);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 1, 50, 28);
		panel_7.add(textField_1);
		
		JButton btnNew = new JButton("Set");
		btnNew.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnNew.setBounds(209, -2, 74, 38);
		panel_7.add(btnNew);
		
		JLabel lblMaximumMoves = new JLabel("Maximum Moves:");
		lblMaximumMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximumMoves.setFont(new Font("PT Sans Caption", Font.BOLD, 11));
		lblMaximumMoves.setBounds(282, 1, 126, 32);
		panel_7.add(lblMaximumMoves);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(406, 1, 74, 28);
		panel_7.add(textField_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setBounds(0, 520, 972, 209);
		getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 199, 425, -14);
		panel_8.add(scrollPane);
		
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
		panel_1.setBounds(0, 76, 516, 38);
		getContentPane().add(panel_1);
		
		JButton btnRemove = new JButton("Toggle");
		btnRemove.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnRemove.setBounds(367, 2, 76, 38);
		panel_1.add(btnRemove);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblNumber.setBounds(72, 13, 61, 16);
		panel_1.add(lblNumber);
		
		JButton btnToggleHint = new JButton("Hint");
		btnToggleHint.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		btnToggleHint.setBounds(440, 2, 76, 38);
		panel_1.add(btnToggleHint);
		
		JLabel lblSquare = new JLabel("Square:");
		lblSquare.setHorizontalAlignment(SwingConstants.CENTER);
		lblSquare.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblSquare.setBounds(0, 2, 70, 32);
		panel_1.add(lblSquare);
		
		JLabel lblNumberColor = new JLabel("Number Color:");
		lblNumberColor.setFont(new Font("PT Sans Caption", Font.PLAIN, 13));
		lblNumberColor.setBounds(189, 13, 97, 16);
		panel_1.add(lblNumberColor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(284, 7, 85, 27);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Red", "Green", "Yellow"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_1.setBounds(127, 7, 61, 27);
		panel_1.add(comboBox_1);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 972, 751);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
