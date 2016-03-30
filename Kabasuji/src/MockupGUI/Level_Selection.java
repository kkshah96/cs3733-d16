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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Button;
import javax.swing.JButton;

public class Level_Selection {

	private JFrame frame;
	private JTextField txtLevel;
	/**
	 * @wbp.nonvisual location=69,171
	 */
	private final ImageIcon Thumbnail = new ImageIcon();
	private JTextField txtLevel_1;
	/**
	 * @wbp.nonvisual location=60,261
	 */
	private final ImageIcon Thumbnail2 = new ImageIcon();
	private JTextField txtLevelSelection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level_Selection window = new Level_Selection();
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
	public Level_Selection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Thumbnail2.setDescription("Thumbnail?");
		Thumbnail.setDescription("Thumbnail?");
		Thumbnail.setImage(Toolkit.getDefaultToolkit().getImage("/Users/alex/Desktop/IQP/CS 3733 Software Engineering/Rhinoceros.jpg"));
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setForeground(Color.DARK_GRAY);
		scrollBar.setBackground(Color.DARK_GRAY);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMinimum(30);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		
		txtLevel = new JTextField();
		txtLevel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLevel.setBackground(Color.DARK_GRAY);
		txtLevel.setForeground(Color.LIGHT_GRAY);
		txtLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		txtLevel.setText("Level 1");
		txtLevel.setColumns(10);
		
		JButton btnPlayLevel = new JButton("Play Level");
		btnPlayLevel.setBackground(Color.LIGHT_GRAY);
		btnPlayLevel.setForeground(Color.DARK_GRAY);
		btnPlayLevel.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		
		txtLevel_1 = new JTextField();
		txtLevel_1.setText("Level 2");
		txtLevel_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtLevel_1.setForeground(Color.LIGHT_GRAY);
		txtLevel_1.setFont(new Font("PT Sans Caption", Font.BOLD, 14));
		txtLevel_1.setColumns(10);
		txtLevel_1.setBackground(Color.DARK_GRAY);
		
		JButton button = new JButton("Play Level");
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("PT Sans Caption", Font.BOLD, 13));
		button.setBackground(Color.LIGHT_GRAY);
		
		txtLevelSelection = new JTextField();
		txtLevelSelection.setForeground(Color.LIGHT_GRAY);
		txtLevelSelection.setHorizontalAlignment(SwingConstants.CENTER);
		txtLevelSelection.setFont(new Font("PT Sans Caption", Font.BOLD, 18));
		txtLevelSelection.setText("Level Selection");
		txtLevelSelection.setBackground(Color.DARK_GRAY);
		txtLevelSelection.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLevel_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPlayLevel)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtLevel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(txtLevelSelection, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(txtLevelSelection, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtLevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPlayLevel)
							.addGap(18)
							.addComponent(txtLevel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
