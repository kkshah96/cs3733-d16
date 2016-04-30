package controller;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import model.Board;
import model.Bullpen;
import model.Level;
import model.LightningLevel;
import model.Piece;
import model.PuzzleLevel;
import model.ReleaseSquare;
import model.Square;

/**
 * Class to handle writing a level to file.
 * 
 * When the builder indicates they want to save a level, this controller is called, converting the Level object
 * and its properties into an XML file, identified by the level number in the file name
 * @author Dan Alfred
 * @author Connor Weeks
 */

public class LevelXMLOutputController {
	/** A placeholder for the level object we will be saving to */
	Level level;
	
	/** The path our file will be saved in (could be used later) */
	String path;
	
	/**
	 * Creates a new instance of the LevelXMLOutputController, with a specified path to write to
	 * @param level Level object to store to file
	 * @param path Path to folder to store file in
	 */
	LevelXMLOutputController(Level level, String path) {
		this.level = level;
		this.path = path;
	}
	
	/**
	 * Creates a new instance of the LevelXMLOutputController, using the default path
	 * @param level Level object to store to file
	 */
	LevelXMLOutputController(Level level) {
		this.level = level;
		this.path = "./src/levels/";
	}
	
	/**
	 * Updates the number of stars for the current level. This method is used in
	 * the game, since the contents of the bullpen are not overwritten.
	 */
	void saveLevelStars() {
		try {
			// get file path from name and number
			String filePath = path + "LevelXML" + level.getLevelNum() + ".xml";
			
			// initialize
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(filePath);

			// Get the root element
			Node levelNode = document.getFirstChild();
			
			// get the stars (progress) element
			Node progressNode = levelNode.getAttributes().getNamedItem("Progress");
			
			int initialStars = Integer.parseInt(progressNode.getNodeValue());
			
			// return if the current number of stars is less than the original number
			if (level.getNumStars() <= initialStars) {
				return;
			}
			
			// set value to new value
			progressNode.setNodeValue("" + level.getNumStars());
			System.out.println("NUmber of stars: " + level.getNumStars());
			
			// write back to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filePath));
			transformer.transform(source, result);

			
		}
		catch(IOException ioe) {
			// Catch an IO exception (permissions error)
			System.err.println("File cannot be overwritten!");
			ioe.printStackTrace();
		} 
		catch(Exception e) {
			// Catch a generalized exception and print trace
			e.printStackTrace();
		}
	}
	/**
	 * Stores the passed-in level to XML format
	 */
	void storeLevelToFile() {
		try {
			// Initialize a factory to create our builder
			// Create a new document from the builder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();
			
			// Create the root element from the level structure and store attributes
			Element rootLevelElement = doc.createElement("Level");
			rootLevelElement.setAttribute("Type", level.getName());
			rootLevelElement.setAttribute("Number", "" + level.getLevelNum());
			rootLevelElement.setAttribute("Locked", "" + level.isLocked());
			rootLevelElement.setAttribute("Progress", "" + level.getNumStars());
			
			// Store any level-specific attributes based on type
			if (level.getName().equals("Lightning")) {
				LightningLevel lightning = (LightningLevel)level;
				System.out.println("saving time: " + lightning.getTime());
				rootLevelElement.setAttribute("Time", "" + lightning.getTime());
			} 
			else if (level.getName().equals("Puzzle")) {
				PuzzleLevel puzzle = (PuzzleLevel)level;
				rootLevelElement.setAttribute("MaxMoves", "" + puzzle.getMaxMoves());
 			}
			else if (level.getName().equals("Release")) {
				System.out.println("Saving relaease level");
			}

			// Create child element for bullpen
			Element bullpenElement = doc.createElement("Bullpen");
			Bullpen bullpen = level.getBullpen();
			
			// Create child elements in bullpen representing each piece present
			for (Piece piece : bullpen.getPieces()) {
				Element pieceElement = doc.createElement("Piece");
				pieceElement.setAttribute("Number", "" + piece.getType()); //TODO: Fix first parameter
				bullpenElement.appendChild(pieceElement);
			}
			
			// Create child element for board, and loop through each square in board
			Element boardElement = doc.createElement("Board");
			for(int i = 0; i < Board.BOARD_HEIGHT; i++) {
				
				// create element for each row
				Element newRowElement = doc.createElement("Row");
				
				for(int j = 0; j < Board.BOARD_WIDTH; j++) {
					
					// add squares to row
					Square s = level.getBoard().getSquare(j, i);
					String squareType = s.getType();
					Element newSquare = doc.createElement(squareType);
					
					// set hint and valid attributes
					newSquare.setAttribute("Valid", "" + s.isValid());
					newSquare.setAttribute("Hint", "" + s.isHint());
					
					// If we reach a release square, set special attributes
					if(squareType.equals("ReleaseSquare")) {
						ReleaseSquare rs = (ReleaseSquare)s;
						newSquare.setAttribute("Number", "" + rs.getNumber());
						int red =0;
						int green = 0;
						int blue = 0;
						if (rs.getNumberColor() != null) {
							red = rs.getNumberColor().getRed();
							green = rs.getNumberColor().getGreen();
							blue = rs.getNumberColor().getBlue();
							
						}

						// add separate fields for RGB
						newSquare.setAttribute("ColorR", "" + red);
						newSquare.setAttribute("ColorG", "" + green);
						newSquare.setAttribute("ColorB", "" + blue);
						
					}
					
					// Add the square to the row element
					newRowElement.appendChild(newSquare);
				}
				
				// Add the row to the board element
				boardElement.appendChild(newRowElement);
			}
			
			// Add the board and bullpen to the level element, and add the level element to the document
			rootLevelElement.appendChild(bullpenElement);
			rootLevelElement.appendChild(boardElement);
			doc.appendChild(rootLevelElement);
			
			// Create the Transformer converters to output to XML
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			// Create the file object, and have it overwrite if it exists already
			File levelFile = new File(path, "LevelXML" + level.getLevelNum() + ".xml");
			levelFile.createNewFile();
			StreamResult result = new StreamResult(levelFile);
			trans.transform(source, result);
			
			//StreamResult consoleResult = new StreamResult(System.out);
	        //trans.transform(source, consoleResult);
		} catch(Exception e) {
			// Catch any exceptions that occur and print trace
			e.printStackTrace();
		}
	}	
}