package controller;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Board;
import model.Bullpen;
import model.Level;
import model.LightningLevel;
import model.LightningSquare;
import model.Palette;
import model.Piece;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.ReleaseLevel;
import model.ReleaseSquare;
import model.Square;

/**
 * Class to handle reading a level to file.
 * 
 * This class, when given a level number (ID), will attempt to open the stored file containing the level data.
 * From there, a level object will be created, populated, and returned to be viewed in Kabasuji.
 * @author Dan Alfred
 * @author Connor Weeks
 *
 */
public class LevelXMLInputController {
	/** The path of the file (adding for if we want to implement later) */
	String path;

	/** The level number (ID) we are loading */
	int levelNumber;

	/**
	 * Creates a new instance of the LevelXMLInputController, specifying a path to read from
	 * @param path Path to folder to read files from
	 * @param levelNumber Number of the level read
	 */
	LevelXMLInputController(String path, int levelNumber) {
		this.path = path;
		this.levelNumber = levelNumber;
	}

	/**
	 * Creates a new instance of the LevelXMLInputController, using default path
	 * @param levelNumber Number of the level read
	 */
	LevelXMLInputController(int levelNumber) {
		this.path = "./src/levels/";
		this.levelNumber = levelNumber;
	}

	/**
	 * Reads level from the file of the given level number. Returns a Level object matching the parameters stored in XML
	 * @return Level object
	 */
	Level readLevelFromFile() {
		// Declare references to our resulting game objects
		Level level = null;
		Bullpen bullpen = new Bullpen();
		Board board = null;

		try {
			// Create a new document from the builder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(new File(path + "LevelXML" + levelNumber + ".xml"));

			// Get the root level element, which contains level properties (type, locked, progress)
			// store to attributes
			Element rootLevelElement = doc.getDocumentElement();
			String levelType = rootLevelElement.getAttribute("Type");
			int levelNumber = Integer.parseInt(rootLevelElement.getAttribute("Number"));
			boolean levelLocked = Boolean.parseBoolean(rootLevelElement.getAttribute("Locked"));
			int levelProgress = Integer.parseInt(rootLevelElement.getAttribute("Progress"));			

			// Obtain the child nodes, and loop through them
			NodeList levelNodes = rootLevelElement.getChildNodes();
			for(int a = 0; a < levelNodes.getLength(); a++) {
				if(levelNodes.item(a).getNodeName().equals("Bullpen")) {
					// If we've reached the Bullpen node, loop through its children (the pieces in the bullpen)
					NodeList pieceList = levelNodes.item(a).getChildNodes();
					for(int i = 0; i < pieceList.getLength(); i++) {
						// Retrieve the node for each piece
						Node pieceNode = pieceList.item(i);
						
						// Parse the attributes for the piece
						NamedNodeMap pieceAttributes = pieceNode.getAttributes();
						int pieceType = 0;
						for(int j = 0; j < pieceAttributes.getLength(); j++) {
							pieceType = Integer.parseInt(pieceAttributes.item(j).getNodeValue());
						}
						
						// Create a new piece matching the one stored, and add to the bullpen
						Piece piece = PieceFactory.getPiece(pieceType);
						bullpen.addPiece(piece);
					}
				} else if(levelNodes.item(a).getNodeName().equals("Board")) {
					// If we've reached the Board node, loop through its children (square on the board)
					NodeList rowList = levelNodes.item(a).getChildNodes();
					
					// Initialize our array for squares to the max size
					Square[][] squares = new Square[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
					for(int j = 0; j < rowList.getLength(); j++) {
						// Obtain the next row from file
						Node row = rowList.item(j);
						
						// Get the listing of squares in this row and loop through
						NodeList squareList = row.getChildNodes();
						for(int k = 0; k < squareList.getLength(); k++) {
							// Get the type of square and create object
							String squareType = squareList.item(k).getNodeName();
							Square square = null;

							// get attributes and set is valid
							NamedNodeMap attributes = squareList.item(k).getAttributes();
							boolean isValid = Boolean.parseBoolean(attributes.getNamedItem("Valid").getNodeValue());
							boolean isHint = Boolean.parseBoolean(attributes.getNamedItem("Hint").getNodeValue());

							if(squareType.equals("ReleaseSquare")) {
								int number = Integer.parseInt(attributes.getNamedItem("Number").getNodeValue());
								
								// get rgb string
								String red = attributes.getNamedItem("ColorR").getNodeValue();
								String green = attributes.getNamedItem("ColorG").getNodeValue();
								String blue = attributes.getNamedItem("ColorB").getNodeValue();
								
								// get actual color from rgb string
								Color color = new Color(Integer.parseInt(red), Integer.parseInt(green), Integer.parseInt(blue));
								square = new ReleaseSquare(k, j, isValid, number, color, isHint);
							} 
							else if(squareType.equals("LightningSquare")) {
								square = new LightningSquare(k, j, isValid, isHint);
							} 
							else if(squareType.equals("PuzzleSquare")) {
								square = new PuzzleSquare(k, j, isValid, isHint);
							}

							// Assign new square to proper location
							squares[k][j] = square;
						}
					}

					// Initialize board with read-in array of squares
					board = new Board(squares);
				}
			}

			// Create the new level object based on the type property read
			if (levelType.equals("Release")) {
				level = new ReleaseLevel(levelNumber, levelLocked, bullpen, board, new Palette());
			} else if(levelType.equals("Lightning")) {
				int levelTime = Integer.parseInt(rootLevelElement.getAttribute("Time"));
				level = new LightningLevel(levelNumber, levelLocked, bullpen, board, new Palette(), levelTime);
			} else if(levelType.equals("Puzzle")) {
				int maxMoves = Integer.parseInt(rootLevelElement.getAttribute("MaxMoves"));
				level = new PuzzleLevel(levelNumber, levelLocked, bullpen, board, new Palette(), maxMoves);
			}
			
			// Restore progress
			level.setNumStars(levelProgress);
		} catch(FileNotFoundException fnfe) {
			// Catch an exception for if the file is missing
			fnfe.printStackTrace();
		} catch(Exception e) {
			// Catch any other general exceptions and print
			e.printStackTrace();
		}

		return level;
	}
}