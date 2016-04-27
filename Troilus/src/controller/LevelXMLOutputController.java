package controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	
	LevelXMLOutputController(Level level, String path) {
		this.level = level;
		this.path = path;
		storeLevelToFile();
	}
	
	LevelXMLOutputController(Level level) {
		this.level = level;
		this.path = "./src/levels/";
		storeLevelToFile();
	}
	
	void storeLevelToFile() {
		try {
			// Initialize a factory to create our builder
			// Create a new document from the builder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();
			
			Element rootLevelElement = doc.createElement("Level");
			rootLevelElement.setAttribute("Type", level.getName());
			rootLevelElement.setAttribute("Number", "" + level.getLevelNum());
			rootLevelElement.setAttribute("Locked", "" + level.isLocked());
			rootLevelElement.setAttribute("Progress", "" + level.getNumStars());
			
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

			Element bullpenElement = doc.createElement("Bullpen");
			//int numPieces = level.getBullpen().getNumPieces();
			Bullpen bullpen = level.getBullpen();
			for (Piece piece : bullpen.getPieces()) {
				Element pieceElement = doc.createElement("Piece");
				pieceElement.setAttribute("Number", "" + piece.getType()); //TODO: Fix first parameter
				bullpenElement.appendChild(pieceElement);
			}
			
			Element boardElement = doc.createElement("Board");
			for(int i = 0; i < 12; i++) {
				// Looping to add the 12 rows
				Element newRowElement = doc.createElement("Row");
				for(int j = 0; j < 12; j++) {
					Square s = level.getBoard().getSquare(i, j);
					String squareType = s.getType();
					Element newSquare = doc.createElement(squareType);
					newSquare.setAttribute("Valid", "" + s.isValid());
					
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
					
					newRowElement.appendChild(newSquare);
				}
				boardElement.appendChild(newRowElement);
			}
			
			rootLevelElement.appendChild(bullpenElement);
			rootLevelElement.appendChild(boardElement);
			doc.appendChild(rootLevelElement);
			
			// Create the Transformer stuff to output to XML
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			// Create the file object, and have it overwrite if it exists already
			File levelFile = new File(path, "LevelXML" + level.getLevelNum() + ".xml");
			levelFile.createNewFile();
			StreamResult result = new StreamResult(levelFile);
			trans.transform(source, result);
			
			StreamResult consoleResult = new StreamResult(System.out);
	        trans.transform(source, consoleResult);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}