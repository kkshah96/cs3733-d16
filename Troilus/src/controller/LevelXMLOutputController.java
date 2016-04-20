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

import model.Level;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseSquare;

/**
 * Class to handle writing a level to file.
 * 
 * When the builder indicates they want to save a level, this controller is called, converting the Level object
 * and its properties into an XML file, identified by the level number in the file name
 * @author Dan Alfred
 *
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
		this.path = "";
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
			
			if(level.getName().equals("Lightning")) {
				LightningLevel ll = (LightningLevel) level;
				rootLevelElement.setAttribute("Time", "" + ll.getTime());
			} else if(level.getName().equals("Puzzle")) {
				PuzzleLevel pl = (PuzzleLevel) level;
				rootLevelElement.setAttribute("MaxMoves", "" + pl.getMaxMoves());
 			}

			Element bullpenElement = doc.createElement("Bullpen");
			int numPieces = level.getBullpen().getNumPieces();
			for(int i = 0; i < numPieces; i++) {
				Element pieceElement = doc.createElement("Piece");
				pieceElement.setAttribute("Number", ""+ level.getBullpen().getPiece(i).getType());
				bullpenElement.appendChild(pieceElement);
			}
			
			Element boardElement = doc.createElement("Board");
			for(int i = 0; i < 12; i++) {
				// Looping to add the 12 rows
				Element newRowElement = doc.createElement("Row");
				for(int j = 0; j < 12; j++) {
					String squareType = level.getBoard().getSquare(i, j).getType();
					Element newSquare = doc.createElement(squareType);
					
					
					if(squareType.equals("ReleaseSquare")) {
						ReleaseSquare rs = (ReleaseSquare) level.getBoard().getSquare(i, j);
						newSquare.setAttribute("Number", "" + rs.getNumber());
						newSquare.setAttribute("Color", "" + rs.getNumberColor());
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
			File levelFile = new File(path + "LevelXML" + level.getLevelNum() + ".xml");
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