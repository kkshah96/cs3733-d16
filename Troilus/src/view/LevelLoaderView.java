package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.NewPuzzleLevelController;
import controller.NewLightningLevelController;
import controller.NewReleaseLevelController;

import java.util.ArrayList;
import model.LevelBuilder;
import model.Level;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class LevelLoaderView extends JFrame {
	static final Font buttonFont = new Font("PT Sans Caption", Font.BOLD, 15);
	static final Color buttonColor = UIManager.getColor("Button.background");
	static final int buttonHeight = 29;
	static final int buttonWidth = 139;
	static final int buttonMargin = 10;
	
	LevelBuilder builder;
	
	/**
	 * Create the frame.
	 */
	public LevelLoaderView(LevelBuilder builder) {
		this.builder = builder;
		initialize();
	}
	
	void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panelLevels = new JPanel();
		panelLevels.setLayout(null);
		panelLevels.setForeground(Color.LIGHT_GRAY);
		panelLevels.setBorder(null);
		panelLevels.setBackground(Color.LIGHT_GRAY);
		panelLevels.setBounds(0, 103, 649, 409);
		getContentPane().add(panelLevels);
		
		JLabel lblLevels = new JLabel("Game Levels");
		lblLevels.setFont(new Font("PT Sans Caption", Font.BOLD, 15));
		lblLevels.setBounds(299, 0, 117, 16);
		panelLevels.add(lblLevels);
		
		createAllButtons(6, 17, 10, panelLevels);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.DARK_GRAY);
		panelTitle.setBounds(0, 0, 655, 48);
		getContentPane().add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblLevelLoader = new JLabel("Level Loader");
		lblLevelLoader.setBounds(238, 6, 210, 38);
		panelTitle.add(lblLevelLoader);
		lblLevelLoader.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelLoader.setForeground(Color.LIGHT_GRAY);
		lblLevelLoader.setFont(new Font("PT Sans Caption", Font.BOLD, 28));
		
		JButton btnNewPuzzleLevel = new JButton("New Puzzle Level");
		btnNewPuzzleLevel.addMouseListener(new NewPuzzleLevelController(builder, this));
		btnNewPuzzleLevel.setBounds(10, 54, 130, 37);
		getContentPane().add(btnNewPuzzleLevel);
		
		JButton btnNewLightningLevel = new JButton("New Lightning Level");
		btnNewLightningLevel.addMouseListener(new NewLightningLevelController(builder, this));
		btnNewLightningLevel.setBounds(152, 54, 146, 37);
		getContentPane().add(btnNewLightningLevel);
		
		JButton btnNewReleaseLevel = new JButton("New Release Level");
		btnNewReleaseLevel.addMouseListener(new NewReleaseLevelController(builder, this));
		btnNewReleaseLevel.setBounds(310, 54, 137, 37);
		getContentPane().add(btnNewReleaseLevel);

		setSize(new Dimension(650,550));
	}
	
	private void createAllButtons(int x, int y, int margin, JPanel panel) {
		ArrayList<Level> levels = builder.getLevels();
		int levelNum = 1;
		int currentX = x;
		int currentY = y;
		String currentName;
		JButton currentButton;
		boolean isLocked;
		
		for (Level level : levels) {
			currentName = String.format("Level %d", levelNum);
			isLocked = level.isLocked();
			currentButton = createLevelButton(isLocked, currentName, currentX, currentY);
			linkLevelButton(panel, currentButton, level);
			
			if (levelNum % 3 == 0) {
				currentY += buttonHeight + margin;
				currentX = x;
			} else {
				currentX += buttonWidth + margin;
			}
			levelNum++;
		}
	}
	
	private JButton createLevelButton(boolean isLocked, String name, int x, int y) {
		JButton levelButton = new JButton(name);
		levelButton.setBounds(x, y, buttonWidth, buttonHeight);
		
		return levelButton;
	}
	
	/** Links controller and entity in the GUI
	 * @param panel
	 * @param button
	 * @param level
	 */
	private void linkLevelButton(JPanel panel, JButton button, Level level) {
		//TODO: Implement this
		panel.add(button);
		//builder.setActiveLevel(level);
		//button.addMouseListener(new EditLevelController(this, builder));
	}
}